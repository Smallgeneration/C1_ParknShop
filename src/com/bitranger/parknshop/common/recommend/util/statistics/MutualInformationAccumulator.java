/*******************************************************************************
 * Copyright (c) 2014 BitRangers (Team C1).
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * 
 * Contributors:
 *      BitRangers (Team C1) - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.common.recommend.util.statistics;

import com.google.common.base.Preconditions;

import java.util.Arrays;

/**
 * Accumulate mutual information over two discrete variables.  Slightly incorrectly,
 * this reports 0 as the entropy and mutual information of empty sets.
 *
 * @author <a href="http://www.grouplens.org">GroupLens Research</a>
 */
public class MutualInformationAccumulator {
    private static final double RECIP_LOG_2 = 1 / Math.log(2);

    private int[][] joint;
    private int[] tbl1;
    private int[] tbl2;
    private int total;

    /**
     * Construct a new accumulator.
     * @param n1 The number of discrete values of the first variable.
     * @param n2 The number of discrete values of the second variable.
     */
    public MutualInformationAccumulator(int n1, int n2) {
        joint = new int[n1][n2];
        tbl1 = new int[n1];
        tbl2 = new int[n2];
        total = 0;
    }

    /**
     * Construct a new accumulator with equal-sized event spaces.
     * @param n The number of discrete values of each variable.
     */
    public MutualInformationAccumulator(int n) {
        this(n, n);
    }

    /**
     * Count an occurrence.
     * @param v1 The value of the first variable.
     * @param v2 The value of the second variable.
     */
    public void count(int v1, int v2) {
        Preconditions.checkArgument(v1 >= 0 && v1 < tbl1.length,
                                    "variable 1 out of bounds");
        Preconditions.checkArgument(v2 >= 0 && v2 < tbl2.length,
                                    "variable 2 out of bounds");
        // count a single occurrance of this value
        tbl1[v1] += 1;
        tbl2[v2] += 1;
        joint[v1][v2] += 1;
        total += 1;
    }

    /**
     * Get the mutual information.
     *
     * @return The mutual information accumulated so far.
     */
    public double getMutualInformation() {
        if (total == 0) {
            return 0;
        }

        double mi = 0;
        final double nlog = Math.log(total);
        for (int i = tbl1.length - 1; i >= 0; i--) {
            final double niLog = Math.log(tbl1[i]);
            for (int j = tbl2.length - 1; j >= 0; j--) {
                final int nij = joint[i][j];
                if (nij != 0) {
                    final double njLog = Math.log(tbl2[j]);
                    double lg = Math.log(nij) - niLog - njLog + nlog;
                    lg *= RECIP_LOG_2;
                    mi += lg * nij;
                }
            }
        }
        return mi / total;
    }

    /**
     * Compute the entropy of an array of counts.
     * @param counts The counts of each value.
     * @param n The total number of events.
     */
    private double entropy(int[] counts, int n) {
        if (n == 0) {
            return 0;
        }
        double acc = 0;
        final double logN = Math.log(n);
        for (int i = counts.length - 1; i >= 0; i--) {
            final int m = counts[i];
            if (m != 0) {
                final double logP = Math.log(m) - logN;
                acc -= m * logP;
            }
        }
        return (acc * RECIP_LOG_2) / n;
    }

    /**
     * Get the entropy of the first variable.
     *
     * @return The accumulated entropy of the first variable.
     */
    public double getV1Entropy() {
        return entropy(tbl1, total);
    }

    /**
     * Get the entropy of the second variable.
     *
     * @return The accumulated entropy of the second variable.
     */
    public double getV2Entropy() {
        return entropy(tbl2, total);
    }

    /**
     * Get the number of events.
     *
     * @return The number of events accumulated.
     */
    public int getCount() {
        return total;
    }

    /**
     * Reset to start accumulating again.
     */
    public void reset() {
        total = 0;
        for (int i = tbl1.length - 1; i >= 0; i--) {
            Arrays.fill(joint[i], 0);
        }
        Arrays.fill(tbl1, 0);
        Arrays.fill(tbl2, 0);
    }
}

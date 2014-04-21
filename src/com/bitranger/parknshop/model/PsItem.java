/*******************************************************************************
 * Copyright (c) 2014 BitRanger.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Lesser Public License v2.1
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/old-licenses/gpl-2.0.html
 * 
 * Contributors:
 *     BitRanger - initial API and implementation
 ******************************************************************************/
package com.bitranger.parknshop.model;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * PsItem entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_item", catalog = "c1_parknshop", uniqueConstraints = {
		@UniqueConstraint(columnNames = "count_purchase"),
		@UniqueConstraint(columnNames = "count_click"),
		@UniqueConstraint(columnNames = "count_favourite") })
public class PsItem implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsShop psShop;
	private PsCategory psCategory;
	private String name;
	private String introduction;
	private Double price;
	private String extra1;
	private String extra2;
	private Timestamp timeCreated;
	private Integer countPurchase;
	private Integer countFavourite;
	private Integer countClick;
	private Double vote;
	private Set<PsCustomer> psCustomers = new HashSet<PsCustomer>(0);
	private Set<PsComment> psComments = new HashSet<PsComment>(0);
	private Set<PsTag> psTags = new HashSet<PsTag>(0);
	private PsItemInfo psItemInfo;
	private Set<CartCustomerItem> cartCustomerItems = new HashSet<CartCustomerItem>(
			0);
	private Set<ROrderItem> ROrderItems = new HashSet<ROrderItem>(0);

	// Constructors

	/** default constructor */
	public PsItem() {
	}

	/** minimal constructor */
	public PsItem(PsShop psShop, PsCategory psCategory, String name,
			Double price, Timestamp timeCreated, Integer countPurchase,
			Integer countFavourite, Integer countClick, Double vote) {
		this.psShop = psShop;
		this.psCategory = psCategory;
		this.name = name;
		this.price = price;
		this.timeCreated = timeCreated;
		this.countPurchase = countPurchase;
		this.countFavourite = countFavourite;
		this.countClick = countClick;
		this.vote = vote;
	}

	/** full constructor */
	public PsItem(PsShop psShop, PsCategory psCategory, String name,
			String introduction, Double price, String extra1, String extra2,
			Timestamp timeCreated, Integer countPurchase,
			Integer countFavourite, Integer countClick, Double vote,
			Set<PsCustomer> psCustomers, Set<PsComment> psComments,
			Set<PsTag> psTags, PsItemInfo psItemInfo,
			Set<CartCustomerItem> cartCustomerItems, Set<ROrderItem> ROrderItems) {
		this.psShop = psShop;
		this.psCategory = psCategory;
		this.name = name;
		this.introduction = introduction;
		this.price = price;
		this.extra1 = extra1;
		this.extra2 = extra2;
		this.timeCreated = timeCreated;
		this.countPurchase = countPurchase;
		this.countFavourite = countFavourite;
		this.countClick = countClick;
		this.vote = vote;
		this.psCustomers = psCustomers;
		this.psComments = psComments;
		this.psTags = psTags;
		this.psItemInfo = psItemInfo;
		this.cartCustomerItems = cartCustomerItems;
		this.ROrderItems = ROrderItems;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_shop", nullable = false)
	public PsShop getPsShop() {
		return this.psShop;
	}

	public void setPsShop(PsShop psShop) {
		this.psShop = psShop;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_category", nullable = false)
	public PsCategory getPsCategory() {
		return this.psCategory;
	}

	public void setPsCategory(PsCategory psCategory) {
		this.psCategory = psCategory;
	}

	@Column(name = "name", nullable = false, length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "introduction", length = 500)
	public String getIntroduction() {
		return this.introduction;
	}

	public void setIntroduction(String introduction) {
		this.introduction = introduction;
	}

	@Column(name = "price", nullable = false, precision = 9)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	@Column(name = "extra_1", length = 120)
	public String getExtra1() {
		return this.extra1;
	}

	public void setExtra1(String extra1) {
		this.extra1 = extra1;
	}

	@Column(name = "extra_2", length = 120)
	public String getExtra2() {
		return this.extra2;
	}

	public void setExtra2(String extra2) {
		this.extra2 = extra2;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@Column(name = "count_purchase", unique = true, nullable = false)
	public Integer getCountPurchase() {
		return this.countPurchase;
	}

	public void setCountPurchase(Integer countPurchase) {
		this.countPurchase = countPurchase;
	}

	@Column(name = "count_favourite", unique = true, nullable = false)
	public Integer getCountFavourite() {
		return this.countFavourite;
	}

	public void setCountFavourite(Integer countFavourite) {
		this.countFavourite = countFavourite;
	}

	@Column(name = "count_click", unique = true, nullable = false)
	public Integer getCountClick() {
		return this.countClick;
	}

	public void setCountClick(Integer countClick) {
		this.countClick = countClick;
	}

	@Column(name = "vote", nullable = false, precision = 22, scale = 0)
	public Double getVote() {
		return this.vote;
	}

	public void setVote(Double vote) {
		this.vote = vote;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinTable(name = "customer_favourite_item", catalog = "c1_parknshop", joinColumns = { @JoinColumn(name = "id_item", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "id_customer", nullable = false, updatable = false) })
	public Set<PsCustomer> getPsCustomers() {
		return this.psCustomers;
	}

	public void setPsCustomers(Set<PsCustomer> psCustomers) {
		this.psCustomers = psCustomers;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psItem")
	public Set<PsComment> getPsComments() {
		return this.psComments;
	}

	public void setPsComments(Set<PsComment> psComments) {
		this.psComments = psComments;
	}

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psItems")
	public Set<PsTag> getPsTags() {
		return this.psTags;
	}

	public void setPsTags(Set<PsTag> psTags) {
		this.psTags = psTags;
	}

	@OneToOne(fetch = FetchType.LAZY, mappedBy = "psItem")
	public PsItemInfo getPsItemInfo() {
		return this.psItemInfo;
	}

	public void setPsItemInfo(PsItemInfo psItemInfo) {
		this.psItemInfo = psItemInfo;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psItem")
	public Set<CartCustomerItem> getCartCustomerItems() {
		return this.cartCustomerItems;
	}

	public void setCartCustomerItems(Set<CartCustomerItem> cartCustomerItems) {
		this.cartCustomerItems = cartCustomerItems;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psItem")
	public Set<ROrderItem> getROrderItems() {
		return this.ROrderItems;
	}

	public void setROrderItems(Set<ROrderItem> ROrderItems) {
		this.ROrderItems = ROrderItems;
	}

}
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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * PsOrder entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_order", catalog = "c1_parknshop")
public class PsOrder implements java.io.Serializable {

	// Fields

	private Integer id;
	private PsCustomer psCustomer;
	private Integer idShop;
	private Short status;
	private String trackingNumber;
	private String address;
	private String postalCode;
	private String nameRecipient;
	private String phoneRecipient;
	private Double priceTotal;
	private Timestamp timeCreated;
	private Set<ROrderItem> ROrderItems = new HashSet<ROrderItem>(0);

	// Constructors

	/** default constructor */
	public PsOrder() {
	}

	/** minimal constructor */
	public PsOrder(PsCustomer psCustomer, Integer idShop, Short status,
			Double priceTotal, Timestamp timeCreated) {
		this.psCustomer = psCustomer;
		this.idShop = idShop;
		this.status = status;
		this.priceTotal = priceTotal;
		this.timeCreated = timeCreated;
	}

	/** full constructor */
	public PsOrder(PsCustomer psCustomer, Integer idShop, Short status,
			String trackingNumber, String address, String postalCode,
			String nameRecipient, String phoneRecipient, Double priceTotal,
			Timestamp timeCreated, Set<ROrderItem> ROrderItems) {
		this.psCustomer = psCustomer;
		this.idShop = idShop;
		this.status = status;
		this.trackingNumber = trackingNumber;
		this.address = address;
		this.postalCode = postalCode;
		this.nameRecipient = nameRecipient;
		this.phoneRecipient = phoneRecipient;
		this.priceTotal = priceTotal;
		this.timeCreated = timeCreated;
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
	@JoinColumn(name = "id_customer", nullable = false)
	public PsCustomer getPsCustomer() {
		return this.psCustomer;
	}

	public void setPsCustomer(PsCustomer psCustomer) {
		this.psCustomer = psCustomer;
	}

	@Column(name = "id_shop", nullable = false)
	public Integer getIdShop() {
		return this.idShop;
	}

	public void setIdShop(Integer idShop) {
		this.idShop = idShop;
	}

	@Column(name = "status", nullable = false)
	public Short getStatus() {
		return this.status;
	}

	public void setStatus(Short status) {
		this.status = status;
	}

	@Column(name = "tracking_number", length = 45)
	public String getTrackingNumber() {
		return this.trackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}

	@Column(name = "address", length = 200)
	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Column(name = "postal_code", length = 45)
	public String getPostalCode() {
		return this.postalCode;
	}

	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

	@Column(name = "name_recipient", length = 45)
	public String getNameRecipient() {
		return this.nameRecipient;
	}

	public void setNameRecipient(String nameRecipient) {
		this.nameRecipient = nameRecipient;
	}

	@Column(name = "phone_recipient", length = 45)
	public String getPhoneRecipient() {
		return this.phoneRecipient;
	}

	public void setPhoneRecipient(String phoneRecipient) {
		this.phoneRecipient = phoneRecipient;
	}

	@Column(name = "price_total", nullable = false, precision = 15)
	public Double getPriceTotal() {
		return this.priceTotal;
	}

	public void setPriceTotal(Double priceTotal) {
		this.priceTotal = priceTotal;
	}

	@Column(name = "time_created", nullable = false, length = 19)
	public Timestamp getTimeCreated() {
		return this.timeCreated;
	}

	public void setTimeCreated(Timestamp timeCreated) {
		this.timeCreated = timeCreated;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "psOrder")
	public Set<ROrderItem> getROrderItems() {
		return this.ROrderItems;
	}

	public void setROrderItems(Set<ROrderItem> ROrderItems) {
		this.ROrderItems = ROrderItems;
	}

}

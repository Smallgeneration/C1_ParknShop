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
package com.bitranger.parknshop.common.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * PsItemInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "ps_item_info", catalog = "c1_parknshop")
public class PsItemInfo implements java.io.Serializable {

	// Fields

	private Integer idItem;
	private PsItem psItem;
	
	private String description;
	private String urlPic;

	// Constructors

	/** default constructor */
	public PsItemInfo() {
	}

	/** minimal constructor */
	public PsItemInfo(Integer idItem, PsItem psItem) {
		this.idItem = idItem;
		this.psItem = psItem;
	}

	/** full constructor */
	public PsItemInfo(Integer idItem, PsItem psItem, String description,
			String urlPic) {
		this.idItem = idItem;
		this.psItem = psItem;
		this.description = description;
		this.urlPic = urlPic;
	}

	// Property accessors
	@Id
	@Column(name = "id_item", unique = true, nullable = false)
	public Integer getIdItem() {
		return this.idItem;
	}

	public void setIdItem(Integer idItem) {
		this.idItem = idItem;
	}

	@OneToOne(fetch = FetchType.EAGER)
	@PrimaryKeyJoinColumn
	public PsItem getPsItem() {
		return this.psItem;
	}

	public void setPsItem(PsItem psItem) {
		this.psItem = psItem;
	}

	@Column(name = "description", length = 200)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "url_pic", length = 100)
	public String getUrlPic() {
		return this.urlPic;
	}

	public void setUrlPic(String urlPic) {
		this.urlPic = urlPic;
	}

}

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
package com.bitranger.parknshop.common.dao;

import java.util.List;

import com.bitranger.parknshop.common.model.PsItemInfo;

public interface IPsItemInfoDAO {

	public abstract void update(PsItemInfo detachedInstance);
	
	public abstract void save(PsItemInfo transientInstance);

	public abstract void delete(PsItemInfo persistentInstance);

	public abstract List<PsItemInfo> findByItemId(java.lang.Integer id);

}
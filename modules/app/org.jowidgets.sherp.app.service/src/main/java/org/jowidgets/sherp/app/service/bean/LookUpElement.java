/*
 * Copyright (c) 2012, grossmann
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 * * Redistributions of source code must retain the above copyright
 *   notice, this list of conditions and the following disclaimer.
 * * Redistributions in binary form must reproduce the above copyright
 *   notice, this list of conditions and the following disclaimer in the
 *   documentation and/or other materials provided with the distribution.
 * * Neither the name of the jo-widgets.org nor the
 *   names of its contributors may be used to endorse or promote products
 *   derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS"
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE
 * IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE
 * ARE DISCLAIMED. IN NO EVENT SHALL jo-widgets.org BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR
 * SERVICES; LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER
 * CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT
 * LIABILITY, OR TORT(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY
 * OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH
 * DAMAGE.
 */
package org.jowidgets.sherp.app.service.bean;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import org.hibernate.annotations.Index;
import org.jowidgets.sherp.app.common.bean.ILookUpElement;
import org.jowidgets.util.NullCompatibleEquivalence;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"key"}))
public class LookUpElement extends Bean implements ILookUpElement {

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LOOK_UP_ID", nullable = false, insertable = false, updatable = false)
	private LookUp lookUp;

	@Column(name = "LOOK_UP_ID", nullable = false)
	private Long lookUpId;

	@Basic
	@Index(name = "KeyIndex")
	private String key;

	@Basic
	private String label;

	@Basic
	private String labelLong;

	@Basic
	private String description;

	@Basic
	private Boolean isValid;

	@Override
	public Long getLookUpId() {
		return lookUpId;
	}

	@Override
	public void setLookUpId(final Long id) {
		this.lookUpId = id;
		if (this.lookUp != null && !NullCompatibleEquivalence.equals(this.lookUp.getId(), lookUpId)) {
			lookUp = null;
		}
	}

	@Override
	public String getKey() {
		return key;
	}

	@Override
	public void setKey(final String key) {
		this.key = key;
	}

	@Override
	public String getLabel() {
		return label;
	}

	@Override
	public void setLabel(final String label) {
		this.label = label;
	}

	@Override
	public String getLabelLong() {
		return labelLong;
	}

	@Override
	public void setLabelLong(final String labelLong) {
		this.labelLong = labelLong;
	}

	@Override
	public String getDescription() {
		return description;
	}

	@Override
	public void setDescription(final String description) {
		this.description = description;
	}

	@Override
	public Boolean getIsValid() {
		return isValid;
	}

	@Override
	public void setIsValid(final Boolean isValid) {
		this.isValid = isValid;
	}

}

/*
 * Copyright (c) 2014, grossmann
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

package org.jowidgets.sherp.app.service.descriptor;

import org.jowidgets.cap.common.api.bean.IBeanPropertyBluePrint;
import org.jowidgets.cap.common.api.sort.Sort;
import org.jowidgets.i18n.api.IMessage;
import org.jowidgets.sherp.app.common.bean.ICommodity;
import org.jowidgets.sherp.app.common.i18n.SecondHandEntityMessages;
import org.jowidgets.util.Assert;

public final class CommodityDtoDescriptorBuilder extends AbstractDtoDescriptorBuilder {

	public CommodityDtoDescriptorBuilder() {
		this(getMessage("commodity"), getMessage("commidities"));
	}

	public CommodityDtoDescriptorBuilder(final IMessage labelSingular, final IMessage labelPlural) {
		super(ICommodity.class);

		setLabelSingular(labelSingular);
		setLabelPlural(labelPlural);
		setDefaultSorting(Sort.create(ICommodity.BARCODE_PROPERTY));

		setRenderingPattern("$" + ICommodity.NAME_PROPERTY + "$ ($" + ICommodity.BARCODE_PROPERTY + "$)");

		addIdProperty();

		IBeanPropertyBluePrint propertyBp = addProperty(ICommodity.BARCODE_PROPERTY);
		propertyBp.setLabel(getMessage("barcode.label"));

		propertyBp = addProperty(ICommodity.NAME_PROPERTY);
		propertyBp.setLabel(getMessage("name.label"));

		addVersionProperty();
	}

	private static IMessage getMessage(final String keySuffix) {
		Assert.paramNotEmpty(keySuffix, "keySuffix");
		return SecondHandEntityMessages.getMessage("CommodityDtoDescriptorBuilder." + keySuffix);
	}
}

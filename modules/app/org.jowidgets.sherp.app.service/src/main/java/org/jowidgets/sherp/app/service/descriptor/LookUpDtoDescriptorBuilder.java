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

package org.jowidgets.sherp.app.service.descriptor;

import org.jowidgets.cap.common.api.bean.IBeanPropertyBluePrint;
import org.jowidgets.cap.common.api.sort.Sort;
import org.jowidgets.i18n.api.IMessage;
import org.jowidgets.sherp.app.common.bean.ILookUp;
import org.jowidgets.sherp.app.common.dto.LookUpDisplayFormat;
import org.jowidgets.sherp.app.common.i18n.SecondHandEntityMessages;
import org.jowidgets.util.Assert;

public class LookUpDtoDescriptorBuilder extends AbstractDtoDescriptorBuilder {

	public LookUpDtoDescriptorBuilder() {
		this("label.singular", "label.plural");
	}

	public LookUpDtoDescriptorBuilder(final String labelSingularKey, final String labelPluralKey) {
		super(ILookUp.class);

		setLabelSingular(getMessage(labelSingularKey));
		setLabelPlural(getMessage(labelPluralKey));
		setRenderingPattern("$" + ILookUp.LABEL_PROPERTY + "$");

		setDefaultSorting(Sort.create(ILookUp.NAME_PROPERTY));

		addIdProperty();

		IBeanPropertyBluePrint propertyBp = addProperty(ILookUp.NAME_PROPERTY);
		propertyBp.setLabel(getMessage("name.label"));
		propertyBp.setDescription(getMessage("name.description"));
		propertyBp.setMandatory(true);

		propertyBp = addProperty(ILookUp.LABEL_PROPERTY);
		propertyBp.setLabel(getMessage("label.label"));
		propertyBp.setDescription(getMessage("label.description"));
		propertyBp.setMandatory(true);

		propertyBp = addProperty(ILookUp.HAS_NULL_VALUE_PROPERTY);
		propertyBp.setLabel(getMessage("hasNullValue.label"));
		propertyBp.setDescription(getMessage("hasNullValue.description"));
		propertyBp.setDefaultValue(Boolean.TRUE);
		propertyBp.setMandatory(true);

		propertyBp = addProperty(ILookUp.DEFAULT_PROPERTY_TYPE_PROPERTY);
		propertyBp.setLabel(getMessage("defaultDisplayFormat.label"));
		propertyBp.setDescription(getMessage("defaultDisplayFormat.description"));
		propertyBp.setDefaultValue(LookUpDisplayFormat.LONG);
		propertyBp.setMandatory(true);

		addVersionProperty();
	}

	private static IMessage getMessage(final String keySuffix) {
		Assert.paramNotEmpty(keySuffix, "keySuffix");
		return SecondHandEntityMessages.getMessage("LookUpDtoDescriptorBuilder." + keySuffix);
	}
}

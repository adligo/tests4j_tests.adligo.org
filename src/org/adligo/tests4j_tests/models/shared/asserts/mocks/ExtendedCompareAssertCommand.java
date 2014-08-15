package org.adligo.tests4j_tests.models.shared.asserts.mocks;

import org.adligo.tests4j.models.shared.asserts.AbstractCompareAssertCommand;
import org.adligo.tests4j.models.shared.asserts.common.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.common.I_CompareAssertionData;

public class ExtendedCompareAssertCommand extends AbstractCompareAssertCommand {

	public ExtendedCompareAssertCommand(
			String failureMessage, I_CompareAssertionData<?> pData) {
		super( failureMessage, pData);
	}

	@Override
	public boolean evaluate() {
		if ((boolean) super.getActual()) {
			if ((boolean) super.getExpected()) {
				return true;
			}
		}
		return false;
	}


}

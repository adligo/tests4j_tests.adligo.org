package org.adligo.tests4j_tests.models.shared.asserts.mocks;

import org.adligo.tests4j.models.shared.asserts.AbstractCompareAssertCommand;
import org.adligo.tests4j.models.shared.asserts.AssertType;
import org.adligo.tests4j.models.shared.asserts.CompareAssertionData;
import org.adligo.tests4j.models.shared.asserts.I_AssertionData;
import org.adligo.tests4j.models.shared.asserts.I_CompareAssertionData;

public class ExtendedCompareAssertCommand extends AbstractCompareAssertCommand {

	public ExtendedCompareAssertCommand(AssertType pType,
			String failureMessage, I_CompareAssertionData<?> pData) {
		super(pType, failureMessage, pData);
	}

	@Override
	public boolean evaluate() {
		I_AssertionData data = super.getData();
		if ((boolean) data.getData(CompareAssertionData.ACTUAL)) {
			if ((boolean) data.getData(CompareAssertionData.EXPECTED)) {
				return true;
			}
		}
		return false;
	}

}
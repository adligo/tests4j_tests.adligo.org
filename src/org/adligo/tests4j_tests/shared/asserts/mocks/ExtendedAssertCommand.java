package org.adligo.tests4j_tests.shared.asserts.mocks;

import org.adligo.tests4j.shared.asserts.AbstractAssertCommand;
import org.adligo.tests4j.shared.asserts.common.I_AssertType;
import org.adligo.tests4j.shared.asserts.common.I_AssertionData;

public class ExtendedAssertCommand extends AbstractAssertCommand {

	public ExtendedAssertCommand(I_AssertType pType, String pFailureMessage) {
		super(pType, pFailureMessage);
	}

	@Override
	public I_AssertionData getData() {
		return null;
	}

}

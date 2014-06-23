package org.adligo.tests4j_tests.models.shared.asserts.mocks;

import org.adligo.tests4j.models.shared.asserts.AbstractAssertCommand;
import org.adligo.tests4j.models.shared.asserts.I_AssertType;
import org.adligo.tests4j.models.shared.asserts.I_AssertionData;

public class ExtendedAssertCommand extends AbstractAssertCommand {

	public ExtendedAssertCommand(I_AssertType pType, String pFailureMessage) {
		super(pType, pFailureMessage);
	}

	@Override
	public I_AssertionData getData() {
		return null;
	}

}
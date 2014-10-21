package org.adligo.tests4j_tests.models.shared.association;

import java.util.List;

import org.adligo.tests4j.models.shared.association.I_ClassParents;
import org.adligo.tests4j.models.shared.association.I_ClassParentsLocal;

public class ClassParentsLocalNullMock implements I_ClassParentsLocal {

	@Override
	public List<I_ClassParents> getParents() {
		return null;
	}

	@Override
	public List<String> getParentNames() {
		return null;
	}

	@Override
	public String getName() {
		return null;
	}

	@Override
	public int compareTo(Object o) {
		return 0;
	}

	@Override
	public Class<?> getTarget() {
		return null;
	}

	@Override
	public List<I_ClassParentsLocal> getParentsLocal() {
		return null;
	}

}

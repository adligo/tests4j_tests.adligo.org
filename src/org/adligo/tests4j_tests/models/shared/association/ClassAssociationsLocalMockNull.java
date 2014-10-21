package org.adligo.tests4j_tests.models.shared.association;

import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.association.I_ClassAssociationsLocal;
import org.adligo.tests4j.models.shared.association.I_ClassParents;
import org.adligo.tests4j.models.shared.association.I_ClassParentsLocal;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAlias;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAliasLocal;
import org.adligo.tests4j.shared.asserts.reference.I_ClassAttributes;

public class ClassAssociationsLocalMockNull implements I_ClassAssociationsLocal {

	@Override
	public boolean hasCircularDependencies() {
		return false;
	}

	@Override
	public Set<I_ClassAlias> getCircularDependencies() {
		return null;
	}

	@Override
	public Set<String> getCircularDependenciesNames() {
		return null;
	}

	@Override
	public boolean hasDependencies() {
		return false;
	}

	@Override
	public Set<I_ClassAlias> getDependencies() {
		return null;
	}

	@Override
	public Set<String> getDependencyNames() {
		return null;
	}

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
	public List<I_ClassParentsLocal> getParentsLocal() {
		return null;
	}

	@Override
	public Class<?> getTarget() {
		return null;
	}

	@Override
	public Set<I_ClassAliasLocal> getCircularDependenciesLocal() {
		return null;
	}

	@Override
	public Set<I_ClassParentsLocal> getDependenciesLocal() {
		return null;
	}

	@Override
	public boolean hasReferences() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<I_ClassAttributes> getReferences() {
		// TODO Auto-generated method stub
		return null;
	}

}

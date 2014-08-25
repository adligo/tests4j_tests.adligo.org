package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAlias;
import org.adligo.tests4j.models.shared.dependency.I_ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassDependenciesLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;

public class ClassDependenciesLocalMockNull implements I_ClassDependenciesLocal {

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

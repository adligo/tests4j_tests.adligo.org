package org.adligo.tests4j_tests.models.shared.dependency;

import java.util.List;
import java.util.Set;

import org.adligo.tests4j.models.shared.dependency.I_ClassAlias;
import org.adligo.tests4j.models.shared.dependency.I_ClassAliasLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassParents;
import org.adligo.tests4j.models.shared.dependency.I_ClassParentsLocal;
import org.adligo.tests4j.models.shared.dependency.I_ClassReferencesLocal;
import org.adligo.tests4j.models.shared.xml.I_XML_Builder;

public class ClassReferencesLocalMockNull implements I_ClassReferencesLocal {

	@Override
	public boolean hasCircularReferences() {
		return false;
	}

	@Override
	public Set<I_ClassAlias> getCircularReferences() {
		return null;
	}

	@Override
	public Set<String> getCircularReferenceNames() {
		return null;
	}

	@Override
	public boolean hasReferences() {
		return false;
	}

	@Override
	public Set<I_ClassAlias> getReferences() {
		return null;
	}

	@Override
	public Set<String> getReferenceNames() {
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
	public void toXml(I_XML_Builder builder) {
		
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
	public Set<I_ClassAliasLocal> getCircularReferencesLocal() {
		return null;
	}

	@Override
	public Set<I_ClassParentsLocal> getReferencesLocal() {
		return null;
	}

}

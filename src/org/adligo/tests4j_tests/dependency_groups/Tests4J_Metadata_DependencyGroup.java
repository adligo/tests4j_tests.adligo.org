package org.adligo.tests4j_tests.dependency_groups;

import java.util.HashSet;
import java.util.Set;

import org.adligo.tests4j.models.shared.metadata.I_MachineMetadata;
import org.adligo.tests4j.models.shared.metadata.I_SourceInfoMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TestMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.I_TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.I_UseCaseMetadata;
import org.adligo.tests4j.models.shared.metadata.MachineMetadata;
import org.adligo.tests4j.models.shared.metadata.MachineMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.SourceInfoMetadata;
import org.adligo.tests4j.models.shared.metadata.SourceInfoMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TestMetadata;
import org.adligo.tests4j.models.shared.metadata.TestMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadata;
import org.adligo.tests4j.models.shared.metadata.TrialRunMetadataMutant;
import org.adligo.tests4j.models.shared.metadata.UseCaseMetadata;

public class Tests4J_Metadata_DependencyGroup extends Tests4J_DependencyGroup {
	public static final Tests4J_Metadata_DependencyGroup INSTANCE = new Tests4J_Metadata_DependencyGroup();
	
	private Tests4J_Metadata_DependencyGroup() {
		Set<String> names = new HashSet<String>();
		add(names, I_MachineMetadata.class);
		add(names, I_SourceInfoMetadata.class);
		add(names, I_TestMetadata.class);
		add(names, I_TrialMetadata.class);
		add(names, I_TrialRunMetadata.class);
		add(names, I_UseCaseMetadata.class);
		
		
		add(names, MachineMetadata.class);
		add(names, MachineMetadataMutant.class);
		
		add(names, SourceInfoMetadata.class);
		add(names, SourceInfoMetadataMutant.class);
		
		add(names, TestMetadata.class);
		add(names, TestMetadataMutant.class);
		add(names, TrialMetadata.class);
		add(names, TrialMetadataMutant.class);
		add(names, TrialRunMetadata.class);
		add(names, TrialRunMetadataMutant.class);
		
		add(names, UseCaseMetadata.class);
		
		names.addAll(Tests4J_XML_DependencyGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}

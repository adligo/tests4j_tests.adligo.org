package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.models.shared.coverage.ClassProbes;
import org.adligo.tests4j.models.shared.coverage.ClassProbesMutant;
import org.adligo.tests4j.models.shared.coverage.CoverageUnitContinerMutant;
import org.adligo.tests4j.models.shared.coverage.CoverageUnits;
import org.adligo.tests4j.models.shared.coverage.I_ClassProbes;
import org.adligo.tests4j.models.shared.coverage.I_ClassProbesMutant;
import org.adligo.tests4j.models.shared.coverage.I_CoverageUnits;
import org.adligo.tests4j.models.shared.coverage.I_CoverageUnitsContainer;
import org.adligo.tests4j.models.shared.coverage.I_LineCoverage;
import org.adligo.tests4j.models.shared.coverage.I_LineCoverageSegment;
import org.adligo.tests4j.models.shared.coverage.I_PackageCoverage;
import org.adligo.tests4j.models.shared.coverage.I_ProbeCoverageContainer;
import org.adligo.tests4j.models.shared.coverage.I_Probes;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.coverage.LineCoverage;
import org.adligo.tests4j.models.shared.coverage.LineCoverageMutant;
import org.adligo.tests4j.models.shared.coverage.LineCoverageSegment;
import org.adligo.tests4j.models.shared.coverage.LineCoverageSegmentMutant;
import org.adligo.tests4j.models.shared.coverage.PackageCoverage;
import org.adligo.tests4j.models.shared.coverage.PackageCoverageDelegator;
import org.adligo.tests4j.models.shared.coverage.PackageCoverageMutant;
import org.adligo.tests4j.models.shared.coverage.Probes;
import org.adligo.tests4j.models.shared.coverage.ProbesMutant;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverage;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverageDelegator;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverageMutant;

import java.util.HashSet;
import java.util.Set;
/**
* @diagram_sync with PackageDependencies.class on 10/1/1014
* @author scott
*
*/
public class Tests4J_Coverage_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_Coverage_ReferenceGroup INSTANCE = new Tests4J_Coverage_ReferenceGroup();
	
	private Tests4J_Coverage_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, ClassProbes.class);
		add(names, ClassProbesMutant.class);
		
		add(names, CoverageUnitContinerMutant.class);
		add(names, CoverageUnits.class);
		
		add(names, I_ClassProbes.class);
		add(names, I_ClassProbesMutant.class);
		
		add(names, I_CoverageUnits.class);
		add(names, I_CoverageUnitsContainer.class);
		add(names, I_LineCoverage.class);
		add(names, I_LineCoverageSegment.class);
		add(names, I_PackageCoverage.class);
		add(names, I_Probes.class);
		add(names, I_ProbeCoverageContainer.class);
		add(names, I_SourceFileCoverage.class);
		
		add(names, LineCoverage.class);
		add(names, LineCoverageMutant.class);
		add(names, LineCoverageSegment.class);
		add(names, LineCoverageSegmentMutant.class);
		
		add(names, PackageCoverage.class);
		add(names, PackageCoverageDelegator.class);
		add(names, PackageCoverageMutant.class);
		
		add(names, Probes.class);
		add(names, ProbesMutant.class);
		
		add(names, SourceFileCoverage.class);
		add(names, SourceFileCoverageDelegator.class);
		add(names, SourceFileCoverageMutant.class);
		
		
		names.addAll(Tests4J_XML_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}

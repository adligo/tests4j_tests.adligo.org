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
import org.adligo.tests4j.models.shared.coverage.I_PackageCoverageBrief;
import org.adligo.tests4j.models.shared.coverage.I_ProbesCoverageContainer;
import org.adligo.tests4j.models.shared.coverage.I_Probes;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverage;
import org.adligo.tests4j.models.shared.coverage.I_SourceFileCoverageBrief;
import org.adligo.tests4j.models.shared.coverage.LineCoverage;
import org.adligo.tests4j.models.shared.coverage.LineCoverageMutant;
import org.adligo.tests4j.models.shared.coverage.LineCoverageSegment;
import org.adligo.tests4j.models.shared.coverage.LineCoverageSegmentMutant;
import org.adligo.tests4j.models.shared.coverage.PackageCoverageBrief;
import org.adligo.tests4j.models.shared.coverage.PackageCoverageBriefDelegator;
import org.adligo.tests4j.models.shared.coverage.PackageCoverageBriefMutant;
import org.adligo.tests4j.models.shared.coverage.Probes;
import org.adligo.tests4j.models.shared.coverage.ProbesMutant;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverage;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverageDelegator;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverageMutant;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverageBrief;
import org.adligo.tests4j.models.shared.coverage.SourceFileCoverageBriefMutant;

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
		add(names, I_PackageCoverageBrief.class);
		add(names, I_Probes.class);
		add(names, I_ProbesCoverageContainer.class);
		add(names, I_SourceFileCoverage.class);
		add(names, I_SourceFileCoverageBrief.class);
		
		add(names, LineCoverage.class);
		add(names, LineCoverageMutant.class);
		add(names, LineCoverageSegment.class);
		add(names, LineCoverageSegmentMutant.class);
		
		add(names, PackageCoverageBrief.class);
		add(names, PackageCoverageBriefDelegator.class);
		add(names, PackageCoverageBriefMutant.class);
		
		add(names, Probes.class);
		add(names, ProbesMutant.class);
		
		add(names, SourceFileCoverage.class);
		add(names, SourceFileCoverageDelegator.class);
		add(names, SourceFileCoverageMutant.class);
		
		
		add(names, SourceFileCoverageBrief.class);
		add(names, SourceFileCoverageBriefMutant.class);
		
		names.addAll(Tests4J_XML_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}

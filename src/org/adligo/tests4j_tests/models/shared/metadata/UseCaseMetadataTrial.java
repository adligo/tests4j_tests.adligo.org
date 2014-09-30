package org.adligo.tests4j_tests.models.shared.metadata;


import org.adligo.tests4j.models.shared.metadata.UseCaseMetadata;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AnnotationMessages;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_Metadata_DependencyGroup;

@SourceFileScope (sourceClass=UseCaseMetadata.class, minCoverage=86.0)
@AllowedDependencies (groups=Tests4J_Metadata_DependencyGroup.class)
public class UseCaseMetadataTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorExceptions() throws Exception {
		I_Tests4J_AnnotationMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAnnotationMessages();
		 
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyNown())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata(null, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyNown())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("", "");
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyVerb())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("nown", null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyVerb())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("nown", "");
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyVerb())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("<useCase nown=\"exception\" />");
					}
				});
		
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyNown())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new UseCaseMetadata("<useCase verb=\"throw\" />");
					}
				});
	}
	
	@Test
	public void testEqualsHashCode() throws Exception {
		UseCaseMetadata a = new UseCaseMetadata("exception", "throw");
		UseCaseMetadata b = new UseCaseMetadata("football", "throw");
		UseCaseMetadata c = new UseCaseMetadata("exception", "throw");
		UseCaseMetadata d = new UseCaseMetadata("exception", "eat");
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, new Object());
	}
	
	@Test
	public void testGettersAndCopyConstructor() throws Exception {
		UseCaseMetadata uc = new UseCaseMetadata("exception", "throw");
		assertEquals("exception", uc.getNown());
		assertEquals("throw", uc.getVerb());
		
		UseCaseMetadata uc2 = new UseCaseMetadata(uc);
		assertEquals("exception", uc2.getNown());
		assertEquals("throw", uc2.getVerb());
	}
	
	@Test
	public void testToAndFromXML() throws Exception {
		UseCaseMetadata uc = new UseCaseMetadata("exception", "throw");
		XML_Builder builder = new XML_Builder();
		builder.addIndent();
		uc.toXml(builder);
		String result = builder.toXmlString();
		assertEquals("\t<useCase nown=\"exception\" verb=\"throw\" />\n", result);
		assertEquals("throw", uc.getVerb());
		
		UseCaseMetadata uc2 = new UseCaseMetadata(result);
		assertEquals("exception", uc2.getNown());
		assertEquals("throw", uc2.getVerb());
	}
	
	@Test
	public void testToString() throws Exception {
		UseCaseMetadata uc = new UseCaseMetadata("exception", "throw");
		assertEquals("UseCase [nown=exception, verb=throw]", uc.toString());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 5);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 24;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			return super.getAsserts(type, thisAsserts + thisAfterAsserts);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 16;
		//code coverage and circular dependencies +
		//custom afterTrialTests
		//+ see above
		int thisAfterUniqueAsserts = 3;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + thisAfterUniqueAsserts);
		} else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

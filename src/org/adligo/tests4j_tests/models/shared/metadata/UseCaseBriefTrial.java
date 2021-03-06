package org.adligo.tests4j_tests.models.shared.metadata;


import org.adligo.tests4j.models.shared.metadata.I_UseCaseBrief;
import org.adligo.tests4j.models.shared.metadata.UseCaseBrief;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_AnnotationMessages;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Metadata_GwtReferenceGroup;

@SourceFileScope (sourceClass=UseCaseBrief.class, minCoverage=85.0)
@AllowedReferences (groups=Tests4J_Metadata_GwtReferenceGroup.class)
public class UseCaseBriefTrial extends SourceFileCountingTrial {

	
	@Test
	public void testConstructorExceptions() throws Exception {
		I_Tests4J_AnnotationMessages messages =  Tests4J_EnglishConstants.ENGLISH.getAnnotationMessages();
		 
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
        new I_Thrower() {
          
          @SuppressWarnings("unused")
          @Override
          public void run() {
            new UseCaseBrief(null, (String) null);
          }
        });
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyName())), 
				new I_Thrower() {
					
					@SuppressWarnings("unused")
          @Override
					public void run() {
						new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, (String) null);
					}
				});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getUseCaseScopeEmptyName())), 
				new I_Thrower() {
					
					@SuppressWarnings("unused")
          @Override
					public void run() {
						new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, "");
					}
				});
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
        new I_Thrower() {
          
          @SuppressWarnings("unused")
          @Override
          public void run() {
            new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, (I_UseCaseBrief) null);
          }
        });
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testEqualsHashCode() throws Exception {
		UseCaseBrief a = new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, "throw exception");
		UseCaseBrief b = new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, "throw football");
		UseCaseBrief c = new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, "throw exception");
		UseCaseBrief d = new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, "eat exception");
		
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
		UseCaseBrief uc = new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, "throw exception");
		assertEquals("throw exception", uc.getName());
		
		UseCaseBrief uc2 = new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, uc);
		assertEquals("throw exception", uc2.getName());
	}
	

	@Test
	public void testToString() throws Exception {
		UseCaseBrief uc = new UseCaseBrief(Tests4J_EnglishConstants.ENGLISH, "throw exception");
		assertEquals("UseCase [throw exception]", uc.toString());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 4, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 16;
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
		int thisUniqueAsserts = 10;
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

package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_XmlSaxExt;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

import java.util.Map;

@SourceFileScope (sourceClass=JSE_1_6_XmlSaxExt.class,minCoverage=92.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_XmlSaxExtTrial extends SourceFileCountingTrial {
	public static final int ASSERTS = 15;
	public static final int UASSERTS = 9;
	
	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_XmlSaxExt.INSTANCE);
		assertEquals("org.xml.sax.ext", JSE_1_6_XmlSaxExt.INSTANCE.getPackageName());
		
		Map<String,String> map = JSE_1_6_XmlSaxExt.INSTANCE.getModelMap();
	  assertEquals("ATTRIBUTES2",map.get("org.xml.sax.ext.Attributes2"));
	  assertEquals("DECL_HANDLER",map.get("org.xml.sax.ext.DeclHandler"));
    assertEquals("LEXICAL_HANDLER",map.get("org.xml.sax.ext.LexicalHandler"));
    assertEquals("LOCATOR2",map.get("org.xml.sax.ext.Locator2"));
    assertEquals("ATTRIBUTES2_IMPL",map.get("org.xml.sax.ext.Attributes2Impl"));
    assertEquals("DEFAULT_HANDLER2",map.get("org.xml.sax.ext.DefaultHandler2"));
    assertEquals("LOCATOR2_IMPL",map.get("org.xml.sax.ext.Locator2Impl"));
	}
	
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
	  asserts.assertTrue(dg.isInGroup("org.xml.sax.ext.Attributes2"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ext.DeclHandler"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ext.LexicalHandler"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ext.Locator2"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ext.Attributes2Impl"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ext.DefaultHandler2"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ext.Locator2Impl"));
    
   
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = ASSERTS;
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
		int thisUniqueAsserts = UASSERTS;
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

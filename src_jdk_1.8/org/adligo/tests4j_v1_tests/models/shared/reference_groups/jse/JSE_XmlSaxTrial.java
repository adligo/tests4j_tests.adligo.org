package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_XmlSax;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_XmlSax.class,minCoverage=77.0)
@AllowedReferences (groups={Tests4J_JSE_GwtReferenceGroup.class})
public class JSE_XmlSaxTrial extends SourceFileCountingTrial {
	public static final int ASSERTS = 32;
	public static final int UASSERTS = 19;
	
	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_XmlSax.INSTANCE);
		assertEquals("org.xml.sax", JSE_XmlSax.INSTANCE.getPackageName());
		

    assertEquals("ATTRIBUTE_LIST",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.AttributeList"));
    assertEquals("ATTRIBUTES",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.Attributes"));
    assertEquals("CONTENT_HANDLER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.ContentHandler"));
    assertEquals("DOCUMENT_HANDLER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.DocumentHandler"));
    assertEquals("DTDHANDLER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.DTDHandler"));
    assertEquals("ENTITY_RESOLVER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.EntityResolver"));
    assertEquals("ERROR_HANDLER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.ErrorHandler"));
    assertEquals("LOCATOR",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.Locator"));
    assertEquals("PARSER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.Parser"));
    assertEquals("XMLFILTER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.XMLFilter"));
    assertEquals("XMLREADER",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.XMLReader"));
    assertEquals("HANDLER_BASE",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.HandlerBase"));
    assertEquals("INPUT_SOURCE",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.InputSource"));
    assertEquals("SAXEXCEPTION",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.SAXException"));
    assertEquals("SAXNOT_RECOGNIZED_EXCEPTION",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.SAXNotRecognizedException"));
    assertEquals("SAXNOT_SUPPORTED_EXCEPTION",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.SAXNotSupportedException"));
    assertEquals("SAXPARSE_EXCEPTION",JSE_XmlSax.INSTANCE.getConstantName("org.xml.sax.SAXParseException"));
	}
	
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
	  asserts.assertTrue(dg.isInGroup("org.xml.sax.Attributes"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ContentHandler"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.DTDHandler"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.EntityResolver"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.ErrorHandler"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.Locator"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.Parser"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.XMLFilter"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.XMLReader"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.InputSource"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.SAXException"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.SAXNotRecognizedException"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.SAXNotSupportedException"));
    asserts.assertTrue(dg.isInGroup("org.xml.sax.SAXParseException"));
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

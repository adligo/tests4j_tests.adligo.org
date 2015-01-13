package org.adligo.tests4j_tests.system.shared.api;

import org.adligo.tests4j.shared.asserts.common.ExpectedThrowable;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.en.Tests4J_EnglishConstants;
import org.adligo.tests4j.shared.i18n.I_Tests4J_ParamsReaderMessages;
import org.adligo.tests4j.shared.xml.XML_Builder;
import org.adligo.tests4j.system.shared.api.Tests4J_RemoteInfo;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_SystemApi_GwtReferenceGroup;
import org.adligo.tests4j_tests.system.shared.mocks.Tests4J_RemoteInfoMock;

@SourceFileScope (sourceClass=Tests4J_RemoteInfo.class, minCoverage=69.0)
@AllowedReferences (groups=Tests4J_SystemApi_GwtReferenceGroup.class)
public class Tests4J_RemoteInfoTrial extends SourceFileCountingTrial {
	
  @SuppressWarnings("unused")
	@Test
	public void testConstructorExceptions() {
		I_Tests4J_ParamsReaderMessages messages = Tests4J_EnglishConstants.ENGLISH.getParamReaderMessages();
		
		//null constants
		assertThrown(new ExpectedThrowable(NullPointerException.class), 
        new I_Thrower() {
          
          @Override
          public void run() {
            new Tests4J_RemoteInfo(null, null);
          }
        });
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getHostRequired())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, null, 0, null);
					}
				});
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getHostRequired())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, "", 0, null);
					}
				});
		
		final Tests4J_RemoteInfoMock mock = new Tests4J_RemoteInfoMock();
		//host null
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getHostRequired())), 
				new I_Thrower() {
					
          @Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock);
					}
				});
		//host empty
		mock.setHost("");
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getHostRequired())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock);
					}
				});
		
		//authCodeDefault null
		mock.setHost("abc");
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getAuthCodeOrAuthCodeDefaultRequired())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock, null);
					}
				});
		//authCodeDefault empty
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getAuthCodeOrAuthCodeDefaultRequired())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock, "");
					}
				});
		
		//authCode null
		mock.setAuthCode(null);
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getAuthCodeOrAuthCodeDefaultRequired())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock, null);
					}
				});
		
		//authCode empty
		mock.setAuthCode("");
		assertThrown(new ExpectedThrowable(new IllegalArgumentException(
				messages.getAuthCodeOrAuthCodeDefaultRequired())), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock, null);
					}
				});
	}
	
	@SuppressWarnings("boxing")
  @Test
	public void testCopyConstructors() {
		final Tests4J_RemoteInfoMock mock = new Tests4J_RemoteInfoMock();
		mock.setHost("abc");
		mock.setPort(7);
		Tests4J_RemoteInfo ri = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock);
		assertEquals("abc", ri.getHost());
		assertEquals(7, ri.getPort());
		assertNull(ri.getAuthCode());
		
		ri = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, mock, "hey7");
		assertEquals("abc", ri.getHost());
		assertEquals(7, ri.getPort());
		assertEquals("hey7", ri.getAuthCode());
		
		ri = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, "mock",11,  "hey999");
		assertEquals("mock", ri.getHost());
		assertEquals(11, ri.getPort());
		assertEquals("hey999", ri.getAuthCode());
	}
	
	
	@SuppressWarnings("boxing")
  @Test
	public void testEqualsHashCode() {
		
		Tests4J_RemoteInfo a = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, "mock",11,  "hey999");
		Tests4J_RemoteInfo b = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, "mockb",11,  "hey999");
		Tests4J_RemoteInfo c = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, "mock",11,  "hey999");
		Tests4J_RemoteInfo d = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, "mock",12,  "hey999");
		Tests4J_RemoteInfo e = new Tests4J_RemoteInfo(Tests4J_EnglishConstants.ENGLISH, "mock",11,  "hey997");
		
		assertEquals(a, a);
		assertEquals(a.hashCode(), a.hashCode());
		
		assertNotEquals(a, b);
		assertNotEquals(a.hashCode(), b.hashCode());
		
		assertEquals(a, c);
		assertEquals(a.hashCode(), c.hashCode());
		
		assertNotEquals(a, d);
		assertNotEquals(a.hashCode(), d.hashCode());
		
		assertNotEquals(a, e);
		assertNotEquals(a.hashCode(), e.hashCode());
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 3, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 28;
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
		int thisUniqueAsserts = 20;
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

package org.adligo.tests4j_tests.models.shared.system;

import org.adligo.tests4j.models.shared.asserts.ExpectedThrownData;
import org.adligo.tests4j.models.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.models.shared.en.Tests4J_ParamsReaderConstants;
import org.adligo.tests4j.models.shared.system.Tests4J_RemoteInfo;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j.models.shared.xml.XML_Builder;
import org.adligo.tests4j_tests.base_abstract_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.models.shared.system.mocks.Tests4J_RemoteInfoMock;

@SourceFileScope (sourceClass=Tests4J_RemoteInfo.class, minCoverage=86.0)
public class Tests4J_RemoteInfoTrial extends SourceFileCountingTrial {
	
	@Test
	public void testConstructorExceptions() {
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.HOST_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(null, 0, null);
					}
				});
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.HOST_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo("", 0, null);
					}
				});
		
		final Tests4J_RemoteInfoMock mock = new Tests4J_RemoteInfoMock();
		//host null
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.HOST_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(mock);
					}
				});
		//host empty
		mock.setHost("");
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.HOST_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(mock);
					}
				});
		
		//authCodeDefault null
		mock.setHost("abc");
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.AUTH_CODE_OR_AUTH_CODE_DEFAULT_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(mock, null);
					}
				});
		//authCodeDefault empty
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.AUTH_CODE_OR_AUTH_CODE_DEFAULT_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(mock, "");
					}
				});
		
		//authCode null
		mock.setAuthCode(null);
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.AUTH_CODE_OR_AUTH_CODE_DEFAULT_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(mock, null);
					}
				});
		
		//authCode empty
		mock.setAuthCode("");
		assertThrown(new ExpectedThrownData(new IllegalArgumentException(
				Tests4J_ParamsReaderConstants.AUTH_CODE_OR_AUTH_CODE_DEFAULT_REQUIRED)), 
				new I_Thrower() {
					
					@Override
					public void run() {
						new Tests4J_RemoteInfo(mock, null);
					}
				});
	}
	
	@Test
	public void testCopyConstructors() {
		final Tests4J_RemoteInfoMock mock = new Tests4J_RemoteInfoMock();
		mock.setHost("abc");
		mock.setPort(7);
		Tests4J_RemoteInfo ri = new Tests4J_RemoteInfo(mock);
		assertEquals("abc", ri.getHost());
		assertEquals(7, ri.getPort());
		assertNull(ri.getAuthCode());
		
		ri = new Tests4J_RemoteInfo(mock, "hey7");
		assertEquals("abc", ri.getHost());
		assertEquals(7, ri.getPort());
		assertEquals("hey7", ri.getAuthCode());
		
		ri = new Tests4J_RemoteInfo("mock",11,  "hey999");
		assertEquals("mock", ri.getHost());
		assertEquals(11, ri.getPort());
		assertEquals("hey999", ri.getAuthCode());
	}
	
	@Test
	public void testCopyConstructorsToAndFromXml() {
		Tests4J_RemoteInfo a = new Tests4J_RemoteInfo("mock",11, null);
		XML_Builder builder = new XML_Builder();
		builder.setAttributesPerLine(1);
		a.toXml(builder);
		String result = builder.toXmlString();
		assertEquals("<remoteInfo host=\"mock\" port=\"11\" />\n", result);
		assertEquals(1, builder.getAttributesPerLine());
		
		
		Tests4J_RemoteInfo b = new Tests4J_RemoteInfo(result);
		assertEquals("mock", b.getHost());
		assertEquals(11, b.getPort());
		assertNull(b.getAuthCode());
		
		
		a = new Tests4J_RemoteInfo("mock",11, "bb");
		builder = new XML_Builder();
		builder.setAttributesPerLine(2);
		a.toXml(builder);
		result = builder.toXmlString();
		assertEquals("<remoteInfo host=\"mock\" port=\"11\" authCode=\"bb\" />\n", result);
		assertEquals(2, builder.getAttributesPerLine());
		
		b = new Tests4J_RemoteInfo(result);
		assertEquals("mock", b.getHost());
		assertEquals(11, b.getPort());
		assertEquals("bb", b.getAuthCode());
	}
	
	@Test
	public void testEqualsHashCode() {
		
		Tests4J_RemoteInfo a = new Tests4J_RemoteInfo("mock",11,  "hey999");
		Tests4J_RemoteInfo b = new Tests4J_RemoteInfo("mockb",11,  "hey999");
		Tests4J_RemoteInfo c = new Tests4J_RemoteInfo("mock",11,  "hey999");
		Tests4J_RemoteInfo d = new Tests4J_RemoteInfo("mock",12,  "hey999");
		Tests4J_RemoteInfo e = new Tests4J_RemoteInfo("mock",11,  "hey997");
		
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
	public int getTests() {
		return 4;
	}

	@Override
	public int getAsserts() {
		return 37;
	}

	@Override
	public int getUniqueAsserts() {
		return 27;
	}
}
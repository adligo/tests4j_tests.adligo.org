package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Sql;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_1_6_Sql.class,minCoverage=91.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_SqlTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Sql.INSTANCE);
    assertEquals("ARRAY",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Array"));
    assertEquals("BLOB",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Blob"));
    assertEquals("CALLABLE_STATEMENT",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.CallableStatement"));
    assertEquals("CLOB",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Clob"));
    assertEquals("CONNECTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Connection"));
    assertEquals("DATABASE_META_DATA",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.DatabaseMetaData"));
    assertEquals("DRIVER",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Driver"));
    assertEquals("NCLOB",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.NClob"));
    assertEquals("PARAMETER_META_DATA",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.ParameterMetaData"));
    assertEquals("PREPARED_STATEMENT",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.PreparedStatement"));
    assertEquals("REF",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Ref"));
    assertEquals("RESULT_SET",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.ResultSet"));
    assertEquals("RESULT_SET_META_DATA",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.ResultSetMetaData"));
    assertEquals("ROW_ID",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.RowId"));
    assertEquals("SAVEPOINT",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Savepoint"));
    assertEquals("SQLDATA",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLData"));
    assertEquals("SQLINPUT",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLInput"));
    assertEquals("SQLOUTPUT",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLOutput"));
    assertEquals("SQLXML",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLXML"));
    assertEquals("STATEMENT",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Statement"));
    assertEquals("STRUCT",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Struct"));
    assertEquals("WRAPPER",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Wrapper"));
    assertEquals("DATE",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Date"));
    assertEquals("DRIVER_MANAGER",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.DriverManager"));
    assertEquals("DRIVER_PROPERTY_INFO",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.DriverPropertyInfo"));
    assertEquals("SQLPERMISSION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLPermission"));
    assertEquals("TIME",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Time"));
    assertEquals("TIMESTAMP",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Timestamp"));
    assertEquals("TYPES",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.Types"));
    assertEquals("CLIENT_INFO_STATUS",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.ClientInfoStatus"));
    assertEquals("PSEUDO_COLUMN_USAGE",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.PseudoColumnUsage"));
    assertEquals("ROW_ID_LIFETIME",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.RowIdLifetime"));
    assertEquals("BATCH_UPDATE_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.BatchUpdateException"));
    assertEquals("DATA_TRUNCATION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.DataTruncation"));
    assertEquals("SQLCLIENT_INFO_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLClientInfoException"));
    assertEquals("SQLDATA_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLDataException"));
    assertEquals("SQLEXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLException"));
    assertEquals("SQLFEATURE_NOT_SUPPORTED_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLFeatureNotSupportedException"));
    assertEquals("SQLINTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLIntegrityConstraintViolationException"));
    assertEquals("SQLINVALID_AUTHORIZATION_SPEC_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLInvalidAuthorizationSpecException"));
    assertEquals("SQLNON_TRANSIENT_CONNECTION_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLNonTransientConnectionException"));
    assertEquals("SQLRECOVERABLE_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLRecoverableException"));
    assertEquals("SQLSYNTAX_ERROR_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLSyntaxErrorException"));
    assertEquals("SQLTIMEOUT_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLTimeoutException"));
    assertEquals("SQLTRANSACTION_ROLLBACK_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLTransactionRollbackException"));
    assertEquals("SQLTRANSIENT_CONNECTION_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLTransientConnectionException"));
    assertEquals("SQLTRANSIENT_EXCEPTION",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLTransientException"));
    assertEquals("SQLWARNING",JSE_1_6_Sql.INSTANCE.getConstantName("java.sql.SQLWarning"));
	}
			
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.sql.Array"));
		asserts.assertTrue(dg.isInGroup("java.sql.Blob"));
		asserts.assertTrue(dg.isInGroup("java.sql.CallableStatement"));
		asserts.assertTrue(dg.isInGroup("java.sql.Clob"));
		asserts.assertTrue(dg.isInGroup("java.sql.Connection"));
		asserts.assertTrue(dg.isInGroup("java.sql.DatabaseMetaData"));
		asserts.assertTrue(dg.isInGroup("java.sql.Driver"));
		asserts.assertTrue(dg.isInGroup("java.sql.DriverAction"));
		asserts.assertTrue(dg.isInGroup("java.sql.NClob"));
		asserts.assertTrue(dg.isInGroup("java.sql.ParameterMetaData"));
		asserts.assertTrue(dg.isInGroup("java.sql.PreparedStatement"));
		asserts.assertTrue(dg.isInGroup("java.sql.Ref"));
		asserts.assertTrue(dg.isInGroup("java.sql.ResultSet"));
		asserts.assertTrue(dg.isInGroup("java.sql.ResultSetMetaData"));
		asserts.assertTrue(dg.isInGroup("java.sql.RowId"));
		asserts.assertTrue(dg.isInGroup("java.sql.Savepoint"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLData"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLInput"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLOutput"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLType"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLXML"));
		asserts.assertTrue(dg.isInGroup("java.sql.Statement"));
		asserts.assertTrue(dg.isInGroup("java.sql.Struct"));
		asserts.assertTrue(dg.isInGroup("java.sql.Wrapper"));
		asserts.assertTrue(dg.isInGroup("java.sql.Date"));
		asserts.assertTrue(dg.isInGroup("java.sql.DriverManager"));
		asserts.assertTrue(dg.isInGroup("java.sql.DriverPropertyInfo"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLPermission"));
		asserts.assertTrue(dg.isInGroup("java.sql.Time"));
		asserts.assertTrue(dg.isInGroup("java.sql.Timestamp"));
		asserts.assertTrue(dg.isInGroup("java.sql.Types"));
		asserts.assertTrue(dg.isInGroup("java.sql.ClientInfoStatus"));
		asserts.assertTrue(dg.isInGroup("java.sql.JDBCType"));
		asserts.assertTrue(dg.isInGroup("java.sql.PseudoColumnUsage"));
		asserts.assertTrue(dg.isInGroup("java.sql.RowIdLifetime"));
		asserts.assertTrue(dg.isInGroup("java.sql.BatchUpdateException"));
		asserts.assertTrue(dg.isInGroup("java.sql.DataTruncation"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLClientInfoException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLDataException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLFeatureNotSupportedException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLIntegrityConstraintViolationException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLInvalidAuthorizationSpecException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLNonTransientConnectionException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLNonTransientException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLRecoverableException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLSyntaxErrorException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLTimeoutException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLTransactionRollbackException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLTransientConnectionException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLTransientException"));
		asserts.assertTrue(dg.isInGroup("java.sql.SQLWarning"));


	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 100;
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
		int thisUniqueAsserts = 49;
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

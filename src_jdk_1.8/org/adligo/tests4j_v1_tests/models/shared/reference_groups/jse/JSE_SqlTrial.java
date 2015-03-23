package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_Sql;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_Sql.class,minCoverage=97.0)
@AllowedReferences (groups=Tests4J_JSE_GwtReferenceGroup.class)
public class JSE_SqlTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.sql.Array",JSE_Sql.ARRAY);
		assertEquals("java.sql.Blob",JSE_Sql.BLOB);
		assertEquals("java.sql.CallableStatement",JSE_Sql.CALLABLE_STATEMENT);
		assertEquals("java.sql.Clob",JSE_Sql.CLOB);
		assertEquals("java.sql.Connection",JSE_Sql.CONNECTION);
		assertEquals("java.sql.DatabaseMetaData",JSE_Sql.DATABASE_META_DATA);
		assertEquals("java.sql.Driver",JSE_Sql.DRIVER);
		assertEquals("java.sql.NClob",JSE_Sql.NCLOB);
		assertEquals("java.sql.ParameterMetaData",JSE_Sql.PARAMETER_META_DATA);
		assertEquals("java.sql.PreparedStatement",JSE_Sql.PREPARED_STATEMENT);
		assertEquals("java.sql.Ref",JSE_Sql.REF);
		assertEquals("java.sql.ResultSet",JSE_Sql.RESULT_SET);
		assertEquals("java.sql.ResultSetMetaData",JSE_Sql.RESULT_SET_META_DATA);
		assertEquals("java.sql.RowId",JSE_Sql.ROW_ID);
		assertEquals("java.sql.Savepoint",JSE_Sql.SAVEPOINT);
		assertEquals("java.sql.SQLData",JSE_Sql.SQLDATA);
		assertEquals("java.sql.SQLInput",JSE_Sql.SQLINPUT);
		assertEquals("java.sql.SQLOutput",JSE_Sql.SQLOUTPUT);
		assertEquals("java.sql.SQLXML",JSE_Sql.SQLXML);
		assertEquals("java.sql.Statement",JSE_Sql.STATEMENT);
		assertEquals("java.sql.Struct",JSE_Sql.STRUCT);
		assertEquals("java.sql.Wrapper",JSE_Sql.WRAPPER);
		assertEquals("java.sql.Date",JSE_Sql.DATE);
		assertEquals("java.sql.DriverManager",JSE_Sql.DRIVER_MANAGER);
		assertEquals("java.sql.DriverPropertyInfo",JSE_Sql.DRIVER_PROPERTY_INFO);
		assertEquals("java.sql.SQLPermission",JSE_Sql.SQLPERMISSION);
		assertEquals("java.sql.Time",JSE_Sql.TIME);
		assertEquals("java.sql.Timestamp",JSE_Sql.TIMESTAMP);
		assertEquals("java.sql.Types",JSE_Sql.TYPES);
		assertEquals("java.sql.ClientInfoStatus",JSE_Sql.CLIENT_INFO_STATUS);
		assertEquals("java.sql.PseudoColumnUsage",JSE_Sql.PSEUDO_COLUMN_USAGE);
		assertEquals("java.sql.RowIdLifetime",JSE_Sql.ROW_ID_LIFETIME);
		assertEquals("java.sql.BatchUpdateException",JSE_Sql.BATCH_UPDATE_EXCEPTION);
		assertEquals("java.sql.DataTruncation",JSE_Sql.DATA_TRUNCATION);
		assertEquals("java.sql.SQLClientInfoException",JSE_Sql.SQLCLIENT_INFO_EXCEPTION);
		assertEquals("java.sql.SQLDataException",JSE_Sql.SQLDATA_EXCEPTION);
		assertEquals("java.sql.SQLException",JSE_Sql.SQLEXCEPTION);
		assertEquals("java.sql.SQLFeatureNotSupportedException",JSE_Sql.SQLFEATURE_NOT_SUPPORTED_EXCEPTION);
		assertEquals("java.sql.SQLIntegrityConstraintViolationException",JSE_Sql.SQLINTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION);
		assertEquals("java.sql.SQLInvalidAuthorizationSpecException",JSE_Sql.SQLINVALID_AUTHORIZATION_SPEC_EXCEPTION);
		assertEquals("java.sql.SQLNonTransientConnectionException",JSE_Sql.SQLNON_TRANSIENT_CONNECTION_EXCEPTION);
		assertEquals("java.sql.SQLRecoverableException",JSE_Sql.SQLRECOVERABLE_EXCEPTION);
		assertEquals("java.sql.SQLSyntaxErrorException",JSE_Sql.SQLSYNTAX_ERROR_EXCEPTION);
		assertEquals("java.sql.SQLTimeoutException",JSE_Sql.SQLTIMEOUT_EXCEPTION);
		assertEquals("java.sql.SQLTransactionRollbackException",JSE_Sql.SQLTRANSACTION_ROLLBACK_EXCEPTION);
		assertEquals("java.sql.SQLTransientConnectionException",JSE_Sql.SQLTRANSIENT_CONNECTION_EXCEPTION);
		assertEquals("java.sql.SQLTransientException",JSE_Sql.SQLTRANSIENT_EXCEPTION);
		assertEquals("java.sql.SQLWarning",JSE_Sql.SQLWARNING);
		assertEquals(JSE_Sql.class.getName(), JSE_Sql.INSTANCE.getClass().getName());
		
    assertEquals("ARRAY",JSE_Sql.INSTANCE.getConstantName("java.sql.Array"));
    assertEquals("BLOB",JSE_Sql.INSTANCE.getConstantName("java.sql.Blob"));
    assertEquals("CALLABLE_STATEMENT",JSE_Sql.INSTANCE.getConstantName("java.sql.CallableStatement"));
    assertEquals("CLOB",JSE_Sql.INSTANCE.getConstantName("java.sql.Clob"));
    assertEquals("CONNECTION",JSE_Sql.INSTANCE.getConstantName("java.sql.Connection"));
    assertEquals("DATABASE_META_DATA",JSE_Sql.INSTANCE.getConstantName("java.sql.DatabaseMetaData"));
    assertEquals("DRIVER",JSE_Sql.INSTANCE.getConstantName("java.sql.Driver"));
    assertEquals("NCLOB",JSE_Sql.INSTANCE.getConstantName("java.sql.NClob"));
    assertEquals("PARAMETER_META_DATA",JSE_Sql.INSTANCE.getConstantName("java.sql.ParameterMetaData"));
    assertEquals("PREPARED_STATEMENT",JSE_Sql.INSTANCE.getConstantName("java.sql.PreparedStatement"));
    assertEquals("REF",JSE_Sql.INSTANCE.getConstantName("java.sql.Ref"));
    assertEquals("RESULT_SET",JSE_Sql.INSTANCE.getConstantName("java.sql.ResultSet"));
    assertEquals("RESULT_SET_META_DATA",JSE_Sql.INSTANCE.getConstantName("java.sql.ResultSetMetaData"));
    assertEquals("ROW_ID",JSE_Sql.INSTANCE.getConstantName("java.sql.RowId"));
    assertEquals("SAVEPOINT",JSE_Sql.INSTANCE.getConstantName("java.sql.Savepoint"));
    assertEquals("SQLDATA",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLData"));
    assertEquals("SQLINPUT",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLInput"));
    assertEquals("SQLOUTPUT",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLOutput"));
    assertEquals("SQLXML",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLXML"));
    assertEquals("STATEMENT",JSE_Sql.INSTANCE.getConstantName("java.sql.Statement"));
    assertEquals("STRUCT",JSE_Sql.INSTANCE.getConstantName("java.sql.Struct"));
    assertEquals("WRAPPER",JSE_Sql.INSTANCE.getConstantName("java.sql.Wrapper"));
    assertEquals("DATE",JSE_Sql.INSTANCE.getConstantName("java.sql.Date"));
    assertEquals("DRIVER_MANAGER",JSE_Sql.INSTANCE.getConstantName("java.sql.DriverManager"));
    assertEquals("DRIVER_PROPERTY_INFO",JSE_Sql.INSTANCE.getConstantName("java.sql.DriverPropertyInfo"));
    assertEquals("SQLPERMISSION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLPermission"));
    assertEquals("TIME",JSE_Sql.INSTANCE.getConstantName("java.sql.Time"));
    assertEquals("TIMESTAMP",JSE_Sql.INSTANCE.getConstantName("java.sql.Timestamp"));
    assertEquals("TYPES",JSE_Sql.INSTANCE.getConstantName("java.sql.Types"));
    assertEquals("CLIENT_INFO_STATUS",JSE_Sql.INSTANCE.getConstantName("java.sql.ClientInfoStatus"));
    assertEquals("PSEUDO_COLUMN_USAGE",JSE_Sql.INSTANCE.getConstantName("java.sql.PseudoColumnUsage"));
    assertEquals("ROW_ID_LIFETIME",JSE_Sql.INSTANCE.getConstantName("java.sql.RowIdLifetime"));
    assertEquals("BATCH_UPDATE_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.BatchUpdateException"));
    assertEquals("DATA_TRUNCATION",JSE_Sql.INSTANCE.getConstantName("java.sql.DataTruncation"));
    assertEquals("SQLCLIENT_INFO_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLClientInfoException"));
    assertEquals("SQLDATA_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLDataException"));
    assertEquals("SQLEXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLException"));
    assertEquals("SQLFEATURE_NOT_SUPPORTED_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLFeatureNotSupportedException"));
    assertEquals("SQLINTEGRITY_CONSTRAINT_VIOLATION_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLIntegrityConstraintViolationException"));
    assertEquals("SQLINVALID_AUTHORIZATION_SPEC_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLInvalidAuthorizationSpecException"));
    assertEquals("SQLNON_TRANSIENT_CONNECTION_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLNonTransientConnectionException"));
    assertEquals("SQLRECOVERABLE_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLRecoverableException"));
    assertEquals("SQLSYNTAX_ERROR_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLSyntaxErrorException"));
    assertEquals("SQLTIMEOUT_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLTimeoutException"));
    assertEquals("SQLTRANSACTION_ROLLBACK_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLTransactionRollbackException"));
    assertEquals("SQLTRANSIENT_CONNECTION_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLTransientConnectionException"));
    assertEquals("SQLTRANSIENT_EXCEPTION",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLTransientException"));
    assertEquals("SQLWARNING",JSE_Sql.INSTANCE.getConstantName("java.sql.SQLWarning"));
	}
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 97;
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
		int thisUniqueAsserts = 97;
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
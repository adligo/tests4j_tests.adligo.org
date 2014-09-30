package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Math;
import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Sql;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.I_DependencyGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_JSE_v1_6_DependencyGroup;

@SourceFileScope (sourceClass=JSE_1_6_Sql.class,minCoverage=91.0)
@AllowedDependencies (groups={Tests4J_JSE_v1_6_DependencyGroup.class})
public class JSE_1_6_SqlTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Sql.INSTANCE);
	}
			
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_DependencyGroup dg) {
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
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 52;
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
		int thisUniqueAsserts = 1;
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

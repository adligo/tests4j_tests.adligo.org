package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_IO;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.shared.asserts.reference.I_ReferenceGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_v1_6_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_1_6_IO.class,minCoverage=88.0)
@AllowedReferences (groups={Tests4J_JSE_v1_6_GwtReferenceGroup.class})
public class JSE_1_6_IOTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_IO.INSTANCE);
	}
	
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_ReferenceGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.io.Closeable"));
		asserts.assertTrue(dg.isInGroup("java.io.DataInput"));
		asserts.assertTrue(dg.isInGroup("java.io.DataOutput"));
		asserts.assertTrue(dg.isInGroup("java.io.Externalizable"));
		asserts.assertTrue(dg.isInGroup("java.io.FileFilter"));
		asserts.assertTrue(dg.isInGroup("java.io.FilenameFilter"));
		asserts.assertTrue(dg.isInGroup("java.io.Flushable"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectInput"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectInputValidation"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectOutput"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectStreamConstants"));
		asserts.assertTrue(dg.isInGroup("java.io.Serializable"));
		asserts.assertTrue(dg.isInGroup("java.io.BufferedInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.BufferedOutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.BufferedReader"));
		asserts.assertTrue(dg.isInGroup("java.io.BufferedWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.ByteArrayInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.ByteArrayOutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.CharArrayReader"));
		asserts.assertTrue(dg.isInGroup("java.io.CharArrayWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.Console"));
		asserts.assertTrue(dg.isInGroup("java.io.DataInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.DataOutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.File"));
		asserts.assertTrue(dg.isInGroup("java.io.FileDescriptor"));
		asserts.assertTrue(dg.isInGroup("java.io.FileInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.FileOutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.FilePermission"));
		asserts.assertTrue(dg.isInGroup("java.io.FileReader"));
		asserts.assertTrue(dg.isInGroup("java.io.FileWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.FilterInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.FilterOutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.FilterReader"));
		asserts.assertTrue(dg.isInGroup("java.io.FilterWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.InputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.InputStreamReader"));
		asserts.assertTrue(dg.isInGroup("java.io.LineNumberInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.LineNumberReader"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectInputStream$GetField"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectOutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectOutputStream$PutField"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectStreamClass"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectStreamField"));
		asserts.assertTrue(dg.isInGroup("java.io.OutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.OutputStreamWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.PipedInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.PipedOutputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.PipedReader"));
		asserts.assertTrue(dg.isInGroup("java.io.PipedWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.PrintStream"));
		asserts.assertTrue(dg.isInGroup("java.io.PrintWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.PushbackInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.PushbackReader"));
		asserts.assertTrue(dg.isInGroup("java.io.RandomAccessFile"));
		asserts.assertTrue(dg.isInGroup("java.io.Reader"));
		asserts.assertTrue(dg.isInGroup("java.io.SequenceInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.SerializablePermission"));
		asserts.assertTrue(dg.isInGroup("java.io.StreamTokenizer"));
		asserts.assertTrue(dg.isInGroup("java.io.StringBufferInputStream"));
		asserts.assertTrue(dg.isInGroup("java.io.StringReader"));
		asserts.assertTrue(dg.isInGroup("java.io.StringWriter"));
		asserts.assertTrue(dg.isInGroup("java.io.Writer"));
		asserts.assertTrue(dg.isInGroup("java.io.CharConversionException"));
		asserts.assertTrue(dg.isInGroup("java.io.EOFException"));
		asserts.assertTrue(dg.isInGroup("java.io.FileNotFoundException"));
		asserts.assertTrue(dg.isInGroup("java.io.InterruptedIOException"));
		asserts.assertTrue(dg.isInGroup("java.io.InvalidClassException"));
		asserts.assertTrue(dg.isInGroup("java.io.InvalidObjectException"));
		asserts.assertTrue(dg.isInGroup("java.io.IOException"));
		asserts.assertTrue(dg.isInGroup("java.io.NotActiveException"));
		asserts.assertTrue(dg.isInGroup("java.io.NotSerializableException"));
		asserts.assertTrue(dg.isInGroup("java.io.ObjectStreamException"));
		asserts.assertTrue(dg.isInGroup("java.io.OptionalDataException"));
		asserts.assertTrue(dg.isInGroup("java.io.StreamCorruptedException"));
		asserts.assertTrue(dg.isInGroup("java.io.SyncFailedException"));
		asserts.assertTrue(dg.isInGroup("java.io.UncheckedIOException"));
		asserts.assertTrue(dg.isInGroup("java.io.UnsupportedEncodingException"));
		asserts.assertTrue(dg.isInGroup("java.io.UTFDataFormatException"));
		asserts.assertTrue(dg.isInGroup("java.io.WriteAbortedException"));
		asserts.assertTrue(dg.isInGroup("java.io.IOError"));
	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 81;
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

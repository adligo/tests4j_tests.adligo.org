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
		

    assertEquals("CLOSEABLE",JSE_1_6_IO.INSTANCE.getConstantName("java.io.Closeable"));
    assertEquals("DATA_OUTPUT",JSE_1_6_IO.INSTANCE.getConstantName("java.io.DataOutput"));
    assertEquals("DATA_INPUT",JSE_1_6_IO.INSTANCE.getConstantName("java.io.DataInput"));
    assertEquals("EXTERNALIZABLE",JSE_1_6_IO.INSTANCE.getConstantName("java.io.Externalizable"));
    assertEquals("FILE_FILTER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FileFilter"));
    assertEquals("FILENAME_FILTER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FilenameFilter"));
    assertEquals("FLUSHABLE",JSE_1_6_IO.INSTANCE.getConstantName("java.io.Flushable"));
    assertEquals("OBJECT_INPUT",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectInput"));
    assertEquals("OBJECT_INPUT_VALIDATION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectInputValidation"));
    assertEquals("OBJECT_OUTPUT",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectOutput"));
    assertEquals("OBJECT_STREAM_CONSTANTS",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectStreamConstants"));
    assertEquals("SERIALIZABLE",JSE_1_6_IO.INSTANCE.getConstantName("java.io.Serializable"));
    assertEquals("BUFFERED_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.BufferedInputStream"));
    assertEquals("BUFFERED_OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.BufferedOutputStream"));
    assertEquals("BUFFERED_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.BufferedReader"));
    assertEquals("BUFFERED_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.BufferedWriter"));
    assertEquals("BYTE_ARRAY_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ByteArrayInputStream"));
    assertEquals("BYTE_ARRAY_OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ByteArrayOutputStream"));
    assertEquals("CHAR_ARRAY_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.CharArrayReader"));
    assertEquals("CHAR_ARRAY_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.CharArrayWriter"));
    assertEquals("CONSOLE",JSE_1_6_IO.INSTANCE.getConstantName("java.io.Console"));
    assertEquals("DATA_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.DataInputStream"));
    assertEquals("DATA_OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.DataOutputStream"));
    assertEquals("FILE",JSE_1_6_IO.INSTANCE.getConstantName("java.io.File"));
    assertEquals("FILE_DESCRIPTOR",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FileDescriptor"));
    assertEquals("FILE_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FileInputStream"));
    assertEquals("FILE_OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FileOutputStream"));
    assertEquals("FILE_PERMISSION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FilePermission"));
    assertEquals("FILE_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FileReader"));
    assertEquals("FILE_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FileWriter"));
    assertEquals("FILTER_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FilterInputStream"));
    assertEquals("FILTER_OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FilterOutputStream"));
    assertEquals("FILTER_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FilterReader"));
    assertEquals("FILTER_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FilterWriter"));
    assertEquals("INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.InputStream"));
    assertEquals("INPUT_STREAM_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.InputStreamReader"));
    assertEquals("LINE_NUMBER_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.LineNumberInputStream"));
    assertEquals("LINE_NUMBER_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.LineNumberReader"));
    assertEquals("OBJECT_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectInputStream"));
    assertEquals("GET_FIELD",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectInputStream$GetField"));
    assertEquals("OBJECT_OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectOutputStream"));
    assertEquals("PUT_FIELD",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectOutputStream$PutField"));
    assertEquals("OBJECT_STREAM_CLASS",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectStreamClass"));
    assertEquals("OBJECT_STREAM_FIELD",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectStreamField"));
    assertEquals("OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.OutputStream"));
    assertEquals("OUTPUT_STREAM_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.OutputStreamWriter"));
    assertEquals("PIPED_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PipedInputStream"));
    assertEquals("PIPED_OUTPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PipedOutputStream"));
    assertEquals("PIPED_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PipedReader"));
    assertEquals("PIPED_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PipedWriter"));
    assertEquals("PRINT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PrintStream"));
    assertEquals("PRINT_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PrintWriter"));
    assertEquals("PUSHBACK_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PushbackInputStream"));
    assertEquals("PUSHBACK_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.PushbackReader"));
    assertEquals("RANDOM_ACCESS_FILE",JSE_1_6_IO.INSTANCE.getConstantName("java.io.RandomAccessFile"));
    assertEquals("READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.Reader"));
    assertEquals("SEQUENCE_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.SequenceInputStream"));
    assertEquals("SERIALIZABLE_PERMISSION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.SerializablePermission"));
    assertEquals("STREAM_TOKENIZER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.StreamTokenizer"));
    assertEquals("STRING_BUFFER_INPUT_STREAM",JSE_1_6_IO.INSTANCE.getConstantName("java.io.StringBufferInputStream"));
    assertEquals("STRING_READER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.StringReader"));
    assertEquals("STRING_WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.StringWriter"));
    assertEquals("WRITER",JSE_1_6_IO.INSTANCE.getConstantName("java.io.Writer"));
    assertEquals("CHAR_CONVERSION_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.CharConversionException"));
    assertEquals("EOFEXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.EOFException"));
    assertEquals("FILE_NOT_FOUND_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.FileNotFoundException"));
    assertEquals("INTERRUPTED_IO_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.InterruptedIOException"));
    assertEquals("INVALID_CLASS_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.InvalidClassException"));
    assertEquals("INVALID_OBJECT_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.InvalidObjectException"));
    assertEquals("IOEXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.IOException"));
    assertEquals("NOT_ACTIVE_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.NotActiveException"));
    assertEquals("NOT_SERIALIZABLE_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.NotSerializableException"));
    assertEquals("OBJECT_STREAM_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.ObjectStreamException"));
    assertEquals("OPTIONAL_DATA_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.OptionalDataException"));
    assertEquals("STREAM_CORRUPTED_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.StreamCorruptedException"));
    assertEquals("SYNC_FAILED_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.SyncFailedException"));
    assertEquals("UNSUPPORTED_ENCODING_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.UnsupportedEncodingException"));
    assertEquals("UTFDATA_FORMAT_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.UTFDataFormatException"));
    assertEquals("WRITE_ABORTED_EXCEPTION",JSE_1_6_IO.INSTANCE.getConstantName("java.io.WriteAbortedException"));
    assertEquals("IOERROR",JSE_1_6_IO.INSTANCE.getConstantName("java.io.IOError"));
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
		int thisAsserts = 161;
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
		int thisUniqueAsserts = 81;
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

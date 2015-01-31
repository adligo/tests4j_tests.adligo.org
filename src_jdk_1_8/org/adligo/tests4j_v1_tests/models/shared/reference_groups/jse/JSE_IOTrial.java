package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse;

import org.adligo.tests4j.models.shared.reference_groups.jse.JSE_IO;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_JSE_GwtReferenceGroup;

@SourceFileScope (sourceClass=JSE_IO.class,minCoverage=97)
@AllowedReferences (groups=Tests4J_JSE_GwtReferenceGroup.class)
public class JSE_IOTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
    assertEquals("CLOSEABLE",JSE_IO.INSTANCE.getConstantName("java.io.Closeable"));
    assertEquals("DATA_OUTPUT",JSE_IO.INSTANCE.getConstantName("java.io.DataOutput"));
    assertEquals("DATA_INPUT",JSE_IO.INSTANCE.getConstantName("java.io.DataInput"));
    assertEquals("EXTERNALIZABLE",JSE_IO.INSTANCE.getConstantName("java.io.Externalizable"));
    assertEquals("FILE_FILTER",JSE_IO.INSTANCE.getConstantName("java.io.FileFilter"));
    assertEquals("FILENAME_FILTER",JSE_IO.INSTANCE.getConstantName("java.io.FilenameFilter"));
    assertEquals("FLUSHABLE",JSE_IO.INSTANCE.getConstantName("java.io.Flushable"));
    assertEquals("OBJECT_INPUT",JSE_IO.INSTANCE.getConstantName("java.io.ObjectInput"));
    assertEquals("OBJECT_INPUT_VALIDATION",JSE_IO.INSTANCE.getConstantName("java.io.ObjectInputValidation"));
    assertEquals("OBJECT_OUTPUT",JSE_IO.INSTANCE.getConstantName("java.io.ObjectOutput"));
    assertEquals("OBJECT_STREAM_CONSTANTS",JSE_IO.INSTANCE.getConstantName("java.io.ObjectStreamConstants"));
    assertEquals("SERIALIZABLE",JSE_IO.INSTANCE.getConstantName("java.io.Serializable"));
    assertEquals("BUFFERED_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.BufferedInputStream"));
    assertEquals("BUFFERED_OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.BufferedOutputStream"));
    assertEquals("BUFFERED_READER",JSE_IO.INSTANCE.getConstantName("java.io.BufferedReader"));
    assertEquals("BUFFERED_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.BufferedWriter"));
    assertEquals("BYTE_ARRAY_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.ByteArrayInputStream"));
    assertEquals("BYTE_ARRAY_OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.ByteArrayOutputStream"));
    assertEquals("CHAR_ARRAY_READER",JSE_IO.INSTANCE.getConstantName("java.io.CharArrayReader"));
    assertEquals("CHAR_ARRAY_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.CharArrayWriter"));
    assertEquals("CONSOLE",JSE_IO.INSTANCE.getConstantName("java.io.Console"));
    assertEquals("DATA_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.DataInputStream"));
    assertEquals("DATA_OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.DataOutputStream"));
    assertEquals("FILE",JSE_IO.INSTANCE.getConstantName("java.io.File"));
    assertEquals("FILE_DESCRIPTOR",JSE_IO.INSTANCE.getConstantName("java.io.FileDescriptor"));
    assertEquals("FILE_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.FileInputStream"));
    assertEquals("FILE_OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.FileOutputStream"));
    assertEquals("FILE_PERMISSION",JSE_IO.INSTANCE.getConstantName("java.io.FilePermission"));
    assertEquals("FILE_READER",JSE_IO.INSTANCE.getConstantName("java.io.FileReader"));
    assertEquals("FILE_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.FileWriter"));
    assertEquals("FILTER_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.FilterInputStream"));
    assertEquals("FILTER_OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.FilterOutputStream"));
    assertEquals("FILTER_READER",JSE_IO.INSTANCE.getConstantName("java.io.FilterReader"));
    assertEquals("FILTER_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.FilterWriter"));
    assertEquals("INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.InputStream"));
    assertEquals("INPUT_STREAM_READER",JSE_IO.INSTANCE.getConstantName("java.io.InputStreamReader"));
    assertEquals("LINE_NUMBER_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.LineNumberInputStream"));
    assertEquals("LINE_NUMBER_READER",JSE_IO.INSTANCE.getConstantName("java.io.LineNumberReader"));
    assertEquals("OBJECT_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.ObjectInputStream"));
    assertEquals("GET_FIELD",JSE_IO.INSTANCE.getConstantName("java.io.ObjectInputStream$GetField"));
    assertEquals("OBJECT_OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.ObjectOutputStream"));
    assertEquals("PUT_FIELD",JSE_IO.INSTANCE.getConstantName("java.io.ObjectOutputStream$PutField"));
    assertEquals("OBJECT_STREAM_CLASS",JSE_IO.INSTANCE.getConstantName("java.io.ObjectStreamClass"));
    assertEquals("OBJECT_STREAM_FIELD",JSE_IO.INSTANCE.getConstantName("java.io.ObjectStreamField"));
    assertEquals("OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.OutputStream"));
    assertEquals("OUTPUT_STREAM_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.OutputStreamWriter"));
    assertEquals("PIPED_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.PipedInputStream"));
    assertEquals("PIPED_OUTPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.PipedOutputStream"));
    assertEquals("PIPED_READER",JSE_IO.INSTANCE.getConstantName("java.io.PipedReader"));
    assertEquals("PIPED_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.PipedWriter"));
    assertEquals("PRINT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.PrintStream"));
    assertEquals("PRINT_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.PrintWriter"));
    assertEquals("PUSHBACK_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.PushbackInputStream"));
    assertEquals("PUSHBACK_READER",JSE_IO.INSTANCE.getConstantName("java.io.PushbackReader"));
    assertEquals("RANDOM_ACCESS_FILE",JSE_IO.INSTANCE.getConstantName("java.io.RandomAccessFile"));
    assertEquals("READER",JSE_IO.INSTANCE.getConstantName("java.io.Reader"));
    assertEquals("SEQUENCE_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.SequenceInputStream"));
    assertEquals("SERIALIZABLE_PERMISSION",JSE_IO.INSTANCE.getConstantName("java.io.SerializablePermission"));
    assertEquals("STREAM_TOKENIZER",JSE_IO.INSTANCE.getConstantName("java.io.StreamTokenizer"));
    assertEquals("STRING_BUFFER_INPUT_STREAM",JSE_IO.INSTANCE.getConstantName("java.io.StringBufferInputStream"));
    assertEquals("STRING_READER",JSE_IO.INSTANCE.getConstantName("java.io.StringReader"));
    assertEquals("STRING_WRITER",JSE_IO.INSTANCE.getConstantName("java.io.StringWriter"));
    assertEquals("WRITER",JSE_IO.INSTANCE.getConstantName("java.io.Writer"));
    assertEquals("CHAR_CONVERSION_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.CharConversionException"));
    assertEquals("EOFEXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.EOFException"));
    assertEquals("FILE_NOT_FOUND_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.FileNotFoundException"));
    assertEquals("INTERRUPTED_IO_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.InterruptedIOException"));
    assertEquals("INVALID_CLASS_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.InvalidClassException"));
    assertEquals("INVALID_OBJECT_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.InvalidObjectException"));
    assertEquals("IOEXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.IOException"));
    assertEquals("NOT_ACTIVE_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.NotActiveException"));
    assertEquals("NOT_SERIALIZABLE_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.NotSerializableException"));
    assertEquals("OBJECT_STREAM_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.ObjectStreamException"));
    assertEquals("OPTIONAL_DATA_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.OptionalDataException"));
    assertEquals("STREAM_CORRUPTED_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.StreamCorruptedException"));
    assertEquals("SYNC_FAILED_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.SyncFailedException"));
    assertEquals("UNSUPPORTED_ENCODING_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.UnsupportedEncodingException"));
    assertEquals("UTFDATA_FORMAT_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.UTFDataFormatException"));
    assertEquals("WRITE_ABORTED_EXCEPTION",JSE_IO.INSTANCE.getConstantName("java.io.WriteAbortedException"));
    assertEquals("IOERROR",JSE_IO.INSTANCE.getConstantName("java.io.IOError"));
    
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.io.Closeable",JSE_IO.CLOSEABLE);
		assertEquals("java.io.DataOutput",JSE_IO.DATA_OUTPUT);
		assertEquals("java.io.DataInput",JSE_IO.DATA_INPUT);
		assertEquals("java.io.Externalizable",JSE_IO.EXTERNALIZABLE);
		assertEquals("java.io.FileFilter",JSE_IO.FILE_FILTER);
		assertEquals("java.io.FilenameFilter",JSE_IO.FILENAME_FILTER);
		assertEquals("java.io.Flushable",JSE_IO.FLUSHABLE);
		assertEquals("java.io.ObjectInput",JSE_IO.OBJECT_INPUT);
		assertEquals("java.io.ObjectInputValidation",JSE_IO.OBJECT_INPUT_VALIDATION);
		assertEquals("java.io.ObjectOutput",JSE_IO.OBJECT_OUTPUT);
		assertEquals("java.io.ObjectStreamConstants",JSE_IO.OBJECT_STREAM_CONSTANTS);
		assertEquals("java.io.Serializable",JSE_IO.SERIALIZABLE);
		assertEquals("java.io.BufferedInputStream",JSE_IO.BUFFERED_INPUT_STREAM);
		assertEquals("java.io.BufferedOutputStream",JSE_IO.BUFFERED_OUTPUT_STREAM);
		assertEquals("java.io.BufferedReader",JSE_IO.BUFFERED_READER);
		assertEquals("java.io.BufferedWriter",JSE_IO.BUFFERED_WRITER);
		assertEquals("java.io.ByteArrayInputStream",JSE_IO.BYTE_ARRAY_INPUT_STREAM);
		assertEquals("java.io.ByteArrayOutputStream",JSE_IO.BYTE_ARRAY_OUTPUT_STREAM);
		assertEquals("java.io.CharArrayReader",JSE_IO.CHAR_ARRAY_READER);
		assertEquals("java.io.CharArrayWriter",JSE_IO.CHAR_ARRAY_WRITER);
		assertEquals("java.io.Console",JSE_IO.CONSOLE);
		assertEquals("java.io.DataInputStream",JSE_IO.DATA_INPUT_STREAM);
		assertEquals("java.io.DataOutputStream",JSE_IO.DATA_OUTPUT_STREAM);
		assertEquals("java.io.File",JSE_IO.FILE);
		assertEquals("java.io.FileDescriptor",JSE_IO.FILE_DESCRIPTOR);
		assertEquals("java.io.FileInputStream",JSE_IO.FILE_INPUT_STREAM);
		assertEquals("java.io.FileOutputStream",JSE_IO.FILE_OUTPUT_STREAM);
		assertEquals("java.io.FilePermission",JSE_IO.FILE_PERMISSION);
		assertEquals("java.io.FileReader",JSE_IO.FILE_READER);
		assertEquals("java.io.FileWriter",JSE_IO.FILE_WRITER);
		assertEquals("java.io.FilterInputStream",JSE_IO.FILTER_INPUT_STREAM);
		assertEquals("java.io.FilterOutputStream",JSE_IO.FILTER_OUTPUT_STREAM);
		assertEquals("java.io.FilterReader",JSE_IO.FILTER_READER);
		assertEquals("java.io.FilterWriter",JSE_IO.FILTER_WRITER);
		assertEquals("java.io.InputStream",JSE_IO.INPUT_STREAM);
		assertEquals("java.io.InputStreamReader",JSE_IO.INPUT_STREAM_READER);
		assertEquals("java.io.LineNumberInputStream",JSE_IO.LINE_NUMBER_INPUT_STREAM);
		assertEquals("java.io.LineNumberReader",JSE_IO.LINE_NUMBER_READER);
		assertEquals("java.io.ObjectInputStream",JSE_IO.OBJECT_INPUT_STREAM);
		assertEquals("java.io.ObjectInputStream$GetField",JSE_IO.OBJECT_INPUT_STREAM_GET_FIELD);
		assertEquals("java.io.ObjectOutputStream",JSE_IO.OBJECT_OUTPUT_STREAM);
		assertEquals("java.io.ObjectOutputStream$PutField",JSE_IO.OBJECT_OUTPUT_STREAM_PUT_FIELD);
		assertEquals("java.io.ObjectStreamClass",JSE_IO.OBJECT_STREAM_CLASS);
		assertEquals("java.io.ObjectStreamField",JSE_IO.OBJECT_STREAM_FIELD);
		assertEquals("java.io.OutputStream",JSE_IO.OUTPUT_STREAM);
		assertEquals("java.io.OutputStreamWriter",JSE_IO.OUTPUT_STREAM_WRITER);
		assertEquals("java.io.PipedInputStream",JSE_IO.PIPED_INPUT_STREAM);
		assertEquals("java.io.PipedOutputStream",JSE_IO.PIPED_OUTPUT_STREAM);
		assertEquals("java.io.PipedReader",JSE_IO.PIPED_READER);
		assertEquals("java.io.PipedWriter",JSE_IO.PIPED_WRITER);
		assertEquals("java.io.PrintStream",JSE_IO.PRINT_STREAM);
		assertEquals("java.io.PrintWriter",JSE_IO.PRINT_WRITER);
		assertEquals("java.io.PushbackInputStream",JSE_IO.PUSHBACK_INPUT_STREAM);
		assertEquals("java.io.PushbackReader",JSE_IO.PUSHBACK_READER);
		assertEquals("java.io.RandomAccessFile",JSE_IO.RANDOM_ACCESS_FILE);
		assertEquals("java.io.Reader",JSE_IO.READER);
		assertEquals("java.io.SequenceInputStream",JSE_IO.SEQUENCE_INPUT_STREAM);
		assertEquals("java.io.SerializablePermission",JSE_IO.SERIALIZABLE_PERMISSION);
		assertEquals("java.io.StreamTokenizer",JSE_IO.STREAM_TOKENIZER);
		assertEquals("java.io.StringBufferInputStream",JSE_IO.STRING_BUFFER_INPUT_STREAM);
		assertEquals("java.io.StringReader",JSE_IO.STRING_READER);
		assertEquals("java.io.StringWriter",JSE_IO.STRING_WRITER);
		assertEquals("java.io.Writer",JSE_IO.WRITER);
		assertEquals("java.io.CharConversionException",JSE_IO.CHAR_CONVERSION_EXCEPTION);
		assertEquals("java.io.EOFException",JSE_IO.EOFEXCEPTION);
		assertEquals("java.io.FileNotFoundException",JSE_IO.FILE_NOT_FOUND_EXCEPTION);
		assertEquals("java.io.InterruptedIOException",JSE_IO.INTERRUPTED_IO_EXCEPTION);
		assertEquals("java.io.InvalidClassException",JSE_IO.INVALID_CLASS_EXCEPTION);
		assertEquals("java.io.InvalidObjectException",JSE_IO.INVALID_OBJECT_EXCEPTION);
		assertEquals("java.io.IOException",JSE_IO.IOEXCEPTION);
		assertEquals("java.io.NotActiveException",JSE_IO.NOT_ACTIVE_EXCEPTION);
		assertEquals("java.io.NotSerializableException",JSE_IO.NOT_SERIALIZABLE_EXCEPTION);
		assertEquals("java.io.ObjectStreamException",JSE_IO.OBJECT_STREAM_EXCEPTION);
		assertEquals("java.io.OptionalDataException",JSE_IO.OPTIONAL_DATA_EXCEPTION);
		assertEquals("java.io.StreamCorruptedException",JSE_IO.STREAM_CORRUPTED_EXCEPTION);
		assertEquals("java.io.SyncFailedException",JSE_IO.SYNC_FAILED_EXCEPTION);
		assertEquals("java.io.UnsupportedEncodingException",JSE_IO.UNSUPPORTED_ENCODING_EXCEPTION);
		assertEquals("java.io.UTFDataFormatException",JSE_IO.UTFDATA_FORMAT_EXCEPTION);
		assertEquals("java.io.WriteAbortedException",JSE_IO.WRITE_ABORTED_EXCEPTION);
		assertEquals("java.io.IOError",JSE_IO.IOERROR);
		assertEquals(JSE_IO.class.getName(), JSE_IO.INSTANCE.getClass().getName());
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
		int thisUniqueAsserts = 161;
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

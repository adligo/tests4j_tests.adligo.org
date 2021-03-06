package org.adligo.tests4j_v1_tests.models.shared.reference_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.I_JSE_1_6_IO;
import org.adligo.tests4j.models.shared.reference_groups.jse.v1_6.JSE_1_6_Lang;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=I_JSE_1_6_IO.class)
@AllowedReferences (groups=JSE_1_6_Lang.class)
public class I_JSE_1_6_IOTrial extends SourceFileCountingTrial {

	@Test
	public void testConstants() {
		//autogenerated by org.adligo.tests4j_tests.models.shared.dependency_group.PackageClassNameWriter
		assertEquals("java.io.Closeable",I_JSE_1_6_IO.CLOSEABLE);
		assertEquals("java.io.DataOutput",I_JSE_1_6_IO.DATA_OUTPUT);
		assertEquals("java.io.DataInput",I_JSE_1_6_IO.DATA_INPUT);
		assertEquals("java.io.Externalizable",I_JSE_1_6_IO.EXTERNALIZABLE);
		assertEquals("java.io.FileFilter",I_JSE_1_6_IO.FILE_FILTER);
		assertEquals("java.io.FilenameFilter",I_JSE_1_6_IO.FILENAME_FILTER);
		assertEquals("java.io.Flushable",I_JSE_1_6_IO.FLUSHABLE);
		assertEquals("java.io.ObjectInput",I_JSE_1_6_IO.OBJECT_INPUT);
		assertEquals("java.io.ObjectInputValidation",I_JSE_1_6_IO.OBJECT_INPUT_VALIDATION);
		assertEquals("java.io.ObjectOutput",I_JSE_1_6_IO.OBJECT_OUTPUT);
		assertEquals("java.io.ObjectStreamConstants",I_JSE_1_6_IO.OBJECT_STREAM_CONSTANTS);
		assertEquals("java.io.Serializable",I_JSE_1_6_IO.SERIALIZABLE);
		assertEquals("java.io.BufferedInputStream",I_JSE_1_6_IO.BUFFERED_INPUT_STREAM);
		assertEquals("java.io.BufferedOutputStream",I_JSE_1_6_IO.BUFFERED_OUTPUT_STREAM);
		assertEquals("java.io.BufferedReader",I_JSE_1_6_IO.BUFFERED_READER);
		assertEquals("java.io.BufferedWriter",I_JSE_1_6_IO.BUFFERED_WRITER);
		assertEquals("java.io.ByteArrayInputStream",I_JSE_1_6_IO.BYTE_ARRAY_INPUT_STREAM);
		assertEquals("java.io.ByteArrayOutputStream",I_JSE_1_6_IO.BYTE_ARRAY_OUTPUT_STREAM);
		assertEquals("java.io.CharArrayReader",I_JSE_1_6_IO.CHAR_ARRAY_READER);
		assertEquals("java.io.CharArrayWriter",I_JSE_1_6_IO.CHAR_ARRAY_WRITER);
		assertEquals("java.io.Console",I_JSE_1_6_IO.CONSOLE);
		assertEquals("java.io.DataInputStream",I_JSE_1_6_IO.DATA_INPUT_STREAM);
		assertEquals("java.io.DataOutputStream",I_JSE_1_6_IO.DATA_OUTPUT_STREAM);
		assertEquals("java.io.File",I_JSE_1_6_IO.FILE);
		assertEquals("java.io.FileDescriptor",I_JSE_1_6_IO.FILE_DESCRIPTOR);
		assertEquals("java.io.FileInputStream",I_JSE_1_6_IO.FILE_INPUT_STREAM);
		assertEquals("java.io.FileOutputStream",I_JSE_1_6_IO.FILE_OUTPUT_STREAM);
		assertEquals("java.io.FilePermission",I_JSE_1_6_IO.FILE_PERMISSION);
		assertEquals("java.io.FileReader",I_JSE_1_6_IO.FILE_READER);
		assertEquals("java.io.FileWriter",I_JSE_1_6_IO.FILE_WRITER);
		assertEquals("java.io.FilterInputStream",I_JSE_1_6_IO.FILTER_INPUT_STREAM);
		assertEquals("java.io.FilterOutputStream",I_JSE_1_6_IO.FILTER_OUTPUT_STREAM);
		assertEquals("java.io.FilterReader",I_JSE_1_6_IO.FILTER_READER);
		assertEquals("java.io.FilterWriter",I_JSE_1_6_IO.FILTER_WRITER);
		assertEquals("java.io.InputStream",I_JSE_1_6_IO.INPUT_STREAM);
		assertEquals("java.io.InputStreamReader",I_JSE_1_6_IO.INPUT_STREAM_READER);
		assertEquals("java.io.LineNumberInputStream",I_JSE_1_6_IO.LINE_NUMBER_INPUT_STREAM);
		assertEquals("java.io.LineNumberReader",I_JSE_1_6_IO.LINE_NUMBER_READER);
		assertEquals("java.io.ObjectInputStream",I_JSE_1_6_IO.OBJECT_INPUT_STREAM);
		assertEquals("java.io.ObjectInputStream$GetField",I_JSE_1_6_IO.OBJECT_INPUT_STREAM_GET_FIELD);
		assertEquals("java.io.ObjectOutputStream",I_JSE_1_6_IO.OBJECT_OUTPUT_STREAM);
		assertEquals("java.io.ObjectOutputStream$PutField",I_JSE_1_6_IO.OBJECT_OUTPUT_STREAM_PUT_FIELD);
		assertEquals("java.io.ObjectStreamClass",I_JSE_1_6_IO.OBJECT_STREAM_CLASS);
		assertEquals("java.io.ObjectStreamField",I_JSE_1_6_IO.OBJECT_STREAM_FIELD);
		assertEquals("java.io.OutputStream",I_JSE_1_6_IO.OUTPUT_STREAM);
		assertEquals("java.io.OutputStreamWriter",I_JSE_1_6_IO.OUTPUT_STREAM_WRITER);
		assertEquals("java.io.PipedInputStream",I_JSE_1_6_IO.PIPED_INPUT_STREAM);
		assertEquals("java.io.PipedOutputStream",I_JSE_1_6_IO.PIPED_OUTPUT_STREAM);
		assertEquals("java.io.PipedReader",I_JSE_1_6_IO.PIPED_READER);
		assertEquals("java.io.PipedWriter",I_JSE_1_6_IO.PIPED_WRITER);
		assertEquals("java.io.PrintStream",I_JSE_1_6_IO.PRINT_STREAM);
		assertEquals("java.io.PrintWriter",I_JSE_1_6_IO.PRINT_WRITER);
		assertEquals("java.io.PushbackInputStream",I_JSE_1_6_IO.PUSHBACK_INPUT_STREAM);
		assertEquals("java.io.PushbackReader",I_JSE_1_6_IO.PUSHBACK_READER);
		assertEquals("java.io.RandomAccessFile",I_JSE_1_6_IO.RANDOM_ACCESS_FILE);
		assertEquals("java.io.Reader",I_JSE_1_6_IO.READER);
		assertEquals("java.io.SequenceInputStream",I_JSE_1_6_IO.SEQUENCE_INPUT_STREAM);
		assertEquals("java.io.SerializablePermission",I_JSE_1_6_IO.SERIALIZABLE_PERMISSION);
		assertEquals("java.io.StreamTokenizer",I_JSE_1_6_IO.STREAM_TOKENIZER);
		assertEquals("java.io.StringBufferInputStream",I_JSE_1_6_IO.STRING_BUFFER_INPUT_STREAM);
		assertEquals("java.io.StringReader",I_JSE_1_6_IO.STRING_READER);
		assertEquals("java.io.StringWriter",I_JSE_1_6_IO.STRING_WRITER);
		assertEquals("java.io.Writer",I_JSE_1_6_IO.WRITER);
		assertEquals("java.io.CharConversionException",I_JSE_1_6_IO.CHAR_CONVERSION_EXCEPTION);
		assertEquals("java.io.EOFException",I_JSE_1_6_IO.EOFEXCEPTION);
		assertEquals("java.io.FileNotFoundException",I_JSE_1_6_IO.FILE_NOT_FOUND_EXCEPTION);
		assertEquals("java.io.InterruptedIOException",I_JSE_1_6_IO.INTERRUPTED_IO_EXCEPTION);
		assertEquals("java.io.InvalidClassException",I_JSE_1_6_IO.INVALID_CLASS_EXCEPTION);
		assertEquals("java.io.InvalidObjectException",I_JSE_1_6_IO.INVALID_OBJECT_EXCEPTION);
		assertEquals("java.io.IOException",I_JSE_1_6_IO.IOEXCEPTION);
		assertEquals("java.io.NotActiveException",I_JSE_1_6_IO.NOT_ACTIVE_EXCEPTION);
		assertEquals("java.io.NotSerializableException",I_JSE_1_6_IO.NOT_SERIALIZABLE_EXCEPTION);
		assertEquals("java.io.ObjectStreamException",I_JSE_1_6_IO.OBJECT_STREAM_EXCEPTION);
		assertEquals("java.io.OptionalDataException",I_JSE_1_6_IO.OPTIONAL_DATA_EXCEPTION);
		assertEquals("java.io.StreamCorruptedException",I_JSE_1_6_IO.STREAM_CORRUPTED_EXCEPTION);
		assertEquals("java.io.SyncFailedException",I_JSE_1_6_IO.SYNC_FAILED_EXCEPTION);
		assertEquals("java.io.UnsupportedEncodingException",I_JSE_1_6_IO.UNSUPPORTED_ENCODING_EXCEPTION);
		assertEquals("java.io.UTFDataFormatException",I_JSE_1_6_IO.UTFDATA_FORMAT_EXCEPTION);
		assertEquals("java.io.WriteAbortedException",I_JSE_1_6_IO.WRITE_ABORTED_EXCEPTION);
		assertEquals("java.io.IOError",I_JSE_1_6_IO.IOERROR);
	}
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1, true);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 80;
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
		int thisUniqueAsserts = 80;
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

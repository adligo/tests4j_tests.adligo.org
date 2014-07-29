package org.adligo.tests4j_tests.run.helpers.class_loading_mocks;

import java.io.IOException;
import java.io.InputStream;

public class MockInputStream extends InputStream {
	private IOException toThrow;
	private boolean closed = false;
	
	public MockInputStream(IOException pToThrow) {
		toThrow = pToThrow;
	}
	
	public int read() throws IOException {
		throw toThrow;
	}

	@Override
	public int read(byte[] b) throws IOException {
		throw toThrow;
	}

	@Override
	public void close() throws IOException {
		closed = true;
	}

	public boolean isClosed() {
		return closed;
	}
}

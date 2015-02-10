package org.adligo.tests4j_tests.trials_api.common;

import org.adligo.tests4j.run.common.I_JseSystem;
import org.adligo.tests4j.shared.common.DefaultSystem;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.atomic.AtomicLong;


/**
 * a dummy/mock implementation of I_SystemExit
 * mostly for mocking, but can be used to derail
 * the System.exit(0); at the end of a Tests4j trial run.
 * @author scott
 *
 */
public class SystemRunnerMock implements I_JseSystem {
	private final ArrayBlockingQueue<Integer> lastStatus = new ArrayBlockingQueue<>(10);
	private final AtomicLong time = new AtomicLong();
	private String lineSeperator;
	
	public SystemRunnerMock() {

	}
	
	public SystemRunnerMock(String pLineSepearator) {
		lineSeperator = pLineSepearator;
	}
	
	public SystemRunnerMock(List<Long> pTimes) {
	}
	
	@Override
	public void exitJvm(final int p) {
		synchronized (lastStatus) {
			lastStatus.add(p);
		}
		
	}

	public int getLastStatus() throws InterruptedException {
		return lastStatus.take();
	}

	@Override
	public void println(String p) {
		//print nothing
	}

	@Override
	public long getTime() {
		return System.currentTimeMillis();
	}

	@Override
	public String lineSeperator() {
		return lineSeperator;
	}

	@Override
	public String getCurrentThreadName() {
		return "SystemRunnerMock_" + DefaultSystem.DEFAULT_THREAD_NAME;
	}

	@Override
	public PrintStream getOut() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getJseVersion() {
		return "";
	}

	@Override
	public boolean isMainSystem() {
		return false;
	}

  @Override
  public File newFile(String path) {
    return new File(path);
  }

  @Override
  public boolean mkdir(String path) {
    // TODO Auto-generated method stub
    return false;
  }

  @Override
  public FileOutputStream newFileOutput(String path) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public FileInputStream newFileInput(String path) throws IOException {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void remove(String path) throws IOException {
    // TODO Auto-generated method stub
    
  }

  @Override
  public String getCurrentThreadGroupName() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public String getLanguage() {
    return "en";
  }

  @Override
  public void interruptCurrentThread() {
    // TODO Auto-generated method stub
    
  }


}

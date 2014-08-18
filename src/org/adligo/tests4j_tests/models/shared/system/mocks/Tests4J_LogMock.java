package org.adligo.tests4j_tests.models.shared.system.mocks;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.adligo.tests4j.shared.output.I_Tests4J_Log;

/**
 * a reusable implementation of I_Tests4J_Log
 * 
 * @author scott
 *
 */
public class Tests4J_LogMock implements I_Tests4J_Log {
	private List<String> logMessages = new ArrayList<String>();
	private List<Throwable> exceptions = new ArrayList<Throwable>();
	private Map<String, Boolean> states = new HashMap<String, Boolean>();
	private String lineSeperator = "\r\n";
	
	public void clear() {
		logMessages.clear();
		exceptions.clear();
	}
	
	public void clearStates() {
		states.clear();
	}
	
	@Override
	public void log(String p) {
		logMessages.add(p);
	}

	@Override
	public void onThrowable(Throwable p) {
		exceptions.add(p);
	}

	@Override
	public boolean isLogEnabled(Class<?> clazz) {
		String name = clazz.getName();
		Boolean toRet = states.get(name);
		if (toRet == null) {
			return false;
		}
		return toRet;
	}

	@Override
	public boolean isMainLog() {
		return false;
	}

	public int getLogMessagesSize() {
		return logMessages.size();
	}
	
	public List<String> getLogMessages() {
		return logMessages;
	}
	public String getLogMessage(int i) {
		return logMessages.get(i);
	}
	
	public int getExceptionsSize() {
		return exceptions.size();
	}
	public Throwable getException(int i) {
		return exceptions.get(i);
	}
	public List<Throwable> getExceptions() {
		return exceptions;
	}

	public int getStatesSize() {
		return states.size();
	}
	public Map<String, Boolean> getStates() {
		return states;
	}
	public void setState(Class<?> c, boolean state) {
		String logName = c.getName();
		states.put(logName, state);
	}

	public String getLineSeperator() {
		return lineSeperator;
	}
}

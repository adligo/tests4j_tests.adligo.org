package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt.v2_6;

import java.util.Set;

import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.dependency.FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_ClassAttributes;
import org.adligo.tests4j.models.shared.dependency.I_FieldSignature;
import org.adligo.tests4j.models.shared.dependency.I_MethodSignature;
import org.adligo.tests4j.models.shared.dependency.MethodSignature;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Lang;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Log;
import org.adligo.tests4j.models.shared.dependency_groups.jse.JSE_Util;
import org.adligo.tests4j.models.shared.trials.I_Trial;

public class GWT_2_6_LogDelegates extends GWT_2_6_LangDelegates {

	public GWT_2_6_LogDelegates(I_Trial p) {
		super(p);
	}

	public void delegateFormatterMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("format", 
			new String[] {JSE_Log.LOG_RECORD}, 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("formatMessage", 
			new String[] {JSE_Log.LOG_RECORD}, 
			JSE_Lang.STRING));
	}
	
	public void delegateHandlerMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("isLoggable", 
			new String[] {JSE_Log.LOG_RECORD}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("getFormatter", 
			JSE_Log.FORMATTER));
		assertContains(ms, new MethodSignature("getLevel", 
			JSE_Log.LEVEL));
		assertContains(ms, new MethodSignature("close"));
		assertContains(ms, new MethodSignature("flush"));
		assertContains(ms, new MethodSignature("publish", 
			new String[] {JSE_Log.LOG_RECORD}));
		assertContains(ms, new MethodSignature("setFormatter", 
			new String[] {JSE_Log.FORMATTER}));
		assertContains(ms, new MethodSignature("setLevel", 
			new String[] {JSE_Log.LEVEL}));
	}
	
	public void delegateLevelMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		assertContains(fs, new FieldSignature("ALL", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("CONFIG", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("FINE", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("FINER", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("FINEST", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("INFO", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("OFF", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("SEVERE", JSE_Log.LEVEL));
		assertContains(fs, new FieldSignature("WARNING", JSE_Log.LEVEL));
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("equals", 
			new String[] {JSE_Lang.OBJECT}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("intValue", 
			ClassMethods.INT));
		assertContains(ms, new MethodSignature("getName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("parse", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Log.LEVEL));
	}
	
	public void delegateLogManagerMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("addLogger", 
			new String[] {JSE_Log.LOGGER}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("getLoggerNames", 
			JSE_Util.ENUMERATION));
		assertContains(ms, new MethodSignature("getLogManager", 
			JSE_Log.LOG_MANAGER));
		assertContains(ms, new MethodSignature("getLogger", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Log.LOGGER));
	}
	
	public void delegateLogRecordMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_MethodSignature> ms = result.getMethods();
		
		assertContains(ms, new MethodSignature("getLoggerName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getMessage", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getThrown", 
			JSE_Lang.THROWABLE));
		assertContains(ms, new MethodSignature("getLevel", 
			JSE_Log.LEVEL));
		assertContains(ms, new MethodSignature("getMillis", 
			ClassMethods.LONG));
		assertContains(ms, new MethodSignature("setLevel", 
			new String[] {JSE_Log.LEVEL}));
		assertContains(ms, new MethodSignature("setLoggerName", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("setMessage", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("setMillis", 
			new String[] {ClassMethods.LONG}));
		assertContains(ms, new MethodSignature("setThrown", 
			new String[] {JSE_Lang.THROWABLE}));
	}
	
	public void delegateLoggerMemberAsserts(I_ClassAttributes result) {
		delegateObjectMemberAsserts(result);
		Set<I_FieldSignature> fs = result.getFields();
		
		Set<I_MethodSignature> ms = result.getMethods();
		assertContains(ms, new MethodSignature("getHandlers", 
			"[" + JSE_Log.HANDLER));
		assertContains(ms, new MethodSignature("getUseParentHandlers", 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("isLoggable", 
			new String[] {JSE_Log.LEVEL}, 
			ClassMethods.BOOLEAN));
		assertContains(ms, new MethodSignature("getName", 
			JSE_Lang.STRING));
		assertContains(ms, new MethodSignature("getLevel", 
			JSE_Log.LEVEL));
		assertContains(ms, new MethodSignature("getLogger", 
			new String[] {JSE_Lang.STRING}, 
			JSE_Log.LOGGER));
		assertContains(ms, new MethodSignature("getParent", 
			JSE_Log.LOGGER));
		assertContains(ms, new MethodSignature("addHandler", 
			new String[] {JSE_Log.HANDLER}));
		assertContains(ms, new MethodSignature("config", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("fine", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("finer", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("finest", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("info", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("log", 
			new String[] {JSE_Log.LEVEL, JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("log", 
			new String[] {JSE_Log.LEVEL, JSE_Lang.STRING, JSE_Lang.THROWABLE}));
		assertContains(ms, new MethodSignature("log", 
			new String[] {JSE_Log.LOG_RECORD}));
		assertContains(ms, new MethodSignature("removeHandler", 
			new String[] {JSE_Log.HANDLER}));
		assertContains(ms, new MethodSignature("setLevel", 
			new String[] {JSE_Log.LEVEL}));
		assertContains(ms, new MethodSignature("setParent", 
			new String[] {JSE_Log.LOGGER}));
		assertContains(ms, new MethodSignature("setUseParentHandlers", 
			new String[] {ClassMethods.BOOLEAN}));
		assertContains(ms, new MethodSignature("severe", 
			new String[] {JSE_Lang.STRING}));
		assertContains(ms, new MethodSignature("warning", 
			new String[] {JSE_Lang.STRING}));
	}
}

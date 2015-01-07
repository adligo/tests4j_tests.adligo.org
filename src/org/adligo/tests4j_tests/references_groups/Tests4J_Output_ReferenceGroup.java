package org.adligo.tests4j_tests.references_groups;

import org.adligo.tests4j.shared.output.ByteListOutputStream;
import org.adligo.tests4j.shared.output.DefaultLog;
import org.adligo.tests4j.shared.output.DelegatingLog;
import org.adligo.tests4j.shared.output.I_ConcurrentOutputDelegator;
import org.adligo.tests4j.shared.output.I_OutputBuffer;
import org.adligo.tests4j.shared.output.I_OutputDelegateor;
import org.adligo.tests4j.shared.output.I_Tests4J_Log;
import org.adligo.tests4j.shared.output.ListDelegateOutputBuffer;
import org.adligo.tests4j.shared.output.PrintStreamOutputBuffer;
import org.adligo.tests4j.shared.output.SafeOutputStreamBuffer;

import java.util.HashSet;
import java.util.Set;

/**
 * @diagram_sync with PackageDependencies.class on 10/1/1014
 * @author scott
 *
 */
public class Tests4J_Output_ReferenceGroup extends Tests4J_ReferenceGroup {
	public static final Tests4J_Output_ReferenceGroup INSTANCE = new Tests4J_Output_ReferenceGroup();
	
	private Tests4J_Output_ReferenceGroup() {
		Set<String> names = new HashSet<String>();
		
		add(names, ByteListOutputStream.class);
		add(names, DefaultLog.class);
		add(names, DelegatingLog.class);
		
		add(names, I_ConcurrentOutputDelegator.class);
		add(names, I_OutputBuffer.class);
		add(names, I_OutputBuffer.class);
		add(names, I_OutputDelegateor.class);
		add(names, I_Tests4J_Log.class);
		add(names, ByteListOutputStream.class);
		
		add(names, ListDelegateOutputBuffer.class);
		add(names, PrintStreamOutputBuffer.class);
		add(names, SafeOutputStreamBuffer.class);
		
		names.addAll(Tests4J_I18N_ReferenceGroup.INSTANCE.getClassNames());
		names.addAll(Tests4J_Common_ReferenceGroup.INSTANCE.getClassNames());
		
		setupDelegates(names);
	}
	
	private void add(Set<String> names, Class<?> c) {
		names.add(c.getName());
	}
}

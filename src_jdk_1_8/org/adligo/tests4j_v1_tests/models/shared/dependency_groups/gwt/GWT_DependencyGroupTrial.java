package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.gwt;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.annotation.AnnotationFormatError;
import java.lang.annotation.AnnotationTypeMismatchException;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.IncompleteAnnotationException;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.AbstractCollection;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSequentialList;
import java.util.AbstractSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.EnumMap;
import java.util.EnumSet;
import java.util.Enumeration;
import java.util.EventListener;
import java.util.EventObject;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.MissingResourceException;
import java.util.NoSuchElementException;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Random;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.Stack;
import java.util.TooManyListenersException;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.Vector;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogManager;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

import org.adligo.tests4j.models.shared.dependency_groups.gwt.GWT_DependencyGroup;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_GWT_DependencyGroup;

@SourceFileScope (sourceClass=GWT_DependencyGroup.class,minCoverage=90.0)
@AllowedDependencies (groups=Tests4J_GWT_DependencyGroup.class)
public class GWT_DependencyGroupTrial extends SourceFileCountingTrial {

	@Test
	public void testClassNames() {
		Set<String> classes = new GWT_DependencyGroup().getClassNames();
		assertLang(classes);
		assertLangAnnotation(classes);
		assertMath(classes);
		assertIO(classes);
		assertSQL(classes);
		assertUtil(classes);
		assertLog(classes);
		assertEquals(121, classes.size());
	}
	
	private void assertLang(Set<String> classes) {
		assertContains(classes,Appendable.class.getName());
		assertContains(classes,ArithmeticException.class.getName());
		assertContains(classes,ArrayIndexOutOfBoundsException.class.getName());
		assertContains(classes,ArrayStoreException.class.getName());
		assertContains(classes,AssertionError.class.getName());
		assertContains(classes,AutoCloseable.class.getName());
		assertContains(classes,Boolean.class.getName());
		assertContains(classes,Byte.class.getName());
		assertContains(classes,CharSequence.class.getName());
		assertContains(classes,Character.class.getName());
		assertContains(classes,Class.class.getName());
		assertContains(classes,ClassCastException.class.getName());
		assertContains(classes,Cloneable.class.getName());
		assertContains(classes,Comparable.class.getName());
		assertContains(classes,Deprecated.class.getName());
		assertContains(classes,Double.class.getName());
		assertContains(classes,Enum.class.getName());
		assertContains(classes,Error.class.getName());
		assertContains(classes,Exception.class.getName());
		assertContains(classes,Float.class.getName());
		assertContains(classes,IllegalArgumentException.class.getName());
		assertContains(classes,IllegalStateException.class.getName());
		assertContains(classes,IndexOutOfBoundsException.class.getName());
		assertContains(classes,Integer.class.getName());
		assertContains(classes,Iterable.class.getName());
		assertContains(classes,Long.class.getName());
		assertContains(classes,Math.class.getName());
		assertContains(classes,NegativeArraySizeException.class.getName());
		assertContains(classes,NoSuchMethodException.class.getName());
		assertContains(classes,NullPointerException.class.getName());
		assertContains(classes,Number.class.getName());
		assertContains(classes,NumberFormatException.class.getName());
		assertContains(classes,Object.class.getName());
		assertContains(classes,Runnable.class.getName());
		assertContains(classes,RuntimeException.class.getName());
		assertContains(classes,Short.class.getName());
		assertContains(classes,StackTraceElement.class.getName());
		assertContains(classes,String.class.getName());
		assertContains(classes,StringBuffer.class.getName());
		assertContains(classes,StringBuilder.class.getName());
		assertContains(classes,StringIndexOutOfBoundsException.class.getName());
		assertContains(classes,SuppressWarnings.class.getName());
		assertContains(classes,System.class.getName());
		assertContains(classes,Throwable.class.getName());
		assertContains(classes,UnsupportedOperationException.class.getName());
		assertContains(classes,Void.class.getName());
	}
	
	private void assertLangAnnotation(Set<String> classes) {
		assertContains(classes,Annotation.class.getName());
		assertContains(classes,AnnotationFormatError.class.getName());
		assertContains(classes,AnnotationTypeMismatchException.class.getName());
		assertContains(classes,Documented.class.getName());
		assertContains(classes,ElementType.class.getName());
		assertContains(classes,IncompleteAnnotationException.class.getName());
		assertContains(classes,Inherited.class.getName());
		assertContains(classes,Retention.class.getName());
		assertContains(classes,RetentionPolicy.class.getName());
		assertContains(classes,Target.class.getName());
	}
	
	private void assertMath(Set<String> classes) {
		assertContains(classes,BigDecimal.class.getName());
		assertContains(classes,BigInteger.class.getName());
		assertContains(classes,MathContext.class.getName());
		assertContains(classes,RoundingMode.class.getName());
	}
	
	private void assertIO(Set<String> classes) {
		assertContains(classes,FilterOutputStream.class.getName());
		assertContains(classes,IOException.class.getName());
		assertContains(classes,OutputStream.class.getName());
		assertContains(classes,PrintStream.class.getName());
		assertContains(classes,Serializable.class.getName());
		assertContains(classes,UnsupportedEncodingException.class.getName());
	}
	
	private void assertSQL(Set<String> classes) {
		assertContains(classes,Date.class.getName());
		assertContains(classes,Time.class.getName());
		assertContains(classes,Timestamp.class.getName());
	}
	
	private void assertUtil(Set<String> classes) {
		assertContains(classes,AbstractCollection.class.getName());
		assertContains(classes,AbstractList.class.getName());
		assertContains(classes,AbstractMap.class.getName());
		assertContains(classes,AbstractQueue.class.getName());
		assertContains(classes,AbstractSequentialList.class.getName());
		assertContains(classes,AbstractSet.class.getName());
		assertContains(classes,ArrayList.class.getName());
		assertContains(classes,Arrays.class.getName());
		assertContains(classes,Collection.class.getName());
		assertContains(classes,Collections.class.getName());
		assertContains(classes,Comparator.class.getName());
		assertContains(classes,ConcurrentModificationException.class.getName());
		assertContains(classes,java.util.Date.class.getName());
		assertContains(classes,Entry.class.getName());
		assertContains(classes,EnumMap.class.getName());
		assertContains(classes,EnumSet.class.getName());
		assertContains(classes,Enumeration.class.getName());
		assertContains(classes,EventListener.class.getName());
		assertContains(classes,EventObject.class.getName());
		assertContains(classes,HashMap.class.getName());
		assertContains(classes,HashSet.class.getName());
		assertContains(classes,IdentityHashMap.class.getName());
		assertContains(classes,Iterator.class.getName());
		assertContains(classes,LinkedHashMap.class.getName());
		assertContains(classes,LinkedHashSet.class.getName());
		assertContains(classes,LinkedList.class.getName());
		assertContains(classes,List.class.getName());
		assertContains(classes,ListIterator.class.getName());
		assertContains(classes,Map.class.getName());
		assertContains(classes,MissingResourceException.class.getName());
		assertContains(classes,NoSuchElementException.class.getName());
		assertContains(classes,PriorityQueue.class.getName());
		assertContains(classes,Queue.class.getName());
		assertContains(classes,Random.class.getName());
		assertContains(classes,RandomAccess.class.getName());
		assertContains(classes,Set.class.getName());
		assertContains(classes,SortedMap.class.getName());
		assertContains(classes,Stack.class.getName());
		assertContains(classes,TooManyListenersException.class.getName());
		assertContains(classes,TreeMap.class.getName());
		assertContains(classes,TreeSet.class.getName());
		assertContains(classes,Vector.class.getName());
	}
	
	private void assertLog(Set<String> classes) {
		assertContains(classes,Formatter.class.getName());
		assertContains(classes,Handler.class.getName());
		assertContains(classes,Level.class.getName());
		assertContains(classes,LogManager.class.getName());
		assertContains(classes,LogRecord.class.getName());
		assertContains(classes,Logger.class.getName());

	}
	//keep at bottom
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 118;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 3);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 118;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

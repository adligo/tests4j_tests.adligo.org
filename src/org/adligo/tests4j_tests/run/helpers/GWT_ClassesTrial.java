package org.adligo.tests4j_tests.run.helpers;

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

import org.adligo.tests4j.run.helpers.GWT_Classes;
import org.adligo.tests4j.shared.asserts.reference.AllowedReferences;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.references_groups.Tests4J_Gwt_GwtReferenceGroup;

@SourceFileScope (sourceClass=GWT_Classes.class,minCoverage=90.0)
@AllowedReferences (groups=Tests4J_Gwt_GwtReferenceGroup.class)
public class GWT_ClassesTrial extends SourceFileCountingTrial {

	@Test
	public void testLang() {
		Set<Class<?>> classes = GWT_Classes.JAVA_LANG;
		assertContains(classes,Appendable.class);
		assertContains(classes,ArithmeticException.class);
		assertContains(classes,ArrayIndexOutOfBoundsException.class);
		assertContains(classes,ArrayStoreException.class);
		assertContains(classes,AssertionError.class);
		assertContains(classes,AutoCloseable.class);
		assertContains(classes,Boolean.class);
		assertContains(classes,Byte.class);
		assertContains(classes,CharSequence.class);
		assertContains(classes,Character.class);
		assertContains(classes,Class.class);
		assertContains(classes,ClassCastException.class);
		assertContains(classes,Cloneable.class);
		assertContains(classes,Comparable.class);
		assertContains(classes,Deprecated.class);
		assertContains(classes,Double.class);
		assertContains(classes,Enum.class);
		assertContains(classes,Error.class);
		assertContains(classes,Exception.class);
		assertContains(classes,Float.class);
		assertContains(classes,IllegalArgumentException.class);
		assertContains(classes,IllegalStateException.class);
		assertContains(classes,IndexOutOfBoundsException.class);
		assertContains(classes,Integer.class);
		assertContains(classes,Iterable.class);
		assertContains(classes,Long.class);
		assertContains(classes,Math.class);
		assertContains(classes,NegativeArraySizeException.class);
		assertContains(classes,NoSuchMethodException.class);
		assertContains(classes,NullPointerException.class);
		assertContains(classes,Number.class);
		assertContains(classes,NumberFormatException.class);
		assertContains(classes,Object.class);
		assertContains(classes,Runnable.class);
		assertContains(classes,RuntimeException.class);
		assertContains(classes,Short.class);
		assertContains(classes,StackTraceElement.class);
		assertContains(classes,String.class);
		assertContains(classes,StringBuffer.class);
		assertContains(classes,StringBuilder.class);
		assertContains(classes,StringIndexOutOfBoundsException.class);
		assertContains(classes,SuppressWarnings.class);
		assertContains(classes,System.class);
		assertContains(classes,Throwable.class);
		assertContains(classes,UnsupportedOperationException.class);
		assertContains(classes,Void.class);
		assertEquals(46,classes.size());
	}
	
	@Test
	public void testLangAnnotation() {
		Set<Class<?>> classes = GWT_Classes.JAVA_ANNOTATION;
		assertContains(classes,Annotation.class);
		assertContains(classes,AnnotationFormatError.class);
		assertContains(classes,AnnotationTypeMismatchException.class);
		assertContains(classes,Documented.class);
		assertContains(classes,ElementType.class);
		assertContains(classes,IncompleteAnnotationException.class);
		assertContains(classes,Inherited.class);
		assertContains(classes,Retention.class);
		assertContains(classes,RetentionPolicy.class);
		assertContains(classes,Target.class);
		assertEquals(10,classes.size());
	}
	
	@Test
	public void testMath() {
		Set<Class<?>> classes = GWT_Classes.JAVA_MATH;
		assertContains(classes,BigDecimal.class);
		assertContains(classes,BigInteger.class);
		assertContains(classes,MathContext.class);
		assertContains(classes,RoundingMode.class);
		assertEquals(4,classes.size());
	}
	
	@Test
	public void testIO() {
		Set<Class<?>> classes = GWT_Classes.JAVA_IO;
		assertContains(classes,FilterOutputStream.class);
		assertContains(classes,IOException.class);
		assertContains(classes,OutputStream.class);
		assertContains(classes,PrintStream.class);
		assertContains(classes,Serializable.class);
		assertContains(classes,UnsupportedEncodingException.class);
		assertEquals(6,classes.size());
	}
	
	@Test
	public void testSQL() {
		Set<Class<?>> classes = GWT_Classes.JAVA_SQL;
		assertContains(classes,Date.class);
		assertContains(classes,Time.class);
		assertContains(classes,Timestamp.class);
		assertEquals(3,classes.size());
	}
	
	@Test
	public void testUtil() {
		Set<Class<?>> classes = GWT_Classes.JAVA_UTIL;
		assertContains(classes,AbstractCollection.class);
		assertContains(classes,AbstractList.class);
		assertContains(classes,AbstractMap.class);
		assertContains(classes,AbstractQueue.class);
		assertContains(classes,AbstractSequentialList.class);
		assertContains(classes,AbstractSet.class);
		assertContains(classes,ArrayList.class);
		assertContains(classes,Arrays.class);
		assertContains(classes,Collection.class);
		assertContains(classes,Collections.class);
		assertContains(classes,Comparator.class);
		assertContains(classes,ConcurrentModificationException.class);
		assertContains(classes,java.util.Date.class);
		assertContains(classes,Entry.class);
		assertContains(classes,EnumMap.class);
		assertContains(classes,EnumSet.class);
		assertContains(classes,Enumeration.class);
		assertContains(classes,EventListener.class);
		assertContains(classes,EventObject.class);
		assertContains(classes,HashMap.class);
		assertContains(classes,HashSet.class);
		assertContains(classes,IdentityHashMap.class);
		assertContains(classes,Iterator.class);
		assertContains(classes,LinkedHashMap.class);
		assertContains(classes,LinkedHashSet.class);
		assertContains(classes,LinkedList.class);
		assertContains(classes,List.class);
		assertContains(classes,ListIterator.class);
		assertContains(classes,Map.class);
		assertContains(classes,MissingResourceException.class);
		assertContains(classes,NoSuchElementException.class);
		assertContains(classes,PriorityQueue.class);
		assertContains(classes,Queue.class);
		assertContains(classes,Random.class);
		assertContains(classes,RandomAccess.class);
		assertContains(classes,Set.class);
		assertContains(classes,SortedMap.class);
		assertContains(classes,Stack.class);
		assertContains(classes,TooManyListenersException.class);
		assertContains(classes,TreeMap.class);
		assertContains(classes,TreeSet.class);
		assertContains(classes,Vector.class);

		assertEquals(42,classes.size());
	}
	
	@Test
	public void testLog() {
		Set<Class<?>> classes = GWT_Classes.JAVA_LOGGING;
		assertContains(classes,Formatter.class);
		assertContains(classes,Handler.class);
		assertContains(classes,Level.class);
		assertContains(classes,LogManager.class);
		assertContains(classes,LogRecord.class);
		assertContains(classes,Logger.class);

		assertEquals(6,classes.size());
	}
	//keep at bottom
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 7);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 124;
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
		int thisUniqueAsserts = 124;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getUniqueAsserts(type, thisUniqueAsserts + 3);
		}  else {
			return super.getUniqueAsserts(type, thisUniqueAsserts);
		}
	}
}

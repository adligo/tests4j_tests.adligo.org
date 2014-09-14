package org.adligo.tests4j_tests.models.dependency_groups;

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

import org.adligo.tests4j.models.shared.common.CacheControl;
import org.adligo.tests4j.models.shared.common.ClassMethods;
import org.adligo.tests4j.models.shared.common.DefaultSystem;
import org.adligo.tests4j.models.shared.common.DelegateSystem;
import org.adligo.tests4j.models.shared.common.I_CacheControl;
import org.adligo.tests4j.models.shared.common.I_Immutable;
import org.adligo.tests4j.models.shared.common.I_Platform;
import org.adligo.tests4j.models.shared.common.I_PlatformContainer;
import org.adligo.tests4j.models.shared.common.I_System;
import org.adligo.tests4j.models.shared.common.I_TrialType;
import org.adligo.tests4j.models.shared.common.JavaAPIVersion;
import org.adligo.tests4j.models.shared.common.LegacyAPI_Issues;
import org.adligo.tests4j.models.shared.common.MethodBlocker;
import org.adligo.tests4j.models.shared.common.Platform;
import org.adligo.tests4j.models.shared.common.StackTraceBuilder;
import org.adligo.tests4j.models.shared.common.StringMethods;
import org.adligo.tests4j.models.shared.common.SystemWithPrintStreamDelegate;
import org.adligo.tests4j.models.shared.common.Tests4J_System;
import org.adligo.tests4j.models.shared.common.TrialType;
import org.adligo.tests4j.models.shared.dependency.DependencyGroupBaseDelegate;
import org.adligo.tests4j.models.shared.dependency_groups.adligo.Tests4J_Common_DependencyGroup;
import org.adligo.tests4j.models.shared.trials.SourceFileScope;
import org.adligo.tests4j.models.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

@SourceFileScope (sourceClass=Tests4J_Common_DependencyGroup.class)
public class Tests4J_Common_DependencyGroupTrial extends SourceFileCountingTrial {


	@Test
	public void testClassNames() {
		Tests4J_Common_DependencyGroup dg = new Tests4J_Common_DependencyGroup();
		assertTrue(dg instanceof DependencyGroupBaseDelegate);
		Set<String> classes = dg.getClassNames();
		assertContains(classes,CacheControl.class.getName());
		assertContains(classes,ClassMethods.class.getName());
		assertContains(classes,DefaultSystem.class.getName());
		assertContains(classes,DelegateSystem.class.getName());
		assertContains(classes,I_CacheControl.class.getName());
		assertContains(classes,I_Immutable.class.getName());
		assertContains(classes,I_Platform.class.getName());
		assertContains(classes,I_PlatformContainer.class.getName());
		assertContains(classes,I_System.class.getName());
		assertContains(classes,I_TrialType.class.getName());
		assertContains(classes,JavaAPIVersion.class.getName());
		
		assertContains(classes,LegacyAPI_Issues.class.getName());
		assertContains(classes,MethodBlocker.class.getName());
		assertContains(classes,Platform.class.getName());
		assertContains(classes,StackTraceBuilder.class.getName());
		assertContains(classes,StringMethods.class.getName());
		assertContains(classes,SystemWithPrintStreamDelegate.class.getName());
		assertContains(classes,Tests4J_System.class.getName());
		assertContains(classes,TrialType.class.getName());
		assertEquals(19, classes.size());
	}
	
	
	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 108;
		if (type.isFromMetaWithCoverage()) {
			//code coverage and circular dependencies +
			//custom afterTrialTests
			return super.getAsserts(type, thisAsserts + 2);
		} else {
			return super.getAsserts(type, thisAsserts);
		}
	}

	@Override
	public int getUniqueAsserts(I_CountType type) {
		int thisUniqueAsserts = 108;
		if (type.isFromMetaWithCoverage()) {
			return super.getUniqueAsserts(type, thisUniqueAsserts + 2);
		}  else {
			return super.getAsserts(type, thisUniqueAsserts);
		}
	}
}

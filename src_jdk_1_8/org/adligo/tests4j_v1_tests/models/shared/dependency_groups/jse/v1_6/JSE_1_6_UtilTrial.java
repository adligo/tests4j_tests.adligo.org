package org.adligo.tests4j_v1_tests.models.shared.dependency_groups.jse.v1_6;

import org.adligo.tests4j.models.shared.dependency_groups.jse.v1_6.JSE_1_6_Util;
import org.adligo.tests4j.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.shared.asserts.dependency.AllowedDependencies;
import org.adligo.tests4j.shared.asserts.dependency.I_DependencyGroup;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;
import org.adligo.tests4j_tests.dependency_groups.Tests4J_JSE_v1_6_DependencyGroup;

@SourceFileScope (sourceClass=JSE_1_6_Util.class,minCoverage=91.0)
@AllowedDependencies (groups={Tests4J_JSE_v1_6_DependencyGroup.class})
public class JSE_1_6_UtilTrial extends SourceFileCountingTrial {

	@Test
	public void testSingletonClasses() {
		delegateSingletonClassAsserts(this, JSE_1_6_Util.INSTANCE);
	}
			
	public static void delegateSingletonClassAsserts(I_Asserts asserts, I_DependencyGroup dg) {
		asserts.assertTrue(dg.isInGroup("java.util.Collection"));
		asserts.assertTrue(dg.isInGroup("java.util.Comparator"));
		asserts.assertTrue(dg.isInGroup("java.util.Deque"));
		asserts.assertTrue(dg.isInGroup("java.util.Enumeration"));
		asserts.assertTrue(dg.isInGroup("java.util.EventListener"));
		asserts.assertTrue(dg.isInGroup("java.util.Formattable"));
		asserts.assertTrue(dg.isInGroup("java.util.Iterator"));
		asserts.assertTrue(dg.isInGroup("java.util.List"));
		asserts.assertTrue(dg.isInGroup("java.util.ListIterator"));
		asserts.assertTrue(dg.isInGroup("java.util.Map"));
		asserts.assertTrue(dg.isInGroup("java.util.Map$Entry"));
		asserts.assertTrue(dg.isInGroup("java.util.NavigableMap"));
		asserts.assertTrue(dg.isInGroup("java.util.NavigableSet"));
		asserts.assertTrue(dg.isInGroup("java.util.Observer"));
		asserts.assertTrue(dg.isInGroup("java.util.Queue"));
		asserts.assertTrue(dg.isInGroup("java.util.RandomAccess"));
		asserts.assertTrue(dg.isInGroup("java.util.Set"));
		asserts.assertTrue(dg.isInGroup("java.util.SortedMap"));
		asserts.assertTrue(dg.isInGroup("java.util.SortedSet"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractCollection"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractList"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractMap"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractMap$SimpleEntry"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractMap$SimpleImmutableEntry"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractQueue"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractSequentialList"));
		asserts.assertTrue(dg.isInGroup("java.util.AbstractSet"));
		asserts.assertTrue(dg.isInGroup("java.util.ArrayDeque"));
		asserts.assertTrue(dg.isInGroup("java.util.ArrayList"));
		asserts.assertTrue(dg.isInGroup("java.util.Arrays"));
		asserts.assertTrue(dg.isInGroup("java.util.BitSet"));
		asserts.assertTrue(dg.isInGroup("java.util.Calendar"));
		asserts.assertTrue(dg.isInGroup("java.util.Collections"));
		asserts.assertTrue(dg.isInGroup("java.util.Currency"));
		asserts.assertTrue(dg.isInGroup("java.util.Date"));
		asserts.assertTrue(dg.isInGroup("java.util.Dictionary"));
		asserts.assertTrue(dg.isInGroup("java.util.EnumMap"));
		asserts.assertTrue(dg.isInGroup("java.util.EnumSet"));
		asserts.assertTrue(dg.isInGroup("java.util.EventListenerProxy"));
		asserts.assertTrue(dg.isInGroup("java.util.EventObject"));
		asserts.assertTrue(dg.isInGroup("java.util.FormattableFlags"));
		asserts.assertTrue(dg.isInGroup("java.util.Formatter"));
		asserts.assertTrue(dg.isInGroup("java.util.GregorianCalendar"));
		asserts.assertTrue(dg.isInGroup("java.util.HashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.HashSet"));
		asserts.assertTrue(dg.isInGroup("java.util.Hashtable"));
		asserts.assertTrue(dg.isInGroup("java.util.IdentityHashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.LinkedHashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.LinkedHashSet"));
		asserts.assertTrue(dg.isInGroup("java.util.ListResourceBundle"));
		asserts.assertTrue(dg.isInGroup("java.util.Locale"));
		asserts.assertTrue(dg.isInGroup("java.util.Locale$Builder"));
		asserts.assertTrue(dg.isInGroup("java.util.Objects"));
		asserts.assertTrue(dg.isInGroup("java.util.Observable"));
		asserts.assertTrue(dg.isInGroup("java.util.PriorityQueue"));
		asserts.assertTrue(dg.isInGroup("java.util.Properties"));
		asserts.assertTrue(dg.isInGroup("java.util.PropertyPermission"));
		asserts.assertTrue(dg.isInGroup("java.util.PropertyResourceBundle"));
		asserts.assertTrue(dg.isInGroup("java.util.Random"));
		asserts.assertTrue(dg.isInGroup("java.util.ResourceBundle"));
		asserts.assertTrue(dg.isInGroup("java.util.ResourceBundle$Control"));
		asserts.assertTrue(dg.isInGroup("java.util.Scanner"));
		asserts.assertTrue(dg.isInGroup("java.util.ServiceLoader"));
		asserts.assertTrue(dg.isInGroup("java.util.SimpleTimeZone"));
		asserts.assertTrue(dg.isInGroup("java.util.Stack"));
		asserts.assertTrue(dg.isInGroup("java.util.StringTokenizer"));
		asserts.assertTrue(dg.isInGroup("java.util.Timer"));
		asserts.assertTrue(dg.isInGroup("java.util.TimerTask"));
		asserts.assertTrue(dg.isInGroup("java.util.TimeZone"));
		asserts.assertTrue(dg.isInGroup("java.util.TreeMap"));
		asserts.assertTrue(dg.isInGroup("java.util.TreeSet"));
		asserts.assertTrue(dg.isInGroup("java.util.UUID"));
		asserts.assertTrue(dg.isInGroup("java.util.Vector"));
		asserts.assertTrue(dg.isInGroup("java.util.WeakHashMap"));
		asserts.assertTrue(dg.isInGroup("java.util.Formatter$BigDecimalLayoutForm"));
		asserts.assertTrue(dg.isInGroup("java.util.Locale$Category"));
		asserts.assertTrue(dg.isInGroup("java.util.ConcurrentModificationException"));
		asserts.assertTrue(dg.isInGroup("java.util.DuplicateFormatFlagsException"));
		asserts.assertTrue(dg.isInGroup("java.util.EmptyStackException"));
		asserts.assertTrue(dg.isInGroup("java.util.FormatFlagsConversionMismatchException"));
		asserts.assertTrue(dg.isInGroup("java.util.FormatterClosedException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatCodePointException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatConversionException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatFlagsException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatPrecisionException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllegalFormatWidthException"));
		asserts.assertTrue(dg.isInGroup("java.util.IllformedLocaleException"));
		asserts.assertTrue(dg.isInGroup("java.util.InputMismatchException"));
		asserts.assertTrue(dg.isInGroup("java.util.InvalidPropertiesFormatException"));
		asserts.assertTrue(dg.isInGroup("java.util.MissingFormatArgumentException"));
		asserts.assertTrue(dg.isInGroup("java.util.MissingFormatWidthException"));
		asserts.assertTrue(dg.isInGroup("java.util.MissingResourceException"));
		asserts.assertTrue(dg.isInGroup("java.util.NoSuchElementException"));
		asserts.assertTrue(dg.isInGroup("java.util.TooManyListenersException"));
		asserts.assertTrue(dg.isInGroup("java.util.UnknownFormatFlagsException"));
		asserts.assertTrue(dg.isInGroup("java.util.ServiceConfigurationError"));


	}

	@Override
	public int getTests(I_CountType type) {
		return super.getTests(type, 1);
	}

	@Override
	public int getAsserts(I_CountType type) {
		int thisAsserts = 97;
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
		int thisUniqueAsserts = 1;
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

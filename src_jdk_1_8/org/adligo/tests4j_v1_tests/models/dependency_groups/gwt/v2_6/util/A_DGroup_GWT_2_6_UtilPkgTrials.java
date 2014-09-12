package org.adligo.tests4j_v1_tests.models.dependency_groups.gwt.v2_6.util;

import org.adligo.tests4j.models.shared.system.Tests4J_Params;
import org.adligo.tests4j.models.shared.trials.I_TrialParams;
import org.adligo.tests4j.run.Tests4J;
import org.adligo.tests4j_4jacoco.plugin.CoveragePluginFactory;
import org.adligo.tests4j_tests.base_trials.I_CountingPackageTrials;
import org.adligo.tests4j_tests.base_trials.SimpleMetaTrial;
import org.adligo.tests4j_tests.base_trials.SimplePackageTrials;

public class A_DGroup_GWT_2_6_UtilPkgTrials extends SimplePackageTrials 
implements I_TrialParams<A_DGroup_GWT_2_6_UtilPkgTrials>, I_CountingPackageTrials {

	
	public static void main(String [] args) {
		try {
			Tests4J_Params params = new Tests4J_Params();
			params.setCoveragePluginFactoryClass(CoveragePluginFactory.class);
			params.setMetaTrialClass(SimpleMetaTrial.class);
			
			A_DGroup_GWT_2_6_UtilPkgTrials me = new A_DGroup_GWT_2_6_UtilPkgTrials();
			me.setParams(params);
			me.addTrials();
			params.addTrials(me);
			params.setMetaTrialParams(me);
		
			//params.addTest(new Tests4J_Selection(ClassReferencesTrial.class, "testGetsSetsAndConstructor"));
			Tests4J.run(params);
		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public void addTrials() throws Exception {
		add(ConcurrentModificationException_2_6_UseTrial.class);
		add(EmptyStackException_2_6_UseTrial.class);
		add(MissingResourceException_2_6_UseTrial.class);
		add(NoSuchElementException_2_6_UseTrial.class);
		add(TooManyListenersException_2_6_UseTrial.class);
		
		add(Date_2_6_UseTrial.class);
		add(AbstractCollection_2_6_UseTrial.class);
		add(AbstractList_2_6_UseTrial.class);
		add(AbstractMap_2_6_UseTrial.class);
		add(AbstractQueue_2_6_UseTrial.class);
		
		add(AbstractSequentialList_2_6_UseTrial.class);
		add(AbstractSet_2_6_UseTrial.class);
		add(ArrayList_2_6_UseTrial.class);
		add(Arrays_2_6_UseTrial.class);
		
		add(Collections_2_6_UseTrial.class);
		add(Collection_2_6_UseTrial.class);
		add(Comparator_2_6_UseTrial.class);
		
		add(EnumMap_2_6_UseTrial.class);
		add(EnumSet_2_6_UseTrial.class);
		
		add(Enumeration_2_6_UseTrial.class);
		add(EventListener_2_6_UseTrial.class);
		add(EventObject_2_6_UseTrial.class);
		add(HashMap_2_6_UseTrial.class);
		
		add(HashSet_2_6_UseTrial.class);
		add(IdentityHashMap_2_6_UseTrial.class);
		add(Iterator_2_6_UseTrial.class);
		add(LinkedHashMap_2_6_UseTrial.class);
		
		add(LinkedHashSet_2_6_UseTrial.class);
		add(LinkedList_2_6_UseTrial.class);
		add(List_2_6_UseTrial.class);
		add(ListIterator_2_6_UseTrial.class);
		
		add(Map_2_6_UseTrial.class);
		add(MapEntry_2_6_UseTrial.class);
		add(Objects_2_6_UseTrial.class);
		
		add(PriorityQueue_2_6_UseTrial.class);
		add(Queue_2_6_UseTrial.class);
		add(Random_2_6_UseTrial.class);
		add(RandomAccess_2_6_UseTrial.class);
		
		add(Set_2_6_UseTrial.class);
		add(SortedMap_2_6_UseTrial.class);
		add(SortedSet_2_6_UseTrial.class);
		
		add(Vector_2_6_UseTrial.class);
		
		add(Stack_2_6_UseTrial.class);
		
		add(TreeMap_2_6_UseTrial.class);
		add(TreeSet_2_6_UseTrial.class);
	}

	@Override
	public A_DGroup_GWT_2_6_UtilPkgTrials getTrialParams() {
		return this;
	}
}

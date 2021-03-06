package org.adligo.tests4j_v1_tests.gwt_refs.v2_6.sql;

import java.sql.Time;
import java.util.Date;

/** autogenerated by org.adligo.tests4j.gen.dependency_groups.ClassUseGen*/
public class Time_2_6_MockUse {

	public Time obj = null;
	public Time_2_6_MockUse() {
		obj = new Time(
			2, 2, 2);
		obj = new Time(3L);
		callTimeMethods();
		callObjectMethods();
		callDateMethods();
	}

	public void callTimeMethods() {
		try {
			obj.getDate();
		} catch (IllegalArgumentException x) {
			
		}
		try {
			obj.getDay();
		} catch (IllegalArgumentException x) {
			
		}
		try {
			obj.getMonth();
		} catch (IllegalArgumentException x) {
			
		}
		try {
			obj.getYear();
		} catch (IllegalArgumentException x) {
			
		}
		try {
			obj.setDate(2);
		} catch (IllegalArgumentException x) {
			
		}
		try {
			obj.setMonth(2);
		} catch (IllegalArgumentException x) {
			
		}
		obj.setTime(3L);
		try {
			obj.setYear(2);
		} catch (IllegalArgumentException x) {
				
		}
	}
	
	public void callObjectMethods() {
		obj.equals(new Object());
		obj.hashCode();
		obj.getClass();
		obj.toString();
	}
	
	public void callDateMethods() {
		obj.after(new Time(0));
		obj.before(new Time(0));
		obj.equals(new Time(2));
		try {
			obj.getDate();
		} catch (IllegalArgumentException x) {
				
		}
		try {
			obj.getDay();
		} catch (IllegalArgumentException x) {
				
		}
		obj.getHours();
		obj.getMinutes();
		try {
			obj.getMonth();
		} catch (IllegalArgumentException x) {
			
		}
		obj.getSeconds();
		obj.getTimezoneOffset();
		try {
			obj.getYear();
		} catch (IllegalArgumentException x) {
			
		}
		obj.compareTo(new Date(1));
		
		obj.clone();
		obj.toGMTString();
		obj.toLocaleString();
		obj.UTC(2, 2, 2, 2, 2, 2);
		obj.getTime();
		obj.parse("12/01/1969");
		try {
			obj.setDate(2);
		} catch (IllegalArgumentException x) {
			
		}
		obj.setHours(2);
		obj.setMinutes(2);
		try {
			obj.setMonth(2);
		} catch (IllegalArgumentException x) {
			
		}
		obj.setSeconds(2);
		obj.setTime(3L);
		try {
			obj.setYear(2);
		} catch (IllegalArgumentException x) {
			
		}
		obj.valueOf("12:31:01");
	}
}

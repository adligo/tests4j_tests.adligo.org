package org.adligo.tests4j_tests.shared.common;

import java.lang.reflect.Method;

public class SpecialClasses {
  public static Class<?> getBooleanClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getBoolean", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getBooleanArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getBooleanArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getByteClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getByte", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getByteArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getByteArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getCharClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getChar", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getCharArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getCharArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getDoubleClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getDouble", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getDoubleArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getDoubleArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getFloatClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getFloat", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getFloatArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getFloatArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getIntClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getInt", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getIntArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getIntArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getLongClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getLong", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getLongArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getLongArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getShortClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getShort", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getShortArrayClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getShortArray", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public static Class<?> getVoidClass() throws Exception {
    Method m = SpecialClasses.class.getMethod("getVoid", new Class<?>[] {});
    return m.getReturnType();
  }
  
  public boolean getBoolean() {
    return true;
  }

  public boolean[] getBooleanArray() {
    return new boolean[] {};
  }
  
  public byte getByte() {
    return (byte) 0;
  }
  
  public byte[] getByteArray() {
    return new byte[] {};
  }
  
  public char getChar() {
    return (char) 0;
  }

  public char[] getCharArray() {
    return new char[] {};
  }
  
  public double getDouble() {
    return 0.0;
  }
  
  public double[] getDoubleArray() {
    return new double[] {};
  }
  
  public float getFloat() {
    return (float) 0.0;
  }
  
  public float[] getFloatArray() {
    return new float[] {};
  }
  
  public int getInt() {
    return 0;
  }
  
  public int[] getIntArray() {
    return new int[] {};
  }
  
  public long getLong() {
    return 0L;
  }
  
  public long[] getLongArray() {
    return new long[]{};
  }
  
  public short getShort() {
    return (short) 0;
  }
  
  public short[] getShortArray() {
    return new short[] {};
  }
  
  public void getVoid() {
  }
}

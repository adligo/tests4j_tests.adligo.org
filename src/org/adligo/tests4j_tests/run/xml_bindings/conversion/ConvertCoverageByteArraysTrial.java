package org.adligo.tests4j_tests.run.xml_bindings.conversion;

import org.adligo.tests4j.models.shared.coverage.Probes;
import org.adligo.tests4j.run.io.Bits;
import org.adligo.tests4j.run.xml_bindings.conversion.ConvertCoverageByteArrays;
import org.adligo.tests4j.run.xml_bindings.conversion.DataFromBytesMutant;
import org.adligo.tests4j.shared.asserts.common.ExpectedThrownData;
import org.adligo.tests4j.shared.asserts.common.I_Thrower;
import org.adligo.tests4j.system.shared.trials.SourceFileScope;
import org.adligo.tests4j.system.shared.trials.Test;
import org.adligo.tests4j_tests.base_trials.I_CountType;
import org.adligo.tests4j_tests.base_trials.SourceFileCountingTrial;

import java.util.Arrays;

import javax.xml.bind.DatatypeConverter;

@SourceFileScope (sourceClass=ConvertCoverageByteArrays.class, minCoverage=99.0)
public class ConvertCoverageByteArraysTrial extends SourceFileCountingTrial {

  public static void main(String [] args) {
    
    byte[] data;
    data = DatatypeConverter.parseBase64Binary("AAABJQAAASkAAAAM/+A=");
    DataFromBytesMutant dfb = ConvertCoverageByteArrays.fromData(data);
    System.out.println(dfb.getCcus() + "/" + dfb.getCus() + System.lineSeparator());
    boolean [] probeArray = dfb.getProbes();
    Probes probes = new Probes(probeArray);
    System.out.println(probes);
    
    
    
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testToFrom1BitProbes() {
    boolean [] probes = new boolean[] {true};
    byte [] bytes = ConvertCoverageByteArrays.to(probes);
    assertEquals(5, bytes.length);
    int probesSize = ConvertCoverageByteArrays.toInt(Arrays.copyOf(bytes, 4));
    assertEquals(1, probesSize);
    Bits bits = new Bits(bytes[4]);
    assertEquals("10000000", bits.toOnesAndZeros());
    
    boolean [] probesOut = ConvertCoverageByteArrays.fromProbes(bytes);
    assertEquals(1, probesOut.length);
    assertTrue(probesOut[0]);
    
    
    //test false
    probes = new boolean[] {false};
    bytes = ConvertCoverageByteArrays.to(probes);
    assertEquals(5, bytes.length);
    probesSize = ConvertCoverageByteArrays.toInt(Arrays.copyOf(bytes, 4));
    assertEquals(1, probesSize);
    bits = new Bits(bytes[4]);
    assertEquals("00000000", bits.toOnesAndZeros());
    
    probesOut = ConvertCoverageByteArrays.fromProbes(bytes);
    assertEquals(1, probesOut.length);
    assertFalse(probesOut[0]);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testToFrom2BitProbes() {
    boolean [] probes = new boolean[] {true, false};
    byte [] bytes = ConvertCoverageByteArrays.to(probes);
    assertEquals(5, bytes.length);
    int probesSize = ConvertCoverageByteArrays.toInt(Arrays.copyOf(bytes, 4));
    assertEquals(2, probesSize);
    Bits bits = new Bits(bytes[4]);
    assertEquals("10000000", bits.toOnesAndZeros());
    
    boolean [] probesOut = ConvertCoverageByteArrays.fromProbes(bytes);
    assertEquals(2, probesOut.length);
    assertTrue(probesOut[0]);
    assertFalse(probesOut[1]);
    
    //test false true
    probes = new boolean[] {false, true};
    bytes = ConvertCoverageByteArrays.to(probes);
    assertEquals(5, bytes.length);
    probesSize = ConvertCoverageByteArrays.toInt(Arrays.copyOf(bytes, 4));
    assertEquals(2, probesSize);
    bits = new Bits(bytes[4]);
    assertEquals("01000000", bits.toOnesAndZeros());
    
    probesOut = ConvertCoverageByteArrays.fromProbes(bytes);
    assertEquals(2, probesOut.length);
    assertFalse(probesOut[0]);
    assertTrue(probesOut[1]);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testToFrom8BitProbes() {
    boolean [] probes = new boolean[] {true, false, false, true, true, false, false, true};
    byte [] bytes = ConvertCoverageByteArrays.to(probes);
    assertEquals(5, bytes.length);
    int probesSize = ConvertCoverageByteArrays.toInt(Arrays.copyOf(bytes, 4));
    assertEquals(8, probesSize);
    Bits bits = new Bits(bytes[4]);
    assertEquals("10011001", bits.toOnesAndZeros());
    
    boolean [] probesOut = ConvertCoverageByteArrays.fromProbes(bytes);
    assertEquals(8, probesOut.length);
    assertTrue(probesOut[0]);
    assertFalse(probesOut[1]);
    assertFalse(probesOut[2]);
    assertTrue(probesOut[3]);
    
    assertTrue(probesOut[4]);
    assertFalse(probesOut[5]);
    assertFalse(probesOut[6]);
    assertTrue(probesOut[7]);
    
  }
  @SuppressWarnings("boxing")
  @Test
  public void testToFrom9BitProbes() {
    boolean [] probes = new boolean[] {true, false, false, true, true, false, false, true, true};
    byte [] bytes = ConvertCoverageByteArrays.to(probes);
    assertEquals(6, bytes.length);
    int probesSize = ConvertCoverageByteArrays.toInt(Arrays.copyOf(bytes, 4));
    assertEquals(9, probesSize);
    Bits bits = new Bits(bytes[4]);
    assertEquals("10011001", bits.toOnesAndZeros());
    bits = new Bits(bytes[5]);
    assertEquals("10000000", bits.toOnesAndZeros());
    
    boolean [] probesOut = ConvertCoverageByteArrays.fromProbes(bytes);
    assertEquals(9, probesOut.length);
    assertTrue(probesOut[0]);
    assertFalse(probesOut[1]);
    assertFalse(probesOut[2]);
    assertTrue(probesOut[3]);
    
    assertTrue(probesOut[4]);
    assertFalse(probesOut[5]);
    assertFalse(probesOut[6]);
    assertTrue(probesOut[7]);
    
    assertTrue(probesOut[8]);
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testToFromPositiveInts() {
    byte [] byteWrong = new byte[3];
    assertThrown(new ExpectedThrownData(IllegalArgumentException.class),
        new I_Thrower() {
          
          @Override
          public void run() throws Throwable {
            ConvertCoverageByteArrays.toInt(byteWrong);
          }
        });
    for (int i = 0; i < 10000; i++) {
      byte [] bytes = ConvertCoverageByteArrays.toBytes(i);
      assertEquals(i, ConvertCoverageByteArrays.toInt(bytes));
    }
  }
  
  @SuppressWarnings("boxing")
  @Test
  public void testToFromProbesAndCoverage() {
    boolean [] probes = new boolean[] {true};
    byte [] bytes = ConvertCoverageByteArrays.to(11, 13, probes);
    assertEquals(13, bytes.length);
    int ccus = ConvertCoverageByteArrays.toInt(Arrays.copyOf(bytes, 4));
    assertEquals(11, ccus);
    int cus = ConvertCoverageByteArrays.toInt(Arrays.copyOfRange(bytes, 4, 8));
    assertEquals(13, cus);
    
    int probesSize = ConvertCoverageByteArrays.toInt(Arrays.copyOfRange(bytes, 8,12));
    assertEquals(1, probesSize);
    Bits bits = new Bits(bytes[12]);
    assertEquals("10000000", bits.toOnesAndZeros());
    
    DataFromBytesMutant data =ConvertCoverageByteArrays.fromData(bytes); 
    assertEquals(11, data.getCcus());
    assertEquals(13, data.getCus());
    boolean [] probesOut = data.getProbes();
    assertEquals(1, probesOut.length);
    assertTrue(probesOut[0]);
    
  }
  @Override
  public int getTests(I_CountType type) {
    return super.getTests(type, 6, false);
  }
  
  @Override
  public int getAsserts(I_CountType type) {
    int asserts = 10058;
    if (type.isFromMetaWithCoverage()) {
      //code coverage and circular dependencies
      return super.getAsserts(type, asserts + 2);
    } else {
      return super.getAsserts(type, asserts);
    }
  }

  @Override
  public int getUniqueAsserts(I_CountType type) {
    int uAsserts = 10029;
    if (type.isFromMetaWithCoverage()) {
      return super.getUniqueAsserts(type, uAsserts+ 2);
    } else {
      return super.getUniqueAsserts(type, uAsserts);
    }
  }

  @Override
  public synchronized double getPctDone(String testName) {
    // TODO Auto-generated method stub
    return super.getPctDone(testName);
  }
}

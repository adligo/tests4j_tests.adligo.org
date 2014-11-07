package org.adligo.tests4j_tests.run.common.mocks;

import org.adligo.tests4j.run.common.Holder;
import org.adligo.tests4j.run.common.I_InitalValueFactory;
import org.adligo.tests4j.run.common.ThreadGroupFilter;
import org.adligo.tests4j.run.common.ThreadGroupLocal;

public class ThreadGroupLocalMock extends ThreadGroupLocal<String> {

  public ThreadGroupLocalMock(ThreadGroupFilter filter, I_InitalValueFactory<String> factory) {
    super(filter, factory);
  }

  @Override
  public Holder<String> initialValue() {
    return super.initialValue();
  }

}

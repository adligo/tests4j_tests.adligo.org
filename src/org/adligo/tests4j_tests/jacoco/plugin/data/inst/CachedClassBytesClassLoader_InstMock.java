package org.adligo.tests4j_tests.jacoco.plugin.data.inst;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.adligo.tests4j.run.helpers.I_CachedClassBytesClassLoader;

public class CachedClassBytesClassLoader_InstMock implements I_CachedClassBytesClassLoader {

	@Override
	public int getCacheSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Class<?> addCache(String name, byte[] bytes)
			throws ClassNotFoundException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCache(Class<?> clazz, byte[] bytes) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Class<?> addCache(InputStream in, String name)
			throws ClassNotFoundException, IOException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addCache(InputStream in, Class<?> clazz) throws IOException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean hasCache(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Class<?> getCachedClass(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getCachedClassesInPackage(String pkgName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> getAllCachedClasses() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public InputStream getCachedBytesStream(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}

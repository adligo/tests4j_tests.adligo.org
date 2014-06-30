package org.adligo.tests4j_tests.run.remote.nio.helpers;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ArrayBlockingQueue;

import org.adligo.tests4j.models.shared.asserts.common.I_Asserts;
import org.adligo.tests4j.run.remote.nio.UTF8_CharacterBuilder;


public class UTF8_CharacterBuilder_ChuckTester implements Runnable {
	private ArrayBlockingQueue<StartCapture> nextCharsGroup;
	private Long nextStart;
	private List<byte []> nextChars;
	
	private I_UTF8_TestProgressMonitor monitor;
	
	public UTF8_CharacterBuilder_ChuckTester(ArrayBlockingQueue<StartCapture> pNextCharsGroup,
			I_UTF8_TestProgressMonitor pMonitor) {
		nextCharsGroup = pNextCharsGroup;
		monitor = pMonitor;
		
	}
	
	public void run() {
		try {
			do {
				if (nextCharsGroup.size() == 0) {
					return;
				}
				StartCapture sc = null;
				try {
					sc = nextCharsGroup.take();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				monitor.log("testing chunk starting at " + sc.getStart() + " with " + sc.getCapture() + " characters");
				produce(sc);
				consume();
				monitor.completedCharGroup();
			} while (nextStart != null);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			
	}

	private void consume() throws UnsupportedEncodingException {
		
		UTF8_CharacterBuilder reader = new UTF8_CharacterBuilder();
		for (int i = 0; i < nextChars.size(); i++) {
			reader.clear();
			monitor.assertTrue(reader.needsBytes());
			byte [] bytes = nextChars.get(i);
			
			for (int j = 0; j < bytes.length; j++) {
				reader.addByte(j, bytes[j]);
			}
			monitor.assertFalse(reader.needsBytes());
			Character c = reader.toCharacter();
			monitor.assertNotNull(c);
			
		}
	}

	private void produce(StartCapture sc) {
			nextChars = new ArrayList<byte[]>();
			
			nextStart = sc.getStart();
			UTF8_Generator gen = new UTF8_Generator(nextStart);
			long cap = sc.getCapture();
			for (int i = 0; i < cap; i++) {
				nextChars.add(gen.next());
			}
	}
}

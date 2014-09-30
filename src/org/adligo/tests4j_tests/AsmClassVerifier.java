package org.adligo.tests4j_tests;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;

import org.adligo.tests4j.system.shared.trials.SourceFileTrial;
import org.adligo.tests4j_tests.system.shared.api.Tests4J_ParamsTrial;
import org.objectweb.asm.ClassWriter;
import org.objectweb.asm.Opcodes;
import org.objectweb.asm.Type;
import org.objectweb.asm.util.CheckClassAdapter;
import org.objectweb.asm.util.TraceClassVisitor;

/**
 * run this to have the ASMifier veify your ASM code if your 
 * working on this project.
 * 
 * @author scott
 *
 */
public class AsmClassVerifier {

	public static void main(String [] args) {
		try {
			String internalName = "./org.adligo.tests4j_tests.models.shared.system.Tests4J_ParamsTrial.class";
			ClassWriter cw = new ClassWriter(0);
			
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			PrintWriter pw = new  PrintWriter(baos);
			TraceClassVisitor tcv = new TraceClassVisitor(cw, 
					pw);
			CheckClassAdapter cv = new CheckClassAdapter(tcv);
			/*
			cv.visitMethod(Opcodes.ACC_PUBLIC, 
					"testDefaultParams", "V", 
					"()V", null);
					*/
			tcv.visit(Opcodes.V1_7,Opcodes.ACC_PUBLIC, 
					Type.getInternalName(Tests4J_ParamsTrial.class), null, 
					Type.getInternalName(SourceFileTrial.class), null);
			byte [] boasA = baos.toByteArray();
			String content = new String(boasA);
			System.out.print(content);
			
		} catch (Exception x) {
			x.printStackTrace();
		}
	}
}

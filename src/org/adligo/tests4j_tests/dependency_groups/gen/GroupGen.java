package org.adligo.tests4j_tests.dependency_groups.gen;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * this class will eventually generage
 * dependency code (dependency_group, 
 *    List<Class<with dependency_usage>>, dependecy_group_trial)
 *  So that a two point verification system can be 
 *  used for dependency groups, and so they can be
 *  auto generated (otherwise no one would probably ever use them).
 *  
 * @author scott
 *
 */
public class GroupGen {
	private GenDepGroupContext ctx;
	private ConstantGen constantGen = new ConstantGen();
	private ConstantTrialGen constantTrialGen = new ConstantTrialGen();
	private ClassUseGen classUseGen = new ClassUseGen();
	private ClassUseTrialGen classUseTrialGen = new ClassUseTrialGen();
	
	/**
	 * note this doesn't take a PackageDiscovery
	 * @param classes
	 */
	public void gen(Collection<Class<?>> classes) {
		List<ClassAndAttributes> caAttribs = new ArrayList<ClassAndAttributes>();
		for (Class<?> c: classes) {
			ClassAndAttributes caa = new ClassAndAttributes(c);
			caAttribs.add(caa);
			if (ctx.isRunConstantGen()) {
				constantGen.gen(caa, System.out, ctx);
			}
			
		}
		if (ctx.isRunConstantTrialGen()) {
			for (ClassAndAttributes caa: caAttribs) {
				constantTrialGen.gen(caa, System.out, ctx);
			}
		}
		if (ctx.isRunUseMockGen()) {
			for (ClassAndAttributes caa: caAttribs) {
				classUseGen.gen(caa, System.out, ctx);
			}
		}
		if (ctx.isRunUseTrialGen()) {
			for (ClassAndAttributes caa: caAttribs) {
				classUseTrialGen.gen(caa, System.out, ctx);
			}
		}
	}

	public GenDepGroupContext getCtx() {
		return ctx;
	}

	public void setCtx(GenDepGroupContext ctx) {
		this.ctx = ctx;
	}
	

}

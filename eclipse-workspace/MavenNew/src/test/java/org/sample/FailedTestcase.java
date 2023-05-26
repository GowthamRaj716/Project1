package org.sample;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.IRetryAnalyzer;
import org.testng.annotations.ITestAnnotation;

public class FailedTestcase implements IAnnotationTransformer {
	public void transform(ITestAnnotation r, Class args1, Constructor args, Method args3) {
		IRetryAnalyzer res = r.getRetryAnalyzer();
		if (res == null) {
			r.setRetryAnalyzer(RerunTestcase.class);
		}
	}

}

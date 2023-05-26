package org.sample;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RerunTestcase implements IRetryAnalyzer {

	int min = 1, max = 3;

	public boolean retry(ITestResult result) {

		if (min <= max) {
			min++;
			return true;
		}
		return false;
	}

}

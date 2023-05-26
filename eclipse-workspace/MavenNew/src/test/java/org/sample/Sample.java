package org.sample;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Sample {
	@Test
	private void tc2() {
		Assert.assertTrue(10 > 20, "change condition tc2");
		System.out.println("testcase 2");
	}

	@Test
	private void tc1() {
		System.out.println(5 / 0 );
		System.out.println("testcase 1");
	}

	@Test 
	private void tc3() {
		System.out.println("testcase 3");
	}
}
  
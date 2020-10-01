package com.POMFramework;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.Assertion;

public class A {
	
	int i =1;
	@Test
	public void testlogins() {
		if(i ==2) {
		assertTrue(true);}
		else {
			i++;
			assertTrue(false);
		}
		
	}

}

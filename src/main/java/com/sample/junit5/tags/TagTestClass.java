package com.sample.junit5.tags;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class TagTestClass {
	
	@Tag("production")
	@Test
	@DisplayName("TestCase 1 Prod Only")
	public void testCase1() {
		System.out.println("Run on Production Env Only ");
	}
	
	
	@Tag("production")
	@Test
	@DisplayName("TestCase 2 Prod-Dev")
	public void testCase2() {
		System.out.println("Run on Production Env Only ");
	}

	
	@Tag("development")
	@Test
	@DisplayName("TestCase 3 Dev Only")
	public void testCase3() {
		System.out.println("Run on Development Env Only ");
	}
	
	@Test
	@DisplayName("No Tag Mentioned")
	public void testCaseC() {
		System.out.println("No Tag Mentioned ");
	}
}

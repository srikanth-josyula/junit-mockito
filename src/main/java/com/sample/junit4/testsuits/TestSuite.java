package com.sample.junit4.testsuits;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ TestFeatureOne.class, TestFeatureTwo.class })
public class TestSuite {
	//
}
package com.sample.junit5.disabletest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DisableTestCase.class, DisableTestClass.class })
public class DisableTestSuiteTest {
	//
}

//Output 
//in IgnoreTestCase #printTest
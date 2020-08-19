package com.sample.junit4.ignoretest;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ IgnoreTestCase.class, IgnoreTestClass.class })
public class IgnoreTestSuiteTest {
	//
}

//Output 
//in IgnoreTestCase #printTest
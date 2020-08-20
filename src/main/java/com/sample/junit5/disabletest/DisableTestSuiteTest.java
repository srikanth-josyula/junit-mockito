package com.sample.junit5.disabletest;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(JUnitPlatform.class)
@SuiteClasses({ DisableTestCase.class, DisableTestClass.class })
public class DisableTestSuiteTest {
	//
}

// Didn't Work Check again Later

/*in IgnoreTestCase #printTest
in IgnoreTestCase #ignoreTest
in IgnoreTestClass #printTestClass*/
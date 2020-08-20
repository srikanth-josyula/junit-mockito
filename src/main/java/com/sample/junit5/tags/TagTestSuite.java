package com.sample.junit5.tags;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({ TagTestClass.class })
@IncludeTags("production")
public class TagTestSuite {

}

//Didn't Work Check again Later
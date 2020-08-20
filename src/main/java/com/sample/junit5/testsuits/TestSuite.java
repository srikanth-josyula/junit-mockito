package com.sample.junit5.testsuits;

/**
 * Create Test Suite 
 * 
 * @RunWith(JUnitPlatform.class). 
 * @SelectPackages specifies the names of packages to select when running a test suite 
 * 		Pass “packageName” as parameter to @SelectPackages annotation.
 * 		Pass package names in parameter as string array (inside curly braces {}) to @SelectPackages
 * 
 * @IncludePackages and @ExcludePackages
 *  	If you want to exclude any specific sub-package, or include any package 
 *  	then you may use @IncludePackages and @ExcludePackages annotations.
 * 
 * @SelectClasses specifies the classes to select when running a test suite
 * 		Pass ClassName.class as parameter to @SelectClasses annotation.
 * 		Pass class names in parameter as array (inside curly braces {}) to @SelectClasses annotation.
 * 
 * @IncludeClassNamePatterns and @ExcludeClassNamePatterns
 * 		To specify test class names patterns to exclude or include,
 * 	 	you can use @IncludeClassNamePatterns and @ExcludeClassNamePatterns annotations.
 **/
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeClassNamePatterns;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)

@SelectPackages("com.sample.junit5.testsuits")
// @IncludePackages("com.sample.junit5.testsuits.tags")
// @ExcludePackages("com.sample.junit5.testsuits.tags")

// @IncludeClassNamePatterns({"^.*TestFeature?$"})
@ExcludeClassNamePatterns({ "^.*TestFeatureTwo?$" })
// @SelectClasses({ TestFeatureOne.class, TestFeatureTwo.class })
public class TestSuite {
	//
}
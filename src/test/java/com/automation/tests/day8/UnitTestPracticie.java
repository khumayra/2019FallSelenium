package com.automation.tests.day8;

import org.apache.commons.lang3.builder.ToStringExclude;
import org.testng.Assert;
import org.testng.annotations.*;

public class UnitTestPracticie {
    public static void main(String[] args) {
        String expected = "cba";
        String toReverse = "abc";
        String actual = reverseString(toReverse);
        verifyEquals(expected,actual);
    }

    @Test (description = "Verify if method can reverse a string")
    public void test(){
        String expected = "elppa";
        String actual = reverseString("apple");
        // it coming from testing, junit also has this class
        // you can compare any data type here: strings, primitves, arrays, objects
        // to verify if expected result is equal to actual
        Assert.assertEquals(actual, expected);

    }
    @BeforeClass
    public void beforeClass(){
        System.out.println("BEFORE CLASS");
    }
    @AfterClass
    public void afterClass(){
        System.out.println("AFTER CLASS");
    }

    @BeforeMethod
    public void beforeMethod(){
        System.out.println("BEFORE METHOD");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("AFTER METHOD");
    }


    @Test
    public void test2(){
        String expected = "rac";
        String actual = reverseString("car");
        Assert.assertEquals(actual, expected);
    }


    public static boolean verifyEquals(String expected, String actual) {
        if (expected.equals(actual)) {
            System.out.println("TEST PASSED");
            return true;
        } else {
            System.out.println("Test failed!!!");
            System.out.println("Expected: " + expected);
            System.out.println("Actual: " + actual);
            return false;
        }
    }
    /**
     * This method stands for reversing strings.
     *
     * @param str to reverse
     * @return reversed string
     */
    public static String reverseString (String str){
        String reversed = "";
        for (int i = str.length()-1; i >=0 ; i--) {
            reversed = reversed+str.charAt(i);

        }
        return reversed;
    }
}

package com.automation.utilities;

public class MyTest {
    public static void checkResult(String actual, String expected){
        if (expected.equals(actual)){
            System.out.println("TEST PASSED!");
        } else {
            System.out.println("TEST FAILED!");
        }
    }
}

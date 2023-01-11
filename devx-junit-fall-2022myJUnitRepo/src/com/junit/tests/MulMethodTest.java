package com.junit.tests;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

// @RunWith annotation indicates that this is the DDT (Data Driven Test)
@RunWith(Parameterized.class)
public class MulMethodTest extends BaseTest {
    /*
        1. First, we need to declare the instance variables (purple ones -> colors help you track how variables travel).
        2. These variables will create a storage in the memory for our Test Data.
        3. These "Test Data" values we will be passing as arguments to our "mul" method,
           when it will get called by the "cp" Object, inside the "multiplicationFunctionality" Test method
     */
    private final int num1;
    private final int num2;
    private final int expectedResult;

    /*
        4. Then we need to create a parameterized Constructor of the "MulMethodTest" Class,
           so that it will help the "cp" Object to initialize the instance variables (purple).
        5. num1, num2 and expectedResult are the local variables (white) for our Constructor, and
           these local variables will be used to store data we are going to be passing to our Test method "multiplicationFunctionality"
     */
    public MulMethodTest(int num1, int num2, int expectedResult) {
        this.num1 = num1; // 0, 2000, 1, 0, -3, -3, 3
        this.num2 = num2; // 3, 300, 1, 0, -2, 2, -2
        this.expectedResult = expectedResult; // 0, 600 000, 1, 0, 6, -6, -6
    }

    /*
        6. Then we need an actual Test method, which will test the functionality of the "mul" method -
           which is the one inside the CalculatorProgram, with the given Test Data in the "supplyData" method below
     */
    @Test
    public void multiplicationFunctionality() {
        int actualResult = c.mul(num1, num2);
        String message = "expected=" + expectedResult + "actual=" + actualResult;
        Assert.assertEquals(message, expectedResult, actualResult);
    }
    /*
        7. Next, we need to create a method to supply the Test Data to our "multiplicationFunctionality" Test method, and
           we need to remember, that first, Test Data will travel to Constructor, there it will get assigned to instance
           variables and those will be used later, inside the "multiplicationFunctionality" Test method.
     */
    @Parameterized.Parameters(name = "Running with {num1} and {num2} data and expecting {expectedResult}")
    public static Integer[][] supplyData() {
        return new Integer[][] {
                                    {0, 3, 0},
                                    {2000, 300, 600000},
                                    {1, 1, 1},
                                    {0, 0, 0},
                                    {-3, -2, 6},
                                    {-3, 2, -6},
                                    {3, -2, -6}
        };
    }
}

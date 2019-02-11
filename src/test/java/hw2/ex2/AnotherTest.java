package hw2.ex2;

import org.testng.annotations.*;

import java.net.URISyntaxException;

public class AnotherTest {

    @BeforeSuite
    public void setupSuite(){
        System.out.println("Before Suite Setup ...... ");
    }

    @BeforeTest
    public void setUpTest() throws Exception {
        System.out.println("Before Test Setup ...... ");
    }

    @BeforeMethod
    public void setUpMethod() throws URISyntaxException {
        System.out.println("Before Method Setup ...... ");
    }

    @AfterMethod
    public void tearDownMethod(){
        System.out.println("After Method Setup ...... ");
    }

    @AfterTest
    public void tearDownSuite() throws Exception {
        System.out.println("After test Setup ...... ");
    }

    @Test(groups = {"sometest"})
    public void someTest(){
        System.out.println("Some test ...... ");
    }

    @Test(groups = {"sometest"})
    public void someTest1(){
        System.out.println("Some test 1...... ");
    }

    @Test(groups = {"anothertest"})
    public void anothertest(){
        System.out.println("Another test ...... ");
    }
}

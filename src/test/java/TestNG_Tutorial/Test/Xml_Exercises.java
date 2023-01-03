package TestNG_Tutorial.Test;

import org.testng.annotations.Test;

public class Xml_Exercises {

    @Test
    public void testCase_01(){
        System.out.println("First Test Case");
    }
    @Test
    public void testCase_02() {
        System.out.println("Second Test Case");
    }
    @Test
    public void MobileLogIn() {
        System.out.println("Mobile 1");
    }
    @Test
    public void MobileLogOut() {
        System.out.println("Mobile 2");
    }
    @Test
    public void MobileSignIn() {
        System.out.println("Mobile 3");
    }
}

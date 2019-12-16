package SampleTestNGConcepts;

import org.openqa.selenium.NoSuchElementException;
import org.testng.annotations.Test;

public class ExpectedExceptionCocept {
	ExpectedExceptionCocept obj = null;
	
	@Test(expectedExceptions=ArithmeticException.class)
	public void loginTest(){
		System.out.println("login test");
		int i = 9/0;
	}
	
	@Test(expectedExceptions={ NullPointerException.class, ArithmeticException.class, NoSuchElementException.class })
	public void homePageTest(){
		System.out.println("login test");
		obj.login();
		
	}
	
	public void login(){
		System.out.println("login method...");
	}
	

}

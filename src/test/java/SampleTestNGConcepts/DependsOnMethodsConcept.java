package SampleTestNGConcepts;

import org.testng.annotations.Test;

public class DependsOnMethodsConcept {
	
	
	@Test
	public void loginTest(){
		System.out.println("login test");
		int i = 9/0;
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homePageTest(){
		System.out.println("home page test");
	}
	
	@Test(dependsOnMethods="loginTest")
	public void homeSearchTest(){
		System.out.println("home search test");
	}
	
	
	

}

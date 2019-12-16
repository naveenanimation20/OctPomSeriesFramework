package SampleTestNGConcepts;

import org.testng.annotations.Test;

public class InvocationCountConcept {
	
	
	@Test(invocationCount=10)
	public void createUserTest(){
		System.out.println("user creation test");
	}
	
	
	
	
	
	

}

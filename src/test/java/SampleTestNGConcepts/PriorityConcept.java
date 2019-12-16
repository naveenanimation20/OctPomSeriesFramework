package SampleTestNGConcepts;

import org.testng.annotations.Test;

public class PriorityConcept {

	@Test(priority=1)
	public void loginTest() {
		System.out.println("login test");
	}

	@Test(priority=1)
	public void homePageTest() {
		System.out.println("home page test");
	}

	@Test(priority=1)
	public void homeSearchTest() {
		System.out.println("home search test");
	}

	@Test()
	public void profileTest() {
		System.out.println("profile test");
	}

	@Test()
	public void homeTabTest() {
		System.out.println("home tab test");
	}

}

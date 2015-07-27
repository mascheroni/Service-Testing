package com.almundo.automation.tests;

import org.testng.annotations.Test;

import com.almundo.automation.services.OneKeyController;

public class OneKeyTests {

	@Test(description = "Spring REST services", groups = { "none" })
	public void verifySpringREST() {
		System.out.println("OneKeyTests");
		OneKeyController oneKeyController = new OneKeyController();
		oneKeyController.template();
	}
	
	@Test(description = "Spring REST services", groups = { "spring-REST" })
	public void verifyREST() {
		System.out.println("OneKeyTests");
		OneKeyController oneKeyController = new OneKeyController();
		oneKeyController.getPositions();
	}
}

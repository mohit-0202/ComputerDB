package com.CompDB.Test;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import com.compDB.TestBase.BrowserFactory;
import com.compDB.pages.ComputerDBHome;

public class ComputerDBTest extends BrowserFactory {

	ComputerDBHome objDBHome;

	/**
	 * TC-Test filter computer by name and verify filter successfully
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void openBrowserEnterUrlAndVerifyFilter() throws InterruptedException {
		WebDriver driver = startBrowser("Chrome", "http://computer-database.herokuapp.com/computers");
		objDBHome = new ComputerDBHome(driver);
		objDBHome.filterComputerByName("ACE");
		objDBHome.verifyFilter();
		driver.quit();

	}
}

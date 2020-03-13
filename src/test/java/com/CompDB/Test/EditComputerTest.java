package com.CompDB.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.compDB.TestBase.BrowserFactory;
import com.compDB.pages.ComputerDBHome;
import com.compDB.pages.EditComputer;

public class EditComputerTest extends BrowserFactory {

	ComputerDBHome objDBHome;
	EditComputer objEditComp;

	/**
	 * TC-Test Edit computer and verify computer edited successfully.
	 * 
	 * @throws InterruptedException
	 */
	@Test
	public void openBrowserEnterUrlAndVerifyEditedComputer() throws InterruptedException {
		WebDriver driver = startBrowser("Chrome", "http://computer-database.herokuapp.com/computers");
		objDBHome = new ComputerDBHome(driver);
		objDBHome.ClickAddedComputer();
		objEditComp = new EditComputer(driver);
		objEditComp.editComputer();
		// verify computer name before update and after update are equal
		Assert.assertNotSame(EditComputer.CompNameBeforeUpdate, EditComputer.CompNameAfterUpdate);
		driver.quit();
	}
}

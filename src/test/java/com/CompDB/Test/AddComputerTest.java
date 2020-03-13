package com.CompDB.Test;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.compDB.TestBase.BrowserFactory;
import com.compDB.pages.AddComputer;
import com.compDB.pages.ComputerDBHome;


public class AddComputerTest extends BrowserFactory{
	    ComputerDBHome objDBHome;
		AddComputer objAddComp;
		
		/**
		 * Tc - Test add new computer with all fields and verify whether computer added successfully
		 * @throws InterruptedException
		 */
		@Test
		public void openBrowserEnterUrlAndVerifyAddedComputer() throws InterruptedException{
		WebDriver driver =	startBrowser("Chrome", "http://computer-database.herokuapp.com/computers");
		objDBHome = new ComputerDBHome(driver);
        objDBHome.clickAddNewComp();
        objAddComp = new AddComputer(driver);
        objAddComp.addNewComputer();
        objDBHome.verifyCompName();
        //To validate Added computer and computer name after adding to DB are equal
        Assert.assertEquals(AddComputer.newCompName,ComputerDBHome.ReturnedCompName );
        driver.quit();
			
		}
}

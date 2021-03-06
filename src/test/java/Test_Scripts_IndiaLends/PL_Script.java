package Test_Scripts_IndiaLends;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;


import Page_Objects_IndiaLends.PL_Page;
import Utility.Base;

public class PL_Script extends Base
{
	@Test(priority=1)
	public void verifyBasicDetails() throws Exception {
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is " + driver);
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterBasicdetailsToCheckLoanEligibility();
	}
	@Test(priority=2)
	public void verifyAdditionalDetails() throws InterruptedException {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterAdditionaldetailsToCheckLoanEligibility();
	}
	@Test(priority=3)
	public void verifyGeneralDetails() throws Exception {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterGeneralInformation();
	}
	@Test(priority=4)
	public void verifyOfficeDetails() throws Exception {
		PL_Page detailsPage = PageFactory.initElements(driver, PL_Page.class);
		detailsPage.enterOfficeInformation();
	}

}

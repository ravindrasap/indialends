package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CC_SBIGenericPage;
import Page_Objects_IndiaLends.CR_Page;
import Utility.Base;

public class CC_SBIGenericScript extends Base {
	@Test(priority=1)
	public void CC_BasicDetailsPage() throws Exception 
	{
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is "+ driver);
		CC_SBIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_SBIGenericPage.class);
		detailsPage.enterBasicdetailsToCheckLoanEligibility();
				
	}
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		Page_Objects_IndiaLends.CC_SBIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_SBIGenericPage.class);
		detailsPage.CC_check_Eligibility();
		
	}
	/*@Test(priority=3)
	public void CC_general_information() throws Exception {
		Page_Objects_IndiaLends.CC_SBIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_SBIGenericPage.class);
		detailsPage.general_Information();
	}
	@Test(priority=4)
	public void CC_contact_Details() throws Exception {
		Page_Objects_IndiaLends.CC_SBIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_SBIGenericPage.class);
		detailsPage.contact_Details();
	}*/
	
}

package Test_Scripts_IndiaLends;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CC_HDFCGenericPage;
import Page_Objects_IndiaLends.CC_ICICIGenericPage;
import Utility.Base;

public class CC_ICICIGenericScript extends Base {
	@Test(priority=1)
	public void CC_BasicDetailsPage() throws Exception 
	{
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is "+ driver);
		CC_ICICIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_ICICIGenericPage.class);
		//detailsPage.analyticsGA();
		detailsPage.enterBasicdetailsToCheckLoanEligibility();
				
	}
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		CC_ICICIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_ICICIGenericPage.class);
		//detailsPage.analyticsGA();
		detailsPage.check_Eligibility();
		
	}
	@Test(priority=3)
	public void CC_general_information() throws Exception {
		CC_ICICIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_ICICIGenericPage.class);
		detailsPage.general_Information();
	}
	@Test(priority=4)
	public void CC_contact_Details() throws Exception {
		CC_ICICIGenericPage detailsPage = PageFactory.initElements(driver, Page_Objects_IndiaLends.CC_ICICIGenericPage.class);
		detailsPage.contact_Details();
		//detailsPage.analyticsGA();
	}
	
}
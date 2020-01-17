package Test_Scripts_IndiaLends;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CC_RBLLenderPage;
import Utility.Base;

public class CC_RBLLenderScript extends Base {
	

	@Test(priority=1)
	public void CC_BasicDetailsPage() throws Exception 
	{
		
		System.out.println("Driver valueE inside fillBasicDetailsPage() method is "+ driver);
		CC_RBLLenderPage detailsPage = PageFactory.initElements(driver, CC_RBLLenderPage.class);
		detailsPage.enterBasicdetailsToCheckLoanEligibility();
				
	}
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		CC_RBLLenderPage detailsPage = PageFactory.initElements(driver, CC_RBLLenderPage.class);
		detailsPage.check_Eligibility();
		
	}
/*	@Test(priority=3)
	public void CC_general_information() throws Exception {
		CC_RBLLenderPage detailsPage = PageFactory.initElements(driver, CC_RBLLenderPage.class);
		detailsPage.general_Information();
	}
	@Test(priority=4)
	public void CC_contact_Details() throws Exception {
		CC_RBLLenderPage detailsPage = PageFactory.initElements(driver, CC_RBLLenderPage.class);
		detailsPage.contact_Details();
	}*/
	
}


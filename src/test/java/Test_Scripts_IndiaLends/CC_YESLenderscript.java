package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CC_YESLenderPage;
import Utility.Base;

public class CC_YESLenderscript extends Base {
	
	@Test
	public void CCBasicDetailsPage() throws Exception {
		
		CC_YESLenderPage detailsPage=PageFactory.initElements(driver,CC_YESLenderPage.class);
		detailsPage.enterBasicdetailsToCCEligibility();
	
	}
	@Test(priority=2)
	public void CC_Eligibility_check() throws Exception {
		CC_YESLenderPage detailsPage = PageFactory.initElements(driver, CC_YESLenderPage.class);
		detailsPage.check_CCEligibility();
		
	}
	@Test(priority=3)
	public void CC_general_information() throws Exception {
		CC_YESLenderPage detailsPage = PageFactory.initElements(driver, CC_YESLenderPage.class);
		detailsPage.general_CCInformation();
	}
	@Test(priority=4)
	public void CC_contact_Details() throws Exception {
		CC_YESLenderPage detailsPage = PageFactory.initElements(driver, CC_YESLenderPage.class);
		detailsPage.contact_CCDetails();
	}

}

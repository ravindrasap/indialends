package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import Page_Objects_IndiaLends.New_CR_Page;
import Utility.Base;

public class New_CR_Script extends Base{
	
	@Test()
	public void VerifyCRBasicDetails() 
	{
			System.out.println("Driver value inside fillBasicDetailsPage() method is "+ driver);
			New_CR_Page detailsPage = PageFactory.initElements(driver, New_CR_Page.class);
			detailsPage.enterCRdetails();
		
	}

}

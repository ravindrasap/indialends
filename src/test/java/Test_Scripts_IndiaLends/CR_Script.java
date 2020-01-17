package Test_Scripts_IndiaLends;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CR_Page;
import Utility.Base;

public class CR_Script extends Base
{
	@Test()
	public void fillBasicDetailsPage() 
	{
		
		try {
			System.out.println("Driver value inside fillBasicDetailsPage() method is "+ driver);
			CR_Page detailsPage = PageFactory.initElements(driver, CR_Page.class);
			detailsPage.enterCRdetails();
		} catch (Exception e) {
			System.out.println("CR Script page Failur occur: "+e.getMessage());
		}
		
		
	}
}

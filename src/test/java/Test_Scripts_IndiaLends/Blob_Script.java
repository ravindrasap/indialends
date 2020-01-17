package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.Blob_Page;
import Utility.Base;

public class Blob_Script extends Base{
	
	@Test()
	public void VerifyBasicDetails() 
	{
			System.out.println("Driver value inside fillBasicDetailsPage() method is "+ driver);
			Blob_Page detailsPage = PageFactory.initElements(driver, Blob_Page.class);
			detailsPage.enterBlobdetails();
		
	}

}

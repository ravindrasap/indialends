package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.CR_Page;
import Page_Objects_IndiaLends.Home_Page;
import Page_Objects_IndiaLends.PL_Page;
import Utility.Base;

public class Home_Script extends Base {
	
	@Test()
	public void Homepagedetails() 
	{
		
		try {
			System.out.println("Driver value inside fillBasicDetailsPage() method is "+ driver);
			Home_Page detailsPage = PageFactory.initElements(driver, Home_Page.class);
			detailsPage.Homepagedetails();
		} catch (Exception e) {
			System.out.println("Home page Script page Failur occur: "+e.getMessage());
		}
		
		
	}

}

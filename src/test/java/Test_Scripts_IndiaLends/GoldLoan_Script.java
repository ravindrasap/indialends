package Test_Scripts_IndiaLends;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

import Page_Objects_IndiaLends.GoldLoan_Page;
import Page_Objects_IndiaLends.New_CR_Page;
import Utility.Base;

public class GoldLoan_Script extends Base{
	
	@Test()
	public void VerifygoldloanBasicDetails() 
	{
			System.out.println("Driver value inside fillBasicDetailsPage() method is "+ driver);
			GoldLoan_Page detailsPage = PageFactory.initElements(driver, GoldLoan_Page.class);
			detailsPage.entergoldloandetails();
		
	}

}

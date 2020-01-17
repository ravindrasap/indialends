	package Page_Objects_IndiaLends;
	
	import java.io.File;
	import java.text.SimpleDateFormat;
	import java.util.Date;
	
	import org.apache.commons.io.FileUtils;
	import org.openqa.selenium.By;
	import org.openqa.selenium.OutputType;
	import org.openqa.selenium.TakesScreenshot;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.FindBy;
	import org.openqa.selenium.support.How;
	import org.openqa.selenium.support.PageFactory;
	import Utility.Base;
	import Utility.Sendmail;
	import Utility.SendmailSSL;
	
	public class Blob_Page extends Base{
		
		protected WebDriver driver;
		
		@FindBy(how=How.CSS, using="#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li:nth-child(4) > a")
		private WebElement clickBlob;
			
		
		@FindBy(how=How.XPATH, using="//*[@id=\"btn_mobile_verify\"]")
		private WebElement otpVerify;
		
		public Blob_Page(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}
	
	   public void enterBlobdetails()  {
		
		try {
			
	 // ========================== Header Link FORM ========================================= //
	     	clickBlob.click();
		//	getStartedCreditcard.click();
			Thread.sleep(3000);
			driver.findElement(By.cssSelector("#wzrk-cancel")).click();
			
			String persol =driver.findElement(By.cssSelector("#il > header > nav > div.col-xl-9.col-lg-7.col-md-8.col-sm-8.col-xs-12 > div > ul > li:nth-child(2) > a")).getText();
			
			System.out.println(persol);
			
			String expected = ("Personal Loan");
			if (persol.contentEquals(expected))
			{
				System.out.println(" Blob link open and personal loan link is displayed is: "+persol);
			//	 Sendmail.sendmail("Blog Link is working");
			}
			else {
				System.out.println(" Blob link is not open also personal loan link is not displayed: "+persol);
				 Sendmail.sendmail("Blog Link is not working");
				
			}
			
										
		} catch (Exception e) {
			
			System.out.println("Blog Form Failure: "+e.getMessage());
		}
		
	    try {
				
	//================= Screenshot take ============================================= //	
			Date date = new Date();  
			SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmm");  
			String strDate= formatter.format(date); 
			
			File scrFile = ((TakesScreenshot) driver)
					.getScreenshotAs(OutputType.FILE);
			// The below method will save the screen shot
			FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
					+ "//screenshot//Live//"+strDate+ "Blob.png"));
		} catch (Exception e) {
			
			System.out.println("Failure in result capture screen: "+e.getMessage());
		}
	    driver.close();
	}
	
	}
	
	

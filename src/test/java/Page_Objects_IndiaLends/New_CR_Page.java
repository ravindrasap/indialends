package Page_Objects_IndiaLends;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.Base;
//import Utility.SendMail;

public class New_CR_Page extends Base {
	
protected WebDriver driver;

String gtag="AW-955414164";
String RemarketingTag1="803650867";
String RemarketingTag2="803650924";
String RemarketingTag3="955414164";
String Google_Analytics="UA-58036769-1";
	
	//@FindBy(how=How.XPATH, using="//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[3]/a")
	@FindBy(how=How.XPATH, using="//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[4]/a")
	//*[@id="mainNav"]/div[6]/div[1]/div[2]/ul/li[4]/a
	private WebElement clickCR;
		
	@FindBy(how=How.CSS, using="body > div > div.banner.sm-pad0.credit-card-banner.xs-pad20t.bg-white > div > div.col-lg-7.col-sm-7.col-md-7.col-xs-12.pad30t.pad15l.sm-pad15t.marg15l.sm-marg0l.xs-pad0t > a")
	private WebElement getStarted;
	
	@FindBy(how=How.CSS, using="#li_first_name")
	private WebElement fname;
	
	@FindBy(how=How.CSS, using="#li_email_id")
	private WebElement emailId;
	
	@FindBy(how=How.CSS, using="#li_gender_male")
	private WebElement gender;
	
	@FindBy(how=How.CSS, using="#li_birthdate")
	private WebElement dobDate;
	
	@FindBy(how=How.CSS, using="#li_birthmonth")
	private WebElement dobMN;
	
	@FindBy(how=How.CSS, using="#li_birthyear")
	private WebElement dobYear;
	
	@FindBy(how=How.CSS, using="#li_res_pin")
	private WebElement pincode;
	
	@FindBy(how=How.CSS, using="#li_emp_type")
	private WebElement employment;
	
	@FindBy(how=How.CSS, using="#li_monthly_salary")
	private WebElement salary;
	
	@FindBy(how=How.CSS, using="#li_mobile_number")
	private WebElement mobileNo;
	
	@FindBy(how=How.CSS, using="#li_pan_number")
	private WebElement panno;
	
	@FindBy(how=How.CSS, using="#li_submit_one")
	private WebElement frmSubmit;

	@FindBy(how=How.CSS, using="#txt_otp0")
	private WebElement otptake;
	
	@FindBy(how=How.CSS, using="#mobile_verification > div > div > div > div.pad20b.pad10t.pad10l.pad10r > label > span")
    private WebElement tNC;
	
	@FindBy(how=How.CSS, using="#btn_verify_mobile")
	private WebElement otpVerify;
	
	@FindBy(how=How.CSS,using="#page-wrapper > div.container-fluid.sm-pad0r.sm-pad0l > div > div > div.panel-body.pad0 > div > h4")
	private WebElement CR_report1;
	
	public New_CR_Page(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

public void enterCRdetails()  {
		
		System.out.println("==================== CR FORM Started=================== ");
		clickCR.click();
		getStarted.click();
		
		 boolean TextPresentNoIndex=driver.getPageSource().contains("nofollow, noindex");
	     Assert.assertFalse(TextPresentNoIndex,"NO index present in pagesource");
		
		 boolean isTheTextPresent = driver.getPageSource().contains(gtag);
		 Assert.assertTrue(isTheTextPresent, "gtag Pixel is Not fired "+gtag);
		 
		 boolean TextPresent = driver.getPageSource().contains(RemarketingTag1);
		 Assert.assertTrue(TextPresent, "Remarketing Tag1 Pixel is Not fired "+RemarketingTag1);
		
		 boolean TextPresent1 = driver.getPageSource().contains(RemarketingTag2);
		 Assert.assertTrue(TextPresent1, "Remarketing Tag2 Pixel is Not fired "+RemarketingTag2);
		 
		 boolean TextPresent2 = driver.getPageSource().contains(RemarketingTag3);
		 Assert.assertTrue(TextPresent2, "Remarketing Tag3 Pixel is Not fired "+RemarketingTag3);
		 
		// boolean TextPresent3 = driver.getPageSource().contains(Google_Analytics);
	//	 Assert.assertTrue(TextPresent3, "Google_Analytics Pixel is Not fired "+Google_Analytics);
		
		fname.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "first_name"));
		emailId.sendKeys(email);
		gender.click();
		
		Select date=new Select(dobDate);
		date.selectByIndex(1);
		
		Select mon=new Select(dobMN);
		mon.selectByIndex(3);
		
		Select yr=new Select(dobYear);
		yr.selectByIndex(4);
		
		//Thread.sleep(2000);
		
		pincode.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "pin_code"));
		
		Select emp=new Select(employment);
		emp.selectByIndex(1);
		
		salary.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "salary"));
		
		mobileNo.sendKeys(mobileno);
		panno.sendKeys(pancard);
		//Base.writePropertiesFile("properties", "mobileno");
		//Reporter.log("Mobile No is:"+mobileno);
		System.out.println("Pan no is:"+pancard);
		frmSubmit.click();
		System.out.println("CR form succesfully submitted");
	
	
	
//=============================== OTP Screen ========================================================= //
	try {
		
		WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(otptake));
		
		String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
		System.out.println("Mobile No is: "+mobileno);
		otptake.sendKeys(passwrd);
		tNC.click();
		otpVerify.click();
		
		Thread.sleep(3000);
		
		System.out.println("Sucessfully submitted OTP");
		
	} catch (Exception e) {
		
		System.out.println("Failure on OTP screen: "+e.getMessage());
		//SendMail.sendmail("Failure on OTP screen:");
		
	}   

//=============================== Report section ========================================================= //
    try {
    	
    	/*WebDriverWait wait = new WebDriverWait(driver, 50);
		wait.until(ExpectedConditions.visibilityOf(CR_report1));*/
    	Thread.sleep(4000);
		String expected="You Are New to Credit!";
		
		try {
			Assert.assertEquals(CR_report1.getText(), expected);
			System.out.println("CR Report is: You Are New to Credit!" );
		} catch (Exception e) {
			System.out.println("CR Report is not matching with correct one.");
			//SendMail.sendmail("CR Report is not matching with correct one.");
		}
		System.out.println("==================== CR FORM ENDED=================== ");
	/*	WebDriverWait wait=new WebDriverWait(driver, 60);
		WebElement CR_report;
		CR_report= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div[2]/div[1]/div[2]/div[1]/div/h4")));
		String report=CR_report.getText();
		
		 boolean TextPresent3 = driver.getPageSource().contains(Google_Analytics);
		 Assert.assertTrue(TextPresent3, "Google_Analytics Pixel is Not fired "+Google_Analytics);
		
		String expected="You Are New to Credit!";
		if (report.contentEquals(expected))
		{
			System.out.println("CR Report is: "+report);
		}
		else {
			System.out.println("CR Report is not matching with correct one.");
		}*/
    	
    	
//================= Screenshot take ============================================= //	
		Date date1 = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmm");  
		String strDate= formatter.format(date1); 
		
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
				+ "//screenshot//Live//"+strDate+ "NewCR.png"));
	} catch (Exception e) {
		
		System.out.println("Failure in result capture screen: "+e.getMessage());
		//tearDown();
	}
}


}

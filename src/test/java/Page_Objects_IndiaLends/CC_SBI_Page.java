package Page_Objects_IndiaLends;
import java.nio.CharBuffer;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.LogStatus;
import Utility.Base;

public class CC_SBI_Page extends Base{
	
	protected WebDriver driver;
	String Conversion="803650867";
	String Conversion2="955414164";
	String gtag="AW-955414164";
	String RemarketingTag1="803650867";
	String RemarketingTag2="803650924";
	String RemarketingTag3="955414164";
	String Google_Analytics="UA-58036769-1";
	//=========================== Short Form Page Locators =============================================================== //
	
	@FindBy(how=How.CSS, using="#li_first_name")
	private WebElement fname;
	
	@FindBy(how=How.CSS, using="#li_res_pin")
	private WebElement pincode;
	
	@FindBy(how=How.CSS, using="#li_emp_type")
	private WebElement empType;
	
	@FindBy(how=How.CSS, using="#li_company_name")
	private WebElement companyname;
	
	@FindBy(how=How.CSS, using="#li_monthly_salary")
	private WebElement salary;
	
	@FindBy(how=How.CSS, using="#li_email_id")
	private WebElement email;
	
	@FindBy(how=How.CSS, using="#li_mobile_number")
	private WebElement mobile;
	
	@FindBy(how=How.CSS, using="#li_submit")
	private WebElement clickNextBtn;

	//=========================== Otp Screen & I-lite Locators  =============================================================== //
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txt_otp\"]")
	private WebElement otptake;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btn_mobile_verify\"]")
	private WebElement otpVerify;
	
	@FindBy(how=How.CSS, using="#control-indicator")
	private WebElement terms;
	
	//============================= Check Eligibility =======================================//
	
	@FindBy(how=How.CSS, using="#male")
	private WebElement gender;
	
	@FindBy(how=How.CSS, using="#radio-8")
	private WebElement existingCard;
	
	@FindBy(how=How.CSS, using="#li_off_pin")
	private WebElement Officepincode;
	
	@FindBy(how=How.CSS, using="#li_pan_number")
	private WebElement PanNo;
	
	@FindBy(how=How.CSS, using="#li_submit_pan_details")
	private WebElement Submit;
	
	
	//@FindBy(how=How.XPATH, using="//*[@id=\"dv_karza_buttons\"]/div[1]/span")
	@FindBy(how=How.CSS,using="#dv_karza_buttons > div.col-sm-5.col-xs-5.pad0.pad20t > span")
	private WebElement PanKarza;
		
 //============= General Information ========================================= //
	@FindBy(how=How.CSS, using="#view_more_section > a")
	private WebElement ViewMore;
	
	@FindBy(how=How.CSS, using="#btn_102")
	private WebElement ClickCard;
	
	@FindBy(how=How.CSS, using="#married")
	private WebElement MaritalStatus;
	
	//@FindBy(how=How.CSS, using="#employmentSelect")
	//private WebElement Qualification;
		
	//Present residential address//
	
	@FindBy(how=How.CSS, using="#li_res_house_no")
	private WebElement houseNo;
	
	@FindBy(how=How.CSS, using="#li_res_street")
	private WebElement street;
	
	@FindBy(how=How.CSS, using="#li_res_area")
	private WebElement ResArea;
	 
	//Office address
	
	@FindBy(how=How.CSS, using="#li_off_house_no")
	private WebElement OfficeNo;
	
	@FindBy(how=How.CSS, using="#li_off_street")
	private WebElement Officestreet;
	
	@FindBy(how=How.CSS, using="#li_off_area")
	private WebElement OfficeArea;
	
	@FindBy(how=How.CSS, using="#generic_details_step1")
	private WebElement genricCLick;
	
	// ====================== Contact Details =====================================//
	@FindBy(how=How.CSS, using="#sbi_relation_no")
	private WebElement RelationNo;
	
	@FindBy(how=How.CSS, using="#li_designation")
	private WebElement designation;
	
	@FindBy(how=How.CSS, using="#bankwise_controls_submit")
	private WebElement FinalSubmit;
	
	public CC_SBI_Page(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	// ========== Verify Basic Details Page Header =================================//
	public void enterBasicdetailsToCheckLoanEligibility() 
	{

	try {
			driver.findElement(By.cssSelector("#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li.dropdown > a")).click();
			driver.findElement(By.cssSelector("#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li.dropdown.open > ul > li:nth-child(1) > a")).click();
			
			Thread.sleep(2000);
			
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
			 
			 boolean TextPresent3 = driver.getPageSource().contains(Google_Analytics);
			 Assert.assertTrue(TextPresent3, "Google_Analytics Pixel is Not fired "+Google_Analytics);
			
			fname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "full_name"));
			//logger.log(LogStatus.INFO,"Enter first name : ");
			pincode.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "pincode"));
			empType.click();
			Select employeeTyp=new Select(empType);
			employeeTyp.selectByIndex(1);
			
			companyname.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "company"));
			Thread.sleep(8000);
			driver.findElement(By.cssSelector("#a_loc1")).click();
			salary.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "salary"));
			email.sendKeys(Base.loadPropertiesFile("CC_Data.properties", "email"));
			mobile.sendKeys(mobileno);	
			System.out.println("Mobile_No is:"+mobileno);
			clickNextBtn.click();
			
			Thread.sleep(4000);
			
	} catch (Exception e1) {
		
		    System.out.println("Failed on Baisc Detailed Page :"+e1.getMessage());
		  //  tearDown();
	}
		
   //==============  OTP Verify =================================================== //
		
	try {
		//OTP Verify
		
				String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
				System.out.println("OTP Is:"+passwrd);
				
				String string=String.valueOf(passwrd);
				char[] ch=string.toCharArray();
				//System.out.println(ch[3]);
				
			    driver.findElement(By.cssSelector("#txt_otp0")).sendKeys(CharBuffer.wrap(new char[]{ch[0]}));
				driver.findElement(By.cssSelector("#txt_otp1")).sendKeys(CharBuffer.wrap(new char[]{ch[1]}));
				driver.findElement(By.cssSelector("#txt_otp2")).sendKeys(CharBuffer.wrap(new char[]{ch[2]}));
				driver.findElement(By.cssSelector("#txt_otp3")).sendKeys(CharBuffer.wrap(new char[]{ch[3]}));
				driver.findElement(By.cssSelector("#txt_otp4")).sendKeys(CharBuffer.wrap(new char[]{ch[4]}));
				driver.findElement(By.cssSelector("#txt_otp5")).sendKeys(CharBuffer.wrap(new char[]{ch[5]}));
				driver.findElement(By.xpath("//*[@id=\"mobile_verification\"]/div[1]/div/div/div[2]/label/span")).click();
				driver.findElement(By.cssSelector("#mobile_verification > div > div > div > a")).click();
				
				Thread.sleep(2000);
				System.out.println("Sucessfully submitted OTP");
	} catch (Exception e) {
		
		System.out.println("Otp screen failure "+e.getMessage());
		//tearDown();
	}
		
	}	
		
	public void CC_check_Eligibility() throws Exception {
		
		 try {
				boolean isTheTextPresent4 = driver.getPageSource().contains(Conversion);
				 Assert.assertTrue(isTheTextPresent4, "Conversion Pixel is Not fired "+Conversion);
				
				 boolean isTheTextPresent = driver.getPageSource().contains(gtag);
				 Assert.assertTrue(isTheTextPresent, "gtag Pixel is Not fired "+gtag);
				 
				 boolean TextPresent = driver.getPageSource().contains(RemarketingTag1);
				 Assert.assertTrue(TextPresent, "Remarketing Tag1 Pixel is Not fired "+RemarketingTag1);
				
				 boolean TextPresent1 = driver.getPageSource().contains(RemarketingTag2);
				 Assert.assertTrue(TextPresent1, "Remarketing Tag2 Pixel is Not fired "+RemarketingTag2);
				 
				 boolean TextPresent2 = driver.getPageSource().contains(RemarketingTag3);
				 Assert.assertTrue(TextPresent2, "Remarketing Tag3 Pixel is Not fired "+RemarketingTag3);
				 
				 boolean TextPresent3 = driver.getPageSource().contains(Google_Analytics);
				 Assert.assertTrue(TextPresent3, "Google_Analytics Pixel is Not fired "+Google_Analytics);
				 System.out.println("Pixel is fired");
			} catch (Exception e) {
				
				System.out.println("Pixel is not fire :"+e.getMessage());
			}
		
		try {
		
			WebElement day=driver.findElement(By.cssSelector("#li_birthdate"));
			Select dropdown11=new Select(day);
			dropdown11.selectByVisibleText("04");
			
			WebElement month=driver.findElement(By.cssSelector("#li_birthmonth"));
			Select mon=new Select(month);
			mon.selectByVisibleText("MAR - 03");
			
			WebElement year=driver.findElement(By.cssSelector("#li_birthyear"));
			Select yy=new Select(year);
			yy.selectByVisibleText("1986");
			
			gender.click();
					
			WebElement salry=driver.findElement(By.cssSelector("#li_salary_mode"));
			Select modeSal=new Select(salry);
			modeSal.selectByVisibleText("HDFC Bank");
			
			existingCard.click();
			Officepincode.sendKeys("110040");
			PanNo.sendKeys(Base.randommPAN());
			Submit.click();
			
			WebDriverWait wait = new WebDriverWait(driver, 70);
			wait.until(ExpectedConditions.visibilityOf(PanKarza));
			
			PanKarza.click();
			System.out.println("PanKarza popup clicked");
			Thread.sleep(2000);
		} catch (Exception e) {
			
			System.out.println("Failure on eligibility form:"+e.getMessage());
			//tearDown();
		}
	
	}
	
	public void general_Information() throws Exception {
		
		try {
			
			ViewMore.click();
			Thread.sleep(2000);
					
			ClickCard.click();
			 System.out.println("card selected successfully");
			//Marital Status
			MaritalStatus.click();
			//Qualification.click();
			WebElement edu = driver.findElement(By.cssSelector("#employmentSelect"));
			Select dropdown = new Select(edu);
			dropdown.selectByVisibleText("Post Graduate");
			
			JavascriptExecutor js11 = (JavascriptExecutor) driver;
			 js11.executeScript("window.scrollBy(0,400)");
			
			//Present residential address//
			 houseNo.sendKeys("10");
			 street.sendKeys("Delhi");
			 ResArea.sendKeys("Delhi");
			Thread.sleep(2000);
			JavascriptExecutor js1 = (JavascriptExecutor) driver;
			 js1.executeScript("window.scrollBy(0,400)");
			 
			//Office address
			 OfficeNo.sendKeys("10");
			 Officestreet.sendKeys("Delhi");
			 OfficeArea.sendKeys("Delhi");
				
			 genricCLick.click();
			 System.out.println("genral information filled successfully");
		} catch (Exception e) {
			
			System.out.println("Failure on genral information form:"+e.getMessage());
			//tearDown();
		}
	
		
	}
	
	public void contact_Details() throws Exception {
		
		try {
			RelationNo.click();
			designation.sendKeys("Software Tester");
			Thread.sleep(2000);
			designation.click();
			FinalSubmit.click();
			
             Thread.sleep(2000);
			
			boolean isTheTextPresent4 = driver.getPageSource().contains(Conversion);
			 Assert.assertTrue(isTheTextPresent4, "Conversion Pixel is Not fired "+Conversion);
			
			 boolean isTheTextPresent = driver.getPageSource().contains(gtag);
			 Assert.assertTrue(isTheTextPresent, "gtag Pixel is Not fired "+gtag);
			 
			 boolean TextPresent = driver.getPageSource().contains(RemarketingTag1);
			 Assert.assertTrue(TextPresent, "Remarketing Tag1 Pixel is Not fired "+RemarketingTag1);
			
			 boolean TextPresent1 = driver.getPageSource().contains(RemarketingTag2);
			 Assert.assertTrue(TextPresent1, "Remarketing Tag2 Pixel is Not fired "+RemarketingTag2);
			 
			 boolean TextPresent2 = driver.getPageSource().contains(RemarketingTag3);
			 Assert.assertTrue(TextPresent2, "Remarketing Tag3 Pixel is Not fired "+RemarketingTag3);
			 
			 boolean TextPresent3 = driver.getPageSource().contains(Google_Analytics);
			 Assert.assertTrue(TextPresent3, "Google_Analytics Pixel is Not fired "+Google_Analytics);
			 System.out.println("Contact details form submitted successfully");
		} catch (Exception e) {
			
			System.out.println("Failure on contact details:"+e.getMessage());
			//tearDown();
		} 
	}
}
	


package Page_Objects_IndiaLends;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import Utility.Base;

public class CR_Page extends Base{
	
	protected WebDriver driver;
	
	@FindBy(how=How.CSS, using="#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li:nth-child(3) > a")
	private WebElement clickCR;
		
	@FindBy(how=How.CSS, using="#page-top > div.custom-container-section > div.free-creditreport-banner-wrap.position-relative > div.col-lg-4.col-md-5.col-sm-5.banner-overlaytext.left.text-white.pad30t.marg30t.lg-pad0t.lg-marg0t.text-c-sm > div.pad10t.marg10t.border-white-top > div > a")
	private WebElement getStarted;
	
	@FindBy(how=How.CSS, using="#li_first_name")
	private WebElement fname;
	
	@FindBy(how=How.CSS, using="#li_last_name")
	private WebElement lname;
	
	@FindBy(how=How.ID, using="li_birthdate")
	private WebElement dobDate;
	
	@FindBy(how=How.ID, using="li_birthmonth")
	private WebElement dobMN;
	
	@FindBy(how=How.ID, using="li_birthyear")
	private WebElement dobYear;
	
	@FindBy(how=How.CSS, using="#gender_male")
	private WebElement gender;
	
	@FindBy(how=How.CSS, using="#li_res_pin")
	private WebElement pincode;
	
	@FindBy(how=How.CSS, using="#salaried")
	private WebElement employment;
	
	@FindBy(how=How.CSS, using="#li_monthly_salary")
	private WebElement salary;
	
	@FindBy(how=How.CSS, using="#li_pan_number")
	private WebElement panno;
	
	@FindBy(how=How.CSS, using="#li_mobile_number")
	private WebElement mobileNo;
	
	@FindBy(how=How.CSS, using="#li_email_id")
	private WebElement emailId;
	
	@FindBy(how=How.CSS, using="#li_submit_one")
	private WebElement frmSubmit;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"txt_otp\"]")
	private WebElement otptake;
	
	@FindBy(how=How.XPATH, using="//*[@id=\"btn_mobile_verify\"]")
	private WebElement otpVerify;
	
	public CR_Page(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}



public void enterCRdetails()  {
	
	try {
		
 // ========================== CR FORM ========================================= //
		
		
		clickCR.click();
		getStarted.click();
		
		fname.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "first_name"));
		lname.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "lastname"));
		
		Select date=new Select(dobDate);
		date.selectByVisibleText(Base.loadPropertiesFile("CR_Data.properties", "dob_day"));
		
		Select mon=new Select(dobMN);
		mon.selectByVisibleText(Base.loadPropertiesFile("CR_Data.properties", "dob_month"));
		
		Select yr=new Select(dobYear);
		yr.selectByVisibleText(Base.loadPropertiesFile("CR_Data.properties", "dob_year"));
		
		//Thread.sleep(2000);
		gender.click();
		pincode.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "pin_code"));
		employment.click();
		salary.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "salary"));
		panno.sendKeys(pancard);
		mobileNo.sendKeys(mobileno);
		emailId.sendKeys(email);
		frmSubmit.click();
		System.out.println("CR form succesfully submitted");
	} catch (Exception e) {
		
		System.out.println("CR Form Failure: "+e.getMessage());
	}
	
//=============================== OTP Screen ========================================================= //
	try {
		String passwrd = Utility.Otp_Call.request_otp(otpURL, mobileno);
		System.out.println("Mobile No is: "+mobileno);
		otptake.sendKeys(passwrd);
		otpVerify.click();
		
		Actions action = new Actions(driver); 
		action.sendKeys(Keys.ENTER).build().perform();
		
		System.out.println("Sucessfully submitted OTP");
	} catch (Exception e) {
		
		System.out.println("Failure on OTP screen: "+e.getMessage());
	}   

//=============================== Report section ========================================================= //
    try {
		WebDriverWait wait=new WebDriverWait(driver, 50);
		WebElement CR_report;
		CR_report= wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#form_container > div > div.container.pad10t.pad30b > div.col-lg-12.marg30t.sm-marg10t.pad20t.pad0r.pad0l > div > div.panel-body.pad0 > div > h4")));
		String report=CR_report.getText();
			
		String expected="You Are New to Credit!";
		if (report.contentEquals(expected))
		{
			System.out.println("CR Report is: "+report);
		}
		else {
			System.out.println("CR Report is not matching with correct one.");
		}
//================= Screenshot take ============================================= //	
		Date date = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmm");  
		String strDate= formatter.format(date); 
		
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
				+ "//screenshot//Live//"+strDate+ "CR.png"));
	} catch (Exception e) {
		
		System.out.println("Failure in result capture screen: "+e.getMessage());
	}
}

}



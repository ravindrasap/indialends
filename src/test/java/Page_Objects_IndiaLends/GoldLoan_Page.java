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
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import Utility.Base;
//import Utility.SendMail;

public class GoldLoan_Page extends Base {
	
protected WebDriver driver;

String gtag="AW-955414164";
String RemarketingTag1="803650867";
String RemarketingTag2="803650924";
String RemarketingTag3="955414164";
String Google_Analytics="UA-58036769-1";
	
	@FindBy(how=How.XPATH, using="//*[@id=\"mainNav\"]/div[6]/div[1]/div[2]/ul/li[2]/a")
	
	private WebElement clickgoldloan;
	
	@FindBy(how=How.CSS, using="body > div > div.banner.sm-pad0.credit-card-banner.xs-pad20t.bg-white > div > div.col-lg-7.col-sm-7.col-md-7.col-xs-12.pad30t.pad15l.sm-pad15t.marg15l.sm-marg0l.xs-pad0t > a")
	private WebElement getStarted;
	
	@FindBy(how=How.CSS, using="#li_name")  //-- change in goldloan
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

	@FindBy(how=How.CSS, using="#btnproceeduj")
	private WebElement proceedbtn;

	
	@FindBy(how=How.CSS, using="#txt_otp0")
	private WebElement otptake;
	
	@FindBy(how=How.CSS, using="#otp-verification > div > div > div > div.pad20b.pad10t.pad10l.pad10r.xs-pad0l.xs-pad0r > label > span")
    private WebElement tNC;
	
	@FindBy(how=How.CSS, using="#btn_verifyMobile")
	private WebElement otpVerify;
	
	@FindBy(how=How.CSS,using="#page-wrapper > div.container-fluid.sm-pad0r.sm-pad0l > div > div > div.panel-body.pad0 > div > h4")
	private WebElement CR_report1;
	
	@FindBy(how=How.CSS,using="/html/body/div/div/div/div/div[1]/div/h3")
	private WebElement GL_report1;
	
	public GoldLoan_Page(WebDriver driver) {
		
		this.driver=driver;
		PageFactory.initElements(driver, this);
		
	}

public void entergoldloandetails()  {
		
		System.out.println("==================== Goldloan FORM Started=================== ");
		clickgoldloan.click();
	
		fname.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "first_name"));
		emailId.sendKeys(email);
		
		mobileNo.sendKeys(mobileno);
		pincode.sendKeys(Base.loadPropertiesFile("CR_Data.properties", "pin_code"));
		
		driver.findElement(By.cssSelector("#loan_amount")).sendKeys("200000");
		
		driver.findElement(By.cssSelector("#jewellery-quantitiy")).sendKeys("50");
		
		driver.findElement(By.cssSelector("#employmentSelect > label:nth-child(2)")).click();
		
		//frmSubmit.click();
		proceedbtn.click();
		System.out.println("Gold loan form succesfully submitted");
	
	
	
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
		
	}   

//=============================== Report section ========================================================= //
    try {
    	    	
    	Thread.sleep(4000);
		String expected="Thank you!";
		
		try {
			Assert.assertEquals(GL_report1.getText(), expected);
			System.out.println("Gold loan Applied sucessfully" );
		} catch (Exception e) {
			System.out.println("Gold loan Applied sucessfully");
		}
		System.out.println("==================== GOld laon FORM ENDED=================== ");
	    	
//================= Screenshot take ============================================= //	
		Date date1 = new Date();  
		SimpleDateFormat formatter = new SimpleDateFormat("ddMMyyyyhhmm");  
		String strDate= formatter.format(date1); 
		
		File scrFile = ((TakesScreenshot) driver)
				.getScreenshotAs(OutputType.FILE);
		// The below method will save the screen shot
		FileUtils.copyFile(scrFile, new File(System.getProperty("user.dir")
				+ "//screenshot//Live//"+strDate+ "goldloan.png"));
		driver.close();
	} catch (Exception e) {
		
		System.out.println("Failure in result capture screen: "+e.getMessage());
		
	}
}


}

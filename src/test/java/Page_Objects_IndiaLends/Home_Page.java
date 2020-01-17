package Page_Objects_IndiaLends;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import Utility.Base;

public class Home_Page extends Base {
	
	   protected WebDriver driver;
	   
	 //=========================== Locator for Home page in header =============================================================== //

		@FindBy(how=How.CSS, using="#mainNav > div.container-fluid.md-pad10b.sm-pad0b > div.col-xs-12.col-sm-12.col-md-9.pad0 > div.collapse.navbar-collapse.navbar-ex1-collapse.pad10t.sm-pad0t.full-width > ul > li:nth-child(1) > a")
		private WebElement clickPl;
		
		// ============ Header text ===
		@FindBy(how=How.CSS,using ="#IndiaLends services are 100% FREE for all our customers. We do not charge for any of our services.")
		
		private WebElement Text;
		
		/// Vrify the indialends logo==========
		
		@FindBy(how=How.CSS, using ="#navbar-brand pad5t")
		
		private WebElement Logo;	
		
		// verify the header name ======
		
		
		// Verify the Login link ========
		
		
		// Verify the app logo ==========
		
		
		
		
		
		public Home_Page(WebDriver driver) {
			
			this.driver=driver;
			PageFactory.initElements(driver, this);
			
		}

		
		
		@FindBy(how=How.CSS, using="#div_frmc>div>div>div:nth-child(4)>h1")
		private WebElement header;




public void Homepagedetails()  {
	
	
    }

	

//=============================  HOME PAGE verification Code =====================






//  Brocken link =====

public class HomepageBrokenLinks {
    
  //  private static WebDriver driver = null;

   // public static void main(String[] args)
    {
        // TODO Auto-generated method stub
        
        String homePage = "http://www.zlti.com";
        String url = "";
        HttpURLConnection huc = null;
        int respCode = 200;
        
      //  driver = new ChromeDriver();
        
        //driver.manage().window().maximize();
        
        //driver.get(homePage);
        
        List<WebElement> links = driver.findElements(By.tagName("a"));
        
        Iterator<WebElement> it = links.iterator();
        
        while(it.hasNext()){
            
            url = it.next().getAttribute("href");
            
            System.out.println(url);
        
            if(url == null || url.isEmpty()){
System.out.println("URL is either not configured for anchor tag or it is empty");
                continue;
            }
            
            if(!url.startsWith(homePage)){
                System.out.println("URL belongs to another domain, skipping it.");
                continue;
            }
            
            try {
                huc = (HttpURLConnection)(new URL(url).openConnection());
                
                huc.setRequestMethod("HEAD");
                
                huc.connect();
                
                respCode = huc.getResponseCode();
                
                if(respCode >= 400){
                    System.out.println(url+" is a broken link");
                }
                else{
                    System.out.println(url+" is a valid link");
                }
                    
            } catch (MalformedURLException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        
      //  driver.quit();

    }
}
}
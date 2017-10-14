package Validate_Google_Analytics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Links_Marketing_tab 
{
	WebDriver driver;
	
	 String all_link_under_start_with_the_basics_marketing = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//div[@class='primary-content'][@style='display: block;']";;
	 String all_links = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]/descendant::h3[2]/following-sibling::div[1]";
	 
	@BeforeMethod //This runs before every test 
   public void open_chrome1() //This opens the chrome instance
   {
		
    driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://pages.mail.salesforce.com/gettingstarted/home/");
	 Page_Object_For_Model p = new Page_Object_For_Model(driver);	
	 driver.findElement(p.marketing_tab).click();
	
   }
	
	@Test(priority =1)
	public void Validate_Links_Starts_With_Basics_marketing() throws Exception
	{   
		Thread.sleep(5000);
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		p.validate_URL_sales(all_link_under_start_with_the_basics_marketing);
	}
	
	@Test(priority =1)
	public void Validate_optimize_your_implementation_marketing() throws Exception
	{   
		Thread.sleep(5000);
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		driver.findElement(By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]/descendant::h3[2]")).click();
		Thread.sleep(3000);
		p.validate_URL_sales(all_links);
	}

    @AfterMethod
      public void close_chrome()
    {
	driver.quit();
    }
}

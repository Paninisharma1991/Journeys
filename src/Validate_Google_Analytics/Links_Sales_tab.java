package Validate_Google_Analytics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Links_Sales_tab 
{
	
	WebDriver driver;
	 
    String all_links =  "//div[@class='primary-content-noindent'][@style='display: block;']";
    String all_link_under_start_with_the_basics = "//div[@class='primary-content']";
    
    
    
    @BeforeMethod //This runs before every test 
    public void open_chrome() //This opens the chrome instance
    {
     driver=new ChromeDriver();
	 driver.manage().window().maximize();
	 driver.get("http://pages.mail.salesforce.com/gettingstarted/home/");
	 
    }
    
	@Test(priority=0)
	public void Validate_Links_Starts_With_Basics()
	{
		Page_Object_For_Model  p = new Page_Object_For_Model(driver);
		p.validate_URL_sales(all_link_under_start_with_the_basics);
	}
	
	@Test(priority=1)
	public void validate_Driver_options_links() throws Exception
	{
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		p.click_tab_start_with_the_basics();
		Thread.sleep(5000);
		driver.findElement(p.driver_adoption).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links);
	}
	
	@Test(priority=2)
	public void validate_optimize_your_implementation() throws Exception
	{
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		p.click_tab_start_with_the_basics();
		Thread.sleep(5000);
		driver.findElement(p.optimize_your_implementation).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links);
	}
	@Test(priority=3)
	public void validate_import_manage_your_data() throws Exception
	{
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		Thread.sleep(5000);
		driver.findElement(p.import_manage_your_data).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links);
	}
	
	@Test(priority=4)
	public void validate_develop_and_maintain_your_implementation() throws Exception
	{
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		p.click_tab_start_with_the_basics();
		Thread.sleep(5000);
		driver.findElement(p.develop_and_maintain_your_implementation).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links);
	}
	
	@AfterMethod
	public void close_chrome()
	{
		driver.quit();
	}

}

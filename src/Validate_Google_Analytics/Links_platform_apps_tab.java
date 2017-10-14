package Validate_Google_Analytics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Links_platform_apps_tab 
{

	WebDriver driver;
	
	 String all_link_under_start_with_the_basics_platform_apps = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//div[@class='primary-content'][@style='display: block;']";;
	 String all_links = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]/descendant::h3[2]/following-sibling::div[1]";
	 String all_links_d_m_i = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/div//child::h3[3]/following-sibling::div";
     String all_links_i_m_d 	= "//*[@class='resp-tab-content tabnav resp-tab-content-active']/div//child::h3[3]/following-sibling::div[2]" ;
 @BeforeMethod //This runs before every test 
 public void open_chrome1() //This opens the chrome instance
 {
		
	 	driver=new ChromeDriver();
	 	driver.manage().window().maximize();
	 	driver.get("http://pages.mail.salesforce.com/gettingstarted/home/");
	 	Page_Object_For_Model p = new Page_Object_For_Model(driver);	
	 	driver.findElement(p.platform_apps_tab).click();
	
 }
 
 @Test(priority =1)
	public void Validate_develop_apps_maintain_integration() throws Exception
	{   
		Thread.sleep(5000);
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		p.validate_URL_sales(all_link_under_start_with_the_basics_platform_apps);
	}
 @Test(priority=2)

	public void validate_driver_adoption_community() throws Exception
	{
	 Page_Object_For_Model p = new Page_Object_For_Model(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='tab-pane active business-goals-inset']//*[@class='accordion-links'][contains(text(), 'Develop Apps and Maintain Your Implementation')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[2]")).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links);
	}
 
 @Test(priority=1)

	public void validate_optimize_your_implementation_links_community() throws Exception
	{
	 Page_Object_For_Model p = new Page_Object_For_Model(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='tab-pane active business-goals-inset']//*[@class='accordion-links'][contains(text(), 'Develop Apps and Maintain Your Implementation')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[3]")).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links_d_m_i);
	}
 
 @Test(priority=2)
 
	public void import_manage_your_data_links() throws Exception
	{
	 Page_Object_For_Model p = new Page_Object_For_Model(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='tab-pane active business-goals-inset']//*[@class='accordion-links'][contains(text(), 'Develop Apps and Maintain Your Implementation')]")).click();
		Thread.sleep(5000);
		driver.findElement(p.import_manage_your_data__platform_apps).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links_i_m_d);
	}
	
 @AfterMethod
	public void close_chrome()
	{
		driver.quit();
	}
 
}

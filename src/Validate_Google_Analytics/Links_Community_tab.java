package Validate_Google_Analytics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;


public class Links_Community_tab 
{

	WebDriver driver;
	
	 String all_link_under_start_with_the_basics_marketing = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//div[@class='primary-content'][@style='display: block;']";;
	 String all_links = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]/descendant::h3[2]/following-sibling::div[1]";
	 String all_links_d_m_i = "//*[@class='resp-tab-content tabnav resp-tab-content-active']/div//child::h3[3]/following-sibling::div";
	
  @BeforeMethod //This runs before every test 
  public void open_chrome1() //This opens the chrome instance
  {
		
   driver=new ChromeDriver();
	driver.manage().window().maximize();
	driver.get("http://pages.mail.salesforce.com/gettingstarted/home/");
	Page_Object_For_Model p = new Page_Object_For_Model(driver);	
	driver.findElement(p.community_tab).click();
	
  }
	
	@Test(priority =1)
	public void Validate_Links_Starts_With_Basics_community() throws Exception
	{   
		Thread.sleep(5000);
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		p.validate_URL_sales(all_link_under_start_with_the_basics_marketing);
	}
	
	@Test(priority=2)

	public void validate_optimize_your_implementation_links_community() throws Exception
	{
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='resp-tab-content tabnav resp-tab-content-active']//*[@class='accordion-links'][contains(text(), 'Start with the Basics')]")).click();
		Thread.sleep(5000);
		driver.findElement(By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]/descendant::h3[2]")).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links);
	}
	
	@Test(priority=3)
	public void develop_and_maintain_your_implementation() throws Exception
	{
		Page_Object_For_Model p = new Page_Object_For_Model(driver);
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[@class='resp-tab-content tabnav resp-tab-content-active']//*[@class='accordion-links'][contains(text(), 'Start with the Basics')]")).click();
		Thread.sleep(5000);
		driver.findElement(p.develop_and_maintain_your_implementation_community).click();
		Thread.sleep(5000);
		p.validate_URL_sales(all_links_d_m_i);
	}
	
	@AfterMethod
	public void close_chrome()
	{
		driver.quit();
	}
}

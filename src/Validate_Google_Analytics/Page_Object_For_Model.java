package Validate_Google_Analytics;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Page_Object_For_Model 
{
	WebDriver driver;
	//***** These xpaths are from the sales tab of getting started page *****//
	
	  
	By start_with_the_basics = By.xpath("//*[@class='accordion-links']/i[@class='fa hub-plus-expander pull-right fa-minus']");
	By driver_adoption = By.xpath("//*[@class='accordion-links'][contains(text(), 'Drive Adoption')]");
	By optimize_your_implementation = By.xpath("//*[@class='accordion-links'][contains(text(), 'Optimize Your Implementation')]");
	By import_manage_your_data = By.xpath("//*[@class='accordion-links'][contains(text(), 'Import and Manage Your Data')]");
	By develop_and_maintain_your_implementation = By.xpath("//*[@class='accordion-links'][contains(text(), 'Develop and Maintain Your Implementation')]");
	By all_links = By.xpath("//div[@class='primary-content-noindent'][@style='display: block;']");
	By all_link_under_start_with_the_basics = By.xpath("//div[@class='primary-content']");
	
	
	//****************************************************************************//
	
	//***** These xpaths are from the service tab of getting started page *****//
	
	By serivce_tab = By.xpath("//*[@class='resp-tabs-list tabnav']/child::li[2]");
	By driver_adoption_service = By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[2]");
	By optimize_your_implementation_service = By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[3]");
	By import_manage_your_data_service =  By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[4]");
	By develop_and_maintain_your_implementation_service = By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[5]");
	
	//***** These xpaths are from the Marketing tab of getting started page *****//
	By marketing_tab = By.xpath("//*[@class='resp-tabs-list tabnav']/child::li[3]");
	By start_with_the_basics_marketing = By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]/descendant::h3[1]");
	By optimize_your_implementation_marketing = By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]/descendant::h3[2]");
	
	
	//***** These xpaths are from the Community tab of getting started page *****//
	By community_tab = By.xpath("//*[@class='resp-tabs-list tabnav']/child::li[4]");
	By develop_and_maintain_your_implementation_community = By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[3]");

	//***** These xpaths are from the Analytics tab of getting started page *****//
	By Analytics_tab = By.xpath("//*[@class='resp-tabs-list tabnav']/child::li[5]");
	By import_manage_your_data_Analytics = By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[2]");
	
	//***** These xpaths are from the Platform and apps tab of getting started page *****//
	By platform_apps_tab = By.xpath("//*[@class='resp-tabs-list tabnav']/child::li[6]");
	By Develop_apps_maintain_your_implementation = By.xpath("//*[@class='tab-pane active business-goals-inset']//*[@class='accordion-links'][contains(text(), 'Develop Apps and Maintain Your Implementation')]");
	By import_manage_your_data__platform_apps =  By.xpath("//*[@class='resp-tab-content tabnav resp-tab-content-active']/child::div[1]//descendant::h3[4]");
	
	public Page_Object_For_Model (WebDriver driver)
	{
		this.driver = driver;
	}
	
    //***** Author: Panini ***** //
	//***** Description: This will collapse the expanded start_with_the_basics tab on the sales tab *****//
	public void click_tab_start_with_the_basics()
	{
		driver.findElement(start_with_the_basics).click();
	}
	
	//***** Author: Panini ****** //
   //****** Description: Verifies if each url on the start page has "//pages.mail.salesforce.com/" and a trailing slash(/) at the end ****//
	
	//******Author: Panini******//
	//*****This function is for the implicit wait**********//
	
	
	public void validate_URL_sales(String xpath)
	{       
		
		try {
	        
		    String parent_window = driver.getWindowHandle(); //gets the string value of the getting started page
			WebElement s_w_b = driver.findElement(By.xpath(xpath)); //This xpath will highlight the block of the collapsible tab
			List<WebElement> link_text = s_w_b.findElements(By.tagName("a")); //link_text will store all the links under the collapsible tab.
			int linkCount =0; // required for counting the number of links under each collapsible tab
			
				for(WebElement links : link_text) // enhanced for loop makes it possible to click over each link by iterating over them.
				{
				link_text.get(linkCount).click();
				linkCount++;
				}
	
				System.out.println(linkCount); //gets the total link count from each collapsible tab
				Set<String> child_windows = driver.getWindowHandles(); //stores all the string values of the child windows
				int i = child_windows.size(); //gets the size of the window
				String winHandle=child_windows.iterator().next();
	
				for (String handle1 : driver.getWindowHandles()) //This for loop will push the driver instance into each child windows
				{
				driver.switchTo().window(handle1);
				String url_child = driver.getCurrentUrl();
				String source = driver.getPageSource();		
				Boolean s = source.contains("(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){\n" + 
						"  (i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),\n" + 
						"  m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)\n" + 
						"  })(window,document,'script','https://www.google-analytics.com/analytics.js','ga');\n" + 
						"\n" + 
						"  ga('create', 'UA-80844926-1', 'auto');\n" + 
						"  ga('send', 'pageview');\n" + 
						"\n" + 
						"");
				
				if(s==false)
				{
				System.out.println("The page does not have Google Analytics code" +url_child);
				}

				}
				
		}
		
		catch(Exception e)
		{
			System.out.println("exception occured " +e.getMessage() );
		}
		
	}


}

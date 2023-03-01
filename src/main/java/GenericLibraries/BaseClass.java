package GenericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.ContactUsPage;
import PomPages.CoreJavaSeleniumpage;
import PomPages.CoreJavaVideopage;
import PomPages.Homepage;
import PomPages.SeleniumTrainingPage;
import PomPages.SkillraryDemoApppage;
import PomPages.TestingPage;

public class BaseClass 
{
	protected PropertyFileUtility property;
	protected ExcelUtility excel;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected Homepage home;
	protected SkillraryDemoApppage skillraryDemo;
	protected SeleniumTrainingPage selenium;
	protected CoreJavaSeleniumpage corejava;
	protected CoreJavaVideopage javavideo;
	protected TestingPage testing;
	protected ContactUsPage contact;
	
	
	//@BeforeSuite
	//@BeforeTest
	@BeforeClass
	 public void classConfiguration()
	 {
		 property= new PropertyFileUtility();
		 excel= new ExcelUtility();
		 web= new WebDriverUtility();
		 
		 property.property_file_inilization(IConstantPath.PROPERTIES_FILE_PATH);
		 excel.excel_Intilization(IConstantPath.EXCEL_FILE_PATH);
		 
		 
		 
	 }
	@BeforeMethod
	public void methodConfiguration()
	{
		long time= Long.parseLong(property.fetchProperty("timeouts"));
		 driver=web.openApplication(property.fetchProperty("browser"), 
				 property.fetchProperty("url"), time);
		 
		 home= new Homepage(driver);
		 Assert.assertTrue(home.getLogo().isDisplayed());
		 skillraryDemo= new SkillraryDemoApppage(driver);
		 selenium=new SeleniumTrainingPage(driver);
		 corejava=new CoreJavaSeleniumpage(driver);
		 javavideo=new CoreJavaVideopage(driver);
		 testing=new TestingPage(driver);
		 contact = new ContactUsPage(driver); 
		 
	}
	@AfterMethod
	public void methodTearDown()
	{
		web.quitBrowser();
	}
	@AfterClass
	public void classTearDown()
	{
		excel.closeExcel();
	}
	//@AfterTest
	//@AfterSuite

}

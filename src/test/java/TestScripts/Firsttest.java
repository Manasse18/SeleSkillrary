package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class Firsttest extends BaseClass
{
	@Test
	public void firstest() throws InterruptedException
	{
		SoftAssert soft = new SoftAssert();
		home.clickGears();
		home.clickSkillrarydemoApp();
		web.handleChildBrowser();
		
		soft.assertEquals(skillraryDemo.getPageHeader().getText(),"SkillRary-ECommerce");
		
		skillraryDemo.mouseHoverTocourse(web);
		skillraryDemo.clickSeleniumTraining();
		
		soft.assertEquals(selenium.getPageHeader(),"Selenium Training");
		selenium.doubleClickPlusButton(web);
		selenium.clickAddToCart();
		//Thread.sleep(2000);
		web.handleAlert();
		
		soft.assertAll();
	}

}

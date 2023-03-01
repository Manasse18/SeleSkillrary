package TestScripts;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class ThridTest  extends  BaseClass
{
	@Test
	public void thridtest() throws InterruptedException
	{
		SoftAssert soft= new SoftAssert();
		home.searchFor("core java for selenium");
		soft.assertEquals(corejava.getPageHeader(), "CORE JAVA FOR SELENIUM");
		
		corejava.clickCoreJavaForSeleniumLink();
		soft.assertEquals(javavideo.pageHeader(), "Core Java For Selenium Training");
		
		//javavideo.clickcloseCookies();
		web.switchToFrame();
		javavideo.clickPlayButton();
		Thread.sleep(2000);
		javavideo.clickPauseButton();
		
		web.switchBackFromFrame();
		
		//javavideo.AddtoWishlist();
		
		soft.assertAll();
	}
	
	
}

package TestScripts;

import java.util.List;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import GenericLibraries.BaseClass;

public class fourthtest extends BaseClass
{
	@Test
	public void foruthtest()
	{
		SoftAssert soft= new SoftAssert();
		home.clickGears();
		home.clickSkillrarydemoApp();
		web.handleChildBrowser();
		
		soft.assertEquals(skillraryDemo.getPageHeader(),"Skillrary");
		web.scrollToElement(skillraryDemo.getContactUs());
		skillraryDemo.clickContactUs();
		
		soft.assertTrue(contact.getpageHeader().isDisplayed());
		List<String> datalist=excel.fetchDataFromExcel("Sheet1");
		contact.submitDetails(datalist.get(0), datalist.get(1), datalist.get(2), datalist.get(3));
		
		soft.assertAll();
	}

}


package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import page.BasePage;
import page.HomepageTG;
import util.Browserfactory;

public class TestTestNG extends BasePage{
	static String cat ="Work_Related"+RandomGen(1000);
	WebDriver driver;
	@BeforeTest
	public void Launcher() {
		driver= Browserfactory.init();
		
	}
	
	@Test(priority=1)
	public void TestCase1() {
		HomepageTG homepageTG =PageFactory.initElements(driver, HomepageTG.class);
		homepageTG.addCategoryInteraction(cat);
}
	@Test(priority=2)
	public void TestCase2() {
		HomepageTG homepageTG =PageFactory.initElements(driver, HomepageTG.class);
		homepageTG.DuplicateCategoryNOTAllowed(cat);
	
	}
	
@Test	(priority=3)
public void TestCase3() {
		HomepageTG homepageTG =PageFactory.initElements(driver, HomepageTG.class);
		homepageTG.validateallMonthExist();
	}


	
//@AfterTest
//public void teardown() {
//	Browserfactory.teardown();
//}
}


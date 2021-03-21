package page;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.Select;

public class HomepageTG extends BasePage {

	WebDriver driver;

	public HomepageTG(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[name='allbox']")
	WebElement TOGGLEBOX;
	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement RemoveButton;
	// @FindBy(how =How.CSS, using="input[name='data']") WebElement AddTextBox;
	@FindBy(how = How.CSS, using = "ul[style='list-style-type: none; padding-left:0']")
	WebElement AllCheckBoxes;
	@FindBy(how = How.CSS, using = "input[type='checkbox']")
	List<WebElement> AllCheckBoxes2; // includes the toggle checkboc
	@FindBy(how = How.XPATH, using = "//li/input[@type='checkbox']")
	List<WebElement> AllCheckBoxes3; // without the toggle checkbox

	@FindBy(how = How.CSS, using = "input[type='text'][name='data']")
	WebElement AddTextBox;
	@FindBy(how = How.CSS, using = "input[type='submit'][value='Add']")
	WebElement AddButton;
	@FindBy(how = How.CSS, using = "input[name='categorydata']")
	WebElement AddCategoryText;
	@FindBy(how = How.CSS, using = "input[value='Add category']")
	WebElement AddCategoryButton;
	@FindBy(how = How.XPATH, using = "/html/body/div[3]/a/span")
	List<WebElement> AllCategories;
	@FindBy(how = How.XPATH, using = "//a[@title='Remove this category'][1]")
	WebElement CATEGORIES;
	@FindBy(how = How.CSS, using = "select[name='due_month']")
	WebElement ALLMonths;
	@FindBy(how = How.CSS, using = "button[onclick='myFunctionSky()']")
	WebElement SkyBlueBackButton;

	public void addCategoryInteraction(String Cat) {
		System.out.println(Cat);
		AddCategoryText.sendKeys(Cat);
		AddCategoryButton.click();
		List<WebElement> categoryList = AllCategories;
		for (WebElement i : categoryList) {
			//System.out.println(i.getText());
			if (i.getText().equalsIgnoreCase(Cat)) {
				System.out.println("Entered Category EXIST, Validated");
			}
//			else {
//				System.out.println("NOT validated");
//			}
		}

	}

	public void DuplicateCategoryNOTAllowed(String Cat) {
		AddCategoryText.sendKeys(Cat);
		AddCategoryButton.click();

		String msg = driver.findElement(By.xpath("//body")).getText();
		System.out.println(msg);
		if (msg.contains("The category you want to add already exists")) {
			System.out.println("VALIDATED that Duplicates are not allowed");
		}
	}

	public void validateallMonthExist() {
		Select sel = new Select(ALLMonths);
		List<WebElement> mymonths = sel.getOptions();
		boolean flag = true;
		for (WebElement i : mymonths) {

			if (i.getText().equalsIgnoreCase("Jan") || i.getText().equalsIgnoreCase("Feb")
					|| i.getText().equalsIgnoreCase("Mar") || i.getText().equalsIgnoreCase("Apr")
					|| i.getText().equalsIgnoreCase("May") || i.getText().equalsIgnoreCase("Jun")
					|| i.getText().equalsIgnoreCase("Jul") || i.getText().equalsIgnoreCase("Aug")
					|| i.getText().equalsIgnoreCase("Sep") || i.getText().equalsIgnoreCase("Oct")
					|| i.getText().equalsIgnoreCase("Nov") || i.getText().equalsIgnoreCase("Dec")) {
				flag = true;
				System.out.println(i.getText());
			} else {
				flag = false;
				break;
			}
		}
		if (flag == true) {
			System.out.println("The DROPDOWN has all the months");
		} else {
			System.out.println("MONTH LIST IS NOT COMPLETE");
		}

	}

	public void SkyBlueBackButton() {
		SkyBlueBackButton.click();
		String color = driver.findElement(By.xpath("//body")).getAttribute("style");
		System.out.println(color);
	}
}

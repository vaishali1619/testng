package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

public class googleSearchPage {
	WebDriver driver = null;
	
	By txtSearch = By.xpath("//*[@class='gLFyf gsfi']");
	
	public googleSearchPage(WebDriver driver) {
		this.driver= driver;
	}
	
	public void setsearchTextBox(String text) {
		driver.findElement(txtSearch).sendKeys(text);
		driver.findElement(txtSearch).sendKeys(Keys.RETURN);
	}
	
}

package org.jsystem.webdriver_so;

import org.openqa.selenium.WebDriver;

public interface WebDriverContainer extends HasWebDriver {
	public WebDriver getDriver();
	public void setDriver(WebDriver driver);
}

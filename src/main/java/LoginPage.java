import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import Util.PropertiesFileParameters;

import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class LoginPage extends BasePage {

    private PropertiesFileParameters properties;

    private By usernameBarBy = By.xpath("//input[@name='username']");
    private By passwordBarBy = By.xpath("//input[@name='password']");
    private By loginButtonBy = By.xpath("//button[@type='submit']");

    public LoginPage(WebDriver driver) {
        super(driver);

        this.driver.get(new PropertiesFileParameters().getSutUrl());

        properties = new PropertiesFileParameters();
    }

    public LoginPage typeCorrectUsername() {
        this.waitAndReturnElement(usernameBarBy).sendKeys(properties.getUsername());
        return this;
    }

    public LoginPage typeCorrectPassword() {
        this.waitAndReturnElement(passwordBarBy).sendKeys(properties.getPassword());
        return this;
    }

    public LoginPage typeIncorrectUsername() {
        this.waitAndReturnElement(usernameBarBy).sendKeys("some wrong value");
        return this;
    }

    public LoginPage typeIncorrectPassword() {
        this.waitAndReturnElement(passwordBarBy).sendKeys("some wrong value");
        return this;
    }

    public DashboardPage clickLoginButton() {
        this.waitAndReturnElement(loginButtonBy).click();
        return new DashboardPage(this.driver);
    }

}

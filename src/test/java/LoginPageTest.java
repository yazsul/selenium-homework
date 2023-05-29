import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;

public class LoginPageTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testLoginLogoutSuccessful() {
        LoginPage loginPage = new LoginPage(this.driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"));
        
        loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"));

        loginPage.clickLogout();
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"));        
    }

    @Test
    public void testLoginFailure() {
        LoginPage loginPage = new LoginPage(this.driver);
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"));
        
        loginPage.typeIncorrectUsername().typeCorrectPassword().clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"));

        loginPage.typeCorrectUsername().typeIncorrectPassword().clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"));

        loginPage.typeIncorrectUsername().typeIncorrectPassword().clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/auth/login"));

        loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"));       
    }

    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

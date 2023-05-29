import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;


public class BasePageTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--download.default_directory=src\\test\\resources\\");

        driver = new ChromeDriver(options);
    }

    @Test
    public void testPageTitle() {
        LoginPage loginPage = new LoginPage(this.driver);
        Assert.assertTrue(driver.getTitle().equals("OrangeHRM"));
    }

    @Test
    public void testNavigateToAllCommonPages() {
        LoginPage loginPage = new LoginPage(this.driver);
        loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton();

        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"));

        loginPage.clickAdminButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/viewSystemUsers"));

        loginPage.clickPIMButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewEmployeeList"));

        loginPage.clickLeaveButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave/viewLeaveList"));

        loginPage.clickTimeButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("time/viewEmployeeTimesheet"));

        loginPage.clickRecruitmentButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/recruitment/viewCandidates"));

        loginPage.clickMyInfoButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewPersonalDetails/empNumber/7"));

        loginPage.clickPerformanceButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/performance/searchEvaluatePerformanceReview"));

        loginPage.clickDashboardButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard/index"));

        loginPage.clickDirectoryButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/directory/viewDirectory"));

        loginPage.clickMaintenanceButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/maintenance/purgeEmployee"));
        driver.navigate().back();

        loginPage.clickbuzzButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/buzz/viewBuzz"));        
    }
    
    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

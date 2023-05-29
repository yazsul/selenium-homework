import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;


public class DashboardPageTest {
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
    public void testQuickLaunchButtonsBoxItems(){
        LoginPage loginPage = new LoginPage(this.driver);
        DashboardPage dashboardPage = loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton();

        dashboardPage.clickAssignLeaveButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave/assignLeave"));
        dashboardPage.navigateBack();

        dashboardPage.clickViewLeaveListQuickButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave/viewLeaveList"));
        dashboardPage.navigateBack();

        dashboardPage.clickViewEmployeeTimesheetQuickButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/time/viewEmployeeTimesheet"));
        dashboardPage.navigateBack();

        dashboardPage.clickApplyLeaveButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave/applyLeave"));
        dashboardPage.navigateBack();

        dashboardPage.clickViewMyLeaveListButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave/viewMyLeaveList"));
        dashboardPage.navigateBack();

        dashboardPage.clickViewMyTimesheetButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/time/viewMyTimesheet"));
        dashboardPage.navigateBack();
    }

    @Test
    public void testMyActionsBoxItems() {
        LoginPage loginPage = new LoginPage(this.driver);
        DashboardPage dashboardPage = loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton();

        dashboardPage.clickViewLeaveListButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/leave/viewLeaveList"));
        dashboardPage.navigateBack();

        dashboardPage.clickViewEmployeeTimesheetButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/time/viewEmployeeTimesheet"));
        dashboardPage.navigateBack();

        dashboardPage.clickSearchEvaluatePerformanceReviewButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/performance/searchEvaluatePerformanceReview"));
        dashboardPage.navigateBack();

        dashboardPage.clickViewCandidatesButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/recruitment/viewCandidates?statusId=4"));
        dashboardPage.navigateBack();
    }

    @Test
    public void testTimeBoxItems() {
        LoginPage loginPage = new LoginPage(this.driver);
        DashboardPage dashboardPage = loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton();

        dashboardPage.clickPunchOutButton();
        Assert.assertTrue(driver.getCurrentUrl().contains("/attendance/punch"));
        dashboardPage.navigateBack();
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

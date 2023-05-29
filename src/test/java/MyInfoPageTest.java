import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import java.net.MalformedURLException;

public class MyInfoPageTest {
    public WebDriver driver;
    
    @Before
    public void setup()  throws MalformedURLException  {
        ChromeOptions options = new ChromeOptions();
        
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Test
    public void testNavigateBetweenMyInfoTabs(){
        LoginPage loginPage = new LoginPage(this.driver);
        MyInfoPage myInfoPage = loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton().clickMyInfoButton();

        myInfoPage.clickPersonalDetailsTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewPersonalDetails/empNumber/7"));

        myInfoPage.clickContactDetailsTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/contactDetails/empNumber/7"));

        myInfoPage.clickEmergencyContactsTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewEmergencyContacts/empNumber/7"));

        myInfoPage.clickDependentsTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewDependents/empNumber/7"));

        myInfoPage.clickJobTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewJobDetails/empNumber/7"));

        myInfoPage.clickSalaryTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewSalaryList/empNumber/7"));

        myInfoPage.clickTaxExemptionsTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewUsTaxExemptions/empNumber/7"));

        myInfoPage.clickReportToTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewReportToDetails/empNumber/7"));

        myInfoPage.clickQualificationsTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewQualifications/empNumber/7"));

        myInfoPage.clickMembershipsTab();
        Assert.assertTrue(driver.getCurrentUrl().contains("/pim/viewMemberships/empNumber/7"));
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }
}

import org.junit.*;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;

class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;

    private By adminButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li/a");
    private By PIMButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[2]/a");
    private By leaveButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[3]/a");
    private By timeButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[4]/a");
    private By recruitmentButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[5]/a");
    private By myInfoButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[6]/a");
    private By performanceButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[7]/a");
    private By dashboardButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[8]/a");
    private By directoryButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[9]/a");
    private By maintenanceButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[10]/a");
    private By buzzButtonBy = By.xpath("//div[@id='app']/div/div/aside/nav/div[2]/ul/li[11]/a");

    private By dropDownBy = By.xpath("//div[@id='app']/div/div/header/div/div[2]/ul/li/span/p");
    private By logoutButtonBy = By.xpath("//a[contains(@href, '/web/index.php/auth/logout')]");

    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 10);
    }

    protected WebElement waitAndReturnElement(By locator) {
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return this.driver.findElement(locator);
    }

    public String getBodyText() {
    WebElement bodyElement = this.waitAndReturnElement(By.tagName("body"));
    return bodyElement.getText();
    }

    public void deleteAllCookies() {
		driver.manage().deleteAllCookies();
    }

    public LoginPage clickLogout() {
        this.wait.until(ExpectedConditions.elementToBeClickable(dropDownBy));
        this.waitAndReturnElement(dropDownBy).click();

        this.wait.until(ExpectedConditions.elementToBeClickable(logoutButtonBy));
        this.waitAndReturnElement(logoutButtonBy).click();

        return new LoginPage(this.driver);
    }

    public String getCurrentUrl() {
        return this.driver.getCurrentUrl();
    }

    public void navigateBack() {
        driver.navigate().back();
    }

    public AdminPage clickAdminButton() {
        this.waitAndReturnElement(adminButtonBy).click();
        return new AdminPage(this.driver);
    }

    public PIMPage clickPIMButton() {
        this.waitAndReturnElement(PIMButtonBy).click();
        return new PIMPage(this.driver);
    }

    public LeavePage clickLeaveButton() {
        this.waitAndReturnElement(leaveButtonBy).click();
        return new LeavePage(this.driver);
    }

    public TimePage clickTimeButton() {
        this.waitAndReturnElement(timeButtonBy).click();
        return new TimePage(this.driver);
    }

    public RecruitmentPage clickRecruitmentButton() {
        this.waitAndReturnElement(recruitmentButtonBy).click();
        return new RecruitmentPage(this.driver);
    }

    public MyInfoPage clickMyInfoButton() {
        this.waitAndReturnElement(myInfoButtonBy).click();
        return new MyInfoPage(this.driver);
    }

    public PerformancePage clickPerformanceButton() {
        this.waitAndReturnElement(performanceButtonBy).click();
        return new PerformancePage(this.driver);
    }

    public DashboardPage clickDashboardButton() {
        this.waitAndReturnElement(dashboardButtonBy).click();
        return new DashboardPage(this.driver);
    }

    public DirectoryPage clickDirectoryButton() {
        this.waitAndReturnElement(directoryButtonBy).click();
        return new DirectoryPage(this.driver);
    }

    public MaintenancePage clickMaintenanceButton() {
        this.waitAndReturnElement(maintenanceButtonBy).click();
        return new MaintenancePage(this.driver);
    }

    public BuzzPage clickbuzzButton() {
        this.waitAndReturnElement(buzzButtonBy).click();
        return new BuzzPage(this.driver);        
    }

}

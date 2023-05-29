import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

class DashboardPage extends BasePage {
    private By punchOutButtonBy = By.xpath("//div[@id='app']/div/div[2]/div[2]/div/div/div/div[2]/div/div[2]/button/i");
    private By viewLeaveListButtonBy = By.cssSelector(".oxd-icon-button--success > .oxd-icon");
    private By viewEmployeeTimesheetButtonBy = By.cssSelector(".oxd-icon-button--warn > .oxd-icon");
    private By searchEvaluatePerformanceReviewButtonBy = By.cssSelector(".oxd-icon-button--danger > .oxd-icon");
    private By viewCandidatesButtonBy = By.cssSelector(".oxd-icon-button--info > .oxd-icon");
    private By assignLeaveButtonBy = By.cssSelector(".oxd-grid-item:nth-child(1) > .oxd-icon-button > .oxd-icon");
    private By viewLeaveListQuickButtonBy = By.cssSelector(".oxd-grid-item:nth-child(2) > .oxd-icon-button > .oxd-icon");
    private By viewEmployeeTimesheetQuickButtonBy = By.cssSelector(".oxd-grid-item:nth-child(3) > .oxd-icon-button > .oxd-icon");
    private By applyLeaveButtonBy = By.cssSelector(".oxd-grid-item:nth-child(4) > .oxd-icon-button > .oxd-icon");
    private By viewMyLeaveListButtonBy = By.cssSelector(".oxd-grid-item:nth-child(5) > .oxd-icon-button > .oxd-icon");
    private By viewMyTimesheetButtonBy = By.cssSelector(".oxd-grid-item:nth-child(6) > .oxd-icon-button > .oxd-icon");

    public DashboardPage(WebDriver driver) {
        super(driver);
    }
    
    public void clickPunchOutButton() {
        this.waitAndReturnElement(punchOutButtonBy).click();
    }

    public void clickViewLeaveListButton() {
        this.waitAndReturnElement(viewLeaveListButtonBy).click();
    }

    public void clickViewEmployeeTimesheetButton() {
        this.waitAndReturnElement(viewEmployeeTimesheetButtonBy).click();
    }

    public void clickSearchEvaluatePerformanceReviewButton() {
        this.waitAndReturnElement(searchEvaluatePerformanceReviewButtonBy).click();
    }

    public void clickViewCandidatesButton() {
        this.waitAndReturnElement(viewCandidatesButtonBy).click();
    }

    public void clickAssignLeaveButton() {
        this.waitAndReturnElement(assignLeaveButtonBy).click();
    }
    public void clickViewLeaveListQuickButton() {
        this.waitAndReturnElement(viewLeaveListQuickButtonBy).click();
    }
    public void clickViewEmployeeTimesheetQuickButton() {
        this.waitAndReturnElement(viewEmployeeTimesheetQuickButtonBy).click();
    }
    public void clickApplyLeaveButton() {
        this.waitAndReturnElement(applyLeaveButtonBy).click();
    }
    public void clickViewMyLeaveListButton() {
        this.waitAndReturnElement(viewMyLeaveListButtonBy).click();
    }
    public void clickViewMyTimesheetButton() {
        this.waitAndReturnElement(viewMyTimesheetButtonBy).click();
    }
}


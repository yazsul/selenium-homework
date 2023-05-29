import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class MyInfoPage extends BasePage {

    private By personalDetailsTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewPersonalDetails/empNumber/7')]");
    private By contactDetailsTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/contactDetails/empNumber/7')]");
    private By emergencyContactsTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewEmergencyContacts/empNumber/7')]");
    private By dependentsTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewDependents/empNumber/7')]");
    private By jobTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewJobDetails/empNumber/7')]");
    private By salaryTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewSalaryList/empNumber/7')]");
    private By taxExemptionsTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewUsTaxExemptions/empNumber/7')]");
    private By reportToTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewReportToDetails/empNumber/7')]");
    private By qualificationsTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewQualifications/empNumber/7')]");
    private By membershipsTabBy = By.xpath("//a[contains(@href, '/web/index.php/pim/viewMemberships/empNumber/7')]");

    public MyInfoPage(WebDriver driver) {
        super(driver);
    }

    public void clickPersonalDetailsTab() {
        this.waitAndReturnElement(personalDetailsTabBy).click();
    }

    public void clickContactDetailsTab() {
        this.waitAndReturnElement(contactDetailsTabBy).click();
    }

    public void clickEmergencyContactsTab() {
        this.waitAndReturnElement(emergencyContactsTabBy).click();
    }

    public void clickDependentsTab() {
        this.waitAndReturnElement(dependentsTabBy).click();
    }

    public void clickJobTab() {
        this.waitAndReturnElement(jobTabBy).click();
    }

    public void clickSalaryTab() {
        this.waitAndReturnElement(salaryTabBy).click();
    }

    public void clickTaxExemptionsTab() {
        this.waitAndReturnElement(taxExemptionsTabBy).click();
    }

    public void clickReportToTab() {
        this.waitAndReturnElement(reportToTabBy).click();
    }

    public void clickQualificationsTab() {
        this.waitAndReturnElement(qualificationsTabBy).click();
    }

    public void clickMembershipsTab() {
        this.waitAndReturnElement(membershipsTabBy).click();
    }
}

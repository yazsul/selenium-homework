import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RecruitmentPage extends BasePage {

    private By numberOfRecordsTextBy = By.xpath("//span[contains(.,'Records Found')]");
    
    public RecruitmentPage(WebDriver driver) {
        super(driver);
    }

    public String getNumberOfRecords(){
        return this.waitAndReturnElement(numberOfRecordsTextBy).getText().charAt(1) + "";
    }

    public void downloadAllRecordsIfAvailable() {
        if(getNumberOfRecords().equals("o")){
            return;
        }
        for(int i = 1; i <= Integer.parseInt(getNumberOfRecords()); i++){
            this.waitAndReturnElement(By.cssSelector(String.format(".oxd-table-card:nth-child(%d) .oxd-icon-button:nth-child(3) > .oxd-icon", i))).click();
        }
    }
}

import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import org.apache.commons.io.FileUtils;

public class RecruitmentPageTest {
    public WebDriver driver;
    private String downloadDirPath;

    @Before
    public void setup()  throws MalformedURLException  {
        System.setProperty("webdriver.chrome.driver","src\\test\\resources\\chromedriver.exe");
        downloadDirPath = prepareDownloadDir();

        ChromeOptions options = new ChromeOptions();
        
        options.addArguments("--disable-popup-blocking");
        options.addArguments("--start-maximized");
        options.addArguments("--incognito");
        options.addArguments("--headless=new");

        Map<String,Object> preferences= new HashMap<>();
        preferences.put("download.default_directory", downloadDirPath);
        options.setExperimentalOption("prefs", preferences);

        driver = new ChromeDriver(options);
    }

    @Test
    public void testDownloadAllResumes() {
        LoginPage loginPage = new LoginPage(this.driver);
        RecruitmentPage recruitmentPage = loginPage.typeCorrectUsername().typeCorrectPassword().clickLoginButton().clickRecruitmentButton();
        
        boolean isDownloadDirEmpty = false;
        try {
            isDownloadDirEmpty = isDirEmpty(Paths.get(downloadDirPath));
        } catch (IOException e) {
            e.printStackTrace();
        }

        Assert.assertTrue(isDownloadDirEmpty);

        recruitmentPage.downloadAllRecordsIfAvailable();
        Assert.assertFalse(isDownloadDirEmpty);
    }

    @After
    public void close() {
        if (driver != null) {
            driver.quit();
        }
    }

    private String prepareDownloadDir() {
        String downloadDirPath = new File("src\\test\\resources\\").getAbsolutePath() + "\\downloads\\";
        File downloadDir = new File(downloadDirPath);
        downloadDir.mkdir();
        try {
            FileUtils.cleanDirectory(downloadDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return downloadDirPath;
    }

    private boolean isDirEmpty(final Path directory) throws IOException {
        try(DirectoryStream<Path> dirStream = Files.newDirectoryStream(directory)) {
            return !dirStream.iterator().hasNext();
        }
    }
}

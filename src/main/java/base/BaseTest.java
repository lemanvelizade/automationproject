package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Optional;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public String sDriverName = "";

    @BeforeMethod
    @Parameters({"browserName"})
    public void setup(@Optional("") String browserName) throws Exception {

        sDriverName = browserName;
        LocalDriver.setTLDriver(getDriver(sDriverName));

    }

    public WebDriver getDriver(String sBrowserName) throws Exception {
        WebDriver oDriver = null;
        WebDriverManager.chromedriver().setup();
        oDriver = new ChromeDriver(getChromeOptions());

        oDriver.manage().deleteAllCookies();
        oDriver.manage().timeouts().pageLoadTimeout(90L, TimeUnit.SECONDS);
        oDriver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        return oDriver;
    }

    private ChromeOptions getChromeOptions() throws Exception {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.merge(getCapability());
        chromeOptions.addArguments("test-type");
        chromeOptions.addArguments("disable-translate");
        chromeOptions.addArguments("window-size=1920,1080");
        chromeOptions.addArguments("disable-popup-blocking");
        chromeOptions.setPageLoadStrategy(PageLoadStrategy.NONE);
        return chromeOptions;
    }

    private DesiredCapabilities getCapability() {
        DesiredCapabilities oCapability = new DesiredCapabilities();
        return oCapability;

    }

    @AfterMethod
    public synchronized void teardown() {
        LocalDriver.getTLDriver().quit();
    }


}

package stepdefs;

import base.BaseTest;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;


public class MyStepdefs extends BaseTest {


    WebDriver driver = new ChromeDriver();
    String locator;



    @Given("Open the {string} URL")
    public void openTheURL(String url) {

        driver.navigate().to(url);
    }


    @When("I click the {string} element")
    public void click_the_element(String elementName) {

        if (elementName.equals("TuketiciKredisi")) {
            locator = "(//a[contains(text(),'Tüketici Kredisi')])[2]";
        } else if (elementName.equals("Hesapla")) {
            locator = "//a[contains(text(),'HESAPLA')]";
        } else if (elementName.equals("MevduatGetirisiHesaplama")) {
            locator = "(//a[contains(text(),'Mevduat Getirisi Hesaplama')])[2]";
        } else if (elementName.equals("IBANHesaplama")) {
            locator = "(//a[contains(text(),'IBAN Hesaplama')])[2]";
        }
        WebElement element = driver.findElement(By.xpath(locator));
        element.click();
    }

    @When("I enter {string} into the {string} field")
    public void i_enter_into_the_field(String text, String fieldName) {
        WebElement inputField = null;

        if (fieldName.equals("tutar")) {
            inputField = driver.findElement(By.id("calc-tutar"));
        } else if (fieldName.equals("vade")) {
            inputField = driver.findElement(By.id("calc-vade"));
        } else if (fieldName.equals("faizOrani")) {
            inputField = driver.findElement(By.id("faiz-orani"));
        } else if (fieldName.equals("mevduatVade")) {
            inputField = driver.findElement(By.id("deposit-calc-vade"));
        } else if (fieldName.equals("mevduatTutar")) {
            inputField = driver.findElement(By.id("tutar"));
        } else if (fieldName.equals("musteriNo")) {
            inputField = driver.findElement(By.id("musteriNo"));
        } else if (fieldName.equals("ekNo")) {
            inputField = driver.findElement(By.id("ekNo"));
        }

        inputField.sendKeys(text);
    }

    @When("I wait for {int} seconds")
    public void i_wait_for_seconds(int seconds) throws InterruptedException {
        Thread.sleep(seconds * 1000);
    }

    @Then("I wait result")
    public void waitResult() {
        WebElement element = null;
        locator="//div[@class='form-result']";
        element = driver.findElement(By.xpath(locator));
        element.isDisplayed();

    }
}

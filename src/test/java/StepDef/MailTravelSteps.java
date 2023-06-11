package StepDef;

import com.beust.ah.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.concurrent.TimeUnit;

import static StepDef.TakeScreenShot.takeSnapShot;

public class MailTravelSteps {

    WebDriver driver;
    WebDriverWait wait; // Declare a WebDriverWait object

    @Given("I open a browser and navigate to {string}")
    public void i_open_a_browser_and_navigate_to(String url) {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get(url);
        wait = new WebDriverWait(driver, 10);
    }

    @When("I accept all cookies")
    public void accept_cookies() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        driver.manage().window().maximize();
        WebElement accept = driver.findElement(By.xpath("//button[@id=\"onetrust-accept-btn-handler\"]"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        js.executeScript("arguments[0].click();", accept);

//        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.id("cookie-banner")));
    }

    @And("I enter {string} in the search bar and click on the search button")
    public void enter_and_click_on_search_button(String term) {


        WebElement search = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='searchtext_freetext_search_form']")));
        search.click();
        search.sendKeys(term);
        search.sendKeys(Keys.ENTER);
    }

    @When("I select holiday package")
    public void click_on_package() {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement package_Tigers = driver.findElement(By.xpath("//div[@id='iterator_2_product_custom_product-content']"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        package_Tigers.click();

    }

    @And("I click on the book online button")
    public void click_on_book_online_button() {

        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        WebElement bookOnlineButton = driver.findElement(By.cssSelector("#book-button-header > #book-d50c5ad7fbd04a98d656d673711d524a > .nbf_button"));
        bookOnlineButton.click();
    }

    @Then("I should see an error message {string}")
    public void error_message(String message) {
        WebElement errorMessage = driver.findElement(By.xpath("//div[@class = \"fielderror\"]"));
        boolean isMessageDisplayed = errorMessage.isDisplayed();
        Assert.assertTrue(isMessageDisplayed, "Error message not displayed");
        Assert.assertEquals(errorMessage.getText(), message, "Error message not matched");
    }

    @When("I select two passenger from the dropdown")
    public void select_passengers() {
        WebElement passengers = driver.findElement(By.id("passenger-dropdown-numpassengers"));
        passengers.click();
        JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("arguments[0].scrollIntoView(true);", passengers);
        Select dropDown = new Select(passengers);
        dropDown.selectByIndex(1);


    }

    @And("I select a departure date from the calendar")
    public void select_departure_date() throws InterruptedException {

        // driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement departureDate = driver.findElement(By.xpath("//input[@id='calbox-d50c5ad7fbd04a98d656d673711d524a-1']"));
        Thread.sleep(2000);
        Actions actions = new Actions(driver);
        actions.moveToElement(departureDate).click().perform();
    }

    @Then("I should see the tour price")
    public void tour_price() {
        WebElement tourPrice = driver.findElement(By.xpath("//div[@id=\"tour-price-wrap\"]"));
        boolean isPriceDisplayed = tourPrice.isDisplayed();
        Assert.assertTrue(isPriceDisplayed, "Tour price not displayed");
    }

    @And("I click on the book online button again")
    public void TheBookOnlineButton() throws Exception {

//        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        Thread.sleep(2000);
        WebElement button = driver.findElement(By.xpath("//div[@id='book-button']//div[@class='nbf_fancyimg_pms_add_button nbf_fg_pms_button_text nbf_bg_pms_button nbf_fg_pms_button_text '][normalize-space()='Book Online']"));
        driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        button.click();


//        WebElement button = driver.findElement(By.cssSelector("button.nbf_button.nbf_tpl_pms_book_button > div.nbf_fg_pms_button_text"));
//        Thread.sleep(2000);
//        button.click();

        takeSnapShot(driver, "C:\\Users\\Maan9\\IdeaProjects\\MailTest\\src.png");
        Assert.assertEquals(driver.getCurrentUrl(), "https://www.newmarketholidays.co.uk/book/c/holidays?tourCode=98637&dDate=2024-02-10&dCode=&adults=2&children=0&utm_source=DMR&utm_medium=partner_referral&deeplink=true#/Error");
        takeSnapShot(driver, "C:\\Users\\Maan9\\IdeaProjects\\MailTest\\src2.png");

    }
}

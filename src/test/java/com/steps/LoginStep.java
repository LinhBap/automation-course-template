package com.steps;

import com.utils.Utils;
import config.Constants;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HRMHomePage;
import pages.HRMLoginPage;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

public class LoginStep {
    public static final Logger logger = LogManager.getLogger();

    protected static WebDriverWait wait;



    WebDriver driver;
    @Given("I open web")
    public void iOpenWeb() throws MalformedURLException {
//        WebDriver driver;
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        String url = "https://icehrm-open.gamonoid.com/login.php";
//        driver.get(url);
//        Assert.assertEquals(driver.getCurrentUrl(), url);
//        System.out.println(driver.getCurrentUrl());
//        System.out.println("3333");
        if (Constants.RUN_AT.equals("local")) {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
            ChromeOptions options = new ChromeOptions();
            if (Constants.HEADLESS) {
                options.addArguments("--headless");
            }

            options.addArguments("window-size=1920,1080");
            options.addArguments("--no-sanbox");
        } else  {
            String hubURL = "https://hub.lambdatest.com/wd/hub";
            DesiredCapabilities capabilities = new DesiredCapabilities();
            capabilities.setCapability("browserName", "Chrome");
            capabilities.setCapability("browserVersion", "95");
            HashMap<String, Object> ltOptions = new HashMap<String, Object>();
            ltOptions.put("user", "linhbap2911");
            ltOptions.put("accessKey", "XgH3dlUR8AtaRl3VjzYeG64L2fPAvcDk2hV8XcGb5Nh2VFFKZw");
            ltOptions.put("build", "Selenium 4");
            ltOptions.put("name", this.getClass().getName());
            ltOptions.put("platformName", "Windows 10");
            ltOptions.put("seCdp", true);
            ltOptions.put("selenium_version", "4.0.0");
            capabilities.setCapability("LT:Options", ltOptions);
            driver = new RemoteWebDriver(new URL(hubURL), capabilities);
        }



//        driver = new ChromeDriver(options);


        // Maximize the browser
        driver.manage().window().maximize();
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 30);
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
    }
    @And("I click login")
    public void iClickLogin(){
        HRMLoginPage hrmLoginPage=new HRMLoginPage(driver);
        hrmLoginPage.clickLogin();
    }

    @Then("The error message is not displayed")
    public void verifyErrorMess(){
        HRMLoginPage hrmLoginPage=new HRMLoginPage(driver);
        String actualError=hrmLoginPage.getErrorMessage();
        Assert.assertEquals(actualError, "");
    }

    @And("I enter valid password")
    public void iEnterValidPassword() {
        HRMLoginPage hrmLoginPage=new HRMLoginPage(driver);
        hrmLoginPage.enterPassword("admin");
    }

    @When("I enter valid username")
    public void iEnterValidUsername() {
        HRMLoginPage hrmLoginPage=new HRMLoginPage(driver);
        hrmLoginPage.enterEmail("admin");
    }

    @When("I click Add new Employee")
    public void iClickAddNewEmployee() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.clickEmployees();
        hrmHomePage.clickEmployee();
        Utils.hardWait();
        hrmHomePage.clickAddNew();
    }

    @And("I input Employee Number")
    public void iInputEmployeeNumber() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.enterid("1");
    }

    @And("I input First name")
    public void iInputFirstName() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.enterFistname("linh");
    }

    @And("I input Middle name")
    public void iInputMiddleName() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.enterMidname("linh");
    }

    @And("I input Last name")
    public void iInputLastName() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.enterLastname("linh");
    }

    @And("I select Nationality")
    public void iSelectNationality() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.selectNation("American");
    }

    @And("I select date of birth")
    public void iSelectDateOfBirth() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.enterDOB("1998-12-12");
    }

    @And("I select gender")
    public void iSelectGender() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.selectGender("Female");
    }

    @And("I select marital status")
    public void iSelectMaritalStatus() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.selectStatus("Single");
    }

    @And("I select Ethinicity")
    public void iSelectEthinicity() {
        HRMHomePage hrmHomePage=new HRMHomePage(driver);
        hrmHomePage.selectEthnic("Asian America");
    }
}

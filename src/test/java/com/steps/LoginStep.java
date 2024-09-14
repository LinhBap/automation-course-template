package com.steps;

import com.utils.Utils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import pages.HRMHomePage;
import pages.HRMLoginPage;

public class LoginStep {
    public static final Logger logger = LogManager.getLogger();

    protected static WebDriverWait wait;



    WebDriver driver;
    @Given("I open web")
    public void iOpenWeb(){
//        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        System.out.println(driver.getCurrentUrl());
        System.out.println("3333");
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

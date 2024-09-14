package com;

import com.utils.BasicTest;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HRMHomePage;
import pages.HRMLoginPage;

public class HRMEmpoyeeTest extends BasicTest {

    @DataProvider(name = "employee")
    public Object[][] data() {
        return new Object[][] {
                {"admin","admin","","123", "Linh","Ngo","Thi","American","1998-12-29","Female","Single","Asian America"}
        };
    }

    @Test(dataProvider = "employee")
    public void loginTest(String username, String password, String expectedResult,String id, String firstname,
                          String middlename, String lastname, String nation, String dob,String gender,
                          String status, String ethnic) throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        HRMLoginPage hrmLoginPage=new HRMLoginPage(driver);
        hrmLoginPage.enterEmail(username);
        hrmLoginPage.enterPassword(password);
        hrmLoginPage.clickLogin();
        String actualError=hrmLoginPage.getErrorMessage();
        Assert.assertEquals(actualError, expectedResult);
        HRMHomePage hrmHomePage= new HRMHomePage(driver);
        hrmHomePage.clickCancel();
        hrmHomePage.clickEmployees();
        hrmHomePage.clickEmployee();
        Utils.hardWait();
        hrmHomePage.clickAddNew();
        hrmHomePage.enterid(id);
        hrmHomePage.enterFistname(firstname);
        hrmHomePage.enterMidname(middlename);
        hrmHomePage.enterLastname(lastname);
        hrmHomePage.selectNation(nation);
        hrmHomePage.enterDOB(dob);
        hrmHomePage.scrollDown();
        hrmHomePage.selectGender(gender);
        hrmHomePage.selectStatus(status);
        hrmHomePage.selectEthnic(ethnic);
        hrmHomePage.clickSave();
    }

}

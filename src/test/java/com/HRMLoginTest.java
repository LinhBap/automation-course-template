package com;

import com.utils.BasicTest;
import com.utils.Utils;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HRMHomePage;
import pages.HRMLoginPage;

public class HRMLoginTest extends BasicTest {


    @Test()
    public void loginTest() throws Exception {
        // Launch website
        String url = "https://icehrm-open.gamonoid.com/login.php";
        driver.get(url);
        Assert.assertEquals(driver.getCurrentUrl(), url);
        HRMLoginPage hrmLoginPage=new HRMLoginPage(driver);
        hrmLoginPage.enterEmail("admin");
        hrmLoginPage.enterPassword("admin");
        hrmLoginPage.clickLogin();
        String actualError=hrmLoginPage.getErrorMessage();
        Assert.assertEquals(actualError, "");

    }

}

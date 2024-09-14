package pages;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class HRMHomePage extends BasePage {
    public HRMHomePage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    };
    By employees = By.xpath("//span[contains(text(),'Employees')]");

    By employee=By.id("admin_Employees");

    By errorMessage=By.xpath("//div[@role='alert']");

    By addNewBtn=By.xpath("//span[contains(text(),'Add New')]");

    By id=By.id("employee_id");

    By firstName=By.id("first_name");
    By middlename=By.id("middle_name");
    By lastname=By.id("last_name");
    By nation=By.id("rc_select_0");

    By dob=By.id("birthday");

    By gender=By.id("rc_select_1");

    By status=By.id("rc_select_2");

    By ethnic=By.id("rc_select_3");

    By saveButton = By.xpath("//span[contains(text(),'Save')]");

    By cancel = By.xpath("//button[2][contains(text(),'Cancel')]");

    By modal=By.xpath("//div[@class='ant-modal-wrap ']");

    public void clickCancel(){
        findElementByLocator(cancel).click();
    }
    public void clickEmployees(){
        findElementByLocator(employees).click();
    }

    public void clickEmployee(){findElementByLocator(employee).click();}

    public void clickAddNew(){findElementByLocator(addNewBtn).click();}


    public void enterid(String txt){
//        this.driver.findElement(usernameInput).sendKeys(txt);
        findElementByLocator(id).clear();
        findElementByLocator(id).sendKeys(txt);
    }

    public void enterFistname(String txt){
        findElementByLocator(firstName).clear();
        findElementByLocator(firstName).sendKeys(txt);
    }
    public void enterMidname(String txt){
        findElementByLocator(middlename).clear();
        findElementByLocator(middlename).sendKeys(txt);
    }
    public void enterLastname(String txt){
        findElementByLocator(lastname).clear();
        findElementByLocator(lastname).sendKeys(txt);
    }
    public void selectNation(String txt){
        findElementByLocator(nation).click();
        findElementByLocator(By.xpath("//div[@title='"+txt+"']")).click();
//        findElementByLocator(nation).sendKeys(txt);
    }

    public void enterDOB(String txt){
        findElementByLocator(dob).sendKeys(txt);
        driver.findElement(By.xpath("//body")).click();
    }

    public void scrollDown(){
        findElementByLocator(modal);
        driver.switchTo().activeElement();
        Actions act = new Actions(driver);
        act.sendKeys(Keys.PAGE_DOWN).build().perform();
    }

    public void selectGender(String txt){
        findElementByLocator(gender).sendKeys(txt);
        findElementByLocator(By.xpath("//div[@title='"+txt+"']")).click();
    }

    public void selectStatus(String txt){
        findElementByLocator(status).sendKeys(txt);
        findElementByLocator(By.xpath("//div[@title='"+txt+"']")).click();
    }

    public void selectEthnic(String txt){
        findElementByLocator(ethnic).sendKeys(txt);
//        findElementByLocator(By.xpath("//div[@title='"+txt+"']")).click();
    }
    public void clickSave() throws InterruptedException {
        findElementByLocator(saveButton).click();
        Thread.sleep(3000);
    }
    public String getErrorMessage(){
        try {
            return findElementByLocator(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }

    }

}

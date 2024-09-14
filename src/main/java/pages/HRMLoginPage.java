package pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HRMLoginPage extends BasePage {
    public HRMLoginPage(WebDriver givenDriver) {
        super(givenDriver);
        //TODO Auto-generated constructor stub
    }

    By usernameInput = By.id("username");
    By passwordInput = By.id("password");
    By loginButton = By.xpath("//button[contains(text(),'Log in')]");

    By errorMessage=By.xpath("//div[@role='alert']");

    public void enterEmail(String txt){
//        this.driver.findElement(usernameInput).sendKeys(txt);
        findElementByLocator(usernameInput).clear();
        findElementByLocator(usernameInput).sendKeys(txt);
    }

    public void enterPassword(String txt){
        findElementByLocator(passwordInput).clear();
        findElementByLocator(passwordInput).sendKeys(txt);
    }


    public void clickLogin(){
        findElementByLocator(loginButton).click();
    }

    public String getErrorMessage(){
        try {
            return findElementByLocator(errorMessage).getText();
        } catch (Exception e) {
            return "";
        }

    }

}

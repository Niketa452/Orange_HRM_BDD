package Orange_HRM_BDD;

import org.openqa.selenium.By;
import org.testng.Assert;

public class HomePage extends Utils {
LoadProp props = new LoadProp();

private By _username=By.id("txtUsername");
private By _password=By.id("txtPassword");
private By _loginButton=By.id("btnLogin");
private By _errormessage=By.id("spanMessage");

    public void launchAndValidateHomepage(){
        driver.get(props.getProperty("url"));
        validateURL(props.getProperty("url"));
    }
    public void enterValidCredentials(){
        enterText(_username, props.getProperty("username"));
        enterText(_password, props.getProperty("password"));
  }
    public void clickonLoginButton()
    {
        clickElement(_loginButton);
        try {
            Thread.sleep(5000 );
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void enterInvalidCredentials(String username, String password){
        enterText(_username, username);
        enterText(_password, password);

    }
    public void validateErrorMessage(String error_message){
        String actualMessage= getTextFromContent(_errormessage);
        Assert.assertEquals(actualMessage, error_message);

    }
}

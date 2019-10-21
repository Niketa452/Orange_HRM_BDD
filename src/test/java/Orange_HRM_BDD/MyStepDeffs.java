package Orange_HRM_BDD;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyStepDeffs {
    HomePage homePage=new HomePage();
    DashBoardPage dashBoardPage=new DashBoardPage();


    @Given("^User is on homempage$")
    public void user_is_on_homempage()  {
        homePage.launchAndValidateHomepage();

    }

    @When("^User enters valid username and password$")
    public void user_enters_valid_username_and_password()  {
        homePage.enterValidCredentials();
    }

    @When("^Clicks on login button$")
    public void clicks_on_login_button()  {
        homePage.clickonLoginButton();

    }

    @Then("^User is navigated to Dashboard page$")
    public void user_is_navigated_to_Dashboard_page()  {
        dashBoardPage.validateurl();

    }

    @When("^User enters invalid \"([^\"]*)\" and \"([^\"]*)\"$")
    public void user_enters_invalid_and(String username, String password)  {
        homePage.enterInvalidCredentials(username, password);

    }

    @Then("^\"([^\"]*)\" should be displayed$")
    public void should_be_displayed(String error_message)  {
        homePage.validateErrorMessage(error_message);
    }


}

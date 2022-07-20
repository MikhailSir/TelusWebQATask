package org.telusqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.telusqa.utilities.CookiesHelper;

/**
 * Login page
 */
public class LoginPage extends BasicPage {

  public LoginPage(WebDriver webDriver) {
    super(webDriver);
    PageFactory.initElements(webDriver, this);
  }

  @FindBy(id = "IDToken1")
  private WebElement loginField;

  @FindBy(id = "IDToken2")
  private WebElement passwordField;

  @FindBy(id = "Submit")
  private WebElement logInButton;

  @FindBy(tagName = "h1")
  private WebElement h1text;

  @FindBy(xpath = "//h1/a")
  private WebElement redirectLink;

  @FindBy(className = "close-modal")
  private WebElement closePopupButton;

  @FindBy(className = "login-button")
  private WebElement homepageLoginButton;

  public void loginIntoApp(String login, String password) {
    logIn(login, password);
    goThroughRedirectPage();
    closePopup();
    applyCookiesAndRefresh();
  }

  private void logIn(String login, String password) {
    loginField.sendKeys(login);
    passwordField.sendKeys(password);
    logInButton.click();
  }

  public void goThroughRedirectPage() {
    if(h1text.getText().contains("If you are using the browser, please use "))
      redirectLink.click();
  }

  public void closePopup() {
    if(closePopupButton.isDisplayed())
      closePopupButton.click();
  }

  public void applyCookiesAndRefresh() {
    CookiesHelper.setCookies(driver);
    driver.navigate().refresh();
    homepageLoginButton.click();
  }
}

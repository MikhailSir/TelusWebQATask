package org.telusqa.pages;

import org.openqa.selenium.WebDriver;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class BasicPage {

  protected WebDriver driver;

  /*
   * Constructor injecting the WebDriver interface
   * 
   * @param webDriver
   */
  public BasicPage(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

}

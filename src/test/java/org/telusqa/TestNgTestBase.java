package org.telusqa;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.telusqa.utilities.CookiesHelper;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import ru.stqa.selenium.factory.WebDriverPool;

import java.io.IOException;
import java.net.URL;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Base class for TestNG-based test classes
 */
public class TestNgTestBase {

  protected static URL gridHubUrl = null;
  protected static String baseUrl;
  protected static Capabilities capabilities;
//TODO  protected static String username = "";
//TODO  protected static String password = "";

  protected WebDriver driver;
  protected static Set<Cookie> cookies;

  @BeforeSuite
  public void initTestSuite() throws IOException {
    SuiteConfiguration config = new SuiteConfiguration();
    baseUrl = config.getProperty("site.url");
    if (config.hasProperty("grid.url") && !"".equals(config.getProperty("grid.url"))) {
      gridHubUrl = new URL(config.getProperty("grid.url"));
    }
    capabilities = config.getCapabilities();
  }

  @BeforeMethod
  public void initWebDriver() {
    switch (capabilities.getBrowserName()) {
      case "chrome":
        WebDriverManager.chromedriver().setup();
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
      default:
        WebDriverManager.chromedriver().setup();
        break;
    }
    driver = WebDriverPool.DEFAULT.getDriver(gridHubUrl, capabilities);
    driver.get(baseUrl);
    driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.manage().window().maximize();
    CookiesHelper.getCookies(driver);
  }

  @AfterSuite(alwaysRun = true)
  public void tearDown() {
    WebDriverPool.DEFAULT.dismissAll();
  }
}

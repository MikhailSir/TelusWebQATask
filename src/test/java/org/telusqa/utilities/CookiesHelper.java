package org.telusqa.utilities;

import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;

import java.util.Set;

public class CookiesHelper {

    protected static Set<Cookie> cookies;
    public static Set<Cookie> getCookies(WebDriver driver) {
        cookies = driver.manage().getCookies();
        return cookies;
    }

    public static void setCookies(WebDriver driver) {
        cookies.forEach(a -> driver.manage().addCookie(a));
    }

    public static void setCookies(WebDriver driver, Set<Cookie> cookies) {
        cookies.forEach(a -> driver.manage().addCookie(a));
    }

}

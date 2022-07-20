package org.telusqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OnDemandPage  extends BasicPage {

    public OnDemandPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindAll({
            @FindBy(xpath = "//div[@class='header']//a")
    })
    private List<WebElement> categoriesLinks;

    public void openAllMoviesLink() {
        categoriesLinks.get(3).click();
    }
}

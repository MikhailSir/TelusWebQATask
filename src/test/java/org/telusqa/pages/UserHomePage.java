package org.telusqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class UserHomePage extends BasicPage {

    public UserHomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(id = "0")
    private WebElement homePageLink;

    @FindBy(id = "2")
    private WebElement onDemandLink;

    @FindAll({
            @FindBy(xpath = "//span[text()='Favourites']/../../following-sibling::div//a")
    })
    private List<WebElement> favouritesList;

    public void openHomePage() {
        homePageLink.click();
    }

    public void openOnDemandSection() {
        onDemandLink.click();
    }

    public SingleMoviePage openLastFavouriteAsset() {
        favouritesList.get(0).click();
        return new SingleMoviePage(driver);
    }

}

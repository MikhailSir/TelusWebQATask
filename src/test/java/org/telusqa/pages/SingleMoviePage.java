package org.telusqa.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SingleMoviePage extends BasicPage {

    public SingleMoviePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    @FindBy(xpath = "//button[@class='imageButton wall-content-icon']")
    private WebElement favoriteHeartButton;

    @FindBy(xpath = "//button[@class='imageButton wall-content-icon']/img")
    private WebElement favoriteHeartButtonImage;

    @FindBy(tagName = "h1")
    private WebElement titleOfMovie;

    public void addMovieToFavoriteList() throws Exception {
        if(!checkIfMovieInFavoriteList()) {
            Actions action = new Actions(driver);
            action.moveToElement(favoriteHeartButton).build().perform();
            favoriteHeartButtonImage.click();
            Thread.sleep(2000);
        }
        else System.out.println("Movie is already in Favorite List");
    }

    public boolean checkIfMovieInFavoriteList() {
        return favoriteHeartButtonImage.getAttribute("alt").equals("Remove");
    }

    public String getTitleOfMovie() {
        return titleOfMovie.getText();
    }





}

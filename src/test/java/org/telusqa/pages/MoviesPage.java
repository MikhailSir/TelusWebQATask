package org.telusqa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

public class MoviesPage extends BasicPage {

    SingleMoviePage movie = new SingleMoviePage(driver);

    public MoviesPage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }


    private WebElement getMovieElementByIndex(int number) {
        String xPath = "//div[@class='column'][" + number + "]";
        return driver.findElement(By.xpath(xPath));
    }

    //There are very big list of Movies with async loading so I check only 30 first assets
    public SingleMoviePage findUnfavouritedAssetAndOpen() throws Exception{
        for(int i = 1; i<=30; i++){
            getMovieElementByIndex(i).click();
            Thread.sleep(2000);
            if (!movie.checkIfMovieInFavoriteList()) {
                return movie;
            } else {
                driver.navigate().back();
            }
        }
        Assert.assertTrue(false, "All movies in Favorite list");
        return null;
    }

}

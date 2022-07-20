package org.telusqa.testwatchpiktv;

import org.telusqa.TestNgTestBase;
import org.telusqa.pages.*;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestFavouritesFeature extends TestNgTestBase {


    @Test
    public void testFavoriteMovieFlow() throws Exception {
        //1. Launch Optik On The Go URL
        //2. Login with username and password
        //3. Select OK to close the This feature is coming soon popup if displayed
        LoginPage loginPage = new LoginPage(driver);
//TODO before start        loginPage.loginIntoApp(username, password);
        UserHomePage userHomepage = new UserHomePage(driver);
        //4. Select On Demand
        userHomepage.openOnDemandSection();
        Thread.sleep((3000));
        OnDemandPage onDemandPage = new OnDemandPage(driver);
        //5. Select Movies
        onDemandPage.openAllMoviesLink();
        MoviesPage moviesPage = new MoviesPage(driver);
        //6. Select All Movies
        //7. Looping through the list and find an unfavourited asset
        SingleMoviePage movie = moviesPage.findUnfavouritedAssetAndOpen();
        //8. Click the "Favourite" to add the asset to Favouties list
        movie.addMovieToFavoriteList();
        //9. Validate the button text changed to "Remove"
        Assert.assertTrue(movie.checkIfMovieInFavoriteList(), "Button text wasn't changed to 'Remove'");
        String movieName = movie.getTitleOfMovie();
        userHomepage.openHomePage();
        movie = userHomepage.openLastFavouriteAsset();
        Assert.assertTrue(movie.getTitleOfMovie().equals(movieName), "Not last added to Favs movie opened");
    }
}

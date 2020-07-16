package android.Etsy.galaxyS8;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class bottomBarNavigation extends pageBase {

    @FindBy(id = "com.etsy.android:id/menu_bottom_nav_home")
    WebElement bottomBarHome;

    @FindBy(id = "com.etsy.android:id/menu_bottom_nav_favorites")
    WebElement bottomBarFavorites;

    @FindBy(id = "com.etsy.android:id/menu_bottom_nav_you")
    WebElement bottomBarYou;

    @FindBy(id = "com.etsy.android:id/menu_bottom_nav_cart")
    WebElement bottomBarCart;

    @FindBy(id ="com.etsy.android:id/you_menu_sign_in_button")
    WebElement inviteToSignInButtom;

    //Field for Sigh In
    @FindBy(id = "com.etsy.android:id/edit_username")
    WebElement userNameFieldSighIn;
    @FindBy(id = "com.etsy.android:id/edit_password")
    WebElement passwordFieldSighIn;
    @FindBy(id = "com.etsy.android:id/button_signin")
    WebElement sighInButton;

    @FindBy(xpath = "//android.widget.TextView[@text = 'Profile']")
    WebElement buttomProfile;

    public bottomBarNavigation(WebDriver driver) {
        super(driver);
    }

    @Override
    public void waitUntilPageIsLoaded() {

    }

    @Override
    public void waitUntilElementIsVisible() {

    }

}

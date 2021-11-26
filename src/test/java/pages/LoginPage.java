package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import BaseSetup.BaseClass;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class LoginPage extends BaseClass
{
    public AndroidDriver<AndroidElement> driver;

    public  LoginPage(AndroidDriver<AndroidElement>driver)
    {
        this.driver = driver ;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }
    /*
    Locating elements of app using AndroidFindBy Anotation
     */

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/btnEmailSignUp")
    private AndroidElement EmailBtn;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/txtEmail")
    private AndroidElement emailField;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/txtPassword")
    private AndroidElement passwordField;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/btnEmailSignUp")
    private AndroidElement LoginBtn;


    /*
    Below method will login into app with email and password of user
     */

    public boolean loginapp()
    {
        try{
            EmailBtn.click();
         //   Thread.sleep(5000);
            WebDriverWait wait = new WebDriverWait(driver, 10);
            wait.until(ExpectedConditions.visibilityOf(emailField));
            emailField.click();
            emailField.sendKeys("Add your email"); // enter your email id
            wait.until(ExpectedConditions.visibilityOf(passwordField));
            System.out.println("User entered username & password");
           // Thread.sleep(5000);
            passwordField.sendKeys("add your password");  // enter your password
            LoginBtn.click();
            System.out.println("User tap login button");

            return true ;
        }
        catch (Exception e)
        {
            System.out.println(e);
            return false ;
        }

    }





}










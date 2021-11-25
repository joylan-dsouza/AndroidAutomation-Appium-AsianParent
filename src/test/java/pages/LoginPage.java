package pages;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import BaseSetup.BaseClass;


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
        Thread.sleep(5000);
        emailField.click();
        emailField.sendKeys("joylan888@gmail.com");
        Thread.sleep(5000);
        passwordField.sendKeys("Test@1234");
        LoginBtn.click();
        return true ;
    }
    catch (Exception e)
    {
        System.out.println(e);
        return false ;
    }

    }





}










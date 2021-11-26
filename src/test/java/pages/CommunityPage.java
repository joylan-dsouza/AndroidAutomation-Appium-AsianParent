package pages;

import BaseSetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class CommunityPage extends BaseClass
{
    public AndroidDriver<AndroidElement> driver;



    public CommunityPage(AndroidDriver<AndroidElement>driver)
    {
        this.driver = driver ;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    /*
    Locating elements of app using AndroidFindBy Anotation
     */

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/img_notification")
    private AndroidElement notificationIcon;

    @AndroidFindBy (className = "android.widget.ImageButton")
    private List<AndroidElement> imagebuttonlist ;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/txt_explore")
    private AndroidElement exploreText;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/fabAddPost")
    private AndroidElement addPost;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/txt_post_question_title")
    private AndroidElement postQuestion;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/txt_title")
    private AndroidElement titleField;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/et_post")
    private AndroidElement postField;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/btn_post")
    private AndroidElement nextBtn;

    @AndroidFindBy (className = "android.widget.TextView")
    private List<AndroidElement> optionList ;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/btn_done")
    private AndroidElement doneBtn;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/btn_more")
    private AndroidElement moreBtn;

    @AndroidFindBy (className = "android.widget.TextView")
    private List<AndroidElement> moreOptions ;

    @AndroidFindBy (id = "com.tickledmedia.ParentTown:id/button_secondary")
    private AndroidElement yesBtn;

    /*
        Below method will tap notification icon on community page
         */
    public void tapNotification() throws InterruptedException {
         WebDriverWait wait = new WebDriverWait(driver, 10);
        //Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(exploreText));
        exploreText.click();
       // Thread.sleep(2000);
        wait.until(ExpectedConditions.visibilityOf(notificationIcon));
        notificationIcon.click();
        System.out.println("User tap notification button");

    }
    /*
    Below method will tap back  icon on notification page
     */
    public void tapBack() throws InterruptedException {
        Thread.sleep(2000);
        outerloop: for(AndroidElement bckbtn : imagebuttonlist)
        {
            if(bckbtn.getAttribute("content-desc").contains("Navigate up"))
            {
                bckbtn.click();
                System.out.println("User tap back button");
                break outerloop;
            }

        }

    }
    /*
    Below method will tap add icon on community page
    */
    public void tapAddPost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(addPost));
        addPost.click();
        System.out.println("User tap add post button");
    }
    /*
               Below method will post question option
                */
    public void tapPostQuestion() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(postQuestion));
        postQuestion.click();
        System.out.println("User tap post question button");

    }

        /*
           Below method will  add title , message
            */

    public void enterPost() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(titleField));
        titleField.sendKeys("This is a title");
        postField.sendKeys("This is a message in the post");
        System.out.println("User entered title and post message  ");


    }
    /*
    Below method will tap Next Button
    */

    public void tapNext() throws InterruptedException {
      //  Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(nextBtn));
        nextBtn.click();
        System.out.println("User tap next button");
    }
    /*
    Below method will select Random topic radio button
     */
    public void selectTopic() throws InterruptedException {
        Thread.sleep(10000);
        outerloop: for(AndroidElement radioBtn : optionList)
        {


            if(radioBtn.getText().contains("Random Talk"))
            {
                radioBtn.click();
                System.out.println("User tap random radio button");
                break outerloop;
            }

        }
        Thread.sleep(2000);
        doneBtn.click();
        System.out.println("User tap done button");

    }
    /*
    Below method will delete the post by tapping  more option and click delete button
    */

    public boolean deletePost()
    {
        try {
            Thread.sleep(10000);
            moreBtn.click();
            System.out.println("User tap more button");
            Thread.sleep(10000);
            outerloop:
            for (AndroidElement deletebtn : moreOptions) {


                if (deletebtn.getText().contains("Delete")) {
                    deletebtn.click();
                    System.out.println("User tap delete button");
                    break outerloop;
                }

            }
            Thread.sleep(2000);
            yesBtn.click();
            System.out.println("User tap yes button");

            return true ;
        }
        catch(Exception e)
        {
            System.out.println(e);

            return false ;
        }


    }











}










package pages;

import BaseSetup.BaseClass;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

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
        Thread.sleep(2000);
        exploreText.click();
        Thread.sleep(2000);
        notificationIcon.click();

    }
    /*
       Below method will tap back  icon on notification page
        */
     public void tapBack() throws InterruptedException {
         Thread.sleep(2000);
        outerloop: for(AndroidElement bckbtn : imagebuttonlist)
        {
            System.out.println(bckbtn.getAttribute("content-desc"));

            if(bckbtn.getAttribute("content-desc").contains("Navigate up"))
            {
                bckbtn.click();
                break outerloop;
            }

        }

    }
    /*
           Below method will tap add icon on community page
            */
        public void tapAddPost() throws InterruptedException {
            Thread.sleep(2000);
            addPost.click();
        }
    /*
               Below method will post question option
                */
        public void tapPostQuestion() throws InterruptedException {
            Thread.sleep(2000);

            postQuestion.click();

        }

        /*
           Below method will  add title , message
            */

    public void enterPost() throws InterruptedException {
        Thread.sleep(2000);

        titleField.sendKeys("This is a title");
        postField.sendKeys("This is a message in the post");


    }
    /*
           Below method will tap Next Button
            */

    public void tapNext() throws InterruptedException {
        Thread.sleep(2000);
        nextBtn.click();
    }
    /*
               Below method will select Random topic radio button
                */
    public void selectTopic() throws InterruptedException {
        Thread.sleep(10000);
        outerloop: for(AndroidElement radioBtn : optionList)
        {
            System.out.println(radioBtn.getText());

            if(radioBtn.getText().contains("Random Talk"))
            {
                radioBtn.click();
                break outerloop;
            }

        }

        Thread.sleep(2000);
        doneBtn.click();

    }
    /*
           Below method will delete the post by tapping  more option and click delete button
            */

    public void deletePost() throws InterruptedException {
        Thread.sleep(10000);
        moreBtn.click();
        Thread.sleep(10000);
        outerloop: for(AndroidElement deletebtn : moreOptions)
        {
            System.out.println(deletebtn.getText());

            if(deletebtn.getText().contains("Delete"))
            {
                deletebtn.click();
                break outerloop;
            }

        }
        Thread.sleep(2000);
        yesBtn.click();


    }











}










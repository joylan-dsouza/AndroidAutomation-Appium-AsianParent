package testscripts;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.CommunityPage;
import pages.LoginPage;
import BaseSetup.BaseClass;

public class TestScript1 extends BaseClass {

    /*
     This test will verify login and opening of notification screen

     */
@Test
    public void test1() throws InterruptedException {

    LoginPage lp = new LoginPage(driver);
    CommunityPage Cp = new CommunityPage(driver);
    lp.loginapp();
    Cp.tapNotification();
    Cp.tapBack();
    //Cp.tapAddPost();
  //  Cp.tapPostQuestion();
   // Cp.enterPost();
  //  Cp.tapNext();
  //  Cp.selectTopic();
  //  Cp.deletePost();

//  Assert.assertTrue(lp.loginapp(),"User logged In");

    Thread.sleep(3000);
}

/*
 This test will verify adding and deleting post

 */

@Test
    public void test2() throws InterruptedException {
    LoginPage lp = new LoginPage(driver);
    CommunityPage Cp = new CommunityPage(driver);
    Cp.tapAddPost();
    Cp.tapPostQuestion();
    Cp.enterPost();
    Cp.tapNext();
    Cp.selectTopic();
    Cp.deletePost();
}


}

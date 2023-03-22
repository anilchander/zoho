package local.test;

import org.testng.annotations.Test;

import local.pageobjects.LocalPageObject1;
import local.pageobjects.NotificationsPO;
import zoho.test.utils.BaseTest;

public class LocalTest extends BaseTest {
  NotificationsPO notificationPage = null;
  @Test
  public void f1() throws Exception {
	  LocalPageObject1 page1 = new LocalPageObject1(getDriver());
	  notificationPage =page1.navigate();
	  
  }
  @Test
  public void f2() throws Exception {
	  notificationPage.clickToggleNotification();
	  
  }
}

package com.testout.simulator.tests;

import com.testout.simulator.utils.Browser;
import com.testout.simulator.utils.Navigator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.testout.simulator.utils.Constants.*;

import static org.testng.Assert.assertEquals;

public class EmailAccountSetupTest {

  @Test
  public void testEmailAccountSetup() throws Exception {
    WebDriver driver = Browser.getDriver("chrome");
    Navigator navigator = new Navigator(driver);

    navigator.openUrl(SERVER_URL);
    navigator.doubleClickById("MessageGroup");
    navigator.doubleClickById(SETTINGS_BUTTON);
    navigator.clickById(MAIL_CONTACTS_CALENDARS);
    navigator.clickById(USER_ACCOUNT_NAME);
    navigator.clickById(ACCOUNT);
    navigator.clickById(ADVANCED_OUTER_ELEMENT);
    //navigator.clickById(ADVANCED);
    navigator.clickById(SSL_DRAG_BUTTON);
    navigator.dragBy(SSL_DRAG_BUTTON, 18, 0);
    assertEquals(navigator.getValue(SERVER_PORT), "993");
    navigator.clickById(ACCOUNT_BACK_BUTTON);
    navigator.clickById(DONE);
  }
}

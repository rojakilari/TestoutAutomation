package com.testout.simulator.tests;

import com.testout.simulator.utils.Browser;
import com.testout.simulator.utils.Navigator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static com.testout.simulator.utils.Constants.*;
import static org.testng.Assert.assertEquals;

public class OpenWifiTest {

  private WebDriver driver;
  private Navigator navigator;

  @BeforeMethod
  public void setup() {
    driver = Browser.getDriver("chrome");
    navigator = new Navigator(driver);
  }

  @AfterMethod
  public void tearDown() {
    //driver.close();
    driver.quit();
  }

  @Test
  public void testConnectingToWifi() throws Exception {
    navigator.openUrl(SERVER_URL);
    navigator.doubleClickById(SETTINGS_BUTTON);
    navigator.clickById(WI_FI);
    navigator.clickById(WIFI_NAME);
    navigator.clickById(PASSWORD_BOX);
    navigator.enter(PASSWORD_BOX, "@CorpNetWeRSecure!&");
    navigator.clickById(JOIN_BUTTON);
  }

  }

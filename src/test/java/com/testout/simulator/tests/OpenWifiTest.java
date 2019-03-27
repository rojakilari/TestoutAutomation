package com.testout.simulator.tests;

import com.testout.simulator.utils.Browser;
import com.testout.simulator.utils.Navigator;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static com.testout.simulator.utils.Constants.*;

public class OpenWifiTest {
  @Test
  public void testConnectingToWifi() throws Exception {
    WebDriver driver = Browser.getDriver("chrome");
    Navigator navigator = new Navigator(driver);

    navigator.openUrl(SERVER_URL);
    navigator.doubleClickById(SETTINGS_BUTTON);
    navigator.clickById(WI_FI);
    navigator.clickById(WIFI_NAME);
    navigator.clickById(PASSWORD_BOX);
    navigator.enter(PASSWORD_BOX, "@CorpNetWeRSecure!&");
    navigator.clickById(JOIN_BUTTON);
  }
}

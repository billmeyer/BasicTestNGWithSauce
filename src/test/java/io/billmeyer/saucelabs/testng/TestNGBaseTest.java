package io.billmeyer.saucelabs.testng;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public abstract class TestNGBaseTest
{
    protected RemoteWebDriver driver;
    protected String baseUrl;
    protected StringBuffer verificationErrors = new StringBuffer();

    protected String userName = System.getenv("SAUCE_USERNAME");
    protected String accessKey = System.getenv("SAUCE_ACCESS_KEY");

    @Test
    public void testFirefox() throws Exception
    {
        DesiredCapabilities caps = DesiredCapabilities.firefox();
        caps.setCapability("version", "57.0");

        runTest(caps);
    }

    @Test
    public void testChrome() throws Exception
    {
        DesiredCapabilities caps = DesiredCapabilities.chrome();
        caps.setCapability("version", "62.0");
        caps.setCapability("chromedriverVersion", "2.33");

        runTest(caps);
    }

    protected abstract void runTest(DesiredCapabilities caps) throws Exception;
}

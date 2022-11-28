package autoFramework;

import org.openqa.selenium.WebDriver;
import webTestFramework.SeleniumControl;

import java.text.MessageFormat;

public class AutoBase extends AutoLogger{

    // TODO Delete all unused methods and fields
    // TODO move all fields to the top

    protected static WebDriver webDriver;
    public SeleniumControl seleniumControl;

    private WebDriverFactory webDriverFactory = new WebDriverFactory();

    public void Sleep(int seconds) throws InterruptedException{
        if(seconds > 5)
            Info(MessageFormat.format("  Sleeping for {0} seconds....", seconds));

        Thread.sleep(seconds * 1000L);
    }

    public void InitWebDriver()
    {
        webDriver = webDriverFactory.CreateSeleniumDriver();
        setWebDriver(webDriver);
    }

    public void GoToURL(String url)
    {
        this.webDriver.navigate().to(url);
        Info("Navigating to " + url);
    }

    public void Quit()
    {
        this.webDriver.quit();
    }

    public void setWebDriver(WebDriver webDriver)
    {
        this.webDriver = webDriver;
    }

    public WebDriver getWebDriver()
    {
        return webDriver;
    }

}

package autoFramework;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class WebDriverFactory extends AutoLogger{

    public WebDriverFactory()
    {

    }

    public WebDriver CreateSeleniumDriver()
    {
        WebDriver _WebDriver = null;
        Info("Creating WebDriver.....");

        _WebDriver = CreateWebDriver();
        _WebDriver.manage().window().maximize();
        _WebDriver.manage().deleteAllCookies();

        return _WebDriver;
    }

    public WebDriver CreateWebDriver()
    {
        // TODO: driver path should be in a smarter location. README.md should explain how, or be set up for Podium tester
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\artch\\Downloads\\chromedriver_win32\\chromedriver.exe");
        return new ChromeDriver();
    }


}

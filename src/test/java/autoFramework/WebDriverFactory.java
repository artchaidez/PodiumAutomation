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
        System.setProperty("webdriver.chrome.driver", "C:\\Program Files (x86)\\Google\\chromedriver.exe");
        return new ChromeDriver();
    }


}

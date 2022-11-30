package webTests;

import autoFramework.AutoBase;
import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webTestFramework.SeleniumControl;

// TODO: Extend class to a class from Pages Package. This class will extend AutoBase
// TODO: Run from command line
// TODO: Make sure this all runs in Mac
public class PodiumTestCases extends AutoBase {

    @BeforeTest
    public void TestSetUp()
    {
        InitWebDriver();
    }

    @Test (groups = {"smokeTest"})
    @Description("Test to switch to correct iframe and click on Podium icon.")
    public void TestClickPodiumButton() throws Exception
    {
        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium bubble");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Bubble");
        SeleniumControl podiumBtn = new SeleniumControl(By.className("ContactBubble__Bubble"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");
    }

    @Test (groups = {"smokeTest"})
    @Description("Test to click on first location found in Location modal.")
    public void TestSelectFirstLocation() throws Exception
    {
        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Icon");
        SeleniumControl podiumBtn = new SeleniumControl(By.className("ContactBubble__Bubble"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");

        Step("Switch to main frame");
        switchToMainFrame();

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-modal");

        Step("Click on first location in location list");
        SeleniumControl locationBtn = new SeleniumControl(By.xpath("//*[@class='LocationContainer StaggerFadeIn3 LocationContainer--desktop']"));
        locationBtn.Click(5);
        Info("Clicked on first location");

    }

    // TODO: Could delete this and use TestSelectFirstLocation()
    @Test (groups = {"smokeTest"})
    @Description("Test to confirm correct location is being clicked in the modal")
    public void TestScoreboardOremLocationExists() throws Exception
    {
        String location = "Scoreboard Sports - Orem";
        String address = "765 West State Road, American Fork, UT 84003, United States";

        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Icon");
        SeleniumControl podiumBtn = new SeleniumControl(By.xpath("//*[@class='ContactBubble__Bubble']"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");

        Step("Switch to main frame");
        switchToMainFrame();

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-modal");

        Step(String.format("Confirm %s is in location list", location));
        // SeleniumControl locationBtn = new SeleniumControl(By.xpath(String.format("//*[contains(text(), \"%s\")]", location)));
        SeleniumControl locationBtn = new SeleniumControl(By.xpath(String.format("//*[text()= \"%s\"]", location)));
        locationBtn.IsVisible(5);
        Info(String.format("%s is in the modal", location));

        Step(String.format("Click on %s", location));
        locationBtn.Click(5);

        Step(String.format("Confirm %s opened up", location));
        // TODO: confirm correct location opened up
        // not finding text
        // SeleniumControl modalBtn = new SeleniumControl(By.xpath(String.format("//*[contains(text(), \"%s\")]", address)));
        SeleniumControl modalBtn = new SeleniumControl(By.xpath(String.format("//*[text() = \"%s\"]", location)));
        modalBtn.IsVisible(5);

        // This works, but need a way to prove text
        SeleniumControl modalText = new SeleniumControl(By.xpath("//*[@class='SendSmsPage__CurrentLocationName']"));
        modalText.IsVisible(5);

    }

    // TODO: Complete TestInputMessageData
    @Test (groups = {"smokeTest"})
    @Description("Test to input data in all 3 fields of message modal")
    public void TestInputMessageData() throws Exception
    {
        String name = "Art";
        Long telephoneNum = 7777777777L;
        String telephone = "7777777777";
        String message = "Hello QA Tester";

        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Icon");
        SeleniumControl podiumBtn = new SeleniumControl(By.className("ContactBubble__Bubble"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");

        Step("Switch to main frame");
        switchToMainFrame();

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-modal");

        Step("Click on first location in location list");
        SeleniumControl locationBtn = new SeleniumControl(By.xpath("//*[@class='LocationContainer StaggerFadeIn3 LocationContainer--desktop']"));
        locationBtn.Click(5);
        Info("Clicked on first location");

        // TODO: xpath class names for all three textfields all differ. Should be consistent. Report this as a bug
        // NOTE: still within iframe podium-modal
        // NOTE: after opening message, Name already clicked
        Step("Input name in Name text field");
        SeleniumControl nameTextBox = new SeleniumControl(By.xpath("//*[@class= 'TextInput__FormInput']"));
        nameTextBox.SetText(name, 5, null);
        Info(String.format("Inputted '%s' into name text field", name));

        Step("Input phone number into mobile phone text field");
        // element.sendKeys(Keys.CONTROL + "a"); cannot interact with textbox
        // this.GetAttribute("type"); returns null, should return tel
        SeleniumControl telephoneTextBox = new SeleniumControl(By.xpath("//*[@class= 'TextInput TextInput--tel']"));
        // TODO: Need to send numbers, not string. Need new method
        //telephoneTextBox.SetText(telephone, 5, null);

        Step("Input message in message text field");
        SeleniumControl messageTextBox = new SeleniumControl(By.xpath("//*[@class= 'TextInput__Textarea ']"));
        messageTextBox.SetText(message, 5, null);
        Info(String.format("Inputted '%s' into message text field", message));

    }

    @Test (groups = {"regressionTest"})
    @Description("Test to confirm subject and terms are opened in a new tab.")
    public void TestClickSubjectTerms() throws Exception
    {
        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium bubble");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Bubble");
        SeleniumControl podiumBtn = new SeleniumControl(By.className("ContactBubble__Bubble"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");

        Step("Switch to main frame");
        switchToMainFrame();

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-modal");

        Step("Click on 'use is subject to terms'");
        // both classes work: 'terms' and 'LocationSelector__PodiumPower'
        SeleniumControl subjectTermsBtn = new SeleniumControl(By.className("LocationSelector__PodiumPower"));
        subjectTermsBtn.Click(5);

        switchToNewlyOpenTab();

        Step("Click on Terms of Service");
        SeleniumControl termsBtn = new SeleniumControl(By.xpath("//*[text()='Terms of Service']"));
        termsBtn.Click(5);
        Info("Clicked on 'Terms of Service'");

    }

    @Test (groups = {"regressionTest"})
    @Description("Test to prove there is a bug with the return arrow in the message modal.")
    public void TestReturnButtonDoesNotWork() throws Exception
    {
        String name = "Art";

        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Icon");
        SeleniumControl podiumBtn = new SeleniumControl(By.className("ContactBubble__Bubble"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");

        Step("Switch to main frame");
        switchToMainFrame();

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-modal");

        Step("Click on first location in location list");
        SeleniumControl locationBtn = new SeleniumControl(By.xpath("//*[@class='LocationContainer StaggerFadeIn3 LocationContainer--desktop']"));
        locationBtn.Click(5);
        Info("Clicked on first location");

        Step("Click on return arrow");
        SeleniumControl returnArrowBtn = new SeleniumControl((By.xpath("//*[@class='SendSmsPage__ArrowIcon']")));
        returnArrowBtn.Click(5);
        Info("Successfully clicked on return arrow");

        Step("Confirm message modal is still open by inputting text into name textbox");
        SeleniumControl nameTextBox = new SeleniumControl(By.xpath("//*[@class= 'TextInput__FormInput']"));
        nameTextBox.SetText(name, 5, null);
        Info(String.format("Inputted '%s' into name text field", name));
    }

    // TODO: BUG: Should search address textbox work?

    // TODO: Select all 3 locations. Weird bug according to SDET, should be 4 locations
}

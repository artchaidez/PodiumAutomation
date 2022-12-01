package webTests;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Pages;
import webTestFramework.SeleniumControl;

// TODO: Extend class to a class from Pages Package. This class will extend AutoBase
// TODO: Run from command line
// TODO: BUG: Should search address textbox work?
public class PodiumTestCases extends Pages {

    @BeforeMethod
    public void TestSetUp()
    {
        InitWebDriver();
    }

    @AfterMethod
    public void TestTearDown()
    {
        Quit();
    }

    @Test (groups = {"smokeTest"})
    @Description("Test to switch to correct iframes and click on Podium icon.")
    public void TestClickPodiumButton() throws Exception
    {
        Step("Go to Podium Demo Website");
            GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Verify on site by finding podium bubble");
            podiumBubble.VerifyPodiumBubbleExists();
            Info("Found Podium bubble");

        Step("Switch to Podium bubble iframe");
            Sleep(1);
            podiumBubble.GoToPodiumBubbleFrame();
            Info("Currently within Podium bubble iframe");

        Step("Click on Podium Bubble");
            podiumBubble.ClickOnPodiumButton();

        Step("Return to main frame");
            switchToMainFrame();

        Step("Switch to Podium modal iframe");
            podiumBubble.GoToPodiumModalFrame();

        Step("Verify on Podium Modal");
            podiumBubble.VerifyOnModal();
            Info("Podium modal is visible");

    }

    @Test (groups = {"smokeTest"})
    @Description("Test to click on first location found in Location modal.")
    public void TestSelectFirstLocation() throws Exception
    {
        Step("Go to Podium Website");
            GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Go immediately to Podium modal");
            Sleep(1);
            podiumBubble.JumpToModal();

        Step("Click on first location in location list");
            podiumModal.ClickFirstLocation();

        Step("Verify on message modal");
            podiumModal.VerifyNameTextInputExists();
            Info("Within message modal as name text input was found.");

    }

    @Test (groups = {"regressionTest"})
    @Description("Test to confirm correct location is being clicked in the modal")
    public void TestScoreboardOremLocationExists() throws Exception
    {
        String location = "Scoreboard Sports - Orem";

        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Go immediately to Podium modal");
            Sleep(1);
            podiumBubble.JumpToModal();

        Step(String.format("Confirm %s is in location list", location));
        SeleniumControl locationBtn = new SeleniumControl(By.xpath(String.format("//*[text()= \"%s\"]", location)));
        locationBtn.IsVisible(5);
        Info(String.format("%s is in the modal", location));

        Step(String.format("Click on %s", location));
        locationBtn.Click(5);

        Step(String.format("Confirm %s opened up", location));
        // This works, but need a way to prove text
        SeleniumControl modalText = new SeleniumControl(By.xpath("//*[@class='SendSmsPage__CurrentLocationName']"));
        String locationText = modalText.getWebElement().getText();
        Assert.assertEquals(locationText, location);

    }

    @Test (groups = {"smokeTest"})
    @Description("Test to input data in all 3 fields of message modal")
    public void TestInputMessageData() throws Exception
    {
        String name = "Art";
        String telephone = "7777777777";
        String message = "Hello QA Tester";

        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium modal");
        Sleep(1);
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

        Step("Input name in Name text field");
        SeleniumControl nameTextBox = new SeleniumControl(By.xpath("//*[@id= 'Name']"));
        nameTextBox.SetText(name, 5, null);
        Info(String.format("Inputted '%s' into name text field", name));
        Sleep(1);
        SeleniumControl checkMark = new SeleniumControl(By.xpath("//*[@class='checkmark']"));
        checkMark.IsVisible(5);

        Step("Input phone number into mobile phone text field");
        SeleniumControl telephoneTextBox = new SeleniumControl(By.xpath("//*[@id= 'Mobile Phone']"));
        telephoneTextBox.SetText(telephone, 5, null);
        // TODO: Verify checkmark appears
        SeleniumControl flagIcon = new SeleniumControl(By.xpath("//*[@class='flag-picker']"));
        Sleep(1);
        flagIcon.IsVisible(5);

        Step("Input message in message text field");
        SeleniumControl messageTextBox = new SeleniumControl(By.xpath("//*[@id= 'Message']"));
        messageTextBox.SetText(message, 5, null);
        Info(String.format("Inputted '%s' into message text field", message));
        // TODO: verify text was inputted
        SeleniumControl messageCharCount = new SeleniumControl(By.xpath("//path[@d='M 50 0 A 50 50 0 0 1 50 0']"));
        Sleep(1);
        messageCharCount.IsNotVisible(5);


        // TODO: use this to verify all text fields inputted
        SeleniumControl sendValid = new SeleniumControl(By.xpath("//*[@class= 'SendButton SendButton--valid']"));
        Sleep(1);
        sendValid.IsVisible(5);

    }

    @Test (groups = {"regressionTest"})
    @Description("Test to confirm subject and terms are opened in a new tab.")
    public void TestClickSubjectTerms() throws Exception
    {
        Step("Go to Podium Website");
            GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Go immediately to Podium modal");
            Sleep(1);
            podiumBubble.JumpToModal();

        Step("Click on 'use is subject to terms'");
            podiumModal.ClickOnTermsButton();

        Step("Switch to Terms and Service page");
            switchToNewlyOpenTab();

        Step("Verify on Terms and Service page by clicking on 'Terms of Service'");
            podiumModal.VerifyOnSubjectTermsPage();
            Info("Clicked on 'Terms of Service'");
    }

    @Test (groups = {"regressionTest"})
    @Description("Test to prove there is a bug with the return arrow in the message modal.")
    public void TestReturnButtonDoesNotWork() throws Exception
    {
        String message = "There is a bug with the return arrow on the message widget!";

        Step("Go to Podium Website");
            GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Go immediately to Podium modal");
            Sleep(1);
            podiumBubble.JumpToModal();

        Step("Click on first location in location list");
            podiumModal.ClickFirstLocation();

        Step("Verify on message modal");
            podiumModal.VerifyNameTextInputExists();
            Info("Within message modal as name text input was found.");

        Step("Click on return arrow");
            podiumModal.ClickOnReturnArrowBtn();

        Step("Confirm message modal is still open by inputting text into message text field");
            podiumModal.SetTextInNameInput(message, 5, null);
            Info(String.format("Inputted '%s' into message text field", message));
    }
}

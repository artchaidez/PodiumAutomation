package webTests;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Pages;
import webTestFramework.SeleniumControl;

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
            podiumModal.SelectFirstLocation();

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
            Assert.assertEquals(podiumModal.GetLocationInMessageModal(), location);

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

        Step("Go immediately to Podium modal");
            Sleep(1);
            podiumBubble.JumpToModal();

        Step("Click on first location in location list");
            podiumModal.SelectFirstLocation();

        Step("Input name in Name text field");
            podiumModal.SetTextInNameInput(name, 5, null);
            Sleep(1);

        Step("Verify text was put into name input");
            podiumModal.VerifyCheckMarkExists();

        Step("Input phone number into mobile phone text input");
            podiumModal.SetMobileNumberInput(telephone, 5, null);
            Sleep(1);

        Step("Verify phone number was put into input");
        // TODO: Verify checkmark appears. Only checking for flag rn
            podiumModal.VerifyPhoneNumberFlagExists();

        Step("Input message in message text field");
        SeleniumControl confirm = new SeleniumControl(By.xpath("//*[local-name()='svg']//*[local-name()='g']//*[@d='M 50 0 A 50 50 0 0 1 50 0']"));
        Sleep(1);
        podiumModal.SetMessageInput(message, 5, null);
        // TODO: verify text was inputted
        // TODO: Idea, check is long xpath exists. It does change and this proves icon changed.
        //  Create a method that it is not longer visible
        // //*[local-name()='svg']//*[local-name()='g']//*[@d='M 50 0 A 50 50 0 0 1 50 0']

        Sleep(1);
        confirm.IsNotVisible(5);

        Step("Verify all inputs have data");
            podiumModal.VerifyAllInputsComplete();
            Info("All inputs filled out and send button is valid");

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
            podiumModal.SelectFirstLocation();

        Step("Verify on message modal");
            podiumModal.VerifyNameTextInputExists();
            Info("Within message modal as name text input was found.");

        Step("Click on return arrow");
            podiumModal.ClickOnReturnArrowBtn();

        Step("Confirm message modal is still open by inputting text into message input");
            podiumModal.SetTextInNameInput(message, 5, null);
            Info(String.format("Inputted '%s' into message text field", message));

        Step("Verify text was inputted into message input");
        // TODO: Verify text was put in

    }
}

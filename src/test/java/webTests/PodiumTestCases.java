package webTests;

import jdk.jfr.Description;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.Pages;
import webTestFramework.SeleniumControl;

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
            podiumBubble.JumpToPodiumModal();

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
            podiumBubble.JumpToPodiumModal();

        Step(String.format("Confirm %s is in location list", location));
            SeleniumControl locationBtn = new SeleniumControl(By.xpath(String.format("//*[text()= \"%s\"]", location)));
            locationBtn.IsVisible(5);
            Info(String.format("%s is in the modal", location));

        Step(String.format("Click on %s", location));
            locationBtn.Click(5);

        Step(String.format("Confirm %s opened up", location));
            // TODO: make this a method that returns bool. Do not use assert
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
            podiumBubble.JumpToPodiumModal();

        Step("Click on first location in location list");
            podiumModal.SelectFirstLocation();

        Step("Input name in Name text field");
            podiumModal.SetTextInNameInput(name, 5, null);
            Sleep(1);

        Step("Verify text was put into name input");
            podiumModal.VerifyNameCheckmarkExists();

        Step("Input phone number into mobile phone text input");
            podiumModal.SetMobileNumberInput(telephone, 5, null);
            Sleep(1);

        Step("Verify phone number was put into input");
            podiumModal.VerifyMobileNumberCheckmarkExists();

        Step("Input message in message text field");
        // //*[local-name()='svg']//*[local-name()='g']//*[@d='M 50 0 A 50 50 0 0 1 50 0']
        // //*[contains(@d, 'M 50 0 A 50 50 0 0 1 50 0' )]
        SeleniumControl confirm = new SeleniumControl(By.xpath("//*[contains(@d, 'M 50 0 A 50 50 0 0 1 50 0' )]"));
        //podiumModal.SetMessageInput(message, 5, null);
        // TODO: Idea, check is long xpath exists. It does change and this proves icon changed.
        //  Create a method that it is not longer visible

        //confirm.IsVisible(5);
        String tury = confirm.getAttribute("d");

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
            podiumBubble.JumpToPodiumModal();

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
            podiumBubble.JumpToPodiumModal();

        Step("Click on first location in location list");
            podiumModal.SelectFirstLocation();

        Step("Verify on message modal");
            podiumModal.VerifyNameTextInputExists();
            Info("Within message modal as name text input was found.");

        Step("Click on return arrow");
            podiumModal.ClickOnReturnArrowBtn();

        Step("Confirm message modal is still open by inputting text into message input");
            podiumModal.SetMessageInput(message, 5, null);
            Info(String.format("Inputted '%s' into message text field", message));

        Step("Verify text was inputted into message input");
        // TODO: Verify text was put in

    }
}

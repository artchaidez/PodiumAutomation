package webTests;

import autoFramework.AutoBase;
import com.thoughtworks.selenium.webdriven.commands.IsVisible;
import org.openqa.selenium.By;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import webTestFramework.SeleniumControl;

import java.awt.event.WindowFocusListener;

// TODO: Extend class to a class from Pages Package. This class will extend AutoBase
public class PodiumTestCases extends AutoBase {

    @BeforeTest
    public void TestSetUp()
    {
        InitWebDriver();
    }

    // This should be a smoke test?
    @Test
    public void TestClickPodiumButton() throws Exception
    {
        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium bubble");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Bubble");
        SeleniumControl podiumBtn = new SeleniumControl(By.xpath("//*[@class='ContactBubble__Bubble']"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");
    }

    // This should be a smoke test?
    @Test
    public void TestSelectFirstLocation() throws Exception
    {
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

        Step("Click on first location in widget");
        SeleniumControl locationBtn = new SeleniumControl(By.xpath("//*[@class='LocationContainer StaggerFadeIn3 LocationContainer--desktop']"));
        locationBtn.Click(5);
        Info("Clicked on first location");

    }

    // This should be a smoke test?
    // TODO: Complete TestInputMessageData
    @Test
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
        SeleniumControl podiumBtn = new SeleniumControl(By.xpath("//*[@class='ContactBubble__Bubble']"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");

        Step("Switch to main frame");
        switchToMainFrame();

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-modal");

        Step("Click on first location in widget");
        SeleniumControl locationBtn = new SeleniumControl(By.xpath("//*[@class='LocationContainer StaggerFadeIn3 LocationContainer--desktop']"));
        locationBtn.Click(5);
        Info("Clicked on first location");

        // TODO: xpath class names for all three textfields all differ. Should be consistent
        // NOTE: still within iframe podium-modal
        // NOTE: after opening message, Name already clicked
        Step("Input name in Name text field");
        SeleniumControl nameTextBox = new SeleniumControl(By.xpath("//*[@class= 'TextInput__FormInput']"));
        nameTextBox.SetText(name, 5, null);
        Info(String.format("Inputted '%s' into name text field", name));

        // NOTE: correct xpath for telephone "//*[@class= 'TextInput TextInput--tel']"
        // NOTE: using SetText() for telephone returns error.
        // element.sendKeys(Keys.CONTROL + "a"); cannot interact with textbox
        // this.GetAttribute("type"); returns null
        // maybe create new method to work with type=tel?
        SeleniumControl telephoneTextBox = new SeleniumControl(By.xpath("//*[@class= 'TextInput TextInput--tel']"));
        // TODO: Need to send numbers, not string. Need new method
        telephoneTextBox.SetText(telephone, 5, null);

        SeleniumControl messageTextBox = new SeleniumControl(By.xpath("//*[@class= 'TextInput__Textarea ']"));
        messageTextBox.SetText(message, 5, null);
        Info(String.format("Inputted '%s' into message text field", message));

    }

    // This should be a regression test?
    @Test
    public void TestClickSubjectTerms() throws Exception
    {
        Step("Go to Podium Website");
        GoToURL("https://demo.podium.tools/qa-webchat-lorw/");

        Step("Switch to iframe Podium bubble");
        switchToiFrame("podium-bubble");

        Step("Click on Podium Bubble");
        SeleniumControl podiumBtn = new SeleniumControl(By.xpath("//*[@class='ContactBubble__Bubble']"));
        podiumBtn.Click(5);
        Info("Clicked on Podium bubble");

        Step("Switch to main frame");
        switchToMainFrame();

        Step("Switch to iframe Podium modal");
        switchToiFrame("podium-modal");

        Step("Click on 'use is subject to terms");
        // both work: 'terms' and 'LocationSelector__PodiumPower'
        SeleniumControl subjectTermsBtn = new SeleniumControl(By.xpath("//*[@class='LocationSelector__PodiumPower']"));
        subjectTermsBtn.Click(5);

        Step("Switch to main frame");
        switchToMainFrame();
        Sleep(3);

        Step("Click on Terms of Service"); // update this
        // TODO: confirm new page opened
        SeleniumControl termsBtn = new SeleniumControl(By.xpath("//*[contains(text(), 'Podium Acceptable Use Policy')]"));
        //termsBtn.Click(5);
        termsBtn.IsVisible(5);
        Info("Clicked on 'Terms of Service'");

    }

    // TODO: Bug found, cannot click back button to Select Location widget
    // TODO: Should textbox search address options?

    // TODO: Click on 'use is subject to terms' on bottom of Select Location widget
    // TODO: Select all 3 locations. Weird bug according to SDET, should be 4 locations
    // TODO: Input data into all 3 textfields. Do not need to click SEND
}

package pages;

import autoFramework.AutoBase;
import org.openqa.selenium.By;
import webTestFramework.SeleniumControl;

public class PodiumModal extends AutoBase {

    SeleniumControl firstLocation = new SeleniumControl(By.xpath("//*[@class='LocationContainer StaggerFadeIn3 LocationContainer--desktop']"));

    SeleniumControl nameTextInput = new SeleniumControl(By.xpath("//*[@id= 'Name']"));

    SeleniumControl checkMark = new SeleniumControl(By.xpath("//*[@class='checkmark']"));

    SeleniumControl telephoneTextInput = new SeleniumControl(By.xpath("//*[@id= 'Mobile Phone']"));

    SeleniumControl flagIcon = new SeleniumControl(By.xpath("//*[@class='flag-picker']"));

    SeleniumControl messageTextInput = new SeleniumControl(By.xpath("//*[@id= 'Message']"));

    SeleniumControl sendButtonValid = new SeleniumControl(By.xpath("//*[@class= 'SendButton SendButton--valid']"));

    SeleniumControl subjectTermsBtn = new SeleniumControl(By.className("terms"));

    SeleniumControl termsBtn = new SeleniumControl(By.xpath("//*[text()='Terms of Service']"));

    SeleniumControl returnArrowBtn = new SeleniumControl((By.xpath("//*[@class='SendSmsPage__ArrowIcon']")));

    SeleniumControl locationText = new SeleniumControl(By.xpath("//*[@class='SendSmsPage__CurrentLocationName']"));

    SeleniumControl addressText = new SeleniumControl(By.xpath("//*[@class='SendSmsPage__CurrentLocationAddress']"));

    public void SelectFirstLocation() throws Exception {
        firstLocation.Click(5);
    }

    // TODO: Delete?
    public void FirstLocationIsVisible()
    {
        firstLocation.IsVisible(5);
    }

    public void VerifyNameTextInputExists()
    {
        nameTextInput.IsVisible(5);
    }

    public void SetTextInNameInput(String data, int Max_Retries, Boolean escape) throws Exception
    {
        nameTextInput.SetText(data, Max_Retries, escape);
    }

    public void VerifyCheckMarkExists()
    {
        checkMark.IsVisible(5);
    }

    public void SetMobileNumberInput(String data, int Max_Retries, Boolean escape) throws Exception
    {
        telephoneTextInput.SetText(data, Max_Retries, escape);
    }

    public void VerifyPhoneNumberFlagExists()
    {
        flagIcon.IsVisible(5);
    }

    public void SetMessageInput(String data, int Max_Retries, Boolean escape) throws Exception
    {
        messageTextInput.SetText(data, Max_Retries, escape);
    }

    public void VerifyAllInputsComplete()
    {
        sendButtonValid.IsVisible(5);
    }

    public void ClickOnTermsButton() throws Exception
    {
        subjectTermsBtn.Click(5);
    }

    public void VerifyOnSubjectTermsPage()
    {
        termsBtn.IsVisible(5);
    }

    /** Click on arrow on message modal to return to location list modal */
    public void ClickOnReturnArrowBtn() throws Exception
    {
        returnArrowBtn.Click(5);
    }

    public String GetLocationInMessageModal()
    {
        return locationText.getWebElement().getText();
    }

    public String GetAddressInMessageModal()
    {
        return addressText.getWebElement().getText();
    }

    // TODO: Delete
    public SeleniumControl CreateLocationSeleniumControl(String location)
    {
        return new SeleniumControl(By.xpath(String.format("//*[text()= \"%s\"]", location)));
    }

}

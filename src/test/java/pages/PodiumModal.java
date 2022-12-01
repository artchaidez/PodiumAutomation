package pages;

import autoFramework.AutoBase;
import org.openqa.selenium.By;
import webTestFramework.SeleniumControl;

public class PodiumModal extends AutoBase {

    SeleniumControl firstLocation = new SeleniumControl(By.id("widget-location-item-63146"));

    SeleniumControl nameTextInput = new SeleniumControl(By.xpath("//*[@id= 'Name']"));

    SeleniumControl nameCheckMark = new SeleniumControl(By.xpath("//*[@class='TextInput']//*[@class='checkmark']"));

    SeleniumControl mobileNumberTextInput = new SeleniumControl(By.xpath("//*[@id= 'Mobile Phone']"));

    SeleniumControl mobileNumberCheckmark = new SeleniumControl(By.xpath("//*[@class='TextInput TextInput--tel']//*[@class='checkmark']"));

    SeleniumControl messageTextInput = new SeleniumControl(By.xpath("//*[@id= 'Message']"));

    SeleniumControl sendButtonValid = new SeleniumControl(By.xpath("//*[@class= 'SendButton SendButton--valid']"));

    SeleniumControl subjectTermsLink = new SeleniumControl(By.className("terms"));

    SeleniumControl termsLink = new SeleniumControl(By.xpath("//*[text()='Terms of Service']"));

    SeleniumControl returnArrowBtn = new SeleniumControl((By.xpath("//*[@class='SendSmsPage__ArrowIcon']")));

    SeleniumControl locationText = new SeleniumControl(By.xpath("//*[@class='SendSmsPage__CurrentLocationName']"));

    SeleniumControl addressText = new SeleniumControl(By.xpath("//*[@class='SendSmsPage__CurrentLocationAddress']"));

    public void SelectFirstLocation() throws Exception {
        firstLocation.Click(5);
    }

    public void VerifyNameTextInputExists()
    {
        nameTextInput.IsVisible(5);
    }

    public void SetTextInNameInput(String data, int Max_Retries, Boolean escape) throws Exception
    {
        nameTextInput.SetText(data, Max_Retries, escape);
    }

    public void VerifyNameCheckmarkExists()
    {
        nameCheckMark.IsVisible(5);
    }

    public void SetMobileNumberInput(String data, int Max_Retries, Boolean escape) throws Exception
    {
        mobileNumberTextInput.SetText(data, Max_Retries, escape);
    }

    public void VerifyMobileNumberCheckmarkExists()
    {
        mobileNumberCheckmark.IsVisible(5);
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
        subjectTermsLink.Click(5);
    }

    public void VerifyOnSubjectTermsPage()
    {
        termsLink.IsVisible(5);
    }

    /** Click on arrow on message modal to return to location list modal */
    public void ClickOnReturnArrowBtn() throws Exception
    {
        returnArrowBtn.Click(5);
    }

    public String GetLocationInMessageModal()
    {
        return locationText.getText();
    }

    public String GetAddressInMessageModal()
    {
        return addressText.getText();
    }


}

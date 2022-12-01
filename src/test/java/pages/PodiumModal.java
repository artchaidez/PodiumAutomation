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


    public void ClickFirstLocation() throws Exception {
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
        nameTextInput.SetText(data, 5, null);
    }


    public void VerifyCheckMarkExists()
    {
        checkMark.IsVisible(5);
    }

    public void VerifyFlagExists()
    {
        flagIcon.IsVisible(5);
    }

    public void VerifyAllTextFieldsComplete()
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

}

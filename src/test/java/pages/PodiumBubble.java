package pages;

import autoFramework.AutoBase;
import org.openqa.selenium.By;
import webTestFramework.SeleniumControl;

public class PodiumBubble extends AutoBase {

    SeleniumControl podiumBubble = new SeleniumControl(By.id("podium-bubble"));

    SeleniumControl podiumBtn = new SeleniumControl(By.className("ContactBubble__Bubble"));

    SeleniumControl modal = new SeleniumControl(By.xpath("//*[contains( @class , 'SearchInput')]"));

    /** Switch to podium bubble iframe.*/
    public void GoToPodiumBubbleFrame() {
        switchToiFrame("podium-bubble");
    }

    /** Verify in main iframe by looking Podium bubble exists. Podium button should not visible.*/
    public void VerifyPodiumBubbleExists()
    {
        podiumBubble.IsVisible(5);
    }

    public void ClickOnPodiumButton() throws Exception
    {
        podiumBtn.Click(5);
    }

    /** Verify within podium-bubble iframe and Podium button exists*/
    public void VerifyPodiumBtnExists() throws Exception
    {
        podiumBtn.IsVisible(5);
    }

    public void GoToPodiumModalFrame()
    {
        switchToiFrame("podium-modal");
    }

    /** Verify Podium button has been clicked and within modal appear.
     * Looks for searchbar. */
    public void VerifyOnModal()
    {
        modal.IsVisible(5);
    }

    // TODO: main frame -> bubble iFrame -> main iFrame -> modal iFrame
    public void JumpToModal() throws Exception
    {
        switchToMainFrame();
        switchToiFrame("podium-bubble");
        podiumBtn.Click(5);
        switchToMainFrame();
        switchToiFrame("podium-modal");
    }
}

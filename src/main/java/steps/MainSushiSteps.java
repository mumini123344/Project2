package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import pages.MainSushiPage;

import static com.codeborne.selenide.Selenide.closeWindow;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainSushiSteps {
    MainSushiPage mainSushiPage = new MainSushiPage();

    @Step("Click share and check facebook login form")
    public MainSushiSteps sharing() {
        mainSushiPage.shareButton.click();
        switchTo().window("Facebook");
        mainSushiPage.facebookLoginForm.shouldBe(Condition.visible);
        closeWindow();
        return this;
    }


}

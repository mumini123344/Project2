package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.switchTo;

public class MainSushiPage {
    public SelenideElement shareButton = $(".share");
    public SelenideElement facebookLoginForm = $("#loginform");
}

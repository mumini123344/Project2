package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    // Accepting Cookie
    public SelenideElement cookie = $(By.className("cookieSection"));
    public SelenideElement acceptCookie = $(".acceptCookie");

    public SelenideElement relaxHeader = $(byXpath("(//li[@class='MoreCategories'])[3]"));

}

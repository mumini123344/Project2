package pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.List;

import static com.codeborne.selenide.Selectors.byId;
import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;


public class RelaxPage {

    public SelenideElement minPrice = $(byXpath("(//input[@id='minprice'])[2]"));
    public SelenideElement maxPrice = $(byXpath("(//input[@id='maxprice'])[2]"));
    public SelenideElement search = $(byXpath("(//div[@class='submit-button'][contains(text(),'ძებნა')])[2]"));
    public SelenideElement priceSection = $(byXpath("(//div[@class='price-filter'])[2]"));
    public List<SelenideElement> prices = $$("div.discounted-prices p:first-child");


}

package steps;

import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pages.RelaxPage;

import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.url;

public class RelaxSteps {
    RelaxPage relaxPage = new RelaxPage();
    SoftAssert softAssert = new SoftAssert();

    @Step("Scroll down")
    public RelaxSteps scrollDown() {
        relaxPage.priceSection.scrollIntoView(true);
        return this;
    }

    @Step("Fill min price")
    public RelaxSteps minPrice() {
        relaxPage.minPrice.sendKeys("200");
        return this;
    }

    @Step("Fill max price")
    public RelaxSteps maxPrice() {
        relaxPage.maxPrice.sendKeys("230");
        return this;
    }

    @Step("Click search button under min and max price section")
    public RelaxSteps clickSearch() {
        relaxPage.search.click();
        return this;
    }

    @Step("Check price range")
    public RelaxSteps checkPrices() {
        webdriver().shouldHave(url("https://www.swoop.ge/category/24/dasveneba/?minprice=200&maxprice=230"));
        for (int i = 0; i < relaxPage.prices.size() - 1; i++) {
            String actualString = relaxPage.prices.get(i).getText();
            String editedString = actualString.replace("₾", "");
            int valueOfString = Integer.parseInt(editedString);
            softAssert.assertEquals(valueOfString <= 230 && valueOfString >= 200, true);
        }
        softAssert.assertAll();
        return this;
    }
}

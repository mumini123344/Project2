package steps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.testng.asserts.SoftAssert;
import pages.SushiPage;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SushiSteps {

    SushiPage sushiPage = new SushiPage();
    SoftAssert softAssert = new SoftAssert();

    @Step
    public SushiSteps firstElement() {
        sushiPage.firstFavProduct.click();
        return this;
    }

    @Step
    public SushiSteps loginAssert() {
        sushiPage.loginPage.shouldBe(Condition.visible);
        return this;
    }

    @Step
    public SushiSteps closingLoginForm() {
        sushiPage.closeButton.click();
        return this;
    }

    @Step("Validation of sold charts")
    public SushiSteps checkingSoldCharts() {
        String soldText = sushiPage.soldAmount.get(0).getText();
        String parseSoldText = soldText.replace("გაყიდულია ", "");
        int value = Integer.parseInt(parseSoldText);

        String diagram = Objects.requireNonNull(sushiPage.soldDiagram.get(0).getAttribute("data-width")).replace("%", "");
        int diagramPercentage = Integer.parseInt(diagram) / 100;

        int total = 0;
        if (value != 0 && diagramPercentage < 1) {
            total = value / diagramPercentage;

            int currentValue = total * diagramPercentage;
            softAssert.assertEquals(value, currentValue);
        } else if (diagramPercentage == 100) {
            System.out.println("All sold out");
            softAssert.fail();
        } else {
            System.out.println("Nothing is sold");
        }
        softAssert.assertAll();
        return this;
    }

    @Step("Click sorting")
    public SushiSteps clickSorting() {
        sushiPage.sort.click();
        return this;
    }

    @Step("Click decreasing")
    public SushiSteps decreasing() {
        sushiPage.decreasingPrice.click();
        return this;
    }

    @Step("Check decreasing sort output")
    public SushiSteps checkingDecreasingSort() {

        String firstSushi = sushiPage.sushiPrices.get(0).getText().replace("₾", "");
        String secondSushi = sushiPage.sushiPrices.get(1).getText().replace("₾", "");

        int firstSushiPrice = Integer.parseInt(firstSushi);
        int secondSushiPrice = Integer.parseInt(secondSushi);

        softAssert.assertEquals(true, firstSushiPrice > secondSushiPrice);
        softAssert.assertAll();
        return this;


    }

    @Step("Click Sushi")
    public SushiSteps clickingSushi() {
        sushiPage.firstProduct.click();
        return this;
    }

}

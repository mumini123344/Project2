package steps;

import com.codeborne.selenide.testng.SoftAsserts;
import io.qameta.allure.Step;
import org.testng.Assert;
import pages.CategoriesPage;

public class CategoriesSteps {
    CategoriesPage categoriesPage = new CategoriesPage();

    @Step("Categories section ")
    public CategoriesSteps categoriesSelection() {
        categoriesPage.categories.click();
        return this;
    }

    @Step("Click food")
    public CategoriesSteps nutritionHover() {
        categoriesPage.nutrition.hover();
        return this;
    }

    @Step("Click Sushi")
    public CategoriesSteps clickSushi() {
        categoriesPage.sushi.click();
        return this;
    }


}

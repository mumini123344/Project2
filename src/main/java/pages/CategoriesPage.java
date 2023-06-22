package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class CategoriesPage {
    public SelenideElement categories = $(".categoriesTitle");
    public SelenideElement nutrition = $(byXpath("//a[contains(text(),'კვება')]"));

    public SelenideElement sushi = $(byXpath("//div[@class='mobileSubCategories subCategory-3 openedMenu']//a[contains(text(),'სუში')]"));
    public SelenideElement firstProduct = $$(".container.deal-container.category-offers").first();
    public SelenideElement addToFavoritesButton = firstProduct.$(".deal-basket-wishlist");
    public SelenideElement loginPage = $(".main-page-login");
}

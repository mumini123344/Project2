package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byXpath;
import static com.codeborne.selenide.Selenide.$;

public class RegistrationPage {

    public SelenideElement login = $(".HeaderTools.swoop-login");
    public SelenideElement registration = $("#ui-id-3");
    public SelenideElement name = $("#pFirstName");
    public SelenideElement surname = $("#pLastName");
    public SelenideElement mail = $("#pEmail");
    public SelenideElement phoneNumber = $("#pPhone");
    public SelenideElement date = $("#pDateBirth");
    public SelenideElement password = $("#pPassword");
    public SelenideElement confirmPassword =$("#pConfirmPassword");
    public SelenideElement registrationButton = $(".dashbord-registration");

    public SelenideElement errorMessage  = $(byXpath("(//p[@id='physicalInfoMassage'])[contains(.,'გთხოვთ აირჩიოთ სქესი!')]"));


}

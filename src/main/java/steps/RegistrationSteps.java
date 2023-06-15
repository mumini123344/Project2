package steps;

import Utils.DataBase;
import com.codeborne.selenide.Condition;
import data.UserData;
import io.qameta.allure.Step;
import pages.RegistrationPage;

import java.sql.Date;


public class RegistrationSteps {

    RegistrationPage registrationPage = new RegistrationPage();


    @Step("Click login button")
    public RegistrationSteps login() {
        registrationPage.login.click();
        return this;
    }

    @Step("Click registration button")
    public RegistrationSteps clickRegistration() {
        registrationPage.registration.click();
        return this;
    }

    @Step("Set value for  firstName")
    public RegistrationSteps fillFirstName(String firstName) {
        registrationPage.name.sendKeys(firstName);
        return this;
    }

    @Step("Set value for last name")
    public RegistrationSteps fillLastName(String lastName) {
        registrationPage.surname.sendKeys(lastName);
        return this;
    }

    @Step("Set value for phone number")
    public RegistrationSteps fillNumber(String phone) {
        registrationPage.phoneNumber.sendKeys(phone);
        return this;
    }

    @Step("Set value for email")
    public RegistrationSteps fillEmail(String email) {
        registrationPage.mail.sendKeys(email);
        return this;
    }

    @Step("Set value for birth of date")
    public RegistrationSteps fillDate(Date dateOfBirth) {
        registrationPage.date.sendKeys(dateOfBirth.toString());
        return this;
    }

    @Step("Set value for password")
    public RegistrationSteps fillPass(String password) {
        registrationPage.password.sendKeys(password);
        return this;
    }

    @Step("Set value for confirmation password")
    public RegistrationSteps fillConfirmPass(String password) {
        registrationPage.confirmPassword.sendKeys(password);
        return this;
    }


    @Step("Click submit button")
    public RegistrationSteps submit() {
        registrationPage.registrationButton.click();
        return this;
    }

    @Step("Check info message")
    public RegistrationSteps infoMessage() {
        registrationPage.errorMessage.shouldBe(Condition.visible);
        return this;
    }

}
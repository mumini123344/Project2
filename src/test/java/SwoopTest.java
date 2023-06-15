import Utils.DataBase;
import com.codeborne.selenide.WebDriverRunner;
import data.UserData;
import io.qameta.allure.*;
import net.bytebuddy.implementation.bind.annotation.DefaultCall;
import org.testng.annotations.*;
import steps.*;

import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;


@Epic("Swoop.ge testing")
@Feature("დასვენება and სუში page's testing")
public class SwoopTest {

    RelaxSteps relaxSteps = new RelaxSteps();
    MainSteps mainSteps = new MainSteps();
    CategoriesSteps categoriesSteps = new CategoriesSteps();
    SushiSteps sushiSteps = new SushiSteps();
    MainSushiSteps mainSushiSteps = new MainSushiSteps();
    RegistrationSteps registrationSteps = new RegistrationSteps();
    DataBase dataBase = new DataBase();


    @BeforeMethod(alwaysRun = true)
    @Story("Opening url for all tests")
    @Description("Maximize browsers windows")
    public void setUp() {
        open("https://www.swoop.ge/");
        WebDriverRunner.getWebDriver().manage().window().maximize();

    }

    @Test(description = "FirstTest, Searches places in price range and checking it", groups = "Regression1")
    @Feature("Cheking price ranges for holiday places")
    @Description("Testing holiday section and price ranges")
    public void FirstTest() {
        mainSteps.hovering()
                .clickCookie()
                .clickRelax();

        relaxSteps.scrollDown()
                .minPrice()
                .maxPrice()
                .clickSearch()
                .checkPrices();

    }

    @Test(description = "SecondTest, checking sold charts amount", groups = "Regression1")
    @Feature("Checking login form and sold charts amount")
    @Story("Valid sold charts test")
    @Description("Testing categories section and favourite button click")
    public void SecondTest() {
        categoriesSteps.categoriesSelection()
                .nutritionHover()
                .clickSushi();

        sushiSteps.firstElement()
                .loginAssert()
                .closingLoginForm()
                .checkingSoldCharts();


    }


    @Test(description = "ThirdTest, Uses sorting filter", groups = "Regression2")
    @Feature("Sorting food prices and checking decreasing sort")
    @Description("Goes to the category menu and hovers food then choosing Sushi then sorting price by decreasing and filters them")
    public void ThirdTest() {
        categoriesSteps.categoriesSelection()
                .nutritionHover()
                .clickSushi();

        sushiSteps.clickSorting()
                .decreasing()
                .checkingDecreasingSort();


    }

    @Test(description = "ForthTest, checking share button  and popup window", groups = "Regression2")
    @Feature("Checking new window login form")
    @Story("Clicking one of the Sushi and then tries to share it on social")
    @Description("On sushi page clicking share and then new Facebook window popups, doing switchTo operation to" +
            "switch pages and then checking valid login form test")
    public void ForthTest() {
        categoriesSteps.categoriesSelection()
                .nutritionHover()
                .clickSushi();

        sushiSteps.clickingSushi();
        mainSushiSteps.sharing();


    }

    @Test(description = "FifthTest, committing data into database", groups = "Regression2")
    @Feature("Commits info")
    @Story("Function inserts info it database and then filling registration form with info")
    @Description("After filling registration form it submits and then validating info message")
    public void FifthTest() {
        dataBase.connection();
        try {
            dataBase.insertData().commitChanges();
            registrationSteps.login().
                    clickRegistration()
                    .fillFirstName(dataBase.getFirstName())
                    .fillLastName(dataBase.getLastName())
                    .fillEmail(dataBase.getEmail())
                    .fillNumber(dataBase.getPhone())
                    .fillDate(dataBase.getDateOfBirth())
                    .fillPass(dataBase.getPassword())
                    .fillConfirmPass(dataBase.getPassword())
                    .submit()
                    .infoMessage();


        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    @AfterMethod(alwaysRun = true)
    @Description("Quits browser")
    public void tearDown() {
        closeWebDriver();
    }

}

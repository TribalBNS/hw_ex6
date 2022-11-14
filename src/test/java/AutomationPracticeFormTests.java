import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.holdBrowserOpen = true;
    }

    @Test
    void fillFormTest() {
        String firstName = "Nick";
        String lastName = "Bel";
        String userEmail = "123@gmail.com";
        String userNumber = "5555135555";
        String gender = "Male";
        String bdayMonth = "January";
        String bdayYear = "1980";
        String bdayDay = "10";
        String datePickerDayMask = ".react-datepicker__day--0";
        String subjects = "Computer Science";
        String hobby1 = "Sports";
        String hobby2 = "Music";
        String pictureName = "1.jpeg";
        File img = new File("src/test/resources/" + pictureName);
        String currentAddress = "Address 123";
        String state = "NCR";
        String city = "Delhi";

        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");

        $("#firstName").setValue(firstName);
        $("#lastName").setValue(lastName);
        $("#userEmail").setValue(userEmail);
        $("#genterWrapper").$(byText(gender)).click();
        $("#userNumber").setValue(userNumber);
        $("#dateOfBirthInput").click();
        $(".react-datepicker__month-select").selectOption(bdayMonth);
        $(".react-datepicker__year-select").selectOption(bdayYear);
        $(datePickerDayMask + bdayDay).click();
        $("#subjectsInput").setValue(subjects).pressEnter();
        $("#hobbiesWrapper").$(byText(hobby1)).click();
        $("#hobbiesWrapper").$(byText(hobby2)).click();
        $("#uploadPicture").uploadFile(img);
        $("#currentAddress").setValue(currentAddress);
        $("#stateCity-wrapper").$("#state").click();
        $(byText(state)).click();
        $("#stateCity-wrapper").$("#city").click();
        $(byText(city)).click();
        $("#submit").click();

        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
        $(".table-responsive").shouldBe(visible).shouldHave(text("Label"), text("Values"));
        $(".table-responsive").shouldHave(text(firstName), text(lastName), text(userEmail), text(userNumber), text(gender), text(bdayDay + " " + bdayMonth + "," + bdayYear), text(subjects), text(hobby1 + ", " + hobby2), text(pictureName), text(currentAddress), text(state + " " + city));
    }
}

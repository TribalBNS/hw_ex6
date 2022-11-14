import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.File;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.by;
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
        String subjects = "Computer Science";
        File img = new File("src/test/img/1.jpeg");
        String currentAddress = "Address 123";
        open("/automation-practice-form");
        executeJavaScript("$('footer').remove()");
        executeJavaScript("$('#fixedban').remove()");
//<input required="" autocomplete="off" placeholder="First Name" type="text" id="firstName" class=" mr-sm-2 form-control">
        $(by("id", "firstName")).setValue(firstName);
//<input required="" autocomplete="off" placeholder="Last Name" type="text" id="lastName" class=" mr-sm-2 form-control">
        $(by("id", "lastName")).setValue(lastName);
//<input autocomplete="off" pattern="^([a-zA-Z0-9_\-\.]+)@([a-zA-Z0-9_\-\.]+)\.([a-zA-Z]{2,5})$" placeholder="name@example.com" type="text" id="userEmail" class="mr-sm-2 form-control">
        $(by("id", "userEmail")).setValue(userEmail);
//<label title="" for="gender-radio-1" class="custom-control-label">Male</label>
        $("#genterWrapper").$(byText("Male")).click();
//<input required="" autocomplete="off" pattern="\d*" minlength="10" maxlength="10" placeholder="Mobile Number" type="text" id="userNumber" class=" mr-sm-2 form-control">
        $(by("id", "userNumber")).setValue(userNumber);
//<input type="text" id="dateOfBirthInput" class="form-control" value="14 Nov 2022">
        $(by("id", "dateOfBirthInput")).click();
        $(".react-datepicker__month-select").selectOption("January");
        $(".react-datepicker__year-select").selectOption("1980");
        $(".react-datepicker__day--010").click();
//<input autocapitalize="none" autocomplete="off" autocorrect="off" id="subjectsInput" spellcheck="false" tabindex="0" type="text" aria-autocomplete="list" value="" style="box-sizing: content-box; width: 2px; background: 0px center; border: 0px; font-size: inherit; opacity: 1; outline: 0px; padding: 0px; color: inherit;">
        $(by("id", "subjectsInput")).setValue(subjects).pressEnter();
//<label title="" for="hobbies-checkbox-1" class="custom-control-label">Sports</label>
        $("#hobbiesWrapper").$(byText("Sports")).click();
//<label title="" for="hobbies-checkbox-3" class="custom-control-label">Music</label></div>
        $("#hobbiesWrapper").$(byText("Music")).click();
//<input id="uploadPicture" type="file" lang="en" class="form-control-file">
        $(by("id", "uploadPicture")).uploadFile(img);
//<textarea placeholder="Current Address" rows="5" cols="20" id="currentAddress" class="form-control">
        $(by("id", "currentAddress")).setValue(currentAddress);
//<div class=" css-2b097c-container" id="state">
        $("#stateCity-wrapper").$(by("id", "state")).click();
        $(byText("NCR")).click();
//<div class=" css-2b097c-container" id="city">
        $("#stateCity-wrapper").$(by("id", "city")).click();
        $(byText("Delhi")).click();
//<button id="submit" type="submit" class="btn btn-primary">Submit</button>
        $(by("id", "submit")).click();
//<div class="modal-title h4" id="example-modal-sizes-title-lg">Thanks for submitting the form</div>
        $(".modal-title").shouldHave(text("Thanks for submitting the form"));
    }
}

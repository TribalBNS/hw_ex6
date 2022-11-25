package tests;

import org.junit.jupiter.api.Test;

import java.io.File;

import static pages.components.StringArrayToStringComponent.convertStringArrayToString;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

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
        String[] subjects = {"Computer Science", "English"};
        String[] hobbies = {"Sports", "Music"};
        String pictureName = "1.jpeg";
        File img = new File("src/test/resources/" + pictureName);
        String currentAddress = "Address 123";
        String state = "NCR";
        String city = "Delhi";

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(bdayDay, bdayMonth, bdayYear)
                .setSubjects(subjects)
                .setHobbies(hobbies)
                .setPhoto(img)
                .setCurrentAddress(currentAddress)
                .setStateCity(state, city)
                .submitForm();

        registrationPage.verifyResultsModalAppearance()
                .verifyResults("Label", "Values")
                .verifyResults("Student Name", firstName + " " + lastName)
                .verifyResults("Student Email", userEmail)
                .verifyResults("Gender", gender)
                .verifyResults("Mobile", userNumber)
                .verifyResults("Date of Birth", bdayDay + " " + bdayMonth + "," + bdayYear)
                .verifyResults("Subjects", convertStringArrayToString(subjects, ", "))
                .verifyResults("Hobbies", convertStringArrayToString(hobbies, ", "))
                .verifyResults("Picture", pictureName)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city)
                .closeResultsForm();

    }
}


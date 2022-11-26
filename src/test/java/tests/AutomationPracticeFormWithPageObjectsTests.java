package tests;

import org.junit.jupiter.api.Test;

import static utils.StringArrayToStringUtil.convertStringArrayToString;
import static tests.TestData.*;

public class AutomationPracticeFormWithPageObjectsTests extends TestBase {

    @Test
    void fillFormTest() {

        registrationPage.openPage()
                .setFirstName(firstName)
                .setLastName(lastName)
                .setUserEmail(userEmail)
                .setGender(gender)
                .setUserNumber(userNumber)
                .setDateOfBirth(birthDateDay, birthDateMonth, birthDateYear)
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
                .verifyResults("Date of Birth", birthDateDay + " " + birthDateMonth + "," + birthDateYear)
                .verifyResults("Subjects", convertStringArrayToString(subjects, ", "))
                .verifyResults("Hobbies", convertStringArrayToString(hobbies, ", "))
                .verifyResults("Picture", pictureName)
                .verifyResults("Address", currentAddress)
                .verifyResults("State and City", state + " " + city)
                .closeResultsForm();

    }
}


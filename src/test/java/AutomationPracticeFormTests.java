import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;

public class AutomationPracticeFormTests {

    @BeforeAll
    static void BeforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";

    }
}

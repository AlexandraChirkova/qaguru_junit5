package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.enabled;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.*;

public class MainPage {

    private final SelenideElement searchBar = $("#search-bar-input");
    private final SelenideElement headerLogo = $("[alt='kaspi.kz']");
    private final SelenideElement cityTitle = $(".city-picker__button-city");

    public void searchQuery(String searchQuery) {
        searchBar.setValue(searchQuery).pressEnter();
    }

    public MainPage openMainPage() {
        open("/almaty/");
        waitForPageToLoad();
        return this;
    }

    public MainPage waitForPageToLoad() {

        headerLogo.shouldBe(visible, Duration.ofSeconds(10));
        searchBar.shouldBe(visible, enabled);
        cityTitle.shouldBe(visible);

        executeJavaScript("return document.readyState").equals("complete");

        searchBar.shouldBe(Condition.interactable, Duration.ofSeconds(10));

        return this;
    }

}

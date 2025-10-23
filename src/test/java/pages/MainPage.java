package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    private final SelenideElement searchBar = $("#search-bar-input");

    public void searchQuery(String searchQuery) {
        searchBar.setValue(searchQuery).pressEnter();
    }

    public MainPage openMainPage() {
        open("/almaty/");
        return this;
    }

}

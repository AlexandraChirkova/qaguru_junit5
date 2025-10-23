package pages;

import com.codeborne.selenide.SelenideElement;
import components.SortType;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;

public class ListingPage {

    private final SelenideElement searchResulTitle =  $(".search-result__title-key");
    private final SelenideElement sortButton =  $("[class*='select']");
    private static final String CATEGORY_PATH = "/c/smartphones%20and%20gadgets/";

    public ListingPage checkSearchResultTitle(String searchQuery) {
        searchResulTitle.shouldBe(visible).shouldHave(text(searchQuery));
        return this;
    }

    public ListingPage openCategoryPage() {
        open(CATEGORY_PATH);
        webdriver().shouldHave(urlContaining(CATEGORY_PATH));
        return this;
    }

    public ListingPage selectSort() {
        sortButton.shouldBe(visible).click();
        return this;
    }

    public SelenideElement sortButton() {
        return sortButton.shouldBe(visible, enabled);
    }

    public ListingPage selectSortItemByDataId(String dataId) {
        $("[data-id='" + dataId + "']").click();
        return this;
    }

    public ListingPage selectSort(SortType sort) {
        selectSort();
        if ($("[data-id='" + sort.sortParam + "']").exists()) {
            selectSortItemByDataId(sort.sortParam);
        }
        return this;
    }

}

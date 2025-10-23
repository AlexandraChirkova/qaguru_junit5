package tests;

import components.CityPicker;
import components.SortType;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import pages.ListingPage;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;


public class SortTest extends BaseTest {
    ListingPage listingPage = new ListingPage();
    CityPicker cityPicker = new CityPicker();

    @ParameterizedTest(name = "Проверка сортировки {0}")
    @CsvSource({
            "price-asc,sort=price-asc",
            "price-desc,sort=price-desc",
            "rating,sort=rating"
    })
    void testSortByDataId(String dataId, String expectedParam) {
        listingPage.openCategoryPage();
        cityPicker.selectCity("750000000");
        listingPage.selectSort().selectSortItemByDataId(dataId);

        webdriver().shouldHave(urlContaining(expectedParam));
    }

    @ParameterizedTest(name = "Проверка сортировки: {0}")
    @EnumSource(SortType.class)
    void testSortByEnum(SortType sort) {

        listingPage.openCategoryPage();
        cityPicker.selectCity("750000000");
        listingPage.selectSort(sort);

        webdriver().shouldHave(urlContaining("sort=" + sort.sortParam));

        listingPage.sortButton().shouldHave(text(sort.label));

    }

}

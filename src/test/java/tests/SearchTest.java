package tests;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;
import pages.ListingPage;
import pages.MainPage;

import java.util.stream.Stream;


public class SearchTest  extends BaseTest{

    MainPage mainPage = new MainPage();
    ListingPage listingPage = new ListingPage();


    @ValueSource(strings = {"смартфон", "Телевизор", "Планшет"})
    @ParameterizedTest(name = "Поиск товара: {0}")
    void searchProductByName(String searchQuery) {
        mainPage.openMainPage()
                .searchQuery(searchQuery);
        listingPage.checkSearchResultTitle(searchQuery);
    }

    static Stream<Arguments> searchQueries() {
        return Stream.of(
                Arguments.of("iphone", "iPhone"),
                Arguments.of("samsung", "Samsung"),
                Arguments.of("наушники", "Наушники"),
                Arguments.of("телевизор", "Телевизор")
        );
    }

    @ParameterizedTest(name = "Поиск по запросу: {0}")
    @MethodSource("searchQueries")
    void testSearchFunctionality(String query, String expectedWord) {
        mainPage.openMainPage()
                .searchQuery(query);
        listingPage.checkSearchResultTitle(expectedWord);
    }

}

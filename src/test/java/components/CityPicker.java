package components;

import com.codeborne.selenide.SelenideElement;
import java.time.Duration;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class CityPicker {

    private SelenideElement cityDialog = $(".dialog");
    private final SelenideElement curtain = $(".curtain");


    public void selectCity(String cityId) {
        SelenideElement cityElement = $("[data-city-id='" + cityId + "']");
        if (cityElement.exists()) {
            cityElement.shouldBe(visible, enabled).click();

            cityDialog.should(disappear, Duration.ofSeconds(10));

            if (curtain.exists()) {
                curtain.should(disappear, Duration.ofSeconds(10));
            }

            curtain.shouldNotBe(visible, Duration.ofSeconds(5));
        }
    }
}

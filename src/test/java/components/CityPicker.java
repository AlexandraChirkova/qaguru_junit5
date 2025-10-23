package components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.disappear;
import static com.codeborne.selenide.Selenide.$;

public class CityPicker {

    private SelenideElement cityDialog = $(".dialog");

    public void selectCity(String cityId) {

        if ($("[data-city-id='" + cityId + "']").exists()) {
            $("[data-city-id='" + cityId + "']").click();
            cityDialog.should(disappear);
        }
    }
}

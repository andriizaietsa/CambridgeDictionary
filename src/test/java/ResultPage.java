import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class ResultPage {
    private final static SelenideElement searchResult = $(By.xpath("//span[@class='hw dhw'][1]"));
    private final static SelenideElement getSearchResultUkr = $(By.xpath("//span[@class='trans dtrans' ][1]"));

    public String getSearchText(){
        return searchResult.should(exist, Duration.ofSeconds(3)).getText();
    }
    public String getSearchTextUkr(){
        return getSearchResultUkr.should(exist, Duration.ofSeconds(3)).getText();
    }
}

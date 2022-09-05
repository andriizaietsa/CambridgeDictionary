import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class MainPage {
    private final SelenideElement search = $(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[1]/div[1]/div/input"));
    private final SelenideElement searchButton = $(By.xpath("/html/body/div[3]/div[1]/div[2]/div/div/div[2]/form/div[1]/div[1]/span/button[3]"));
    private final SelenideElement changeDictionary = $(By.xpath("//button[@class='bw lb0 lp-10 lpt-5 lpb-5 lmr-10 lml-0 cdo-dataset-selector  lbl']"));
    private final SelenideElement dictionaryLanguage = $(By.xpath("//span[@class='hp hdb' and @data-dictcode='english-ukrainian' ]"));

    private final SelenideElement login = $(By.xpath("//span[@class='tb'][1]"));
    private final SelenideElement titleLoginedUser = $(By.xpath("//span[@class='tb lpl-2 cdo-username']"));
     public MainPage(String url){
         Selenide.open(url);
     }
     public void EnterSearchText(String searchString){
         search.setValue(searchString);
         searchButton.click();
     }
     public void getChangeLanguageMenu(){
         changeDictionary.click();
     }
     public void changeLanguage(){
         dictionaryLanguage.click();
     }
     public void clickLogin(){
         login.click();
     }
     public String getLoginedUserTitle(){
         return titleLoginedUser.should(exist,Duration.ofSeconds(3)).getText();
     }



};

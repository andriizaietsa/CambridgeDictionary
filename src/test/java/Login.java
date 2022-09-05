import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.time.Duration;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;

public class Login {
    private final SelenideElement loginButton = $(By.xpath("//input[@class='gigya-input-submit' and @value='Log in'][1]"));
    private final SelenideElement email = $(By.xpath("//input[@class='gigya-input-text' and @placeholder='Email *']"));
    private final SelenideElement enterPassword = $(By.xpath("//input[@placeholder='Password *' and @name='password']"));
    private final SelenideElement notValidCredentialMessage = $(By.xpath("//div[@class='gigya-error-msg gigya-form-error-msg gigya-error-code-403120 gigya-error-msg-active']"));
    public void clickLoginButton(){
        loginButton.click();
    }
    public void enterLogin(String login){
        email.sendKeys(login);
    }
    public void enterPassword(String Password){
        enterPassword.sendKeys(Password);
    }
    public String getNotValidCredentialMessage(){
        return notValidCredentialMessage.should(exist, Duration.ofSeconds(3)).getText();
    }
}

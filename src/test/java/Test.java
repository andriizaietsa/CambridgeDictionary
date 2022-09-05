import org.junit.Assert;

import static com.codeborne.selenide.Selenide.switchTo;

public class Test extends BaseTest{
    private final static String BASE_URL = "https://dictionary.cambridge.org/";
    private final static String SEARCH_STRING = "cat";
    private final static String LOGIN = "nisoke4130@vasqa.com";
    private final static String PASSWORD = "Pass123!";
    private final static String NOT_VALID_LOGIN = "test login";
    private final static String NOT_VALID_PASSWORD = "test pass";
    MainPage mainPage = new MainPage(BASE_URL);
    ResultPage resultPage = new ResultPage();
    Login login = new Login();

    @org.junit.Test
    public void englishSearchWord(){
        mainPage.EnterSearchText(SEARCH_STRING);
        String searchResultWord = resultPage.getSearchText();
        System.out.println("result is " + searchResultWord);
        Assert.assertTrue(searchResultWord.contains("cat"));
    }
    @org.junit.Test
    public void changeDictionaryLanguage(){
        mainPage.getChangeLanguageMenu();
        mainPage.changeLanguage();
    }
    @org.junit.Test
    public void searchWordInUkrainian(){
        mainPage.getChangeLanguageMenu();
        mainPage.changeLanguage();
        mainPage.EnterSearchText(SEARCH_STRING);
        String searchResultWord = resultPage.getSearchTextUkr();
        Assert.assertTrue(searchResultWord.contains("кіт, кішка"));
    }
    @org.junit.Test
    public void loginWithNotValidData(){
        mainPage.clickLogin();
        switchTo().window("Login");
        login.enterLogin(NOT_VALID_LOGIN);
        login.enterPassword(NOT_VALID_PASSWORD);
        login.clickLoginButton();
        String errorCredentialMessage = login.getNotValidCredentialMessage();
        Assert.assertTrue(errorCredentialMessage.contains("Account temporarily locked out"));
    }
    @org.junit.Test
    public void loginValidData(){
        mainPage.clickLogin();
        switchTo().window("Login");
        login.enterLogin(LOGIN);
        login.enterPassword(PASSWORD);
        login.clickLoginButton();
        switchTo().window(0);
        String loginedUser = mainPage.getLoginedUserTitle();
        Assert.assertTrue(loginedUser.contains("John Dou"));
    }
}

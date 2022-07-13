package Main;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class MainTest {
    private WebDriver webDriver;
    private String url;
    private String login;
    private String password;

    @Before
    public void setup(){
        System.setProperty("webdriver.gecko.driver","C:\\Users\\ddykacz\\Desktop\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\ddykacz\\Desktop\\chromedriver.exe");

        webDriver = new ChromeDriver();
        url = "file:///C:/Users/ddykacz/Desktop/www/index.html";
        //url = "https://www.wp.pl/";
        login = "skdkdkcfkd";
        password = "dlsdlcdkfkoc";
    }

    @Test
    public void shouldHaveTitle(){
        webDriver.get(url);

        String title = webDriver.getTitle();
        Assert.assertTrue(title.equals("TITLE"));
    }
    @Test
    public void shouldLogin(){
        webDriver.get(url);

        //WebElement webElement = webDriver.findElement(By.xpath("//a[@href=\"https://poczta.wp.pl\"]"));
        WebElement webElement = webDriver.findElement(By.partialLinkText("POCZTA"));
        waitForClickablility(webElement,10000).click();

        Assert.assertTrue(webDriver.getPageSource().contains("sswsds"));
    }

    public WebElement waitForClickablility(WebElement element, int timeout) {
        WebDriverWait wait = new WebDriverWait(webDriver, Duration.ofSeconds((timeout)));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    @After
    public void close(){
        webDriver.close();
    }
}

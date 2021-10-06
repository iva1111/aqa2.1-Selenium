package ru.netology;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.List;

import static org.openqa.selenium.By.cssSelector;

public class CardTest {
    private WebDriver driver;

    @BeforeAll
    static void setUpAll() {
        System.setProperty("webdriver.chrome.driver",
                "C:\\Users\\User\\Documents\\Netology\\aqa2.1\\aqa2.1-Selenium\\driver\\chromedriver.exe");
           }

    @BeforeEach
    void setUp() {
        driver = new ChromeDriver();
    }

    @AfterEach
    void tearDown() {
        driver.quit();
        driver = null;
    }

    @Test
    void shouldTestWithCssSelector() {
        driver.get("http://localhost:9999");
        driver.findElement(By.cssSelector("[type=text]")).sendKeys("Иванов Иван");
        driver.findElement(By.cssSelector("[type=tel]")).sendKeys("+79998887766");
        driver.findElement(By.cssSelector(".checkbox")).click();
        driver.findElement(By.cssSelector("button")).click();
        String actualMessage = driver.findElement(By.cssSelector(".alert-success")).getText();
        String expectedMessage = "Ваша заявка успешно отправлена! Наш менеджер свяжется с вами в ближайшее время.";
        Assertions.assertEquals(expectedMessage, actualMessage.strip());
    }


}


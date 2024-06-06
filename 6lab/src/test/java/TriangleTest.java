
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

public class TriangleTest {
    @Test
    public void giveUpThePuzzle() {
        FirefoxOptions options = new FirefoxOptions();
        options.setBinary("C:/Program Files/Mozilla Firefox/firefox.exe");

        System.setProperty("webdriver.gecko.driver", "D:/firefox/geckodriver.exe");
        WebDriver driver = new FirefoxDriver(options = options);
        driver.get("https://playground.learnqa.ru/puzzle/triangle");

        WebElement giveUpButton = driver.findElement(By.xpath("//button[contains(text(), 'Я сдаюсь')]"));

        if (giveUpButton.isDisplayed()) {
            giveUpButton.click();

            WebElement button2 = driver.findElement(By.xpath("//a[contains(text(), 'Ссылка на ответы')]"));
            WebElement button3 = driver.findElement(By.xpath("//button[contains(text(), 'Спрятать ответы')]"));

            if (button2.isDisplayed() && button3.isDisplayed()) {
                System.out.println("Всё зашибись)");
            }
            else{
                System.out.println("Новые элементы не найдены");
            }

        } else {
            System.out.println("Кнопка \"Я сдаюсь\" не найдена");
        }

        driver.quit();
    }
}
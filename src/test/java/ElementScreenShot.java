import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.IOException;

public class ElementScreenShot {
    public static void main(String[] args) throws IOException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.co.il");
        WebElement element = driver.findElement(By.cssSelector("[name='q']"));
        File elementSrc = element.getScreenshotAs(OutputType.FILE);
        FileUtils.copyFileToDirectory(elementSrc, new File("target"));
    }
}
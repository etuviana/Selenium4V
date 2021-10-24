import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ParentFrame {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://the-internet.herokuapp.com/nested_frames");
        JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
        driver.switchTo().frame("frame-top");
        driver.switchTo().frame("frame-left");
        String currentFrame = jsExecutor.executeScript("return self.name").toString();
        System.out.println("Current frame is: " + currentFrame);
        driver.switchTo().parentFrame();
        currentFrame = jsExecutor.executeScript("return self.name").toString();
        System.out.println("Current frame is: " + currentFrame);
    }
}
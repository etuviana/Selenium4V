import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;

public class WindowAndTab {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        driver.get("https://google.com");
        String googleWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://netflix.com");
        String netflixWindowHandle = driver.getWindowHandle();
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://amazon.com");
        driver.switchTo().window(googleWindowHandle);
        WebElement element = driver.findElement(By.cssSelector("input[name='q']"));
        element.sendKeys("Cheese!");
        element.submit();
    }
}
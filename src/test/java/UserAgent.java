
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.emulation.Emulation;

import java.util.Optional;

public class UserAgent {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        driver.get("https://www.whatismybrowser.com/detect/what-is-my-user-agent");
        devTools.send(Emulation.setUserAgentOverride("python 2.7", Optional.empty(), Optional.of("Windows"), Optional.empty()));
        driver.navigate().refresh();
    }
}
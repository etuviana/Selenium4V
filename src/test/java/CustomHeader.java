import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.network.Network;
import org.openqa.selenium.devtools.v95.network.model.Headers;


import java.util.HashMap;
import java.util.Optional;

public class CustomHeader {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        HashMap<String, Object> headers = new HashMap<>();
        headers.put("customHeaderName", "customHeaderValue");
        headers.put("Elad", "Test");
        Headers headersData = new Headers(headers);
        driver.get("https://www.whatismybrowser.com/detect/what-http-headers-is-my-browser-sending");
        devTools.send(Network.setExtraHTTPHeaders(headersData));

    }
}
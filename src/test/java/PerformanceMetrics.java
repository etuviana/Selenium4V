import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v95.performance.Performance;
import org.openqa.selenium.devtools.v95.performance.model.Metric;

import java.util.List;
import java.util.Optional;

import static org.openqa.selenium.devtools.v95.performance.Performance.getMetrics;

public class PerformanceMetrics {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://google.com");
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.send(Performance.enable(Optional.empty()));
        List<Metric> metrics = devTools.send(Performance.getMetrics());
        metrics.forEach(metric-> System.out.println(metric.getName() +" : "+ metric.getValue() ));
    }
}

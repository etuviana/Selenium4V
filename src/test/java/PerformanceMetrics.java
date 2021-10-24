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
        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Performance.enable(Optional.of(Performance.EnableTimeDomain.TIMETICKS)));
        driver.get("https://google.com");
        List<Metric> metrics = devTools.send(getMetrics());
        metrics.forEach(metric -> System.out.println(metric.getName() + ":" + metric.getValue()));
    }
}
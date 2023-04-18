package browserfactory;

import org.junit.After;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class BaseTest {

    public static WebDriver driver;                  //Assigned variable for web driver

    public void openBrowser(String baseUrl) {
        driver = new ChromeDriver();                    //Storing driver in variable
        driver.get(baseUrl);                            //Getting Url
        driver.manage().window().fullscreen();          //Maximise webpage
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  //implicit wait time
    }
@After
    public void closeBrowser(){                           //Close browser
   }
}

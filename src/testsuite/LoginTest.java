package testsuite;

import browserfactory.BaseTest;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class LoginTest extends BaseTest {
    String baseUrl = "http://the-internet.herokuapp.com/login";

    @Before
    public void setUp() {

        openBrowser(baseUrl);
    }
    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {


        // Get element for the username field and enter the username to username field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("tomsmith");

        // Get element for password field and enter the password to password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword!");

        //Find th element for submit button and click on it
        driver.findElement(By.xpath("//button[@class = 'radius' and @type='submit']")).click();
    }
        @Test
        public void verifyUsernameErrorMessage(){
            //storing expected text value in variable
            String expectedMessage = "Secure Area";

            //Finding element to locate text and store in variable
            WebElement actualTextElement = driver.findElement(By.xpath("//h4[@class='subheader']"));

            //Getting the actual text from webpage and storing into variable
            String actualMessage = actualTextElement.getText();

            //Comparing the expected and actual text and print message in console
            Assert.assertEquals("Invalid message", expectedMessage, actualMessage);
        }

        @Test
    public void verifyTheUsernameErrorMessage(){
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

            // Find the username element and enter the username to email field
            WebElement emailField = driver.findElement(By.name("username"));
            emailField.sendKeys("tomsmith1");

            // Find the password element and enter the password to password field
            WebElement password = driver.findElement(By.name("password"));
            password.sendKeys("SuperSecretPassword!");

            // Find the element creating xpath to find submit button and click on it
            driver.findElement(By.xpath("//button[@class = 'radius' and @type='submit']")).click();

            // Storing the value of expected text on webpage
            String expectedMessage = "Your username is invalid!\n" +
                    "×";

            // Finding element for actual text  and storing in variable
            WebElement actualTextElement = driver.findElement(By.xpath("//div[@id ='flash']"));

            // Getting actual text from webpage
            String actualMessage = actualTextElement.getText();

            // Comparing actual and expected message
            Assert.assertEquals("Invalid text",expectedMessage,actualMessage);
        }

    @Test
    public void verifyThePasswordErrorMessage(){
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));

        // Find the element and enter the email to email field
        WebElement emailField = driver.findElement(By.name("username"));
        emailField.sendKeys("tomsmith");

        // Find the element and enter the password to password field
        WebElement password = driver.findElement(By.name("password"));
        password.sendKeys("SuperSecretPassword");

        // Finding element by xpath and click
        driver.findElement(By.xpath("//button[@class = 'radius' and @type='submit']")).click();

        // Expected message on webpage stored in variable
        String expectedMessage = "Your password is invalid!\n" +
                "×";

        //Finding actual text on webpage by xpath and storing in variable
        WebElement actualTextElement = driver.findElement(By.xpath("//div[@id='flash']"));

        //Storing value from webpage in variable
        String actualMessage = actualTextElement.getText();

        //Comparing actual text , expected text and display message
        Assert.assertEquals("Invalid text",expectedMessage,actualMessage);
    }
    }

package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LoginTest extends BaseTest {
    String baseUrl = "https://courses.ultimateqa.com/";


    @Before
    public void setUp() {
        openBrowser(baseUrl);
    }

    @Test
    public void userShouldNavigateToLoginPageSuccessfully() {
        //Locating and clicking on sign in link
        driver.findElement(By.linkText("Sign In")).click();
        //Verifying text
        String expectedMessage = "Welcome Back!";
        WebElement actualMessage = driver.findElement(By.xpath("//h2[@class='page__heading']"));
        String actualMessage1 = actualMessage.getText();
        Assert.assertEquals("Error Message is not Displayed", expectedMessage, actualMessage1);
    }

    @Test
    public void verifyTheErrorMessage() {
        //Locating and clicking on sign in
        driver.findElement(By.linkText("Sign In")).click();
        //Locating and inputting data into email field
        driver.findElement(By.id("user[email]")).sendKeys("prime@gmail.com");
        //Locating and inputting data into password field
        driver.findElement(By.id("user[password]")).sendKeys("12345");
        //clicking on submit button
        driver.findElement(By.xpath("//button[@type='submit']")).click();
        //Verifying expected message
        String expectedMessage = "Invalid email or password.";
        WebElement actualElementMessage = driver.findElement(By.xpath("//li[@class='form-error__list-item']"));
        String actualMessage = actualElementMessage.getText();
        Assert.assertEquals(actualMessage, expectedMessage);


    }

    @After
    public void tearDown() {
        closeBrowser();
    }

}

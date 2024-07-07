package org.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class SeleniumTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        // Ensure you have the ChromeDriver executable in your PATH
        System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
    }

    @Test
    public void testGoogleSearch() throws InterruptedException {
        driver.get("https://aaip.labour.alberta.ca/");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Loop to refresh until redirected to expected URL
        while (!driver.getCurrentUrl().toLowerCase().contains("queue")) {
            // Refresh the page
            driver.navigate().refresh();
        }
        // Step 4: Wait for the redirect to complete

        // Step 5: Capture the redirected URL
        String redirectedUrl = driver.getCurrentUrl();
        System.out.println("Redirected URL: " + redirectedUrl);

        // Step 6: Validate the redirected URL text
        String expectedUrlText = "queue";
        if (redirectedUrl.contains(expectedUrlText)) {
            System.out.println("Validation successful: Redirected URL contains the expected text.");
        } else {
            System.out.println("Validation failed: Redirected URL does not contain the expected text.");
        }

        Thread.sleep(60000000);
    }

    @AfterEach
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}


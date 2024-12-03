package config;

import org.openqa.selenium.WebDriver;

public class CommonMethods {

    private WebDriver driver;

    public void teardown(){
        driver.quit();
    }
}

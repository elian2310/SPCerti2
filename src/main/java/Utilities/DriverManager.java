package Utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.Set;

public class DriverManager {
    private static DriverManager instance;
    public WebDriver driver;

    private DriverManager(){
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }
    public static DriverManager getDriver(){
        if(instance==null){
            instance = new DriverManager();
        }
        return instance;
    }

    public static String[] getWindowHandles(){
        Set<String> setHandles = instance.driver.getWindowHandles();
        String[] res = new String[setHandles.size()];
        setHandles.toArray(res);
        return res;
    }
}

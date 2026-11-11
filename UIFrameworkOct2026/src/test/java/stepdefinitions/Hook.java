package stepdefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigUtil;
import utilities.WebDriverHelpers;

import java.io.IOException;
import java.sql.Time;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hook extends WebDriverHelpers {

    WebDriverHelpers webDriverHelpers;
    ConfigUtil configUtil;

    public Hook(WebDriverHelpers _webDriverHelpers, ConfigUtil _configUtil) {

        this.webDriverHelpers = _webDriverHelpers;
        this.configUtil = _configUtil;
    }

    @Before
    public void initialisation() throws IOException {
        String browserName = configUtil.loadEnvProfileData("browser");
        switch (browserName) {
            case "edge":
                webDriverHelpers.driver = WebDriverManager.edgedriver().create();
                webDriverHelpers.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                webDriverHelpers.driver.manage().window().maximize();
                System.out.println("Use firefox to run your test automation");
                System.out.println("Use internet explorer to run your test automation");
                break;
            case "firefox":

                webDriverHelpers.driver = WebDriverManager.firefoxdriver().create();
                webDriverHelpers.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                webDriverHelpers.driver.manage().window().maximize();
                System.out.println("Use firefox to run your test automation");
                break;
            case "chrome":
                webDriverHelpers.driver = WebDriverManager.chromedriver().create();
                webDriverHelpers.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
                webDriverHelpers.driver.manage().window().maximize();

            default:
                System.out.println("Please select correct browser name");

        }
    }

        @After
        public void shutDown() {
            webDriverHelpers.driver.quit();
        }
    }


//To run API
// @Before("web")
// @After("web")
package Orange_HRM_BDD;

import org.openqa.selenium.MutableCapabilities;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariOptions;

import java.net.MalformedURLException;
import java.net.URL;

public class BrowserSelector extends Utils {
    public static LoadProp props = new LoadProp();
    public static final String USERNAME = props.getProperty("SAUCE_USERNAME");
    public static final String ACCESS_KEY = props.getProperty("SAUCE_ACCESS_KEY");
    public static final String URL = "https://" + USERNAME + ":" + ACCESS_KEY + "@ondemand.eu-central-1.saucelabs.com:443/wd/hub";

    public static final boolean SAUCE_LAB = Boolean.parseBoolean(System.getProperty("Sauce"));
    public static final String browser = System.getProperty("browser");

    public void setUpBrowser() {

        System.out.println(USERNAME);
        System.out.println(ACCESS_KEY);//if sauce lab is true..
        if (SAUCE_LAB) {
            System.out.println("Running in Saucelab with browser : " + browser);

            if (browser.equalsIgnoreCase("safari")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                SafariOptions browserOptions = new SafariOptions();
                browserOptions.setCapability("platformName", "macOS 10.14");
                browserOptions.setCapability("browserVersion", "12.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            } else if (browser.equalsIgnoreCase("chrome")) {

                MutableCapabilities sauceOptions = new MutableCapabilities();

                ChromeOptions browserOptions = new ChromeOptions();
                browserOptions.setExperimentalOption("w3c", true);
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "77.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("firefox")) {

                MutableCapabilities sauceOptions = new MutableCapabilities();

                FirefoxOptions browserOptions = new FirefoxOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "69.0");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("edge")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                EdgeOptions browserOptions = new EdgeOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "18.17763");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }
            } else if (browser.equalsIgnoreCase("IE")) {
                MutableCapabilities sauceOptions = new MutableCapabilities();

                InternetExplorerOptions browserOptions = new InternetExplorerOptions();
                browserOptions.setCapability("platformName", "Windows 10");
                browserOptions.setCapability("browserVersion", "11.285");
                browserOptions.setCapability("sauce:options", sauceOptions);
                try {
                    driver = new RemoteWebDriver(new URL(URL), browserOptions);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                }

            }
        }
        else {
            String browser = System.getProperty("browser");//Storing the value of browser of config file in a string

            if (browser.equalsIgnoreCase("chrome")) {
                System.setProperty("webdriver.chrome.driver", "src\\test\\java\\Resources\\WebBrowser\\chromedriver.exe");//calling the chromedriver path
                ChromeOptions options = new ChromeOptions();
                //options.addArguments("disable-infobars");
                //options.addArguments("--disable-extensions");
                //options.addArguments("--disable-setUpBrowser-side-navigation");
                //options.addArguments("incognito");
                //options.addArguments("--disable-blink-features=BlockCredentialedSubresources");
                //driver=new ChromeDriver(options);
                driver = new ChromeDriver();//creating chrome driver object

            } else if (browser.equalsIgnoreCase("firefox")) {
                System.setProperty("webdriver.gecko.driver", "src\\test\\java\\Resources\\WebBrowser\\geckodriver.exe");
                driver = new FirefoxDriver();
                //DesiredCapabilities ff = DesiredCapabilities.firefox();
                //ff.acceptInsecureCerts();
                //ff.setAcceptInsecureCerts(true);
                //FirefoxOptions options = new FirefoxOptions();
                //options.merge(ff);

            } else if (browser.equalsIgnoreCase("InternetExplorer")) {
                System.setProperty("webdriver.ie.driver", "src\\test\\java\\Resources\\WebBrowser\\IEDriverServer.exe");
                InternetExplorerOptions internetExplorerOptions = new InternetExplorerOptions();
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_SWITCHES, "-private");
                internetExplorerOptions.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
                driver = new InternetExplorerDriver();

            } else {
                System.out.println("Browser name is either empty or typed wrong: " + browser);
            }


        }
    }
}



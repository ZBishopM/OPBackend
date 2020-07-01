package pe.backend.seletest;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.edge.*;

public class seleniumConfig {

	public seleniumConfig(){
		
	}
	
	public static WebDriver getDriver(String navegador) {
		WebDriver driver =null;
		
		//System.setProperty("webdriver.chrome.driver",
		//		"C:\\ProgramasInstalados\\chromedriver.exe");
		//driver = null;
		
		try {
			switch (navegador.toLowerCase()) {
			case "firefox":
				System.setProperty("webdriver.gecko.driver",
						"C:\\ProgramasInstalados\\geckodriver.exe");
				driver = new FirefoxDriver();
				break;
			case "chrome":
				System.setProperty("webdriver.chrome.driver",
						"C:\\ProgramasInstalados\\chromedriver.exe");
				driver = new ChromeDriver();
				break;
			case "internetexplorer":
				System.setProperty("webdriver.edge.driver",
						"C:\\ProgramasInstalados\\msedgedriver.exe");
				driver = new EdgeDriver();
				break;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return driver;
	}
	
}

package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.net.URL;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;

public class Test1LoginFehlschlagSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		//URL remoteWebDriver = new URL("http://192.168.178.132:4444");
		
		//DesiredCapabilities capabilities = new DesiredCapabilities();

		//capabilities.setBrowserName("firefox");
		//capabilities.setPlatform(Platform.LINUX);
		 // Firefox driver:
 		System.setProperty("webdriver.gecko.driver", "/home/headkillah/geckodriver");
		//driver = new FirefoxDriver(capabilities);
		driver = new FirefoxDriver();
		
		//driver = new RemoteWebDriver(remoteWebDriver, capabilities);

		driver.get("https://seleniumkurs.codingsolo.de");
	}

	@After
	public void tearDown() throws Exception {
		System.out.println("Test abgeschlossen- ich räume");
		driver.close();
	}

	@Test
	public void testLogin() {
		System.out.println("Starte Test Login mit Fehlschlag");

		// Arrange

		SeleniumKursLoginPage loginPage = new SeleniumKursLoginPage(driver);
		loginPage.zugangsdatenEingeben("Benutzer", "test");

		// Act
		loginPage.loginButtonAnklicken();

		// Assert

		String fehlerMeldung = loginPage.statusMeldungAuslesen();
		assertTrue(fehlerMeldung.contains("Anmeldung fehlgeschlagen"));
	}

}

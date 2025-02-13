package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxBinary;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;

public class Test1LoginFehlschlagSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		System.setProperty("webdriver.gecko.driver", "/usr/lib/firefox/firefox");
		FirefoxOptions options = new FirefoxOptions();
		options.setBinary(new FirefoxBinary(new File("/usr/bin/firefox")));
		driver = new FirefoxDriver(options);
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

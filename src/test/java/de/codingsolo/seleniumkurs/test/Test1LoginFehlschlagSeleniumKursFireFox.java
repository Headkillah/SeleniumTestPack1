package de.codingsolo.seleniumkurs.test;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import de.codingsolo.seleniumkurs.pages.SeleniumKursLoginPage;

public class Test1LoginFehlschlagSeleniumKursFireFox {

	WebDriver driver;

	@Before
	public void setUp() throws Exception {
		System.out.println("Initialisiere Webdriver");
		File firefoxPathBinary = new File("/lib/firefox/firefox-bin");
		System.setProperty("webdriver.firefox.bin", firefoxPathBinary.getAbsolutePath());
		driver = new FirefoxDriver();
//		System.setProperty("webdriver.gecko.driver", "/usr/bin/firefox");
//		driver = new FirefoxDriver();
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

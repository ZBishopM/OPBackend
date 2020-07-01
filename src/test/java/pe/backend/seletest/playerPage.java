package pe.backend.seletest;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class playerPage {
	private WebDriver webDriver = null;
	private final static int tiempoEspera = 1000;
	
	private By botonMenu = By.id("menuButton");
	private By botonMenuPlayer = By.id("playerSlot");
	private By nuevoEquipo = By.id("newPlayer");
	private By nameTextBox = By.id("nameTextBox");
	private By gameTextBox = By.id("gameTextBox");
	private By teamSelect = By.id("teamSelect"); 
	private By team0 = By.id("team0");
	private By savePlayer = By.id("savePlayer");
	private By editPlayer = By.id("editPlayer");
	private By updatePlayer = By.id("updatePlayer");
	private By searchPlayer = By.id("searchPlayer");
	
	public playerPage()
	{
		
	}
	
	public void inicializarWebDriver(String navegador) {
		this.webDriver = seleniumConfig.getDriver(navegador);
	}
	
	public void ingresarPagina(String urlInicial)throws Exception{
		webDriver.get(urlInicial);
		Thread.sleep(tiempoEspera);
	}
	
	public void ingresarModuloPlayer() throws Exception{
		this.webDriver.findElement(botonMenu).click();
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(botonMenuPlayer).click();
		Thread.sleep(3000);
		this.webDriver.findElement(botonMenuPlayer).sendKeys(Keys.ESCAPE);
		Thread.sleep(2000);
	}
	
	public void ingresarPlayer(String name, String game) throws Exception{
		this.webDriver.findElement(nuevoEquipo).click();
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(nameTextBox).sendKeys(name);
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(gameTextBox).sendKeys(game);
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(teamSelect).click();
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(team0).click();
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(savePlayer).click();
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(savePlayer).sendKeys(Keys.ESCAPE);
		Thread.sleep(tiempoEspera);
	}
	
	public void editarPlayer(String name, String game) throws Exception{
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(editPlayer).click();
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(nameTextBox).clear();
		this.webDriver.findElement(nameTextBox).sendKeys(name);
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(gameTextBox).clear();
		this.webDriver.findElement(gameTextBox).sendKeys(game);
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(updatePlayer).click();
		Thread.sleep(tiempoEspera);
		this.webDriver.findElement(updatePlayer).sendKeys(Keys.ESCAPE);
	}
	
	public String buscarPlayer(String name) throws Exception
	{
		Thread.sleep(1000);
		this.webDriver.findElement(searchPlayer).sendKeys(name);
		Thread.sleep(1000);
		this.webDriver.findElement(editPlayer).click();
		String expectedName = this.webDriver.findElement(nameTextBox).getAttribute("value");
		System.out.println(expectedName);
		return expectedName;
	}
	
	public void cerrarPagina() {
		this.webDriver.quit();
	}
}

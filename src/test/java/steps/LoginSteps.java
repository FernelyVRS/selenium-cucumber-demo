package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LoginSteps {
    WebDriver driver;

    @Before
    public void setup(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    @Given("el usuario está en la página de inicio de sesión")
    public void ir_pagina_inicio_sesion(){
        driver.get("https://www.saucedemo.com/");
    }

    @When("el usuario ingresa el nombre de usuario {string} y la contraseña {string}")
    public void user_add_username_and_password(String username, String password){
        driver.findElement(By.id("user-name")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
    }

    @And("hace Clic en el botón de inicio de sesión")
    public void click_button_login(){
        driver.findElement(By.id("login-button")).click();
    }

    @Then("el usuario debería ver la página de productos")
    public void look_the_product_page(){
        String expectUrl = "https://www.saucedemo.com/inventory.html";
        Assert.assertEquals(expectUrl, driver.getCurrentUrl());
    }

    @Then("el usuario debería ver un mensaje de error {string}")
    public void look_an_error_message(String defaultErrorMessage){
        String errorMessage = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        Assert.assertEquals(defaultErrorMessage, errorMessage);
    }

    @When("el usuario deja el campo de nombre de usuario y contraseña vacíos")
    public void user_not_add_username_and_password(){
        driver.findElement(By.id("user-name")).sendKeys("");
        driver.findElement(By.id("password")).sendKeys("");
    }

    @After
    public void tearDowm(){
        driver.quit();
    }
}

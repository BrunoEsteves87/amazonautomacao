package br.com.amazon.testes;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import io.github.bonigarcia.wdm.WebDriverManager;

public class AmazonTest {

    @Test
    public void searchIphoneOnAmazon() {
        // Configurar o WebDriverManager para gerenciar o ChromeDriver
        WebDriverManager.chromedriver().setup();

        // Configurar opções do Chrome
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--disable-notifications");
        options.addArguments("--disable-extensions");
        options.addArguments("--remote-allow-origins=*");

        // Instanciar o WebDriver com as opções configuradas
        WebDriver driver = new ChromeDriver(options);

        try {
            // Acessar o site da Amazon
            driver.get("https://www.amazon.com.br");

            // Encontrar a barra de busca e digitar "iphone"
            WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
            searchBox.sendKeys("iphone");

            // Encontrar o botão de busca e clicar
            WebElement searchButton = driver.findElement(By.id("nav-search-submit-button"));
            searchButton.click();

            // Adicionar uma espera para visualizar os resultados (opcional)
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            // Fechar o navegador
            driver.quit();
        }
    }
}

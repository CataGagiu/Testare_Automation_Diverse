package demoqa;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
public class CompletareFormular
{
    @Test
    public void completareFormular()
    {
        String fullName = "C G";
        String email = "catagagiu@yahoo.co.uk";
        String adresaCurentaurenta = "Str.E Q, nr 20";
        String adresapermanenta= "Str E Q, nr 30";

        //open page
        String url = "https://demoqa.com/text-box";
        WebDriver driver = new ChromeDriver();
        driver.get(url);
        driver.manage().window().maximize();

        // insert nume

        WebElement fullNameInput = driver.findElement(By.xpath("/html//input[@id='userName']"));
        fullNameInput.sendKeys(fullName);

        //insert adresa de e-mail
        WebElement adresaEmail = driver.findElement(By.xpath("/html//input[@id='userEmail']"));
        adresaEmail.sendKeys(email);

        //insert adresa curenta

        WebElement adresaCurenta = driver.findElement(By.xpath("/html//textarea[@id='currentAddress']"));
        adresaCurenta.sendKeys(adresaCurentaurenta);

        //insert adresa permanenta

        WebElement adresaPermanenta = driver.findElement(By.xpath("/html//textarea[@id='permanentAddress']"));
        adresaPermanenta.sendKeys(adresapermanenta);


        // apasare buton submit
        WebElement submitButton = driver.findElement(By.xpath("/html//button[@id='submit']"));
        submitButton.click();

        //verificare submit


        WebElement campSubmit=driver.findElement(By.xpath("//*[@id=\"output\"]/div"));
        String mesajAfisatSubmit=campSubmit.getText();
        Assert.assertTrue(mesajAfisatSubmit.contains(fullName));
        Assert.assertTrue(mesajAfisatSubmit.contains(email));
        Assert.assertTrue(mesajAfisatSubmit.contains(adresaCurentaurenta));
        Assert.assertTrue(mesajAfisatSubmit.contains(adresapermanenta));

        //close page
        driver.close();
    }

}

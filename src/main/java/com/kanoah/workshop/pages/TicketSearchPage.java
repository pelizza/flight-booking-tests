package com.kanoah.workshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class TicketSearchPage {
    private final WebDriver webDriver;

    public TicketSearchPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public void navegar() {
        webDriver.get("https://workshop-flight-booking.herokuapp.com");
    }

    public void setDe(String cidade) {
        webDriver.findElement(By.id("from")).sendKeys(cidade);
    }

    public void setPara(String cidade) {
        webDriver.findElement(By.id("to")).sendKeys(cidade);
    }

    public void setIda(String data) {
        webDriver.findElement(By.id("departureDate")).sendKeys(data);
    }

    public void setVolta(String data) {
        webDriver.findElement(By.id("returnDate")).sendKeys(data);
    }

    public void setPassageiros(int quantity) {
        new Select(webDriver.findElement(By.id("quantity"))).selectByVisibleText(String.valueOf(quantity));
    }

    public void procurarPassagens() {
        webDriver.findElement(By.tagName("button")).click();
    }

    public boolean temMensagemDeErro(String fieldName) {
        return !webDriver.findElements(By.xpath("//div[label = \"" + fieldName + ":\"]/span")).isEmpty();
    }
}

package com.kanoah.workshop.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketResultsPage {
    private final WebDriver webDriver;

    public TicketResultsPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    public int getQuantidadeDePassagens() {
        return webDriver.findElements(By.tagName("li")).size();
    }

    public String getCustoDaPassagem(int index) {
        return webDriver.findElement(By.xpath("//li[" + index + "]/div[6]/span[2]")).getText();
    }
}

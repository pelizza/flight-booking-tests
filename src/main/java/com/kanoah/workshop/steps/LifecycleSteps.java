package com.kanoah.workshop.steps;

import org.jbehave.core.annotations.AfterStories;
import org.openqa.selenium.WebDriver;

public class LifecycleSteps {

    private WebDriver webDriver;

    public LifecycleSteps(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @AfterStories
    public void afterStories() throws Exception {
        webDriver.quit();
    }
}

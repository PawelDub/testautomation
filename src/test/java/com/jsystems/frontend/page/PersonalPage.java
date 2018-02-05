package com.jsystems.frontend.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PersonalPage extends BasePage {

    WebDriver driver;
    public PersonalPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "p button.button.form-button.is-primary")
    public WebElement profileDetailsSave;

    @FindBy(css = "li a[href=\"/me/notifications\"] span.menu-link-text")
    public WebElement notificationList;

    @FindBy(id = "description")
    public WebElement textArea;
}

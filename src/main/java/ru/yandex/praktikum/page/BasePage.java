package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public BasePage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 5);
    }
    // Кнопка "Заказать" вверху страницы
    private final By upperOrderButton = By.className("Button_Button__ra12g");
    // Кнопка "Заказать" внизу страницы
    private final By lowerOrderButton = By.cssSelector(".Button_Middle__1CSJM");
    // Метод кликает по верхней кнопке "Заказать"
    public void clickUpperOrderButton(){
        driver.findElement(upperOrderButton).click();
    }
    // Метод кликает по нижней кнопке "Заказать"
    public void clickLowwerOrderButton(){
        WebElement element = driver.findElement(lowerOrderButton);
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    // Метод открывает вопрос из раздела "Вопросы о важном"
    public void clickAccordion(int questionId){
        WebElement element = driver.findElement(By.id("accordion__heading-" + questionId));
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
        element.click();
    }
    // Метод проверяет ответ из раздела "Вопросы о важном"
    public String checkAccordionItemPanel(int answerId) {
        driver.findElement(By.id("accordion__panel-" + answerId)).isDisplayed();
        return driver.findElement(By.id("accordion__panel-" + answerId)).getText();
    }
}

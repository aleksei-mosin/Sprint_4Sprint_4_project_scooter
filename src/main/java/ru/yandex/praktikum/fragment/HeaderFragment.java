package ru.yandex.praktikum.fragment;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.praktikum.page.BasePage;

public class HeaderFragment extends BasePage {

    private final By orderStatusButton = By.className("Header_Link__1TAG7");
    private final By orderNumberInput = By.xpath(".//input[@class='Input_Input__1iN_Z Header_Input__xIoUq']");
    private final By searchOrderButton = By.xpath(".//button[@class='Button_Button__ra12g Header_Button__28dPO']");

    public HeaderFragment(WebDriver driver) {
        super(driver);
    }

    public void clickOrderStatusButton(){
        driver.findElement(orderStatusButton).click();
    }
    public void provideOrderNumberInput(String orderNumber){
        wait.until(ExpectedConditions.visibilityOfElementLocated(orderNumberInput)).sendKeys(orderNumber);
    }

    public void clickSearchOrderButton(){
        driver.findElement(searchOrderButton).click();
    }

}

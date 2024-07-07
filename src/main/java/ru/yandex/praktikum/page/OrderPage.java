package ru.yandex.praktikum.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class OrderPage {
    // Поле "Имя"
    private By customerName = By.xpath(".//input[@placeholder='* Имя']");
    // Поле "Фамилия"
    private By customerSurname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Поле "Адресс доставки"
    private By customerAddress = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    // Поле выбора станции метро
    private By metro = By.xpath(".//input[@placeholder='* Станция метро']");
    // Поле  "Телефон"
    private By phoneNumber = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    // Кнопка "Далее"
    private By nextButton = By.cssSelector(".Button_Middle__1CSJM");
    // Поле для указания даты
    private By datePicker = By.xpath(".//input[@placeholder='* Когда привезти самокат']");
    // Поле "Срок аренды"
    private By rental = By.className("Dropdown-placeholder");
    // Поле выпадающего меню с сроком аренды
    private By rentalPeriod = By.xpath("//div[contains(text(), 'семеро суток')]");
    // Чек бокс для выбора черного самока
    private By scooterColourBlack = By.xpath("//label[@for='black']");
    // Чек бокс для выбора серого самоката
    private By scooterColourGrey = By.xpath("//label[@for='grey']");
    // Поле для ввода комментария для курьера
    private By commentForCourier = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    // Кнопка "Заказать"
    private By orderButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");
    // Кнопка подтверждения заказа
    private By yesButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");
    // Статус заказа
    private By orderStatus = By.xpath(".//div[@class ='Order_ModalHeader__3FDaJ' and text()='Заказ оформлен']");
    private WebDriver driver;


    public OrderPage(WebDriver driver){
        this.driver = driver;
    }
    public void enterName(String name){
        driver.findElement(customerName).sendKeys(name);
    }
    public void enterSurname(String surName){
        driver.findElement(customerSurname).sendKeys(surName);
    }
    public void enterAddress(String address){
        driver.findElement(customerAddress).sendKeys(address);
    }
    public void setMetro(String station){
        driver.findElement(metro).click();
        driver.findElement(By.xpath(".//button/div[text() = '" + station + "']")).click();

    }
    public void setPhoneNumber(String number){
        driver.findElement(phoneNumber).sendKeys(number);
    }
    public void clickNextButton(){
        driver.findElement(nextButton).click();
    }
    public void setClientData(String name,String surName,String address, String station, String number){
        enterName(name);
        enterSurname(surName);
        enterAddress(address);
        setMetro(station);
        setPhoneNumber(number);
        clickNextButton();
    }

    public void setDatePicker(String date){
        driver.findElement(datePicker).sendKeys(date);
    }
    public void setScooterColour (String color) {
        if (color.equalsIgnoreCase("black")) {
            driver.findElement(scooterColourBlack).click();
        } else if (color.equalsIgnoreCase("grey")) {
            driver.findElement(scooterColourGrey).click();
        }
    }
    public void setRental(){
        driver.findElement(rental).click();
        driver.findElement(rentalPeriod).click();
    }

    public void setComment(String comment){
        driver.findElement(commentForCourier).sendKeys(comment);
    }
    public void confirmOrder(){
        driver.findElement(orderButton).click();
        driver.findElement(yesButton).click();
    }

    public void setRentalData(String date, String color,String comment){
        setDatePicker(date);
        setScooterColour(color);
        setRental();
        setComment(comment);
        confirmOrder();
    }

    public boolean checkOrderStatus(){
      return   driver.findElement(orderStatus).isDisplayed();
    }

}

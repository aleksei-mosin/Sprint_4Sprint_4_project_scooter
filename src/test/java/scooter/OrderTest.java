package scooter;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.page.BasePage;
import ru.yandex.praktikum.page.OrderPage;

import static org.junit.Assert.assertTrue;

@RunWith(Parameterized.class)
public class OrderTest extends BaseTest {
    private final String name;
    private final String surName;
    private final String address;
    private final String station;
    private final String number;
    private final String date;
    private final String color;
    private final String comment;

    public OrderTest(String name, String surName, String address, String station, String number, String date, String color, String comment) {
        this.name = name;
        this.surName = surName;
        this.address = address;
        this.station = station;
        this.number = number;
        this.date = date;
        this.color = color;
        this.comment = comment;
    }
    @Parameterized.Parameters
    public static Object[][] data() {
        return new Object[][]{
                {"Тест", "Тестов", "Москва, ул. Крапивнинского ", "Варшавская", "888005553555", "01.07.2024", "black", "Тестовый комментарий для курьера"},
                {"Яндекс", "Практикум", "Москва, улица Льва Толстого, дом 16 ", "Парк культуры", "+79993414433", "10.07.2024", "grey", "Тестовый комментарий для курьера"},
        };
    }
    @Test
    public void testUpperOrderButton(){
        BasePage basePage = new BasePage(driver);
        basePage.clickUpperOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setClientData(name,surName,address,station,number);
        orderPage.setRentalData(date,color,comment);
        boolean actualOrderStatus = orderPage.checkOrderStatus();
        assertTrue(actualOrderStatus);
    }

    @Test
    public void testLowerOrderButton(){
        BasePage basePage = new BasePage(driver);
        basePage.clickLowwerOrderButton();
        OrderPage orderPage = new OrderPage(driver);
        orderPage.setClientData(name,surName,address,station,number);
        orderPage.setRentalData(date,color,comment);
        boolean actualOrderStatus = orderPage.checkOrderStatus();
        assertTrue(actualOrderStatus);
    }
}

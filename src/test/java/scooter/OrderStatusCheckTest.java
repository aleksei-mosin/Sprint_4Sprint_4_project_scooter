package scooter;
import org.junit.Test;
import ru.yandex.praktikum.fragment.HeaderFragment;
import ru.yandex.praktikum.page.OrderStatusPage;

import static org.junit.Assert.assertTrue;

public class OrderStatusCheckTest extends BaseTest {

    @Test
    public void checkOrderStatus(){
        String nonValidOrderNumber = "5";


        HeaderFragment headerFragment = new HeaderFragment(driver);
        headerFragment.clickOrderStatusButton();
        headerFragment.provideOrderNumberInput(nonValidOrderNumber);
        headerFragment.clickSearchOrderButton();

        OrderStatusPage orderStatusPage = new OrderStatusPage(driver);

        boolean result = orderStatusPage.isImageDisplayed();
        assertTrue(result);
    }
}

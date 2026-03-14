package praktikum;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

@RunWith(Parameterized.class)
public class BurgerPriceTest extends BurgerBaseTest {

    private final float bunPrice;
    private final float saucePrice;
    private final float fillingPrice;
    private final float expectedPrice;

    public BurgerPriceTest(float bunPrice, float saucePrice, float fillingPrice, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.saucePrice = saucePrice;
        this.fillingPrice = fillingPrice;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "bun={0}, sauce={1}, filling={2}, expected={3}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {100f, 50f, 60f, 310f},
                {200f, 100f, 300f, 800f},
                {50f, 10f, 15f, 125f}
        });
    }

    @Before
    public void prepareTestData() {

        when(mockBun.getPrice()).thenReturn(bunPrice);
        when(mockSauce.getPrice()).thenReturn(saucePrice);
        when(mockFilling.getPrice()).thenReturn(fillingPrice);

        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
    }

    @Test
    public void shouldCalculateBurgerPriceCorrectly() {
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.0001f);
    }
}
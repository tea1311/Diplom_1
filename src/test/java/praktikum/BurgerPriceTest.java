package praktikum;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

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

    @Parameterized.Parameters (name = "Цена булки={0}, Цена соуса={1}, Цена начинки={2}, Ожидаемая цена={3}")
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {100f, 50f, 75f, 325f},
                {200f, 0f, 25f, 425f},
                {50f, 10f, 10f, 120f}
        });
    }

    @Test
    public void shouldCalculateBurgerPriceCorrectly() {
        burger.setBuns(bunWithPrice(bunPrice));
        burger.addIngredient(ingredientWithPrice(saucePrice));
        burger.addIngredient(ingredientWithPrice(fillingPrice));

        assertEquals(expectedPrice, burger.getPrice(), 0.0001f);
    }
}

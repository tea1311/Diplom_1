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
    private final float ingredientPrice1;
    private final float ingredientPrice2;
    private final float expectedPrice;

    public BurgerPriceTest(float bunPrice, float ingredientPrice1, float ingredientPrice2, float expectedPrice) {
        this.bunPrice = bunPrice;
        this.ingredientPrice1 = ingredientPrice1;
        this.ingredientPrice2 = ingredientPrice2;
        this.expectedPrice = expectedPrice;
    }

    @Parameterized.Parameters(name = "bun={0}, ingredient1={1}, ingredient2={2}, expected={3}")
    public static Collection<Object[]> getData() {
        return Arrays.asList(new Object[][]{
                {100f, 50f, 60f, 310f},
                {200f, 100f, 300f, 800f},
                {50f, 10f, 15f, 125f}
        });
    }

    @Before
    public void prepareTestData() {

        when(bun.getPrice()).thenReturn(bunPrice);
        when(ingredient1.getPrice()).thenReturn(ingredientPrice1);
        when(ingredient2.getPrice()).thenReturn(ingredientPrice2);

        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
    }

    @Test
    public void shouldCalculateBurgerPriceCorrectly() {
        float actualPrice = burger.getPrice();

        assertEquals(expectedPrice, actualPrice, 0.0001f);
    }
}
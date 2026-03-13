package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

public class BurgerTest extends BurgerBaseTest {

    @Test
    public void shouldSetBunInBurger() {
        burger.setBuns(bun);

        assertSame(bun, burger.bun);
    }

    @Test
    public void shouldIncreaseIngredientsSizeAfterAdd() {
        burger.addIngredient(ingredient1);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldAddCorrectIngredientToList() {
        burger.addIngredient(ingredient1);

        assertSame(ingredient1, burger.ingredients.get(0));
    }

    @Test
    public void shouldDecreaseIngredientsSizeAfterRemove() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldShiftIngredientAfterRemove() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        burger.removeIngredient(0);

        assertSame(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void shouldMoveFirstIngredientToLastPosition() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);

        assertSame(ingredient1, burger.ingredients.get(2));
    }

    @Test
    public void shouldMoveSecondIngredientToFirstPosition() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);

        assertSame(ingredient2, burger.ingredients.get(0));
    }

    @Test
    public void shouldMoveThirdIngredientToSecondPosition() {
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);
        burger.addIngredient(ingredient3);

        burger.moveIngredient(0, 2);

        assertSame(ingredient3, burger.ingredients.get(1));
    }

    @Test
    public void shouldReturnDoubleBunPriceWhenBurgerWithoutIngredients() {
        burger.setBuns(bun);
        when(bun.getPrice()).thenReturn(100f);

        float actualPrice = burger.getPrice();

        assertEquals(200f, actualPrice, 0.0001f);
    }

    @Test
    public void shouldReturnCorrectReceipt() {
        burger.setBuns(bun);
        burger.addIngredient(ingredient1);
        burger.addIngredient(ingredient2);

        when(bun.getName()).thenReturn("black bun");
        when(bun.getPrice()).thenReturn(100f);

        when(ingredient1.getType()).thenReturn(IngredientType.SAUCE);
        when(ingredient1.getName()).thenReturn("hot sauce");
        when(ingredient1.getPrice()).thenReturn(50f);

        when(ingredient2.getType()).thenReturn(IngredientType.FILLING);
        when(ingredient2.getName()).thenReturn("cutlet");
        when(ingredient2.getPrice()).thenReturn(70f);

        String expectedReceipt = String.format(
                "(==== %s ====)%n" +
                        "= %s %s =%n" +
                        "= %s %s =%n" +
                        "(==== %s ====)%n" +
                        "%nPrice: %f%n",
                "black bun",
                "sauce", "hot sauce",
                "filling", "cutlet",
                "black bun",
                320f
        );

        String actualReceipt = burger.getReceipt();

        assertEquals(expectedReceipt, actualReceipt);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenRemovingIngredientFromEmptyBurger() {
        burger.removeIngredient(0);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void shouldThrowExceptionWhenMovingIngredientWithInvalidIndex() {
        burger.addIngredient(ingredient1);

        burger.moveIngredient(5, 0);
    }
}
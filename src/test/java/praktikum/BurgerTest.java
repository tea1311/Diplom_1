package praktikum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.mockito.Mockito.when;

public class BurgerTest extends BurgerBaseTest {

    @Test
    public void shouldSetBunInBurger() {
        burger.setBuns(mockBun);

        assertSame(mockBun, burger.bun);
    }

    @Test
    public void shouldIncreaseIngredientsSizeAfterAdd() {
        burger.addIngredient(mockSauce);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldAddCorrectIngredientToList() {
        burger.addIngredient(mockSauce);

        assertSame(mockSauce, burger.ingredients.get(0));
    }

    @Test
    public void shouldDecreaseIngredientsSizeAfterRemove() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.removeIngredient(0);

        assertEquals(1, burger.ingredients.size());
    }

    @Test
    public void shouldShiftIngredientAfterRemove() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        burger.removeIngredient(0);

        assertSame(mockFilling, burger.ingredients.get(0));
    }

    @Test
    public void shouldMoveFirstIngredientToLastPosition() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.addIngredient(mockExtraIngredient);

        burger.moveIngredient(0, 2);

        assertSame(mockSauce, burger.ingredients.get(2));
    }

    @Test
    public void shouldMoveSecondIngredientToFirstPosition() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.addIngredient(mockExtraIngredient);

        burger.moveIngredient(0, 2);

        assertSame(mockFilling, burger.ingredients.get(0));
    }

    @Test
    public void shouldMoveThirdIngredientToSecondPosition() {
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);
        burger.addIngredient(mockExtraIngredient);

        burger.moveIngredient(0, 2);

        assertSame(mockExtraIngredient, burger.ingredients.get(1));
    }

    @Test
    public void shouldReturnDoubleBunPriceWhenBurgerWithoutIngredients() {
        burger.setBuns(mockBun);
        when(mockBun.getPrice()).thenReturn(100f);

        float actualPrice = burger.getPrice();

        assertEquals(200f, actualPrice, 0.0001f);
    }

    @Test
    public void shouldReturnCorrectReceipt() {
        burger.setBuns(mockBun);
        burger.addIngredient(mockSauce);
        burger.addIngredient(mockFilling);

        when(mockBun.getName()).thenReturn("black bun");
        when(mockBun.getPrice()).thenReturn(100f);

        when(mockSauce.getType()).thenReturn(IngredientType.SAUCE);
        when(mockSauce.getName()).thenReturn("hot sauce");
        when(mockSauce.getPrice()).thenReturn(50f);

        when(mockFilling.getType()).thenReturn(IngredientType.FILLING);
        when(mockFilling.getName()).thenReturn("cutlet");
        when(mockFilling.getPrice()).thenReturn(70f);

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
        burger.addIngredient(mockSauce);

        burger.moveIngredient(5, 0);
    }
}
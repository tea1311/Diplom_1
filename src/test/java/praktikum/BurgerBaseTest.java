package praktikum;

import org.junit.Before;

import static org.mockito.Mockito.mock;

public abstract class BurgerBaseTest {

    protected Burger burger;
    protected Bun mockBun;
    protected Ingredient mockSauce;
    protected Ingredient mockFilling;
    protected Ingredient mockExtraIngredient;

    @Before
    public void setUp() {
        burger = new Burger();
        mockBun = mock(Bun.class);
        mockSauce = mock(Ingredient.class);
        mockFilling = mock(Ingredient.class);
        mockExtraIngredient = mock(Ingredient.class);
    }
}
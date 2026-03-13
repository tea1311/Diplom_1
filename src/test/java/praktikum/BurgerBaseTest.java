package praktikum;

import org.junit.Before;

import static org.mockito.Mockito.mock;

public abstract class BurgerBaseTest {

    protected Burger burger;
    protected Bun bun;
    protected Ingredient ingredient1;
    protected Ingredient ingredient2;
    protected Ingredient ingredient3;

    @Before
    public void setUp() {
        burger = new Burger();
        bun = mock(Bun.class);
        ingredient1 = mock(Ingredient.class);
        ingredient2 = mock(Ingredient.class);
        ingredient3 = mock(Ingredient.class);
    }
}
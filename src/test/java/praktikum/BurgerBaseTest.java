package praktikum;

import org.junit.Before;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public abstract class BurgerBaseTest {

    protected Burger burger;

    @Before
    public void setUpBurger() {
        burger = new Burger();
    }

    protected Bun bunWithPrice(float price) {
        Bun bun = mock(Bun.class);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    protected Bun bunWithNameAndPrice(String name, float price) {
        Bun bun = mock(Bun.class);
        when(bun.getName()).thenReturn(name);
        when(bun.getPrice()).thenReturn(price);
        return bun;
    }

    protected Ingredient ingredientWithPrice(float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }

    protected Ingredient ingredientWithTypeNamePrice(IngredientType type, String name, float price) {
        Ingredient ingredient = mock(Ingredient.class);
        when(ingredient.getType()).thenReturn(type);
        when(ingredient.getName()).thenReturn(name);
        when(ingredient.getPrice()).thenReturn(price);
        return ingredient;
    }
}
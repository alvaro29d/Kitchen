import java.util.Arrays;
import java.util.List;

import org.junit.*;
import static org.junit.Assert.*;

public class DishTest {

  @Rule
  public DatabaseRule database = new DatabaseRule();

  @Test
  public void equals_returnsTrueIfSameName() {
    Dish firstDish = new Dish("Cheeseburger");
    firstDish.save();
    Dish secondDish = new Dish("Cheeseburger");
    secondDish.save();
    assertTrue(firstDish.equals(secondDish));
  }

  @Test
  public void all_emptyAtFirst() {
    assertEquals(Dish.all().size(), 0);
  }

  @Test
  public void dish_instantiatesNameAndFindsItInListOfDishes() {
    Dish dish = new Dish("Cheeseburger");
    dish.save();
    assertEquals("Cheeseburger", Dish.find(dish.getId()).getName());
  }

  @Test
  public void delete_deletesADish() {
    Dish dish = new Dish("Cheeseburger");
    dish.save();
    Dish anotherDish = new Dish("Turkey Burger");
    anotherDish.save();
    dish.delete();
    assertEquals(1, Dish.all().size());
  }

  @Test
  public void update_updateWorksProperly() {
    Dish dish = new Dish("Cheeseburger");
    dish.save();
    dish.update("Turkey Burger");
    assertEquals(dish.getName(), "Turkey Burger");
  }

}

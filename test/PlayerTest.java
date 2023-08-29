import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import team.Player;
import team.Position;

/**
 * This is a junit test to test the class Player.
 */
public class PlayerTest {
  private Player youth1;

  /**
   * Sets up a player object for later tests.
   */
  @Before
  public void setUp() {
    youth1 = new Player("adam", "black", LocalDate.of(2014, 11, 2),
            Position.Midfielder, 5);
  }

  /**
   * Tests the illegal birthday of a player object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalBirthday() {
    youth1 = new Player("adam", "black", LocalDate.of(2011, 11, 2),
            Position.Midfielder, 5);
  }

  /**
   * Tests the illegal skill level(above five) of a player object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalSkillLevelAboveFive() {
    youth1 = new Player("adam", "black", LocalDate.of(2015, 11, 2),
            Position.Midfielder, 6);
  }

  /**
   * Tests the illegal skill level(below zero) of a player object.
   */
  @Test(expected = IllegalArgumentException.class)
  public void testIllegalSkillLevelBelowOne() {
    youth1 = new Player("adam", "black", LocalDate.of(2015, 11, 2),
            Position.Midfielder, 0);
  }

  /**
   * Tests getFirstName() in Player class.
   */
  @Test
  public void testGetFirstName() {
    assertEquals("Adam", youth1.getFirstName());
  }

  /**
   * Tests getLastName() in Player class.
   */
  @Test
  public void testGetLastName() {
    assertEquals("Black", youth1.getLastName());
  }

  /**
   * Tests getLastName() in Player class.
   */
  @Test
  public void testGetName() {
    assertEquals("Adam Black", youth1.getName());
  }

  /**
   * Tests getBirthday() in Player class.
   */
  @Test
  public void testGetBirthday() {
    LocalDate date = LocalDate.of(2014, 11, 2);
    assertEquals(date, youth1.getBirthday());
  }

  /**
   * Tests getPreferredPosition() in Player class.
   */
  @Test
  public void testGetPreferredPosition() {
    assertEquals(Position.Midfielder, youth1.getPreferredPosition());
  }

  /**
   * Tests getPreferredPosition() in Player class.
   */
  @Test
  public void testGetSkillLevel() {
    assertEquals(5, youth1.getSkillLevel());
  }

  /**
   * Tests compareTo() in Player class when youth1 comes before youth2 in lexicographic order.
   */
  @Test
  public void testCompareToOne() {
    //youth1 last name: "black"
    Player youth2 = new Player("josh", "white", LocalDate.of(2015, 10, 2),
            Position.Goalie, 1);
    assertTrue(youth1.compareTo(youth2) < 0);
  }

  /**
   * Tests compareTo() in Player class when youth2 comes before youth1 in lexicographic order.
   */
  @Test
  public void testCompareToTwo() {
    //youth1 last name: "black"
    Player youth2 = new Player("josh", "Apple", LocalDate.of(2015, 10, 2),
            Position.Goalie, 1);
    assertTrue(youth1.compareTo(youth2) > 0);
  }

}

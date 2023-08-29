package team;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * This is a class Player, representing a player in a youth soccer team. A player object has a
 * first name, last name, birthday, preferred position, and skill level.
 */
public class Player implements Comparable<Player> {
  private String firstName;
  private String lastName;
  private LocalDate birthday;
  private Position preferredPosition;
  private int skillLevel;

  /**
   * This is the constructor of class Player.
   *
   * @param firstName the first name of a player
   * @param lastName the last name of a player
   * @param birthday the birthday of a player
   * @param preferredPosition the position a player wish to be assigned to in the soccer team
   * @param skillLevel the skill level of a player
   */
  public Player(String firstName, String lastName, LocalDate birthday, Position preferredPosition,
                int skillLevel) {
    this.firstName = firstName.toLowerCase();
    this.lastName = lastName.toLowerCase();
    this.birthday = birthday;
    if (Period.between(this.birthday, LocalDate.now()).getYears() >= 10) {
      throw new IllegalArgumentException("Player is not under ten years of age and cannot "
              + "be added.");
    }
//    if (Period.between(this.birthday, LocalDate.now()).getYears() <= 0) {
//      throw new IllegalArgumentException("Birthday can be in the future.");
//    }
    this.preferredPosition = preferredPosition;
    if (skillLevel < 1 || skillLevel > 5) {
      throw new IllegalArgumentException("Skill level should be between 1 and 5(inclusive).");
    }
    this.skillLevel = skillLevel;
  }

  /**
   * Gets the first name of a player.
   *
   * @return a string of the first name of a player
   */
  public String getFirstName() {
    return this.firstName.substring(0, 1).toUpperCase() + this.firstName.substring(1);
  }

  /**
   * Gets the last name of a player.
   *
   * @return a string of the last name of a player
   */
  public String getLastName() {
    return this.lastName.substring(0, 1).toUpperCase() + this.lastName.substring(1);
  }

  /**
   * Gets the name of a player.
   *
   * @return a string of the name of a player
   */
  public String getName() {
    return getFirstName() + " " + getLastName();
  }

  /**
   * Gets the birthday of a player.
   *
   * @return the birthday of a player
   */
  public LocalDate getBirthday() {
    return this.birthday;
  }

  /**
   * Gets the preferred position of a player.
   *
   * @return the preferred position of a player
   */
  public Position getPreferredPosition() {
    return this.preferredPosition;
  }

  /**
   * Gets the skill level of a player.
   *
   * @return the skill level of a player
   */
  public int getSkillLevel() {
    return this.skillLevel;
  }

  @Override
  public int compareTo(Player player) {
    return this.getLastName().compareTo(player.getLastName());
  }

  @Override
  public boolean equals(Object other) {
    if (other == this) {
      return true;
    }
    if (!(other instanceof Player)) {
      return false;
    }
    Player player2 = (Player) other;
    return Objects.equals(this.getName(), player2.getName())
        && Objects.equals(this.getBirthday(), player2.getBirthday())
        && Objects.equals(this.getPreferredPosition(), player2.getPreferredPosition())
        && Objects.equals(this.getSkillLevel(), player2.getSkillLevel());
  }

  @Override
  public int hashCode() {
    final int p1 = 2; // arbitrary prime number
    final int p2 = 3;
    final int p3 = 5;
    final int p4 = 7;

    int result = 1;
    result = p1 * result + ((this.getName() == null) ? 0 : this.getName().hashCode());
    result = p2 * result + ((this.getBirthday() == null) ? 0 : this.getBirthday().hashCode());
    result = p3 * result + ((this.getPreferredPosition() == null) ? 0 :
        this.getPreferredPosition().hashCode());
    result = p4 * result + this.getSkillLevel();
    return result;
  }
}

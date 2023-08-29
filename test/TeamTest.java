import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import com.sun.jdi.request.DuplicateRequestException;
import java.time.LocalDate;
import org.junit.Before;
import org.junit.Test;
import team.Player;
import team.Position;
import team.Team;
import team.TeamModel;

/**
 * This is a junit test to test the class Team.
 */
public class TeamTest {
  private Team team1;
  private Player youth1;
  private Player youth2;
  private Player youth3;
  private Player youth4;
  private Player youth5;
  private Player youth6;
  private Player youth7;
  private Player youth8;
  private Player youth9;
  private Player youth10;
  private Player youth11;
  private Player youth12;
  private Player youth13;
  private Player youth14;
  private Player youth15;
  private Player youth16;
  private Player youth17;
  private Player youth18;
  private Player youth19;
  private Player youth20;
  private Player youth21;

  /**
   * Sets up TeamModel and Player objects for later tests.
   */
  @Before
  public void setUp() {
    team1 = new TeamModel();
    youth1 = new Player("adam", "black", LocalDate.of(2014, 11, 2),
            Position.Midfielder, 5);
    youth2 = new Player("jenny", "paris", LocalDate.of(2014, 9, 15),
            Position.Goalie, 4);
    youth3 = new Player("oliver", "white", LocalDate.of(2014, 11, 15),
            Position.Forward, 4);
    youth4 = new Player("phoebe", "smith", LocalDate.of(2014, 10, 20),
            Position.Forward, 2);
    youth5 = new Player("daisy", "barker", LocalDate.of(2014, 8, 10),
            Position.Forward, 2);
    youth6 = new Player("otto", "cook", LocalDate.of(2014, 6, 12),
            Position.Forward, 2);
    youth7 = new Player("jenn", "lee", LocalDate.of(2014, 7, 14),
            Position.Defender, 5);
    youth8 = new Player("grace", "nelson", LocalDate.of(2014, 3, 17),
            Position.Defender, 4);
    youth9 = new Player("maeve", "ross", LocalDate.of(2014, 2, 15),
            Position.Defender, 3);
    youth10 = new Player("alice", "bishop", LocalDate.of(2014, 1, 25),
            Position.Goalie, 3);
    youth11 = new Player("ivy", "smith", LocalDate.of(2016, 7, 21),
            Position.Goalie, 4);
    youth12 = new Player("saoirse", "brown", LocalDate.of(2016, 4, 10),
            Position.Goalie, 3);
    youth13 = new Player("mabel", "jones", LocalDate.of(2016, 3, 19),
            Position.Goalie, 2);
    youth14 = new Player("lyra", "miller", LocalDate.of(2016, 2, 14),
            Position.Goalie, 1);
    youth15 = new Player("freya", "law", LocalDate.of(2016, 1, 12),
            Position.Midfielder, 5);
    youth16 = new Player("arlo", "Davis", LocalDate.of(2016, 8, 13),
            Position.Midfielder, 4);
    youth17 = new Player("elio", "williams", LocalDate.of(2016, 5, 22),
            Position.Midfielder, 3);
    youth18 = new Player("kai", "hunter", LocalDate.of(2016, 9, 23),
            Position.Midfielder, 2);
    youth19 = new Player("cyrus", "lee", LocalDate.of(2016, 10, 24),
            Position.Midfielder, 1);
    youth20 = new Player("aya", "sauerbrey", LocalDate.of(2016, 11, 29),
            Position.Forward, 4);
    youth21 = new Player("may", "wisener", LocalDate.of(2016, 12, 30),
            Position.Forward, 3);
  }

  /**
   * Tests team is not successfully created when one player is added.
   */
  @Test(expected = IllegalStateException.class)
  public void testTeamNotCreatedWithOnePlayer() {
    team1.addPlayer(youth1);
    team1.createTeam();
  }

  /**
   * Tests team is not successfully created when nine players are added.
   */
  @Test(expected = IllegalStateException.class)
  public void testTeamNotCreatedWithNinePlayers() {
    team1.addPlayer(youth1);
    team1.addPlayer(youth2);
    team1.addPlayer(youth3);
    team1.addPlayer(youth4);
    team1.addPlayer(youth5);
    team1.addPlayer(youth6);
    team1.addPlayer(youth7);
    team1.addPlayer(youth8);
    team1.addPlayer(youth9);
    team1.createTeam();
  }

  /**
   * Tests the same player cannot be added twice.
   */
  @Test(expected = DuplicateRequestException.class)
  public void testAddPlayer() {
    team1.addPlayer(youth1);
    team1.addPlayer(youth1);
    team1.createTeam();
  }

  /**
   * Tests a team can be created with ten candidates.
   */
  @Test
  public void testCreateTeamWithTenPlayers() {
    team1.addPlayer(youth1);
    team1.addPlayer(youth2);
    team1.addPlayer(youth3);
    team1.addPlayer(youth4);
    team1.addPlayer(youth5);
    team1.addPlayer(youth6);
    team1.addPlayer(youth7);
    team1.addPlayer(youth8);
    team1.addPlayer(youth9);
    team1.addPlayer(youth10);
    team1.createTeam();
    System.out.println(team1.getLineup());
    assertEquals(10, team1.getTeamSize());
  }

  /**
   * Tests the getLineup() method.
   */
  @Test
  public void testLineupStringOrder() {
    team1.addPlayer(youth1);
    team1.addPlayer(youth2);
    team1.addPlayer(youth3);
    team1.addPlayer(youth4);
    team1.addPlayer(youth5);
    team1.addPlayer(youth6);
    team1.addPlayer(youth7);
    team1.addPlayer(youth8);
    team1.addPlayer(youth9);
    team1.addPlayer(youth10);
    team1.createTeam();
    Position[] positions = {Position.Goalie, Position.Defender, Position.Defender,
      Position.Midfielder, Position.Midfielder, Position.Midfielder,
      Position.Forward};
    String str = team1.getLineup();
    String[] lines = str.split("\n");
    boolean result = true;
    for (int i = 0; i < positions.length; i++) {
      if (!lines[i].contains(positions[i].toString())) {
        result = false;
      }
    }
    assertTrue(result);
  }

  /**
   * Tests the getPlayers() method.
   */
  @Test
  public void testTeamPlayersStringOrder() {
    team1.addPlayer(youth1);
    team1.addPlayer(youth2);
    team1.addPlayer(youth3);
    team1.addPlayer(youth4);
    team1.addPlayer(youth5);
    team1.addPlayer(youth6);
    team1.addPlayer(youth7);
    team1.addPlayer(youth8);
    team1.addPlayer(youth9);
    team1.addPlayer(youth10);
    team1.createTeam();
    String[] lastNames = {"Barker", "Bishop", "Black", "Cook", "Lee", "Nelson",
        "Paris", "Ross", "Smith", "White"};
    String str = team1.getPlayers();
    System.out.println(str);
    String[] lines = str.split("\n");
    boolean result = true;
    for (int i = 0; i < lastNames.length; i++) {
      if (!lines[i].contains(lastNames[i].toString())) {
        result = false;
      }
    }
    assertTrue(result);
  }

  /**
   * Tests a team can be created with 21 players. One player will not be included in the team.
   */
  @Test
  public void testCreateTeamWithTwentyOnePlayers() {
    team1.addPlayer(youth1);
    team1.addPlayer(youth2);
    team1.addPlayer(youth3);
    team1.addPlayer(youth4);
    team1.addPlayer(youth5);
    team1.addPlayer(youth6);
    team1.addPlayer(youth7);
    team1.addPlayer(youth8);
    team1.addPlayer(youth9);
    team1.addPlayer(youth10);
    team1.addPlayer(youth11);
    team1.addPlayer(youth12);
    team1.addPlayer(youth13);
    team1.addPlayer(youth14);
    team1.addPlayer(youth15);
    team1.addPlayer(youth16);
    team1.addPlayer(youth17);
    team1.addPlayer(youth18);
    team1.addPlayer(youth19);
    team1.addPlayer(youth20);
    team1.addPlayer(youth21);
    team1.createTeam();
    assertEquals(20, team1.getTeamSize());
  }
}

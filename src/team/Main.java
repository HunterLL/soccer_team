package team;

import java.time.LocalDate;

/**
 * This is the driver class to create a youth soccer team.
 */
public class Main {

  /**
   * The driver method to help create a youth soccer team.
   *
   * @param args an array of strings containing the filename to be processed
   */
  public static void main(String[] args) {
    Player youth1 = new Player("adam", "black", LocalDate.of(2014, 11, 2),
            Position.Midfielder, 5);
    Player youth2 = new Player("jenny", "paris", LocalDate.of(2014, 9, 15),
            Position.Goalie, 4);
    Player youth3 = new Player("oliver", "white", LocalDate.of(2014, 11, 15),
            Position.Forward, 4);
    Player youth4 = new Player("phoebe", "smith", LocalDate.of(2014, 10, 20),
            Position.Forward, 3);
    Player youth5 = new Player("daisy", "barker", LocalDate.of(2014, 8, 10),
            Position.Forward, 2);
    Player youth6 = new Player("otto", "cook", LocalDate.of(2014, 6, 12),
            Position.Forward, 2);
    Player youth7 = new Player("jenny", "lee", LocalDate.of(2014, 7, 14),
            Position.Defender, 5);
    Player youth8 = new Player("grace", "nelson", LocalDate.of(2014, 3, 17),
            Position.Defender, 4);
    Player youth9 = new Player("maeve", "ross", LocalDate.of(2014, 2, 15),
            Position.Defender, 3);
    Player youth10 = new Player("alice", "bishop", LocalDate.of(2014, 1, 25),
            Position.Goalie, 3);
    Team newTeam = new TeamModel();
    newTeam.addPlayer(youth1);
    newTeam.addPlayer(youth2);
    newTeam.addPlayer(youth3);
    newTeam.addPlayer(youth4);
    newTeam.addPlayer(youth5);
    newTeam.addPlayer(youth6);
    newTeam.addPlayer(youth7);
    newTeam.addPlayer(youth8);
    newTeam.addPlayer(youth9);
    newTeam.addPlayer(youth10);
    newTeam.createTeam();
    System.out.println(newTeam.getLineup());
    System.out.println(newTeam.getPlayers());
  }
}
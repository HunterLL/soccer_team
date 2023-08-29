package team;

import com.sun.jdi.request.DuplicateRequestException;

/**
 * A soccer team is created by adding players under ten years old one by one. When a team is
 * created, every team member will be assigned a jersey number. A starting lineup will be
 * created by selecting the most skillful members in the team. Coaches can learn the team member
 * information and lineup information.
 */
public interface Team {

  /**
   * Add a player to the candidate list.
   *
   * @param player a youth soccer player
   * @throws DuplicateRequestException if the same player be added again
   */
  void addPlayer(Player player) throws DuplicateRequestException;

  /**
   * Create a soccer team by assigning every team member a jersey number and
   * selecting a starting lineup.
   *
   * @throws IllegalStateException if candidates are fewer than 10
   */
  void createTeam() throws IllegalStateException;

  /**
   * Get a string with a list of all the players in the team. In the string, the following
   * information is provided for every player: first name, last name, jersey number. The
   * list is sorted in alphabetical order (last name).
   *
   * @return a string with a list of all the players in the team
   */
  String getPlayers();

  /**
   * Get a string with a list of the starting lineup. The following information is provided
   * for every player: first name, last name, jersey number, and position. The list is sorted
   * by position (goalie, defender, midfielder, forward). Players with the same position
   * is ordered alphabetically.
   *
   * @return a string with a list of the starting lineup
   */
  String getLineup();

  /**
   * Return the number of team member in the soccer team.
   *
   * @return the number of team member in the soccer team.
   */
  public int getTeamSize();

  /**
   * Return the number of candidates added before creating the soccer team.
   *
   * @return the number of candidates added
   */
  public int getCandidateSize();
}

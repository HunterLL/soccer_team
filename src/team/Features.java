package team;

/**
 * Interface for the team controller.
 */
public interface Features {
  /**
   * Provide view with all the callbacks.
   * @param v the view.
   */
  public void setView(View v);

  /**
   * Exit the program.
   */
  void exitProgram();

  /**
   * Receive user input of a Player from the view and use it to make model
   * call addPlayer() method to add a player into the candidate list.
   */
  public void addPlayer();

  /**
   * Call model's createTeam() method to create a team, assign each a jersey number.
   */
  public void createTeam();

  /**
   * Retrieves the string of all the players in the team from the model and passes it
   * to the view to display.
   */
  public void displayPlayers();

  /**
   * Retrieves the lineup string from the model and passes it to the view to display.
   */
  public void displayLineup();

}

package team;

import java.time.LocalDate;

/**
 * The View interface represents the user interface of the application.
 */
public interface View {
  /**
   * Add the Controller to the view.
   *
   * @param features the implementation of our controller.
   */
  void addFeatures(Features features);

  /**
   * Gets the result of first name selected by user in firstNameField.
   *
   * @return the result of first name(a string)
   */
  public String getFirstNameString();

  /**
   * Gets the result of last name selected by user in firstNameField.
   *
   * @return the result of last name(a string)
   */
  public String getLastNameString();

  /**
   * Gets the result of position selected by user in positionComboBox.
   *
   * @return the result of position
   */
  public Position getPosition();

  /**
   * Gets the result of birthday selected by user in DateChooser.
   *
   * @return the result of birthday
   */
  public LocalDate getBirthday();

  /**
   * Gets the result of skill level selected by user in skillLevelComboBox.
   *
   * @return the result of skill level
   */
  public int getSkillLevel();

  /**
   * Make "view team" button available to users to click on after a team is created.
   */
  public void setGetPlayersButton();

  /**
   * Make "view lineup" button available to users to click on after a team is created.
   */
  public void setGetLineupButton();

  /**
   * Make add and create buttons unable to be clicked on.
   */
  public void disableAddAndCreateButton();

  /**
   * Display the number of players added on the user interface window.
   *
   * @param numPlayers the number of players added
   */
  public void displayNumPlayers(int numPlayers);

  /**
   * Make a new window pop up to show team member information.
   *
   * @param teamMemberInfo a string of all the team member information
   */
  public void addTeamDialog(String teamMemberInfo);

  /**
   * Make a new window pop up to show linup information.
   *
   * @param lineupInfo a string of all the lineup information
   */
  public void addLineupDialog(String lineupInfo);

  /**
   * Clear first name textfield, last name textfield and birthdat datechooser part input
   * on the user interface window after a payer is added.
   */
  public void clearNewPlayerInput();

}

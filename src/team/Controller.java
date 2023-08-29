package team;

import com.sun.jdi.request.DuplicateRequestException;
import java.awt.Component;
import javax.swing.JOptionPane;

/**
 * A Controller class that implements the Features interface to handle interactions between
 * the Team model and the View GUI.
 */
public class Controller implements Features {
  private Team model;
  private View view;

  /**
   * Constructor for the Controller class.
   * @param m the Team model
   */
  public Controller(Team m) {
    this.model = m;
  }

  @Override
  public void setView(View v) {
    this.view = v;
    this.view.addFeatures(this);
  }

  @Override
  public void exitProgram() {
    System.exit(0);
  }

  @Override
  public void addPlayer() {
    try {
      checkEmpty();
      checkValidName();
      this.model.addPlayer(new Player(view.getFirstNameString(), view.getLastNameString(),
          view.getBirthday(), view.getPosition(), view.getSkillLevel()));
      this.view.displayNumPlayers(this.model.getCandidateSize());
      this.view.clearNewPlayerInput();
    } catch (IllegalArgumentException e) {
      JOptionPane.showMessageDialog((Component) this.view, "Player is not under "
          + "ten years of age and cannot be added.", "Error", JOptionPane.ERROR_MESSAGE);
    } catch (DuplicateRequestException f) {
      JOptionPane.showMessageDialog((Component) this.view, "The same player can't"
          + " be added again.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Check if the first and last name fields are empty, and display an error message
   * if either one is empty.
   */
  private void checkEmpty() {
    if (this.view.getFirstNameString() == null
        || this.view.getFirstNameString().isEmpty()) {
      JOptionPane.showMessageDialog(null, "First name cannot be empty.",
          "Error", JOptionPane.ERROR_MESSAGE);
    }
    if (this.view.getLastNameString() == null
        || this.view.getLastNameString().isEmpty()) {
      JOptionPane.showMessageDialog(null, "Last cannot be empty.",
          "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  /**
   * Check if the first and last name fields contain only letters, and display an error
   * message if any other characters or symbols are detected.
   */
  private void checkValidName() {
    if (!this.view.getFirstNameString().matches("^[a-zA-Z]+$")
        || !this.view.getLastNameString().matches("^[a-zA-Z]+$")) {
      JOptionPane.showMessageDialog(null, "Invalid characters or symbols"
              + " in name.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  @Override
  public void createTeam() {
    try {
      this.model.createTeam();
      this.view.setGetPlayersButton();
      this.view.setGetLineupButton();
      this.view.disableAddAndCreateButton();
    } catch (IllegalStateException e) {
      JOptionPane.showMessageDialog((Component) this.view, "A team with fewer "
          + "than 10 candidates can't be created.", "Error", JOptionPane.ERROR_MESSAGE);
    }
  }

  @Override
  public void displayPlayers() {
    this.view.addTeamDialog(this.model.getPlayers());
  }

  @Override
  public void displayLineup() {
    this.view.addLineupDialog(this.model.getLineup());
  }
}

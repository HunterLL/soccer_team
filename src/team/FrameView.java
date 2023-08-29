package team;

import com.toedter.calendar.JDateChooser;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 * GUI Implementation of the View interface.
 */
public class FrameView extends JFrame implements View {
  private final JLabel displayNumPlayers;
  private final JLabel displayCandidate;
  private final JLabel displayFirstName;
  private final JLabel displayLastName;
  private final JLabel displayPosition;
  private final JLabel displayBirthday;
  private final JLabel displaySkillLevel;
  private final JTextField firstNameField;
  private final JTextField lastNameField;
  private final JComboBox<Position> positionComboBox;
  private final JDateChooser dateChooser;
  private final JComboBox<Integer> skillLevelComboBox;
  private final JButton addPlayerButton;
  private final JButton createTeamButton;
  private final JButton getPlayersButton;
  private final JButton getLineupButton;
  private final JButton exitButton;
  private JDialog dialog1;
  private JTextArea textArea1;
  private JScrollPane scrollPane1;
  private JButton closeButton1;
  private JPanel buttonPanel1;
  private JDialog dialog2;
  private JTextArea textArea2;
  private JScrollPane scrollPane2;
  private JButton closeButton2;
  private JPanel buttonPanel2;

  /**
   * Constructor for FrameView class.
   *
   * @param caption the title/caption of the frame.
   */
  public FrameView(String caption) {
    super(caption);

    JPanel contentPane = new JPanel(new BorderLayout(20, 20));
    contentPane.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
    JLabel label = new JLabel();
    label.setHorizontalAlignment(JLabel.CENTER);
    label.setVerticalAlignment(JLabel.CENTER);
    contentPane.add(label, BorderLayout.CENTER);
    setContentPane(contentPane);

    setViewTheme(); // a private method
    getContentPane().setBackground(Color.WHITE); // sets the background color of the content pane
    setBackground(Color.BLUE); // sets the background color of the frame

    setSize(1000, 1000);
    setLocation(200, 200);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    setLayout(new GridBagLayout());
    GridBagConstraints gbc = new GridBagConstraints();
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.gridx = 0;
    gbc.gridy = 0;
    gbc.anchor = GridBagConstraints.WEST;
    gbc.insets = new Insets(10, 10, 10, 10);

    //Candidate Title: Label
    displayCandidate = new JLabel("Candidate information: ");
    Font font = displayCandidate.getFont();
    Font boldFont = new Font(font.getName(), Font.BOLD, font.getSize() + 2);
    displayCandidate.setFont(boldFont);
    add(displayCandidate, gbc);

    //firstname: Label+TextField
    gbc.gridx = 0;
    gbc.gridy++;
    displayFirstName = new JLabel("1. First name");
    add(displayFirstName, gbc);

    gbc.gridx++;
    firstNameField = new JTextField(10);
    firstNameField.setMaximumSize(firstNameField.getPreferredSize());
    add(firstNameField, gbc);

    //Lastname: Label+TextField
    gbc.gridx = 0;
    gbc.gridy++;
    displayLastName = new JLabel("2. Last name");
    add(displayLastName, gbc);

    gbc.gridx++;
    lastNameField = new JTextField(10);
    add(lastNameField, gbc);

    //Position: Label+ComboBox
    gbc.gridx = 0;
    gbc.gridy++;
    displayPosition = new JLabel("3. Preferred Position: ");
    add(displayPosition, gbc);

    gbc.gridx++;
    positionComboBox = new JComboBox<>(Position.values());
    add(positionComboBox, gbc);

    //Birthday: Label+DateChooser
    gbc.gridx = 0;
    gbc.gridy++;
    displayBirthday = new JLabel("4. Birthday");
    add(displayBirthday, gbc);

    gbc.gridx++;
    dateChooser = new JDateChooser();
    add(dateChooser, gbc);

    //Skill level: label+ComboBox
    gbc.gridx = 0;
    gbc.gridy++;
    displaySkillLevel = new JLabel("5. Skill Level");
    add(displaySkillLevel, gbc);

    gbc.gridx++;
    skillLevelComboBox = new JComboBox<Integer>();
    for (int i = 1; i <= 5; i++) {
      skillLevelComboBox.addItem(i);
    }
    add(skillLevelComboBox, gbc);

    //Player number summary: label
    gbc.gridx = 0;
    gbc.gridy++;
    displayNumPlayers = new JLabel("Number of players: " + 0);
    add(displayNumPlayers, gbc);

    //exit button
    gbc.gridx = 3;
    gbc.gridy = 4;
    exitButton = new JButton("Exit");
    exitButton.setActionCommand("Exit Button");
    add(exitButton, gbc);

    //Add:Button
    gbc.gridx = 3;
    gbc.gridy = 0;
    addPlayerButton = new JButton("Add");
    addPlayerButton.setActionCommand("Add");
    add(addPlayerButton, gbc);

    //Create team: Button
    gbc.gridx = 3;
    gbc.gridy = 1;
    createTeamButton = new JButton("Create");
    createTeamButton.setActionCommand("Create");
    add(createTeamButton, gbc);

    //View team: Button
    gbc.gridx = 3;
    gbc.gridy = 2;
    getPlayersButton = new JButton("View team");
    getPlayersButton.setActionCommand("View team");
    getPlayersButton.setEnabled(false);
    add(getPlayersButton, gbc);

    //View lineup: Button
    gbc.gridx = 3;
    gbc.gridy = 3;
    getLineupButton = new JButton("View lineup");
    getLineupButton.setActionCommand("View lineup");
    getLineupButton.setEnabled(false);
    add(getLineupButton, gbc);

    pack();
    setVisible(true);
  }

  /**
   * Sets the theme for the view.
   */
  private void setViewTheme() {
    try {
      UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
             | UnsupportedLookAndFeelException ex) {
      ex.printStackTrace();
    }
    // Update the UI of the window
    SwingUtilities.updateComponentTreeUI(this);
  }

  @Override
  public void addFeatures(Features features) {
    exitButton.addActionListener(evt -> features.exitProgram());
    addPlayerButton.addActionListener(evt -> features.addPlayer());
    createTeamButton.addActionListener(evt -> features.createTeam());
    getPlayersButton.addActionListener(evt -> features.displayPlayers());
    getLineupButton.addActionListener(evt -> features.displayLineup());
  }

  @Override
  public String getFirstNameString() {
    return firstNameField.getText();
  }

  @Override
  public String getLastNameString() {
    return lastNameField.getText();
  }

  @Override
  public Position getPosition() {
    return (Position) positionComboBox.getSelectedItem();
  }

  @Override
  public LocalDate getBirthday() {
    Date selectedDate = dateChooser.getDate();
    if (selectedDate.after(new Date())) {
      dateChooser.setDate(new Date());
    }
    LocalDate birthday = selectedDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
    return birthday;
  }

  @Override
  public int getSkillLevel() {
    int skillLevel = (int) skillLevelComboBox.getSelectedItem();
    return skillLevel;
  }

  @Override
  public void setGetPlayersButton() {
    getPlayersButton.setEnabled(true);
  }

  @Override
  public void setGetLineupButton() {
    getLineupButton.setEnabled(true);
  }

  @Override
  public void disableAddAndCreateButton() {
    addPlayerButton.setEnabled(false);
    createTeamButton.setEnabled(false);
  }

  @Override
  public void displayNumPlayers(int numPlayers) {
    displayNumPlayers.setText("Number of players: " + numPlayers);
  }

  @Override
  public void addTeamDialog(String teamMemberInfo) {
    dialog1 = new JDialog(this, "Team Information", true);
    dialog1.setSize(300, 200);
    dialog1.setLayout(new BorderLayout());
    textArea1 = new JTextArea(teamMemberInfo);
    textArea1.setEditable(false);
    scrollPane1 = new JScrollPane(textArea1);
    dialog1.add(scrollPane1, BorderLayout.CENTER);
    closeButton1 = new JButton("Close");
    buttonPanel1 = new JPanel();
    buttonPanel1.add(closeButton1);
    closeButton1.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        dialog1.dispose();
      }
    });
    dialog1.add(buttonPanel1, BorderLayout.SOUTH);
    dialog1.setVisible(true);
  }

  @Override
  public void addLineupDialog(String lineupInfo) {
    dialog2 = new JDialog(this, "Lineup Information", true);
    dialog2.setSize(400, 200);
    dialog2.setLayout(new BorderLayout());
    textArea2 = new JTextArea(lineupInfo);
    textArea2.setEditable(false);
    scrollPane2 = new JScrollPane(textArea2);
    dialog2.add(scrollPane2, BorderLayout.CENTER);
    closeButton2 = new JButton("Close");
    buttonPanel2 = new JPanel();
    buttonPanel2.add(closeButton2);
    closeButton2.addActionListener(new ActionListener() {
      @Override public void actionPerformed(ActionEvent e) {
        dialog2.dispose();
      }
    });
    dialog2.add(buttonPanel2, BorderLayout.SOUTH);
    dialog2.setVisible(true);
  }

  @Override
  public void clearNewPlayerInput() {
    firstNameField.setText("");
    lastNameField.setText("");
    dateChooser.setDate(null);
  }
}

package team;

import com.sun.jdi.request.DuplicateRequestException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;


/**
 *  This is a class representing a TeamModel class, implementing all the operations
 *  mandated by Team.
 */
public class TeamModel implements Team {
  private List<Player> candidates;
  private TreeMap<Integer, Player> jerseyNumTable;
  private TreeMap<Player, Position> lineupTable;

  /**
   * The constructor of class TeamModel, initializing the field:
   * candidates, jerseyNumTable and lineupTable.
   */
  public TeamModel() {
    this.candidates = new ArrayList<>();
    this.jerseyNumTable =  new TreeMap<>();
    this.lineupTable =  new TreeMap<>();
  }

  @Override
  public void addPlayer(Player player) throws DuplicateRequestException {
    if (this.candidates.contains(player)) {
      throw new DuplicateRequestException("The same player can't be added twice.");
    } else {
      this.candidates.add(player);
    }
  }

  @Override
  public void createTeam() throws IllegalStateException {
    if (this.candidates.size() < 10) {
      throw new IllegalStateException("A team with fewer than 10 candidates can't be created.");
    }
    if (this.candidates.size() > 20) {
      Collections.sort(this.candidates, (player1, player2) -> Integer
              .compare(player2.getSkillLevel(),
              player1.getSkillLevel()));
      this.candidates = this.candidates.subList(0, 20);
    }
    //assign jersey number
    assignJerseyNum();
    //form starting lineup team
    //Step 1: choose lineup list
    //Step 2: assign position
    selectLineup();
  }

  /**
   * Choose a random number from 1 to 20(inclusive) and assign it to a team
   * member as their unique jersey number. Number is recorded in the treemap
   * as key and player is recorded as value.
   */
  private void assignJerseyNum() {
    //create a list of integers from 1 to 20
    List<Integer> availableNums = new ArrayList<>();
    for (int i = 1; i <= 20; i++) {
      availableNums.add(i);
    }
    Collections.shuffle(availableNums);
    for (Player candidate : this.candidates) {
      this.jerseyNumTable.put(availableNums.remove(0), candidate);
    }
  }

  /**
   * Select starting lineup players and assign them each a position.
   */
  private void selectLineup() {
    List<Player> lineup = new ArrayList<>();
    List<Player> teamList = new ArrayList<>(this.jerseyNumTable.values());
    Collections.sort(teamList, (player1, player2) -> Integer.compare(player2.getSkillLevel(),
            player1.getSkillLevel()));
    lineup.addAll(teamList.subList(0, 7));
    assignPositions(lineup);
  }

  /**
   * Assign each player a position in the starting lineup.
   *
   * @param players a list of players
   */
  private void assignPositions(List<Player> players) {
    List<Position> availablePositions = new ArrayList<>();
    availablePositions.add(Position.Goalie);
    availablePositions.add(Position.Defender);
    availablePositions.add(Position.Defender);
    availablePositions.add(Position.Midfielder);
    availablePositions.add(Position.Midfielder);
    availablePositions.add(Position.Midfielder);
    availablePositions.add(Position.Forward);
    for (Player player : players) {
      Position preferredPosition = player.getPreferredPosition();
      if (availablePositions.contains(preferredPosition)) {
        this.lineupTable.put(player, preferredPosition);
        availablePositions.remove(preferredPosition);
      } else {
        Position position = availablePositions.remove(0);
        this.lineupTable.put(player, position);
      }
    }
  }

  @Override
  public String getPlayers() {
    StringBuilder str = new StringBuilder();
    List<Player> sortedPlayers = new ArrayList<>(this.jerseyNumTable.values());
    Collections.sort(sortedPlayers, (player1, player2) -> player1.getLastName()
            .compareTo(player2.getLastName()));

    for (Player player : sortedPlayers) {
      int playerJerseyNum = findJerseyNum(player);
      str.append("Name: ").append(player.getName()).append(", ").append("Jersey number: ")
              .append(playerJerseyNum).append("\n");
    }
    return str.toString();
  }

  /**
   * Return the jersey number of a player in the team.
   *
   * @param player a player object
   * @return the jersey number of a player in the team
   */
  private int findJerseyNum(Player player) {
    List<Integer> numbers = new ArrayList<>(this.jerseyNumTable.keySet());
    Integer temp = null;
    for (Integer num : numbers) {
      if (player == this.jerseyNumTable.get(num)) {
        temp = num;
      }
    }
    return temp;
  }

  @Override
  public String getLineup() {
    List<Map.Entry<Player, Position>> entries = new ArrayList<>(lineupTable.entrySet());
    Collections.sort(entries, new Comparator<Map.Entry<Player, Position>>() {
      @Override
      public int compare(Map.Entry<Player, Position> entry1, Map.Entry<Player, Position> entry2) {
        int positionComparison = entry1.getValue().compareTo(entry2.getValue());
        if (positionComparison != 0) {
          return positionComparison;
        }
        String lastName1 = entry1.getKey().getLastName();
        String lastName2 = entry2.getKey().getLastName();
        return lastName1.compareTo(lastName2);
      }
    });

    StringBuilder str = new StringBuilder();
    for (Map.Entry<Player, Position> entry : entries) {
      int playerJerseyNum = findJerseyNum(entry.getKey());
      str.append("Name: ").append(entry.getKey().getName()).append(", ").append("Jersey number: ")
                .append(playerJerseyNum).append(", ").append("Position: ")
                .append(entry.getValue()).append("\n");
    }
    return str.toString();
  }

  @Override
  public int getTeamSize() {
    return this.jerseyNumTable.size();
  }

  @Override
  public int getCandidateSize() {
    return this.candidates.size();
  }

}

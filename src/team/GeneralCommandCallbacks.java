package team;

public class GeneralCommandCallbacks {
  /**
   * Driver class. Creates MVC objects.
   *
   * @param args not used.
   */
  public static void main(String[] args) {
    Team model = new TeamModel();
    Controller controller = new Controller(model);
    View view = new FrameView("Soccer Team Manager");
    controller.setView(view);
  }
}
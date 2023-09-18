package cs3500.pa01;

/**
 * represents the inputs that the users can choose and
 *  the difficulty tag
 */
public enum UserInput {
  EASY("1", "Easy"),
  HARD("2", "Hard"),
  ANSWER("3", "Answer"),
  EXIT("4", "Exit");

  private final String userInp;
  private final String tag;

  UserInput(String userInp, String tag) {
    this.userInp = userInp;
    this.tag = tag;
  }

  /**
   * represents the numeric version of the input
   */
  public String correspondingInput() {
    return this.userInp;
  }

  /**
   * represents string version of the user input
   */
  public String getTagName() {
    return this.tag;
  }
}

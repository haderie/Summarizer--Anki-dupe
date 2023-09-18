package cs3500.pa01;

import java.io.IOException;

/**
 *
 */
public class ViewClass {
  private final Appendable output;

  public ViewClass(Appendable output) {
    this.output = output;
  }

  /**
   * displays a message welcoming the user
   *
   */
  public void welcomeUser() throws IOException {
    output.append("\nWelcome to your study session!\n");

    System.out.println("\nWelcome to your study session!\n");
    //return output;
  }

  /**
   * displays a message asks the user for the path
   **/
  public void askUserPath() throws IOException {

    output.append("Please provide the path to the question bank:");

    System.out.println("Please provide the path to the question bank:");
  }

  /**
   * prints a question as how many questions the user wants to input
   */
  public void askNumQuestions() throws IOException {
    output.append("How many questions would you like to practice today?");

    System.out.println("How many questions would you like to practice today?");
  }

  /**
   * displays the choices the user has
   */
  void displayMenu() throws IOException {

    output.append("Press: 3) to Show Answer, 4) to Exit");

    System.out.println("Press: 3) to Show Answer, 4) Finish");
  }

  /**
   * displays the choices the user has
   */
  void displayTagChoice() throws IOException {

    output.append("Press 1) Mark Easy, 4) Exit");

    System.out.println("Press 1) Mark Easy, 2) Mark Hard, 4) Finish");
  }

  /**
   * displays the current question or answer
   */
  void displayQuestionAnswer(String question) throws IOException {

    output.append(question);

    System.out.println(question);
  }

  /**
   * displays the stats of the question bank
   */
  void displayStats(int numOfQs, int easyToHard,
                    int hardToEasy, int totalHard, int totalEasy) throws IOException {

    output.append("You answered " + numOfQs + " questions."
        + easyToHard + " went from easy to hard."
        + hardToEasy + " went from hard to easy."
        + "Current count in Question Bank:"
        + totalHard + " hard questions"
        + totalEasy + " easy questions");

    System.out.println("You answered " + numOfQs + " questions.");
    System.out.println(easyToHard + " went from easy to hard.");
    System.out.println(hardToEasy + " went from hard to easy.");

    System.out.println("Current count in Question Bank:");
    System.out.println(totalHard + " hard questions");
    System.out.println(totalEasy + " easy questions");
  }

}

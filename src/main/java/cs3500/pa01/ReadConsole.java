

package cs3500.pa01;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * represents the user input and the console output
 */
public class ReadConsole {
  private final Readable input;
  private final HandlesAllQuestions allQuestions;
  private final Appendable output;

  /**
   * represents the constructor
   */
  public ReadConsole(Readable input, HandlesAllQuestions allQuestions, Appendable output) {
    this.input = input;
    this.allQuestions = allQuestions;
    this.output = output;
  }

  String easy = UserInput.EASY.correspondingInput();
  String hard = UserInput.HARD.correspondingInput();
  String answer = UserInput.ANSWER.correspondingInput();
  String exit = UserInput.EXIT.correspondingInput();
  String easyTag = UserInput.EASY.getTagName();
  String hardTag = UserInput.HARD.getTagName();

  /**
   * reads the user input and outputs the corresponding message
   */
  public void read() throws IOException {
    Scanner scanner = new Scanner(input);
    ViewClass view = new ViewClass(output);
    ArrayList<QuestionAnswerPair> practiceQs = this.allQuestions.getPracticeQuestions();
    int easyToHard = 0;
    int hardToEasy = 0;
    int numOfEasyQuest = this.allQuestions.easyCount();
    int numOfHardQuest = this.allQuestions.hardCount();
    int sessQuest = practiceQs.size();

    for (int ind = 0; ind < practiceQs.size(); ind += 1) {
      QuestionAnswerPair current = practiceQs.get(ind);
      view.displayQuestionAnswer(current.getQuestion());
      view.displayMenu();

      if (scanner.hasNext(exit)) {
        practiceQs.clear();
        view.displayStats(sessQuest, easyToHard, hardToEasy,
            numOfHardQuest - hardToEasy, numOfEasyQuest - easyToHard);
        break;
      }
      if (scanner.hasNext(answer)) {
        view.displayQuestionAnswer(current.getAnswer());

        view.displayTagChoice();
        scanner.nextLine();
        if (scanner.hasNext(easy)) {
          if (current.getTag().equals(hardTag)) {
            allQuestions.changeTagToEasy(current);
            hardToEasy++;
          }
        } else if (scanner.hasNext(hard)) {
          if (current.getTag().equals(easyTag)) {
            allQuestions.changeTagToHard(current);
            easyToHard++;
          }
        } else if (scanner.hasNext(exit)) {
          view.displayStats(sessQuest, easyToHard, hardToEasy,
              numOfHardQuest - hardToEasy, numOfEasyQuest - easyToHard);
          practiceQs.clear();
          break;
        } else {
          ind = ind - 1;
          System.err.println(
              "That was an invalid input. Please choose from one of the options and try again");
          scanner.nextLine();
        }
        scanner.nextLine();

      }
      if (ind == practiceQs.size() - 1) {
        practiceQs.clear();
        view.displayStats(sessQuest, easyToHard, hardToEasy,
            numOfHardQuest, numOfEasyQuest - easyToHard);
      }

    }
  }
}





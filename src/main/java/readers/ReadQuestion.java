package readers;

import cs3500.pa01.QuestionAnswerPair;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * represents the class to read the question file
 */
public class ReadQuestion {
  private final ArrayList<QuestionAnswerPair> allQues = new ArrayList<>();

  public ReadQuestion() {
  }

  /**
   * returns the list of questions
   */
  public ArrayList<QuestionAnswerPair> getAllQs() {
    return allQues;
  }

  /**
   * reads the questions from the question bank
   *
   * @param file represents the sr file of questions
   */
  public void readQuestion(File file) {
    Scanner sc;
    try { // The file may not exist, in which case we need to handle that error (hence try-catch)
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }

    while (sc.hasNextLine()) { // Check there is another unread line in the file
      String nextLine = sc.nextLine();
      allQues.add(new QuestionAnswerPair(nextLine));

    }
  }
}

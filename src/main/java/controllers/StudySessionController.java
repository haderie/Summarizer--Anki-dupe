package controllers;

import cs3500.pa01.HandlesAllQuestions;
import cs3500.pa01.ReadConsole;
import cs3500.pa01.ViewClass;
import java.io.File;
import java.io.IOException;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;
import writer.UpdateQuestionFile;


/**
 * represents the controller for a study session
 */
public class StudySessionController implements Controller {
  private final Readable input;
  private final Appendable output;

  private final Random rand;

  /**
   * represents the constructor
   */
  public StudySessionController(Readable input, Appendable output, Random rand) {
    this.input = Objects.requireNonNull(input);
    this.output = Objects.requireNonNull(output);
    this.rand = rand;
  }


  /**
   * runs the different model classes
   */
  public void run() throws IOException {
    Scanner scan = new Scanner(input);
    ViewClass view = new ViewClass(output);
    view.welcomeUser(); //welcomes the user
    view.askUserPath(); //asks user for a path
    String path = scan.next();

    //checks for invalid file or file not found
    File file = new File(path);
    Scanner sc;
    try {
      sc = new Scanner(file);
    } catch (IOException e) {
      System.err.println(e);
      view.askUserPath();
      path = scan.next();
    }

    //ask user how many questions to practice
    view.askNumQuestions();
    int numQuestions = Integer.parseInt(scan.next());

    if (numQuestions <= 0) {
      System.err.println(numQuestions + " is not a valid input, please input positive numbers" );
      numQuestions = Integer.parseInt(scan.next());
    }

    HandlesAllQuestions allQuestions = new HandlesAllQuestions(new File(path), numQuestions, rand);

    //reads what
    ReadConsole console = new ReadConsole(input, allQuestions, output);
    console.read();

    //updates the question bank at the end
    UpdateQuestionFile fileWriter =
        new UpdateQuestionFile(path, allQuestions.getFullListQuestions());
    fileWriter.writeQuestion();


  }
}
//sample/questBank.sr

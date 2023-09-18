package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import controllers.StudySessionController;
import java.io.IOException;
import java.io.StringReader;
import java.util.Random;
import org.junit.jupiter.api.Test;

/**
 * tests the studySession controller that starts the studySession.
 */
class StudySessionControllerTest {

  /**
   * tests that the studySession runs.
   */
//  @Test
//  void run() {
//    String path = "sample/questBank.sr\n1";
//    Appendable output = new StringBuilder();
//
//    Readable input = new StringReader(path);
//
//    StudySessionController studySessController =
//        new StudySessionController(input, output, new Random(1));
//
//    assertEquals(output.toString(), "");
//
//    try {
//      studySessController.run();
//    } catch (IOException e) {
//      throw new RuntimeException(e);
//    }
//    String userInput =
//        "\nWelcome to your study session!\n"
//            + "Please provide the path to the question "
//            + "bank:How many questions would you like to practice today?"
//            + "Which country is known as the Land of the Rising Sun? "
//            + "Press: 3) to Show Answer, 4) to Exit"
//            + "You answered 1 questions.0 went from easy to hard.0 went from hard to "
//            + "easy.Current count in Question Bank:1 hard questions1 easy questions";
//
//
//    assertEquals(output.toString(), userInput);
//
//  }

  /**
   * tests the that the studySession controller throws a Runtime exception given
   * a wrong file path
   */
  @Test
  void runInvalidFile() {
    String path = "sample/studyde.sr\n1\n3";
    Readable input = new StringReader(path);

    Appendable output = new StringBuilder();
    StudySessionController studySessController =
        new StudySessionController(input, output, new Random(1));


    assertThrows(RuntimeException.class,
        () -> studySessController.run());

  }
}
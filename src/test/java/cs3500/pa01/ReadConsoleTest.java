package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import java.io.IOException;
import java.io.StringReader;
import java.util.NoSuchElementException;
import java.util.Random;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * tests the class that reads the user input
 */
class ReadConsoleTest {

  String path;
  Appendable output;
  HandlesAllQuestions handlesAllQuestions;

  /**
   * sets up the path to the question bank and the class that generates questions
   */
  @BeforeEach
  void setUp() {
    path = "sample/questBank.sr";
    output = new StringBuilder();
    handlesAllQuestions
        = new HandlesAllQuestions(new File(path), 2, new Random(1));
  }

  /**
   * tests that the console can accept an input to show the answer to
   * a question and then mark the question as hard
   */
  @Test
  void testReadHard() {
    String userInp = "3\n2\n";
    Readable input = new StringReader(userInp);

    ReadConsole readConsole = new ReadConsole(input, handlesAllQuestions, output);
    try {
      readConsole.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * tests that the console can immediately exit the program before accepting
   * an answer
   */
  @Test
  void testReadExit() {
    String userInp = "4\n";
    Readable input = new StringReader(userInp);
    ReadConsole readConsole = new ReadConsole(input, handlesAllQuestions, output);

    try {
      readConsole.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * tests that the console can accept an input to show the answer to
   * a question and then marks the question as easy
   */
  @Test
  void testReadEasy() {
    String userInp = "3\n1";
    Readable input = new StringReader(userInp);
    ReadConsole readConsole = new ReadConsole(input, handlesAllQuestions, output);

    try {
      readConsole.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * tests that the console can accept an input to show the answer to
   * a question and then exit the program
   */

  @Test
  void testReadAnswerThenExit() {
    String userInp = "3\n4\n";
    Readable input = new StringReader(userInp);
    ReadConsole readConsole = new ReadConsole(input, handlesAllQuestions, output);

    try {
      readConsole.read();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * tests that the user can give an invalid input and outputs an error message
   * but doesn't end the program
   */
  @Test
  void testInvalidInput() {
    String userInp = "3\n5";
    Readable input = new StringReader(userInp);
    ReadConsole readConsole = new ReadConsole(input, handlesAllQuestions, output);

    assertThrows(NoSuchElementException.class,
        () -> readConsole.read());
  }

}
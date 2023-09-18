import controllers.StudyGuideController;
import controllers.StudySessionController;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Random;

/**
 * This is the main driver of this project.
 */
public class Driver {
  /**
   * Project entry point
   *
   * @param args - no command line args required
   */
  public static void main(String[] args) {
    if (args.length == 3) {

      StudyGuideController studyGuideControl = new StudyGuideController(args[0], args[1], args[2]);
      studyGuideControl.run();
    }
    Readable input = new InputStreamReader(System.in);
    Appendable output = new OutputStreamWriter(System.out);
    StudySessionController studSessController =
        new StudySessionController(input, output, new Random());
    try {
      studSessController.run();
    } catch (IOException e) {
      throw new RuntimeException(e);

    }
  }
}
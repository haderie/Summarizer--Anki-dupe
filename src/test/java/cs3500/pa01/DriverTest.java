package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import controllers.StudyGuideController;
import controllers.StudySessionController;
import java.io.IOException;
import java.io.StringReader;
import java.util.Random;
import org.junit.jupiter.api.Test;

class DriverTest {

  @Test
  public void driverTest() {
    String[] args = new String[3];

    String path = args[0] = "sampleMd";
    String flag = args[1] = "filename";
    String output = args[2] = "sample/studyguide.md";
    StudyGuideController studyGuideController = new StudyGuideController(path, flag, output);
    studyGuideController.run();
  }

  @Test
  public void driverStudySessionTest() {
    String[] args = new String[0];

    String path = "sample/studyguide.sr\n1\n3";
    Appendable output = new StringBuilder();
    Readable input = new StringReader(path);

    StudySessionController studySessController =
        new StudySessionController(input, output, new Random(1));
    try {
      studySessController.run();
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}


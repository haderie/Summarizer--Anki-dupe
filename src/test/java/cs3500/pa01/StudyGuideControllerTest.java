package cs3500.pa01;

import controllers.StudyGuideController;
import org.junit.jupiter.api.Test;

/**
 * test for the studyGuide controller
 */
class StudyGuideControllerTest {

  /**
   * test that the studyGuide controller can accept the 3 arguments and runs
   */
  @Test
  void run() {
    String[] args = new String[3];
    args[0] = "sampleMd";
    args[1] = "filename";
    args[2] = "sample/studyguide.md";
    String directory = args[0];
    String flag = args[1];
    String output = args[2];

    StudyGuideController studyGuideController = new StudyGuideController(directory, flag, output);
    studyGuideController.run();
  }
}
package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.File;
import org.junit.jupiter.api.Test;
import writer.WriteStudyGuide;


/**
 * test for class that writes a markdown studyguide
*/
class WriteStudyGuideTest {

  /**
   * tests that a correct studyGuide has been created
   */
  @Test
  void filterFile() {
    File file1 = new File("sampleMd/file1.md");
    WriteStudyGuide writeStudyGuide = new WriteStudyGuide(file1.toPath(), "studyguide.sr");
    writeStudyGuide.writeFile();
  }

  /**
   * test that the method filtetFile() throws a RuntimeException when given a
   * wrong file to read from
   */
  @Test
  void testInvalidFile() {
    File file1 = new File("samprd/file1.md");
    WriteStudyGuide writeStudyGuide = new WriteStudyGuide(file1.toPath(), "studyge.sr");

    assertThrows(RuntimeException.class,
        () -> writeStudyGuide.writeFile());

  }
}
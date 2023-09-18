package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.attribute.FileTime;
import org.junit.jupiter.api.Test;

/**
 * represents test for MdFiles
 */
class MdFileTest {

  File file1 = new File("sampleMd/file1.md");
  File file4 = new File("sampleMd/file4.md");

  MdFile mdFile1 = new MdFile(file1, "file1.md", FileTime.fromMillis(2023 - 5 - 12), 10);
  MdFile mdFile4 = new MdFile(file4, "file4.md", FileTime.fromMillis(2023 - 4 - 12), 20);

  /**
   * tests that the given file name equals getFileName
   */
  @Test
  public void getFileName() {
    assertEquals("file1.md", mdFile1.getFileName());
    assertEquals("file4.md", mdFile4.getFileName());
  }

  /**
   * tests that the date created equals the file's getDateCreated method
   */
  @Test
  public void getDateCreated() {
    assertEquals(FileTime.fromMillis(2023 - 5 - 12), mdFile1.getDateCreated());
    assertEquals(FileTime.fromMillis(2023 - 4 - 12), mdFile4.getDateCreated());
  }

  /**
   * tests that the time modified equals the file's getDateModified method
   */
  @Test
  public void getDateModified() {
    assertEquals(10, mdFile1.getDateModified());
    assertEquals(20, mdFile4.getDateModified());
  }

  /**
   * tests that the given string equals the file's currFileContent method
   */
  @Test
  public void getFileContent() {
    assertEquals("\n# this is file 4 content second to last created\n",
        mdFile4.currFileContent());
  }


}

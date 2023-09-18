package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * represents tests for SortByCreated comparator
 */
class SortByCreatedTest {

  SortByCreated byCreated = new SortByCreated();

  ArrayList<MdFile> allFiles = new ArrayList<>();
  File file1 = new File("sampleMd/file1.md");
  File file5 = new File("sampleMd/file5.md");
  MdFile mdFile1 = new MdFile(file1, "file1.md", FileTime.fromMillis(2023 - 5 - 12), 10);
  MdFile mdFile5 = new MdFile(file5, "file5.md", FileTime.fromMillis(2023 - 4 - 12), 20);

  /**
   * tests that the files have been added to the arrayList
   */
  @Test
  public void addFiles() {
    allFiles.add(mdFile1);
    assertEquals(1, allFiles.size());
    allFiles.add(mdFile5);
    assertEquals(2, allFiles.size());
  }

  /**
   * tests compare method to sort the file correctly by created date
   */
  @Test
  public void compare() {
    assertEquals(-1, byCreated.compare(mdFile1, mdFile5));
    assertEquals(1, byCreated.compare(mdFile5, mdFile1));
  }


}
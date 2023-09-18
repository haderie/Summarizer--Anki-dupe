package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * represents tests for SortByModified comparator
 */
class SortByModifiedTest {
  SortByModified byModified = new SortByModified();

  ArrayList<MdFile> allFiles = new ArrayList<>();
  File file1 = new File("sampleMd/file1.md");
  File file2 = new File("sampleMd/file2.md");
  MdFile mdFile1 = new MdFile(file1, "file1.md", FileTime.fromMillis(2023 - 5 - 12),
      10);
  MdFile mdFile2 = new MdFile(file2, "file2.md", FileTime.fromMillis(2023 - 4 - 12),
      20);

  /**
   * tests that the files have been added to the arrayList
   */
  @BeforeEach
  public void addFiles() {
    allFiles.add(mdFile1);
    assertEquals(1, allFiles.size());
    allFiles.add(mdFile2);
    assertEquals(2, allFiles.size());
  }

  /**
   * tests compare method to sort the file correctly by last modified date
   */
  @Test
  public void compare() {
    assertEquals(-1, byModified.compare(mdFile1, mdFile2));
    assertEquals(1, byModified.compare(mdFile2, mdFile1));
  }

}
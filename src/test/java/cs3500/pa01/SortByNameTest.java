package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.File;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;

/**
 * represents tests for SortByName comparator
 */
class SortByNameTest {
  SortByName byName = new SortByName();
  ArrayList<MdFile> allFiles = new ArrayList<>();
  File file1 = new File("sampleMd/file1.md");
  File file2 = new File("sampleMd/file2.md");
  MdFile mdFile1 = new MdFile(file1, "file1.md", FileTime.fromMillis(2023 - 5 - 12),
      file1.lastModified());
  MdFile mdFile2 = new MdFile(file2, "file2.md", FileTime.fromMillis(2023 - 4 - 12),
      file1.lastModified());

  /**
   * tests that the files have been added to the arrayList
   */
  @Test
  public void addFiles() {
    assertEquals(0, allFiles.size());
    allFiles.add(mdFile1);
    assertEquals(1, allFiles.size());
    allFiles.add(mdFile2);
    assertEquals(2, allFiles.size());
  }

  /**
   * represents tests for SortByCreated comparator
   */
  @Test
  public void compare() {
    assertEquals(-1, byName.compare(mdFile1, mdFile2));
    assertEquals(1, byName.compare(mdFile2, mdFile1));
  }


}
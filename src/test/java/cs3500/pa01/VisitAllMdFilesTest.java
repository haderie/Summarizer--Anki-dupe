package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.nio.file.attribute.FileTime;
import java.util.ArrayList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * represents tests for ALlMdFilesTest
 */
class VisitAllMdFilesTest {

  VisitAllMdFiles visitAllMdFilesFileName;

  VisitAllMdFiles visitAllMdFilesCreated;

  VisitAllMdFiles visitAllMdFilesModified;

  ArrayList<MdFile> allFiles = new ArrayList<>();
  File file1 = new File("sampleMd/file1.md");
  File file2 = new File("sampleMd/file2.md");
  File file3 = new File("sampleMd/file3.pdf");
  File file4 = new File("sampleMd/file4.md");
  MdFile mdFile1 = new MdFile(file1, "file1.md", FileTime.fromMillis(2023 - 4 - 12), 10);
  MdFile mdFile2 = new MdFile(file2, "file2.md", FileTime.fromMillis(2023 - 5 - 12), 20);

  MdFile mdFile4 = new MdFile(file4, "file4.md", FileTime.fromMillis(2023 - 2 - 12), 40);

  @BeforeEach
  void setUp() {
    visitAllMdFilesFileName = new VisitAllMdFiles("filename");
    visitAllMdFilesCreated = new VisitAllMdFiles("created");
    visitAllMdFilesModified = new VisitAllMdFiles("modified");
  }

  /**
   * tests that files have been added to the arrayList
  */
  @Test
  void addFiles() {
    assertEquals(0, allFiles.size());
    assertEquals(new ArrayList<>(), visitAllMdFilesFileName.getList());
    allFiles.add(mdFile1);
    assertEquals(1, allFiles.size());
    allFiles.add(mdFile2);
    assertEquals(2, allFiles.size());
    allFiles.add(mdFile4);
    assertEquals(3, allFiles.size());
  }

  /**
   * tests that giving an invalid flag with throw an illegal argument exception
   */
  @Test
  void invalidFlag() {
    assertThrows(IllegalArgumentException.class,
        // .class refers to the type, not an instance of the IllegalArgumentException class
        () -> new VisitAllMdFiles("hello"));
  }

  /**
   * tests that the manually added arrayList is equal to the getList method
   */
  @Test
  void getList() {
    assertEquals(allFiles, visitAllMdFilesFileName.getList());
  }

  /**
   * tests that the individual files have been visited
   */
  @Test
  void visitFile() {

    try {
      assertEquals(FileVisitResult.CONTINUE,
          visitAllMdFilesCreated.visitFile(Path.of("sampleMd/file1.md"),
              Files.readAttributes(file1.toPath(), BasicFileAttributes.class)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      assertTrue(Files.readAttributes(file1.toPath(), BasicFileAttributes.class).isRegularFile());
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    try {
      assertEquals(FileVisitResult.CONTINUE,
          visitAllMdFilesCreated.visitFile(Path.of("sampleMd/file3.pdf"),
              Files.readAttributes(file3.toPath(), BasicFileAttributes.class)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * tests that nothing happens after visiting a directory
   */
  @Test
  void postVisitDirectory() {
    assertEquals(FileVisitResult.CONTINUE,
        visitAllMdFilesModified.postVisitDirectory(Path.of("sampleMd"), new IOException()));
  }

  /**
   * tests that nothing happens before visiting a directory
   */
  @Test
  void preVisitDirectory() {
    try {
      assertEquals(FileVisitResult.CONTINUE,
          visitAllMdFilesCreated.preVisitDirectory(Path.of("sampleMd"),
              Files.readAttributes(file1.toPath(), BasicFileAttributes.class)));
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }

  /**
   * tests if a file cannot be visited for some reason
   */
  @Test
  void visitFileFailed() {
    assertEquals(FileVisitResult.CONTINUE,
        visitAllMdFilesCreated.visitFileFailed(Path.of("sampleMd"), new IOException()));
  }


}

package cs3500.pa01;

import static org.junit.jupiter.api.Assertions.assertThrows;

import java.nio.file.FileSystemException;
import java.nio.file.Files;
import java.nio.file.Path;
import org.junit.jupiter.api.Test;
import writer.CompileAllFiles;

/**
 * represents tests for CompileAllFilesTest
 */
class CompileAllFilesTest {

  VisitAllMdFiles visitAllMdFiles = new VisitAllMdFiles("filename");
  CompileAllFiles fileWriter = new CompileAllFiles("sample/study.md", visitAllMdFiles);

  /**
   * tests that the file important phrases have all been added to the new file
   */
  @Test
  void writeFile() {

    assertThrows(FileSystemException.class,

        () -> Files.write(Path.of("sample/"), " ".getBytes()));

    fileWriter.writeFile();
  }
}
package writer;

import cs3500.pa01.MdFile;
import cs3500.pa01.VisitAllMdFiles;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

/**
 * reads all the files with all questions and important information
 */
public class CompileAllFiles {
  private final String outputPath;
  private final VisitAllMdFiles visitFiles;

  /**
   * represents the constructor
   */
  public CompileAllFiles(String outputPath, VisitAllMdFiles visitFiles) {
    this.outputPath = outputPath;
    this.visitFiles = visitFiles;
  }

  /**
   * Concat the file content of each file in the arrayList and writes it to a new file
   * which is then passed into 2 methods in order to separate the questions and information
   */
  public void writeFile() {
    StringBuilder concat = new StringBuilder();
    Path studyGuideFile;

    for (MdFile file : this.visitFiles.getList()) {
      concat.append(file.currFileContent());
    }

    String allContent = concat.toString();
    Path path = Path.of(outputPath);

    byte[] data = allContent.getBytes();

    try {
      //Files.write(path, data);
      studyGuideFile = Files.write(path, data);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
    //sends the file to CompressQuestionToFile to be filtered and only have questions left
    CompressQuestionToFile
        compressQuestionToFile = new CompressQuestionToFile(studyGuideFile, outputPath);
    compressQuestionToFile.readFileContent();

    //sends the file to WriteStudyGuide to be filtered and only important info left
    WriteStudyGuide writeStudyGuide = new WriteStudyGuide(studyGuideFile, outputPath);
    writeStudyGuide.writeFile();

  }
}
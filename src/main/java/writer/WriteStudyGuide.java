package writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

/**
 * Writes the important questions to a studyGuide markdown file
 */
public class WriteStudyGuide {

  private final Path file;
  private final String output;

  /**
   * represents the constructor
   */
  public WriteStudyGuide(Path file, String output) {
    this.file = file;
    this.output = output;
  }

  /**
   * Writes the important questions to a studyGuide markdown file
   */
  public void writeFile() {
    Scanner scan;
    try {
      scan = new Scanner(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    StringBuilder concat = new StringBuilder();

    //checks if each line DOESN'T have a question and if that is true, concat them
    while (scan.hasNextLine()) {
      String nextLine = scan.nextLine();
      if (!nextLine.contains(":::")) {
        concat.append(nextLine).append("\n");
      }
    }
    String allContent = concat.toString();
    Path path = Path.of(output);

    byte[] data = allContent.getBytes();

    try {
      Files.write(path, data);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }
  }
}

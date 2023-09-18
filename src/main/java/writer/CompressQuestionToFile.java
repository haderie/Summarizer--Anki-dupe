package writer;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * reads the combined file with questions and important info
 * writes the questions to a file
 */
public class CompressQuestionToFile {
  Path file;
  String output;
  ArrayList<String> foundQs = new ArrayList<>();

  /**
   * represents the constructor for compressing the questions to a file
   */
  public CompressQuestionToFile(Path file, String output) {
    this.file = file;
    this.output = output;
    readFileContent();
  }

  /**
   * reads the full given file, finds the questions, and writes it to a
   */
  public void readFileContent() {
    Scanner sc;
    try {
      sc = new Scanner(file);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    //checks if each line contains a question and if so, adds it to a new arrayList
    //in order to attach the default tag
    while (sc.hasNextLine()) {
      String nextLine = sc.nextLine();
      if (nextLine.contains(":::")) {
        foundQs.add(nextLine.substring(2));
      }
    }

    StringBuilder concat = new StringBuilder();

    //concat the list of questions into a stringBuilder
    for (int ind = 0; ind < foundQs.size() / 2; ind++) {
      concat.append("Hard[[" + foundQs.get(ind) + "]]").append("\n");
    }
    String allContent = concat.toString();
    Path path = Path.of(output.substring(0, output.length() - 2) + "sr");

    // Convert String to data for writing ("raw" byte data)
    byte[] data = allContent.getBytes();

    try {
      Files.write(path, data);

    } catch (IOException e) {
      throw new RuntimeException(e);
    }


  }

}
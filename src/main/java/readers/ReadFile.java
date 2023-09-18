package readers;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * represents the read file class
 */
public class ReadFile {
  private String currFileContent;

  ArrayList<String> foundBrackets = new ArrayList<>();


  /**
   * represents the constructor
   */
  public ReadFile(File file) {
    readFileContent(file);
  }

  /**
   * @return the important information of the current file
   */
  public String getCurrFileContent() {
    return currFileContent;

  }

  /**
   * reads the file content and stores the important phrases in a StringBuilder
   *
   * @param file the file that gets read by the method
   */
  public void readFileContent(File file) {
    Scanner sc;
    try { // The file may not exist, in which case we need to handle that error (hence try-catch)
      sc = new Scanner(file);
    } catch (FileNotFoundException e) {
      throw new RuntimeException(e);
    }
    StringBuilder content = new StringBuilder(); //stores all the important phrases
    String rest; //stores the rest of the line

    while (sc.hasNextLine()) { // Check there is another unread line in the file
      String nextLine = sc.nextLine();
      int openBrackInd = nextLine.indexOf("[[");
      int closedBrackInd = nextLine.indexOf("]]");
      boolean lnContOpen = nextLine.contains("[[");
      boolean lnContClosed = nextLine.contains("]]");

      if (nextLine.startsWith("#")) { //checks if line starts with #
        content.append("\n").append(nextLine).append("\n");
      }
      if (lnContClosed) { //if the line contains a closed bracket
        rest = nextLine.substring(closedBrackInd + 2);
        if (lnContOpen) { //both open and closed brackets
          foundBrackets.add(String.valueOf(
              content.append("- ").append(nextLine, openBrackInd + 2, closedBrackInd)
                  .append("\n")));
        }
        if (!lnContOpen) { //only has closed bracket
          foundBrackets.add(
              String.valueOf(content.append(nextLine, 0, (closedBrackInd)).append("\n")));
        }
        if (rest.contains("[[") && rest.contains("]]")) { //rest has both open and closed bracket
          foundBrackets.add(String.valueOf(
              content.append("- ").append(rest, rest.indexOf("[[") + 2, rest.indexOf("]]"))
                  .append("\n")));
        }
        if (rest.contains("[[") && !rest.contains("]]")) { //rest only has open bracket
          foundBrackets.add(
              String.valueOf(content.append("- ").append(rest.substring(rest.indexOf("[[") + 2))));
        }
      }
      if (lnContOpen && !lnContClosed) { //if line only has open bracket
        foundBrackets.add(
            String.valueOf(content.append("- ").append(nextLine.substring(openBrackInd + 2))));
      }
    }
    currFileContent = content.toString();
  }

}

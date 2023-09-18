package writer;

import cs3500.pa01.QuestionAnswerPair;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

/**
 * Updates the question bank after it has been initially written, and so,
 * the tag doesn't have to be defined here since it's already been defined initially
 */
public class UpdateQuestionFile {
  private final String outputPath;
  private final ArrayList<QuestionAnswerPair> visitQuestions;


  /**
   * represents the constructor
   */
  public UpdateQuestionFile(String outputPath, ArrayList<QuestionAnswerPair> visitQuestions) {
    this.outputPath = outputPath;
    this.visitQuestions = visitQuestions;
  }

  /**
   * Concat the file content of each file in the arrayList and writes it to a new file
   */
  public void writeQuestion() {

    StringBuilder concat = new StringBuilder();

    for (QuestionAnswerPair file : this.visitQuestions) {
      concat.append(file.getTag() + file.getBothQuestAndAnsw() + "\n");
    }

    String allContent = concat.toString();
    Path path = Path.of(outputPath);

    // Convert String to data for writing ("raw" byte data)
    byte[] data = allContent.getBytes();

    // The path may not exist, or we may not have permissions to write to it,
    // in which case we need to handle that error (hence try-catch)

    // Built-in convenience method for writing data to a file.
    try {
      Files.write(path, data);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

  }
}



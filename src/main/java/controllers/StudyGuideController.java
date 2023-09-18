package controllers;

import cs3500.pa01.VisitAllMdFiles;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import writer.CompileAllFiles;


/**
 * This is the main driver of this project.
 */
public class StudyGuideController implements Controller {

  String pathInp;

  String orderInp;

  String outputPath;

  /**
   * represents the constructor
   */
  public StudyGuideController(String pathInp, String orderInp, String outputPath) {
    this.pathInp = pathInp;
    this.orderInp = orderInp;
    this.outputPath = outputPath;
  }

  /**
   * Project entry point
   */
  public void run() {

    Path p = Path.of(pathInp);

    //example of VisitAllMdFiles
    VisitAllMdFiles visMdFiles = new VisitAllMdFiles(orderInp);

    //walks through each file
    try {
      Files.walkFileTree(p, visMdFiles);
    } catch (IOException e) {
      throw new RuntimeException(e);
    }

    CompileAllFiles compileFile = new CompileAllFiles(outputPath, visMdFiles);
    compileFile.writeFile();

  }
}
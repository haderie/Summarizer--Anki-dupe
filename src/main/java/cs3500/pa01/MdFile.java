package cs3500.pa01;

import java.io.File;
import java.nio.file.attribute.FileTime;
import readers.ReadFile;

/**
 * represents a markdown file
 */
public class MdFile {

  private final File file;
  private final String fileName;
  private final FileTime dateCreated;
  private final long dateModified;
  private String fileContent;

  MdFile(File file, String fileName, FileTime dateCreated, long dateModified) {
    this.file = file;
    this.fileName = fileName;
    this.dateCreated = dateCreated;
    this.dateModified = dateModified;
    this.fileContent = currFileContent();
  }

  /**
   * @return the fileName of the file
   */
  public String getFileName() {
    return fileName;
  }

  /**
   * @return the date created of the file
   */
  public FileTime getDateCreated() {
    return dateCreated;
  }

  /**
   * @return the date modified of the file
   */
  public long getDateModified() {
    return dateModified;
  }

  /**
   * gets the important content from the readFile class
   *
   * @return the important phrases
   */
  public String currFileContent() {
    ReadFile readFile = new ReadFile(file);
    fileContent = readFile.getCurrFileContent();
    return fileContent;
  }
}

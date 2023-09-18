package cs3500.pa01;

import static java.nio.file.FileVisitResult.CONTINUE;

import java.io.IOException;
import java.nio.file.FileVisitResult;
import java.nio.file.FileVisitor;
import java.nio.file.Path;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.Comparator;

/**
 * represents all the MD files in the directory and the fileWalker
 */
public class VisitAllMdFiles implements FileVisitor<Path> {
  private final ArrayList<MdFile> allFiles = new ArrayList<>();
  private Comparator<MdFile> order;
  private final String orderInp;

  public VisitAllMdFiles(String orderInp) {
    this.orderInp = orderInp;
    setOrder();
  }

  /**
   * sets the ordering flag based on the orderInp
   */
  private void setOrder() {
    switch (orderInp) {
      case "filename" -> this.order = new SortByName();
      case "created" -> this.order = new SortByCreated();
      case "modified" -> this.order = new SortByModified();
      default -> throw new IllegalArgumentException("ordering flag is not a valid input");
    }
  }

  /**
   * returns the arrayList of MdFiles
   *
   * @return the arrayList of MdFiles
   */
  public ArrayList<MdFile> getList() {
    return allFiles;
  }

  /**
   * called everytime the file system walker encounters a file
   *
   * @param file a reference to the file
   * @param attr the file's basic attributes
   * @return directive on how to process current item's siblings and children.
   */
  @Override
  public FileVisitResult visitFile(Path file, BasicFileAttributes attr) {
    String fileName = file.getFileName().toString();
    if (fileName.endsWith(".md") && attr.isRegularFile()) {
      this.allFiles.add(
          new MdFile(file.toFile(), fileName, attr.creationTime(), file.toFile().lastModified()));
      this.allFiles.sort(order);
    }
    return CONTINUE;
  }

  /**
   * What to do after processing all items in a directory
   *
   * @param dir  a reference to the directory
   * @param exec {@code null} if the iteration of the directory completes without
   *             an error; otherwise the I/O exception that caused the iteration
   *             of the directory to complete prematurely
   * @return in all cases, continue processing the sibling and child items of current item
   */
  @Override
  public FileVisitResult postVisitDirectory(Path dir, IOException exec) {
    System.out.format("Finishing Directory: %s%n", dir);

    return CONTINUE;
  }

  /**
   * What to do at the beginning of processing a directory
   *
   * @param dir   a reference to the directory
   * @param attrs the directory's basic attributes
   * @return a directive to continue processing siblings and children of current item.
   */
  @Override
  public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) {
    System.out.format("Starting Directory: %s%n", dir);
    return CONTINUE;
  }

  /**
   * called when a file cannot be visited for some undetermined reason (perhaps
   * locked by another process or an access permissions issue)
   *
   * @param file a reference to the file
   * @param exc  the I/O exception that prevented the file from being visited
   * @return Continues if there is no issue
   */
  @Override
  public FileVisitResult visitFileFailed(Path file, IOException exc) {
    System.err.println("IOException exception thrown");
    return CONTINUE;
  }


}



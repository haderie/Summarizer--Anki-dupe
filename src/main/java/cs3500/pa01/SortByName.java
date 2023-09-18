package cs3500.pa01;

import java.util.Comparator;

/**
 * represents a sorting by the file's name
 */
public class SortByName implements Comparator<MdFile> {

  /**
   * sorts the MdFile based on the file name
   *
   * @param o1 an MdFile
   * @param o2 an MdFile
   */
  @Override
  public int compare(MdFile o1, MdFile o2) {
    return o1.getFileName().compareTo(o2.getFileName());
  }
}

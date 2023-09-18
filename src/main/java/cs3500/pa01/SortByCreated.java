package cs3500.pa01;

import java.util.Comparator;

/**
 * represents a sorting by the file's created date
 */
public class SortByCreated implements Comparator<MdFile> {

  /**
   * sorts the MdFile based on the date created
   *
   * @param o1 an MdFile
   * @param o2 an MdFile
   */
  @Override
  public int compare(MdFile o1, MdFile o2) {
    return o1.getDateCreated().compareTo(o2.getDateCreated());
  }
}

package cs3500.pa01;

import java.util.Comparator;

/**
 * represents a sorting by the file's last modified date
 */
public class SortByModified implements Comparator<MdFile> {

  /**
   * sorts the MdFile based on the last modified date
   *
   * @param o1 an MdFile
   * @param o2 an MdFile
   */
  @Override
  public int compare(MdFile o1, MdFile o2) {
    return Long.compare(o1.getDateModified(), o2.getDateModified());
  }
}


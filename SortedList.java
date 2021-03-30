/**
 * @Author: Parsa Rahimi <par5ul1>
 * @Date:   2021-03-12T14:33:36-08:00
 * @Filename: SortedList.java
 * @Last modified by:   par5ul1
 * @Last modified time: 2021-03-12T15:08:54-08:00
 */

public​​ interface​ SortedList<T extends Comparable<T>> {

  public boolean add(T item);

  public T remove(int pos);

  public T get(int pos);

  public int size();

}

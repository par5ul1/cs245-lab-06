/**
 * @Author: Parsa Rahimi <par5ul1>
 * @Date:   2021-03-12T14:38:04-08:00
 * @Filename: SortedArrayList.java
 * @Last modified by:   par5ul1
 * @Last modified time: 2021-03-29T18:34:43-07:00
 */

public class SortedArrayList<T extends Comparable<T>> implements SortedList<T> {

  protected T[] a;
  protected int size;

  public SortedArrayList() { // Constructor
    a = (T[]) new Comparable[16];
    size = 0;
  }

  public boolean add(T item) {
    // Make sure there's enough space to do things:
    if (this.size == this.a.length) { // Can't be greater. If they're equal, then there's no more empty space
      grow_array();
    }

    int i = 0; // Find the index for where we should insert the new item
    while (this.a[i] != null && item.compareTo(this.a[i]) >= 0) { // While the item is greater than or equal to the current item in the list...
      i++; // Increment i
    }

    // Shift values around:
    for (int j = this.size; j > i; j--) {
      this.a[j] = this.a[j-1]; // Shift values to the right, and increment i
    }

    this.a[i] = item; // Place the item
    this.size++; // Increment the size
    return true;
  }

  public T get(int pos) {

    if (pos < 0 || pos >= size) { // Verify bounds
      throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
    }

    return this.a[pos]; // Return item at position

  }

  public T remove(int pos) {

    T item = this.get(pos); // This will handle bound checking for us too.

    // Shift values around:
    for (int i = pos; i < size-1; i++) { // Starting at the removal position...
      this.a[i] = this.a[i+1]; // Move right values over to the left
    }

    size--; // The above leaves a duplicate value to the right of the last item but decrementing size means it should never be accessed.
    return item;

  }

  public int size() {
    return this.size;
  }

  public String toString() {
      String result = "[";
      for(int i=0; i < this.size-1; i++) {
          result = result + a[i] + ",";
      }
      return result+a[size-1]+"]";
  }

  private void grow_array() { //doubles size of array

    T[] a = (T[]) new Object[this.a.length * 2]; // Create a new array with double the size

    for (int i = 0; i < this.a.length; i++) { // Copy over the values
      a[i] = this.a[i];
    }

    this.a = a; // Replace the original array

  }

}

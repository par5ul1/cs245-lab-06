/**
 * @Author: Parsa Rahimi <par5ul1>
 * @Date:   2021-03-12T14:38:04-08:00
 * @Filename: SortedArrayList.java
 * @Last modified by:   par5ul1
 * @Last modified time: 2021-03-29T22:22:24-07:00
 */

public class SortedLinkedList<T extends Comparable<T>> implements SortedList<T> {

  protected int size;
  protected Node head;

  public SortedLinkedList() { // Constructor

    head = new Node(null);
    size = 0;

  }

  public boolean add(T item) {

    Node current = new Node(item); // Create the node we want to add
    Node prev = this.head; // Start at the beginning

    while (prev.next != null && current.data.compareTo(prev.next.data) >= 0) { // While the item is greater than or equal to the current item in the list...
      prev = prev.next; // Walk the list
    }

    current.next = prev.next;
    prev.next = current; // Place the item
    this.size++; // Increment the size
    return true;

  }

  public T get(int pos) {
    if (pos < 0 || pos >= size) { // Verify bounds
      throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
    }

    Node prev = this.head;
    for (int i = 0; i < pos+1; i++) { // We need to travel up pos+1 since because we ignore the dummy head
      prev = prev.next;
    }

    return (T) prev.data; // Return item at position (Manually have to cast Comparable to T)
  }

  public T remove(int pos) {
    if (pos < 0 || pos >= size) { // Verify bounds
      throw new ArrayIndexOutOfBoundsException("Index out of bounds.");
    }

    Node prev = this.head;
    for (int i = 0; i < pos-1; i++) { // Only walk up to the node we want to unlink
      prev = prev.next;
    }

    Node current = prev.next; // Get the node we want to remove
    prev.next = current.next; // Remove the reference from the previous to current
    this.size--; // Decrement the size
    return (T) current.data; // Return the removed item (Manually have to cast Comparable to T)
  }

  public int size() {
    return this.size;
  }

  public String toString() {
      String result = "[";
      Node prev = this.head;
      for (int i = 0; i < this.size-1; i++) { // Only add size-1 items
        prev = prev.next;
        result = result + prev.data + ",";
      }
      return result+prev.next.data+"]"; // Add the last item and the closing bracket
  }

  private class Node<T extends Comparable<T>> {

    private T data;
    private Node next;

    private Node(T data) {
      this.data = data; // Why ruin a good name when you can just use 'this'
      this.next = null;
    }

  }

}

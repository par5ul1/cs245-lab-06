/**
 * @Author: Parsa Rahimi <par5ul1>
 * @Date:   2021-03-05T14:54:25-08:00
 * @Filename: Test.java
 * @Last modified by:   par5ul1
 * @Last modified time: 2021-03-29T22:26:17-07:00
 */

public class Test
{
    /**
     * Main function to run tests
     * @param args command arg line
     */
    public static void main(String[] args) //change to test code
    {

        SortedArrayList<String> arrayList = new SortedArrayList<String>(); // Array List
        System.out.println("\nTesting Array List: ");
        test(arrayList);

        SortedLinkedList<String> linkedList = new SortedLinkedList<String>(); // Linked List
        System.out.println("\nTesting Array List: ");
        test(linkedList);

    }

    private static void test(SortedList a) {

      String ANSI_RESET = "\u001B[0m";
      String ANSI_RED = "\u001B[31m";
      String ANSI_GREEN = "\u001B[32m";
      String ANSI_YELLOW = "\u001B[33m";

      System.out.println(ANSI_YELLOW+"Testing empty at start..."+ANSI_RESET);
      System.out.print("\t");
      System.out.println(a.size() == 0 ? ANSI_GREEN+"list is empty at the start\n"+ANSI_RESET : ANSI_RED+"list is not empty at the start\n"+ANSI_RESET);

      System.out.println(ANSI_YELLOW+"Testing add()..."+ANSI_RESET);
      a.add("b");
      a.add("l");
      a.add("a");
      a.add("1");

      System.out.print("\t");
      System.out.println(a.toString().equals("[1,a,b,l]") ? ANSI_GREEN+"add() passes\n"+ANSI_RESET : ANSI_RED+"add() fails\n"+ANSI_RESET);

      System.out.println(ANSI_YELLOW+"Testing get()..."+ANSI_RESET);
      System.out.print("\t");
      System.out.println(a.get(1).equals("a") ? ANSI_GREEN+"get() passes\n"+ANSI_RESET : ANSI_RED+"get() fails\n"+ANSI_RESET);

      System.out.println(ANSI_YELLOW+"Testing remove()..."+ANSI_RESET);
      System.out.print("\t");
      System.out.println(a.remove(0).equals("1") ? ANSI_GREEN+"remove() returns the correct value"+ANSI_RESET : ANSI_RED+"remove() returns the incorrect value"+ANSI_RESET);
      System.out.print("\t");
      System.out.println(a.toString().equals("[a,b,l]") ? ANSI_GREEN+"remove() passes\n"+ANSI_RESET : ANSI_RED+"remove() fails\n"+ANSI_RESET);

      System.out.println(ANSI_YELLOW+"Testing size()..."+ANSI_RESET);
      System.out.print("\t");
      System.out.println(a.size() == 3 ? ANSI_GREEN+"size() passes\n"+ANSI_RESET : ANSI_RED+"size() fails\n"+ANSI_RESET);

      System.out.println(ANSI_YELLOW+"Testing out of bounds operation..."+ANSI_RESET);
      try {
        System.out.println(a.get(a.size()));
        System.out.print("\t");
        System.out.println(ANSI_RED+"Exception was not thrown."+ANSI_RESET);
      } catch(Exception e) {
        System.out.print("\t");
        System.out.println(ANSI_GREEN+"Exception was thrown."+ANSI_RESET);
      }
    }
}

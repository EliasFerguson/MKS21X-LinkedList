import java.util.*;
public class MyLinkedList {
 private int size;
 private Node start,end;
 public MyLinkedList() {
   size = 0;
   start = null;
   end = null;
 }
 public int size() {
   return size;
 }
 public boolean add(Integer value) {
   if (size == 0) {
     Node adder = new Node(value, null, null);
     end = adder;
     start = adder;
   }
   else {
     Node adder = new Node(value, end, null);
     end = adder;
     adder.prev().setNext(adder);
  }
  size++;
  return true;
 }
 public String toString() {
   int counter = 0;
   Node current = start;
   String output = "[";
   if (size == 0) {
     return "[]";
   }
   while (counter < size - 1) {
     output += current.toString() + ", ";
     current = current.next();
     counter++;
   }
   return output + current.toString() + "]";
  }
  public Integer get(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    int counter = 0;
    Node current = start;
    while (index != counter) {
      current = current.next();
      counter++;
    }
    return current.getData();
  }
  public Integer set(int index, Integer value) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    int counter = 0;
    Node current = start;
    while (index != counter) {
      current = current.next();
      counter++;
    }
    return current.setData(value);
   }
  public boolean contains(Integer value) {
    Node current = start;
    while (current != null) {
      if (current.getData() == value) {
        return true;
      }
      else {
        current = current.next();
      }
    }
    return false;
  }
  public int indexOf(Integer value) {
    Node current = start;
    int counter = 0;
    while (current != null) {
      if (current.getData() == value) {
        return counter;
      }
      else {
        current = current.next();
        counter++;
      }
    }
    return -1;
  }
  public void add(int index, Integer value) {
    if (index < 0 || index > size) {
      throw new IndexOutOfBoundsException();
    }
    if (index == size) {
      add(value);
    }
    else if (index == 0) {
      Node adder = new Node(value, null, start);
      start = adder;
      adder.next().setPrev(adder);
      size++;
    }
    else {
      int counter = 0;
      Node current = start;
      while (counter != index) {
        current = current.next();
        counter++;
      }
      Node adder = new Node(value, current.prev(), current);
      adder.prev().setNext(adder);
      adder.next().setPrev(adder);
      size++;
    }
  }
  public Integer remove(int index) {
    if (index < 0 || index >= size) {
      throw new IndexOutOfBoundsException();
    }
    Integer returner = get(index);
    Node current = start;
    int counter = 0;
    while (counter != index) {
      counter++;
      current = current.next();
    }
    if (index == 0) {
      start = current.next();
      current.next().setPrev(null);
    }
    else if (index == size - 1) {
      end = current.prev();
      current.prev().setNext(null);
    }
    else {
      current.next().setPrev(current.prev());
      current.prev().setNext(current.next());
    }
    size--;
    return returner;
  }
  public boolean remove(Integer value) {
    Node current = start;
    int counter = 0;
    boolean needsFinding = true;
    while (needsFinding && current != null) {
      if (current.getData().equals(value)) {
        needsFinding = false;
      }
      else {
        current = current.next();
        counter++;
      }
    }
    if (needsFinding) {
      return false;
    }
    remove(counter);
    return true;
  }
  public void extend(MyLinkedList other) {
    Node otherStart = other.start;
    Node otherEnd = other.end;
    end.setNext(otherStart);
    otherStart.setPrev(end);
    end = otherEnd;
    size += other.size();
    MyLinkedList spare = new MyLinkedList();
    other.start = spare.start;
    other.end = spare.end;
    other.size = spare.size;

  }
  private class Node {
   private int data;
   private Node next,prev;
   private Node(int num, Node nPrev, Node nNext) {
     data = num;
     next = nNext;
     prev = nPrev;
   }
   private Node next() {
     return next;
   }
   private Node prev() {
     return prev;
   }
   private void setNext(Node other) {
     next = other;
   }
   private void setPrev(Node other) {
     prev = other;
   }
   private Integer getData() {
     return data;
   }
   private Integer setData(Integer i) {
    Integer old = data;
    data = i;
    return old;
   }
   public String toString() {
     return "" + getData();
   }
  }
  public static void main(String[] args) {
    MyLinkedList test = new MyLinkedList();
    test.add(5);
    test.add(4);
    test.add(3);
    test.add(2);
    test.add(1);
    System.out.println(test.toString());
    test.add(0, 6);
    test.add(5, 0);
    test.add(3, 1000);
    System.out.println(test.toString());
    test.remove(0);
    test.remove(6);
    System.out.println(test.toString());
    Integer remover = new Integer(1000);
    test.remove(remover);
    System.out.println(test.toString());
  }
}

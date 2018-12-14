class MyLinkedList {
 private int size;
 private Node start,end;
 public MyLinkedList() {
   size = 0;
 }
 public int size() {
   return size;
 }
 public boolean add(Integer value) {
   if (size == 0) {
     start = new Node(value);
     end = start;
   }
   else {
    end = new Node(value);
    size++;
  }
  return true;
 }
 public String toString() {
   Node current = start;
   String output = "[";
   while (current != null) {
     output += current.toString() + ", ";
     current = current.next();
   }
   return output + "]";
  }
  public Integer get(int index) {
    int counter = 0;
    Node current = start;
    while (index != counter) {
      current = current.next();
      counter++;
    }
    return current.getData();
  }
  public Integer set(int index, Integer value) {
    int counter = 0;
    Node current = start;
    while (index != counter) {
      current = current.next();
      counter++;
    }
    return current.setData(value);
   }
  public boolean contains(Integer value) {

  }
  public int indexOf(Integer value) {

  }
  public void add(int index, Integer value) {

  }
  public Integer remove(int index) {

  }
  public boolean remove(Integer value) {

  }
  private Node findNode(int index) {

  }
  private class Node {
   private int data;
   private Node next,prev;
   private Node(int num) {
     data = num;
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
}

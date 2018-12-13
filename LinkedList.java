class MyLinkedList {
 private int size;
 private Node start,end;
 public MyLinkedList() {
   size = 0;
 }
 public int size() {
   return size;
 }
 public boolean add(int value) {
   end = new Node(value);
   size++;
   return true;
 }
 public String toString() {
   return "help me";
 }
}

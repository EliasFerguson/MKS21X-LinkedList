class Node {
 private int data;
 private Node next,prev;
 public Node(int num) {
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
 public Integer getData() {
   return data;
 }
 public Integer setData(Integer i) {
  Integer old = data;
  data = i;
  return old;
 }
 public String toString() {
   return "" + getData();
 }
}

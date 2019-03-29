
class MyLinkedList{
  //Fields
 private int length;
 private Node start,end;

 //Constructor
 public MyLinkedList(){
   length = 0;
   start = null;
   end = null;
 }


 public boolean add(int value){
   if (length == 0){
     end = new Node(value, null, null);
     start = end;
     length++;
   }
   else {
     Node temp = new Node(value, null, end);
     end.setNext(temp);
     end = temp;
     length++;
   }
   return true;
 }

 public String toString(){
   Node current = start;
   String out = "[";
   while (current != null){
     out += current + "";
     if (current.next() != null) out += ", ";
     current = current.next();
   }
   out += "]";
   return out;
 }

   public void extend(MyLinkedList other){
      end.setNext(other.start);
      length += other.length;
      other.length = 0;
      other.start = null;
      other.end = null;
    }

 //Node class
 private class Node{
  private int data;
  private Node next,prev;

  public Node(int datain, Node nextin, Node previn){
    data = datain;
    next = nextin;
    prev = previn;
  }

   public Node next(){
     return next;
   }
   public Node prev(){
     return prev;
   }
   public void setNext(Node other){
     next = other;
   }
   public void setPrev(Node other){
     prev = other;
   }
   public Integer getData(){
     return data;
   }
   public Integer setData(Integer i){
     int temp = data;
     data = i;
     return temp;
   }
   public String toString(){
     return "" + data;
   }
 }

}

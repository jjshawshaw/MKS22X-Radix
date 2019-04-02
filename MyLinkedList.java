
class MyLinkedList<E>{
  //Fields
 private int length;
 private Node<E> start,end,current;

 //Constructor
 public MyLinkedList(){
   length = 0;
   start = null;
   end = null;
   current = start;
 }

 public void clear(){
   length = 0;
   start = null;
   end = null;
 }

 public E next(){
   Node<E> temp = current;
   current = current.next();
   return temp.getData();
 }

 public boolean hasNext(){
   return current != null;
 }


 public boolean add(E value){
   if (length == 0){
     end = new Node<E>(value, null, null);
     start = end;
     length++;
     current = start;
   }
   else {
     Node<E> temp = new Node<E>(value, null, end);
     end.setNext(temp);
     end = temp;
     length++;
   }
   return true;
 }

 public String toString(){
   Node<E> current = start;
   String out = "[";
   while (current != null){
     out += current + "";
     if (current.next() != null) out += ", ";
     current = current.next();
   }
   out += "]";
   return out;
 }

   public void extend(MyLinkedList<E> other){
      end.setNext(other.start);
      length += other.length;
      other.length = 0;
      other.start = null;
      other.end = null;
    }

 //Node class
 private class Node<E>{
  private E data;
  private Node<E> next,prev;

  public Node(E datain, Node<E> nextin, Node<E> previn){
    data = datain;
    next = nextin;
    prev = previn;
  }

   public Node<E> next(){
     return next;
   }
   public Node<E> prev(){
     return prev;
   }
   public void setNext(Node<E> other){
     next = other;
   }
   public void setPrev(Node<E> other){
     prev = other;
   }
   public E getData(){
     return data;
   }
   public E setData(E i){
     E temp = data;
     data = i;
     return temp;
   }
   public String toString(){
     return "" + data;
   }
 }

}

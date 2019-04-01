public class Driver{
  public static void main(String[] args){
    MyLinkedList<Integer> L = new MyLinkedList<Integer>();
    L.add(1);
    L.add(2);
    L.add(3);
    System.out.println(L);
    while (L.hasNext()){
      System.out.println(L.next());
    }
  }
}

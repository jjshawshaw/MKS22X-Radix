
public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    boolean running = true;
    int dig = 10;
    while (running){
      System.out.println("dig: " + dig);
      running = false;
      for (int i : data){
        if (Math.abs(i) > dig * 10) running = true;
        if (i >= 0) buckets[i%dig + 10].add(i);
        else buckets[9 - i%dig].add(i);
      }
      for (int i = 0; i < 20; i++){
        System.out.println("bucket " + i + " : " + buckets[i]);
      }
      dig *= 10;
    }
  }

  public static void main(String[] args){
    radixsort(new int[] {12, -31, 24, -42, 2, -1, 14, -21});
  }
}

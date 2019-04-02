import java.util.*;
public class Radix{
  public static void radixsort(int[]data){
    @SuppressWarnings("unchecked")
    MyLinkedList<Integer>[] buckets = new MyLinkedList[20];
    for (int i = 0; i < 20; i++){
      buckets[i] = new MyLinkedList<Integer>();
    }
    int count = 0;
    for (int i : data){
      int num = (int)Math.log10(Math.abs(i));
      if (num > count) count = num;
    }
    int dig = 10;
    for (int i : data){
      if (i >= 0) buckets[i%dig + 10].add(i);
      else buckets[9 + i%dig].add(i);
    }
    for (int i = 0; i < 20; i++){
        System.out.println("bucket " + i + " : " + buckets[i]);
      }
    while (count > 0){
      fillBuckets(buckets, dig);
      dig *= 10;
      count--;
    }
    for (int i = 0; i < 20; i++){
        System.out.println("bucket " + i + " : " + buckets[i]);
      }
  }

  public static void fillBuckets(MyLinkedList<Integer>[] buckets, int dig){
    MyLinkedList<Integer> all = new MyLinkedList<Integer>();
    for (MyLinkedList<Integer> bucket : buckets){
      all.extend(bucket);
    }
    while (all.hasNext()){
      int nextInt = all.next();
      if (nextInt >= 0) buckets[nextInt%dig + 10].add(nextInt);
      else buckets[9 - nextInt%dig].add(nextInt);
    }
  }

  public static void main(String[] args){
    radixsort(new int[] {12, -31, 24, -42, 2, -1, 14, -21});
  }
}

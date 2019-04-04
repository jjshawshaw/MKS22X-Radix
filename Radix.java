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
      if (i > count) count = i;
    }
    count = (int)Math.log10(Math.abs(count));
    int dig = 10;
    for (int i : data){
      if (i >= 0) buckets[i%dig + 10].add(i);
      else buckets[9 + i%dig].add(i);
    }
    MyLinkedList<Integer> all = new MyLinkedList<Integer>();
    while (count > 0){
      dig *= 10;
      fillBuckets(buckets, dig, all);
      count--;
    }
    all.clear();
    for (MyLinkedList<Integer> bucket : buckets){
      all.extend(bucket);
    }
    for (int i = 0; i < data.length; i++){
      data[i] = all.next();
    }
  }

  public static void fillBuckets(MyLinkedList<Integer>[] buckets, int dig, MyLinkedList<Integer> all){
    all.clear();
    for (MyLinkedList<Integer> bucket : buckets){
      all.extend(bucket);
    }
    while (all.hasNext()){
      int nextInt = all.next();
      if (nextInt >= 0) buckets[nextInt%dig/(dig / 10) + 10].add(nextInt);
      else buckets[9 + nextInt%dig/(dig / 10)].add(nextInt);
    }
  }

  public static void main(String[] args){
    System.out.println("Size\t\tMax Value\tquick/builtin ratio ");
    int[]MAX_LIST = {1000000000,500,10};
    for(int MAX : MAX_LIST){
      for(int size = 31250; size < 2000001; size*=2){
        long qtime=0;
        long btime=0;
        //average of 5 sorts.
        for(int trial = 0 ; trial <=5; trial++){
          int []data1 = new int[size];
          int []data2 = new int[size];
          for(int i = 0; i < data1.length; i++){
            data1[i] = (int)(Math.random()*MAX);
            data2[i] = data1[i];
          }
          long t1,t2;
          t1 = System.currentTimeMillis();
          Radix.radixsort(data2);
          t2 = System.currentTimeMillis();
          qtime += t2 - t1;
          t1 = System.currentTimeMillis();
          Arrays.sort(data1);
          t2 = System.currentTimeMillis();
          btime+= t2 - t1;
          if(!Arrays.equals(data1,data2)){
            System.out.println("FAIL TO SORT!");
            System.exit(0);
          }
        }
        System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime);
      }
      System.out.println();
    }
  }
}

package com.bianjq.perf.chapter01;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jqbian on 2017-03-30.
 * 
 * @author jqbian
 */
public class LoopPerf {
  private static  int loopSize=50000000;
   ArrayList<Integer> testList = null;
  public static void main(String args[]){
    LoopPerf loopPerf=new LoopPerf();
    loopPerf.testList=loopPerf.prepareData(loopSize);
    long[] result2=new long[4];
    for(int index=0;index<10;index++) {
      System.out.println("-------------");
      result2[0]+=loopPerf.forEachLoop();
      result2[1]+=loopPerf.indexLoop();
      result2[2]+=loopPerf.forLoop();
      result2[3]+=loopPerf.iteratorLoop();
    }
    for(int index=0;index<result2.length;index++){
      System.out.println(result2[index]);
    }
  }

  public ArrayList<Integer> prepareData(int loopSize) {
    ArrayList list = new ArrayList<>(loopSize);
    for (int index = 0; index < loopSize; index++) {
      list.add(index);
    }
    System.out.println("prepareData finished");
    return list;
  }

  public  long indexLoop(){
    //ArrayList<Integer> list = prepareData(loopSize);
    long start=System.currentTimeMillis();
    for(int index=0;index<testList.size();index++){
      Integer temp=testList.get(index);
      temp.toString();
    }
    long end=System.currentTimeMillis();
    System.out.println("indexLoop Time="+(end-start));
    return (end-start);
  }

  public long forLoop(){
    //ArrayList<Integer> list = prepareData(loopSize);
    long start=System.currentTimeMillis();
    for(Integer s:testList){
      s.toString();
    }
    long end=System.currentTimeMillis();
    long result = end-start;
    System.out.println("forLoop Time="+result);
    return result;
  }

  private long iteratorLoop(){
    //List<Integer> a = prepareData(loopSize);
    long start=System.currentTimeMillis();
    for (Iterator iterator = testList.iterator();iterator.hasNext();)
    {
      Integer integer = (Integer) iterator.next();
      integer.toString();
    }
    long end=System.currentTimeMillis();
    long result = end-start;
    System.out.println("iteratorLoop Time="+result);
    return result;
  }

  private long forEachLoop(){
    //List<Integer> a = prepareData(loopSize);
    long start=System.currentTimeMillis();
    testList.forEach(item->item.toString());
    long end=System.currentTimeMillis();
    long result = end-start;
    System.out.println("forEachLoop Time="+result);
    return  result;
  }
}

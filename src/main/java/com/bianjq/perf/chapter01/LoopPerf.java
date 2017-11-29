package com.bianjq.perf.chapter01;

import java.util.ArrayList;

/**
 * Created by jqbian on 2017-03-30.
 * 
 * @author jqbian
 */
public class LoopPerf {
  private static  int loopSize=5000000;

  public static void main(String args[]){
    LoopPerf loopPerf=new LoopPerf();
    loopPerf.indexLoop();
    loopPerf.forLoop();
  }

  public ArrayList<String> prepareData(int loopSize) {
    ArrayList list = new ArrayList<>(loopSize);
    for (int index = 0; index < loopSize; index++) {
      list.add("index" + index);
    }
    return list;
  }

  public void indexLoop(){
    ArrayList<String> list = prepareData(loopSize);
    long start=System.currentTimeMillis();
    for(int index=0;index<list.size();index++){
      String str=list.get(index);
    }
    long end=System.currentTimeMillis();
    System.out.println("indexLoop Time="+(end-start));
  }

  public void forLoop(){
    ArrayList<String> list = prepareData(loopSize);
    long start=System.currentTimeMillis();
    for(String s:list){

    }
    long end=System.currentTimeMillis();
    System.out.println("forLoop Time="+(end-start));
  }
}

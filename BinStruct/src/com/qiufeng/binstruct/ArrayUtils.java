package com.qiufeng.binstruct;
import java.util.*;

public class ArrayUtils
{
	public void push(Object o,Object[] arr){
		arr=Arrays.copyOf(arr,arr.length+1);
		arr[arr.length-1]=o;
	}
}

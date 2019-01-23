package com.qiufeng.binstruct;
import java.util.*;

public class ArrayUtils
{
	public static Object[] push(Object o,Object[] arr){
		arr=Arrays.copyOf(arr,arr.length+1);
		arr[arr.length-1]=o;
		return arr;
	}
	public static byte[] cutFromDataObj(DataObj arg){
		byte[] part=new byte[arg.blen];
		System.arraycopy(arg.all,arg.index,part,0,arg.blen);
		return part;
	}
	public static void pop(Object[] obj){
		obj=Arrays.copyOfRange(obj,0,obj.length-1);
	}
}

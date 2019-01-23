package com.qiufeng.binstruct;

public class DebugLogger
{
	public static boolean DEBUG=true;
	public static void println(Object obj){
		if(DEBUG){
			System.out.println(obj);
		}
	}
}

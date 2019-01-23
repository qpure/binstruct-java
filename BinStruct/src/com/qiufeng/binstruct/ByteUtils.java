package com.qiufeng.binstruct;
import java.util.*;

public class ByteUtils
{
	public static int toInt(byte[] bts){
		int bits=0;
		int res=0;
		byte[] rev=new byte[bts.length];
		for(int i=bts.length;i>0;i--){
			rev[i-1]=bts[bts.length-i];
		}
		for(byte b : rev){
			//normal range of a byte is between -128 to 127,so +128 to get unsigned number.
			int bunsigned=b+128;
			res+=bunsigned<<bits;
			bits+=8;
		}
		DebugLogger.println(res+"("+Integer.toBinaryString(res));
		return res;
	}
}

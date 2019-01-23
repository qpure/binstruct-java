package com.qiufeng.binstruct;
import java.lang.reflect.*;
import java.util.*;

public interface DoFunction<Arg,Return>
{
	public Return proc(Arg arg)
	public static DoFunction<DataObj,byte[]> doDefault=new DoFunction<DataObj,byte[]>(){
		@Override
		public byte[] proc(DataObj arg){
			return ArrayUtils.cutFromDataObj(arg);
		}
	};
	public static DoFunction<DataObj,Integer> doFlagDefault=new DoFunction<DataObj,Integer>(){
		@Override
		public Integer proc(DataObj arg){
			byte[] bts=ArrayUtils.cutFromDataObj(arg);
			int res=ByteUtils.toInt(bts);
			return res;
		}
	};
	public static DoFunction<CompareObj,Boolean> checkDefault=new DoFunction<CompareObj,Boolean>(){
		@Override
		public Boolean proc(CompareObj arg){
			//use equals not == for String comparation
			DebugLogger.println("all:"+new String(arg.all)+",cut="+new String((byte[])arg.key));
			DebugLogger.println("all class="+arg.all.getClass().getName()+",key class="+arg.key.getClass().getName());
			boolean b=arg.key.equals(arg.all)||arg.key==arg.all;
			if(arg.key.getClass().isArray()&&arg.all.getClass().isArray()){
				b=Arrays.equals(arg.all,(byte[])arg.key);
			}
			DebugLogger.println(b);
			return b;
		}
	};
}

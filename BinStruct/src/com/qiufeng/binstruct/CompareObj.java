package com.qiufeng.binstruct;

public class CompareObj<K> extends DataObj
{
	K key;
	public CompareObj(int blen,int index,byte[] all,K key){
		super(blen,index,all);
		this.key=key;
	}
	
}

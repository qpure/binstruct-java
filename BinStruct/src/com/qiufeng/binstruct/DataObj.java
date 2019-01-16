package com.qiufeng.binstruct;

/*
	stores data passed in DoFunction
*/
public class DataObj
{
	int blen,index;
	byte[] all;

	public DataObj(int blen, int index, byte[] all){
		this.blen = blen;
		this.index = index;
		this.all = all;
	}
}

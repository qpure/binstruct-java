package com.qiufeng.binstruct.step;

public class DataStep extends Step
{
	Object data;
	public DataStep(Object data){
		super(0,null);
		this.data=data;
	}

	@Override
	public Object check(byte[] all, int index){
		// TODO: Implement this method
		return data;
	}
	
}

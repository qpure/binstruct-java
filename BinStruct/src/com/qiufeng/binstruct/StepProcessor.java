package com.qiufeng.binstruct;

import com.qiufeng.binstruct.step.*;

public class StepProcessor
{
	Step[] steps={};
	Object[] ret={};
	byte[] input=new byte[0];
	public int byteIndex=0;
	
	public StepProcessor(){
		this(new Step[]{});
	}
	public StepProcessor(Step[] steps){
		this.steps=steps;
	}
	public Object[] doStep(Step s){
		Object[] retarr={};
		s.check(input,byteIndex);
		return retarr;
	}
}

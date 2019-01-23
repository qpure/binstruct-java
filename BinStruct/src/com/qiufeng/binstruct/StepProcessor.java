package com.qiufeng.binstruct;

import com.qiufeng.binstruct.step.*;

public class StepProcessor
{
	public Step[] steps={};
	Object[] ret={};
	byte[] input=new byte[0];
	public int byteIndex=0;
	public Object[] stepIndex={0};
	
	public StepProcessor(){
		this(new Step[]{});
	}
	public StepProcessor(Step[] steps){
		this.steps=steps;
	}
	public void setInput(byte[] in){
		input=in;
	}
	public void addStep(Step s){
		steps=(Step[])ArrayUtils.push(s,steps);
	}
	public void removeStep(Step s){
		
	}
	public Object[] process(){
		DebugLogger.println("hi");
		
		Object[] retarr=new Object[]{};
		//DID this to adapt GOTO step
		while((int)stepIndex[0]<steps.length){
			DebugLogger.println("processing "+steps[(int)stepIndex[0]]);
			retarr=ArrayUtils.push(doStep(steps[(int)stepIndex[0]]),retarr);
			stepIndex[0]=(int)stepIndex[0]+1;
		}
		return retarr;
	}
	public Object doStep(Step s){
		Object ret;
		s.processor=this;
		DebugLogger.println("Currently processing:"+s);
		ret=s.check(input,byteIndex);
		return ret;
	}
	public Step getCurrent(){
		Step s=null;
		for(Object i : stepIndex){
			if(s==null){
				s=steps[(int)i];
				continue;//skip rest below.
			}
			if(s instanceof ContainerStep){
				s=((ContainerStep)s).get(i);
			}else{
				//cannot get a value from a non-ContainerStep.
				throw new UnsupportedOperationException();
			}
		}
		return s;
	}
	public void setCurrent(Object ind){
		stepIndex[stepIndex.length-1]=ind;
	}
	public void addNextSlope(Object obj){
		ArrayUtils.push(obj,stepIndex);
	}
	public void quitSlope(){
		DebugLogger.println(stepIndex.length);
		ArrayUtils.pop(stepIndex);
	}
	public void skipToSlope(Object[] index){
		stepIndex=index;
	}
}

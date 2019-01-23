package com.qiufeng.binstruct.step;

import com.qiufeng.binstruct.*;

public class Step
{
	int blen=0;
	public StepProcessor processor;
	public ContainerStep parent;
	DoFunction<DataObj,? extends Object> dofunc=DoFunction.doDefault;
	public Step(int blen,
				DoFunction<DataObj,? extends Object> dofunc){
		this.blen=blen;
		if(dofunc!=null)
			this.dofunc=dofunc;
	}
	public Object check(byte[] all,int index){
		processor.byteIndex+=blen;
		return dofunc.proc(new DataObj( blen,
									   index,
									   all));
	}

	@Override
	public String toString(){
		// TODO: Implement this method
		return getClass().getName()+" blen="+blen;
	}
	
}

package com.qiufeng.binstruct;

public class Step
{
	int blen=0;
	DoFunction<DataObj,Object> dofunc=DoFunction.dfault;
	public Step(int blen,
				DoFunction<DataObj,Object> dofunc){
			this.blen=blen;
			if(dofunc!=null)
				this.dofunc=dofunc;
	}
	public Object check(byte[] all,int index){
		return dofunc.proc(new DataObj( blen,
										index,
										all));
	}
}

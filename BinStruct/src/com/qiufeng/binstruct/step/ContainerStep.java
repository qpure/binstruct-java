package com.qiufeng.binstruct.step;
import com.qiufeng.binstruct.*;

public abstract class ContainerStep extends Step
{
	public ContainerStep(DoFunction<DataObj,Object> dofunc){
		super(0,dofunc);
	}
	public abstract Step get(Object obj)
}

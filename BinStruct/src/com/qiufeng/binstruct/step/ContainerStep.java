package com.qiufeng.binstruct.step;
import com.qiufeng.binstruct.*;

public abstract class ContainerStep<K> extends Step
{
	public ContainerStep(int blen,DoFunction<DataObj,Object> dofunc){
		super(blen,dofunc);
	}
	public abstract Step get(K key);
	public abstract void set(K key,Step value);
}

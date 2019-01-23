package com.qiufeng.binstruct.step;
import com.qiufeng.binstruct.*;
import java.util.*;

public class FlagStep extends ContainerStep<Integer>
{
	public HashMap<Integer,Step> flags;
	DoFunction<DataObj,Integer> dofunc=DoFunction.doFlagDefault;
	public FlagStep(int blen,DoFunction<DataObj,Integer> dofunc){
		super(blen,dofunc);
		if(dofunc!=null)
			this.dofunc=dofunc;
		flags=new HashMap<>();
	}
	
	@Override
	public Object check(byte[] all, int index){
		// TODO: Implement this method
		processor.byteIndex+=blen;
		int flag=dofunc.proc(new DataObj(blen,index,all));
		Object[] returns=new Object[0];
		for(Map.Entry<Integer,Step> me : flags.entrySet()){
			Integer fb=me.getKey();
			if((flag&fb)!=0){
				Step s=me.getValue();
				processor.addNextSlope(fb);
				returns=ArrayUtils.push(processor.doStep(s),returns);
				processor.quitSlope();
			}
		}
		return returns;
	}
	
	public void generateFlags(Step[] ss){
		int val=1;
		for(Step s : ss){
			set(val,s);
			val<<=1;
		}
	}
	public void generateFlags(int num){
		Step[] retsteps=new Step[0];
		for(int i=0;i<num;i++){
			retsteps=(Step[])ArrayUtils.push(new DataStep(i),retsteps);
		}
		generateFlags(retsteps);
	}

	@Override
	public void set(Integer key, Step value){
		// TODO: Implement this method
		flags.put(key,value);
	}

	@Override
	public Step get(Integer key){
		// TODO: Implement this method
		return flags.get(key);
	}
}

package com.qiufeng.binstruct.step;
import java.util.*;
import com.qiufeng.binstruct.*;

public class SwitchStep<K> extends ContainerStep<K>
{
	HashMap<K,Step> switches;
	DoFunction<CompareObj,Boolean> checkfunc=DoFunction.checkDefault;
	DoFunction<DataObj,byte[]> dofunc=DoFunction.doDefault;
	public SwitchStep(int blen,DoFunction<DataObj,byte[]> dofunc,DoFunction<CompareObj,Boolean> checkfunc){
		super(blen,dofunc);
		//just to ensure that parent class and child class both have same attr value.
		//This is not waste!!!
		if(dofunc!=null)
			this.dofunc=dofunc;
		if(checkfunc!=null)
			this.checkfunc=checkfunc;
		switches=new HashMap<K,Step>();
	}

	@Override
	public Object check(byte[] all, int index){
		//cut the part that belongs to This step.
		processor.byteIndex+=blen;
		byte[] cut=dofunc.proc(new DataObj(blen,index,all));
		DebugLogger.println("cut bytes:"+new String(cut));
		Object[] ret=new Object[0];
		for(Map.Entry<K,Step> me : switches.entrySet()){
			K key=me.getKey();
			DebugLogger.println("SwitchStep processing "+new String((byte[])key)+",val="+me.getValue());
			if(checkfunc.proc(new CompareObj<K>(blen,index,cut,key))){
				//add a slope.
				DebugLogger.println("matched.");
				processor.addNextSlope(key);
				ret=ArrayUtils.push(processor.doStep(get(key)),ret);
				processor.quitSlope();
			}
		}
		return ret;
	}
	

	@Override
	public void set(K key, Step value){
		value.parent=this;
		switches.put(key,value);
	}

	@Override
	public Step get(K key){
		return switches.get(key);
	}


	
}

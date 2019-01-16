package com.qiufeng.binstruct;

public interface DoFunction<Arg,Return>
{
	public Return proc(Arg arg)
	public static DoFunction<DataObj,Object> dfault=new DoFunction<DataObj,Object>(){

		@Override
		public Object proc(DataObj arg){
			// TODO: Implement this method
			byte[] part=new byte[arg.blen];
			System.arraycopy(arg.all,arg.index,part,0,arg.blen);
			return part;
		}
	};
}

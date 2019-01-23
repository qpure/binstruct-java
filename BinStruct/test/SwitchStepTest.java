
import com.qiufeng.binstruct.*;
import com.qiufeng.binstruct.step.*;
import java.util.*;
public class SwitchStepTest extends TestContainer
{

	public static void main(String[] args){
		//System.out.println("hellodude");
		new SwitchStepTest().run(args);
	}
	@Override
	public void run(String[] args){
		//System.out.println("hi");
		// TODO: Implement this method
		byte[] allbts=new byte[]{56,78,90,12,34};
		byte[] bts=new byte[]{56,78};
		DebugLogger.println("hello");
		StepProcessor sp=new StepProcessor();
		sp.setInput(allbts);
		SwitchStep ss=new SwitchStep<byte[]>(2,null,null);
		ss.set(bts,new DataStep("hi"));
		sp.addStep(ss);
		Step st=new Step(3,null);
		sp.addStep(st);
		DebugLogger.println(Arrays.deepToString(sp.steps));
		Object[] ret=sp.process();
		print(ret);
		DebugLogger.println(Arrays.deepToString(ret));
	}
	void print(Object[] objs){
		for(Object o : objs){
			if(o instanceof Object[])
				print((Object[])o);
			else
				System.out.println(o);
		}
	}
}

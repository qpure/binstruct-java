
import com.qiufeng.binstruct.*;
import com.qiufeng.binstruct.step.*;
import java.util.*;
public class FlagStepTest extends TestContainer
{

	@Override
	public void run(String[] args){
		// TODO: Implement this method
		byte[] all={64,64,27};
		StepProcessor sp=new StepProcessor();
		sp.setInput(all);
		FlagStep fs=new FlagStep(2,null);
		fs.generateFlags(16);
		DebugLogger.println(Arrays.deepToString(fs.flags.keySet().toArray()));
		sp.addStep(fs);
		Object[] res=sp.process();
		for(Object o : res){
			Object[] oo=(Object[])o;
			for(int ooo : oo){
				DebugLogger.println(Integer.toBinaryString(1<<ooo));
			}
		}
		DebugLogger.println(Arrays.deepToString(res));
	}
	
}

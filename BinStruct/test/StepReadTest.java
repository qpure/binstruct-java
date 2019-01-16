
import com.qiufeng.binstruct.*;
public class StepReadTest extends TestContainer
{
	
	byte[] bts="hello world!".getBytes();
	public StepReadTest(){
		shouldThrowErr=true;
	}
	@Override
	public void run(String[] args){
		// TODO: Implement this method
		Step step=new Step(5,null);
		assert new String((byte[])step.check(bts,2))=="llo w";
		System.out.println("Assertion Passed.This is meant NOT to cause an error.");
		System.out.println("The following below IS meant to cause an error.");
		System.out.println(new String((byte[])step.check(bts,9)));
	}
	
}

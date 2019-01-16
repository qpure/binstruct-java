public class MainTest extends TestContainer
{
	Class<? extends TestContainer>[] testClasses={
		StepReadTest.class
	};
	public static void main(String[] args){
		new MainTest().run(args);
	}
	@Override
	public void run(String[] args){
		int succ=0,fail=0;
		for(Class<? extends TestContainer> cls : testClasses){
			System.out.println("------------------TEST------------------");
			System.out.println("Test "+cls.getName()+" started.");
			TestContainer instance=null;
			try{
				instance=cls.newInstance();
			}catch(Throwable e){
				System.out.println("Test "+cls.getName()+" cannot be initialised.");
				fail++;
				continue;
			}
			try{
				System.out.println("This test should"+(instance.shouldThrowErr?"":" not")+" throw error");
				instance.run(args);
				if(instance.shouldThrowErr)
					fail++;
				else
					succ++;
				System.out.println("-----------------SUCCESS----------------");
			}catch(Throwable e){
				if(instance.shouldThrowErr)
					succ++;
				else
					fail++;
				System.out.println("---------------ERROR--------------");
				System.out.println("ERROR from test "+cls.getName()+":");
				e.printStackTrace();
				System.out.println("------------------FAILED----------------");
			}
		}
		System.out.println("Tests Ended.Success:"+succ+",Failed:"+fail);
	}
}

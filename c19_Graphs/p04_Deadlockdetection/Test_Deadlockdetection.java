package c19_Graphs.p04_Deadlockdetection;
import static java.lang.System.out;

import java.util.List;

import util.MyGraphVertex;
public class Test_Deadlockdetection {

	public static void main(String[] args) {
		
		{
			out.println("-----------graph01");
			List<MyGraphVertex> graph01 = MyGraphVertex.getGraph01();
			MyGraphVertex.printGraph( graph01 );
			
			out.println("has cycle? " + Deadlockdetection.isDeadLocked( graph01 ) );
			MyGraphVertex.printGraph( graph01 );
			
			
		}
		
		{
			out.println("-----------graph02");
			List<MyGraphVertex> graph02 = MyGraphVertex.getGraph02();
			MyGraphVertex.printGraph( graph02 );
			
			out.println("has cycle? " + Deadlockdetection.isDeadLocked( graph02 ) );
			MyGraphVertex.printGraph( graph02 );
		}
		
		{
			out.println("-----------graph03");
			List<MyGraphVertex> graph03 = MyGraphVertex.getGraph03();
			MyGraphVertex.printGraph( graph03 );
			
			out.println("has cycle? " + Deadlockdetection.isDeadLocked( graph03 ) );
			MyGraphVertex.printGraph( graph03 );
		}
		
		{
			out.println("-----------graph04");
			List<MyGraphVertex> graph04 = MyGraphVertex.getGraph04();
			MyGraphVertex.printGraph( graph04 );
			
			out.println("has cycle? " + Deadlockdetection.isDeadLocked( graph04 ) );
			MyGraphVertex.printGraph( graph04 );
		}
	}

}



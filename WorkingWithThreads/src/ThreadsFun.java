import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;


public class ThreadsFun {
	
	final static int maxPoints = 100_000;
	final static int maxRange = 10_000;
	
	static List<Point> generatePoints(){
		
		List<Point> points = new ArrayList<Point>();
		Random rand = new Random();
		
		for(int i = 0; i < maxPoints ; ++i){
			points.add(new Point(rand.nextInt(maxRange), rand.nextInt(maxRange)));
		}
		return points;
	}
	
	static void doCalculations(List<Point> generatedPoints,
			int indexFrom, int indexTo, Map<Point, Point> outMap){
		
		for (int i = indexFrom; i < indexTo; i++) {
			Point curPoint = generatedPoints.get(i);
			Point nearest = curPoint;
			for (int j = 0; j < generatedPoints.size(); j++) {
				Point testPoint = generatedPoints.get(j);
				if(curPoint != testPoint){
					if(curPoint == nearest){
						nearest = testPoint;
					}
					else{
						if(curPoint.distance(nearest) > curPoint.distance(testPoint))
							nearest = testPoint;
					}
				}
			}
			outMap.put(curPoint, nearest);
		}
	}
	
	static Map<Point, Point> getNearestPoint(final List<Point> generatedPoints){
		
		
		final Map<Point, Point> outMap = Collections.synchronizedMap(new HashMap<Point, Point>());
		
		Thread secThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				doCalculations(generatedPoints, maxPoints/4+1, maxPoints/2, outMap);
			}	
			
		});
		
		Thread thirdThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				doCalculations(generatedPoints, maxPoints/2+1, 3*maxPoints/4, outMap);
			}
		});
		
		Thread forthThread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				doCalculations(generatedPoints, 3*maxPoints/4+1, maxPoints, outMap);
			}
		});
		
		secThread.start();
		thirdThread.start();
		forthThread.start();
		
		doCalculations(generatedPoints, 0, maxPoints/4, outMap);
		
		try {
			secThread.join();
			thirdThread.join();
			forthThread.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		return outMap;
	}
	
	public static void main(String[] args) {
		
		
		long start = System.currentTimeMillis();
		System.out.println("Strated at " + start);
		getNearestPoint(generatePoints());
		long end = System.currentTimeMillis();
		System.out.println("Ended at - " + end);
		System.out.println("Took - " + (end-start));		
	}
}

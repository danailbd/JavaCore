package com.danailbd.hackbulgaria;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ListUtility {
	
	public static List<Integer> sort(List<Integer> unsortedArray){
		
		List<Integer> sortedArray = new ArrayList<>();
		sortedArray.addAll(0, unsortedArray);
		Collections.sort(sortedArray);
		return sortedArray;
	}

	public static List<Integer> reverse(List<Integer> list) {
		
		List<Integer> revList = new ArrayList<>(list);
		Collections.reverse(revList);
		
		return revList;
	}
	
	public static boolean isMonotonous(List<Integer> list) {

		return list.equals(sort(list)) || list.equals(reverse(sort(list)));
	}
}

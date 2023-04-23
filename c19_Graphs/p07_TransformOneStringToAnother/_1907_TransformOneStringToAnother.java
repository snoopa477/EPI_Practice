package c19_Graphs.p07_TransformOneStringToAnother;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class _1907_TransformOneStringToAnother {

	private static class StringWithDistance {
		public String candidatestring;
		public Integer distance;

		public StringWithDistance(String candidatestring, Integer distance) {
			this.candidatestring = candidatestring;
			this.distance = distance;
		}
	}


	
	// Uses BFS to find the least steps of transformation.
	public static int transformstring(Set<String> D, String s, String t) {
		Queue<StringWithDistance> q = new LinkedList<>();

		D.remove(s); // Marks s as visited by erasing it in D.
		q.add(new StringWithDistance(s, 0));
		StringWithDistance f;
		
		
		while ((f = q.poll()) != null) {
			// Returns if we find a match.
			if (f.candidatestring.equals(t)) {
				return f.distance; // Number of steps reaches t.
			}

			
			// Tries all possible transformations of f.first.
			String str = f.candidatestring;
			for (int i = 0; i < str.length(); ++i) {
				String strStart = i == 0 ? "" : str.substring(0, i);
				String strEnd = i + 1 < str.length() ? str.substring(i + 1) : "";
				
				for (int j = 0; j < 26; ++j) {// Iterates through 'a' ~ 'z'.
					String modStr = strStart + (char) ('a' + j) + strEnd;
					if (D.remove(modStr)) {
						q.add(new StringWithDistance(modStr, f.distance + 1));
					}
				}
			}

		}
		return -1; // Cannot find a possible transformations.
	}
}

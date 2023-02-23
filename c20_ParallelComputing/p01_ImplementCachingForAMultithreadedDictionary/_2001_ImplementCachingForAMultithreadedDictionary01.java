package c20_ParallelComputing.p01_ImplementCachingForAMultithreadedDictionary;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _2001_ImplementCachingForAMultithreadedDictionary01 {

	public static class UnsafeSpellCheckService extends SpellCheckService {
		private static final int MAX_ENTRIES = 3;
		private static LinkedHashMap<String, String[]> cachedClosestStrings = new LinkedHashMap<String, String[]>() {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > MAX_ENTRIES;
			}
		};

		public static void service(ServiceRequest req, ServiceResponse resp) {
			String w = req.extractWordToCheckFromRequest();
			if (cachedClosestStrings.containsKey(w)) {
				resp.encodeIntoResponse(cachedClosestStrings.get(w));
				return;
			}
			String[] closestToLastWord = Spell.closestlnDictionary(w);
			cachedClosestStrings.put(w, closestToLastWord);
		}

	}
}

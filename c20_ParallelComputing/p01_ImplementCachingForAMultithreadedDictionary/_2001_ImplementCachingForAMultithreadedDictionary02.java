package c20_ParallelComputing.p01_ImplementCachingForAMultithreadedDictionary;

import static java.lang.System.out;

import java.util.LinkedHashMap;
import java.util.Map;

public class _2001_ImplementCachingForAMultithreadedDictionary02 {

	public static class SafeSpellCheckService extends SpellCheckService {
		private static final int MAX_ENTRIES = 3;
		private static LinkedHashMap<String, String[]> cachedClosestStrings = new LinkedHashMap<String, String[]>() {
			protected boolean removeEldestEntry(Map.Entry eldest) {
				return size() > MAX_ENTRIES;
			}
		};

		public static void service(ServiceRequest req, ServiceResponse resp) {
			String w = req.extractWordToCheckFromRequest();
			synchronized (S2Alternative.class) {
				if (cachedClosestStrings.containsKey(w)) {
					resp.encodeIntoResponse(cachedClosestStrings.get(w));
					return;
				}
			}
			String[] closestToLastWord = Spell.closestlnDictionary(w);
			synchronized (S2Alternative.class) {
				cachedClosestStrings.put(w, closestToLastWord);
			}
		}

	}
}

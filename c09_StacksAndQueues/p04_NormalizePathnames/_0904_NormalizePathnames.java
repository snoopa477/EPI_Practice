package c09_StacksAndQueues.p04_NormalizePathnames;

import static java.lang.System.out;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;

public class _0904_NormalizePathnames {

	public static String shortestEquivalentPath(String path) {
		if (path.equals("")) {
			throw new IllegalArgumentException("Empty string is not a legal path.");
		}
		Deque<String> pathNames = new LinkedList<>();
// Special case: starts with which is an absolute path.
		if (path.startsWith("/")) {
			pathNames.addFirst("/");
		}
		for (String token : path.split("/")) {
			if (token.equals("..")) {
				if (pathNames.isEmpty() || pathNames.peekFirst().equals("..")) {
					pathNames.addFirst(token);
				} else {
					if (pathNames.peekFirst().equals("/")) {
						throw new IllegalArgumentException("Path error, trying to go up root " + path);
					}
					pathNames.removeFirst();
				}

			} else if (!token.equals(".") && !token.isEmpty()) {// Must be a name.
				pathNames.addFirst(token);
			}
		}
		StringBuilder result = new StringBuilder();
		if (!pathNames.isEmpty()) {
			Iterator<String> it = pathNames.descendingIterator();
			String prev = it.next();
			result.append(prev);
			while (it.hasNext()) {
				if (!prev.equals("/")) {
					result.append("/");
				}
				prev = it.next();
				result.append(prev);
			}
		}
		return result.toString();
	}
}

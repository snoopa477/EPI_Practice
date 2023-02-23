package c15_BinarySearchTrees.p13_AddCredits;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;

public class _1513_AddCredits {

	public static class ClientsCreditsInfo {
		private int offset = 0;
		private Map<String, Integer> clientToCredit = new HashMap<>();
		private NavigableMap<Integer, Set<String>> creditToClients = new TreeMap<>();

		public void insert(String clientID, int c) {
			remove(clientID);
			clientToCredit.put(clientID, c - offset);
			Set<String> set = creditToClients.get(c - offset);
			if (set == null) {
				set = new HashSet<>();
				creditToClients.put(c - offset, set);

			}

			set.add(clientID);

		}

		public boolean remove(String clientID) {
			Integer clientCredit = clientToCredit.get(clientID);
			if (clientCredit != null) {
				creditToClients.get(clientCredit).remove(clientID);
				if (creditToClients.get(clientCredit).isEmpty()) {

					creditToClients.remove(clientCredit);

				}
				clientToCredit.remove(clientID);
				return true;

			}
			return false;

		}

		public int lookup(String clientID) {
			Integer clientCredit = clientToCredit.get(clientID);
			return clientCredit == null ? -1 : clientCredit + offset;
		}

		public void addAll(int C) {
			offset += C;
		}

		public String max() {
			return creditToClients.isEmpty() ? "" : creditToClients.lastEntry().getValue().iterator().next();
		}

	}

}

package c14_Sorting.p08_TeamPhotoday_01;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class _1408_TeamPhotoday_01 {

	class Player implements Comparable<Player> {
		public Integer height;

		public Player(Integer h) {
			height = h;
		}

		@Override
		public int compareTo(Player that) {
			return Integer.compare(height, that.height);

		}

	}

	class Team {
		public Team(List<Integer> height) {
			players = new ArrayList<Player>(height.size());
			for (int i = 0; i < height.size(); ++i) {
				players.add(new Player(height.get(i)));
			}
		}

// Checks if A can be placed in front of B.
		public boolean validPlacementExists(Team A, Team B) {
			List<Player> ASorted = A.sortPlayersByHeight();
			List<Player> BSorted = B.sortPlayersByHeight();
			for (int i = 0; i < ASorted.size() && i < BSorted.size(); ++i) {
				if (ASorted.get(i).compareTo(BSorted.get(i)) >= 0) {
					return false;
				}
			}
			return true;
		}

		private List<Player> sortPlayersByHeight() {
			List<Player> sortedPlayers = new ArrayList<Player>(players);
			Collections.sort(sortedPlayers);
			return sortedPlayers;
		}

		private List<Player> players;

	}
}

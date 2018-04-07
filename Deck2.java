package blackjack2;

import java.util.*;

public class Deck2 {
	public void put(Object key, Object value) {
		Map<Integer, String> map = new HashMap<Integer, String>();
		map.put(2, "Kettõ");
		map.put(3, "Három");
		map.put(4, "Négy");
		map.put(5, "Öt");
		map.put(6, "Hat");
		map.put(7, "Hét");
		map.put(8, "Nyolc");
		map.put(9, "Kilenc");
		map.put(10, "Tíz");
		map.put(10, "Bubi");
		map.put(10, "Dáma");
		map.put(10, "Király");
		map.put(10, "Ász");

		Set<Integer> keys = map.keySet();
		Integer[] arr = keys.toArray(new Integer[0]);

		for (Map.Entry m : map.entrySet()) {
		}

		List<Integer> keys1 = new ArrayList<Integer>(map.keySet());
		Collections.shuffle(keys1);
		for (Object o : keys1) {
			// Access keys/values in a random order
			map.get(o);
		}
	}
}
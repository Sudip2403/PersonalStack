package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LongQueue {

	public static void main(String[] args) {
		String[][] a = {
				{ "mpividy1/THB/THB/THB/THB/fanafody/atody/THB/T-Shirt/peluche",
						"mpividy2/cheddar/vary/menaka/siramamy/sira/atody/jambon/akoho/voasary",
						"mpividy3/totokena/yaourt/vovon-dronono/biscuit/ovy",
						"mpividy3/savony/vovon-dronono/yaourt/yaourt/yaourt/ovy/henakisoa/ody moka/shampoing" },
				/*
				 * {
				 * "mpividy1/THB/THB/THB/THB/fanafody/atody/THB/T-Shirt/peluche",
				 * "mpividy2/cheddar/vary/menaka/siramamy/sira/atody/jambon/akoho",
				 * "mpividy3/totokena/yaourt/vovon-dronono/biscuit/ovy",
				 * "mpividy4/savony/vovon-tsavony/henakisoa/ody moka/ovy/shampoing"
				 * , "mpividy4/henakisoa/ody moka/ody moka/savony" },
				 */
				{ "mpividy1/ovy/ovy/karaoty/paoma/karaoty/paoma/anana/anana/sira" } };
		String f = "ovy/karaoty/voasary/paoma/anana";
		System.out.println(new LongQueue().longQueue(a, f));
	}

	String longQueue(String[][] a, String f) {
		String[] v = f.split("/");
		String[] p = new String[v.length];
		for (int i = 0; i < v.length; i++)
			p[i] = v[i];
		Arrays.sort(p);
		List<Integer> c = new ArrayList<>();
		int t = Integer.MAX_VALUE;
		for (int i = 0; i < a.length; i++) {
			Map<String, String> z = new HashMap<>();
			for (int j = 0; j < a[i].length; j++) {
				String q = a[i][j].substring(0, a[i][j].indexOf("/"));
				String b = z.get(q);
				if (b == null)
					b = "";
				z.put(q, b + a[i][j].substring(a[i][j].indexOf("/"), a[i][j].length()));
			}
			int r = 0;
			for (Map.Entry<String, String> h : z.entrySet()) {
				String[] q = h.getValue().split("/");
				Map<String, Integer> m = new HashMap<>();
				int u = 0;
				for (int k = 1; k < q.length; k++) {
					Integer o = m.get(q[k]);
					if (o == null)
						o = 0;
					m.put(q[k], o + 1);
				}
				for (Map.Entry<String, Integer> e : m.entrySet())
					u += (Arrays.binarySearch(p, e.getKey()) < 0 ? 1 : 10) + (e.getValue() > 1 ? 1 : 0);

				r += u;
			}

			if (r == t)
				c.add(i + 1);
			else if (r < t) {
				c = new ArrayList<>();
				c.add(i + 1);
				t = r;
			}
			System.out.println((i + 1) + " -> " + r);
		}
		String g = "";
		for (Integer i : c)
			g += i + " or ";
		return g.substring(0, g.length() - 4);
	}

}

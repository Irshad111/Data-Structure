package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Graph {
	private class Vertex {
		HashMap<String, Integer> nbrs = new HashMap<>();

	}

	HashMap<String, Vertex> vtces = new HashMap<>();

	public int numVertex() {
		return vtces.size();

	}

	public boolean containVertex(String vname) {
		return vtces.containsKey(vname);

	}

	public void addVertex(String vname) {
		Vertex nv = new Vertex();
		vtces.put(vname, nv);

	}

	public void removeVertex(String vname) {
		if (!vtces.containsKey(vname)) {
			return;
		}
		Vertex vts = vtces.get(vname);
		for (String key : vts.nbrs.keySet()) {
			Vertex vtxnbr = vtces.get(key);
			vtxnbr.nbrs.remove(vname);

		}
		vtces.remove(vname);

	}

	public int numEdges() {
		int count = 0;
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			Vertex nbrvtx = vtces.get(key);
			count += nbrvtx.nbrs.size();
		}
		return count / 2;

	}

	public boolean containEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return false;
		}
		return true;

	}

	public void addEdge(String vname1, String vname2, int cost) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.put(vname2, cost);
		vtx2.nbrs.put(vname1, cost);

	}

	public void removeEdge(String vname1, String vname2) {
		Vertex vtx1 = vtces.get(vname1);
		Vertex vtx2 = vtces.get(vname2);
		if (vtx1 == null || vtx2 == null || !vtx1.nbrs.containsKey(vname2)) {
			return;
		}
		vtx1.nbrs.remove(vname2);
		vtx2.nbrs.remove(vname1);

	}

	public void display() {
		System.out.println("--------------");
		ArrayList<String> keys = new ArrayList<>(vtces.keySet());
		for (String key : keys) {
			Vertex vtx = vtces.get(key);
			System.out.println(key + " -> " + vtx.nbrs);
		}
		System.out.println("----------------");

	}

	public boolean hasPath(String vname1, String vname2, HashMap<String, Boolean> processed) {

		processed.put(vname1, true);

		if (containEdge(vname1, vname2)) {
			return true;
		}
		Vertex vtx = vtces.get(vname1);
		ArrayList<String> nbrs = new ArrayList<>(vtx.nbrs.keySet());
		for (String nbr : nbrs) {
			if (!processed.containsKey(nbr) && hasPath(nbr, vname2, processed)) {
				return true;
			}

		}
		return false;

	}

	private class Pair {
		String vname;
		String psf;// path so far
	}

	public boolean bfs(String src, String dest) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();

		// make 1st pair & add to q
		Pair np = new Pair();
		np.vname = src;
		np.psf = src;
		q.addLast(np);

		while (!q.isEmpty()) {
			Pair rp = q.removeFirst();
			// if alrady processed a pair then continue
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			// processed put if we visit
			processed.put(rp.vname, true);

			// if direct edge b/w src & dest. then return true
			if (containEdge(rp.vname, dest)) {
				System.out.println(rp.psf + dest);
				return true;
			}
			// for remove pair nbres
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			// get each nbr
			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair npair = new Pair();
					npair.vname = nbr;
					npair.psf = rp.psf + nbr;
					q.addLast(npair);
				}

			}

		}
		return false;

	}

	public boolean dfs(String src, String dest) {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> s = new LinkedList<>();

		// make 1st pair & add to stack
		Pair np = new Pair();
		np.vname = src;
		np.psf = src;
		s.addFirst(np);

		while (!s.isEmpty()) {
			Pair rp = s.removeFirst();
			// if alrady processed a pair then continue
			if (processed.containsKey(rp.vname)) {
				continue;
			}
			// processed put if we visit
			processed.put(rp.vname, true);

			// if direct edge b/w src & dest. then return true
			if (containEdge(rp.vname, dest)) {
				System.out.println(rp.psf + dest);
				return true;
			}
			// for remove pair nbres
			Vertex rpvtx = vtces.get(rp.vname);
			ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
			// get each nbr
			for (String nbr : nbrs) {
				if (!processed.containsKey(nbr)) {
					Pair npair = new Pair();
					npair.vname = nbr;
					npair.psf = rp.psf + nbr;
					s.addFirst(npair);
				}

			}

		}
		return false;

	}

	// in bft we cover each & every node of graph
	// even if graph is disconnected
	public void bft() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		// for all nodes
		for (String key : vtces.keySet()) {
			// in bft we cover all nodes if graph are disconnected so
			// we use this if condition
			if (processed.containsKey(key)) {
				continue;
			}
			// create a new pair
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			q.addLast(np);

			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();
				// if alrady processed a pair then continue
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				// processed put if we visit
				processed.put(rp.vname, true);

				// sys
				System.out.println(rp.vname + " via " + rp.psf);
				// for remove pair nbres
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				// get each nbr
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair npair = new Pair();
						npair.vname = nbr;
						npair.psf = rp.psf + nbr;
						q.addLast(npair);
					}

				}

			}
		}

	}

	public void dft() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> s = new LinkedList<>();
		// for all nodes
		for (String key : vtces.keySet()) {
			// in bft we cover all nodes if graph are disconnected so
			// we use this if condition
			if (processed.containsKey(key)) {
				continue;
			}
			// create a new pair
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			s.addFirst(np);

			while (!s.isEmpty()) {
				Pair rp = s.removeFirst();
				// if alrady processed a pair then continue
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				// processed put if we visit
				processed.put(rp.vname, true);

				// sys
				System.out.println(rp.vname + " via " + rp.psf);
				// for remove pair nbres
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				// get each nbr
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair npair = new Pair();
						npair.vname = nbr;
						npair.psf = rp.psf + nbr;
						s.addFirst(npair);
					}

				}

			}
		}

	}

	public boolean isCyclic() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		// for all nodes
		for (String key : vtces.keySet()) {
			// in bft we cover all nodes if graph are disconnected so
			// we use this if condition
			if (processed.containsKey(key)) {
				continue;
			}
			// create a new pair
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			q.addLast(np);

			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();
				// if alrady processed a pair then retuen true
				if (processed.containsKey(rp.vname)) {
					return true;
				}
				// processed put if we visit
				processed.put(rp.vname, true);

				// for remove pair nbres
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				// get each nbr
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair npair = new Pair();
						npair.vname = nbr;
						npair.psf = rp.psf + nbr;
						q.addLast(npair);
					}

				}

			}
		}
		return false;

	}

	public boolean isConnected() {
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		// for all nodes
		int flag = 0;
		for (String key : vtces.keySet()) {
			// in bft we cover all nodes if graph are disconnected so
			// we use this if condition
			if (processed.containsKey(key)) {
				continue;
			}
			flag++;
			// create a new pair
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			q.addLast(np);

			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();
				// if alrady processed a pair then continue
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				// processed put if we visit
				processed.put(rp.vname, true);

				// for remove pair nbres
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				// get each nbr
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair npair = new Pair();
						npair.vname = nbr;
						npair.psf = rp.psf + nbr;
						q.addLast(npair);
					}

				}

			}
		}
		if (flag >= 2) {
			return false;
		} else {
			return true;
		}

	}

	public boolean isTree() {
		return !isCyclic() && isConnected();
	}

	public ArrayList<ArrayList<String>> getConnectedComponents() {

		ArrayList<ArrayList<String>> ans = new ArrayList<>();
		HashMap<String, Boolean> processed = new HashMap<>();

		LinkedList<Pair> q = new LinkedList<>();
		// for all nodes
		for (String key : vtces.keySet()) {
			// in bft we cover all nodes if graph are disconnected so
			// we use this if condition

			if (processed.containsKey(key)) {
				continue;
			}

			ArrayList<String> subans = new ArrayList<>();
			// create a new pair
			Pair np = new Pair();
			np.vname = key;
			np.psf = key;
			q.addLast(np);

			while (!q.isEmpty()) {
				Pair rp = q.removeFirst();
				// if alrady processed a pair then continue
				if (processed.containsKey(rp.vname)) {
					continue;
				}
				// put in subans
				subans.add(rp.vname);
				// processed put if we visit
				processed.put(rp.vname, true);

				// for remove pair nbres
				Vertex rpvtx = vtces.get(rp.vname);
				ArrayList<String> nbrs = new ArrayList<>(rpvtx.nbrs.keySet());
				// get each nbr
				for (String nbr : nbrs) {
					if (!processed.containsKey(nbr)) {
						Pair npair = new Pair();
						npair.vname = nbr;
						npair.psf = rp.psf + nbr;
						q.addLast(npair);
					}

				}

			}
			// put subans in ans
			ans.add(subans);
		}
		return ans;

	}

}

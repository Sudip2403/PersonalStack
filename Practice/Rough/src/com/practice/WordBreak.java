package com.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WordBreak {

	public static void main(String[] args) {
		String s1 = "catssandog";
		String[] w1 = { "cats", "dog", "sand", "and", "cat", "" };

		String s2 = "bbz";
		String[] w2 = { "a", "b", "bbb", "bbbb" };

		String s3 = "abcd";
		String[] w3 = { "a", "abc", "b", "cd" };

		String s4 = "aaaaa";//aa";
		String[] w4 = { "aaaa", "aa" };

		String s5 = "fohhemkkaecojceoaejkkoedkofhmohkcjmkggcmnami";
		String[] w5 = { "kfomka", "hecagbngambii", "anobmnikj", "c", "nnkmfelneemfgcl", "ah", "bgomgohl", "lcbjbg",
				"ebjfoiddndih", "hjknoamjbfhckb", "eioldlijmmla", "nbekmcnakif", "fgahmihodolmhbi", "gnjfe", "hk", "b",
				"jbfgm", "ecojceoaejkkoed", "cemodhmbcmgl", "j", "gdcnjj", "kolaijoicbc", "liibjjcini", "lmbenj",
				"eklingemgdjncaa", "m", "hkh", "fblb", "fk", "nnfkfanaga", "eldjml", "iejn", "gbmjfdooeeko",
				"jafogijka", "ngnfggojmhclkjd", "bfagnfclg", "imkeobcdidiifbm", "ogeo", "gicjog", "cjnibenelm",
				"ogoloc", "edciifkaff", "kbeeg", "nebn", "jdd", "aeojhclmdn", "dilbhl", "dkk", "bgmck",
				"ohgkefkadonafg", "labem", "fheoglj", "gkcanacfjfhogjc", "eglkcddd", "lelelihakeh", "hhjijfiodfi",
				"enehbibnhfjd", "gkm", "ggj", "ag", "hhhjogk", "lllicdhihn", "goakjjnk", "lhbn", "fhheedadamlnedh",
				"bin", "cl", "ggjljjjf", "fdcdaobhlhgj", "nijlf", "i", "gaemagobjfc", "dg", "g", "jhlelodgeekj",
				"hcimohlni", "fdoiohikhacgb", "k", "doiaigclm", "bdfaoncbhfkdbjd", "f", "jaikbciac", "cjgadmfoodmba",
				"molokllh", "gfkngeebnggo", "lahd", "n", "ehfngoc", "lejfcee", "kofhmoh", "cgda", "de", "kljnicikjeh",
				"edomdbibhif", "jehdkgmmofihdi", "hifcjkloebel", "gcghgbemjege", "kobhhefbbb", "aaikgaolhllhlm", "akg",
				"kmmikgkhnn", "dnamfhaf", "mjhj", "ifadcgmgjaa", "acnjehgkflgkd", "bjj", "maihjn", "ojakklhl", "ign",
				"jhd", "kndkhbebgh", "amljjfeahcdlfdg", "fnboolobch", "gcclgcoaojc", "kfokbbkllmcd", "fec", "dljma",
				"noa", "cfjie", "fohhemkka", "bfaldajf", "nbk", "kmbnjoalnhki", "ccieabbnlhbjmj", "nmacelialookal",
				"hdlefnbmgklo", "bfbblofk", "doohocnadd", "klmed", "e", "hkkcmbljlojkghm", "jjiadlgf", "ogadjhambjikce",
				"bglghjndlk", "gackokkbhj", "oofohdogb", "leiolllnjj", "edekdnibja", "gjhglilocif", "ccfnfjalchc", "gl",
				"ihee", "cfgccdmecem", "mdmcdgjelhgk", "laboglchdhbk", "ajmiim", "cebhalkngloae", "hgohednmkahdi",
				"ddiecjnkmgbbei", "ajaengmcdlbk", "kgg", "ndchkjdn", "heklaamafiomea", "ehg", "imelcifnhkae",
				"hcgadilb", "elndjcodnhcc", "nkjd", "gjnfkogkjeobo", "eolega", "lm", "jddfkfbbbhia", "cddmfeckheeo",
				"bfnmaalmjdb", "fbcg", "ko", "mojfj", "kk", "bbljjnnikdhg", "l", "calbc", "mkekn", "ejlhdk",
				"hkebdiebecf", "emhelbbda", "mlba", "ckjmih", "odfacclfl", "lgfjjbgookmnoe", "begnkogf", "gakojeblk",
				"bfflcmdko", "cfdclljcg", "ho", "fo", "acmi", "oemknmffgcio", "mlkhk", "kfhkndmdojhidg", "ckfcibmnikn",
				"dgoecamdliaeeoa", "ocealkbbec", "kbmmihb", "ncikad", "hi", "nccjbnldneijc", "hgiccigeehmdl",
				"dlfmjhmioa", "kmff", "gfhkd", "okiamg", "ekdbamm", "fc", "neg", "cfmo", "ccgahikbbl", "khhoc", "elbg",
				"cbghbacjbfm", "jkagbmfgemjfg", "ijceidhhajmja", "imibemhdg", "ja", "idkfd", "ndogdkjjkf", "fhic",
				"ooajkki", "fdnjhh", "ba", "jdlnidngkfffbmi", "jddjfnnjoidcnm", "kghljjikbacd", "idllbbn", "d",
				"mgkajbnjedeiee", "fbllleanknmoomb", "lom", "kofjmmjm", "mcdlbglonin", "gcnboanh", "fggii", "fdkbmic",
				"bbiln", "cdjcjhonjgiagkb", "kooenbeoongcle", "cecnlfbaanckdkj", "fejlmog", "fanekdneoaammb",
				"maojbcegdamn", "bcmanmjdeabdo", "amloj", "adgoej", "jh", "fhf", "cogdljlgek", "o", "joeiajlioggj",
				"oncal", "lbgg", "elainnbffk", "hbdi", "femcanllndoh", "ke", "hmib", "nagfahhljh", "ibifdlfeechcbal",
				"knec", "oegfcghlgalcnno", "abiefmjldmln", "mlfglgni", "jkofhjeb", "ifjbneblfldjel", "nahhcimkjhjgb",
				"cdgkbn", "nnklfbeecgedie", "gmllmjbodhgllc", "hogollongjo", "fmoinacebll", "fkngbganmh",
				"jgdblmhlmfij", "fkkdjknahamcfb", "aieakdokibj", "hddlcdiailhd", "iajhmg", "jenocgo", "embdib",
				"dghbmljjogka", "bahcggjgmlf", "fb", "jldkcfom", "mfi", "kdkke", "odhbl", "jin", "kcjmkggcmnami",
				"kofig", "bid", "ohnohi", "fcbojdgoaoa", "dj", "ifkbmbod", "dhdedohlghk", "nmkeakohicfdjf",
				"ahbifnnoaldgbj", "egldeibiinoac", "iehfhjjjmil", "bmeimi", "ombngooicknel", "lfdkngobmik",
				"ifjcjkfnmgjcnmi", "fmf", "aoeaa", "an", "ffgddcjblehhggo", "hijfdcchdilcl", "hacbaamkhblnkk",
				"najefebghcbkjfl", "hcnnlogjfmmjcma", "njgcogemlnohl", "ihejh", "ej", "ofn", "ggcklj", "omah", "hg",
				"obk", "giig", "cklna", "lihaiollfnem", "ionlnlhjckf", "cfdlijnmgjoebl", "dloehimen", "acggkacahfhkdne",
				"iecd", "gn", "odgbnalk", "ahfhcd", "dghlag", "bchfe", "dldblmnbifnmlo", "cffhbijal", "dbddifnojfibha",
				"mhh", "cjjol", "fed", "bhcnf", "ciiibbedklnnk", "ikniooicmm", "ejf", "ammeennkcdgbjco", "jmhmd", "cek",
				"bjbhcmda", "kfjmhbf", "chjmmnea", "ifccifn", "naedmco", "iohchafbega", "kjejfhbco", "anlhhhhg" };

		System.out.println(new WordBreak().wordBreak(s1, Arrays.asList(w1)));
	}

	T p = new T(' ');

	boolean wordBreak(String s, List<String> wordDict) {
		for (String w : wordDict)
			create(p, w.toCharArray());
		return s.isEmpty() && wordDict.contains("") ? true : s.isEmpty() ? false : f(p, 0, s.toCharArray(), false);
	}

	boolean f(T r, int i, char[] c, boolean found) {
		if(r == null)
			return found;
		if (i == c.length)
			return r.e ? true : found;
		if (r != null && r.nodes.get(c[i] - 'a') == null)
			return found;
		for (int j = i; j < c.length; j++) {
			if (r != null && null != r.nodes.get(c[j] - 'a') && r.nodes.get(c[j] - 'a').e) {
				if (!found) 
					found = f(p, j + 1, c, found);
			}
			if (r != null && !found)
				found = f(r.nodes.get(c[j] - 'a'), j + 1, c, found);
		}
		return found;
	}

	void create(T node, char[] c) {
		for (char d : c) {
			if (node.nodes.get(d - 'a') == null) {
				T t = new T(d);
				node.nodes.set(d - 'a', t);
			}
			node = node.nodes.get(d - 'a');
		}
		node.e = true;
	}
}

class T {
	List<T> nodes = new ArrayList<>();
	char c;
	boolean e;

	public T(char c) {
		this.c = c;
		for (int i = 0; i < 26; i++)
			nodes.add(null);
	}
}

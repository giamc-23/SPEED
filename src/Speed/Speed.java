package Speed;

import java.util.*;
import java.lang.Character;

public class Speed {



	public static void main(String[] args) {
		Tree tree = new Tree();
		//tree.SPEED("ABbDCcaBCbdcADaBAdab");
		tree.Read("Bb",0);
		tree.Read("Cc", 0);
		tree.Read("caBC", 0);
		tree.Read("BCb", 0);
		tree.Read("Cbdc", 0);
		tree.Read("dcAD", 0);
		tree.Read("ADa", 0);
		tree.Read("DaBAd", 0);
		tree.Read("aBA", 0);
		tree.Read("Ada", 0);
		tree.Read("BAdab", 0);


		System.out.println(tree.EpisodeList);
		System.out.println(tree.EpisodeList.size());
		System.out.println(tree.root.frequency);
		for(int i = 0; i < tree.EpisodeList.size();i++) {
			System.out.println("Adding " + tree.EpisodeList.get(i));
			tree.addEvents(tree.EpisodeList.get(i));
		}

	}









}

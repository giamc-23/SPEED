package Speed;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Tree {

	private static final String OPEN_BRACKET = "{";
	private static final String CLOSED_BRACKET = "}";
	private static final String EMPTY = "";
	ArrayList<Character> List;
	String window = "";


	public TreeNode root;
	public ArrayList<String> EpisodeList = new ArrayList<String>();

	public Tree() {
		// Marking root event as ' ' empty
		this.root = new TreeNode(' ');
	}
	public void addEvents(String events) {
		TreeNode cur_node = this.root;
		cur_node.frequency++;
		for(char event : events.toCharArray()) {
			if(!cur_node.children.containsKey(event)) 
				cur_node.children.put(event, new TreeNode(event));
			System.out.println("The children of "+cur_node.ToString() +" are/is " +cur_node.getChildren(cur_node.event));
			cur_node = cur_node.children.get(event);
			cur_node.frequency++;
			cur_node.getFreq(cur_node);
			}
		}

	public void Seperate(String seq){
		char[] seqList = seq.toCharArray();
		char firstletter = seqList[0];
		char Opposite;
		if(firstletter>='A' && firstletter<='Z'){//if it is true ,display upper case
			Opposite = Character.toLowerCase(firstletter);

		}
		else{//if it is true ,display lower case
			Opposite = Character.toUpperCase(firstletter);
		}
		for(int i = 1; i <seqList.length; i++) {
			window += seqList[i];
		}
		System.out.println(window);

	}

	public void SPEED(String seq){
		int max_episode_length = 1;
		String Episode = "";
		char Opposite;
		String Window = "";

		for(Character v: seq.toCharArray()){
			Window += v;
			if(v>='A' && v<='Z'){//if it is true ,display upper case
				Opposite = Character.toLowerCase(v);
			}
			else{//if it is true ,display lower case
				Opposite = Character.toUpperCase(v);
			}
			for(int i = 0; i < Window.length(); i++) {
				char[] WindList = Window.toCharArray();
				if (WindList[i] == Opposite) {
					Episode = Window.substring(i, Window.length());
					Read(Episode, 0, "");

					if (Episode.length() > max_episode_length) {
						max_episode_length = Episode.length();
					}
				}
				Read(Episode, 0, "");
				Window = Window.substring(Window.length() - max_episode_length+1, Window.length());
			}

		}
	}

	public void Read(String Episode, int i, String out){
		if (i == Episode.length()) {
			return;
		}

		// consider each substring `S[i, j]`
		for (int j = Episode.length() - 1; j >= i; j--)
		{
			String sub_str = OPEN_BRACKET + Episode.substring(i, j + 1)
					+ CLOSED_BRACKET;
			EpisodeList.add(Episode.substring(i,j+1));

			// append the substring to the result and recur with an index of
			// the next character to be processed and the result string
			Read(Episode, j + 1, out + sub_str);
		}

		Set<String> set = new HashSet<>(EpisodeList);
		EpisodeList.clear();
		EpisodeList.addAll(set);

	}

	}





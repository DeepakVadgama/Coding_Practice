// only allows chars 'a' through 'z'
class Trie {


	private TrieNode root;

	public Trie(){
		root = new TrieNode();	
	}

	public void insert(String word){
	
		TrieNode current = root;
		for(int i=0; i<word.size(); i++){
			char val = word.getCharAt(i); 
			if (current.get(val) == null){ 
				current.link(val);
			}
			current = current.get(val);
		}
		current.SetEnd(true);
	}

	public boolean search(String word){
		TrieNode current = root;
		for(int i=0; i<word.size(); i++){
			char val = word.getCharAt(i); 
			if (current.get(val) == null){ 
				return false;
			}
			current = current.get(val);
		}
	return current != null && current.isEnd();
	}

	public boolean startsWith(String word){
		TrieNode current = root;
		for(int i=0; i<word.size(); i++){
			char val = word.getCharAt(i); 
			if (current.get(val) == null){ 
				return false;
			}
			current = current.get(val);
		}
	return true;
	}
}

private class TrieNode {

	private char value;
private TrieNode[] links = new TrieNode[26];
private boolean isEnd;

	public TrieNode(char value) {
		this.value = value;
	}

	public TrieNode get(char ch){
		return links[ch - 'a'];
	}

	public void link(char ch){
		links[ch - 'a'] = new TrieNode(ch);
	}
}

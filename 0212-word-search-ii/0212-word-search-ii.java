class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words); 
        
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[i].length; j++){
                findWord(board,root,result,i,j);
            }
        }
        
        return result;
    }

    public void findWord(char[][] board, TrieNode root, List<String> result, int row, int col){

        if(row < 0 || col < 0 || row >= board.length || col >= board[row].length){
            return;
        }
        char ch = board[row][col] ;
        if(ch == '#'){
            return; //Already visited
        }

        if(root.children[ch-'a'] == null){
            return;
        }

        TrieNode node = root.children[ch-'a'];
        if(node.word != null){
            result.add(node.word);
            node.word =  null;
        }

        board[row][col] = '#';

        findWord(board,node,result,row+1,col);
        findWord(board,node,result,row-1,col);
        findWord(board,node,result,row,col+1);
        findWord(board,node,result,row,col-1);
         
        board[row][col] = ch;
    }

    public TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for(String word : words){
            TrieNode current = root;
            for(char ch : word.toCharArray()){
                if(current.children[ch -'a'] == null){
                    current.children[ch -'a'] = new TrieNode();
                }
                current = current.children[ch - 'a'];
            }
            current.word = word;
        }
        return root;
    }
}

class TrieNode {
    char ch;
    TrieNode[] children = new TrieNode[26];
    String word;

    public TrieNode(){
        this.ch = ch;
    }
}
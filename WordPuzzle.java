public class WordPuzzle {
    public static void main(String[] args) {
        char[][] board = {{'A','D','E','R','T','Y','W','I','O','P','A','P','R','O','J','E','C','T','S','Z','X','C','V','G','R','M'},
        {'U','I','O','W','I','S','C','O','N','S','I','N','N','X','C','V','L','M','Q','W','A','D','T','R','I','O'},
        {'G','S','I','S','T','E','R','V','R','P','B','O','M','A','W','R','O','C','N','E','V','E','L','E','D','F'},
        {'X','N','V','C','I','R','D','E','C','K','M','N','E','T','I','C','V','D','Y','R','D','N','U','A','L','Z'},
        {'S','G','J','L','S','M','C','W','E','A','T','Y','A','R','P','T','E','D','F','G','U','H','K','T','Z','M'},
        {'G','R','A','N','O','I','S','Y','D','L','R','T','H','R','U','L','S','A','B','D','S','R','Z','W','S','M'},
        {'N','Y','E','U','H','J','E','R','V','E','F','C','M','D','O','T','S','I','W','I','I','O','H','H','T','C'},
        {'I','L','K','H','D','A','D','V','T','I','M','M','B','O','A','D','N','G','R','N','K','K','C','I','I','H'},
        {'D','I','V','I','T','D','E','H','E','R','I','E','H','N','M','Z','Q','E','J','H','N','V','R','T','J','B'},
        {'D','M','H','S','D','O','A','U','P','D','L','C','X','E','K','Z','H','T','V','B','C','I','D','E','W','S'},
        {'E','A','R','P','A','N','R','F','R','A','S','U','K','G','Z','C','H','F','B','D','N','M','T','L','M','U'},
        {'B','F','Y','G','U','T','F','B','C','E','I','T','S','I','Y','H','Q','A','W','E','A','T','Y','R','S','P'},
        {'T','K','H','F','D','C','V','B','M','M','Q','E','T','R','P','S','I','E','R','E','C','O','R','G','A','U'},
        {'E','D','F','S','H','J','J','O','D','X','C','A','B','L','B','O','U','Q','A','R','W','S','H','E','Q','M'},
        {'W','J','N','U','J','M','H','K','O','L','I','D','L','O','L','I','I','B','A','B','I','E','S','B','T','G'}};        
        String[] words = {"ADRIEL","ADVENTURE","BABIES","BROTHERS","BUSY","CALEB","CEDRIC","CHERISH","CHRISTIAN","CUTE","DAD","DAMON","DORAN","ETHAN","ELEVEN","FAMILY","FUN","GREAT WHITE","GROCERIES","HOMESCHOOLED","JADON","LAUNDRY","LOVE","MARTIN","MOM","NOISY","ONEGIRL","PROJECTS","SISTER","TWINS","WETBEDDING","WISCONSIN","WORK"};
        for(int i =0 ;i<words.length;i++){
            int[] position = search(board, words[i]);
            System.out.println(position[0] + " "+position[1]);
        }
    }
    public static boolean searchDir(char[][] board, String key,int y,int x,String direction){
        for(int i = 0 ;i<key.length();i++){
            switch(direction){
                case "up":
                    if(board[y-i][x] != key.charAt(i)){
                        return false;
                    }
                    break;
                case "down":
                    if(board[y+i][x] != key.charAt(i)){
                        return false;
                    }
                    break;
                case "left":
                    if(board[y][x-i] != key.charAt(i)){
                        return false;
                    }
                    break;
                case "right":
                    if(board[y][x+i] != key.charAt(i)){
                        return false;
                    }
                    break;
                case "upleft":
                    if(board[y-i][x-i] != key.charAt(i)){
                        return false;
                    }
                    break;
                case "upright":
                    if(board[y-i][x+i] != key.charAt(i)){
                        return false;
                    }
                    break;
                case "downleft":
                    if(board[y+i][x-i] != key.charAt(i)){
                        return false;
                    }
                    break;
                case "downright":
                    if(board[y+i][x+i] != key.charAt(i)){
                        return false;
                    }
                    break;
            }
        }
        return true;
    }
    public static int[] search(char[][] board, String key){
        int[] position = new int[2];
        position[0] = -1;
        position[1] = -1;
        for(int i = 0 ;i<board.length;i++){
            for(int j = 0 ;j<board[i].length;j++){
                if(i >= key.length()-1){
                    if(searchDir(board, key, i, j, "up")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
                if(i+key.length() <= board.length){
                    if(searchDir(board, key, i, j, "down")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
                if(j+key.length() <= board[i].length){
                    if(searchDir(board, key, i, j, "right")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
                if(j >= key.length() -1){
                    if(searchDir(board, key, i, j, "left")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
                if(i >= key.length()-1 && j >= key.length() -1){
                    if(searchDir(board, key, i, j, "upleft")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
                if(i >= key.length()-1 && j+key.length() <= board[i].length){
                    if(searchDir(board, key, i, j, "upright")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
                if(i+key.length() <= board.length && j >= key.length() -1){
                    if(searchDir(board, key, i, j, "downleft")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
                if(i+key.length() <= board.length && j+key.length() <= board[i].length){
                    if(searchDir(board, key, i, j, "downright")){
                        position[0] = i;
                        position[1] = j;
                        break;
                    }
                }
            }
        }
        return position;
    }
}
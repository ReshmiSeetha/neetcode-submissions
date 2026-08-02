class Solution {
    public boolean isValidSudoku(char[][] board) {
        Set<String> seen = new HashSet<>();
        for(int i = 0; i<9; i++){
            for(int j = 0; j<9; j++){
                char ch = board[i][j];
                if(ch != '.'){
                    if(!seen.add(ch + "fount at row" + i) ||
                        !seen.add(ch + "found at column" + j) ||
                        !seen.add(ch + "found at sub box" + i/3 + "_" + j/3)){
                            return false;
                        }
                }
            }
        }
        return true;
    }
}

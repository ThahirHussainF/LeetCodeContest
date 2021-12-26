class Solution {
    int moveGrid(String s, int[] startPos, int grid) {
        
        int i=startPos[0],j=startPos[1],m=0;
        int move=0;
        int n=s.length();
            while(m<n&&i<grid) {
                while(m<n&&j<grid) {
                    if(m<n&&s.charAt(m)=='R'&&(++j >= grid)) return move; 
                    
                    else if(m<n&&s.charAt(m)=='L'&&(--j < 0))  return move;
      
                    else if(m<n&&s.charAt(m)=='U'&&(--i<0)) return move;

                    else if(m<n&&s.charAt(m)=='D'&&(++i >= grid)) return move;
                        
                    move++;   
                    m++;
                }
            }
        return move;
    }
    public int[] executeInstructions(int n, int[] startPos, String s) {
        
        int i;
        int[] result=new int[s.length()];
        for(i=0; i<s.length();i++) {
            String temp=s.substring(i);
            result[i]=moveGrid(temp,startPos,n);
        }
        return result;
                
    }
}

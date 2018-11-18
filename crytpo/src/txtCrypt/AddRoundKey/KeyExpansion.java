package txtCrypt.AddRoundKey;
import txtCrypt.Bitsgetter.bytegetter;
import txtCrypt.ase.AES;
import txtCrypt.ase.SBox.SBox;
import txtCrypt.ase.arrayprinter;
/**
 *
 * @author Siddharth & Simran
 */
public class KeyExpansion {
    
    /** Creates a new instance of KeyExpansion */
    public KeyExpansion() {
    }
    public void keyExpansion(String[][] mykey){
        
        
        words[0]=new String[4];
        words[1]=new String[4];
        words[2]=new String[4];
        words[3]=new String[4];
        words[0]=mykey[0];
        words[1]=mykey[1];
        words[2]=mykey[2];
        words[3]=mykey[3];
        
        
        for(int i=4;i<44;i++) {
            temp=words[i-1];
            System.out.println(temp[0]);
            if(i%4==0){
                temp= RCxor((SubWord(Rotword(temp))),i/4);
                
                
            }
            
            
            words[i]=xor2words(words[i-4],temp);
            
        }
        
        arrayprinter.printarray(words,"key Expantion");
    }
    public String[] Rotword(String[] word) {
        String[] afterRot=new String[4];
        
        for(int i=0;i<3;i++)
            afterRot[i]=word[i+1];
        afterRot[3]= word[0];
        return afterRot;
    }
    public String[] xor2words(String[] word1,String[] word2) {
        
        newWord=new String[4];
        
        
        for(int i=0;i<4;i++) {
            newWord[i]= byteget.xor2hex( word1[i],word2[i] );
            
        }
        
        return newWord;
    }
    public String[] SubWord(String[] word) {
        String [] aftersub=new String[4];
        for(int i=0;i<4;i++) {
            
            aftersub[i]=sbox.getSbox(word[i]);
            
        }
        return aftersub;
    }
    public String[] RCxor(String[] word,int i) {
        RCword[0]=RCtable[i-1];
        
        String[] w= xor2words(RCword,word);
        
        return w;
    }
    
    
    
    public String getKey(){
        return k;
    }
    public String[][] getkeyToRound() {
        String[][] roundkey=new String[4][4];
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++) {
            roundkey[j][i]=words[i+((AES.ROUND-1)*4)][j];
            }
        return roundkey;
    }
    
    public String[][] getWords() {
        return words;
    }
    
    private  SBox sbox=new SBox();
    private bytegetter byteget=new bytegetter((byte)27);
    String [] temp=new String[4];
    String [] RCtable=new String[]  {"01","02","04","08","10","20","40","80","1B","36"};
    String [] RCword=new  String[] {"00","00","00","00",};
    String [] word1=new String[4];
    String [] word2=new String[4];
    String [] word3=new String[4];
    String [] word4=new String[4];
    String [][] words=new String[44][4];
    String [] newWord=new String[4];
    
    
    String k;
    
}
 
package txtCrypt.Mixcolumns;

import txtCrypt.Bitsgetter.bytegetter;
import txtCrypt.ase.arrayprinter;


/**
 *
 * @author Siddharth & Simran
 */
public class mixcolumns {
    
    /** Creates a new instance of mixcolumns */
    public mixcolumns() {
    }
    public String[][]  mixcolumns(String[][] state) {
        bytegetter=new bytegetter((byte)27);
        aftermix=new String[4][4];
        data=new byte[4];
    
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++) {
            for(int k=0;k<4;k++)
            {
           
                data[k]=bytegetter.Xorbytegetter(trans[i][k],state[k][j]);
            }
            aftermix[i][j]=bytegetter.XorAll(data);
            }
      
        return aftermix;
        
        
    }
    String[][] trans=new String[][]
    {{"02","03","01","01"},
     {"01","02","03","01"},
     {"01","01","02","03"},
     {"03","01","01","02"},
    };
    
    private bytegetter bytegetter;
    private String[][] aftermix=new String[4][4];
    private byte[] data=new byte[4];
}

 
package txtCrypt.Hexdecimal_converter;

import txtCrypt.Bitsgetter.bitsgetter;

/**
 *
 * @author Siddharth & Simran
 */
public class decimalhextable {
    
    /** Creates a new instance of decimalhex */
    public decimalhextable() {
    }
    public String[][] getHextable(String data) {
        byte[] bitsarray;
        for(int i=0;i<16;i++) {
         
            bitsarray=bitsget.getBinaryBits(data.charAt(i));
  
            filltable(i,bitsarray);
        }
        for(int i=0;i<4;i++) {
            System.out.print("|");
            for(int j=0;j<4;j++)
                System.out.print(Hextable[i][j]+" ");
            System.out.println("|");
        }
        return Hextable;
       
    }
    
    public void filltable(int i,byte[] bits) {
 
         row=i%4;
        col=i/4;
        
        left_value=bits[3]*1+bits[2]*2+bits[1]*4+bits[0]*8;
        right_value=bits[7]*1+bits[6]*2+bits[5]*4+bits[4]*8;
 
        Hextable[row][col]=decmhex.getHex(left_value)+decmhex.getHex(right_value);
    }
    public String getString(String[][] myTable) {
        byte[] b1,b2;
        String str=null;
        for(int i=0;i<4;i++)
            for(int j=0;j<4;j++) {
            
           
            b1=bitsget.getBinaryBitsHex(myTable[j][i].charAt(0));
            b2=bitsget.getBinaryBitsHex( myTable[j][i].charAt(1));
            left_value=b1[3]*128+b1[2]*64+b1[1]*32+b1[0]*16;
            left_value+=b2[3]*8+b2[2]*4+b2[1]*2+b2[0]*1;
             if(str==null)
             {
                str=Character.toString((char)left_value);
             }
             else
                 str+=Character.toString((char)left_value);
            
            }
        return str;
    }
    
    private String[][] Hextable=new String[4][4];
    private decimalhex decmhex=new decimalhex();
    private bitsgetter bitsget=new bitsgetter();
 
    private int col;
    private int row;
    private int left_value;
    private int right_value;
    
}
 
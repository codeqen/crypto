
package txtCrypt.Hexdecimal_converter;

/**
 *
 * @author Siddharth & Simran
 */
public class decimalhex {
    
    /** Creates a new instance of decimalhex */
    public decimalhex() {
    }
    public String getHex(int decimal)
    {
        
        if(decimal<10)Hex=Integer.toString(decimal);
        else
        {
            switch(decimal)
            {
                case 10:Hex="A";break;
                case 11:Hex="B";break;
                case 12:Hex="C";break;
                case 13:Hex="D";break;
                case 14:Hex="E";break;
                case 15:Hex="F";break;
                default:Hex="?";break;
            }
        }
               return Hex; 
    }
      public int getDecimal(char ch)
    {
        
        
            switch(ch)
            {
                case '0':Decimal=0;break;
                case '1':Decimal=1;break;
                case '2':Decimal=2;break;
                case '3':Decimal=3;break;
                case '4':Decimal=4;break;
                case '5':Decimal=5;break;
                case '6':Decimal=6;break;
                case '7':Decimal=7;break;
                case '8':Decimal=8;break;
                case '9':Decimal=9;break;
                case 'A':Decimal=10;break;
                case 'B':Decimal=11;break;
                case 'C':Decimal=12;break;
                case 'D':Decimal=13;break;
                case 'E':Decimal=14;break;
                case 'F':Decimal=15;break;
                 
                
                
                default:Decimal=-1;break;
            }
        
               return Decimal; 
    }
    String Hex;
    int Decimal;
}
 
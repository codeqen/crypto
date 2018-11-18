
package txtCrypt.Bitsgetter;

import txtCrypt.Hexdecimal_converter.decimalhex;

/**
 *
 * @author Siddharth & Simran
 * 
 */
public class bytegetter {
    
    /** Creates a new instance of bytegetter */
    public bytegetter(byte newcon) {
        constant=newcon;
    }
    public byte Xorbytegetter(String cell,String cell2) {
        elements=new byte[4];
        elements[0]=(byte)0;
        elements[1]=(byte)0;
        elements[2]=(byte)0;
        elements[3]=(byte)0;
        left=bitsgetter.getBinaryBitsHex(cell.charAt(0));
        right=bitsgetter.getBinaryBitsHex(cell.charAt(1));
       
        byte cellbyte=(byte)(left[3]*128+left[2]*64+left[1]*32+left[0]*16+right[3]*8+right[2]*4+right[1]*2+right[0]*1);
        
        left2=bitsgetter.getBinaryBitsHex((cell2.charAt(0)));
        right2=bitsgetter.getBinaryBitsHex(cell2.charAt(1));
    
        byte cellbyte2=(byte)(left2[3]*128+left2[2]*64+left2[1]*32+left2[0]*16+right2[3]*8+right2[2]*4+right2[1]*2+right2[0]*1);
        
        
        byte xorbyte;
         
        if(right[0]==1) {
          
            System.out.println("1");
            elements[0]=cellbyte2;
        }
        if(right[1]==1) {
            System.out.println("2");
            elements[1]=xorByIndex(cellbyte2,1);
        }
        if(right[2]==1) {
            System.out.println("3");
            elements[2]=xorByIndex(cellbyte2,2);
        }
        if(right[3]==1) {
            System.out.println("4");
            elements[3]=cellbyte2=xorByIndex(cellbyte2,3);
        }
        
        System.out.println(right[0]+" "+right[1]+" "+right[2]+" "+right[3]);
     
        return XorAllBytes(elements);
        
    }
    public byte do2Xor(byte cell) {
         
        cell=(byte)(cell<<1);
        if(left2[3]==1) {
            
            cell=(byte)((cell) ^ constant);
             
        }
        return cell;
    }
    public byte do3Xor(byte cell) {
         
        byte newbyte=cell;
        
        
        newbyte=do2Xor(cell);
        
       
        return (byte)(cell ^ newbyte);
    }
    public byte xorByIndex(byte mydata,int shifts) {
        byte returnbyte=mydata;
        byte[] bits=new byte[8];
        
        while(shifts>0) {
            bits=bitsgetter.getBinaryBits(returnbyte);
            returnbyte=(byte)(returnbyte<<1);
            if(bits[0]==1) {
                returnbyte=(byte)((returnbyte) ^ constant);
            }
            shifts--;
        }
        return returnbyte;
    }
    
    public byte XorAllBytes(byte[] data) {
        byte allxor=(byte)(((data[0]^data[1])^(data[2])^data[3]));
        return allxor;
    }
    public byte justXor(byte cell) {
       
        
        
        cell=(byte)((cell) ^ constant);
         
        
        return cell;
    }
    public String   XorAll(byte[] data) {
        byte allxor=(byte)(((data[0]^data[1])^(data[2])^data[3]));
        
        byte[] bits=bitsgetter.getBinaryBits(allxor);
        left_value=bits[3]*1+bits[2]*2+bits[1]*4+bits[0]*8;
        right_value=bits[7]*1+bits[6]*2+bits[5]*4+bits[4]*8;
         
         
       
        return decmhex.getHex(left_value)+decmhex.getHex(right_value);
    }
    public String xor2hex(String ch1,String ch2) {
        left=bitsgetter.getBinaryBitsHex(ch1.charAt(0));
        right=bitsgetter.getBinaryBitsHex(ch1.charAt(1));
         
        byte cellbyte=(byte)(left[3]*128+left[2]*64+left[1]*32+left[0]*16+right[3]*8+right[2]*4+right[1]*2+right[0]*1);
        
        left2=bitsgetter.getBinaryBitsHex((ch2.charAt(0)));
        right2=bitsgetter.getBinaryBitsHex(ch2.charAt(1));
        
        
        
        byte cellbyte2=(byte)(left2[3]*128+left2[2]*64+left2[1]*32+left2[0]*16+right2[3]*8+right2[2]*4+right2[1]*2+right2[0]*1);
        byte xor=(byte)(cellbyte^cellbyte2);
        byte[] bits=bitsgetter.getBinaryBits(xor);
        left_value=bits[3]*1+bits[2]*2+bits[1]*4+bits[0]*8;
        right_value=bits[7]*1+bits[6]*2+bits[5]*4+bits[4]*8;
        return decmhex.getHex(left_value)+decmhex.getHex(right_value);
    }
    private bitsgetter bitsgetter=new bitsgetter();
    private decimalhex decmhex=new decimalhex();
    private byte[] elements;
    private byte[] left2;
    private byte[] right2;
    private byte[] left;
    private byte[] right;
    private int left_value;
    private int right_value;
    private byte constant=27;
    
}
 
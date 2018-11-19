package txtCrypt.ase;

import txtCrypt.AddRoundKey.AddRoundKey;
import txtCrypt.AddRoundKey.KeyExpansion;
import txtCrypt.Hexdecimal_converter.decimalhextable;
import txtCrypt.Mixcolumns.invmixcolumns;
import txtCrypt.Mixcolumns.mixcolumns;
import txtCrypt.Shiftrow.invshiftrows;
import txtCrypt.Shiftrow.shiftrows;
import txtCrypt.ase.SBox.invSBOX;


import txtCrypt.substitution.substitute_bytes;

/**
 *
 * @author Siddharth & Simran Singh
 *
  */
public class AES {
    
    /** Creates a new instance of ASE_Cipher */
    public AES(String key,String PlainText) {
        this.plaintext=PlainText;
        
        mykey=key;
        
        fillDataTable();
        
        
    }
    public String ASE_Cipher_loop() {
        AESPanel.StepsText.append("************************CIPHER***********************************"+'\n');
        arrayprinter.printarray(state_plain,"Plain Text");
        keytable=keyhex.getHextable( mykey);
        
        arrayprinter.printarray(keytable,"Key Hex");
        keyexpan.keyExpansion(keytable);
        
        
        ROUND=1;
        
        
        AESPanel.StepsText.append("****************************************************************"+'\n');
        arrayprinter.printarray(keyexpan.getkeyToRound(),"Round key Value");
        state_plain=AddRoundkey.AddRoundKey(state_plain,keyexpan.getkeyToRound());
        
        while(ROUND<=9) {
            arrayprinter.printarray(state_plain,"Start of Round");
            substitute_bytes();
            arrayprinter.printarray(state_plain,"After SubBytes");
            state_plain=shift.shiftrows(state_plain);
            arrayprinter.printarray(state_plain,"After shiftrows");
            state_plain=mixer.mixcolumns(state_plain);
            arrayprinter.printarray(state_plain,"Mix-columns");
            ROUND++;
            arrayprinter.printarray(keyexpan.getkeyToRound(),"Round key Value");
            state_plain=AddRoundkey.AddRoundKey(state_plain,keyexpan.getkeyToRound());
        }
        substitute_bytes();
        
        arrayprinter.printarray(state_plain,"After SubBytes");
        state_plain=shift.shiftrows(state_plain);
        arrayprinter.printarray(state_plain,"After shiftrows");
        ROUND++;
        state_plain=AddRoundkey.AddRoundKey(state_plain,keyexpan.getkeyToRound());
        AESPanel.StepsText.append("****************************************************************"+'\n');
        arrayprinter.printarray(state_plain,"Cipher Text");
        
        
        AESPanel.StepsText.append("**************************************************************"+'\n');
        return plainhex.getString(state_plain);
    }
    public String ASE_Decipher_loop() {
        AESPanel.StepsText.append("************************DECIPHER***********************************"+'\n');
        ROUND=11;
        
        keytable=keyhex.getHextable(mykey);
        
        keyexpan.keyExpansion(keytable);
        arrayprinter.printarray( keyexpan.getWords(),"Key expantintion");
        
        
        arrayprinter.printarray(state_plain,"Start of Round");
        arrayprinter.printarray(keyexpan.getkeyToRound(),"Round key Value");
        state_plain=AddRoundkey.AddRoundKey(state_plain,keyexpan.getkeyToRound());
        arrayprinter.printarray(state_plain,"After Add round key");
        ROUND--;
        while(ROUND>1) {
            
            
            state_plain=invshift.invshiftrows(state_plain);
            arrayprinter.printarray(state_plain,"After invshiftrows");
            
            inverssubstitute_bytes();
            arrayprinter.printarray(state_plain,"After SubBytes");
            arrayprinter.printarray(keyexpan.getkeyToRound(),"Round key Value");
            state_plain=AddRoundkey.AddRoundKey(state_plain,keyexpan.getkeyToRound());
            arrayprinter.printarray(state_plain,"After Add round key");
            state_plain=invmix.invmixcolumns(state_plain);
            arrayprinter.printarray(state_plain,"invMix-columns");
            ROUND--;
            
        }
        state_plain=invshift.invshiftrows(state_plain);
        arrayprinter.printarray(state_plain,"After invshiftrows");
        inverssubstitute_bytes();
        arrayprinter.printarray(state_plain,"After SubBytes");
        arrayprinter.printarray(keyexpan.getkeyToRound(),"Round key Value");
        state_plain=AddRoundkey.AddRoundKey(state_plain,keyexpan.getkeyToRound());
        
        arrayprinter.printarray(state_plain,"state plain");
        AESPanel.StepsText.append("*******************************************************************"+'\n');
        arrayprinter.printarray(state_plain,"Plain text");
        
        
        return plainhex.getString(state_plain);
    }
    public void fillDataTable() {
        state_plain=plainhex.getHextable(plaintext);
    }
    public void substitute_bytes() {
        for(int i=0;i<4;i++) {
            
            for(int j=0;j<4;j++) {
                state_plain[i][j]=substit.getsubstitue_bytes(state_plain[i][j]);
                
            }
            
        }
        
    }
    public void inverssubstitute_bytes() {
        for(int i=0;i<4;i++) {
            
            for(int j=0;j<4;j++) {
                state_plain[i][j]=substit.invgetsubstitue_bytes(state_plain[i][j]);
                
            }
            
        }
        
    }
    
    
    public static int ROUND=1;
    private decimalhextable plainhex=new decimalhextable();
    private decimalhextable keyhex=new decimalhextable();
    private substitute_bytes substit=new substitute_bytes();
    private AddRoundKey AddRoundkey=new AddRoundKey();
    private KeyExpansion keyexpan=new KeyExpansion();
    private mixcolumns mixer=new mixcolumns();
    private shiftrows shift=new shiftrows();
    private invmixcolumns invmix=new invmixcolumns();
    private invshiftrows invshift=new invshiftrows();
    
    private invSBOX invsbox=new invSBOX();
    private String plaintext ;
    
    private String mykey;
    private String[][] state_plain=new String[4][4];
    private   String[][] keytable=new String[4][4];
    
    
    
}
 

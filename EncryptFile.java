package fi;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.swing.JFileChooser;

/**
 *
 * @author dhanoopbhaskar
 */
public class EncryptFile {

    KeyGenerator keyGenerator = null;
    SecretKey secretKey = null;
    Cipher cipher = null;

    public EncryptFile() {
        try {
            /**
             * Create a Blowfish key
             */
            keyGenerator = KeyGenerator.getInstance("Blowfish");
            secretKey = keyGenerator.generateKey();

            /**
             * Create an instance of cipher mentioning the name of algorithm
             *     - Blowfish
             */
            cipher = Cipher.getInstance("Blowfish");
        } catch (NoSuchPaddingException ex) {
            System.out.println(ex);
        } catch (NoSuchAlgorithmException ex) {
            System.out.println(ex);
        }
    }

    public static void main(String[] args) throws IOException{
    	JFileChooser chooser = new JFileChooser();
    	if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
    		File file = chooser.getSelectedFile();
    		String path = file.getAbsolutePath();
    	
    	

    	
    //	String fileToEncrypt = "index.jpeg";
        String encryptedFile = "encryptedFile.jpg";
       // String decryptedFile = "decryptedFile.jpg";
        String directoryPath = "/home/niit1/Pictures/";
        EncryptFile encryptFile = new EncryptFile();
        System.out.println("Starting Encryption...");
        encryptFile.encrypt(path,directoryPath + encryptedFile);
        System.out.println("Encryption completed...");
        /*System.out.println("Starting Decryption...");
        encryptFile.decrypt(directoryPath + encryptedFile,
                directoryPath + decryptedFile);
        System.out.println("Decryption completed...");*/
    	}
    }

    /**
     * 
     * @param srcPath
     * @param destPath
     *
     * Encrypts the file in srcPath and creates a file in destPath
     */
    private void encrypt(String srcPath, String destPath) {
        File rawFile = new File(srcPath);
        File encryptedFile = new File(destPath);
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            /**
             * Initialize the cipher for encryption
             */
            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            /**
             * Initialize input and output streams
             */
            inStream = new FileInputStream(rawFile);
            outStream = new FileOutputStream(encryptedFile);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inStream.read(buffer)) > 0) {
                outStream.write(cipher.update(buffer, 0, len));
                outStream.flush();
            }
            outStream.write(cipher.doFinal());
            inStream.close();
            outStream.close();
        } catch (IllegalBlockSizeException ex) {
            System.out.println(ex);
        } catch (BadPaddingException ex) {
            System.out.println(ex);
        } catch (InvalidKeyException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }

    /**
     * 
     * @param srcPath
     * @param destPath
     *
     * Decrypts the file in srcPath and creates a file in destPath
     */
 /*   private void decrypt(String srcPath, String destPath) {
        File encryptedFile = new File(srcPath);
        File decryptedFile = new File(destPath);
        InputStream inStream = null;
        OutputStream outStream = null;
        try {
            /**
             * Initialize the cipher for decryption
             
            cipher.init(Cipher.DECRYPT_MODE, secretKey);
            /**
             * Initialize input and output streams
            
            inStream = new FileInputStream(encryptedFile);
            outStream = new FileOutputStream(decryptedFile);
            byte[] buffer = new byte[1024];
            int len;
            while ((len = inStream.read(buffer)) > 0) {
                outStream.write(cipher.update(buffer, 0, len));
                outStream.flush();
            }
            outStream.write(cipher.doFinal());
            inStream.close();
            outStream.close();
        } catch (IllegalBlockSizeException ex) {
            System.out.println(ex);
        } catch (BadPaddingException ex) {
            System.out.println(ex);
        } catch (InvalidKeyException ex) {
            System.out.println(ex);
        } catch (FileNotFoundException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            System.out.println(ex);
        }
    }*/
    
    
    /**************
    public static void main(String[] args) throws IOException{

		//1. Create the frame.
		JFrame frame = new JFrame("Crypto");

		//2. Optional: What happens when the frame closes?
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//3. Create components and put them in the frame.
		//...create emptyLabel...

		//5. Show it.
		frame.setTitle("CRYPTO");
		frame.setSize(600, 400);
		frame.setVisible(true);
		frame.setLocationRelativeTo(null);

		JButton encrypt = new JButton("encrypt");
		encrypt.setBounds(50,100,60,30);  
		frame.add(encrypt);
		encrypt.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent encrypt) {
				JFileChooser chooser = new JFileChooser();
				if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
					File file = chooser.getSelectedFile();
					String path = file.getAbsolutePath();
					// TODO Auto-generated method stub
					String encryptedFile = "encryptedFile.jpg";
					String directoryPath = "/home/niit1/Pictures/";
					EncryptFile encryptFile = new EncryptFile();
					System.out.println("Starting Encryption...");
					encryptFile.encrypt(path,directoryPath + encryptedFile);
					System.out.println("Encryption completed...");
				}
			}
		});
	}

}

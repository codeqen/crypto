package txtCrypt.menu;

import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.event.ActionListener;
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
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JTextArea;

public class CryptAlgo {

	KeyGenerator keyGenerator = null;
	SecretKey secretKey = null;
	Cipher cipher = null;

	public CryptAlgo() {
		try {
			keyGenerator = KeyGenerator.getInstance("AES");
			secretKey = keyGenerator.generateKey();


			cipher = Cipher.getInstance("AES");
		} catch (NoSuchPaddingException ex) {
			System.out.println(ex);
		} catch (NoSuchAlgorithmException ex) {
			System.out.println(ex);
		}
	}
	

	public void encrypt(String srcPath, String destPath) {
		File rawFile = new File(srcPath);
		File encryptedFile = new File(destPath);
		InputStream inStream = null;
		OutputStream outStream = null;
		try {

			cipher.init(Cipher.ENCRYPT_MODE, secretKey);
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


	public void decrypt(String srcPath, String destPath) {
		File encryptedFile = new File(srcPath);
		File decryptedFile = new File(destPath);
		InputStream inStream = null;
		OutputStream outStream = null;
		try {
			cipher.init(Cipher.DECRYPT_MODE, secretKey);
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
	}
}


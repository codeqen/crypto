package txtCrypt.ase;
import txtCrypt.AddRoundKey.KeyExpansion;
import txtCrypt.menu.CryptAlgo;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.Desktop;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicSplitPaneUI;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.DocumentFilter;
import txtCrypt.*;


/**
 *
 * @author Siddharth & Simran
 */
public class ASEMain   {

	/** Creates a new instance of DesMain */
	public ASEMain() {
	}

	public static void main(String [] rr){
		AESPanel  mm = new AESPanel();
		mm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mm.setVisible(true);
	}
}
class AESPanel extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static   JTextArea StepsText = new JTextArea(17,70);
	private    AES mm;
	@SuppressWarnings("unused")
	private    KeyExpansion ee =new KeyExpansion();
	private    Container c=this.getContentPane();
	private    JButton btnCihper = new JButton("Cipher");
	private    JButton btnDeCihper = new JButton("Decipher");

	private   JTextArea CipherText = new JTextArea(4,70);
	private   JTextArea OriginalText = new JTextArea(4,70);
	private   JTextArea DeCipherText = new JTextArea(4,70);


	private    JScrollPane OriginalScorl=new JScrollPane(OriginalText,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private    JScrollPane CipherScorl=new JScrollPane(CipherText,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private  JScrollPane DecipherScorl=new JScrollPane(DeCipherText,
			JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	private  JTextField KeyWord = new JTextField(16);
	private  JPanel PanelCipher = new JPanel();
	private  JPanel PanelDecipher = new JPanel();
	private  JPanel PanelKeyWord = new JPanel();
	private  JPanel PanelOriginaltxt = new JPanel();
	private  JMenuBar menubar = new JMenuBar();
	private  JLabel lblKeyWord= new JLabel("KeyWord : ");


	@SuppressWarnings("static-access")
	public AESPanel(){
		this.setTitle("AES");
		this.setSize(600,700);
		this.setVisible(true);
		setState(JFrame.MAXIMIZED_BOTH);
		setExtendedState(this.getExtendedState() | this.MAXIMIZED_BOTH);
		GenerateGUI();
	}


	private void GenerateGUI(){

	
		c.setLayout(new FlowLayout());
		
	
		JMenu fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);
		JMenu aboutMenu = new JMenu("About");
		aboutMenu.setMnemonic(KeyEvent.VK_A);


		JMenuItem openFileE = new JMenuItem("Encrypt Existing  File");
		openFileE.addActionListener((event) -> {
			JFileChooser chooser = new JFileChooser();
			if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooser.getSelectedFile();
				String fileToEncrypt = selectedFile.getAbsolutePath();
				String encryptedFile = "Enc"+selectedFile.getName();
				String directoryPath = "/home/siddharth/folder/";
				CryptAlgo encrypt = new CryptAlgo();
				encrypt.encrypt(fileToEncrypt,directoryPath + encryptedFile);
			try {
				Desktop.getDesktop().open(new File(directoryPath));
				} catch (IOException e) {
				// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}
		);

		JMenuItem openFileD = new JMenuItem("Decrypt Existing  File");
		openFileD.addActionListener((event) -> {
			JFileChooser chooser = new JFileChooser();
			if(chooser.showOpenDialog(null)==JFileChooser.APPROVE_OPTION) {
				File selectedFile = chooser.getSelectedFile();
				String fileToDecrypt = selectedFile.getAbsolutePath();
				String decryptedFile = "Dec"+selectedFile.getName();
				String directoryPath = "/home/siddharth/folder/";
				CryptAlgo decrypt = new CryptAlgo();
				decrypt.decrypt(directoryPath + fileToDecrypt,
						directoryPath + decryptedFile);
				try {
					Desktop.getDesktop().open(new File(directoryPath));
					} catch (IOException e) {
					// TODO Auto-generated catch block
						e.printStackTrace();
					}
				
			}
		}
		);
		JMenuItem about = new JMenuItem("About");
		about.setMnemonic(KeyEvent.VK_O);
		about.setToolTipText("About");
		about.addActionListener((event) ->  {
			JFrame frame = new JFrame();
			frame.setTitle("crypto");
			setLayout(new BorderLayout());

			//set icon
			//	setIconImage(new ImageIcon(getClass().getClassLoader().getResource("images/lock.png")).getImage());

			//Center text
			JPanel textPanel = new JPanel();
			textPanel.setLayout(new BoxLayout(textPanel,BoxLayout.LINE_AXIS));
			textPanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 5));

			//setting the text and size
			String content = "<html><h3>About Crypto</h3>"+
					"<br/><br/>Team: <b>Simran Singh Siddharth Bisht</b>";
			JLabel text = new JLabel(content);
			text.setPreferredSize(new Dimension(250,100));

			//Border and position
			text.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
			text.setHorizontalAlignment(SwingConstants.LEFT);
			text.setVerticalAlignment(SwingConstants.TOP);

			//adding to the panel
			textPanel.add(new JScrollPane(text),BorderLayout.CENTER);

			//Bottom button
			JPanel bottomButton = new JPanel();
			JButton close = new JButton("Close");
			bottomButton.add(close);

			//Add panels
			add(textPanel,BorderLayout.CENTER);
			add(bottomButton,BorderLayout.SOUTH);

			//Add Listener
			close.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					dispose();
				}
			});

			//Default configuration
			setSize(300,300);
			setVisible(true);
			setResizable(false);
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			//setLocationRelativeTo(parent);
		});

		JMenuItem exit = new JMenuItem("Exit");
		exit.setMnemonic(KeyEvent.VK_O);
		exit.setToolTipText("Exit application");
		exit.addActionListener((event) -> System.exit(0));
		fileMenu.add(openFileE);
		fileMenu.add(openFileD);
		fileMenu.add(exit);
		aboutMenu.add(about);
		menubar.add(fileMenu);
		menubar.add(aboutMenu);
		menubar.setBounds(0, 0, 1800, 10);
		c.add(menubar);


		PanelKeyWord.setLayout(new FlowLayout());
		PanelKeyWord.add(lblKeyWord);
		PanelKeyWord.add(KeyWord);

		PanelOriginaltxt.setBorder(BorderFactory.createTitledBorder("Original Text"));
		PanelOriginaltxt.setLayout(new FlowLayout());
		PanelOriginaltxt.add(OriginalScorl);

		PanelCipher.setBorder(BorderFactory.createTitledBorder("Cipher Text"));
		PanelCipher.setLayout(new FlowLayout());
		PanelCipher.add(CipherScorl);
		PanelCipher.add(btnCihper);

		PanelDecipher.setBorder(BorderFactory.createTitledBorder("Decipher Text"));
		PanelDecipher.setLayout(new FlowLayout());
		PanelDecipher.add(DecipherScorl);
		PanelDecipher.add(btnDeCihper);



		c.add(PanelKeyWord);
		c.add(PanelOriginaltxt);
		c.add(PanelCipher);
		c.add(PanelDecipher);


		


		DoActions();
	}

	private void DoActions(){
		ActionHandler action = new ActionHandler();

		btnCihper.addActionListener(action);
		btnDeCihper.addActionListener(action);

	}

	private class ActionHandler implements ActionListener{


		public void actionPerformed(ActionEvent e) {
			if(e.getSource()==btnCihper){
				String plaintext=OriginalText.getText();
				String keyworD=KeyWord.getText();

				if(keyworD.length()<16) {
					String Massg="Keyword must be 16 character";
					JOptionPane.showConfirmDialog(null, Massg,"Error",
							JOptionPane.ERROR_MESSAGE);
				} else  if(plaintext.length()<16) {
					String Massg="Original Text must be 16 character or larger";
					JOptionPane.showConfirmDialog(null, Massg,"Error",
							JOptionPane.ERROR_MESSAGE);
				} else {
					StepsText.setText(" ");
					StepsText.append("keyword : "+keyworD+'\n');
					StepsText.append("PlainText : "+plaintext+'\n');
					mm= new AES( keyworD,plaintext);



					CipherText.append(mm.ASE_Cipher_loop());
				}
			}
			if(e.getSource()==btnDeCihper){
				if(mm!=null) {

					DeCipherText.setText(mm.ASE_Decipher_loop());
				}

			}
		}

	}

}

class DocumentSizeFilter extends DocumentFilter {
	int maxCharacters;

	public DocumentSizeFilter(int maxChars) {
		maxCharacters = maxChars;
	}

	public void insertString(FilterBypass fb, int offs, String str, AttributeSet a) throws BadLocationException {

		if ((fb.getDocument().getLength() + str.length()) <= maxCharacters)
			super.insertString(fb, offs, str, a);
		else
			Toolkit.getDefaultToolkit().beep();
	}

	public void replace(FilterBypass fb, int offs, int length, String str, AttributeSet a) throws BadLocationException {

		if ((fb.getDocument().getLength() + str.length()- length) <= maxCharacters)
			super.replace(fb, offs, length, str, a);
		else
			Toolkit.getDefaultToolkit().beep();
	}

}





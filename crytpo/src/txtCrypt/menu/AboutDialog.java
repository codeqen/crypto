package txtCrypt.menu;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.ActionEvent;

import javax.swing.*;

/**
 * @author siddharth & simran
 *
 */
public class AboutDialog extends JDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * About Dialog
	 * @param parent Parent JFrame
	 * */
	public AboutDialog( ) {
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
	}
}
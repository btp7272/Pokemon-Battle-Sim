package pokemonBattleSim.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import javax.swing.JTextArea;
import pokemonBattleSim.online.*;
import javax.swing.JMenuBar;
import javax.swing.JTextPane;
import javax.swing.JPasswordField;
import javax.swing.JFormattedTextField;

public class IPAddress {

	private JFrame frmHello;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IPAddress window = new IPAddress();
					window.frmHello.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public IPAddress() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmHello = new JFrame();
		frmHello.setTitle("Your IP Address");
		frmHello.setBounds(100, 100, 232, 75);
		frmHello.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JTextArea txtrTesting = new JTextArea();
		txtrTesting.setText(Recieve.getIPAddress());
		frmHello.getContentPane().add(txtrTesting, BorderLayout.CENTER);
	}

}

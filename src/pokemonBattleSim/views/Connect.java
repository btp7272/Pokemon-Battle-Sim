package pokemonBattleSim.views;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.BorderLayout;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Toolkit;

public class Connect {

	private JFrame frmConnect;
	private JTextField textField;
	private JButton btnNewButton;
	private JButton btnCancel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Connect window = new Connect();
					window.frmConnect.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Connect() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConnect = new JFrame();
		frmConnect.setIconImage(Toolkit.getDefaultToolkit().getImage(Connect.class.getResource("/pokemonBattleSim/resources/auxImages/Pokeball1.png")));
		frmConnect.setTitle("Connect");
		frmConnect.setBounds(100, 100, 506, 137);
		frmConnect.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{118, 147, 124, 65, 0};
		gridBagLayout.rowHeights = new int[]{38, 23, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		frmConnect.getContentPane().setLayout(gridBagLayout);
		
		JLabel lblHostIpAddress = new JLabel("  Host IP Address");
		lblHostIpAddress.setHorizontalAlignment(SwingConstants.CENTER);
		GridBagConstraints gbc_lblHostIpAddress = new GridBagConstraints();
		gbc_lblHostIpAddress.anchor = GridBagConstraints.WEST;
		gbc_lblHostIpAddress.fill = GridBagConstraints.VERTICAL;
		gbc_lblHostIpAddress.insets = new Insets(0, 0, 0, 5);
		gbc_lblHostIpAddress.gridx = 0;
		gbc_lblHostIpAddress.gridy = 1;
		frmConnect.getContentPane().add(lblHostIpAddress, gbc_lblHostIpAddress);
		
		textField = new JTextField();
		GridBagConstraints gbc_textField = new GridBagConstraints();
		gbc_textField.fill = GridBagConstraints.BOTH;
		gbc_textField.insets = new Insets(0, 0, 0, 5);
		gbc_textField.gridx = 1;
		gbc_textField.gridy = 1;
		frmConnect.getContentPane().add(textField, gbc_textField);
		textField.setColumns(10);
		
		btnNewButton = new JButton("Connect to Host");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		GridBagConstraints gbc_btnNewButton = new GridBagConstraints();
		gbc_btnNewButton.anchor = GridBagConstraints.NORTH;
		gbc_btnNewButton.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnNewButton.insets = new Insets(0, 0, 0, 5);
		gbc_btnNewButton.gridx = 2;
		gbc_btnNewButton.gridy = 1;
		frmConnect.getContentPane().add(btnNewButton, gbc_btnNewButton);
		
		btnCancel = new JButton("Cancel");
		GridBagConstraints gbc_btnCancel = new GridBagConstraints();
		gbc_btnCancel.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnCancel.gridx = 3;
		gbc_btnCancel.gridy = 1;
		frmConnect.getContentPane().add(btnCancel, gbc_btnCancel);
	}

}

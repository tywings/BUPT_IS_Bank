package bank;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JLabel;

public class WelGUI {
	private ArrayList<Account> Acc = new ArrayList<Account> ();
	
	private JFrame frmBank;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WelGUI window = new WelGUI();
					window.frmBank.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public WelGUI() {
		
		initialize();
		
	}

	/**
	 * Initialize the contents of the frame.
	 */
	
	private void initialize() {
		try {
			FileInputStream fileStream = new FileInputStream("Bank.dat");
			ObjectInputStream os = new ObjectInputStream(fileStream);
			Object ob = os.readObject();
			Acc= (ArrayList<Account>) ob;
			os.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		
		
		frmBank = new JFrame();
		frmBank.setTitle("Bank System");
		frmBank.setBounds(350, 150, 700, 460);
		frmBank.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBank.getContentPane().setLayout(null);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setFont(new Font("宋体", Font.PLAIN, 15));
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				LogGUI logwindow = new LogGUI(Acc);
				logwindow.getFrmLogin().setVisible(true);
			}
		});
		btnLogin.setBounds(70, 64, 130, 50);
		frmBank.getContentPane().add(btnLogin);
		
		JButton btnRegister = new JButton("Register");
		btnRegister.setFont(new Font("宋体", Font.PLAIN, 15));
		btnRegister.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//frmBank.setVisible(false);
				RegGUI regwindow = new RegGUI(Acc);
				regwindow.getFrmRegister().setVisible(true);
				//frmBank.setVisible(true);
			}
		});
		btnRegister.setBounds(70, 184, 130, 50);
		frmBank.getContentPane().add(btnRegister);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Object[] options = {"Yes", "No"};
				int response = JOptionPane.showOptionDialog(null, "Would you like to exit the Bank System?", "Exit?", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
				if(response == 0){
					try {
						
						FileOutputStream fs = new FileOutputStream("Bank.dat");
						ObjectOutputStream os = new ObjectOutputStream(fs);
						os.writeObject(Acc);
						os.close();
					} catch (FileNotFoundException er) {
						// TODO Auto-generated catch block
						er.printStackTrace();
					} catch (IOException er) {
						// TODO Auto-generated catch block
						er.printStackTrace();
					}
					System.exit(0);
				}
				
			}
		});
		btnExit.setFont(new Font("宋体", Font.PLAIN, 15));
		btnExit.setBounds(70, 304, 130, 50);
		frmBank.getContentPane().add(btnExit);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(WelGUI.class.getResource("/bank/logot.png")));
		lblNewLabel.setBounds(299, 64, 300, 300);
		frmBank.getContentPane().add(lblNewLabel);
		
		ImageIcon logot=new ImageIcon("logot.png");
	}
}

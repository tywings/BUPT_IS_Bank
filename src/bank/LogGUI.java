package bank;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class LogGUI {

	private JFrame frmLogin;
	private JTextField textID;
	private JPasswordField textPassword;
	
	
	public JFrame getFrmLogin() {
		return frmLogin;
	}

	/**
	 * Create the application.
	 */
	public LogGUI(ArrayList<Account> Acc) {
		initialize(Acc);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Account> Acc) {
		frmLogin = new JFrame();
		frmLogin.setTitle("Login");
		frmLogin.setBounds(350, 150, 700, 460);
		frmLogin.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmLogin.getContentPane().setLayout(null);
		
		JTextPane txtpnYouCanLog = new JTextPane();
		txtpnYouCanLog.setText("You can log in your account in this page.\r\nPlease input your Account ID and your Account Password (PIN).");
		txtpnYouCanLog.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		txtpnYouCanLog.setEditable(false);
		txtpnYouCanLog.setBackground(SystemColor.menu);
		txtpnYouCanLog.setBounds(152, 38, 340, 68);
		frmLogin.getContentPane().add(txtpnYouCanLog);
		
		JTextPane txtpnAccountId = new JTextPane();
		txtpnAccountId.setText("Account ID\uFF1A");
		txtpnAccountId.setFont(new Font("����", Font.PLAIN, 16));
		txtpnAccountId.setEditable(false);
		txtpnAccountId.setBackground(SystemColor.menu);
		txtpnAccountId.setBounds(152, 143, 130, 30);
		frmLogin.getContentPane().add(txtpnAccountId);
		
		JTextPane txtpnPassword = new JTextPane();
		txtpnPassword.setText("Password\uFF1A");
		txtpnPassword.setFont(new Font("����", Font.PLAIN, 16));
		txtpnPassword.setEditable(false);
		txtpnPassword.setBackground(SystemColor.menu);
		txtpnPassword.setBounds(152, 223, 100, 30);
		frmLogin.getContentPane().add(txtpnPassword);
		
		textID = new JTextField();
		textID.setColumns(10);
		textID.setBounds(292, 143, 200, 30);
		frmLogin.getContentPane().add(textID);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ȷ����ť֮��Ķ���
				submit(Acc);
			}
		});
		btnSubmit.setBounds(200, 332, 100, 40);
		frmLogin.getContentPane().add(btnSubmit);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				frmLogin.dispose();
			}
		});
		btnDiscard.setBounds(372, 332, 100, 40);
		frmLogin.getContentPane().add(btnDiscard);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(292, 223, 200, 30);
		frmLogin.getContentPane().add(textPassword);
	}
	
	public void submit(ArrayList<Account> Acc){
		int i;
		if(Acc.size() > 0){
			for(i=0; i< Acc.size(); i++){
				if(Acc.get(i).getID().equals(textID.getText())){
					if(Acc.get(i).getPIN().equals(textPassword.getText())){
						
						if(!Acc.get(i).isState()){
							Object[] options = {"Yes", "No"};
							int response = JOptionPane.showOptionDialog(null, "The account has been suspend!\n Would you like to restart it ?", "Restart", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
							if(response == 1){	//choose no
								frmLogin.dispose();
								return ;
							}
							else if(response == 0){	//choose yes
								Acc.get(i).setState(true);
								JOptionPane.showMessageDialog(null,"Restart successful!","Information",JOptionPane.INFORMATION_MESSAGE);
							}
						}
						Acc.get(i).setBalance(Acc.get(i).getBalance()+Acc.get(i).getUnbalance());		
						Acc.get(i).setUnbalance(0);
						if(Acc.get(i).getRsvDeposit() == 1){
							Acc.get(i).setRsvDeposit(2);
						}
						JOptionPane.showMessageDialog(null,"Login successful!","Information",JOptionPane.INFORMATION_MESSAGE);
						ManGUI manwindow = new ManGUI(Acc, i);
						manwindow.getFrmManifest().setVisible(true);
						frmLogin.dispose();
						return;
					}
					else{
						
						JOptionPane.showMessageDialog(null,"Password Error!","Information",JOptionPane.INFORMATION_MESSAGE);
						return;
					}
				}
			}
			
			if(i == Acc.size()){
				JOptionPane.showMessageDialog(null,"There is no such Account ID!","Information",JOptionPane.INFORMATION_MESSAGE);
				return ;
			}
		}
		else{
			JOptionPane.showMessageDialog(null,"There is no any account!","Information",JOptionPane.INFORMATION_MESSAGE);
			frmLogin.dispose();
			return ;
		}
	}
}

package bank;

import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.JTextPane;
import java.awt.SystemColor;
import javax.swing.JFormattedTextField;
import javax.swing.SwingConstants;

public class ManGUI {

	private JFrame frmManifest;
	private JTextPane textBalancevalue;
	private JTextPane textLimitvalue;
	private JTextPane textDebtvalue;
	private JTextPane textUnclearvalue;


	public JFrame getFrmManifest() {
		return frmManifest;
	}

	/**
	 * Create the application.
	 * 宋体Account��ArrayListʵ宋体宋体宋体ݵ宋体i
	 */
	public ManGUI(ArrayList<Account> Acc, int i) {
		initialize(Acc, i);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Account> Acc, int i) {
		frmManifest = new JFrame();
		frmManifest.setTitle("Manifest");
		frmManifest.setBounds(350, 150, 700, 460);
		frmManifest.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmManifest.getContentPane().setLayout(null);
		
		JButton btnWithdraw = new JButton("Withdraw");
		btnWithdraw.setFont(new Font("宋体", Font.PLAIN, 20));
		btnWithdraw.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Acc.get(i).withdraw();
				textBalancevalue.setText(Acc.get(i).getBalance() + "");
				try{
					textDebtvalue.setText(Acc.get(i).getOverdraw() + "");
				}
				catch(Exception er){}
			}
		});
		btnWithdraw.setBounds(10, 66, 150, 90);
		frmManifest.getContentPane().add(btnWithdraw);
		
		JButton btnDeposit = new JButton("Deposit");
		btnDeposit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Acc.get(i).deposit();
				textBalancevalue.setText(Acc.get(i).getBalance() + "");
			}
		});
		btnDeposit.setFont(new Font("宋体", Font.PLAIN, 20));
		btnDeposit.setBounds(10, 194, 150, 90);
		frmManifest.getContentPane().add(btnDeposit);
		
		JButton btnCheque = new JButton("Che.Deposit");
		btnCheque.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Acc.get(i).chequeDeposit();
				textUnclearvalue.setText(Acc.get(i).getUnbalance() + "");
			}
		});
		btnCheque.setFont(new Font("宋体", Font.PLAIN, 20));
		btnCheque.setBounds(10, 320, 150, 90);
		frmManifest.getContentPane().add(btnCheque);
		
		
		if(Acc.get(i).getType() == 2){
			
			JButton btnRefund = new JButton("Refund");
			btnRefund.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Acc.get(i).refund();
					textDebtvalue.setText(Acc.get(i).getOverdraw() + "");
				}
			});
			btnRefund.setFont(new Font("宋体", Font.PLAIN, 20));
			btnRefund.setBounds(524, 320, 150, 90);
			frmManifest.getContentPane().add(btnRefund);
		}
		else if(Acc.get(i).getType() == 0){
			
			JButton btnReserve = new JButton("Reservation");
			btnReserve.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					Acc.get(i).setRsvDeposit();
				}
			});
			btnReserve.setFont(new Font("宋体", Font.PLAIN, 20));
			btnReserve.setBounds(524, 320, 150, 90);
			frmManifest.getContentPane().add(btnReserve);
		}

		JButton btnSuspend = new JButton("Suspend");
		btnSuspend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Acc.get(i).suspend();
				JOptionPane.showMessageDialog(null,"You have suspend your account successfully.","Information",JOptionPane.INFORMATION_MESSAGE);
				frmManifest.dispose();
			}
		});
		btnSuspend.setFont(new Font("宋体", Font.PLAIN, 20));
		btnSuspend.setBounds(524, 66, 150, 90);
		frmManifest.getContentPane().add(btnSuspend);
		
		JButton btnDeleteacc = new JButton("Delete.Acc");
		btnDeleteacc.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete(Acc, i);
			}
		});
		btnDeleteacc.setFont(new Font("宋体", Font.PLAIN, 20));
		btnDeleteacc.setBounds(524, 194, 150, 90);
		frmManifest.getContentPane().add(btnDeleteacc);
		
		JTextPane txtpnYouCanManifest = new JTextPane();
		txtpnYouCanManifest.setText("You can manifest and get details of your account in this page.");
		txtpnYouCanManifest.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		txtpnYouCanManifest.setEditable(false);
		txtpnYouCanManifest.setBackground(SystemColor.menu);
		txtpnYouCanManifest.setBounds(135, 12, 446, 30);
		frmManifest.getContentPane().add(txtpnYouCanManifest);
		
		JTextPane textType = new JTextPane();
		textType.setText("Account Type\uFF1A");
		textType.setFont(new Font("宋体", Font.PLAIN, 16));
		textType.setEditable(false);
		textType.setBackground(SystemColor.menu);
		textType.setBounds(204, 66, 130, 30);
		frmManifest.getContentPane().add(textType);
		
		JTextPane textName = new JTextPane();
		textName.setText("Name\uFF1A");
		textName.setFont(new Font("宋体", Font.PLAIN, 16));
		textName.setEditable(false);
		textName.setBackground(SystemColor.menu);
		textName.setBounds(204, 106, 130, 30);
		frmManifest.getContentPane().add(textName);
		
		JTextPane textID = new JTextPane();
		textID.setText("Account ID\uFF1A");
		textID.setFont(new Font("宋体", Font.PLAIN, 16));
		textID.setEditable(false);
		textID.setBackground(SystemColor.menu);
		textID.setBounds(204, 146, 130, 30);
		frmManifest.getContentPane().add(textID);
		
		JTextPane textBalance = new JTextPane();
		textBalance.setText("Balance\uFF1A");
		textBalance.setFont(new Font("宋体", Font.PLAIN, 16));
		textBalance.setEditable(false);
		textBalance.setBackground(SystemColor.menu);
		textBalance.setBounds(204, 186, 130, 30);
		frmManifest.getContentPane().add(textBalance);
		
		JTextPane txtpnUnclear = new JTextPane();
		txtpnUnclear.setText("Unclear:");
		txtpnUnclear.setFont(new Font("宋体", Font.PLAIN, 16));
		txtpnUnclear.setEditable(false);
		txtpnUnclear.setBackground(SystemColor.menu);
		txtpnUnclear.setBounds(204, 226, 130, 30);
		frmManifest.getContentPane().add(txtpnUnclear);
		
		if(Acc.get(i).getType() == 2){
			JTextPane textLimit = new JTextPane();
			textLimit.setText("Overdraw Limit\uFF1A");
			textLimit.setFont(new Font("宋体", Font.PLAIN, 16));
			textLimit.setEditable(false);
			textLimit.setBackground(SystemColor.menu);
			textLimit.setBounds(204, 266, 150, 30);
			frmManifest.getContentPane().add(textLimit);
			
			JTextPane txtpnDebt = new JTextPane();
			txtpnDebt.setText("Debt\uFF1A");
			txtpnDebt.setFont(new Font("宋体", Font.PLAIN, 16));
			txtpnDebt.setEditable(false);
			txtpnDebt.setBackground(SystemColor.menu);
			txtpnDebt.setBounds(204, 306, 130, 30);
			frmManifest.getContentPane().add(txtpnDebt);
		}
		
		
		
		JTextPane textTypevalue = new JTextPane();
		switch (Acc.get(i).getType()){
		case 0:							//Saver Account
			textTypevalue.setText("Saver");
			break;
		case 1:							//Junior Account
			textTypevalue.setText("Junior");
			break;
		case 2:							//Current Account
			textTypevalue.setText("Current");
			break;
		}
		
		textTypevalue.setFont(new Font("宋体", Font.PLAIN, 16));
		textTypevalue.setEditable(false);
		textTypevalue.setBackground(SystemColor.menu);
		textTypevalue.setBounds(355, 66, 130, 30);
		frmManifest.getContentPane().add(textTypevalue);
		
		JTextPane textNamevalue = new JTextPane();
		textNamevalue.setText(Acc.get(i).getName());
		textNamevalue.setFont(new Font("宋体", Font.PLAIN, 16));
		textNamevalue.setEditable(false);
		textNamevalue.setBackground(SystemColor.menu);
		textNamevalue.setBounds(355, 106, 130, 30);
		frmManifest.getContentPane().add(textNamevalue);
		
		JTextPane textIDvalue = new JTextPane();
		textIDvalue.setText(Acc.get(i).getID());
		textIDvalue.setFont(new Font("宋体", Font.PLAIN, 16));
		textIDvalue.setEditable(false);
		textIDvalue.setBackground(SystemColor.menu);
		textIDvalue.setBounds(355, 146, 130, 30);
		frmManifest.getContentPane().add(textIDvalue);
		
		textBalancevalue = new JTextPane();
		textBalancevalue.setText(Acc.get(i).getBalance() + "");
		textBalancevalue.setFont(new Font("宋体", Font.PLAIN, 16));
		textBalancevalue.setEditable(false);
		textBalancevalue.setBackground(SystemColor.menu);
		textBalancevalue.setBounds(355, 186, 130, 30);
		frmManifest.getContentPane().add(textBalancevalue);
		
		textUnclearvalue = new JTextPane();
		textUnclearvalue.setText(Acc.get(i).getUnbalance() + "");
		textUnclearvalue.setFont(new Font("宋体", Font.PLAIN, 16));
		textUnclearvalue.setEditable(false);
		textUnclearvalue.setBackground(SystemColor.menu);
		textUnclearvalue.setBounds(355, 226, 130, 30);
		frmManifest.getContentPane().add(textUnclearvalue);
		
		if(Acc.get(i).getType() == 2){
			textLimitvalue = new JTextPane();
			textLimitvalue.setText(Acc.get(i).getCredit() + "");
			textLimitvalue.setFont(new Font("宋体", Font.PLAIN, 16));
			textLimitvalue.setEditable(false);
			textLimitvalue.setBackground(SystemColor.menu);
			textLimitvalue.setBounds(355, 266, 130, 30);
			frmManifest.getContentPane().add(textLimitvalue);
			
			textDebtvalue = new JTextPane();
			textDebtvalue.setText(Acc.get(i).getOverdraw() + "");
			textDebtvalue.setFont(new Font("宋体", Font.PLAIN, 16));
			textDebtvalue.setEditable(false);
			textDebtvalue.setBackground(SystemColor.menu);
			textDebtvalue.setBounds(355, 306, 130, 30);
			frmManifest.getContentPane().add(textDebtvalue);
		}
	}
	
	public void delete(ArrayList<Account> Acc, int i){
		Object[] options = {"Yes", "No"};
		int response = JOptionPane.showOptionDialog(null, "The account will be delete!\n Please rechek again!", "Delete", JOptionPane.YES_OPTION, JOptionPane.PLAIN_MESSAGE, null, options, options[0]);
		if(response == 0){	//choose yes
			if(Acc.get(i).getType() == 2){
				if(Acc.get(i).getOverdraw() != 0){
					JOptionPane.showMessageDialog(null,"You have to repay all the debt before you delete the account!","Information",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
			}
			JOptionPane.showMessageDialog(null,"Delete account successful!\nPlease take all the money inside your account: $" + (Acc.get(i).getBalance() + Acc.get(i).getUnbalance()),"Information",JOptionPane.INFORMATION_MESSAGE);
			Acc.remove(i);
			frmManifest.dispose();
		}
	}
}

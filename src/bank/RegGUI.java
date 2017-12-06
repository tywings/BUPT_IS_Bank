package bank;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextPane;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.Choice;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.UIManager;

public class RegGUI {

	private JFrame frmRegister;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;
	private JPasswordField PwdFir;
	private JPasswordField PwdSec;
	private JComboBox AccType;
	Calendar calendar = Calendar.getInstance();
	
	private String bufname;
	private String bufaddress;
	private int bufbirthyear = 0;
	private int bufbirthmonth = 0;
	private int bufbirthday = 0;
	private String bufbirthyearstr;
	private String bufbirthmonthstr;
	private String bufbirthdaystr;
	private boolean bufage = true;
	private String bufPIN1;
	private String bufPIN2;
	private String bufID;
	private int nowYear;
	private int nowMonth;
	private int nowDay;
	private String bufType;
	
	
	
	//getter() and setter();
	
	
	public JFrame getFrmRegister() {
		return frmRegister;
	}
	//end of getter() and setter(); 

	/**
	 * Create the application.
	 */
	//ArrayList<Account> Acc = new ArrayList<Account> ();
	public RegGUI(ArrayList<Account> Acc) {
		initialize(Acc);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(ArrayList<Account> Acc) {
		frmRegister = new JFrame();
		frmRegister.setTitle("Register");
		frmRegister.setBounds(350, 150, 700, 460);
		frmRegister.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		frmRegister.getContentPane().setLayout(null);
		
		JTextPane txtpnFollowingYouMay = new JTextPane();
		txtpnFollowingYouMay.setEditable(false);
		txtpnFollowingYouMay.setBackground(new Color(240, 240, 240));
		txtpnFollowingYouMay.setFont(new Font("Franklin Gothic Medium", Font.PLAIN, 15));
		txtpnFollowingYouMay.setText("Following you may fill in some information, \r\nwhich is necessary for you to open a new account.");
		txtpnFollowingYouMay.setBounds(60, 30, 446, 44);
		frmRegister.getContentPane().add(txtpnFollowingYouMay);
		
		JTextPane txtpnName = new JTextPane();
		txtpnName.setEditable(false);
		txtpnName.setFont(new Font("����", Font.PLAIN, 16));
		txtpnName.setBackground(new Color(240, 240, 240));
		txtpnName.setText("Name\uFF1A");
		txtpnName.setBounds(60, 100, 75, 30);
		frmRegister.getContentPane().add(txtpnName);
		
		JTextPane txtpnAddress = new JTextPane();
		txtpnAddress.setEditable(false);
		txtpnAddress.setText("Address\uFF1A");
		txtpnAddress.setFont(new Font("����", Font.PLAIN, 16));
		txtpnAddress.setBackground(SystemColor.menu);
		txtpnAddress.setBounds(60, 150, 75, 30);
		frmRegister.getContentPane().add(txtpnAddress);
		
		JTextPane txtpnBirthday = new JTextPane();
		txtpnBirthday.setEditable(false);
		txtpnBirthday.setText("Birthday\uFF1A");
		txtpnBirthday.setFont(new Font("����", Font.PLAIN, 16));
		txtpnBirthday.setBackground(SystemColor.menu);
		txtpnBirthday.setBounds(60, 200, 75, 30);
		frmRegister.getContentPane().add(txtpnBirthday);
		
		textName = new JTextField();
		textName.setBounds(200, 100, 150, 30);
		frmRegister.getContentPane().add(textName);
		textName.setColumns(10);
		
		textAddress = new JTextField();
		textAddress.setColumns(10);
		textAddress.setBounds(200, 150, 150, 30);
		frmRegister.getContentPane().add(textAddress);
		
		textYear = new JTextField();
		textYear.setColumns(10);
		textYear.setBounds(200, 200, 150, 30);
		frmRegister.getContentPane().add(textYear);
		
		textMonth = new JTextField();
		textMonth.setColumns(10);
		textMonth.setBounds(200, 250, 150, 30);
		frmRegister.getContentPane().add(textMonth);
		
		textDay = new JTextField();
		textDay.setColumns(10);
		textDay.setBounds(200, 300, 150, 30);
		frmRegister.getContentPane().add(textDay);
		
		JTextPane txtpnYear = new JTextPane();
		txtpnYear.setForeground(UIManager.getColor("Button.disabledForeground"));
		txtpnYear.setEditable(false);
		txtpnYear.setText("Year\uFF1A");
		txtpnYear.setFont(new Font("����", Font.PLAIN, 16));
		txtpnYear.setBackground(SystemColor.menu);
		txtpnYear.setBounds(145, 200, 46, 30);
		frmRegister.getContentPane().add(txtpnYear);
		
		JTextPane txtpnMonth = new JTextPane();
		txtpnMonth.setForeground(UIManager.getColor("Button.disabledForeground"));
		txtpnMonth.setEditable(false);
		txtpnMonth.setText("Month\uFF1A");
		txtpnMonth.setFont(new Font("����", Font.PLAIN, 16));
		txtpnMonth.setBackground(SystemColor.menu);
		txtpnMonth.setBounds(145, 250, 55, 30);
		frmRegister.getContentPane().add(txtpnMonth);
		
		JTextPane txtpnDay = new JTextPane();
		txtpnDay.setForeground(UIManager.getColor("Button.disabledForeground"));
		txtpnDay.setEditable(false);
		txtpnDay.setText("Day\uFF1A");
		txtpnDay.setFont(new Font("����", Font.PLAIN, 16));
		txtpnDay.setBackground(SystemColor.menu);
		txtpnDay.setBounds(145, 300, 46, 30);
		frmRegister.getContentPane().add(txtpnDay);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//ȷ����ť�������жϴ�ֵ��arraylistд��׶�
				submit(Acc);
			}
		});
		btnSubmit.setBounds(145, 356, 100, 40);
		frmRegister.getContentPane().add(btnSubmit);
		
		JButton btnDiscard = new JButton("Discard");
		btnDiscard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//�ر�Register����
				frmRegister.dispose();
			}
		});
		btnDiscard.setBounds(448, 356, 100, 40);
		frmRegister.getContentPane().add(btnDiscard);
		
		JTextPane textAccType = new JTextPane();
		textAccType.setText("Acc Type\uFF1A");
		textAccType.setFont(new Font("����", Font.PLAIN, 16));
		textAccType.setEditable(false);
		textAccType.setBackground(SystemColor.menu);
		textAccType.setBounds(411, 96, 89, 44);
		frmRegister.getContentPane().add(textAccType);
		
		AccType = new JComboBox();
		AccType.setModel(new DefaultComboBoxModel(new String[] {"Saver", "Junior", "Current"}));
		AccType.setBounds(502, 100, 148, 30);
		frmRegister.getContentPane().add(AccType);
		
		PwdFir = new JPasswordField();
		PwdFir.setBounds(502, 150, 148, 30);
		frmRegister.getContentPane().add(PwdFir);
		
		JTextPane textPwdFir = new JTextPane();
		textPwdFir.setText("Password\uFF1A");
		textPwdFir.setFont(new Font("����", Font.PLAIN, 16));
		textPwdFir.setEditable(false);
		textPwdFir.setBackground(SystemColor.menu);
		textPwdFir.setBounds(411, 150, 86, 30);
		frmRegister.getContentPane().add(textPwdFir);
		
		JTextPane textPwdSec = new JTextPane();
		textPwdSec.setText("Password\uFF1ARecheck");
		textPwdSec.setFont(new Font("����", Font.PLAIN, 16));
		textPwdSec.setEditable(false);
		textPwdSec.setBackground(SystemColor.menu);
		textPwdSec.setBounds(397, 200, 103, 51);
		frmRegister.getContentPane().add(textPwdSec);
		
		PwdSec = new JPasswordField();
		PwdSec.setBounds(502, 200, 148, 30);
		frmRegister.getContentPane().add(PwdSec);
	}
	
	/*̫Զ�˿�����������
	 * private JFrame frmRegister;
	private JTextField textName;
	private JTextField textAddress;
	private JTextField textYear;
	private JTextField textMonth;
	private JTextField textDay;
	
	private String bufname;
	private String bufaddress;
	private int bufbirthyear = 0;
	private int bufbirthmonth = 0;
	private int bufbirthday = 0;
	private String bufbirthyearstr;
	private String bufbirthmonthstr;
	private String bufbirthdaystr;
	private boolean bufage = true;
	private String bufPIN1;
	private String bufPIN2;
	private int bufID;
	private int nowYear;
	private int nowMonth;
	private int nowDay
	private String bufType;
	
	Calendar calendar = Calendar.getInstance();*/
	
	private void submit(ArrayList<Account> Acc){
		bufname = textName.getText();
		bufaddress = textAddress.getText();
		bufbirthyearstr = textYear.getText();
		bufbirthmonthstr = textMonth.getText();
		bufbirthdaystr = textDay.getText();
		bufPIN1 = PwdFir.getText();
		bufPIN2 = PwdSec.getText();
		bufType = AccType.getSelectedItem().toString();
		
		
		if(bufname.isEmpty() || bufaddress.isEmpty() || bufbirthyearstr.isEmpty() || bufbirthmonthstr.isEmpty() || bufbirthdaystr.isEmpty() || bufPIN1.isEmpty() || bufPIN2.isEmpty()){
			JOptionPane.showMessageDialog(null,"Please input all the items!","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		else{
			try{
				
				bufbirthyear = Integer.parseInt(bufbirthyearstr);
				bufbirthmonth = Integer.parseInt(bufbirthmonthstr);
				bufbirthday = Integer.parseInt(bufbirthdaystr);
			}
			catch(Exception e){
				JOptionPane.showMessageDialog(null,"You have to input integer number \nlike 2016-5-16 in the birthday textbox.","Information",JOptionPane.INFORMATION_MESSAGE);
				return ;
			}
		}
		
		nowYear = calendar.get(Calendar.YEAR);
		nowMonth = calendar.get(Calendar.MONTH);
		nowDay = calendar.get(Calendar.DATE);
		
		if(bufbirthyear >= calendar.get(Calendar.YEAR) || bufbirthyear < 1900 || bufbirthmonth < 1 || bufbirthmonth > 12 || bufbirthday < 1 || bufbirthday > 31){
			JOptionPane.showMessageDialog(null,"Please input the right format of date.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		
		//true>16
		if((nowYear - bufbirthyear) < 16){
			bufage = false;
		}
		else if((nowYear - bufbirthyear) == 16){
			if(nowMonth < bufbirthmonth){
				bufage = false;
			}
			else if(nowMonth == bufbirthmonth){
				if(nowDay < bufbirthday){
					bufage = false;
				}
			}
		}
		
		if(!bufPIN1.equals(bufPIN2)){
			JOptionPane.showMessageDialog(null,"The two passwords are not the same!\nPlease check your password again.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		else{
			if(bufType.equals("Junior")){
				if(bufage){
					JOptionPane.showMessageDialog(null,"Junior Account can only be created by people\nwho is less than 16.\nPlease choose other account.","Information",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				else{
					//JuniorAccount 12000
					JuniorAccount JunAcc = new JuniorAccount();
					JunAcc.setName(bufname);
					JunAcc.setAddress(bufaddress);
					JunAcc.setBirthYear(bufbirthyear);
					JunAcc.setBirthMonth(bufbirthmonth);
					JunAcc.setPIN(bufPIN1);
					bufID = ((100001+Acc.size()) + "");
					JunAcc.setID(bufID);
					Acc.add(JunAcc);
				}
			}
			else{
				if(!bufage){
					JOptionPane.showMessageDialog(null,"Under 16 can only create Junior Account.\nPlease choose Junior Account.","Information",JOptionPane.INFORMATION_MESSAGE);
					return ;
				}
				else{
					if(bufType.equals("Saver")){
						
						SaverAccount SavAcc = new SaverAccount();
						SavAcc.setName(bufname);
						SavAcc.setAddress(bufaddress);
						SavAcc.setBirthYear(bufbirthyear);
						SavAcc.setBirthMonth(bufbirthmonth);
						SavAcc.setPIN(bufPIN1);
						bufID = ((10001+Acc.size()) + "");
						SavAcc.setID(bufID);
						Acc.add(SavAcc);
					}
					else if(bufType.equals("Current")){
						
						CurrentAccount CurAcc = new CurrentAccount();
						CurAcc.setName(bufname);
						CurAcc.setAddress(bufaddress);
						CurAcc.setBirthYear(bufbirthyear);
						CurAcc.setBirthMonth(bufbirthmonth);
						CurAcc.setPIN(bufPIN1);
						bufID = ((10001+Acc.size()) + "");
						CurAcc.setID(bufID);
						Acc.add(CurAcc);
					}
				}
			}
		}
		
		JOptionPane.showMessageDialog(null,"Submit Successful.\nYou have created a new account!\nThe account ID is " + bufID + " .","Information",JOptionPane.INFORMATION_MESSAGE);
		frmRegister.dispose();
	}
}

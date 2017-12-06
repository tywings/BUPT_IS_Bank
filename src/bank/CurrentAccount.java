package bank;

import javax.swing.JOptionPane;


public class CurrentAccount extends Account {
	private int overdrawlimit = credit;	//credit�ķ������ǿ�͸֧��Ǯ��
	private int overdraw = 0;			//ծ
	
	public CurrentAccount (){
		type = 2;
	}
	
	public int getOverdraw() {
		return overdraw;
	}

	public void withdraw(){		
		int withdraw;
		
		String withdrawStr = JOptionPane.showInputDialog("Please input the value that you would like to deposit: ");
		try{
			withdraw = Integer.parseInt(withdrawStr);
			//JOptionPane.showMessageDialog(null,"You have withdrawed successfully.","Information",JOptionPane.INFORMATION_MESSAGE);
			if(withdraw <= balance){
				balance -= withdraw;
				JOptionPane.showMessageDialog(null,"You have withdraw $" + withdraw + " successfully!","Information",JOptionPane.INFORMATION_MESSAGE);
				//System.out.println("You have withdraw $" + withdraw + " successfully!");
				//System.out.println("You remain $" + balance + " in your account.");
				return ;
			}
			else if(withdraw > balance && withdraw <= (balance + overdrawlimit - overdraw)){
				overdraw += (withdraw - balance);
				balance = 0;
				JOptionPane.showMessageDialog(null,"You have withdraw $" + withdraw + " successfully!\n"
						+ "You remain $" + balance + " in your account.\n"
								+ "You have to repay $" + overdraw + " as soon as possible.\n"
										+ "You can still overdraw $"
											+ (overdrawlimit - overdraw),"Information",JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("You have withdraw $" + withdraw + " successfully!");
//				System.out.println("You remain $" + balance + " in your account.");
//				System.out.println("You have to repay $" + overdraw + " as soon as possible.");
//				System.out.println("You can still overdraw $" + (overdrawlimit - overdraw));
			}
			else{
				JOptionPane.showMessageDialog(null,"You can't withdraw more than your balance!","Information",JOptionPane.INFORMATION_MESSAGE);
				return ;
				//System.out.println("You can't withdraw more than your balance.!");
			}		
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Input Invalid.\nPlease try again.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}		
	}
	
	public void refund(){		
		int refund;
		
		String refundStr = JOptionPane.showInputDialog("Please input the value that you would like to deposit: ");
		
		try{
			refund = Integer.parseInt(refundStr);
			
			if(overdraw == 0){
				JOptionPane.showMessageDialog(null,"You have no debt to overdraw.","Information",JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("You have no debt to overdraw.");
			}
			else if(refund <= overdraw){
				overdraw = overdraw - refund;
				JOptionPane.showMessageDialog(null,"You have repaid $" + refund + " successfully.\n"
						+ "You remain have $" + overdraw + " should be repaid.","Information",JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("You have repaid $" + refund + " successfully.");
//				System.out.println("You remain have $" + overdraw + " should be repaid.");
			}
			else if(refund > overdraw){
				refund -= overdraw;
				JOptionPane.showMessageDialog(null,"You have repaid $" + overdraw + " successfullt.\nAnd you have no debt left." + "The left money &" + refund +" is handed back to you.","Information",JOptionPane.INFORMATION_MESSAGE);
//				System.out.println("You have repaid $" + overdraw + " successfullt.");
//				System.out.println("And you have no debt left.");
				overdraw = 0;
//				System.out.println("The left money &" + refund +" is handed back to you.");
			}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Input Invalid.\nPlease try again.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
		
		
	}
	
	
	public int getRsvDeposit(){
		return 0;
	}
	public void setRsvDeposit(){}
	public void setRsvDeposit(int value){}
}

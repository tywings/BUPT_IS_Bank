package bank;

import javax.swing.JOptionPane;

/*
 * 需要写取钱withdraw()方法（需要有预约功能）	ok
 * 其中关闭账户没想好
 * 
 */
public class SaverAccount extends Account {
	private int rsvDeposit = 0;		//是否有预约取款情况.0->没有（不能取款）.1->已经预约，但没有重新登陆2.->可以取款
	
	public SaverAccount (){
		type = 0;
	}
	
	public int getRsvDeposit() {
		return rsvDeposit;
	}
	public void setRsvDeposit() {	//预约
		if(rsvDeposit == 0 || rsvDeposit == 1){
			rsvDeposit = 1;
		}
		JOptionPane.showMessageDialog(null,"Reserve successful!","Information",JOptionPane.INFORMATION_MESSAGE);
	}
	public void setRsvDeposit(int value){
		rsvDeposit = 2;
	}
	
	public void withdraw(){
		int withdraw;
		
		String withdrawStr = JOptionPane.showInputDialog("Please input the value that you would like to deposit: ");
		try{
			 withdraw = Integer.parseInt(withdrawStr);
			 if(rsvDeposit == 2){
				 if(withdraw > balance){
					 JOptionPane.showMessageDialog(null,"You can't withdraw more than your balance!","Information",JOptionPane.INFORMATION_MESSAGE);
					 return ;
						//System.out.println("You can't withdraw more than your balance.!");
						//返回功能菜单
				 }
				 else{
					 balance -= withdraw;
					 rsvDeposit = 0;
					 JOptionPane.showMessageDialog(null,"You have withdraw $" + withdraw + " successfully!\n"
							 + "You remain $"  + balance + " in your account.","Information",JOptionPane.INFORMATION_MESSAGE);
					//返回功能菜单
					 return ;
				 }
			 }
			 else{
				 JOptionPane.showMessageDialog(null,"You have to reserve first!","Information",JOptionPane.INFORMATION_MESSAGE);
				 return ;
			 }
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Input Invalid.\nPlease try again.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}
	}
	
	//实现一下静态类。。
	public void refund(){}
	public int getOverdraw(){return 0;}
}

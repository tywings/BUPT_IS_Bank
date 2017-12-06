package bank;

import javax.swing.JOptionPane;

/*
 * 需要取钱withdraw()方法（普通）				ok
 * 只有16岁以下可以使用本账户（在其他类中实现）
 * 其余和saveraccount一样
 * 其中关闭账户没想好
 * 
 */
public class JuniorAccount extends Account {
	
	public JuniorAccount (){
		type = 1;
	}
	
	public void withdraw(){
		int withdraw;
		
		String withdrawStr = JOptionPane.showInputDialog("Please input the value that you would like to deposit: ");
		try{
			 withdraw = Integer.parseInt(withdrawStr);
			 if(withdraw > balance){
				 JOptionPane.showMessageDialog(null,"You can't withdraw more than your balance!","Information",JOptionPane.INFORMATION_MESSAGE);
				 return ;
					//System.out.println("You can't withdraw more than your balance.!");
					//返回功能菜单
				}
				else{
					balance -= withdraw;
					JOptionPane.showMessageDialog(null,"You have withdraw $" + withdraw + " successfully!\n"
							+ "You remain $"  + balance + " in your account.","Information",JOptionPane.INFORMATION_MESSAGE);
//					System.out.println("You have withdraw $" + withdraw + " successfully!");
//					System.out.println("You remain $" + balance + " in your account.");
					//返回功能菜单
				}
		}
		catch(Exception e){
			JOptionPane.showMessageDialog(null,"Input Invalid.\nPlease try again.","Information",JOptionPane.INFORMATION_MESSAGE);
			return ;
		}	
	}
	
	//实现一下静态类。。
		public int getRsvDeposit(){return 0;}
		public void setRsvDeposit(){}
		public void refund(){}
		public int getOverdraw(){return 0;}
		public void setRsvDeposit(int value){}
}

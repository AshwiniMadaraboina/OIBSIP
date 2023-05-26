	package atm ;
	import java.util.Scanner;
	public class AtmInterface{
		String user_id;
		String user_pin;
		int count=0;
		String mini[]=new String[5];
		int balance;
		static Scanner sc=new Scanner(System.in);
		AtmInterface(String uid,String upin,int b){
			user_id=uid;
			user_pin=upin;
			balance=b;
		}
		public void withdraw() {
			System.out.println("enter amount to be withdraw");
			int amount=sc.nextInt();
			if(balance>=amount) {
				balance=balance-amount;
				System.out.println(amount+"amount is withdrawn");
				mini[count++]="+"+amount;}

			else {
				System.out.println("Insufficient Balance");
			}
			System.out.println("Available Balance is"+balance);
		}
		public void deposit() {
			System.out.println("enter amount to be deposited");
			int amount=sc.nextInt();
			System.out.println(amount+"amount be deposited");
			balance=balance+amount;
			System.out.println("Available Balance is"+balance);
			mini[count++]="+"+amount;
		}
		public void transfer(AtmInterface a[],int n) {
			System.out.println("enter amount to be transfered");
			int i,amount=sc.nextInt();
			if(amount<=balance) {
			System.out.println("enter userid to whom you want to transfer");
			String s=sc.next();
			for(i=0;i<n;i++) {
				if(a[i].user_id.equals(s)) {
					a[i].balance=a[i].balance+amount;
					mini[count++]="-"+amount;
					balance=balance-amount;
					System.out.println("available balance is"+balance);
					break;
				}
			}if(i==n) {
				System.out.println("user_id not exist");
			}}
			else {
				System.out.println("Insufficient Balance");
			}
		}
		public void transactionhistory() {
			int i=0;
			if(count==0) {
				System.out.println("NOT DONE ANY TRANSACTIONS YET");
			}
			while(i<5 && i<count){
				if(mini[i].charAt(0)=='+') {
					System.out.println("amount credit is"+mini[i]);
				}
				else if(mini[i].charAt(0)=='-') {
					System.out.println("amount debit is"+mini[i]);
				}
				i=i+1;
			}
		}	
		public static void main(String args[]) throws Exception{
			System.out.println("no.of accounts present in bank");
			int n=sc.nextInt();
			AtmInterface a[]=new AtmInterface[n];
			for(int i=0;i<n;i++) {
				System.out.println("enter user_id ,user_pin and balance");
				String uid=sc.next();
				String upin=sc.next();
				int bal=sc.nextInt();
				a[i]=new AtmInterface(uid,upin,bal);
			}
			System.out.println("enter user_id and user_pin");
				String ui=sc.next();
				String up=sc.next();
				while(true) {
				System.out.println("enter '1' for TransactionHistory\n enter '2' for Withdraw\n enter '3' for Deposit\nenter '4' for Transfer\n  enter '5' to quit\n");
				int choice=sc.nextInt();
				switch(choice) {
				case 1:
					for(int i=0;i<n;i++) {
						if(a[i].user_id.equals(ui)) {
							a[i].transactionhistory();
							break;
						}
					}
					break;
				case 2:
					for(int i=0;i<n;i++) {
						if(a[i].user_id.equals(ui)) {
							a[i].withdraw();
							break;
						}
					}
					break;
				case 3:
					for(int i=0;i<n;i++) {
						if(a[i].user_id.equals(ui)) {
							a[i].deposit();
							break;
						}
					}
					break;
				case 4:
					for(int i=0;i<n;i++) {
						if(a[i].user_id.equals(ui)) {
							a[i].transfer(a,n);
							break;
						}
					}
					break;
			case 5:
				System.exit(0);
				}
		}
		}}

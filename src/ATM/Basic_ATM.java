package ATM;

import java.util.Scanner;

public class Basic_ATM {
    /*
    ATM
Kullanicidan giriş için kart numarasi ve şifresini isteyin, eger herhangi birini yanlis girerse tekrar isteyin.
Kart numarasi aralarda boşluk ile girerse de eger doğruysa kabul edin.
Kart numarasi ve sifre dogrulanirsa kullanicinin yapabileceği işlemleri ekrana yazdirin,

Menu listesinde Bakiye sorgula, para yatirma, para çekme, para gönderme, sifre değiştirme
ve cikis islemleri olacaktır.

Para çekme ve para gonderme işleminde mevcut bakiyeden buyuk para çekilemez,
Para gönderme işleminde istenen iban TR ile baslamali ve toplam 26 karakterli olmali, eger değilse menü ekranina
geri donsun.
Sifre değiştirme işleminde mevcut şifreyi teyit ettikten sonra, sifre değişiklik işlemini yapmali,
     */
    static double balance=100000;
    static String user_password="2122";

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        System.out.println("Please pass in your password: ");
        String password = scan.nextLine();
        System.out.println("Please pass in your card number: ");
        String card_number = scan.nextLine();

        boolean security_check = check(password, card_number);
        mainmenu(security_check);
           
       }

    public static void mainmenu(boolean security_check) {
        Scanner scan=new Scanner(System.in);
        while (true)
        {

            if (security_check) {
                System.out.println("Please choose a transaction type\n");

                System.out.println("1.Balance check" + "\n2.Withdraw money" + "\n3.Deposit money" + "\n4.Transfer money"
                        + "\n5.Change password" + "\n6.Exit");
                int number = scan.nextInt();

                switch (number) {
                    case 1:
                        System.out.println(balance);
                        break;
                    case 2:
                        System.out.println("please enter in the money you'd like to take out");
                        double money = scan.nextDouble();
                        if (money > balance)
                            System.out.println("insufficient balance!");
                        else
                            withdrawmoney(money);
                        break;
                    case 3:
                        System.out.println("Please enter in the money you deposit");
                        double deposit = scan.nextDouble();
                        depositmoney(deposit);
                        break;
                    case 4:
                        System.out.println("Please enter in the amount you send");
                        double send = scan.nextDouble();
                        if (send > balance)
                            System.out.println("insufficient balance");
                        else
                            transfermoner(send);
                        break;
                    case 5:
                        Scanner scan1=new Scanner(System.in);
                        System.out.println("Please enter in your older passport");
                        String pass=scan1.nextLine();
                        if (pass.equals(user_password))
                          changepassport();
                        else
                            System.out.println("wrong password!!");
                        break;
                    case 6:
                        System.exit(0);
                    default:
                        System.out.println("Please pass in a number 1-6!");
                }
            }

        }

    }
    public static void changepassport() {
        Scanner scan1=new Scanner(System.in);
        System.out.println("Please tap in your new passport.It should have four digits.");
        user_password= scan1.nextLine();
        System.out.println("your passport was changed successfully!");
        mainmenu(true);
    }

    public static void transfermoner(double send) {
        String user_iban="TR1234567890";
        Scanner scan=new Scanner(System.in);
        System.out.println("Please tap in your iban no:");
        String iban=scan.nextLine();

        if (iban.equals(user_iban)) {
            balance=balance-send;
            System.out.println("sent!");
        }else
            mainmenu(true);

    }

    public static void depositmoney(double deposit) {
        balance=balance+deposit;
        System.out.println("Your money has been deposited");
    }

    public static void withdrawmoney(double money) {
        balance=balance-money;
        System.out.println("Please collect your money");
    }
    public static boolean check(String password,String card_number)
    {
        String user_card_number= "1234567890";

        if (password.equals(user_password)) {
            if (card_number.contains(" "))
                card_number=card_number.replace(" ","");

            return card_number.equals(user_card_number);
        }

        return false;
    }

}

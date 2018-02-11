import java.net.*;
import java.util.Scanner;

public class Sms{
    public static void main(String [] args){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter recipient: ");
        String recipient = input.nextLine();
        System.out.print("Enter message: ");
        String msg = input.nextLine();;
        try{
            String email = URLEncoder.encode("junaries16@gmail.com", "UTF-8");
            String password = URLEncoder.encode("070417", "UTF-8"); //eto yung credentials na ginamit mo nung nag-sign up ka
            String device = URLEncoder.encode("68641", "UTF-8");
            String number = URLEncoder.encode(recipient, "UTF-8"); //number ng recipient
            String message = URLEncoder.encode(msg, "UTF-8");
            
            String gateway = "http://smsgateway.me/api/v3/messages/send?";
            gateway += "email=" +email;
            gateway += "&password=" +password;
            gateway += "&device=" +device;
            gateway += "&number=" +number;
            gateway += "&message=" +message;
            
            URL url = new URL(gateway);
            HttpURLConnection conn = (HttpURLConnection)url.openConnection();
            conn.setRequestMethod("POST");
            
            //optional lang yung susunod na line kase ayaw magsend kapag wala 'to lol
            System.out.println("Method: " +conn.getRequestMethod() +"\nStatus code: " +conn.getResponseCode() +"\nResponse Message: " +conn.getResponseMessage());
        }
        catch(Exception e){
        }
    }
}
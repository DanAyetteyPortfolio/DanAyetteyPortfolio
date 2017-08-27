package clientPackage;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.*;

/**
 * Created by Ayettey on 24/11/2016.
 */

@ManagedBean(name = "login" ,eager = true)
@RequestScoped
public class Login{



    private String emailAndPhone;
    private String secretPassword;
    private String fullName;
    private String dateOfBirth;
    private String email;
    private String street;
    private String state;
    private String country;
    private String postCode;
    private String streetNumber;



    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getFullName() {
        return fullName;
    }

   // public void setFullName(String fullName) {
    //    this.fullName = fullName;
   // }



    public void setEmailAndPhone(String emailAndPhone) {
        this.emailAndPhone = emailAndPhone;
    }

    public void setSecretPassword(String secretPassword) {
        this.secretPassword = secretPassword;
    }



    public String getEmailAndPhone() {
        return emailAndPhone;
    }

    public String getSecretPassword() {
        return secretPassword;
    }


    public String login(){


        int count=0;

        try {

            Connection connection=null;
            PreparedStatement statement=null;
            emailAndPhone="danni.ayette@gmail.com";
            secretPassword="mother30";

         if(!emailAndPhone.equals("")){


                Class.forName("com.mysql.jdbc.Driver");

                System.out.println("Connecting.....");
                connection= DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinimax", "root", "0000");
                String sql="SELECT*FROM kunder";
                statement=connection.prepareStatement(sql);


                ResultSet result=statement.executeQuery();

                while (result.next()){

                    final String phoneAndEmail=getEmailAndPhone();
                    final String ID=getSecretPassword();

                    if(phoneAndEmail.equals(result.getString("email")) && ID.equals(result.getString("password"))){
                        setFullName(result.getString("fistName") );
                       return "clientAccount";
                    }else{

                        return "invalid";
                    }





                }
                System.out.println("USer  :"+secretPassword);
                System.out.println("success.....");
         }

        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


        return "";
    }


    public static void main(String [] arg){

       Login login= new Login();
       login.login();
       System.out.println(login.getFullName());



    }



}

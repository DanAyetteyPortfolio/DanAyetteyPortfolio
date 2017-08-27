package clientPackage;


import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

/**
 * Created by Ayettey on 19/11/2016.
 */

@ManagedBean( name = "register",eager = true)
@SessionScoped
public class Register{


       private String firstName;
       private String surname;
       private String emailOrMobileNumber;
       private String secretID;
       private  int ID;
       private String reenterSecretID;
       private String day;
       private String month;
       private String year;
       private boolean isMale;
       private boolean isFemale;
       private String Male;
       private String Female;
       private String dateOfBirth;

    public String getDateOfBirth() {
        return day+"/"+month+"/"+year;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmailOrMobileNumber(String emailOrMobileNumber) {
        this.emailOrMobileNumber = emailOrMobileNumber;
    }

    public void setSecretID(String secretID) {
        this.secretID = secretID;
    }

    public void setReenterSecretID(String reenterSecretID) {
        this.reenterSecretID = reenterSecretID;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setIsFemale(boolean  isFemale) {
        this.isFemale = isFemale;
    }

    public void setIsMale(boolean isMale) {
        this.isMale = isMale;
    }

    public String getYear() {
        return year;
    }


    public boolean getIsFemale() {
        return isFemale;
    }

    public boolean getIsMale() {
        return isMale;
    }

    public String getDay() {
        return day;
    }

    public String getEmailOrMobileNumber() {
        return emailOrMobileNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getFullName(){

        return "Welcome " + firstName + "" +surname;

    }
    public String getMonth() {
        return month;
    }

    public String getReenterSecretID() {
        return reenterSecretID;
    }

    public String getSecretID() {
        return secretID;
    }

    public String getSurname() {
        return surname;
    }

    public void setFemale(String female) {
        Female = female;
    }

    public void setMale(String male) {
        Male = male;
    }

    public String getFemale() {
        return Female;
    }

    public String getMale() {
        return Male;
    }








    public String insert () {


        int count = 0;




            try {

                if(!firstName.equals("")) {
                    PreparedStatement ps = null;
                    Connection con = null;

                    Class.forName("com.mysql.jdbc.Driver");
                    con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Cinimax", "root", "0000");
                    String sql = "INSERT INTO kunder(id,fistName, lastName, email, password, reenterPassword, dateOfBirth, gender) VALUES(?,?,?,?,?,?,?,?)";
                    ps = con.prepareStatement(sql);
                    dateOfBirth=getDay()+"/"+getMonth()+"/"+getYear();

                    String birthDateAsAnId=getDay()+getMonth()+getYear();
                    ps.setString(1,birthDateAsAnId);
                    ps.setString(2, getFirstName());
                    ps.setString(3, getSurname());
                    ps.setString(4, getEmailOrMobileNumber());
                    ps.setString(5, getSecretID());
                    ps.setString(6, getReenterSecretID());
                    ps.setString(7, getDateOfBirth());
                    ps.setString(8, getFemale());



                   count=ps.executeUpdate();


                    System.out.println("Successful");
                }
            } catch (ClassNotFoundException e) {
                e.printStackTrace();

            } catch (Exception x) {

                x.printStackTrace();
            }


            if (count > 0) {
                return "clientAccount";
            } else return "invalid";




        }





    @Override
    public String toString() {
        return super.toString();
    }
}

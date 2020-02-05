package Spring;

import java.io.*;
import javax.persistence.*;

@Entity
public class BuddyInfo  {

    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private String address, name, phonenumber;
    private Integer id;

    public BuddyInfo() {
        // TODO Auto-generated constructor stub
    }


    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    public BuddyInfo(String name, String address, String phonenum)
    {
        this.name = name;
        this.address = address;
        this.phonenumber = phonenum;
    }

    public String getAddress(){
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public void setNum(String num) {
        this.phonenumber = num;
    }

    @Transient
    public String getPhonenumber() {
        return phonenumber;
    }

    public void Phonenumber(String phonenumber){
        this.phonenumber = phonenumber;
    }
    //public String toString() {
    //    return this.name +","+this.address+","+ this.phonenumber;
    //}

    @Override
    public String toString() {
        return  "id: " + this.id + ", name: " + this.name +", address: "+this.address+", phone number: "+ this.phonenumber;
    }

    public static void main (String []args) {
        String name = "test,test,test";
        BuddyInfo bud = BuddyInfo.importBuddy(name);
        System.out.println(bud);
    }

    public static BuddyInfo importBuddy(String buddy) {
        String[] read;
        read = buddy.split(",");
        BuddyInfo newBud = new BuddyInfo (read[0],read[1],read[2]);
        return newBud;
    }

}

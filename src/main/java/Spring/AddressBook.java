package Spring;

import org.springframework.stereotype.Component;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.*;
import javax.swing.JOptionPane;

@Component
@Entity
public class AddressBook implements Serializable {


    List<BuddyInfo> buddyCollection;
    private static BufferedWriter out;
    private static AddressBook importBook;
    private Integer id;

    public AddressBook() {
        // TODO Auto-generated constructor stub
        buddyCollection = new ArrayList<BuddyInfo>();
    }

    @Id
    public Integer getId(){
        return this.id;
    }

    public void setId(Integer id){
        this.id = id;
    }

    @OneToMany (cascade = CascadeType.PERSIST)
    public Collection<BuddyInfo> getBuddy() {
        return buddyCollection;
    }

    public void editBook(int index, BuddyInfo bd) {
        buddyCollection.set(index, bd);
    }

    public void setBuddy (Collection<BuddyInfo> buddyCollection){
        this.buddyCollection = (List<BuddyInfo>) buddyCollection;
    }

    public void setAddress(List<BuddyInfo> address) {
        this.buddyCollection = address;
    }

    public void addBuddy(BuddyInfo B){
        buddyCollection.add(B);
    }

    public void addBuddy (String name, String address,String number){
        addBuddy(new BuddyInfo(name, address, number));
    }

    public void removeBuddy(BuddyInfo B) {
        buddyCollection.remove(B);
    }

    public Boolean removeBuddy(String name) {
        BuddyInfo temp =null;
        for(BuddyInfo bud : buddyCollection){
            if (bud.getName().equals(name)){
                temp = bud;
                break;
            }
        }
        return buddyCollection.remove(temp);
    }

    public void removeBuddy(int index) {
        buddyCollection.remove(index);
    }

    public BuddyInfo get(int i) {
        return buddyCollection.get(i);
    }

    public int size() {
        return buddyCollection.size();
    }
    /*public String toString() {
        String str="";
        for (Spring.BuddyInfo bud : this.buddyCollection) {
            str+=bud.toString()+"\n";
        }
        return str;
    }*/

    @Override
    public String toString(){
        String str="";
        for (BuddyInfo bud : this.buddyCollection) {
            str+=bud.toString()+"\n";
        }
        return " [id =" + id + "], "+ str ;
    }

    public static void main (String []args) {
        BuddyInfo bud, bud1, bud2, bud3;

        bud = new BuddyInfo ("test", "address", "num");
        bud1 = new BuddyInfo ("test1", "add1", "num1");
        bud2 = new BuddyInfo ("test2", "add2", "num2");
        bud3 = new BuddyInfo ("test3", "add3", "num3");

        AddressBook book = new AddressBook();

        book.addBuddy(bud);
        book.addBuddy(bud1);
        book.addBuddy(bud2);
        book.addBuddy(bud3);

        System.out.println(book.toString());
    }

    public static void export(String fileName, AddressBook aBook) {
        try {
            out = new BufferedWriter(new FileWriter(fileName));
            out.write(aBook.toString());
            out.close();
        }
        catch(FileNotFoundException fnfe) {
            JOptionPane.showMessageDialog(null, "Uh Oh, couldnt find the file specified. Please try again.");
        }
        catch(IOException ie) {
            JOptionPane.showMessageDialog(null, "Seems like there was an error writing to your file. Please try again.");
        }
        catch (Exception ee) {
            JOptionPane.showMessageDialog(null, "Seems like there was an unknown issue, please try again.");
        }
    }
    public static AddressBook importAddressBook (String file) {
        try {
            importBook = new AddressBook();
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;
            while((line = bufferedReader.readLine()) != null) {
                importBook.addBuddy(BuddyInfo.importBuddy(line));
            }
            return importBook;
        }
        catch(FileNotFoundException fe){
            JOptionPane.showMessageDialog(null, "Uh Oh, couldnt find the file specified. Please try again.");
        }
        catch (IOException ioe) {
            JOptionPane.showMessageDialog(null, "Seems like there was an error reading to your file. Please try again.");
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Seems like there was an unknown issue, please try again.");
        }
        finally {
            return importBook;
        }
    }

}

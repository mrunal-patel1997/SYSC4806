package Spring;//import Spring.AddressBook.example.SimpleAddressBook.Model.Spring.AddressBook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import javax.swing.*;
@Component

public class AddressBookController {

    @Qualifier("addressBook")
    @Autowired
    private AddressBook model;
    @Qualifier("addressBookGui")
    @Autowired
    private AddressBookGui view;

    @Autowired
    private BuddyInfoRepository buddyInfoRepository;


    @Autowired
    public AddressBookController(){

    }


    public AddressBookController (AddressBookGui view, AddressBook model) {

        this.view = view;
        this.model = model;
        initController();
    }


    public void initController() {

        view.getAdd().addActionListener(e -> addBuddy());
        view.getRemove().addActionListener(e -> removeBuddy());
        view.getDisplay().addActionListener(e -> displayBook());
        view.getCreate().addActionListener(e -> createAddressBook());

    }

    public void createAddressBook() {

        model = new AddressBook();
        view.getField().setText("New Address Book Created");
        view.getDisplayArea().setText("");
    }

    public void displayBook() {

        if (model == null)
            view.getDisplayArea().setText("No Address book Created");
        else
            view.getDisplayArea().setText(model.toString());

    }

    public void addBuddy() {

        if (model == null)
            view.getDisplayArea().setText("No Address book Created");
        else {
            String name = JOptionPane.showInputDialog("Please enter the buddy's name");
            String address = JOptionPane.showInputDialog("Please enter the buddy's address");
            String number = JOptionPane.showInputDialog("Please enter the buddy's number");
            model.addBuddy(name, address, number);
            displayBook();
        }
    }

    public void removeBuddy() {

        if (model == null)
            view.getDisplayArea().setText("No Address book Created");
        else {
            String name = JOptionPane.showInputDialog("Please enter the buddy's name");
            if (model.removeBuddy(name)) {
                view.getDisplayArea().setText("Buddy Removed");
            } else {
                view.getDisplayArea().setText("Buddy not found");
            }
        }
    }

    public static void main(String[] args) {

        AddressBook model = new AddressBook();
        AddressBookGui view = new AddressBookGui();
        AddressBookController controller = new AddressBookController(view, model);
        controller.initController();
    }
}

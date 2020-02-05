package Spring;

import org.springframework.stereotype.Component;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.*;

@Component
public class AddressBookGui extends JFrame {

	private JFrame jFrame;
	private JMenuBar jMenuBar;
	private JMenu address;
	private JMenu buddy;
	private JMenuItem create;
	private JMenuItem display;
	private JMenuItem add;
	private JMenuItem remove;
	private JMenuItem database;
	private JLabel field;
	private JTextArea displayArea;


	public AddressBookGui() {
		jFrame = new JFrame();// creating instance of JFrame
		jMenuBar = new JMenuBar();
		field = new JLabel();
		displayArea = new JTextArea();
		address = new JMenu("Address Book");
		buddy = new JMenu("Buddy Options");

		address.setMnemonic(KeyEvent.VK_A);
		address.getAccessibleContext().setAccessibleDescription(
				"Spring.AddressBook Options");

		create = new JMenuItem("Create Address Book", KeyEvent.VK_T);
		create.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));

		display = new JMenuItem("Display Address Book", KeyEvent.VK_T);
		display.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));

		add = new JMenuItem("Add Buddy", KeyEvent.VK_T);
		add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_1,
				ActionEvent.ALT_MASK));

		remove = new JMenuItem("Remove Buddy", KeyEvent.VK_R);
		add.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_R,
				ActionEvent.ALT_MASK));

		address.add(create);
		address.add(display);
		buddy.add(add);
		buddy.add(remove);
		jMenuBar.add(address);
		jMenuBar.add(buddy);
		jFrame.add(displayArea, BorderLayout.WEST);
		jFrame.add(field, BorderLayout.SOUTH);
		jFrame.setJMenuBar(jMenuBar);
		jFrame.setSize(400, 500);
		jFrame.setLocationRelativeTo(null);
		jFrame.setVisible(true);
	}

	public JFrame getjFrame() {
		return jFrame;
	}

	public void setjFrame(JFrame jFrame) {
		this.jFrame = jFrame;
	}

	public JMenuBar getjMenuBar() {
		return jMenuBar;
	}

	public void setjMenuBar(JMenuBar jMenuBar) {
		this.jMenuBar = jMenuBar;
	}

	public JMenu getAddress() {
		return address;
	}

	public void setAddress(JMenu address) {
		this.address = address;
	}

	public JMenu getBuddy() {
		return buddy;
	}

	public JMenuItem getRemove() {
		return remove;
	}

	public void setRemove(JMenuItem remove) {
		this.remove = remove;
	}

	public void setBuddy(JMenu buddy) {
		this.buddy = buddy;
	}

	public JMenuItem getCreate() {
		return create;
	}

	public void setCreate(JMenuItem create) {
		this.create = create;
	}

	public JMenuItem getDisplay() {
		return display;
	}

	public void setDisplay(JMenuItem display) {
		this.display = display;
	}

	public JMenuItem getAdd() {
		return add;
	}

	public void setAdd(JMenuItem add) {
		this.add = add;
	}

	public JLabel getField() {
		return field;
	}

	public void setField(JLabel field) {
		this.field = field;
	}

	public JTextArea getDisplayArea() {
		return displayArea;
	}

	public void setDisplayArea(JTextArea displayArea) {
		this.displayArea = displayArea;
	}

	public void setController(Object controller) {
		//this.controller = controller;
	}

	public void getController() {
		//return controller;
	}
}
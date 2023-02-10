package labs.lab9;

import java.awt.BorderLayout;
import java.awt.GridLayout;


import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;

public class UI extends JFrame {
	private static final int FRAME_WIDTH = 1200;
	private static final int FRAME_HEIGHT = 400;
	JMenuBar menuBar;
	JMenu fileMenu;
	JMenuItem exitItem;
	
	JButton toggleButton;
	JButton deleteButton;
	DefaultListModel<String> model;
	JList<String> li;
	
	JTextField item;
	JTextField priority;
	JCheckBox deadlineCheckBox;
	JComboBox<String> month;
	JComboBox<String> day;
	JComboBox<String> year;
	JTextArea note;
	
	JButton saveItemButton;
	JButton newItemButton;
	
	JPanel rightButtonPanel;
	
	JPanel listUIPanle;
	String[] months = {"January","February","March","April","May",
			"June","July","August","September","October","November","December"};


	public UI() {
		menu();
		this.setLayout(new GridLayout(1,2));
		listUI();
		add(itemUI());
		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setTitle("Zhaoyang Lu - 30735594");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		
		
	}
	
	public static void popup() {
		JOptionPane popup = new JOptionPane();
		JOptionPane.showMessageDialog(popup, "Invalid Input!");
	}
	
	
	public static void popupSave() {
		JOptionPane popup = new JOptionPane();
		JOptionPane.showMessageDialog(popup, "Item saved!");
	}

	private void menu() {
		menuBar = new JMenuBar();
		fileMenu = new JMenu("File");
		menuBar.add(fileMenu);
		exitItem = new JMenuItem("Exit");

				
		fileMenu.add(exitItem);
		setJMenuBar(menuBar);
	}
	
	public JMenuItem getExitItem() {
		return exitItem;
	}
	
	
	public JButton gettoggleButton() {
		return toggleButton;
	}
	
	
	public JButton getdeleteButton() {
		return deleteButton;
	}
	
	public JButton getsaveItemButton() {
		return saveItemButton;
	}
	
	public JButton getnewItemButton() {
		return newItemButton;
	}
	
	public JTextField getItem() {
		return item;
	}
	
	public JTextField getPriority() {
		return priority;
	}
	
	public boolean getDeadlineCheckBox() {
		if (deadlineCheckBox.getSelectedObjects() != null) {
			return true;
		}else {
			return false;
		}
	}
	
	public JCheckBox getDeadlineCheckBoxItem() {
		return deadlineCheckBox;
	}
	
	public int getMonth(){
		//changing str month to int annoying, maybe using map is better
		switch (month.getSelectedItem().toString()) {
		case "January": return 1;
		case "February": return 2;
		case "March": return 3;
		case "April": return 4;
		case "May": return 5;
		case "June": return 6;
		case "July": return 7;
		case "August": return 8;
		case "September": return 9;
		case "October": return 10;
		case "November": return 11;
		case "December": return 12;
		}
		return 0;
	}
	
	public static String getInttoMonth(int monthnumber){
		//changing str month to int annoying, maybe using map is better
		switch (monthnumber) {
		case 1: return "January";
		case 2: return "February";
		case 3: return "March";
		case 4: return "April";
		case 5: return "May";
		case 6: return "June";
		case 7: return "July";
		case 8: return "August";
		case 9: return "September";
		case 10: return "October";
		case 11: return "November";
		case 12: return "December";
		}
		return "";
	}
	
	public JComboBox<String> getMonthItem(){
		return month;
	}
	
	public int getDay(){
		return Integer.valueOf(day.getSelectedItem().toString());
	}
	
	public JComboBox<String> getDayItem(){
		return day;
	}
	
	public int getYear(){
		return Integer.valueOf(year.getSelectedItem().toString());
	}
	
	public JComboBox<String> getYearItem(){
		return year;
	}
	
	public JTextArea getNote() {
		return note;
	}
	

	
	public JList<String> getToDoList(){
		return li;
	}
	
	public DefaultListModel<String> getToDoListModel(){
		return model;
	}
	
	
	private void listUI() {
		listUIPanle = new JPanel();
		rightButtonPanel = new JPanel();
		model = new DefaultListModel<>();
		li = new JList<String>(model);
		
		toggleButton = new JButton("Toggle Done");
		
		rightButtonPanel.add(toggleButton);
		
		
		deleteButton = new JButton("Delete");
		
		
		rightButtonPanel.add(deleteButton);
		
		rightButtonPanel.setLayout(new GridLayout(2,1));

		listUIPanle.setLayout(new BorderLayout());
		listUIPanle.add(rightButtonPanel, BorderLayout.EAST);
		listUIPanle.add(li, BorderLayout.CENTER);
		listUIPanle.setBorder(new TitledBorder(new EtchedBorder(), "ToDo List"));
		
		add(listUIPanle);
	}
	
	private JPanel itemUI(){
		JPanel p = new JPanel();
		//Panels
		JPanel itemPanel = new JPanel();
		JPanel priorityPanel = new JPanel();
		JPanel timePanel = new JPanel();
		JPanel notePanel = new JPanel();
		JPanel lowTwoBPanel = new JPanel();
		JPanel monthPanel = new JPanel();
		JPanel dayPanel = new JPanel();
		JPanel yearPanel = new JPanel();
		
		
		//set Layout managers
		p.setLayout(new GridLayout(5,1));
		timePanel.setLayout(new GridLayout(1,4));
		notePanel.setLayout(new BorderLayout());
		
		
		//create texts
		item = new JTextField(30);
		priority = new JTextField(10);
		note = new JTextArea(30,30);
		JScrollPane notePane = new JScrollPane(note);
		

		
		
		
		//create choices
		deadlineCheckBox = new JCheckBox("DeadLine");
		month = new JComboBox<String>();
		for(String m: months) {
			month.addItem(m);
		}
		day = new JComboBox<String>();
		for (int d = 1; d<32; d++) {
			day.addItem(String.valueOf(d));
		}
		year = new JComboBox<String>();
		for (int y = 2022; y<2032; y++) {
			year.addItem(String.valueOf(y));
		}
		month.setEnabled(false);
		day.setEnabled(false);
		year.setEnabled(false);
		
		
		//create buttons
		saveItemButton = new JButton("Save Item");
		newItemButton = new JButton("NewItem");
		
		//create labels
		JLabel itemLabel = new JLabel("Item:");
		JLabel priorityLabel = new JLabel("Priority:");
		JLabel noteLabel = new JLabel("Notes:");
		JLabel monthLabel = new JLabel("Month:");
		JLabel dayLabel = new JLabel("Day:");
		JLabel yearLabel = new JLabel("Year:");
		
		
		//adding labels
		itemPanel.add(itemLabel);
		priorityPanel.add(priorityLabel);
		notePanel.add(noteLabel, BorderLayout.WEST);
		monthPanel.add(monthLabel);
		monthPanel.add(month);
		dayPanel.add(dayLabel);
		dayPanel.add(day);
		yearPanel.add(yearLabel);
		yearPanel.add(year);
		
		
		
		
		
		//adding components
		itemPanel.add(item);
		priorityPanel.add(priority);
		timePanel.add(deadlineCheckBox);
		timePanel.add(monthPanel);
		timePanel.add(dayPanel);
		timePanel.add(yearPanel);
		
		
		//notePanel.add(note, BorderLayout.CENTER);
		notePanel.add(notePane,BorderLayout.CENTER);
		
		lowTwoBPanel.add(saveItemButton);
		lowTwoBPanel.add(newItemButton);
		
		
		//adding panels to the item panel
		p.add(itemPanel);
		p.add(priorityPanel);
		p.add(timePanel);
		p.add(notePanel);
		p.add(lowTwoBPanel);
		
		
		p.setBorder(new TitledBorder(new EtchedBorder(), "Item"));
		return p;
	}
}

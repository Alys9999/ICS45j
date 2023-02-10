package labs.lab9;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class ToDos {
	private ArrayList<ToDoItem> toDoList;
	
	public ToDos() {
		toDoList = new ArrayList<ToDoItem>();
	}
	
	public void addItem(ToDoItem item) {
		String itemName = item.getName();
		String altItemName = "<html><strike>"+itemName+"</strike><html>";
		for (ToDoItem i: toDoList) {
			if (i.getName().equals(itemName) || i.getName().equals(altItemName)) {
				throw new IllegalArgumentException();
			}
		}
		toDoList.add(item);
		//not sure if this is right
		sortItem();
	}
	
	public void sortItem() {
		Collections.sort(toDoList);
	}
	
	public void removeItem(ToDoItem item) {
		toDoList.remove(item);
		sortItem();
	}
	
	public ArrayList<ToDoItem> getToDoList(){
		return toDoList;
	}
	
	public ToDoItem getItem(String name) {
		for (ToDoItem item:toDoList) {
			if (item.getName().equals(name)) {
				return item;
			}
		}
		return null;
	}
	
	public static boolean isLeapYear(int year) {
		  Calendar cal = Calendar.getInstance();
		  cal.set(Calendar.YEAR, year);
		  return cal.getActualMaximum(Calendar.DAY_OF_YEAR) > 365;
		}
	
	
	public static void main(String[] args) {
		UI frame = new UI();
		ToDos td =  new ToDos();	
		//---------------------------------------------
		class ExitItemListener implements ActionListener{
			
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		}
		ActionListener exitlistener = new ExitItemListener();
		frame.getExitItem().addActionListener(exitlistener);
		
		//---------------------------------------------------
		class ToggleListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (frame.getToDoList().getSelectedValue()!=null) {
					String name = frame.getToDoList().getSelectedValue();
					String altname = "";
					if (!td.getItem(name).getIfDone()) {
						altname = "<html><strike>"+name+"</strike><html>";
					}else {
						altname = name.replaceAll("\\<[^>]*>","");
					}
					td.getItem(name).setIfDone();
					td.getItem(name).setName(altname);
					td.sortItem();
					
					frame.getToDoListModel().clear();
					for (ToDoItem t: td.getToDoList()) {
						frame.getToDoListModel().addElement(t.getName());
					}
				}
			}
		}
		ToggleListener toggleListener = new ToggleListener();
		frame.gettoggleButton().addActionListener(toggleListener);
		
		//---------------------------------------------------
		class DeleteListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (frame.getToDoList().getSelectedValue()!=null) {
					String name = frame.getToDoList().getSelectedValue();
					td.removeItem(td.getItem(name));


					frame.getToDoListModel().clear();
					for (ToDoItem t: td.getToDoList()) {
						frame.getToDoListModel().addElement(t.getName());
					}
				}
			}
		}
		
		DeleteListener deleteListener = new DeleteListener();
		frame.getdeleteButton().addActionListener(deleteListener);
		
		//---------------------------------------------------
		
		class NewItemListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.getToDoList().clearSelection();
				frame.getItem().setText("");
				frame.getPriority().setText("");
				frame.getDeadlineCheckBoxItem().setSelected(false);
				//time
				frame.getYearItem().setSelectedItem("2022");
				frame.getMonthItem().setSelectedItem("January");
				frame.getDayItem().setSelectedItem("1");
				frame.getYearItem().setEnabled(false);
				frame.getMonthItem().setEnabled(false);
				frame.getDayItem().setEnabled(false);
				frame.getNote().setText("");
				 /* 
				if (frame.getItem().getText()!="" && frame.getPriority().getText()!="" && frame.getToDoList().getSelectedValue()!=null) {
					//does save need to check name?
					String name = frame.getToDoList().getSelectedValue();
					td.removeItem(td.getItem(name));
					
					name = frame.getItem().getText();
					String priority = frame.getPriority().getText();
					if (name.equals("") || priority.equals("")|| Integer.valueOf(priority)<1) {
						UI.popup();
						return;
					}
					String note = frame.getNote().getText();
					boolean ifDeadline = frame.getDeadlineCheckBox();
					Date date = new Date(frame.getYear(),frame.getMonth(),frame.getDay());
					ToDoItem newItem = new ToDoItem(name, priority, note, ifDeadline, date);
					td.addItem(newItem);
					UI.popupSave();
					

					
					frame.getToDoListModel().clear();
					for (ToDoItem t: td.getToDoList()) {
						frame.getToDoListModel().addElement(t.getName());
					}
					frame.getToDoList().setSelectedValue(newItem, false);
				}else {
					UI.popup();
					return;
				}*/
			}
		}
		
		NewItemListener newItemListener = new NewItemListener();
		frame.getnewItemButton().addActionListener(newItemListener);
		
		//---------------------------------------------------
		
		class SaveItemListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (frame.getItem().getText()!="" && frame.getPriority().getText()!=""&& frame.getPriority().getText().matches("[0-9]+")) {
					String name ="";
					if (frame.getToDoList().getSelectedValue()!=null) {
						name = frame.getToDoList().getSelectedValue();
						td.removeItem(td.getItem(name));
					}
					name = frame.getItem().getText();
					String priority = frame.getPriority().getText();
					if (Integer.valueOf(priority)<1) {
						UI.popup();
						return;
					}
					String note = frame.getNote().getText();
					boolean ifDeadline = frame.getDeadlineCheckBox();
					Date date = new Date(frame.getYear(),frame.getMonth(),frame.getDay());
					ToDoItem newItem = new ToDoItem(name, priority, note, ifDeadline, date);
					try {
						td.addItem(newItem);
						UI.popupSave();
						
						frame.getToDoListModel().clear();
						for (ToDoItem t: td.getToDoList()) {
							frame.getToDoListModel().addElement(t.getName());
						}
						frame.getToDoList().setSelectedValue(name, false);
					}catch(IllegalArgumentException e) {
						UI.popup();
					}
				}else {
					UI.popup();
					return;
				}
			}
		}
		
		SaveItemListener saveItemListener = new SaveItemListener();
		frame.getsaveItemButton().addActionListener(saveItemListener);
		
		//---------------------------------------------------
		class ToDoListListener implements ListSelectionListener {
			public void valueChanged(ListSelectionEvent event) {
				if (frame.getToDoList().getSelectedValue()!=null) {
					String name = frame.getToDoList().getSelectedValue();
					ToDoItem item = td.getItem(name);
					frame.getItem().setText(item.getName().replaceAll("\\<[^>]*>",""));
					frame.getPriority().setText(String.valueOf(item.getPriority()));
					frame.getDeadlineCheckBoxItem().setSelected(item.getIfDeadLine());
					//time
					frame.getYearItem().setEnabled(item.getIfDeadLine());
					frame.getMonthItem().setEnabled(item.getIfDeadLine());
					frame.getDayItem().setEnabled(item.getIfDeadLine());
					
					frame.getYearItem().setSelectedItem(String.valueOf(item.getYear()));
					frame.getMonthItem().setSelectedItem(UI.getInttoMonth(item.getMonth()));
					frame.getDayItem().setSelectedItem(String.valueOf(item.getDay()));
						
					frame.getNote().setText(item.getNote());
					}
			}
		}
		
		ToDoListListener toDoListListener = new ToDoListListener();
		frame.getToDoList().addListSelectionListener(toDoListListener);
		
		//---------------------------------------------------
		class IfDeadLineListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				if (frame.getDeadlineCheckBox()) {
					frame.getMonthItem().setEnabled(true);
					frame.getDayItem().setEnabled(true);
					frame.getYearItem().setEnabled(true);
				}else if (!frame.getDeadlineCheckBox()) {
					frame.getMonthItem().setEnabled(false);
					frame.getDayItem().setEnabled(false);
					frame.getYearItem().setEnabled(false);
				}
			}
		}
		
		IfDeadLineListener ifDeadLineListener = new IfDeadLineListener();
		frame.getDeadlineCheckBoxItem().addActionListener(ifDeadLineListener);
		
		//---------------------------------------------------
		class ShowDayListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				frame.getDayItem().removeAllItems();;
				List<Integer> largeMonth = Arrays.asList(1,3,5,7,8,10,12);
				List<Integer> smallMonth = Arrays.asList(4,6,9,11);
				int m = frame.getMonth();
				boolean b = largeMonth.contains(frame.getMonth());
				if (ToDos.isLeapYear(frame.getYear())) {
					if (largeMonth.contains(frame.getMonth())) {
						for (int d = 1; d<32; d++) {
							frame.getDayItem().addItem(String.valueOf(d));
						}
					}else if (smallMonth.contains(frame.getMonth())) {
						for (int d = 1; d<31; d++) {
							frame.getDayItem().addItem(String.valueOf(d));
						}
					}else {
						for (int d = 1; d<30; d++) {
							frame.getDayItem().addItem(String.valueOf(d));
						}
					}
				}else if (!ToDos.isLeapYear(frame.getYear())) {
					if (largeMonth.contains(frame.getMonth())) {
						for (int d = 1; d<32; d++) {
							frame.getDayItem().addItem(String.valueOf(d));
						}
					}else if (smallMonth.contains(frame.getMonth())) {
						for (int d = 1; d<31; d++) {
							frame.getDayItem().addItem(String.valueOf(d));
						}
					}else {
						for (int d = 1; d<29; d++) {
							frame.getDayItem().addItem(String.valueOf(d));
						}
					}
				}
			}
		}
		
		ShowDayListener showDayListener = new ShowDayListener();
		frame.getMonthItem().addActionListener(showDayListener);
		frame.getYearItem().addActionListener(showDayListener);


	
		
	}

}

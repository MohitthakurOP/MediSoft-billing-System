package com.billing.MedcialBillingSystem;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.time.LocalDate;
import java.util.Random;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.SwingConstants;

public class Sales extends JFrame implements ActionListener{
	
	Conn Connection = new Conn();
	Random ran = new Random();
	long no4 = (ran.nextLong(9000) + 1000);
	String no = "S" + Math.abs(no4);
	LocalDate date =LocalDate.now();
	JTextField TextPatient,TextDoctor,Textphone,Textaddress,sr,type,Mname,qnt,price,amt,subtotal,grandtotal; 
	String billtype="Sales";
	private JTable table;
	private DefaultTableModel tableModel;
	private JButton addButton, saveButton,backButton,printButton,QRCode;
	private int srcounter=1,check;
	
	public Sales(){

	JLabel l1 = new JLabel("MediSoft Billing System");
    l1.setFont(new Font("System",Font.BOLD,38));
	l1.setBounds(475, 10, 1000, 50);
	add(l1);
	
	JSeparator separator1 = new JSeparator();
	separator1.setForeground(Color.BLACK);
    separator1.setBounds(0, 60, 2500, 20); 
    add(separator1);

    JLabel l2 = new JLabel("Bill no : "+no);
    l2.setFont(new Font("System",Font.BOLD,28));
	l2.setBounds(10, 70, 250, 40);
	add(l2);
	
	JLabel l3 = new JLabel("Date :"+date);
    l3.setFont(new Font("System",Font.BOLD,28));
	l3.setBounds(1300, 70, 500, 40);
	add(l3);
    
    JLabel l4 = new JLabel("Patient Name :");
    l4.setFont(new Font("System",Font.BOLD,28));
	l4.setBounds(10, 130, 250, 40);
	add(l4);
	
	TextPatient =new JTextField();
    TextPatient.setBounds(210, 130, 350, 40);
    TextPatient.setFont(new Font("Arial", Font.BOLD,18));
    add(TextPatient);

    JLabel l5 = new JLabel("Doctor Name :");
    l5.setFont(new Font("System",Font.BOLD,28));
   	l5.setBounds(10, 200, 250, 40);
   	add(l5);	
   	
   	TextDoctor =new JTextField();
    TextDoctor.setBounds(210, 200, 350, 40);
    TextDoctor.setFont(new Font("Arial", Font.BOLD,18));
    add(TextDoctor);
   	
    JLabel l6 = new JLabel("Phone no :");
    l6.setFont(new Font("System",Font.BOLD,28));
   	l6.setBounds(1230, 130, 250, 40);
   	add(l6);
    
	Textphone =new JTextField();
    Textphone.setBounds(1380, 130, 140, 40);
    Textphone.setFont(new Font("Arial", Font.BOLD,18));
    add(Textphone);
    
    JLabel l7 = new JLabel("Bill Type : "+ billtype);
    l7.setFont(new Font("System",Font.BOLD,28));
   	l7.setBounds(1230, 200, 250, 40);
   	add(l7);
   	
   	JLabel l8 = new JLabel("Address :");
   	l8.setFont(new Font("System",Font.BOLD,28));
	l8.setBounds(610, 130, 250, 40);
	add(l8);
	
	Textaddress = new JTextField();
	Textaddress.setBounds(750, 130, 350, 40);
    Textaddress.setFont(new Font("Arial", Font.BOLD,18));
    add(Textaddress);
		
    //table
	JSeparator separator2 = new JSeparator();
	separator2.setForeground(Color.BLACK);
    separator2.setBounds(0, 250, 2310, 20); 
    add(separator2);

    JLabel l10 = new JLabel("Type");
	l10.setHorizontalAlignment(SwingConstants.CENTER);
	l10.setFont(new Font("System",Font.BOLD,28));
	l10.setBackground(Color.white);
	l10.setBounds(0, 270, 109, 40);
	add(l10);
	
	type = new JTextField();
	type.setBounds(105, 270, 100, 40);
	type.setFont(new Font("Arial", Font.BOLD,18));
    add(type);
    
    JLabel l11 = new JLabel("Medicine");
	l11.setHorizontalAlignment(SwingConstants.CENTER);
	l11.setFont(new Font("System",Font.BOLD,28));
	l11.setBackground(Color.white);
	l11.setBounds(215, 270, 162, 40);
	add(l11);
	
	Mname = new JTextField();
	Mname.setBounds(387, 270, 333, 40);
	Mname.setFont(new Font("Arial", Font.BOLD,18));
    add(Mname);
    
	JLabel l12 = new JLabel("Quantity");
	l12.setHorizontalAlignment(SwingConstants.CENTER);
	l12.setFont(new Font("System",Font.BOLD,28));
	l12.setBackground(Color.white);
	l12.setBounds(730, 270, 150, 40);
	add(l12);
	
    qnt = new JTextField();
    qnt.setBounds(891, 270 , 130, 40);
    qnt.setFont(new Font("Arial", Font.BOLD,18));
    add(qnt);
	

    setBackground(new Color(225,225,225));	
	setLayout(null);
	
	 tableModel = new DefaultTableModel();
     tableModel.addColumn("Sr_no");
     tableModel.addColumn("Type");
     tableModel.addColumn("Medicine Name");
     tableModel.addColumn("Quantity");
     tableModel.addColumn("Price");
     tableModel.addColumn("Amount");
     
     
     table = new JTable(tableModel);
     table.setFont(new Font("Arial", Font.PLAIN, 18)); // Adjust the font size as needed
 	 table.setRowHeight(40); // Adjust the row height as needed
 	 JTableHeader header = table.getTableHeader();
 	 header.setFont(new Font("System", Font.BOLD, 24)); // Adjust the font size as needed
 	
     JScrollPane scrollPane = new JScrollPane(table);
     scrollPane.setBounds(0, 340, 1550, 300);
     add(scrollPane);

     addButton = new JButton("INSERT");
     addButton.setFont(new Font("System", Font.BOLD, 22));
     addButton.setBounds(1300, 260, 193, 50);
     addButton.addActionListener(this);
     add(addButton);
     
     backButton = new JButton("Back");
     backButton.setFont(new Font("System", Font.BOLD, 26));
     backButton.setBounds(60, 650, 200, 50);
     backButton.addActionListener(this);
     add(backButton);
     
     saveButton = new JButton("Save");
     saveButton.setFont(new Font("System", Font.BOLD, 26));
     saveButton.setBounds(310, 650, 200, 50);
     saveButton.addActionListener(this);
     add(saveButton);
     
     printButton = new JButton("Print");
     printButton.setFont(new Font("System", Font.BOLD, 26));
     printButton.setBounds(600, 650, 200, 50);
     printButton.addActionListener(this);
     add(printButton);
     
     QRCode = new JButton("QR-Code");
     QRCode.setFont(new Font("System", Font.BOLD, 26));
     QRCode.setBounds(870, 650, 200, 50);
     QRCode.addActionListener(this);
     add(QRCode);
     
     
     JLabel l14 = new JLabel("Sub Total :");
     l14.setFont(new Font("System",Font.BOLD,28));
 	 l14.setBackground(Color.white);
 	 l14.setBounds(1178, 650, 162, 40);
 	 add(l14);
 	 
 	 subtotal = new JTextField();
 	 subtotal.setFont(new Font("System",Font.BOLD,28));
 	 subtotal.setBounds(1330, 650, 180, 40);
 	 add(subtotal);
 	 
 	 JLabel l15 = new JLabel("Discount  : 10%");
     l15.setFont(new Font("System",Font.BOLD,28));
	 l15.setBackground(Color.white);
	 l15.setBounds(1178, 690, 220, 40);
	 add(l15);
	 
	 JLabel l16 = new JLabel("Grand Total :");
     l16.setFont(new Font("System",Font.BOLD,28));
 	 l16.setBackground(Color.white);
 	 l16.setBounds(1178, 730, 250, 40);
 	 add(l16);
 	 
 	 grandtotal = new JTextField();
 	 grandtotal.setFont(new Font("System",Font.BOLD,28));
	 grandtotal.setBounds(1360, 730, 150, 40);
	 add(grandtotal);
     
    setSize(1550, 1080);
    setLocation(0, 0);
    setVisible(true);
    
}
   
	
	public static void main(String[] args) {
		new Sales();
	}

	//adding medicine to table
	private void addMedicine() {
    String sr_no = String.valueOf(srcounter++);
    String Mtype = type.getText();
    String medicineName = Mname.getText();
    String quantity = qnt.getText();
//    String Mprice = price.getText();
    
    if (Mtype.isEmpty() || medicineName.isEmpty() || quantity.isEmpty()) {
        JOptionPane.showMessageDialog(this, "Please fill in all the fields.");
        return;
    }
    
    //checking if the medicne with the same name is available or not
    if (!MedAvailability(Mtype,medicineName)) {
        JOptionPane.showMessageDialog(this, "Medicine is not available.");
        return;
    }
    int availablequantity = qntavailable(medicineName,quantity);
    
    //checking if the quantity of med is available or not
    if(availablequantity > 0) {
    	JOptionPane.showMessageDialog(this,"Only "+availablequantity +" units are available");
        return;
    }
    int Mprice = fetchingprice(medicineName);
    try {
    double amountValue = Mprice * Integer.parseInt(quantity);
    String amount = String.valueOf(amountValue);
    
    //adding value in the table
    Object[] rowData = {sr_no, Mtype, medicineName, quantity, Mprice, amount};
    tableModel.addRow(rowData);

    double updatedSubtotal = 0.0;
    for (int row = 0; row < tableModel.getRowCount(); row++) {
        updatedSubtotal += Double.parseDouble(tableModel.getValueAt(row, 5).toString());
    }

    double discount = 0.1 * updatedSubtotal;
    double updatedGrandtotal = updatedSubtotal - discount;

    //seting and clearing textboxes
    subtotal.setText(String.valueOf(updatedSubtotal));
    grandtotal.setText(String.valueOf(updatedGrandtotal));
    type.setText("");
    Mname.setText("");
    qnt.setText("");
//    price.setText("");
    }
    catch(NumberFormatException e) {
   	 JOptionPane.showMessageDialog(this, "Please enter valid integers for Quantity and Price.");
   }
   catch(Exception e) {
   	e.printStackTrace();
   }

}
    //checking if the medicne with the same name is available or not
	private boolean MedAvailability(String tab,String medicine) {
		
		try {
		Connection = new Conn();
		String query = "Select * from stocks where tab = ? and medicine_name = ? ";
		PreparedStatement preparedStatement = Connection.prepareStatement(query);
			preparedStatement.setString(1, tab);
			preparedStatement.setString(2, medicine);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next() ) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}
	
    //checking if the quantity of med is available or not
	private int qntavailable(String medicine,String quantity) {
		try {
			Connection = new Conn();
			String query = "Select * from stocks where medicine_name = ? ";
			PreparedStatement preparedStatement = Connection.prepareStatement(query);
				preparedStatement.setString(1,medicine);
		        ResultSet resultSet = preparedStatement.executeQuery();
		        if (resultSet.next()) {
		            int availableQuantity = resultSet.getInt("quantity");
		            int requestedQuantity = Integer.parseInt(quantity);
		            
		            if (availableQuantity >= requestedQuantity) {
		                // Sufficient quantity available
		                return 0;
		            } else {
		                // Insufficient quantity
		                return availableQuantity;
		            }
		        } 
		    }
		catch(Exception e) {
			e.printStackTrace();
		}
		return 1;
	}
	
	//fetcging price from database
	private int fetchingprice(String medicine) {
		
		try {
			Connection = new Conn();
			String query = "Select price from Stocks where medicine_name = ?";
			PreparedStatement preparedStatement = Connection.prepareStatement(query);
			preparedStatement.setString(1, medicine);
			ResultSet resultset = preparedStatement.executeQuery();
			if(resultset.next()) {
			int price = resultset.getInt("price");
			return price;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
		
		
	}
	
	//updating the stocks in the table
	private void updateStocksTable(String medicineName, int quantity) {
    try {
        Connection = new Conn();
        String updateQuery = "UPDATE Stocks SET quantity = quantity - ? WHERE medicine_name = ?";
        PreparedStatement preparedStatement = Connection.prepareStatement(updateQuery);

        preparedStatement.setInt(1, quantity);
        preparedStatement.setString(2, medicineName);

        preparedStatement.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (Connection != null) {
                Connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
	
	//adding patient data into the patient table
	private void patientdata() {
	String bill_no = no;
	LocalDate date1 = date;
	String patient = TextPatient.getText();
	String address = Textaddress.getText();
	String phone = Textphone.getText();
	String doctor = TextDoctor.getText();
	
	if(patient.isEmpty() || address.isEmpty() || phone.isEmpty() || doctor.isEmpty()) {
		JOptionPane.showMessageDialog(this,"Please fill in all the fields.");
		return;
	}

    try {
    	 Connection = new Conn();
    	 String query = "INSERT INTO Sales (bill_no, date, patient_name, address, phone_no, doctor_name) VALUES (?, ?, ?, ?, ?, ?)";
    	 PreparedStatement preparedStatement = Connection.prepareStatement(query);
    	    
        preparedStatement.setString(1, bill_no);
        preparedStatement.setString(2, date1.toString());
        preparedStatement.setString(3, patient);
        preparedStatement.setString(4, address);
        preparedStatement.setString(5, phone);
        preparedStatement.setString(6, doctor);
        preparedStatement.executeUpdate();
        

    } catch (SQLException E) {
        E.printStackTrace();
    }
    saveData();
}

	//creating a table with name same as bill no
	private void saveData() {
    String tableName = no; 
    try {
        Connection = new Conn();
        String query1 = "CREATE TABLE IF NOT EXISTS " + tableName + " (sr_no INT AUTO_INCREMENT PRIMARY KEY, type VARCHAR(30), medicine_name VARCHAR(30), quantity VARCHAR(30), price VARCHAR(30), amount VARCHAR(30))";
        PreparedStatement preparedStatement = Connection.prepareStatement(query1);

        preparedStatement.execute();

    } catch (SQLException e) {
        e.printStackTrace();
    } finally {
        try {
            if (Connection != null) {
                Connection.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Now, insert the data into the table
    for (int row = 0; row < tableModel.getRowCount(); row++) {
        String sr_no = tableModel.getValueAt(row, 0).toString();
        String type = tableModel.getValueAt(row, 1).toString();
        String medicineName = tableModel.getValueAt(row, 2).toString();
        String quantity = tableModel.getValueAt(row, 3).toString();
        String price = tableModel.getValueAt(row, 4).toString();
        String amount = tableModel.getValueAt(row, 5).toString();

        try {
            Connection = new Conn();
            String query2 = "INSERT INTO " + tableName + " (type, medicine_name, quantity, price, amount) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement preparedStatement = Connection.prepareStatement(query2);

            preparedStatement.setString(1, type);
            preparedStatement.setString(2, medicineName);
            preparedStatement.setString(3, quantity);
            preparedStatement.setString(4, price);
            preparedStatement.setString(5, amount);

            int rowsAffected = preparedStatement.executeUpdate();
            check = rowsAffected;
            preparedStatement.close();

           
        } catch (SQLException e) {
            e.printStackTrace();
        }
        int quantity1 = Integer.parseInt(quantity);
        updateStocksTable(medicineName,quantity1);
    }
    if (check > 0) {
        JOptionPane.showMessageDialog(this, "Data saved successfully!");
    } else {
        JOptionPane.showMessageDialog(this, "Data failed to save!");
    }

}

@Override
public void actionPerformed(ActionEvent e) {

	try {
		if(e.getSource()==addButton) {
			addMedicine();
		}
	}
	catch(Exception E) {
		E.printStackTrace();
	}
	
	try {
		if(e.getSource()==saveButton) {
		patientdata();
		}
	}
	catch(Exception E) {
		E.printStackTrace();;
	}
	try {
		if(e.getSource() == backButton) {
			new Menu();
			dispose();

		}
	}
	catch(Exception E) {
		E.printStackTrace();
	}
	try {
		if(e.getSource() == printButton) {
			JOptionPane.showMessageDialog(this,"Bill is Printed.");
		}
	}
	catch(Exception E) {
		E.printStackTrace();
	}
	try {
		if(e.getSource()==QRCode) {
		    String total = grandtotal != null ? grandtotal.getText() : "";
			new QRCode(total);
			}
	}
	catch(Exception E) {
		E.printStackTrace();
	}
}
}

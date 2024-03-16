package com.billing.MedcialBillingSystem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Menu extends JFrame implements ActionListener  {

	Connection con;
	JButton Salesbt,Purchasebt,searchbt,stockbt;

	public Menu() {
		
		JLabel label1 = new JLabel("MediSoft Billing System");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGarde", Font.BOLD, 36));
        label1.setBounds(530,190,600,50);
        add(label1);
        
		Purchasebt = new JButton("Purchase");
		Purchasebt.setFont(new Font("System",Font.BOLD,22));
		Purchasebt.setBounds(465, 325, 150, 50);
		Purchasebt.addActionListener(this);
		add(Purchasebt);
		
		Salesbt = new JButton("Sales");
		Salesbt.setFont(new Font("System",Font.BOLD,22));
		Salesbt.setBounds(915, 325, 150, 50);
		Salesbt.addActionListener(this);
		add(Salesbt);
		
		searchbt = new JButton("Search");
		searchbt.setFont(new Font("System",Font.BOLD,22));
		searchbt.setBounds(465, 445, 150, 50);
		searchbt.addActionListener(this);
		add(searchbt);
		
		stockbt = new JButton("Stock");
		stockbt.setFont(new Font("System",Font.BOLD,22));
		stockbt.setBounds(915, 445, 150, 50);
		stockbt.addActionListener(this);
		add(stockbt);
	
		
		ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("abstract-envelope.png"));
		Image i2 = i1.getImage().getScaledInstance(1550,1080, Image.SCALE_DEFAULT);
		ImageIcon i3 = new ImageIcon(i2);
		JLabel image = new JLabel(i3);
		image.setBounds(0, 0, 1550,1080);
		add(image);
		
		setSize(1550,1080);
	    setLocation(0,0);
		setVisible(true);
		
	}
	
	public static void main(String[] args) {
		new Menu();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		try {
			if(e.getSource() == Purchasebt) {
			
				new Purchase();
				dispose();
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		try {
			if(e.getSource() == Salesbt) {
				
				new Sales();
				dispose();
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		try {
			if(e.getSource() == searchbt) {
				
				new Search();
				dispose();
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		try {
			if(e.getSource() == stockbt) {
				
				new Stocks();
				dispose();
			}
		}
		catch(Exception E) {
			E.printStackTrace();
		}
		}
	}


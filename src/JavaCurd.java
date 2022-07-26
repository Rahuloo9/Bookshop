import java.awt.EventQueue;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;

public class JavaCurd {

	private JFrame frame;
	private JTextField textname;
	private JTextField textedition;
	private JTextField textprice;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JavaCurd window = new JavaCurd();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public JavaCurd() {
		initialize();
		connect();
	}

	Connection con;
	PreparedStatement stms;
	
public void connect() {
	try {
		 	
			Class.forName("com.mysql.cj.jdbc.Driver");//Driver Load 
			
			//String url = "jdbc:mysql://localhost:3306/bookshop";// 
			
			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/bookshop", "root", "Rahul@123");//Connection with Databases
	}
		catch(Exception e) {
		System.out.println(e);
	}
}
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 716, 523);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Book Shop");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(239, 11, 175, 77);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Registation", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 99, 348, 200);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Book Name");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1.setBounds(27, 29, 96, 49);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Edition");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_1.setBounds(27, 75, 96, 49);
		panel.add(lblNewLabel_1_1);
	
		
		JLabel lblNewLabel_1_2 = new JLabel("Price");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNewLabel_1_2.setBounds(27, 124, 96, 49);
		panel.add(lblNewLabel_1_2);
		
		textname = new JTextField();
		textname.setBounds(165, 45, 134, 20);
		panel.add(textname);
		textname.setColumns(10);
		
		textedition = new JTextField();
		textedition.setColumns(10);
		textedition.setBounds(165, 91, 134, 20);
		panel.add(textedition);
		
		textprice = new JTextField();
		textprice.setColumns(10);
		textprice.setBounds(165, 140, 134, 20);
		panel.add(textprice);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(196, 101, 10, 10);
		panel.add(panel_2);
		
		JButton btnSave = new JButton("Save");
		
		btnSave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				String bname,edition,price;
				
				
				bname = textname.getText();
				
				edition = textedition.getText();
				
				price = textprice.getText();
				
				try {
					
					stms =con.prepareStatement("insert into book values(?,?,?)");
					
					stms.setString(1, bname);
					stms.setString(2, edition);
					stms.setString(3, price);
					stms.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record  Addeddd.....!!!!!");
					
					textname.setText("");
					textedition.setText("");
					textprice.setText("");
					
					
					textname.requestFocus();
				}
				catch(Exception e1) {
					e1.printStackTrace();
					System.out.println(e1);
				}
				
				
				
			}
		});
		
		btnSave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnSave.setBounds(10, 310, 100, 44);
		frame.getContentPane().add(btnSave);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnExit.setBounds(132, 310, 100, 44);
		frame.getContentPane().add(btnExit);
		
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnClear.setBounds(256, 310, 100, 44);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(383, 99, 248, 262);
		frame.getContentPane().add(scrollPane);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(10, 382, 348, 70);
		frame.getContentPane().add(panel_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Book ID");
		panel_1.add(lblNewLabel_1_1_1);
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.BOLD, 14));
		
		JScrollPane scrollPane_1 = new JScrollPane();
		panel_1.add(scrollPane_1);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		panel_1.add(textField_3);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBounds(403, 387, 100, 44);
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDelete.setBounds(531, 387, 100, 44);
		frame.getContentPane().add(btnDelete);
	}
}

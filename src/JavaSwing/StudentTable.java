package JavaSwing;


import MainPackage.MainClass;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class StudentTable  extends JFrame implements ActionListener {

    private Container container;
    private JLabel jLabel,jLabel2,jLabel3,jLabel4,jLabel5;
    private JTextField jTextField,jTextField2,jTextField3,jTextField4;
    private JButton jButton,jButton2,jButton3,jButton4;
    private JTable jTable;
    private JScrollPane jScrollPane;
    private DefaultTableModel defaultTableModel;
    private String []  columms = {"Name","Dept.","Course","Course"};
    private String [] rows = new String[4];
    StudentTable(){
        induction();
    }
    public void induction(){
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(780,690);
        this.setLocationRelativeTo(null);
        this.setTitle("Library Management System");

        container = this.getContentPane();
        container.setLayout(null);
        container.setBackground(Color.blue);

        Font font = new Font("Font",Font.BOLD,14);

        jLabel = new JLabel("Student Registration");
        jLabel.setFont(font);
        jLabel.setForeground(Color.magenta);
        jLabel.setBounds(140,10,250,50);
        container.add(jLabel);

        jLabel2 = new JLabel("Name :");
        jLabel2.setFont(font);
        jLabel2.setForeground(Color.green);
        jLabel2.setBounds(10,80,140,30);
        container.add(jLabel2);

        jTextField = new JTextField();
        jTextField.setFont(font);
        jTextField.setBounds(110,80,200,30);
        container.add(jTextField);

        jButton = new JButton("Add");
        jButton.setFont(font);
        jButton.setBounds(400,80,100,30);
        container.add(jButton);

        jLabel3 = new JLabel("Dept :");
        jLabel3.setFont(font);
        jLabel3.setForeground(Color.green);
        jLabel3.setBounds(10,130,150,30);
        container.add(jLabel3);

        jTextField2 = new JTextField();
        jTextField2.setFont(font);
        jTextField2.setBounds(110,130,200,30);
        container.add(jTextField2);

        jButton2 = new JButton("Update");
        jButton2.setFont(font);
        jButton2.setBounds(400,130,100,30);
        container.add(jButton2);

        jLabel4 = new JLabel("Course :");
        jLabel4.setFont(font);
        jLabel4.setForeground(Color.green);
        jLabel4.setBounds(10,180,150,30);
        container.add(jLabel4);

        jTextField3 = new JTextField();
        jTextField3.setFont(font);
        jTextField3.setBounds(110,180,200,30);
        container.add(jTextField3);

        jButton3 = new JButton("Delete");
        jButton3.setFont(font);
        jButton3.setBounds(400,180,100,30);
        container.add(jButton3);

        jLabel5 = new JLabel("Course2 :");
        jLabel5.setFont(font);
        jLabel5.setForeground(Color.green);
        jLabel5.setBounds(10,230,150,30);
        container.add(jLabel5);

        jTextField4 = new JTextField();
        jTextField4.setFont(font);
        jTextField4.setBounds(110,230,200,30);
        container.add(jTextField4);

        jButton4 = new JButton("Clear ");
        jButton4.setFont(font);
        jButton4.setBounds(400,230,100,30);
        container.add(jButton4);

        jTable = new JTable();
        defaultTableModel = new DefaultTableModel();
        defaultTableModel.setColumnIdentifiers(columms);
        jTable.setModel(defaultTableModel);
        jTable.setFont(font);
        jTable.setSelectionBackground(Color.green);
        jTable.setOpaque(true);
        jTable.setBackground(Color.red);
        jTable.setRowHeight(30);

        jScrollPane = new JScrollPane(jTable);
        jScrollPane.setBounds(10,360,740,265);
        container.add(jScrollPane);

        jButton.addActionListener(this);
        jButton2.addActionListener(this);
        jButton3.addActionListener(this);
        jButton4.addActionListener(this);
        jTable.addMouseListener(new MouseAdapter() {

            public void mouseClicked(MouseEvent me){
                int number_of_row = jTable.getSelectedRow();
                String srting = defaultTableModel.getValueAt(number_of_row,0).toString();
                String srting1 = defaultTableModel.getValueAt(number_of_row,1).toString();
                String srting2 = defaultTableModel.getValueAt(number_of_row,2).toString();
                String srting3 = defaultTableModel.getValueAt(number_of_row,3).toString();
                jTextField.setText(srting);
                jTextField2.setText(srting1);
                jTextField3.setText(srting2);
                jTextField4.setText(srting3);
            }
        });

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==jButton){
            rows[0] = jTextField.getText();
            rows[1] = jTextField2.getText();
            rows[2] = jTextField3.getText();
            rows[3] = jTextField4.getText();
            defaultTableModel.addRow(rows);

        }
        else if(e.getSource()==jButton4){
            jTextField.setText("");
            jTextField2.setText("");
            jTextField3.setText("");
            jTextField4.setText("");
        }
        else if(e.getSource()==jButton2){
            int number_of_row = jTable.getSelectedRow();
            String srting  = jTextField.getText();
            String srting1  = jTextField2.getText();
            String srting2  = jTextField3.getText();
            String srting3   = jTextField4.getText();
            defaultTableModel.setValueAt(srting,number_of_row,0);
            defaultTableModel.setValueAt(srting1,number_of_row,1);
            defaultTableModel.setValueAt(srting2,number_of_row,2);
            defaultTableModel.setValueAt(srting3,number_of_row,3);

        }
        else if(e.getSource()==jButton3){
            int number_of_row = jTable.getSelectedRow();
            if(number_of_row>=0){
                defaultTableModel.removeRow(number_of_row);
            }
            else{
                JOptionPane.showMessageDialog(null,"Please Delete Any row");
            }
        }
    }
    public static void main(String[] args) {
        MainClass frame = new MainClass();
        frame.setVisible(true);
    }

}
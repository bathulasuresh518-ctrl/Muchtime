package hospital;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class HospitalManagementInMemory extends JFrame {

    private JTextField tfPatientID, tfPatientName, tfAge, tfPhone;
    private JButton btnAdd, btnUpdate, btnDelete, btnClear;
    private JTable table;
    private DefaultTableModel model;

    // In-memory list to store patients
    private final ArrayList<Patient> patients = new ArrayList<>();

    public HospitalManagementInMemory() {
        setTitle("Hospital Management System (In-Memory)");
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(5, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Patient Details"));

        inputPanel.add(new JLabel("Patient ID:"));
        tfPatientID = new JTextField();
        inputPanel.add(tfPatientID);

        inputPanel.add(new JLabel("Name:"));
        tfPatientName = new JTextField();
        inputPanel.add(tfPatientName);

        inputPanel.add(new JLabel("Age:"));
        tfAge = new JTextField();
        inputPanel.add(tfAge);

        inputPanel.add(new JLabel("Phone:"));
        tfPhone = new JTextField();
        inputPanel.add(tfPhone);

        btnAdd = new JButton("Add Patient");
        btnUpdate = new JButton("Update Patient");
        btnDelete = new JButton("Delete Patient");
        btnClear = new JButton("Clear Fields");

        JPanel btnPanel = new JPanel();
        btnPanel.add(btnAdd);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);
        btnPanel.add(btnClear);

        add(inputPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);

        model = new DefaultTableModel(new String[]{"ID", "Name", "Age", "Phone"}, 0);
        table = new JTable(model);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Patients List"));

        add(scrollPane, BorderLayout.SOUTH);

        // Button listeners
        btnAdd.addActionListener(e -> addPatient());
        btnUpdate.addActionListener(e -> updatePatient());
        btnDelete.addActionListener(e -> deletePatient());
        btnClear.addActionListener(e -> clearFields());

        // Table row click listener to fill form
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                tfPatientID.setText(model.getValueAt(row, 0).toString());
                tfPatientName.setText(model.getValueAt(row, 1).toString());
                tfAge.setText(model.getValueAt(row, 2).toString());
                tfPhone.setText(model.getValueAt(row, 3).toString());
            }
        });
    }

    private void addPatient() {
        String idStr = tfPatientID.getText().trim();
        String name = tfPatientName.getText().trim();
        String ageStr = tfAge.getText().trim();
        String phone = tfPhone.getText().trim();

        if (idStr.isEmpty() || name.isEmpty() || ageStr.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int age = Integer.parseInt(ageStr);

            // Check if ID already exists
            for (Patient p : patients) {
                if (p.getId() == id) {
                    JOptionPane.showMessageDialog(this, "Patient ID already exists!");
                    return;
                }
            }

            Patient patient = new Patient(id, name, age, phone);
            patients.add(patient);
            model.addRow(new Object[]{id, name, age, phone});
            clearFields();
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID and Age must be numbers");
        }
    }

    private void updatePatient() {
        String idStr = tfPatientID.getText().trim();
        String name = tfPatientName.getText().trim();
        String ageStr = tfAge.getText().trim();
        String phone = tfPhone.getText().trim();

        if (idStr.isEmpty() || name.isEmpty() || ageStr.isEmpty() || phone.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill all fields");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);
            int age = Integer.parseInt(ageStr);

            for (int i = 0; i < patients.size(); i++) {
                Patient p = patients.get(i);
                if (p.getId() == id) {
                    p.setName(name);
                    p.setAge(age);
                    p.setPhone(phone);

                    model.setValueAt(name, i, 1);
                    model.setValueAt(age, i, 2);
                    model.setValueAt(phone, i, 3);

                    JOptionPane.showMessageDialog(this, "Patient updated!");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Patient ID not found!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID and Age must be numbers");
        }
    }

    private void deletePatient() {
        String idStr = tfPatientID.getText().trim();

        if (idStr.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Enter Patient ID to delete");
            return;
        }

        try {
            int id = Integer.parseInt(idStr);

            for (int i = 0; i < patients.size(); i++) {
                if (patients.get(i).getId() == id) {
                    patients.remove(i);
                    model.removeRow(i);
                    JOptionPane.showMessageDialog(this, "Patient deleted!");
                    clearFields();
                    return;
                }
            }
            JOptionPane.showMessageDialog(this, "Patient ID not found!");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, "ID must be a number");
        }
    }

    private void clearFields() {
        tfPatientID.setText("");
        tfPatientName.setText("");
        tfAge.setText("");
        tfPhone.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new HospitalManagementInMemory().setVisible(true);
        });
    }
}

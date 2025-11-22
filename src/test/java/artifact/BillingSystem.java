package artifact;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

public class BillingSystem extends JFrame {

    private JTextField tfProductName, tfPrice, tfQuantity, tfBillArea;
    private JButton btnAddProduct, btnGenerateBill, btnClear;
    private double total = 0.0;
    private StringBuilder billText = new StringBuilder();

    public BillingSystem() {
        setTitle("Simple Billing System");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        // Input panel
        JPanel inputPanel = new JPanel(new GridLayout(4, 2, 10, 10));
        inputPanel.setBorder(BorderFactory.createTitledBorder("Add Product"));

        inputPanel.add(new JLabel("Product Name:"));
        tfProductName = new JTextField();
        inputPanel.add(tfProductName);

        inputPanel.add(new JLabel("Price (per unit):"));
        tfPrice = new JTextField();
        inputPanel.add(tfPrice);

        inputPanel.add(new JLabel("Quantity:"));
        tfQuantity = new JTextField();
        inputPanel.add(tfQuantity);

        btnAddProduct = new JButton("Add Product");
        inputPanel.add(btnAddProduct);

        btnClear = new JButton("Clear Bill");
        inputPanel.add(btnClear);

        add(inputPanel, BorderLayout.NORTH);

        // Bill area
        tfBillArea = new JTextField();
        tfBillArea.setEditable(false);

        JTextArea taBill = new JTextArea();
        taBill.setEditable(false);
        taBill.setFont(new Font("Monospaced", Font.PLAIN, 14));
        JScrollPane scrollPane = new JScrollPane(taBill);
        scrollPane.setBorder(BorderFactory.createTitledBorder("Bill Details"));
        add(scrollPane, BorderLayout.CENTER);

        // Generate bill button
        btnGenerateBill = new JButton("Generate Total Bill");
        add(btnGenerateBill, BorderLayout.SOUTH);

        // Initialize bill header
        billText.append(String.format("%-20s %-10s %-10s %-10s\n", "Product", "Price", "Qty", "Amount"));
        billText.append("-------------------------------------------------\n");
        taBill.setText(billText.toString());

        // Button actions
        btnAddProduct.addActionListener(e -> {
            String name = tfProductName.getText().trim();
            String priceStr = tfPrice.getText().trim();
            String qtyStr = tfQuantity.getText().trim();

            if (name.isEmpty() || priceStr.isEmpty() || qtyStr.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill all fields", "Input Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            try {
                double price = Double.parseDouble(priceStr);
                int qty = Integer.parseInt(qtyStr);
                double amount = price * qty;
                total += amount;

                // Append product to bill
                billText.append(String.format("%-20s %-10.2f %-10d %-10.2f\n", name, price, qty, amount));
                taBill.setText(billText.toString());

                // Clear inputs
                tfProductName.setText("");
                tfPrice.setText("");
                tfQuantity.setText("");

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, "Price and Quantity must be numeric", "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        btnGenerateBill.addActionListener(e -> {
            DecimalFormat df = new DecimalFormat("#.##");
            billText.append("-------------------------------------------------\n");
            billText.append(String.format("%-20s %-10s %-10s %-10.2f\n", "", "", "Total:", total));
            taBill.setText(billText.toString());
        });

        btnClear.addActionListener(e -> {
            billText.setLength(0);
            total = 0.0;
            billText.append(String.format("%-20s %-10s %-10s %-10s\n", "Product", "Price", "Qty", "Amount"));
            billText.append("-------------------------------------------------\n");
            taBill.setText(billText.toString());
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BillingSystem frame = new BillingSystem();
            frame.setVisible(true);
        });
    }
}

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.*;
import java.util.LinkedList;

class InventoryItem {
    private int id;
    private String name;
    private int quantity;
    private double price;

    public InventoryItem(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + quantity + "," + price;
    }
}

class InventoryApp extends JFrame {
    private LinkedList<InventoryItem> inventory; // Changed from ArrayList to LinkedList
    private DefaultTableModel tableModel;
    private JTable inventoryTable;
    private JTextField idField, nameField, quantityField, priceField, searchField;
    private TableRowSorter<DefaultTableModel> sorter;

    public InventoryApp() {
        inventory = new LinkedList<>(); // Initialized as LinkedList
        setTitle("Inventory Management System");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initComponents();
        setupLayout();
    }

    private void initComponents() {
        idField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();
        searchField = new JTextField();

        String[] columnNames = {"ID", "Name", "Quantity", "Price"};
        tableModel = new DefaultTableModel(columnNames, 0);
        inventoryTable = new JTable(tableModel);
        sorter = new TableRowSorter<>(tableModel);
        inventoryTable.setRowSorter(sorter);
    }

    private void setupLayout() {
        JPanel addPanel = createAddPanel();
        JScrollPane scrollPane = new JScrollPane(inventoryTable);
        JPanel controlPanel = createControlPanel();

        add(addPanel, BorderLayout.NORTH);
        add(scrollPane, BorderLayout.CENTER);
        add(controlPanel, BorderLayout.SOUTH);
    }

    private JPanel createAddPanel() {
        JPanel addPanel = new JPanel(new GridLayout(6, 2));
        addPanel.setBorder(BorderFactory.createTitledBorder("Add/Edit Inventory"));

        addPanel.add(new JLabel("ID:"));
        addPanel.add(idField);
        addPanel.add(new JLabel("Name:"));
        addPanel.add(nameField);
        addPanel.add(new JLabel("Quantity:"));
        addPanel.add(quantityField);
        addPanel.add(new JLabel("Price:"));
        addPanel.add(priceField);

        JButton addButton = new JButton("Add/Update");
        addButton.addActionListener(e -> addOrUpdateItem());
        addPanel.add(addButton);

        addPanel.add(new JLabel("Search:"));
        addPanel.add(searchField);

        JButton searchButton = new JButton("Search");
        searchButton.addActionListener(e -> searchItem());
        addPanel.add(searchButton);

        return addPanel;
    }

    private JPanel createControlPanel() {
        JPanel controlPanel = new JPanel(new GridLayout(1, 3));

        JButton deleteButton = new JButton("Delete");
        deleteButton.addActionListener(e -> deleteItem());
        controlPanel.add(deleteButton);

        JButton saveButton = new JButton("Save");
        saveButton.addActionListener(e -> saveInventory());
        controlPanel.add(saveButton);

        JButton loadButton = new JButton("Load");
        loadButton.addActionListener(e -> loadInventory());
        controlPanel.add(loadButton);

        return controlPanel;
    }

    private void addOrUpdateItem() {
        try {
            int id = Integer.parseInt(idField.getText().trim());
            String name = nameField.getText().trim();
            int quantity = Integer.parseInt(quantityField.getText().trim());
            double price = Double.parseDouble(priceField.getText().trim());

            if (name.isEmpty()) {
                throw new IllegalArgumentException("Name cannot be empty");
            }

            InventoryItem newItem = new InventoryItem(id, name, quantity, price);
            boolean updated = false;

            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getId() == id) {
                    inventory.set(i, newItem);
                    updateTableModel(i, name, quantity, price);
                    updated = true;
                    break;
                }
            }

            if (!updated) {
                inventory.add(newItem);
                Object[] row = {id, name, quantity, price};
                tableModel.addRow(row);
            }

            clearFields();
        } catch (NumberFormatException ex) {
            showErrorDialog("Invalid input. Please enter valid numbers for ID, Quantity, and Price.");
        } catch (IllegalArgumentException ex) {
            showErrorDialog(ex.getMessage()); // Display the message from IllegalArgumentException
        }
    }

    private void updateTableModel(int rowIndex, String name, int quantity, double price) {
        tableModel.setValueAt(name, rowIndex, 1);
        tableModel.setValueAt(quantity, rowIndex, 2);
        tableModel.setValueAt(price, rowIndex, 3);
    }

    private void deleteItem() {
        int selectedRow = inventoryTable.getSelectedRow();
        if (selectedRow != -1) {
            int idToDelete = (int) inventoryTable.getValueAt(selectedRow, 0);

            for (int i = 0; i < inventory.size(); i++) {
                if (inventory.get(i).getId() == idToDelete) {
                    inventory.remove(i);
                    tableModel.removeRow(selectedRow);
                    clearFields();
                    break;
                }
            }
        } else {
            showErrorDialog("Please select an item to delete.");
        }
    }

    private void searchItem() {
        String searchText = searchField.getText().trim();
        if (!searchText.isEmpty()) {
            sorter.setRowFilter(RowFilter.regexFilter("(?i)" + searchText));
        } else {
            sorter.setRowFilter(null);
        }
    }

    private void saveInventory() {
        try (PrintWriter writer = new PrintWriter(new File("inventory.txt"))) {
            for (InventoryItem item : inventory) {
                writer.println(item.toString());
            }
            showMessageDialog("Inventory saved successfully.");
        } catch (IOException e) {
            showErrorDialog("Error saving inventory: " + e.getMessage());
        }
    }

    private void loadInventory() {
        try (BufferedReader reader = new BufferedReader(new FileReader("inventory.txt"))) {
            inventory.clear();
            tableModel.setRowCount(0);

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                int quantity = Integer.parseInt(parts[2]);
                double price = Double.parseDouble(parts[3]);

                InventoryItem item = new InventoryItem(id, name, quantity, price);
                inventory.add(item);
                Object[] row = {id, name, quantity, price};
                tableModel.addRow(row);
            }

            showMessageDialog("Inventory loaded successfully.");
        } catch (IOException | NumberFormatException e) {
            showErrorDialog("Error loading inventory: " + e.getMessage());
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
        searchField.setText("");
        sorter.setRowFilter(null);
    }

    private void showMessageDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    private void showErrorDialog(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventoryApp().setVisible(true);
        });
    }
}

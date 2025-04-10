import java.sql.*;
import java.util.Scanner;

public class Update_Data {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "A!s#H46@9r7A2f0A$t";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            System.out.print("Enter student ID to update: ");
            int id = scanner.nextInt();
            scanner.nextLine();

            System.out.println("Which field do you want to update?");
            System.out.println("1. Name");
            System.out.println("2. Age");
            System.out.println("3. Marks");
            System.out.println("4. All");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            try (Connection connection = DriverManager.getConnection(url, username, password)) {
                String query = "";
                PreparedStatement preparedStatement = null;

                switch (choice) {
                    case 1 -> {
                        System.out.print("Enter new name: ");
                        String name = scanner.nextLine();
                        query = "UPDATE student SET name = ? WHERE id = ?";
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, name);
                        preparedStatement.setInt(2, id);
                    }
                    case 2 -> {
                        System.out.print("Enter new age: ");
                        int age = scanner.nextInt();
                        query = "UPDATE student SET age = ? WHERE id = ?";
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setInt(1, age);
                        preparedStatement.setInt(2, id);
                    }
                    case 3 -> {
                        System.out.print("Enter new marks: ");
                        float marks = scanner.nextFloat();
                        query = "UPDATE student SET marks = ? WHERE id = ?";
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setFloat(1, marks);
                        preparedStatement.setInt(2, id);
                    }
                    case 4 -> {
                        System.out.print("Enter new name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter new age: ");
                        int age = scanner.nextInt();
                        System.out.print("Enter new marks: ");
                        float marks = scanner.nextFloat();
                        query = "UPDATE student SET name = ?, age = ?, marks = ? WHERE id = ?";
                        preparedStatement = connection.prepareStatement(query);
                        preparedStatement.setString(1, name);
                        preparedStatement.setInt(2, age);
                        preparedStatement.setFloat(3, marks);
                        preparedStatement.setInt(4, id);
                    }
                    default -> {
                        System.out.println("Invalid choice.");
                        return;
                    }
                }

                int rowsUpdated = preparedStatement.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Student updated successfully.");
                } else {
                    System.out.println("No student found with that ID.");
                }

            } catch (SQLException s) {
                System.out.println("SQL Error: " + s.getMessage());
            }

        } catch (ClassNotFoundException e) {
            System.out.println("JDBC Driver not found: " + e.getMessage());
        }
    }
}


//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import java.sql.*;
//
//public class Update_Data {
//    private static final String url = "jdbc:mysql://localhost:3306/mydb";
//    private static final String username = "root";
//    private static final String password = "A!s#H46@9r7A2f0A$t";
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(Update_Data::createAndShowGUI);
//    }
//
//    public static void createAndShowGUI() {
//        JFrame frame = new JFrame("Update Student Data");
//        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        frame.setSize(400, 300);
//        frame.setLayout(new GridLayout(7, 2));
//
//        JLabel idLabel = new JLabel("Student ID:");
//        JTextField idField = new JTextField();
//        JLabel choiceLabel = new JLabel("Choose field to update:");
//        JComboBox<String> choiceComboBox = new JComboBox<>(new String[]{"Name", "Age", "Marks", "All"});
//        JLabel nameLabel = new JLabel("New Name:");
//        JTextField nameField = new JTextField();
//        JLabel ageLabel = new JLabel("New Age:");
//        JTextField ageField = new JTextField();
//        JLabel marksLabel = new JLabel("New Marks:");
//        JTextField marksField = new JTextField();
//        JButton updateButton = new JButton("Update");
//
//        frame.add(idLabel);
//        frame.add(idField);
//        frame.add(choiceLabel);
//        frame.add(choiceComboBox);
//        frame.add(nameLabel);
//        frame.add(nameField);
//        frame.add(ageLabel);
//        frame.add(ageField);
//        frame.add(marksLabel);
//        frame.add(marksField);
//        frame.add(updateButton);
//
//        // Initially hide the additional fields for Age, Marks, and Name based on the choice
//        nameLabel.setVisible(false);
//        nameField.setVisible(false);
//        ageLabel.setVisible(false);
//        ageField.setVisible(false);
//        marksLabel.setVisible(false);
//        marksField.setVisible(false);
//
//        choiceComboBox.addActionListener(e -> {
//            String choice = (String) choiceComboBox.getSelectedItem();
//            // Toggle visibility of input fields based on choice
//            if ("Name".equals(choice)) {
//                nameLabel.setVisible(true);
//                nameField.setVisible(true);
//                ageLabel.setVisible(false);
//                ageField.setVisible(false);
//                marksLabel.setVisible(false);
//                marksField.setVisible(false);
//            } else if ("Age".equals(choice)) {
//                nameLabel.setVisible(false);
//                nameField.setVisible(false);
//                ageLabel.setVisible(true);
//                ageField.setVisible(true);
//                marksLabel.setVisible(false);
//                marksField.setVisible(false);
//            } else if ("Marks".equals(choice)) {
//                nameLabel.setVisible(false);
//                nameField.setVisible(false);
//                ageLabel.setVisible(false);
//                ageField.setVisible(false);
//                marksLabel.setVisible(true);
//                marksField.setVisible(true);
//            } else if ("All".equals(choice)) {
//                nameLabel.setVisible(true);
//                nameField.setVisible(true);
//                ageLabel.setVisible(true);
//                ageField.setVisible(true);
//                marksLabel.setVisible(true);
//                marksField.setVisible(true);
//            }
//        });
//
//        updateButton.addActionListener(e -> {
//            String idText = idField.getText();
//            if (idText.isEmpty()) {
//                JOptionPane.showMessageDialog(frame, "Please enter a valid student ID.");
//                return;
//            }
//            int id = Integer.parseInt(idText);
//            String query = "";
//            String name = nameField.getText();
//            String ageText = ageField.getText();
//            String marksText = marksField.getText();
//
//            try (Connection connection = DriverManager.getConnection(url, username, password)) {
//                int choiceIndex = choiceComboBox.getSelectedIndex();
//                PreparedStatement preparedStatement = null;
//
//                switch (choiceIndex) {
//                    case 0: // Name
//                        if (name.isEmpty()) {
//                            JOptionPane.showMessageDialog(frame, "Name cannot be empty.");
//                            return;
//                        }
//                        query = "UPDATE student SET name = ? WHERE id = ?";
//                        preparedStatement = connection.prepareStatement(query);
//                        preparedStatement.setString(1, name);
//                        preparedStatement.setInt(2, id);
//                        break;
//                    case 1: // Age
//                        if (ageText.isEmpty()) {
//                            JOptionPane.showMessageDialog(frame, "Age cannot be empty.");
//                            return;
//                        }
//                        int age = Integer.parseInt(ageText);
//                        query = "UPDATE student SET age = ? WHERE id = ?";
//                        preparedStatement = connection.prepareStatement(query);
//                        preparedStatement.setInt(1, age);
//                        preparedStatement.setInt(2, id);
//                        break;
//                    case 2: // Marks
//                        if (marksText.isEmpty()) {
//                            JOptionPane.showMessageDialog(frame, "Marks cannot be empty.");
//                            return;
//                        }
//                        float marks = Float.parseFloat(marksText);
//                        query = "UPDATE student SET marks = ? WHERE id = ?";
//                        preparedStatement = connection.prepareStatement(query);
//                        preparedStatement.setFloat(1, marks);
//                        preparedStatement.setInt(2, id);
//                        break;
//                    case 3: // All
//                        if (name.isEmpty() || ageText.isEmpty() || marksText.isEmpty()) {
//                            JOptionPane.showMessageDialog(frame, "All fields must be filled.");
//                            return;
//                        }
//                        int ageAll = Integer.parseInt(ageText);
//                        float marksAll = Float.parseFloat(marksText);
//                        query = "UPDATE student SET name = ?, age = ?, marks = ? WHERE id = ?";
//                        preparedStatement = connection.prepareStatement(query);
//                        preparedStatement.setString(1, name);
//                        preparedStatement.setInt(2, ageAll);
//                        preparedStatement.setFloat(3, marksAll);
//                        preparedStatement.setInt(4, id);
//                        break;
//                    default:
//                        JOptionPane.showMessageDialog(frame, "Please select a valid option.");
//                        return;
//                }
//
//                int rowsUpdated = preparedStatement.executeUpdate();
//
//                if (rowsUpdated > 0) {
//                    JOptionPane.showMessageDialog(frame, "Student updated successfully.");
//                } else {
//                    JOptionPane.showMessageDialog(frame, "No student found with that ID.");
//                }
//
//            } catch (SQLException s) {
//                JOptionPane.showMessageDialog(frame, "SQL Error: " + s.getMessage());
//            }
//        });
//
//        frame.setVisible(true);
//    }
//}


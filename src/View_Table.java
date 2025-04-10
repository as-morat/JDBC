import java.sql.*;

public class View_Table {
    private static final String url = "jdbc:mysql://localhost:3306/mydb";
    private static final String username = "root";
    private static final String password = "A!s#H46@9r7A2f0A$t";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student";
            ResultSet resultSet = statement.executeQuery(query);

            String line = "+------+----------------------+-----+--------+";
            System.out.println(line);
            System.out.printf("| %-4s | %-20s | %-3s | %-6s |\n", "ID", "Name", "Age", "Marks");
            System.out.println(line);

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                double marks = resultSet.getDouble("marks");

                System.out.printf("| %-4d | %-20s | %-3d | %-6.2f |\n", id, name, age, marks);
            }

            System.out.println(line);

        } catch (SQLException s) {
            System.out.println(s.getMessage());
        }
    }
}

//import javax.swing.*;
//import javax.swing.table.DefaultTableModel;
//import java.sql.*;
//import java.awt.*;
//
//public class View_Table {
//    private static final String url = "jdbc:mysql://localhost:3306/mydb";
//    private static final String username = "root";
//    private static final String password = "A!s#H46@9r7A2f0A$t";
//
//    public static void main(String[] args) {
//        SwingUtilities.invokeLater(() -> {
//            JFrame frame = new JFrame("Student Table");
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setSize(600, 400);
//            frame.setLocationRelativeTo(null); // center the window
//
//            String[] columnNames = {"ID", "Name", "Age", "Marks"};
//            DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
//            JTable table = new JTable(tableModel);
//            JScrollPane scrollPane = new JScrollPane(table);
//
//            try {
//                Class.forName("com.mysql.cj.jdbc.Driver");
//                Connection connection = DriverManager.getConnection(url, username, password);
//                Statement statement = connection.createStatement();
//                ResultSet resultSet = statement.executeQuery("SELECT * FROM student");
//
//                while (resultSet.next()) {
//                    int id = resultSet.getInt("id");
//                    String name = resultSet.getString("name");
//                    int age = resultSet.getInt("age");
//                    double marks = resultSet.getDouble("marks");
//
//                    Object[] row = {id, name, age, marks};
//                    tableModel.addRow(row);
//                }
//
//                resultSet.close();
//                statement.close();
//                connection.close();
//            } catch (Exception e) {
//                JOptionPane.showMessageDialog(frame, "Error: " + e.getMessage());
//            }
//
//            frame.add(scrollPane, BorderLayout.CENTER);
//            frame.setVisible(true);
//        });
//    }
//}
//

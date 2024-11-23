package org.example.employeemanagementsystem;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HelloApplication extends Application {
    private TableView<Employee> employeeTable;
    private ObservableList<Employee> employees;

    @Override
    public void start(Stage primaryStage) {
        employees = FXCollections.observableArrayList();

        employeeTable = new TableView<>();
        TableColumn<Employee, String> nameColumn = new TableColumn<>("Name");
        nameColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getName()));

        TableColumn<Employee, String> typeColumn = new TableColumn<>("Type");
        typeColumn.setCellValueFactory(data -> new SimpleStringProperty(data.getValue().getEmployeeType()));

        TableColumn<Employee, String> salaryColumn = new TableColumn<>("Salary");
        salaryColumn.setCellValueFactory(data -> new SimpleStringProperty(
                String.format("%.2f", data.getValue().calculateSalary())
        ));

        employeeTable.getColumns().addAll(nameColumn, typeColumn, salaryColumn);

        // Поля ввода
        TextField nameField = new TextField();
        nameField.setPromptText("Name");

        ComboBox<String> typeBox = new ComboBox<>();
        typeBox.getItems().addAll("Full-time", "Part-time", "Contractor");

        TextField salaryField = new TextField();
        salaryField.setPromptText("Anual salary/Hourly rate");

        TextField hoursField = new TextField();
        hoursField.setPromptText("Work hours/Max. hours");

        Button addButton = new Button("Add employee");
        addButton.setOnAction(e -> {
            String name = nameField.getText();
            String type = typeBox.getValue();
            try {
                if (type.equals("Full-time")) {
                    double annualSalary = Double.parseDouble(salaryField.getText());
                    employees.add(new FullTimeEmployee(name, annualSalary));
                } else if (type.equals("Part-time")) {
                    double hourlyRate = Double.parseDouble(salaryField.getText());
                    int hours = Integer.parseInt(hoursField.getText());
                    employees.add(new PartTimeEmployee(name, hourlyRate, hours));
                } else if (type.equals("Contractor")) {
                    double hourlyRate = Double.parseDouble(salaryField.getText());
                    int maxHours = Integer.parseInt(hoursField.getText());
                    employees.add(new Contractor(name, hourlyRate, maxHours));
                }
                employeeTable.setItems(employees);
            } catch (NumberFormatException ex) {
                showAlert("Error", "Insert correct data.");
            }
        });

        // Интерфейс
        VBox root = new VBox(10, nameField, typeBox, salaryField, hoursField, addButton, employeeTable);
        Scene scene = new Scene(root, 600, 400);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Employee management");
        primaryStage.show();
    }

    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        alert.showAndWait();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

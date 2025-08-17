package gui;



import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import managers.AssignmentManager;
import models.Assignment;
import models.AssignmentType;
import models.CategoryType;
import models.Course;

public class LMSFrontend extends Application {

    // Backend managers
    private Course courseManager = new Course();
    private AssignmentManager assignmentManager = new AssignmentManager(null, null, null, null);

    // Observable lists to connect backend data with UI
    private ObservableList<Course> courses = FXCollections.observableArrayList();
    private ObservableList<Assignment> assignments = FXCollections.observableArrayList();

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("LMS - Learning Management System");

        TabPane tabPane = new TabPane();

        Tab courseTab = new Tab("Courses", createCoursePane());
        Tab assignmentTab = new Tab("Assignments", createAssignmentPane());

        tabPane.getTabs().addAll(courseTab, assignmentTab);

        Scene scene = new Scene(tabPane, 950, 600);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

   
    private Pane createCoursePane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        // Input fields
        TextField idField = new TextField();
        idField.setPromptText("Course ID");

        TextField nameField = new TextField();
        nameField.setPromptText("Course Name");

        TextField priceField = new TextField();
        priceField.setPromptText("Price");

        ComboBox<CategoryType> typeBox = new ComboBox<>();
        typeBox.getItems().addAll(CategoryType.values());

        // Buttons
        Button addBtn = new Button("Add");
        Button updateBtn = new Button("Update Selected");
        Button deleteBtn = new Button("Delete Selected");

        // Search field
        TextField searchField = new TextField();
        searchField.setPromptText("Search by Course Name...");

        // TableView
        TableView<Course> table = new TableView<>(courses);

        TableColumn<Course, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));

        TableColumn<Course, String> nameCol = new TableColumn<>("Name");
        nameCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getName()));

        TableColumn<Course, String> typeCol = new TableColumn<>("Category");
        typeCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getType().toString()));

        TableColumn<Course, String> priceCol = new TableColumn<>("Price");
        priceCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                String.valueOf(c.getValue().getPrice())));

        table.getColumns().addAll(idCol, nameCol, typeCol, priceCol);

        // Button actions
        addBtn.setOnAction(e -> {
            try {
                Course course = new Course(
                        idField.getText(),
                        nameField.getText(),
                        typeBox.getValue(),
                        Double.parseDouble(priceField.getText())
                );
                courseManager.add(course);
                courses.add(course);

                idField.clear(); nameField.clear(); priceField.clear(); typeBox.setValue(null);
            } catch (Exception ex) {
                showAlert("Error", "Please enter valid data.");
            }
        });

        updateBtn.setOnAction(e -> {
            Course selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                try {
                    selected.setId(idField.getText());
                    selected.setName(nameField.getText());
                    selected.setType(typeBox.getValue());
                    selected.setPrice(Double.parseDouble(priceField.getText()));

                    courseManager.update(selected);
                    table.refresh();
                } catch (Exception ex) {
                    showAlert("Error", "Invalid input for update.");
                }
            }
        });

        deleteBtn.setOnAction(e -> {
            Course selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                courseManager.delete(selected.getId());
                courses.remove(selected);
            }
        });

        // Search functionality
        searchField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.isEmpty()) {
                table.setItems(courses);
            } else {
                ObservableList<Course> filtered = FXCollections.observableArrayList();
                for (Course c : courses) {
                    if (c.getName().toLowerCase().contains(newVal.toLowerCase())) {
                        filtered.add(c);
                    }
                }
                table.setItems(filtered);
            }
        });

        HBox btnBox = new HBox(10, addBtn, updateBtn, deleteBtn);
        vbox.getChildren().addAll(idField, nameField, priceField, typeBox, btnBox, searchField, table);
        return vbox;
    }

  
    private Pane createAssignmentPane() {
        VBox vbox = new VBox(10);
        vbox.setPadding(new Insets(10));

        TextField idField = new TextField();
        idField.setPromptText("Assignment ID");

        TextField titleField = new TextField();
        titleField.setPromptText("Title");

        ComboBox<AssignmentType> typeBox = new ComboBox<>();
        typeBox.getItems().addAll(AssignmentType.values());

        DatePicker dueDatePicker = new DatePicker();

        Button addBtn = new Button("Add");
        Button updateBtn = new Button("Update Selected");
        Button deleteBtn = new Button("Delete Selected");

        TableView<Assignment> table = new TableView<>(assignments);

        TableColumn<Assignment, String> idCol = new TableColumn<>("ID");
        idCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getId()));

        TableColumn<Assignment, String> titleCol = new TableColumn<>("Title");
        titleCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(c.getValue().getTitle()));

        TableColumn<Assignment, String> typeCol = new TableColumn<>("Type");
        typeCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getType() != null ? c.getValue().getType().toString() : "N/A"));

        TableColumn<Assignment, String> dueCol = new TableColumn<>("Due Date");
        dueCol.setCellValueFactory(c -> new javafx.beans.property.SimpleStringProperty(
                c.getValue().getDueDate() != null ? c.getValue().getDueDate().toString() : "N/A"));

        table.getColumns().addAll(idCol, titleCol, typeCol, dueCol);

        // Add
        addBtn.setOnAction(e -> {
            try {
                Assignment assignment = new Assignment(
                        idField.getText(),
                        titleField.getText(),
                        typeBox.getValue(),
                        dueDatePicker.getValue()
                );
                assignmentManager.add(assignment);
                assignments.add(assignment);

                idField.clear(); titleField.clear(); typeBox.setValue(null); dueDatePicker.setValue(null);
            } catch (Exception ex) {
                showAlert("Error", "Invalid input for assignment.");
            }
        });

        // Update
        updateBtn.setOnAction(e -> {
            Assignment selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                selected.setId(idField.getText());
                selected.setTitle(titleField.getText());
                selected.setType(typeBox.getValue());
                selected.setDueDate(dueDatePicker.getValue());

                assignmentManager.update(selected);
                table.refresh();
            }
        });

        // Delete
        deleteBtn.setOnAction(e -> {
            Assignment selected = table.getSelectionModel().getSelectedItem();
            if (selected != null) {
                assignmentManager.delete(selected.getId());
                assignments.remove(selected);
            }
        });

        HBox btnBox = new HBox(10, addBtn, updateBtn, deleteBtn);
        vbox.getChildren().addAll(idField, titleField, typeBox, dueDatePicker, btnBox, table);
        return vbox;
    }

    
    private void showAlert(String title, String message) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

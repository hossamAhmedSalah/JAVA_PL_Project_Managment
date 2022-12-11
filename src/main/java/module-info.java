module com.java_pl_project_managment {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.java_pl_project_managment to javafx.fxml;
    exports com.java_pl_project_managment;

    requires java.sql;
    
}

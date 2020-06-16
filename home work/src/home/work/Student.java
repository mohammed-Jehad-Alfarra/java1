package home.work;

import database.DBConnection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import menuBar.MenuBarControl;
import profileView.Info;
import profileView.ProfileView;

import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
* Created for chegg
*/
public class Student {

@FXML
TableView<RegistrationTableData> studentRunningCourseTableView;
@FXML
TableColumn<RegistrationTableData,String> studentRCourseColumnCode;
@FXML
TableColumn<RegistrationTableData,String> studentRCourseColumnTitle;
@FXML
TableColumn<RegistrationTableData,Integer> studentRCourseColumnCredit;
@FXML
TableColumn<RegistrationTableData,String> studentRCourseColumnSec;


@FXML
TableView<resultHistoryTableData> resultHistoryTableView;
@FXML
TableColumn<resultHistoryTableData,String> resultHistoryColumnCode;
@FXML
TableColumn<resultHistoryTableData,String> resultHistoryColumnSec;
@FXML
TableColumn<resultHistoryTableData,String> resultHistoryColumnGPA;

@FXML
TextField studentTFFname;
@FXML
TextField studentTFLname;
@FXML
TextField studentTFID;
@FXML
TextField studentTFEmail;
@FXML
TextField studentTFPhone;
@FXML
TextField studentTFGFname;
@FXML
TextField studentTFGLname;
@FXML
TextField studentTFAddress;
@FXML
TextField studentTFPassword;
@FXML
TextField studentTFPicChooser;

@FXML
Button studentSaveClick;
@FXML
Button studentCancelClick;


private DBConnection database = new DBConnection();
private Connection connection;
private Statement statement;
private ResultSet resultSet;
RegistrationController registrationController;

private MenuBarControl menuBarControl = new MenuBarControl();

static String ID;
public void setStudentId(String ID){
this.ID = ID;
}

private ObservableList getDataFromResultHistoryAndAddToObservableList(String query) {
ObservableList<resultHistoryTableData> resultHistoryTableData = FXCollections.observableArrayList();

try {
connection = database.getConnection();
statement = connection.createStatement();
resultSet = statement.executeQuery(query);

String columnNo = null;
String[] devide = null,partPart = null;
while (resultSet.next()){
for (int i = 1; i < 16; i++) {
columnNo = resultSet.getString("dbstudentgpa"+i+"thSem");

String temp = "a"+columnNo;
temp = temp.substring(1);
if (temp.equals("null")||temp.isEmpty()){
break;
}
else {
devide = columnNo.split(",", 0);
for (String s : devide) {
partPart = s.split(":", 0);
resultHistoryTableData.add(new resultHistoryTableData(partPart[0], partPart[1], partPart[2]));
}
}

}
}


} catch (SQLException e) {
e.printStackTrace();
}

return resultHistoryTableData;
}
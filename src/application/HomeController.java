package application;

import java.net.URL;
import java.util.ResourceBundle;

import db.UserDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

public class HomeController implements Initializable {
	
	@FXML
    private Button button01;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		button01.setOnAction(event -> {
			System.out.println("処理開始");
			
			UserDAO userDAO = new UserDAO();
			
			var users = userDAO.findAll();
			users.forEach(user -> System.out.println(user));
			
			
			System.out.println("処理終了");			
		});
	}
}

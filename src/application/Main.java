package application;
	
import java.io.IOException;

import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.layout.BorderPane;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		/* アプリケーションスレッドでキャッチされなかった例外を処理 */
		Thread.currentThread().setUncaughtExceptionHandler((t, e) -> {
			showException(e);
		});
		
		try {
			BorderPane root;
			root = (BorderPane)FXMLLoader.load(getClass().getResource("Home.fxml"));
			Scene scene = new Scene(root,400,400);
			scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			primaryStage.setScene(scene);
			primaryStage.show();
		} catch (IOException e) {
			throw new RuntimeException("FXMLロードエラーが発生しました。", e);
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
	/**
	 * エラーダイアログを表示
	 * @param e
	 */
	protected void showException(Throwable e) {
		e.printStackTrace();

		Alert dialog = new Alert(Alert.AlertType.WARNING, e.getMessage());
		dialog.setTitle(e.getClass().getSimpleName());
		dialog.setHeaderText(null);
		dialog.showAndWait();
	}
}

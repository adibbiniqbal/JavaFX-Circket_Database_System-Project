package fx.cricketdatabase;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import Cricket.*;

public class HelloApplication extends Application {
    private Stage stage;
    private Scene scene;
    private PlayersDatabase playersData = new PlayersDatabase();

    @Override
    public void start(Stage stage) throws IOException {
        this.stage = stage;
        mainMenuScene();
    }


    public void mainMenuScene() throws IOException {
        FXMLLoader mainMenu = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        scene = new Scene(mainMenu.load());
        HelloController controller = mainMenu.getController();
        controller.setApplication(this);
        stage.setTitle("Cricket Player Database");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void quitScene() throws IOException {
        playersData.savePlayers();
        stage.close();
    }

    public void searchPlayerScene() throws IOException {
        FXMLLoader searchPlayerLoader = new FXMLLoader(HelloApplication.class.getResource("searchPlayers.fxml"));
        scene = new Scene(searchPlayerLoader.load());
        HelloController controller = searchPlayerLoader.getController();
        controller.setApplication(this);
        stage.setTitle("Search Players");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void searchClubScene() throws IOException {
        FXMLLoader searchClubLoader = new FXMLLoader(HelloApplication.class.getResource("searchClubs.fxml"));
        scene = new Scene(searchClubLoader.load());
        HelloController controller = searchClubLoader.getController();
        controller.setApplication(this);
        stage.setTitle("Search Clubs");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }

    public void addPlayerScene() throws IOException {
        FXMLLoader addPlayerLoader = new FXMLLoader(HelloApplication.class.getResource("addPlayers.fxml"));
        scene = new Scene(addPlayerLoader.load());
        AddPlayersController controller = addPlayerLoader.getController(); // Note the updated type
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Add Player");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void searchNameScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchPlayersName.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Search Players by Name");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void searchCountryClubScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchPlayersCountryClub.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Search Players by Country and Club");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void searchSalaryScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchPlayersSalary.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Search Players by Salary Range");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void searchPositionScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchPlayersPosition.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Search Players by Position");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void countryPlayersScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchPlayersCountryCount.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Country Wise Player Count");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void maxSalaryScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchClubsMaxSalary.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Club Player with maximum salary");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void maxAgeScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchClubsMaxAge.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Most senior player of club");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void maxHeightScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchClubsMaxHeight.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Tallest player of club");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }
    public void totalSalaryScene() throws IOException {
        FXMLLoader searchLoader = new FXMLLoader(HelloApplication.class.getResource("searchClubsTotalSalary.fxml"));
        scene = new Scene(searchLoader.load());
        SearchController controller = searchLoader.getController();
        controller.setApplication(this);
        controller.setPlayerDatabase(playersData);
        stage.setTitle("Total salary of club");
        stage.setResizable(false);
        stage.setScene(scene);
        stage.show();
    }




    public static void main(String[] args) {
        launch();
    }
}
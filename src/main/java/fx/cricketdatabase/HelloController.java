package fx.cricketdatabase;

import javafx.event.ActionEvent;

import java.io.IOException;

public class HelloController {
    public HelloApplication application;

    public HelloApplication getApplication() {
        return application;
    }

    public void setApplication(HelloApplication application) {
        this.application = application;
    }


    public void switchPlayerSearch(ActionEvent actionEvent) throws IOException {
        application.searchPlayerScene();
    }

    public void switchMainMenu(ActionEvent actionEvent) throws IOException {
        application.mainMenuScene();
    }

    public void switchClubSearch(ActionEvent actionEvent) throws IOException {
        application.searchClubScene();
    }

    public void switchAddPlayers(ActionEvent actionEvent) throws IOException {
        application.addPlayerScene();
    }

    public void quitApp(ActionEvent actionEvent) throws IOException {
        application.quitScene();
    }

    public void searchPlayerName(ActionEvent actionEvent) throws IOException {
        application.searchNameScene();
    }

    public void searchCountryClub(ActionEvent actionEvent) throws IOException {
        application.searchCountryClubScene();
    }

    public void searchPosition(ActionEvent actionEvent) throws IOException {
        application.searchPositionScene();
    }

    public void searchSalaryRange(ActionEvent actionEvent) throws IOException {
        application.searchSalaryScene();
    }

    public void searchCountryPlayerCount(ActionEvent actionEvent) throws IOException {
        application.countryPlayersScene();
    }

    public void searchClubSalary(ActionEvent actionEvent) throws IOException {
        application.maxSalaryScene();
    }

    public void searchClubAge(ActionEvent actionEvent) throws IOException {
        application.maxAgeScene();
    }

    public void searchClubHeight(ActionEvent actionEvent) throws IOException {
        application.maxHeightScene();
    }

    public void searchClubTotalSalary(ActionEvent actionEvent) throws IOException {
        application.totalSalaryScene();
    }
}
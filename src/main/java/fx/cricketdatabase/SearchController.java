package fx.cricketdatabase;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.util.Map;

import Cricket.*;

public class SearchController {


    public TextField name;
    public TextField country;
    public TextField club;
    public TextField position;
    public TextField minSalary;
    public TextField maxSalary;
    public TextField clubHeight;
    public TextField clubAge;
    public TextField clubTotalSalary;
    public TextField clubSalary;
    public ListView<Player> playerListView = new ListView<>();
    public Label clubTotalSalaryLabel;
    public ListView<String> playerCountryCount = new ListView<>();
    public Label playerSalaryLabel;
    private HelloApplication application;
    private PlayersDatabase playersData;


    public void setApplication(HelloApplication application) {
        this.application = application;
    }


    public void setPlayerDatabase(PlayersDatabase playersData) {
        this.playersData = playersData;
        ObservableList<Player> players = FXCollections.observableArrayList(playersData.getPlayers());
        playerListView.setItems(players);
    }


    public void playerSearchMenu(ActionEvent actionEvent) throws IOException {
        application.searchPlayerScene();
    }
    public void clubSearchMenu(ActionEvent actionEvent) throws IOException {
        application.searchClubScene();
    }
    public void searchPlayerName(ActionEvent actionEvent) {
        String searchName = name.getText().trim();
        if (!searchName.isEmpty()) {
            ObservableList<Player> results = FXCollections.observableArrayList(
                    playersData.searchName(searchName)
            );
            playerListView.setItems(results);
        }
        name.clear();
    }

    public void searchPlayerCountryClub(ActionEvent actionEvent) {
        String searchCountry = country.getText().trim();
        String searchClub = club.getText().trim();
        if (!searchCountry.isEmpty() && !searchClub.isEmpty()) {
            ObservableList<Player> results = FXCollections.observableArrayList(
                    playersData.searchClubCountry(searchCountry, searchClub)
            );
            playerListView.setItems(results);
        }
        country.clear();
        club.clear();
    }

    public void searchPlayerPosition(ActionEvent actionEvent) {
        String searchPosition = position.getText().trim();
        if (!searchPosition.isEmpty()) {
            ObservableList<Player> results = FXCollections.observableArrayList(playersData.searchPosition(searchPosition));
            playerListView.setItems(results);
        }
        position.clear();
    }

    public void searchPlayerSalary(ActionEvent actionEvent) {
        try {
            int min = Integer.parseInt(minSalary.getText().trim());
            int max = Integer.parseInt(maxSalary.getText().trim());
            ObservableList<Player> results = FXCollections.observableArrayList(playersData.searchSalaryRange(min, max));
            playerListView.setItems(results);
        } catch (NumberFormatException e) {
            playerSalaryLabel.setText("Invalid salary range input");
        }
        minSalary.clear();
        maxSalary.clear();
    }

    public void searchClubAge(ActionEvent actionEvent) {
        String searchClub = clubAge.getText().trim();
        if (!searchClub.isEmpty()) {
            ObservableList<Player> results = FXCollections.observableArrayList(playersData.maximumAge(searchClub));
            playerListView.setItems(results);
        }
        clubAge.clear();
    }


    public void searchClubSalary(ActionEvent actionEvent) {
        String searchClub = clubSalary.getText().trim();
        if (!searchClub.isEmpty()) {
            ObservableList<Player> results = FXCollections.observableArrayList(playersData.maximumSalary(searchClub));
            playerListView.setItems(results);
        }
        clubSalary.clear();
    }

    public void searchClubHeight(ActionEvent actionEvent) {
        String searchClub = clubHeight.getText().trim();
        if (!searchClub.isEmpty()) {
            ObservableList<Player> results = FXCollections.observableArrayList(playersData.maximumHeight(searchClub));
            playerListView.setItems(results);
        }
        clubHeight.clear();
    }

    public void searchClubTotalSalary(ActionEvent actionEvent) {
        String searchClub = clubTotalSalary.getText().trim();
        double totalSalary = 0;
        if (!searchClub.isEmpty()) {
            totalSalary = playersData.totalClubSalary(searchClub);
        }
        if(totalSalary>0){
            clubTotalSalaryLabel.setText(String.format("Total Weekly Salary of %s: %.0f", searchClub, totalSalary));
        }
        else{
            clubTotalSalaryLabel.setText("Club does not exist");
        }
        clubTotalSalary.clear();
    }

    public void searchCountryCount(ActionEvent actionEvent) {
        Map<String, Integer> countryCounts = playersData.countryPlayers(); // Assumes this method exists in PlayersDatabase
        ObservableList<String> countryList = FXCollections.observableArrayList();
        for (Map.Entry<String, Integer> entry : countryCounts.entrySet()) {
            String displayText = String.format("%s: %d players", (entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1).toLowerCase()), entry.getValue());
            countryList.add(displayText);
        }
        playerCountryCount.setItems(countryList);
    }
}


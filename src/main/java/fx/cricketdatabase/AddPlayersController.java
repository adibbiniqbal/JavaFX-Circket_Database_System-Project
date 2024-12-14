package fx.cricketdatabase;

import Cricket.PlayersDatabase;
import javafx.event.ActionEvent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.io.IOException;

public class AddPlayersController {
    public TextField playerName;
    public TextField playerCountry;
    public TextField playerAge;
    public TextField playerHeight;
    public TextField playerPosition;
    public TextField playerClub;
    public TextField playerNumber;
    public TextField playerWeeklySalary;
    public Label prompt;
    private PlayersDatabase playersData;

    private HelloApplication application;

    public void setApplication(HelloApplication application) {
        this.application = application;
    }
    public void setPlayerDatabase(PlayersDatabase playersData) {
        this.playersData = playersData;
    }

    public void backToMenuButton(ActionEvent actionEvent) throws IOException {
        application.mainMenuScene();

    }


public void addPlayerButton(ActionEvent actionEvent) {
    try {
        String name = playerName.getText().trim();
        String country = playerCountry.getText().trim();
        String club = playerClub.getText().trim();
        String position = playerPosition.getText().trim();
        int age = validateIntegerInput(playerAge.getText().trim(), "Age");
        int number = validateIntegerInput(playerNumber.getText().trim(), "Jersey Number");
        double height = validateDoubleInput(playerHeight.getText().trim(), "Height");
        int weeklySalary = validateIntegerInput(playerWeeklySalary.getText().trim(), "Weekly Salary");

        if (name.isEmpty() || country.isEmpty() || club.isEmpty() || position.isEmpty()) {
            prompt.setText("Error: All fields must be filled!");
            return;
        }

        boolean added = playersData.addPlayer(name, country, age, height, position, club, number, weeklySalary);
        if(added) {
            prompt.setText("Added player successfully!");
        }
        else{
            prompt.setText("Error adding player!");
        }
        clearInputFields();
    } catch (NumberFormatException e) {
        prompt.setText("Error: Invalid number format in one or more fields!");
    } catch (IllegalArgumentException e) {
        prompt.setText("Error: " + e.getMessage());
    } catch (Exception e) {
        prompt.setText("Error: Could not add the player!");
    }
}

    private int validateIntegerInput(String input, String fieldName) throws IllegalArgumentException {
        if (input.isEmpty()) throw new IllegalArgumentException(fieldName + " must be provided.");
        int value = Integer.parseInt(input);
        if (value < 0) throw new IllegalArgumentException(fieldName + " cannot be negative.");
        return value;
    }

    private double validateDoubleInput(String input, String fieldName) throws IllegalArgumentException {
        if (input.isEmpty()) throw new IllegalArgumentException(fieldName + " must be provided.");
        double value = Double.parseDouble(input);
        if (value < 0) throw new IllegalArgumentException(fieldName + " cannot be negative.");
        return value;
    }

    private void clearInputFields() {
        playerName.clear();
        playerCountry.clear();
        playerAge.clear();
        playerHeight.clear();
        playerPosition.clear();
        playerClub.clear();
        playerNumber.clear();
        playerWeeklySalary.clear();
    }
}


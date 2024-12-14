package Cricket;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PlayersDatabase {
    private final List<Player> playerList = new ArrayList<Player>();
    private final Map<String, Integer> countryPlayerCount = new HashMap<String, Integer>();
    private final String FILE_NAME;

    public PlayersDatabase() {
        this.FILE_NAME = "players.txt";
        loadPlayers();
    }

    private void loadPlayers() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME));
            String line;
            while (true) {
                line = reader.readLine();
                if (line == null) {
                    System.out.println("Successfully loaded " + playerList.size() + " players from " + FILE_NAME);
                    reader.close();
                    return;
                }
                String[] playerInfo = line.split(",");
                String name = playerInfo[0].trim();
                String country = playerInfo[1].trim();
                int age = Integer.parseInt(playerInfo[2]);
                double height = Double.parseDouble(playerInfo[3]);
                String club = playerInfo[4].trim();
                String position = playerInfo[5].trim();
                int number = playerInfo[6].isEmpty() ? -1 : Integer.parseInt(playerInfo[6]);
                int weeklySalary = Integer.parseInt(playerInfo[7]);
                countryPlayerCount.put(country.trim().toLowerCase(), countryPlayerCount.getOrDefault(country.trim().toLowerCase(), 0) + 1);
                playerList.add(new Player(name, country, age, height, club, position, number, weeklySalary));
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }

    public void savePlayers() {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME));
            for (Player player : playerList) {
                writer.write(String.format("%s,%s,%d,%.2f,%s,%s,%s,%d\n",
                        player.getName(),
                        player.getCountry(),
                        player.getAge(),
                        player.getHeight(),
                        player.getClub(),
                        player.getPosition(),
                        player.getNumber() == -1 ? "" : player.getNumber(),
                        player.getWeeklySalary()));
            }
            System.out.println("Successfully saved " + playerList.size() + " players to " + FILE_NAME);
            writer.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public List<Player> getPlayers() {
        return playerList;
    }


    public boolean addPlayer(String name, String country, int age, double height, String club, String position, int number, int weeklySalary) {
        for (Player player : playerList) {
            if (player.getName().equalsIgnoreCase(name)) {
                return false;
            }
        }
        countryPlayerCount.put(country.trim().toLowerCase(), countryPlayerCount.getOrDefault(country.trim().toLowerCase(), 0) + 1);
        playerList.add(new Player(name, country, age, height, club, position, number, weeklySalary));
        return true;
    }

    private void displayPlayers(List<Player> Players) {
        if (Players.isEmpty()) {
            System.out.println("No such player exists!");
        }
        for (Player player : Players) {
            player.display();
        }
        System.out.println();
    }

    public List<Player> searchName(String name) {
        List<Player> result = new ArrayList<Player>();
        for (Player player : playerList) {
            if (name.equalsIgnoreCase(player.getName())) {
                result.add(player);
            }
        }
        return result;
    }

    public List<Player> searchClubCountry(String country, String club) {
        List<Player> result = new ArrayList<Player>();
        for (Player player : playerList) {
            if (country.equalsIgnoreCase(player.getCountry())
                    && (club.equalsIgnoreCase(player.getClub()) || club.equalsIgnoreCase("ANY"))) {
                result.add(player);
            }
        }
        return result;
    }

    public List<Player> searchPosition(String position) {
        List<Player> result = new ArrayList<Player>();
        for (Player player : playerList) {
            if (position.equalsIgnoreCase(player.getPosition())) {
                result.add(player);
            }
        }
        return result;
    }

    public List<Player> searchSalaryRange(int min, int max) {
        List<Player> result = new ArrayList<Player>();
        for (Player player : playerList) {
            double salary = player.getWeeklySalary();
            if (salary >= min && salary <= max) {
                result.add(player);
            }
        }
        return result;
    }

    public Map<String, Integer> countryPlayers() {
//        System.out.println("\nCountry-wise Player Count:");
//        for (Map.Entry<String, Integer> entry : countryPlayerCount.entrySet()) {
//            System.out.println("Country: " + (entry.getKey().substring(0, 1).toUpperCase() + entry.getKey().substring(1).toLowerCase()) + ", Count: " + entry.getValue());
//        }
        return countryPlayerCount;
    }

    public List<Player> maximumSalary(String club) {
        double maxSalary = -1;
        List<Player> result = new ArrayList<Player>();
        for (Player player : playerList) {
            if (club.equalsIgnoreCase(player.getClub()) && (maxSalary < player.getWeeklySalary())) {
                maxSalary = player.getWeeklySalary();
            }
        }
        if (maxSalary == -1) {
            return result;
        }
        for (Player player : playerList) {
            if (club.equalsIgnoreCase(player.getClub()) && (maxSalary == player.getWeeklySalary())) {
                result.add(player);
            }
        }
        return result;
    }

    public List<Player> maximumAge(String club) {
        int maxAge = -1;
        List<Player> result = new ArrayList<Player>();
        for (Player player : playerList) {
            if (club.equalsIgnoreCase(player.getClub()) && (maxAge < player.getAge())) {
                maxAge = player.getAge();
            }
        }
        if (maxAge == -1) {
            return result;
        }
        for (Player player : playerList) {
            if (club.equalsIgnoreCase(player.getClub()) && (maxAge == player.getAge())) {
                result.add(player);
            }
        }
        return result;
    }

    public List<Player> maximumHeight(String club) {
        double maxHeight = -1;
        List<Player> result = new ArrayList<Player>();
        for (Player player : playerList) {
            if (club.equalsIgnoreCase(player.getClub()) && (maxHeight < player.getHeight())) {
                maxHeight = player.getHeight();
            }
        }
        if (maxHeight == -1) {
            return result;
        }
        for (Player player : playerList) {
            if (club.equalsIgnoreCase(player.getClub()) && (maxHeight == player.getHeight())) {
                result.add(player);
            }
        }
        return result;
    }

    public double totalClubSalary(String club) {
        double totalSalary = 0;
        for (Player player : playerList) {
            if (club.equalsIgnoreCase(player.getClub())) {
                totalSalary = totalSalary + player.getWeeklySalary();
            }
        }
        return totalSalary;
    }

}



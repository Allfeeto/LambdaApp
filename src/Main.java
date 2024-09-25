import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

// игрв
class Game {
    String name;
    int releaseYear;
    String genre;
    String systemRequirements;

    public Game(String name, int releaseYear, String genre, String systemRequirements) {
        this.name = name;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.systemRequirements = systemRequirements;
    }

    public void displayInfo() {
        System.out.println("Название игры: " + name);
        System.out.println("Год выпуска: " + releaseYear);
        System.out.println("Жанр: " + genre);
        System.out.println("Системные требования: " + systemRequirements);
    }
}


class Developer {
    String name;
    double rating;

    public Developer(String name, double rating) {
        this.name = name;
        this.rating = rating;
    }

    public void displayInfo() {
        System.out.println("Название разработчика: " + name);
        System.out.println("Рейтинг: " + rating);
    }
}

public class Main {
    public static void main(String[] args) {
        // Список игр
        List<Game> games = new ArrayList<>();
        games.add(new Game("Game 1", 2020, "Action", "Windows 10, 8GB RAM, GTX 1050"));
        games.add(new Game("Game 2", 2019, "RPG", "Windows 8, 4GB RAM, GTX 960"));
        games.add(new Game("Game 3", 2021, "Adventure", "Windows 10, 16GB RAM, GTX 1070"));

        // Список разработчиков
        List<Developer> developers = new ArrayList<>();
        developers.add(new Developer("Dev 1", 4.5));
        developers.add(new Developer("Dev 2", 4.7));
        developers.add(new Developer("Dev 3", 4.2));

        // лямбда-выражение для фильтрации игр по жанру
        System.out.println("Игры жанра RPG:");
        filterGames(games, game -> game.genre.equals("RPG"));

        // лямбда-выражение для фильтрации разработчиков по рейтингу
        System.out.println("\nРазработчики с рейтингом выше 4.5:");
        filterDevelopers(developers, dev -> dev.rating > 4.5);
    }

    // Метод для фильтрации игр
    public static void filterGames(List<Game> games, Predicate<Game> condition) {
        for (Game game : games) {
            if (condition.test(game)) {
                game.displayInfo();
                System.out.println();
            }
        }
    }

    // Метод для фильтрации разработчиков
    public static void filterDevelopers(List<Developer> developers, Predicate<Developer> condition) {
        for (Developer dev : developers) {
            if (condition.test(dev)) {
                dev.displayInfo();
                System.out.println();
            }
        }
    }
}

import model.Game;
import service.GameBuilder;
import service.GameService;

public class Main {
    public static void main(String[] args) {
        // Move interactive setup to GameBuilder so Main stays small and focused.
        GameBuilder builder = new GameBuilder();
        Game game = builder.buildFromConsole();

        GameService gameService = new GameService();
        gameService.gameStart(game);

        System.out.println("Game has finished. Thanks for playing!");
    }
}

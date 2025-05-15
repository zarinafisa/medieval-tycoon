
package interfaces;


public interface FileManager {
    public boolean saveGame(Player player);
    public Player loadGame(String username);
    public boolean saveHighScore(Player player);
}

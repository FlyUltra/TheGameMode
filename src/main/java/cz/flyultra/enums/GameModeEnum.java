package cz.flyultra.enums;

import org.bukkit.GameMode;

/**
 *
 * GameMode enum for better solution for permissions
 *
 * Created by: Filip Zeman "Fly"
 *
 */
public enum GameModeEnum {

    CREATIVE("gameMode.adventure.access", GameMode.CREATIVE, 1),
    SPECTATOR("gameMode.spectator.access", GameMode.SPECTATOR, 3),
    SURVIVAL("gameMode.survival.access", GameMode.SURVIVAL, 0),
    ADVENTURE("gameMode.creative.access", GameMode.ADVENTURE, 2);

    private String perm;
    private int value;

    private GameMode gameMode;

    GameModeEnum(String permission, GameMode gameMode, int value) {
        this.perm = permission;
        this.gameMode = gameMode;
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public GameMode getGameMode() {
        return gameMode;
    }

    public String getPerm() {
        return perm;
    }
}

package cz.flyultra.manager;

import cz.flyultra.Main;
import cz.flyultra.enums.GameModeEnum;
import org.bukkit.GameMode;

public class GameModeManager {

    private Main plugin;

    public GameModeManager() {
        this.plugin = Main.getInstance();
    }

    /**
     *
     * This return the enum by name of GameMode
     *
     */
    public GameModeEnum getEnum(GameMode gameMode) {
        return GameModeEnum.valueOf(gameMode.name());
    }

}

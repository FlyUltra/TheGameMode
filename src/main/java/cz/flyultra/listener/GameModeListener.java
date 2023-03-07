package cz.flyultra.listener;

import cz.flyultra.Main;
import cz.flyultra.enums.GameModeEnum;
import cz.flyultra.enums.TypePermission;
import cz.flyultra.utils.ColorAPI;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;

public class GameModeListener implements Listener {

    private Main plugin;

    public GameModeListener() {
        this.plugin = Main.getInstance();
    }

    /**
     *
     * Listener for checking if player can change the GameMode!
     *
     * @param event PlayerGameModeChangeEvent
     */
    @EventHandler
    public void onChange(PlayerGameModeChangeEvent event) {
        Player player = event.getPlayer();
        GameMode gameMode = event.getNewGameMode();
        GameModeEnum gameModeEnum = plugin.getGameModeManager().getEnum(gameMode);

        if (!plugin.getGameModeTaker().hasPerm(player, gameModeEnum, TypePermission.HAVE)) {
            event.setCancelled(true);
        }
        ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fTvůj herní mod se změnil na &a&l" + gameModeEnum.name()+"&f!");
    }


}

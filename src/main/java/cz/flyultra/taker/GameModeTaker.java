package cz.flyultra.taker;

import cz.flyultra.Main;
import cz.flyultra.enums.GameModeEnum;
import cz.flyultra.enums.TypePermission;
import cz.flyultra.utils.ColorAPI;
import org.bukkit.GameMode;
import org.bukkit.entity.Player;

public class GameModeTaker {

    private Main plugin;

    public GameModeTaker() {
        this.plugin = Main.getInstance();
    }

    /**
     *
     * Custom method for hasPermission
     * We build that permission by GameMode Enum, and Type of required perm
     *
     * @return true/false if he has the perm
     */
    public boolean hasPerm(Player player, GameModeEnum gameMode, TypePermission type) {
        if (!player.hasPermission(gameMode.getPerm() + type.getType())) {
            ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fMáš nedostatečná oprávnění!");
            return false;
        }
        return player.hasPermission(gameMode.getPerm() + type.getType());
    }

    /**
     *
     * Method for change the GameMode by player, and enum of GameMode
     *
     */
    public void changeGameMode(Player player, GameModeEnum gameMode) {
        if (hasPerm(player, gameMode, TypePermission.HAVE)) {
            player.setGameMode(gameMode.getGameMode());
        }
    }

    /**
     *
     * Method with switch of arg, for command
     *
     * @param arg args[0] in command
     */
    public void gameMode(Player player, String arg) {
        GameModeEnum gameModeEnum;
        switch (arg.toLowerCase()) {
            case "creative", "c" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.CREATIVE);
                changeGameMode(player, gameModeEnum);
                return;
            }
            case "survival", "s" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.SURVIVAL);
                changeGameMode(player, gameModeEnum);
                return;
            }
            case "spectator", "sp" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.SPECTATOR);
                changeGameMode(player, gameModeEnum);
                return;
            }
            case "adventure", "a" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.ADVENTURE);
                changeGameMode(player, gameModeEnum);
                return;
            }
            default -> {
                return;
            }
        }
    }

    /**
     *
     * Method with switch of arg, for command
     * For target
     *
     * @param arg args[0] in command
     * @param target our target we want to change GameMode for him
     */
    public void gameModeTarget(Player player, Player target, String arg) {
        GameModeEnum gameModeEnum;
        switch (arg.toLowerCase()) {
            case "creative", "c" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.CREATIVE);
                if (hasPerm(player, gameModeEnum, TypePermission.OTHER)) {
                    ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fZměnil si mod hráči &c"+target.getPlayer()+"&f!");
                    changeGameMode(target, gameModeEnum);
                }
            }
            case "survival", "s" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.SURVIVAL);
                if (hasPerm(player, gameModeEnum, TypePermission.OTHER)) {
                    ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fZměnil si mod hráči &c"+target.getPlayer()+"&f!");
                    changeGameMode(target, gameModeEnum);
                }
            }
            case "spectator", "sp" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.SPECTATOR);
                if (hasPerm(player, gameModeEnum, TypePermission.OTHER)) {
                    ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fZměnil si mod hráči &c"+target.getPlayer()+"&f!");
                    changeGameMode(target, gameModeEnum);
                }
            }
            case "adventure", "a" -> {
                gameModeEnum = plugin.getGameModeManager().getEnum(GameMode.ADVENTURE);
                if (hasPerm(player, gameModeEnum, TypePermission.OTHER)) {
                    ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fZměnil si mod hráči &c"+target.getPlayer()+"&f!");
                    changeGameMode(target, gameModeEnum);
                }
            }
            default -> {
                ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fŠpatný syntax!");
            }
        }
    }


}

package cz.flyultra.command;

import cz.flyultra.Main;
import cz.flyultra.utils.ColorAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class GameModeCommand implements CommandExecutor {

    private Main plugin;

    public GameModeCommand() {
        this.plugin = Main.getInstance();
    }

    /**
     *
     * Command /gamemode
     *
     */
    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String s, String[] args) {
        if (!(sender instanceof Player)) {
            sender.sendMessage("This command can be only used from game!");
        }

        Player player = Bukkit.getPlayer(sender.getName());

        if (args.length == 1) {
            plugin.getGameModeTaker().gameMode(player, args[0]);
            return true;
        }

        if (args.length == 2) {
            Player target = Bukkit.getPlayer(args[1]);
            if (target == null) {
                ColorAPI.sendMessage(player,"{/#b36000}&lGameMode{/#72cc00} &7>> &fUživatel &c"+args[1]+" &fnení připojen!");
                return true;
            }
            plugin.getGameModeTaker().gameModeTarget(player, target, args[0]);
            return true;
        }


        return true;
    }
}

package cz.flyultra;

import cz.flyultra.command.GameModeCommand;
import cz.flyultra.listener.GameModeListener;
import cz.flyultra.manager.GameModeManager;
import cz.flyultra.taker.GameModeTaker;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.TabCompleter;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class Main extends JavaPlugin {

    private static Main instance;

    private GameModeManager gameModeManager;
    private GameModeTaker gameModeTaker;

    @Override
    public void onEnable() {
        instance = this;

        gameModeManager = new GameModeManager();
        gameModeTaker = new GameModeTaker();
        registerListener(new GameModeListener());
        registerCommand(new GameModeCommand(), "gamemode");
    }

    @Override
    public void onDisable() {

    }

    public void registerCommand(CommandExecutor commandExecutor, String cmd) {
        Objects.requireNonNull(getCommand(cmd)).setExecutor(commandExecutor);}

    public void registerTabCompleter(TabCompleter commandExecutor, String cmd) {
        Objects.requireNonNull(getCommand(cmd)).setTabCompleter(commandExecutor);}

    public void registerListener(Listener listener) {
        getServer().getPluginManager().registerEvents(listener, this);
    }


    public static Main getInstance() {
        return instance;
    }

    public GameModeManager getGameModeManager() {
        return gameModeManager;
    }

    public GameModeTaker getGameModeTaker() {
        return gameModeTaker;
    }
}
package me.AshenClock;

import me.AshenClock.commands.CommandPosition;
import me.AshenClock.commands.OffPlayers;
import org.bukkit.plugin.java.JavaPlugin;
public class PlayerPositions extends JavaPlugin {
    @Override
    public void onEnable(){
        System.out.println("PlayerPositions Attivato!");
        this.getCommand("PlayerPositions").setExecutor(new CommandPosition());
        this.getCommand("OffPlayers").setExecutor(new OffPlayers());
    }
    @Override
    public void onDisable(){
        System.out.println("PlayerPositions Disattivato!");
    }

}

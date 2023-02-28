package me.AshenClock.commands;
import org.bukkit.ChatColor;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
public class CommandPosition implements CommandExecutor {
    @Override
    public boolean onCommand( CommandSender sender, Command command, String label, String[] args){
        if (sender instanceof Player) {
            Server server = sender.getServer();
            Player player = (Player) sender;
            int i = 1;
            player.sendMessage(ChatColor.YELLOW + "Your Current Position:" + ChatColor.GREEN + " X: " + ChatColor.AQUA + ((int)player.getLocation().getX()) + ChatColor.GREEN + " Y: " +  ChatColor.AQUA + (int)player.getLocation().getY() + ChatColor.GREEN + " Z: " + ChatColor.AQUA + (int)player.getLocation().getZ());
            for (Player p : server.getOnlinePlayers()) {
                try {
                    if (!player.equals(p))
                        player.sendMessage(ChatColor.YELLOW + "" + (i++) + "." + ChatColor.WHITE +" Name: " + ChatColor.GREEN + p.getDisplayName() + ChatColor.WHITE + " World: " + ChatColor.GREEN + p.getLocation().getWorld().getEnvironment() + ChatColor.WHITE + " X:" + ChatColor.AQUA + (int) p.getLocation().getX() + ChatColor.WHITE + " Y:" + ChatColor.AQUA + (int) p.getLocation().getY() +
                                ChatColor.WHITE + " Z:" + ChatColor.AQUA + (int) p.getLocation().getZ());
                } catch (Exception ex) {
                    System.out.println("ERRORE!");
                }
            }
            return true;
        }
        return false;
    }
    }

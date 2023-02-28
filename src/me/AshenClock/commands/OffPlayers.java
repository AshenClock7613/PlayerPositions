package me.AshenClock.commands;

import net.querz.nbt.io.NBTUtil;
import net.querz.nbt.io.NamedTag;
import net.querz.nbt.tag.CompoundTag;
import net.querz.nbt.tag.DoubleTag;
import net.querz.nbt.tag.Tag;
import org.bukkit.ChatColor;
import org.bukkit.OfflinePlayer;
import org.bukkit.Server;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class OffPlayers implements CommandExecutor {
    @Override
   public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        Server server = sender.getServer();
        int i = 1;
        DateFormat obj = new SimpleDateFormat("dd MMM yyyy HH:mm:ss");
        for(OfflinePlayer p : server.getOfflinePlayers()){
            if(!p.isOnline()) {
                Date data = new Date(p.getLastPlayed());
                try {
                    String dir = System.getProperty("user.dir") + "/world/playerdata/";
                    NamedTag n = NBTUtil.read(dir + p.getUniqueId() + ".dat");
                    CompoundTag c = (CompoundTag) n.getTag();
                    Tag<?> b = c.get("Pos");
                    List<DoubleTag> h = (List<DoubleTag>) b.getValue();
                    sender.sendMessage(ChatColor.YELLOW + "" + (i++) + ". Name: " + ChatColor.AQUA + p.getName() + ChatColor.YELLOW + " Last Login: " + ChatColor.AQUA + obj.format(data) + "\n" +
                            ChatColor.GREEN + "X: " + ChatColor.AQUA + h.get(0).getValue().intValue() + ChatColor.GREEN + " Y: " + ChatColor.AQUA + h.get(1).getValue().intValue() + ChatColor.GREEN + " Z: " + ChatColor.AQUA + h.get(2).getValue().intValue());
                } catch (IOException e) {
                    System.out.println(e.getMessage());
                }
            }
        }
    return true;
    }
}

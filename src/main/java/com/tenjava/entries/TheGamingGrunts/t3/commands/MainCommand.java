package com.tenjava.entries.TheGamingGrunts.t3.commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

import com.tenjava.entries.TheGamingGrunts.t3.enums.MessageType;
import com.tenjava.entries.TheGamingGrunts.t3.events.ChangeRiderEvent;
import com.tenjava.entries.TheGamingGrunts.t3.events.HailStormEvent;
import com.tenjava.entries.TheGamingGrunts.t3.events.MobDownpourEvent;

public class MainCommand implements CommandExecutor {

	public boolean onCommand(CommandSender sender, Command cmd, String cml, String[] args){
		if (cml.equalsIgnoreCase("mm")){
			if (args.length == 1){
				switch(args[0]){
					case "passenger":
						Bukkit.getPluginManager().callEvent(new ChangeRiderEvent());
						break;
					case "downpour":
						Bukkit.getPluginManager().callEvent(new MobDownpourEvent());
						break;
					case "hailstorm":
						Bukkit.getPluginManager().callEvent(new HailStormEvent());
						break;
					default:
						sender.sendMessage(MessageType.CMD_INVALID.getMsg() + " Try /mm <passenger | downpour | hailstorm>");
						break;
				}
			}
		}
		return false;
	}
}

package com.github.tuserver.api.commands.defaultCommands;

import java.util.ArrayList;
import java.util.List;

import com.github.tuserver.api.TUServer;
import com.github.tuserver.api.commands.ICommandSender;
import com.github.tuserver.api.commands.ICommandWrapper;
import com.github.tuserver.api.plugin.Plugin;
import com.github.tuserver.api.utils.ChatColors;

public class EnableCmd implements ICommandWrapper {
	@Override
	public String getCommandName() {
		return "enable";
	}

	@Override
	public List getCommandAliases() {
		List<String> list = new ArrayList<String>();
		return list;
	}

	@Override
	public void onCommand(ICommandSender sender, String[] args) {
		if (sender.hasPermission("tus.enable")) {
			if (args.length == 0) {
				// TODO Permissions
				sender.sendMessage(ChatColors.RED + "Need more arguments!");
				sender.sendMessage(ChatColors.RED + "/enable [pluginName]");
			} else {
				if (TUServer.getPluginManager().getPlugin(args[0]) != null) {
					Plugin plugin = TUServer.getPluginManager().getPlugin(args[0]);

					if (!plugin.isEnable()) {
						TUServer.getPluginManager().enablePlugin(plugin);
						sender.sendMessage(ChatColors.AQUA + plugin.getFileDescription().getName() + ChatColors.WHITE + " has been successful enabled!");
					} else {
						sender.sendMessage(ChatColors.AQUA + plugin.getFileDescription().getName() + ChatColors.WHITE + " is enabled");
					}
				} else {
					sender.sendMessage(ChatColors.RED + "Plugin not found!");
				}
			}
		} else {
			sender.sendMessage(ChatColors.RED + "You don't have permission.");
		}
	}

	@Override
	public String getCommandUsage(ICommandSender p_71518_1_) {
		return "/enable [pluginName]";
	}

}
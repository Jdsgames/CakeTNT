package dev.jdsgames.caketnt.commands;

import dev.jdsgames.caketnt.CakeTNT;
import dev.jdsgames.caketnt.data.Configuration;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CakeConfiguration implements CommandExecutor
{
    // Basic use of the command /caketntconfig
    private final Permission USE_CONFIGURATION = new Permission("dev.jdsgames.caketnt.config.use");
    // Use of the command /caketntconfig help - Display a help menu for the configuration
    private final Permission USE_CONFIGURATION_HELP = new Permission("dev.jdsgames.caketnt.config.use.help");
    // Use of the command /caketntconfig toggleplugin - Toggle's the enabled state of the plugin
    private final Permission SET_CONFIGURATION_IS_ENABLED = new Permission("dev.jdsgames.caketnt.config.set.isenabled");
    // Use of the command /caketntconfig toggleworld <world> - Toggle the enabled status of a world
    private final Permission SET_CONFIGURATION_IS_WORLD_ENABLED = new Permission("dev.jdsgames.caketnt.config.set.worldenabled");

    // Plugin Config
    Configuration pluginConfig;


    // Command Handler
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
    {
        // Plugin Configuration
        pluginConfig = CakeTNT.getCakeConfiguration();

        // If the command sender was a player
        if(sender instanceof Player)
        {
            Player sendingPlayer = (Player) sender;

            // If the player can use the configuration command
            if(!hasConfigurationPermission(sendingPlayer, USE_CONFIGURATION)) return false;

            switch(label)
            {
                case "toggleplugin":
                    toggleEnable(sendingPlayer);
                    break;
                case "toggleworld":
                    toggleWorld(sendingPlayer, args);
                    break;
                default:
                    displayHelpMenu(sendingPlayer);
                    break;
            }
        }

        return false;
    }

    // Check if the player has a particular permission if not let them know!
    private boolean hasConfigurationPermission(Player player, Permission permission)
    {
        if(player.hasPermission(permission))
            return true;

        player.sendMessage(ChatColor.RED + "You require permission: " + permission.getName());
        return false;
    }

    // Display Help Menu
    private void displayHelpMenu(Player player)
    {
        if(hasConfigurationPermission(player, USE_CONFIGURATION_HELP))
        {
            player.sendMessage(ChatColor.GOLD + "- - - - - Cake TNT - - - - - Configuration Menu - - - - -");
            player.sendMessage(ChatColor.GRAY + " /caketntconfig help: :: Display Help Menu to the Player ");
            player.sendMessage(ChatColor.GRAY + " /caketntconfig toggleplugin :: Toggle the Plugin On/Off ");
            player.sendMessage(ChatColor.GOLD + "- - - - - Cake TNT - - - - - Configuration Menu - - - - -");
        }
    }

    // Toggle Enabled Status
    private void toggleEnable(Player player)
    {
        if(hasConfigurationPermission(player, SET_CONFIGURATION_IS_ENABLED))
        {
            pluginConfig.toggleIsPluginEnabled();
        }
    }

    // Toggle World Status
    private void toggleWorld(Player player, String[] strings)
    {
        if(hasConfigurationPermission(player, SET_CONFIGURATION_IS_WORLD_ENABLED))
        {
            // TODO
        }
    }
}

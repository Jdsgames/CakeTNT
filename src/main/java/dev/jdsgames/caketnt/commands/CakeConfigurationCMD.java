package dev.jdsgames.caketnt.commands;

import dev.jdsgames.caketnt.CakeTNT;
import dev.jdsgames.caketnt.data.Configuration;
import dev.jdsgames.caketnt.utility.CakeUtility;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

public class CakeConfigurationCMD implements CommandExecutor
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
            if(!CakeUtility.hasPermissionWithError(sendingPlayer, USE_CONFIGURATION)) return false;

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

    // Display Help Menu
    private void displayHelpMenu(Player player)
    {
        if(CakeUtility.hasPermissionWithError(player, USE_CONFIGURATION_HELP))
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
        if(CakeUtility.hasPermissionWithError(player, SET_CONFIGURATION_IS_ENABLED))
        {
            pluginConfig.toggleIsPluginEnabled();
        }
    }

    // Toggle World Status
    private void toggleWorld(Player player, String[] strings)
    {
        if(CakeUtility.hasPermissionWithError(player, SET_CONFIGURATION_IS_WORLD_ENABLED))
        {
            World toggleWorld = Bukkit.getWorld(strings[0]);

            if(toggleWorld != null)
            {
                // Toggle World
                pluginConfig.toggleWorldEnabledStatus(toggleWorld);
                // Alert Player of Change
                player.sendMessage(ChatColor.GOLD + toggleWorld.getName() +
                                   ChatColor.GRAY + " has been toggled to: " + pluginConfig.getWorldEnabledStatus(toggleWorld));
                return;
            }
            else
                // Warn the user that the command failed due to a null world
                player.sendMessage(ChatColor.RED + strings[0] + " is not a valid World!");
        }

    }
}

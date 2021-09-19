package dev.jdsgames.caketnt.utility;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.permissions.Permission;

/* Functions Used by Multiple Classes */

public class CakeUtility
{
    // Determines if a player has a particular permission and will let them know if they need it.
    public static boolean hasPermissionWithError(Player player, Permission permission)
    {
        // If the player has the permission return true!
        if(player.hasPermission(permission))
            return true;

        // Player does not have permission, let them know and return false.
        player.sendMessage(ChatColor.RED + "You require permission: " + permission.getName());
        return false;
    }
}

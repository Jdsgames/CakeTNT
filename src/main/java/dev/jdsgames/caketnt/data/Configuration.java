package dev.jdsgames.caketnt.data;

import org.bukkit.World;

import java.util.HashMap;

public class Configuration
{
    // Configuration Instance
    private static Configuration configuration;

    // Is the plugin enabled?
    private boolean isPluginEnabled;

    // World List
    private HashMap<World, Boolean> worldList;

    // Constructor
    private Configuration()
    {
        // Set Default Values
        isPluginEnabled = true;
    }

    // Get Configuration Instance
    public static Configuration getConfiguration()
    {
        // Create configuration instance if it is not already created.
        if(configuration == null)
            configuration = new Configuration();

        return configuration;
    }

    // Is the Plugin Enabled?
    public boolean isPluginEnabled() { return isPluginEnabled; }

    // Toggle if the Plugin is Enabled
    public void toggleIsPluginEnabled() { isPluginEnabled = !isPluginEnabled; }

    // Get the Enabled World List
    public HashMap<World, Boolean> getWorldList() { return worldList; }

    // Set the Enabled World List
    public void setWorldList(HashMap<World, Boolean> worldList) { this.worldList = worldList;}

    // Get World Enabled Status
    public boolean getWorldEnabledStatus(World world)
    {
        if(worldList.containsKey(world))
        {
            return worldList.get(world);
        }

        return false;
    }

    // Toggle World Enabled Status
    public void toggleWorldEnabledStatus(World world)
    {
        if(worldList.containsKey(world))
            worldList.replace(world, !worldList.get(world));
    }
}

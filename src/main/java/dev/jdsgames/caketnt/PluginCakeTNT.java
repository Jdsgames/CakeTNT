package dev.jdsgames.caketnt;

import dev.jdsgames.caketnt.data.Configuration;
import org.bukkit.plugin.java.JavaPlugin;

public final class PluginCakeTNT extends JavaPlugin
{
    // Plugin Instance
    private static PluginCakeTNT pluginCakeTnt;

    // Configuration Instance
    private static Configuration cakeConfiguration;

    @Override
    public void onEnable()
    {
        // Get Plugin Instance
        pluginCakeTnt = this;

        // Get Cake Configuration
        cakeConfiguration = Configuration.getConfiguration();


        // Register Plugin Commands
        registerCommands();
        // Register Plugin Events
        registerEvents();
        // Register Plugin Tasks
        registerTasks();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    // Get Plugin Instance
    public static PluginCakeTNT getPluginInstance() { return pluginCakeTnt; }

    // Get Configuration Instance
    public static Configuration getCakeConfiguration() { return cakeConfiguration; }

    // Register Commands
    private void registerCommands()
    {

    }

    // Register Events
    private void registerEvents()
    {

    }

    // Register Tasks
    private void registerTasks()
    {

    }
}

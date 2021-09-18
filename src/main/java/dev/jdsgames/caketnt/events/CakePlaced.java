package dev.jdsgames.caketnt.events;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;

public class CakePlaced implements Listener
{
    @EventHandler
    public void playerPlacedCake(BlockPlaceEvent bpe)
    {
        Player placingPlayer = bpe.getPlayer();
    }
}

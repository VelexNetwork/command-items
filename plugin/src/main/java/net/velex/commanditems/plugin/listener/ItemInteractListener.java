package net.velex.commanditems.plugin.listener;

import com.google.common.base.Preconditions;
import net.velex.commanditems.api.model.ActionManagerModel;
import net.velex.commanditems.api.model.ItemManagerModel;
import net.velex.commanditems.api.model.config.ConfModel;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class ItemInteractListener implements Listener {
  private final Map<String, ConfModel.Item> items;
  private final ItemManagerModel itemManager;
  private final ActionManagerModel actionManager;
  
  public ItemInteractListener(
    final @NotNull Map<String, ConfModel.Item> items,
    final @NotNull ItemManagerModel itemManager,
    final @NotNull ActionManagerModel actionManager
  ) {
    this.items = Preconditions.checkNotNull(items, "Items map data cannot be null.");
    this.itemManager = Preconditions.checkNotNull(itemManager, "ItemManagerModel reference cannot be null.");
    this.actionManager = Preconditions.checkNotNull(actionManager, "ActionManagerModel reference cannot be null.");
  }
  
  @EventHandler (priority = EventPriority.LOW, ignoreCancelled = true)
  public void onItemInteract(final PlayerInteractEvent event) {
  
  }
}

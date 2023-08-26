package net.velex.commanditems.plugin;

import net.kyori.adventure.text.minimessage.tag.resolver.Placeholder;
import net.velex.commanditems.api.CommandItems;
import net.velex.commanditems.api.Provider;
import net.velex.commanditems.api.model.ActionManagerModel;
import net.velex.commanditems.api.model.ConfManagerModel;
import net.velex.commanditems.api.model.ItemManagerModel;
import net.velex.commanditems.plugin.impl.ActionManagerModelImpl;
import net.velex.commanditems.plugin.impl.ItemManagerModelImpl;
import net.velex.commanditems.plugin.impl.SimpleConfManagerImpl;
import net.velex.commanditems.plugin.utils.LoggerUtils;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public final class CommandItemsPlugin extends JavaPlugin implements CommandItems {
  private ConfManagerModel confManager;
  private ActionManagerModel actionManager;
  private ItemManagerModel itemManager;
  
  @Override
  public @NotNull ConfManagerModel confManager() {
    return confManager;
  }
  
  @Override
  public @NotNull ActionManagerModel actionManager() {
    return actionManager;
  }
  
  @Override
  public @NotNull ItemManagerModel itemManager() {
    return itemManager;
  }
  
  @Override
  public void onLoad() {
    LoggerUtils.sendInfo("<gradient:blue:aqua>[CommandItems]</gradient> Enabling plugin internal components...");
    
    Provider.load(this);
    
    LoggerUtils.sendInfo("<gradient:blue:aqua>[CommandItems]</gradient> <gradient:green:blue>Loading configuration models.");
    confManager = new SimpleConfManagerImpl(getDataFolder().toPath());
    if (!confManager.load()) {
      LoggerUtils.sendError("<gradient:blue:aqua>[CommandItems]</gradient> The configuration could not be loaded correctly.");
      setEnabled(false);
      return;
    }
    
    actionManager = new ActionManagerModelImpl();
    itemManager = new ItemManagerModelImpl();
  }
  
  @Override
  public void onEnable() {
    LoggerUtils.sendInfo("<gradient:blue:aqua>[CommandItems]</gradient> <gradient:green:blue>Loading item models from configuration.");
    
    confManager.config()
      .items()
      .forEach(itemManager::addItemModel);
    
    LoggerUtils.sendInfo("<gradient:blue:aqua>[CommandItems]</gradient> Plugin enabled correctly.");
    LoggerUtils.sendInfo("<gradient:blue:aqua>[CommandItems]</gradient> Running on version <gradient:aqua:green><version>", Placeholder.parsed("version", Constants.VERSION));
  }
  
  @Override
  public void onDisable() {
    Provider.unload();
    
    if (confManager != null) {
      confManager = null;
    }
    
    if (actionManager != null) {
      actionManager.clear();
      actionManager = null;
    }
    
    if (itemManager != null) {
      itemManager.clear();
      itemManager = null;
    }
  }
}

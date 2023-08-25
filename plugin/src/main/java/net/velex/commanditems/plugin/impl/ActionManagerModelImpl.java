package net.velex.commanditems.plugin.impl;

import net.velex.commanditems.api.model.ActionManagerModel;
import net.velex.commanditems.api.model.action.AbstractActionModel;
import org.apache.commons.lang3.StringUtils;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ActionManagerModelImpl implements ActionManagerModel {
  private final Map<String, AbstractActionModel> cache;
  
  public ActionManagerModelImpl() {
    cache = new HashMap<>();
  }
  
  @Override
  public @Nullable AbstractActionModel findOrNull(final @NotNull String id) {
    return cache.get(id);
  }
  
  @Override
  public void register(final @NotNull String id, final @NotNull AbstractActionModel model) {
    if (cache.get(id) != null) return;
    
    cache.put(id, model);
  }
  
  @Override
  public void unregister(final @NotNull String id) {
    if (cache.get(id) == null) return;
    
    cache.remove(id);
  }
  
  @Override
  public void perform(final @NotNull Player player, final @NotNull String content) {
    final var identifierBetweenBraces = StringUtils.substringBetween(content, "[", "]").toLowerCase();
    final var action = cache.get(identifierBetweenBraces);
    
    // Checks if there are a model with that identifier.
    if (action != null) {
      action.perform(player, content);
    }
  }
  
  @Override
  public void clear() {
    cache.clear();
  }
}

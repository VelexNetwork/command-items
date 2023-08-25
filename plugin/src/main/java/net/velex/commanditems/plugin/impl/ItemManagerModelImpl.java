package net.velex.commanditems.plugin.impl;

import net.velex.commanditems.api.model.ItemManagerModel;
import net.velex.commanditems.api.model.config.ConfModel;
import net.velex.commanditems.api.model.item.CachedItemModel;
import net.velex.commanditems.plugin.utils.ComponentUtils;
import net.velex.commanditems.plugin.utils.item.ItemBuilder;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.HashMap;
import java.util.Map;

public class ItemManagerModelImpl implements ItemManagerModel {
  private final Map<String, CachedItemModel> cache;
  
  public ItemManagerModelImpl() {
    cache = new HashMap<>();
  }
  
  @Override
  public @Nullable CachedItemModel findOrNull(final @NotNull String id) {
    return cache.get(id);
  }
  
  @Override
  public void addItemModel(final @NotNull String id, final @NotNull ConfModel.Item itemData) {
    // Gets some parameters from configuration.
    final var glow = itemData.useGlow();
    final var skullName = itemData.skull();
    final var unbreakable = itemData.isUnbreakable();
    final var damage = itemData.damage();
    
    // Stores the new model into memory cache.
    cache.put(id, CachedItemModel.of(
      ItemBuilder.of(itemData.type())
        .displayName(ComponentUtils.parse(itemData.name()))
        .lore(ComponentUtils.parse(itemData.lore()))
        .damage(damage)
        .glow(glow)
        .unbreakable(unbreakable)
        .skullName(skullName)
        .build(),
      glow, skullName, unbreakable,
      itemData.damage(), itemData.isConsumed(), itemData.isSneaking(),
      itemData.fixedHeight(), itemData.randomOffset(), itemData.actions()
    ));
  }
  
  @Override
  public void removeItemModel(final @NotNull String id) {
    cache.remove(id);
  }
  
  @Override
  public void clear() {
    cache.clear();
  }
}

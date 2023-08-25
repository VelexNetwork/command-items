package net.velex.commanditems.api.model;

import net.velex.commanditems.api.model.config.ConfModel;
import net.velex.commanditems.api.model.item.CachedItemModel;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface ItemManagerModel {
  /**
   * Tries to get a model for the id given. If the model doesn't exist will return null.
   *
   * @param id ID of the model.
   *
   * @return A {@code CachedItemModel} object or null.
   */
  @Nullable CachedItemModel findOrNull(final @NotNull String id);
  
  /**
   * Store a {@code CachedItemModel} object with the data given.
   *
   * @param id ID for the model.
   * @param itemData Data parameters for the model.
   */
  void addItemModel(final @NotNull String id, final @NotNull ConfModel.Item itemData);
  
  /**
   * Removes a {@code CachedItemModel} object with that id.
   *
   * @param id ID of the model.
   */
  void removeItemModel(final @NotNull String id);
  
  void clear();
}

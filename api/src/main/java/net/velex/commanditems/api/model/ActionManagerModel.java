package net.velex.commanditems.api.model;

import net.velex.commanditems.api.model.action.AbstractActionModel;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public interface ActionManagerModel {
  /**
   * Tries to find a {@code AbstractActionModel} object for that id. If there are one, will be return.
   *
   * @param id ID for the model.
   *
   * @return A {@code AbstractActionModel} object or null if there aren't one with these id.
   */
  @Nullable AbstractActionModel findOrNull(final @NotNull String id);
  
  /**
   * Register a new model into the plugin cache.
   *
   * @param id ID for this model.
   * @param model {@code AbstractActionModel} implementation of model.
   */
  void register(final @NotNull String id, final @NotNull AbstractActionModel model);
  
  /**
   * Unregister the model from plugin cache.
   *
   * @param id ID of the model.
   */
  void unregister(final @NotNull String id);
  
  /**
   * Performs the action in the text string.
   *
   * @param player {@code Player} who executed the action.
   * @param content Content of this action.
   */
  void perform(final @NotNull Player player, final @NotNull String content);
  
  /**
   * Performs the actions in the text list.
   *
   * @param player {@code Player} who executed the actions.
   * @param content {@code List} object that contains the actions.
   */
  default void perform(final @NotNull Player player, final @NotNull List<String> content) {
    for (final var str : content) {
      perform(player, str);
    }
  }
  
  void clear();
}

package net.velex.commanditems.api;

import net.velex.commanditems.api.model.ActionManagerModel;
import net.velex.commanditems.api.model.ConfManagerModel;
import net.velex.commanditems.api.model.ItemManagerModel;
import org.jetbrains.annotations.NotNull;

public interface CommandItems {
  /**
   * Returns the current {@code ConfManagerModel} object reference.
   *
   * @return A {@code ConfManagerModel} object.
   */
  @NotNull ConfManagerModel confManager();
  
  /**
   * Returns the current {@code ActionManagerModel} object reference.
   *
   * @return A {@code ActionManagerModel} object.
   */
  @NotNull ActionManagerModel actionManager();
  
  /**
   * Returns the current {@code ItemManagerModel} object reference.
   *
   * @return A {@code ItemManagerModel} object.
   */
  @NotNull ItemManagerModel itemManager();
}

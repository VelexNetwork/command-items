package net.velex.commanditems.api.model;

import net.velex.commanditems.api.model.config.ConfModel;
import net.velex.commanditems.api.model.config.MessagesModel;
import org.jetbrains.annotations.NotNull;

public interface ConfManagerModel {
  boolean load();
  
  /**
   * Returns the model for the configuration file.
   *
   * @return A {@code ConfModel} object.
   */
  @NotNull ConfModel config();
  
  /**
   * Returns the model for the messages file.
   *
   * @return A {@code MessagesModel} object.
   */
  @NotNull MessagesModel messages();
}

package net.velex.commanditems.api.model.action;

import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public abstract class AbstractActionModel {
  public abstract @NotNull String identifier();
  
  public abstract void perform(final @NotNull Player player, final @NotNull String content);
}

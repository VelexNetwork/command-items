package net.velex.commanditems.plugin.utils.item;

import net.velex.commanditems.plugin.utils.ItemBuilderUtils;
import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

public interface ItemBuilder {
  @Contract(value = "_ -> new", pure = true)
  static @NotNull ItemBuilderUtils of(final @NotNull String material) {
    return new ItemBuilderUtils(material);
  }
}

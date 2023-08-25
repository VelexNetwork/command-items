package net.velex.commanditems.plugin.utils;

import net.kyori.adventure.text.logger.slf4j.ComponentLogger;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.velex.commanditems.plugin.CommandItemsPlugin;
import org.jetbrains.annotations.NotNull;

public class LoggerUtils {
  private static final ComponentLogger LOGGER = CommandItemsPlugin.getPlugin(CommandItemsPlugin.class).getComponentLogger();
  
  public static void sendInfo(final @NotNull String content, final TagResolver @NotNull... resolvers) {
    LOGGER.info(ComponentUtils.parse(content, resolvers));
  }
  
  public static void sendWarn(final @NotNull String content, final TagResolver @NotNull... resolvers) {
    LOGGER.warn(ComponentUtils.parse(content, resolvers));
  }
  
  public static void sendError(final @NotNull String content, final TagResolver @NotNull... resolvers) {
    LOGGER.error(ComponentUtils.parse(content, resolvers));
  }
}

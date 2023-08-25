package net.velex.commanditems.plugin.utils;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.kyori.adventure.text.minimessage.tag.resolver.TagResolver;
import net.kyori.adventure.text.serializer.legacy.LegacyComponentSerializer;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ComponentUtils {
  private static final MiniMessage MINI_MESSAGE = MiniMessage.miniMessage();
  private static final LegacyComponentSerializer LEGACY_COMPONENT_SERIALIZER = LegacyComponentSerializer.legacyAmpersand();
  
  public static @NotNull Component parse(final @NotNull String content) {
    return MINI_MESSAGE.deserialize(content);
  }
  
  public static @NotNull Component parse(final @NotNull String content, final TagResolver @NotNull... resolvers) {
    return MINI_MESSAGE.deserialize(content, resolvers);
  }
  
  public static @NotNull List<Component> parse(final @NotNull List<String> content) {
    final var list = new ArrayList<Component>();
    
    for (final var str : content) {
      list.add(parse(str));
    }
    
    return list;
  }
  
  public static @NotNull String serialize(final @NotNull Component component) {
    return LEGACY_COMPONENT_SERIALIZER.serialize(component);
  }
}

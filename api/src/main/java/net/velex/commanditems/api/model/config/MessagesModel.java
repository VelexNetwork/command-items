package net.velex.commanditems.api.model.config;

import org.jetbrains.annotations.NotNull;
import space.arim.dazzleconf.annote.*;
import space.arim.dazzleconf.serialiser.URLValueSerialiser;
import space.arim.dazzleconf.sorter.AnnotationBasedSorter;

import java.util.List;

@ConfSerialisers(URLValueSerialiser.class)
@ConfHeader({
  "CommandItems | Messages Configuration",
  "Customize the plugin messages, you can use the MiniMessage format for create unique message formats."
})
public interface MessagesModel {
  @AnnotationBasedSorter.Order(10)
  @ConfKey("messages.requires-permission")
  @ConfComments("This message use when a command is executed without permission.")
  @ConfDefault.DefaultString("<prefix> <red>You can't use this command without permission!")
  @NotNull String requiresPermission();
  
  @AnnotationBasedSorter.Order(20)
  @ConfKey("messages.unknown-sub-command")
  @ConfComments("This message use when specify an invalid sub-command.")
  @ConfDefault.DefaultString("<prefix> <red>That sub-command has not been added yet!")
  @NotNull String unknownSubCommand();
  
  @AnnotationBasedSorter.Order(30)
  @ConfKey("messages.unknown-sub-command")
  @ConfComments("This message use when execute the '/ci help' command.")
  @ConfDefault.DefaultString("<prefix> <red>That sub-command has not been added yet!")
  @NotNull List<String> help();
  
  @AnnotationBasedSorter.Order(40)
  @ConfKey("messages.item-disabled")
  @ConfComments("This message use when use a deactivated item.")
  @ConfDefault.DefaultString("<prefix> <red>This item is not activated in the configuration!")
  @NotNull String itemDisabled();
  
  @AnnotationBasedSorter.Order(50)
  @ConfKey("messages.item-interval")
  @ConfComments("This message use when try to use an item before ends their reload time.")
  @ConfDefault.DefaultString("<prefix> <gradient:gold:yellow>This item could be used in <time> seconds!")
  @NotNull String itemInterval();
  
  @AnnotationBasedSorter.Order(60)
  @ConfKey("messages.item-internal-error")
  @ConfComments("This message use when happens an error to interact with the item.")
  @ConfDefault.DefaultString("<prefix> <red>Has happened an error to interact with this item.")
  @NotNull String itemInternalError();
}

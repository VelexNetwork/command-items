package net.velex.commanditems.api.model.config;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Unmodifiable;
import space.arim.dazzleconf.annote.*;
import space.arim.dazzleconf.serialiser.URLValueSerialiser;
import space.arim.dazzleconf.sorter.AnnotationBasedSorter;

import java.util.List;
import java.util.Map;

@ConfSerialisers(URLValueSerialiser.class)
@ConfHeader({
  "CommandItems | Fork by Qekly",
  "Customize the items with multiple attributes, settings and more."
})
public interface ConfModel {
  @SuppressWarnings("unused")
  static @NotNull @Unmodifiable Map<String, Item> defaultItems() {
    return Map.of("fly", Item.of(
      "FEATHER",
      "<gradient:green:blue><bold>Flight Token",
      List.of("<aqua>Click for 10 seconds of flight!", "Random second line"),
      false,
      "unknown",
      true,
      0,
      false, false,
      0, 0, 0,
      List.of()
    ));
  }
  
  @AnnotationBasedSorter.Order(10)
  @ConfKey("config.prefix")
  @ConfComments({
    "Format for the plugin messages.",
    "To show the prefix, use the '<prefix>' placeholder."
  })
  @ConfDefault.DefaultString("<gradient:blue:aqua>[CommandItems]</gradient> <dark_gray>|</dark_gray>")
  @NotNull String prefix();
 
  @AnnotationBasedSorter.Order(20)
  @ConfKey("config.items")
  @ConfComments("Configure which items you want to add.")
  @ConfDefault.DefaultObject("defaultItems")
  @NotNull Map<String, Item> items();
  
  interface Item {
    @ConfComments("The material type of the item.")
    @NotNull String type();
    
    @ConfComments("The name to display for this item.")
    @NotNull String name();
    
    @ConfComments("The lore to display for this item.")
    @NotNull List<String> lore();
    
    @ConfComments("Do you want to use the glow effect for this item?")
    boolean useGlow();
    
    @ConfComments({
      "Do you want to use a skull for this item?",
      "If you don't want to use a skull, type 'unknown'."
    })
    @NotNull String skull();
    
    @ConfComments("Do you want to make the item unbreakable?")
    boolean isUnbreakable();
    
    @ConfComments("The damage amount inflicted by this item.")
    int damage();
    
    boolean isConsumed();
    
    boolean isSneaking();
    
    int fixedHeight();
    
    int randomOffset();
    
    @ConfComments("Actions to execute when interacts with the item.")
    @NotNull List<String> actions();
    
    static @NotNull Item of(
      final @NotNull String type,
      final @NotNull String name,
      final @NotNull List<String> lore,
      final boolean glow,
      final @NotNull String skull,
      final boolean unbreakable,
      final int damage,
      final boolean consumed,
      final boolean sneaking,
      final int fixedHeight,
      final int randomOffset,
      final @NotNull List<String> actions
    ) {
      return new Item() {
        @Override
        public @NotNull String type() {
          return type;
        }
        
        @Override
        public @NotNull String name() {
          return name;
        }
        
        @Override
        public @NotNull List<String> lore() {
          return lore;
        }
        
        @Override
        public boolean useGlow() {
          return glow;
        }
        
        @Override
        public @NotNull String skull() {
          return skull;
        }
        
        @Override
        public boolean isUnbreakable() {
          return unbreakable;
        }
        
        @Override
        public int damage() {
          return damage;
        }
        
        @Override
        public boolean isConsumed() {
          return consumed;
        }
        
        @Override
        public boolean isSneaking() {
          return sneaking;
        }
        
        @Override
        public int fixedHeight() {
          return fixedHeight;
        }
        
        @Override
        public int randomOffset() {
          return randomOffset;
        }
        
        @Override
        public @NotNull List<String> actions() {
          return actions;
        }
      };
    }
  }
}

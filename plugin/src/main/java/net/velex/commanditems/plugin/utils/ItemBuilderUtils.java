package net.velex.commanditems.plugin.utils;

import com.google.common.base.Preconditions;
import net.kyori.adventure.text.Component;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Map;

public class ItemBuilderUtils {
  private final String material;
  
  private int amount;
  private Component displayName;
  private List<Component> lore;
  private boolean glow;
  private int damage;
  private boolean unbreakable;
  private String skullName;
  
  public ItemBuilderUtils(final @NotNull String material) {
    this.material = Preconditions.checkNotNull(material, "Material type cannot be null for the ItemBuilder.");
  }
  
  public @NotNull ItemBuilderUtils amount(final int amount) {
    this.amount = amount;
    return this;
  }
  
  public @NotNull ItemBuilderUtils displayName(final @NotNull Component displayName) {
    this.displayName = Preconditions.checkNotNull(displayName, "Display name component for the item cannot be null.");
    return this;
  }
  
  public @NotNull ItemBuilderUtils lore(final @NotNull List<Component> lore) {
    this.lore = Preconditions.checkNotNull(lore, "Lore for the item cannot be null.");
    return this;
  }
  
  public @NotNull ItemBuilderUtils glow(final boolean addGlow) {
    glow = addGlow;
    return this;
  }
  
  public @NotNull ItemBuilderUtils damage(final int damage) {
    this.damage = damage;
    return this;
  }
  
  public @NotNull ItemBuilderUtils unbreakable(final boolean makeUnbreakable) {
    unbreakable = makeUnbreakable;
    return this;
  }
  
  public @NotNull ItemBuilderUtils skullName(final @NotNull String skullName) {
    this.skullName =  Preconditions.checkNotNull(skullName, "Skull name for the item cannot be null.");
    return this;
  }
  
  public @NotNull ItemStack build() {
    Material bukkitMaterial = Material.getMaterial(material);
    
    // Checks if the material name specified isn't valid.
    if (bukkitMaterial == null) {
      bukkitMaterial = Material.STONE;
    }
    
    // Checks if the amount for this item were established.
    if (amount <= 0) {
      amount = 1;
    }
    
    // Checks if the name or the lore were established for this item.
    if ((displayName == null) || (lore == null)) {
      throw new IllegalArgumentException("Display name or lore for the item has not been established for the ItemBuilder.");
    }
    
    final var item = new ItemStack(bukkitMaterial, amount);
    // Checks if the glow effect is activated, then add this enchantment to the item.
    if (glow) {
      item.addEnchantment(Enchantment.SWEEPING_EDGE, 1);
    }
    
    item.editMeta(meta -> {
      meta.displayName(displayName);
      meta.lore(lore);
      meta.setUnbreakable(unbreakable);
      meta.addItemFlags(ItemFlag.values());
      
      // Checks if the name established for the skull is distinct to 'unknown'.
      if (!skullName.equals("unknown")) {
      
      }
      
      item.setItemMeta(meta);
    });
    
    return item;
  }
}

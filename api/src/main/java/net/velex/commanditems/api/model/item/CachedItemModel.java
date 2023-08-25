package net.velex.commanditems.api.model.item;

import com.google.common.base.Preconditions;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class CachedItemModel {
  private final ItemStack item;
  private final boolean glow;
  private final String skullName;
  private final boolean unbreakable;
  private final int damage;
  private final boolean consumed;
  private final boolean sneaking;
  private final int fixedHeight;
  private final int randomOffset;
  private final List<String> actions;
  
  private CachedItemModel(
    final @NotNull ItemStack item,
    final boolean glow,
    final @NotNull String skullName,
    final boolean unbreakable,
    final int damage,
    final boolean consumed,
    final boolean sneaking,
    final int fixedHeight,
    final int randomOffset,
    final @NotNull List<String> actions
  ) {
    this.item = Preconditions.checkNotNull(item, "ItemStack reference for this item cannot be null.");
    this.glow = glow;
    this.skullName = Preconditions.checkNotNull(skullName, "SkullName for this item cannot be null.");
    this.unbreakable = unbreakable;
    this.damage = damage;
    this.consumed = consumed;
    this.sneaking = sneaking;
    this.fixedHeight = fixedHeight;
    this.randomOffset = randomOffset;
    this.actions = Preconditions.checkNotNull(actions, "Actions list for this item cannot be null.");
  }
  
  public static @NotNull CachedItemModel of(
    final @NotNull ItemStack item,
    final boolean glow,
    final @NotNull String skullName,
    final boolean unbreakable,
    final int damage,
    final boolean consumed,
    final boolean sneaking,
    final int fixedHeight,
    final int randomOffset,
    final @NotNull List<String> actions
  ) {
    return new CachedItemModel(
      item,
      glow, skullName, unbreakable,
      damage, consumed, sneaking,
      fixedHeight, randomOffset, actions
    );
  }
  
  public @NotNull ItemStack item() {
    return item;
  }
  
  public boolean hasGlowEffect() {
    return glow;
  }
  
  public @NotNull String skullName() {
    return skullName;
  }
  
  public boolean isUnbreakable() {
    return unbreakable;
  }
  
  public int damage() {
    return damage;
  }
  
  public boolean isConsumed() {
    return consumed;
  }
  
  public boolean isSneaking() {
    return sneaking;
  }
  
  public int fixedHeight() {
    return fixedHeight;
  }
  
  public int randomOffset() {
    return randomOffset;
  }
  
  public @NotNull List<String> actions() {
    return actions;
  }
}

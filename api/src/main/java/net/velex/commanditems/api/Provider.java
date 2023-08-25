package net.velex.commanditems.api;

import com.google.common.base.Preconditions;
import org.jetbrains.annotations.NotNull;

public class Provider {
  private static CommandItems instance;
  
  /**
   * Returns the current reference for the {@code CommandItems} instance. If the reference is null<p>
   * will throw an {@code IllegalStateException} exception.
   *
   * @return A {@code CommandItems} reference.
   */
  public static @NotNull CommandItems get() {
    // The instance were loaded?
    if (instance == null) {
      throw new IllegalStateException("CommandItems API reference can't be got due wasn't loaded.");
    }
    
    return instance;
  }
  
  /**
   * Sets the reference given to the current instance.
   *
   * @param reference New API reference for set.
   */
  public static void load(final @NotNull CommandItems reference) {
    // The instance has already a reference?
    if (instance != null) {
      throw new IllegalStateException("CommandItems API is already referenced.");
    }
    
    instance = Preconditions.checkNotNull(reference, "CommandItems API reference cannot be null.");
  }
  
  /**
   * Sets null for the API reference.
   */
  public static void unload() {
    instance = null;
  }
}

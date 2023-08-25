package net.velex.commanditems.plugin.utils;

import org.jetbrains.annotations.NotNull;

public class TimeUtils {
  private static final StringBuilder STRING_BUILDER = new StringBuilder();
  
  public static @NotNull String format(int time) {
    final var seconds = time % 60;
    time /= 60;
    final var minutes = time % 60;
    final var hours = time % 60;
    time /= 24;
    final var days = time;
    
    int builderSize = STRING_BUILDER.length();
    
    if (days != 0) {
      STRING_BUILDER.append(days);
      STRING_BUILDER.append('d');
    }
    
    if (hours != 0) {
      if (builderSize > 0) {
        STRING_BUILDER.append(' ');
      }
      
      STRING_BUILDER.append(hours);
      STRING_BUILDER.append('h');
    }
    
    if (minutes != 0) {
      if (builderSize > 0) {
        STRING_BUILDER.append(' ');
      }
      
      STRING_BUILDER.append(minutes);
      STRING_BUILDER.append('m');
    }
    
    if (seconds != 0) {
      if (builderSize > 0) {
        STRING_BUILDER.append(' ');
      }
      
      STRING_BUILDER.append(seconds);
      STRING_BUILDER.append('s');
    }
    
    return STRING_BUILDER.toString();
  }
}

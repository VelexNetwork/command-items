package net.velex.commanditems.plugin.impl;

import net.velex.commanditems.api.model.ConfManagerModel;
import net.velex.commanditems.api.model.config.ConfModel;
import net.velex.commanditems.api.model.config.MessagesModel;
import org.jetbrains.annotations.NotNull;
import space.arim.dazzleconf.ConfigurationOptions;
import space.arim.dazzleconf.error.InvalidConfigException;
import space.arim.dazzleconf.ext.snakeyaml.CommentMode;
import space.arim.dazzleconf.ext.snakeyaml.SnakeYamlConfigurationFactory;
import space.arim.dazzleconf.ext.snakeyaml.SnakeYamlOptions;
import space.arim.dazzleconf.helper.ConfigurationHelper;
import space.arim.dazzleconf.sorter.AnnotationBasedSorter;

import java.io.IOException;
import java.nio.file.Path;

public class SimpleConfManagerImpl implements ConfManagerModel {
  private final ConfigurationHelper<ConfModel> confHelper;
  private final ConfigurationHelper<MessagesModel> messagesHelper;
  
  private ConfModel confModel;
  private MessagesModel messagesModel;
  
  public SimpleConfManagerImpl(final @NotNull Path dataFolder) {
    final var sorter = new ConfigurationOptions.Builder()
      .sorter(new AnnotationBasedSorter())
      .build();
    final var commentMode = new SnakeYamlOptions.Builder()
      .commentMode(CommentMode.fullComments())
      .build();
    
    confHelper = new ConfigurationHelper<>(dataFolder, "config.yml", SnakeYamlConfigurationFactory.create(ConfModel.class, sorter, commentMode));
    messagesHelper = new ConfigurationHelper<>(dataFolder, "messages.yml", SnakeYamlConfigurationFactory.create(MessagesModel.class, sorter, commentMode));
  }
  
  @Override
  public boolean load() {
    try {
      confModel = confHelper.reloadConfigData();
      messagesModel = messagesHelper.reloadConfigData();
    } catch (final IOException | InvalidConfigException exception) {
      exception.printStackTrace();
      return false;
    }
    
    return true;
  }
  
  @Override
  public @NotNull ConfModel config() {
    if (confModel == null) {
      throw new IllegalStateException("ConfModel reference could not be got because is null.");
    }
    
    return confModel;
  }
  
  @Override
  public @NotNull MessagesModel messages() {
    if (messagesModel == null) {
      throw new IllegalStateException("MessagesModel reference could not be got because is null.");
    }
    
    return messagesModel;
  }
}

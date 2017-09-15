package com.pgms.tw;

/**
 * Given a configuration file, produces a {@link ConfigurationReader} that allows consumers
 * to interact with the configuration values specified in that file.
 *
 * Supports overrides - an ordered list of preferences for configuration keys that have been
 * specified with multiple overrides.
 */
public interface ConfigurationParser {
  /**
   * @return a {@link ConfigurationReader} that returns values ignoring any overrides
   */
  ConfigurationReader getConfig();

  /**
   * @param overrides
   * @return a {@link ConfigurationReader} that returns values by giving preferences to those
   * specified in the overrides list - where the order of the overrides is respected.
   */
  ConfigurationReader getConfig(String... overrides);
}

package com.github.sormuras.bach.javafx;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.Test;

class SystemInfoTests {

  @Test
  void javaVersionIsNotBlank() {
    assertFalse(SystemInfo.javaVersion().isBlank());
  }

  @Test
  void javafxVersionIsNull() {
    assertNull(SystemInfo.javafxVersion());
  }

  @Test
  void runningOnTheModulePath() {
    assertEquals("com.github.sormuras.bach.javafx", getClass().getModule().getName());
  }
}

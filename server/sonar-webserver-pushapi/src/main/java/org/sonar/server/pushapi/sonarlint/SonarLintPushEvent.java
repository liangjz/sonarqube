/*
 * SonarQube
 * Copyright (C) 2009-2022 SonarSource SA
 * mailto:info AT sonarsource DOT com
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this program; if not, write to the Free Software Foundation,
 * Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02110-1301, USA.
 */
package org.sonar.server.pushapi.sonarlint;

import static java.nio.charset.StandardCharsets.UTF_8;

public class SonarLintPushEvent {

  private final String name;
  private final byte[] data;
  private final String projectKey;

  public SonarLintPushEvent(String name, byte[] data, String projectKey) {
    this.name = name;
    this.data = data;
    this.projectKey = projectKey;
  }

  public String getProjectKey() {
    return projectKey;
  }

  public String getName() {
    return name;
  }

  public byte[] getData() {
    return data;
  }

  public String serialize() {
    return "event: " + this.name + "\n"
      + "data: " + new String(this.data, UTF_8);
  }

}

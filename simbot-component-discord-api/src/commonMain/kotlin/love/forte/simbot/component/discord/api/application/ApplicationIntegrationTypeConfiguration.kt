/*
 * Copyright (c) 2026. ForteScarlet.
 *
 * This file is part of simbot-component-discord.
 *
 * simbot-component-discord is free software: you can redistribute it and/or modify it under the terms
 * of the GNU Lesser General Public License as published by the Free Software Foundation,
 * either version 3 of the License, or (at your option) any later version.
 *
 * simbot-component-discord is distributed in the hope that it will be useful, but WITHOUT ANY WARRANTY;
 * without even the implied warranty of MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.
 * See the GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with simbot-component-discord.
 * If not, see <https://www.gnu.org/licenses/>.
 */

package love.forte.simbot.component.discord.api.application

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

/**
 * [Application Integration Type Configuration Object](https://docs.discord.com/developers/resources/application#application-integration-type-configuration-object).
 *
 * Represents the configuration for one application installation context.
 *
 * It provides the default OAuth2 installation parameters for that context.
 *
 * @property oauth2InstallParams Default install-link parameters, when configured.
 *
 * @see Application
 */
@Serializable
public class ApplicationIntegrationTypeConfiguration internal constructor(
    @SerialName("oauth2_install_params")
    public val oauth2InstallParams: InstallParams? = null,
) {
    override fun toString(): String =
        "ApplicationIntegrationTypeConfiguration(" +
            "oauth2InstallParams=$oauth2InstallParams)"
}

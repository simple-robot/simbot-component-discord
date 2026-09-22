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

import kotlinx.serialization.Serializable

/**
 * [Install Params Structure](https://discord.com/developers/docs/resources/application#install-params-object-install-params-structure)
 *
 * Contains the OAuth2 scopes and bot permissions used by an install link.
 *
 * @property scopes Scopes to add the application to the server with
 * @property permissions Permissions to request for the bot role
 *
 * @author ForteScarlet
 */
@Serializable
public class InstallParams internal constructor(
    public val scopes: List<String> = emptyList(),
    public val permissions: String,
) {
    override fun toString(): String =
        "InstallParams(scopes=$scopes, permissions=$permissions)"
}

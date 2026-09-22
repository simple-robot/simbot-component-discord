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

package love.forte.simbot.component.discord.model.channel

import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.permission.Permissions
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Overwrite Object](https://docs.discord.com/developers/resources/channel#overwrite-object).
 *
 * Defines the permissions explicitly allowed or denied for a role or member.
 *
 * @property id The Discord ID of the role or member affected by the overwrite.
 * @property type Whether the overwrite targets a role or member.
 * @property allow The permissions explicitly allowed by this overwrite.
 * @property deny The permissions explicitly denied by this overwrite.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class PermissionOverwrite internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    @get:JvmExposeBoxed
    public val type: PermissionOverwriteType,
    public val allow: Permissions,
    public val deny: Permissions,
) {
    override fun toString(): String =
        "PermissionOverwrite(id=$id, type=$type, allow=$allow, deny=$deny)"
}


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

package love.forte.simbot.component.discord.model.guild

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.permission.Permissions
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Role Object](https://docs.discord.com/developers/topics/permissions#role-object).
 *
 * Represents a named guild permission group. The everyone role has the same ID
 * as its guild, and role hierarchy is determined by position and ID.
 *
 * @property id The role ID.
 * @property name The role name.
 * @property color The deprecated integer primary color.
 * @property colors The role's primary and optional enhanced colors.
 * @property hoist Whether the role is shown separately in the member list.
 * @property icon The role icon hash.
 * @property unicodeEmoji The role's Unicode emoji.
 * @property position The role position within the guild hierarchy.
 * @property permissions The role's permission bit field.
 * @property managed Whether the role is managed by an integration.
 * @property mentionable Whether members can mention this role.
 * @property tags The role's integration or subscription metadata.
 * @property flags Additional role capability flags.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Role internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    public val color: Int,
    public val colors: RoleColors,
    public val hoist: Boolean,
    public val icon: String? = null,
    @SerialName("unicode_emoji")
    public val unicodeEmoji: String? = null,
    public val position: Int,
    @get:JvmExposeBoxed
    public val permissions: Permissions,
    public val managed: Boolean,
    public val mentionable: Boolean,
    public val tags: RoleTags? = null,
    @get:JvmExposeBoxed
    public val flags: RoleFlags,
) {
    override fun toString(): String =
        "Role(id=$id, name=$name, position=$position)"
}

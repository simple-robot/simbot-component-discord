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

import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.user.User

/**
 * [Ban Object](https://docs.discord.com/developers/resources/guild#ban-object).
 *
 * Represents a user banned from a guild and the optional reason recorded for
 * that ban.
 *
 * @property reason The reason for the ban.
 * @property user The banned user.
 */
@Serializable
public class Ban internal constructor(
    public val reason: String?,
    public val user: User,
) {
    override fun toString(): String = "Ban(user=${user.id}, reason=$reason)"
}

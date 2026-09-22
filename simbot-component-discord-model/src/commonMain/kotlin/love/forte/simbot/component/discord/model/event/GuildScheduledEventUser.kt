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

package love.forte.simbot.component.discord.model.event

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.guild.GuildMember
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Guild Scheduled Event User Object](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-user-object).
 *
 * Represents a user subscribed to a guild scheduled event.
 *
 * @property guildScheduledEventId The subscribed scheduled event ID.
 * @property user The subscribed user.
 * @property member The user's guild member data, when included.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class GuildScheduledEventUser internal constructor(
    @SerialName("guild_scheduled_event_id")
    @get:JvmExposeBoxed
    public val guildScheduledEventId: DiscordId,
    public val user: User,
    public val member: GuildMember? = null,
) {
    override fun toString(): String =
        "GuildScheduledEventUser(guildScheduledEventId=$guildScheduledEventId, " +
            "user=${user.id})"
}

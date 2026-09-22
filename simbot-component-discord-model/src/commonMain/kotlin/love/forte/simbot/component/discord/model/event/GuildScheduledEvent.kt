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
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Guild Scheduled Event Object](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-object).
 *
 * Represents a voice, stage, or externally hosted event scheduled in a guild.
 *
 * @property id The scheduled event ID.
 * @property guildId The guild that owns the event.
 * @property channelId The hosting channel ID, or null for external events.
 * @property creatorId The user that created the event.
 * @property name The event name.
 * @property description The event description.
 * @property scheduledStartTime When the event starts.
 * @property scheduledEndTime When the event ends.
 * @property privacyLevel Who can access the event.
 * @property status The event lifecycle status.
 * @property entityType Where the event is hosted.
 * @property entityId The Discord entity associated with the event.
 * @property entityMetadata Additional metadata for external events.
 * @property creator The event creator, when included.
 * @property userCount The subscriber count, when requested.
 * @property image The event cover image hash.
 * @property recurrenceRule The recurrence definition, when configured.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class GuildScheduledEvent internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId,
    @SerialName("channel_id")
    @get:JvmExposeBoxed
    public val channelId: DiscordId?,
    @SerialName("creator_id")
    @get:JvmExposeBoxed
    public val creatorId: DiscordId? = null,
    public val name: String,
    public val description: String? = null,
    @SerialName("scheduled_start_time")
    public val scheduledStartTime: Instant,
    @SerialName("scheduled_end_time")
    public val scheduledEndTime: Instant?,
    @SerialName("privacy_level")
    @get:JvmExposeBoxed
    public val privacyLevel: GuildScheduledEventPrivacyLevel,
    @get:JvmExposeBoxed
    public val status: GuildScheduledEventStatus,
    @SerialName("entity_type")
    @get:JvmExposeBoxed
    public val entityType: GuildScheduledEventEntityType,
    @SerialName("entity_id")
    @get:JvmExposeBoxed
    public val entityId: DiscordId?,
    @SerialName("entity_metadata")
    public val entityMetadata: GuildScheduledEventEntityMetadata?,
    public val creator: User? = null,
    @SerialName("user_count")
    public val userCount: Int? = null,
    public val image: String? = null,
    @SerialName("recurrence_rule")
    public val recurrenceRule: GuildScheduledEventRecurrenceRule?,
) {
    override fun toString(): String =
        "GuildScheduledEvent(id=$id, guildId=$guildId, name=$name, status=$status)"
}

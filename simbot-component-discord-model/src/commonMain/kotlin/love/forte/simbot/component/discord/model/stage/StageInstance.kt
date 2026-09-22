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

package love.forte.simbot.component.discord.model.stage

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Stage Instance Object](https://docs.discord.com/developers/resources/stage-instance#stage-instance-object).
 *
 * Represents a live stage hosted in a guild stage channel.
 *
 * @property id The stage instance ID.
 * @property guildId The associated guild ID.
 * @property channelId The associated stage channel ID.
 * @property topic The stage topic.
 * @property privacyLevel Who can access the stage.
 * @property discoverableDisabled Whether Stage Discovery is disabled.
 * @property guildScheduledEventId The associated scheduled event ID.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class StageInstance internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId,
    @SerialName("channel_id")
    @get:JvmExposeBoxed
    public val channelId: DiscordId,
    public val topic: String,
    @SerialName("privacy_level")
    @get:JvmExposeBoxed
    public val privacyLevel: StagePrivacyLevel,
    @SerialName("discoverable_disabled")
    public val discoverableDisabled: Boolean,
    @SerialName("guild_scheduled_event_id")
    @get:JvmExposeBoxed
    public val guildScheduledEventId: DiscordId?,
) {
    override fun toString(): String =
        "StageInstance(id=$id, guildId=$guildId, channelId=$channelId, topic=$topic)"
}

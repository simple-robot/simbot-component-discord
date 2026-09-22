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

package love.forte.simbot.component.discord.model.voice

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.guild.GuildMember
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Voice State Object](https://docs.discord.com/developers/resources/voice#voice-state-object).
 *
 * Represents a user's current guild voice connection and local or server-side
 * mute, deaf, video, stream, and stage speaking state.
 *
 * @property guildId The guild ID, when included.
 * @property channelId The connected channel ID, or null when disconnected.
 * @property userId The user represented by this voice state.
 * @property member The user's guild member data, when included.
 * @property sessionId The voice session ID.
 * @property deaf Whether the user is server-deafened.
 * @property mute Whether the user is server-muted.
 * @property selfDeaf Whether the user is locally deafened.
 * @property selfMute Whether the user is locally muted.
 * @property selfStream Whether the user is streaming with Go Live.
 * @property selfVideo Whether the user's camera is enabled.
 * @property suppress Whether the user is denied permission to speak.
 * @property requestToSpeakTimestamp When the user requested to speak.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class VoiceState internal constructor(
    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId? = null,
    @SerialName("channel_id")
    @get:JvmExposeBoxed
    public val channelId: DiscordId?,
    @SerialName("user_id")
    @get:JvmExposeBoxed
    public val userId: DiscordId,
    public val member: GuildMember? = null,
    @SerialName("session_id")
    public val sessionId: String,
    public val deaf: Boolean,
    public val mute: Boolean,
    @SerialName("self_deaf")
    public val selfDeaf: Boolean,
    @SerialName("self_mute")
    public val selfMute: Boolean,
    @SerialName("self_stream")
    public val selfStream: Boolean? = null,
    @SerialName("self_video")
    public val selfVideo: Boolean,
    public val suppress: Boolean,
    @SerialName("request_to_speak_timestamp")
    public val requestToSpeakTimestamp: Instant?,
) {
    override fun toString(): String =
        "VoiceState(userId=$userId, channelId=$channelId, sessionId=$sessionId)"
}

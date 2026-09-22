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

package love.forte.simbot.component.discord.model.soundboard

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Soundboard Sound Object](https://docs.discord.com/developers/resources/soundboard#soundboard-sound-object).
 *
 * Represents a default or guild-owned sound that can be played in a voice
 * channel through Discord's soundboard.
 *
 * @property name The sound name.
 * @property soundId The sound ID.
 * @property volume The sound volume from 0 to 1.
 * @property emojiId The custom emoji ID associated with the sound.
 * @property emojiName The Unicode emoji associated with the sound.
 * @property guildId The owning guild ID, when this is a guild sound.
 * @property available Whether the sound can currently be used.
 * @property user The user that created the sound, when included.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class SoundboardSound internal constructor(
    public val name: String,
    @SerialName("sound_id")
    @get:JvmExposeBoxed
    public val soundId: DiscordId,
    public val volume: Double,
    @SerialName("emoji_id")
    @get:JvmExposeBoxed
    public val emojiId: DiscordId?,
    @SerialName("emoji_name")
    public val emojiName: String?,
    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId? = null,
    public val available: Boolean,
    public val user: User? = null,
) {
    override fun toString(): String =
        "SoundboardSound(soundId=$soundId, name=$name, available=$available)"
}

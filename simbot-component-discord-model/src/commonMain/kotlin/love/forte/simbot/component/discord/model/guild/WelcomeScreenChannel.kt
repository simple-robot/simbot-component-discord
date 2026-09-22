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
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Welcome Screen Channel Structure](https://docs.discord.com/developers/resources/guild#welcome-screen-object-welcome-screen-channel-structure).
 *
 * Represents one channel promoted to new members on a guild welcome screen.
 *
 * @property channelId The promoted channel ID.
 * @property description The description shown for the channel.
 * @property emojiId The custom emoji ID, when one is configured.
 * @property emojiName The custom emoji name or Unicode character.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class WelcomeScreenChannel internal constructor(
    @SerialName("channel_id")
    @get:JvmExposeBoxed
    public val channelId: DiscordId,
    public val description: String,
    @SerialName("emoji_id")
    @get:JvmExposeBoxed
    public val emojiId: DiscordId?,
    @SerialName("emoji_name")
    public val emojiName: String?,
) {
    override fun toString(): String =
        "WelcomeScreenChannel(channelId=$channelId, description=$description)"
}

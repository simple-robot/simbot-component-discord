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

package love.forte.simbot.component.discord.api.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Default Reaction Object](https://docs.discord.com/developers/resources/channel#default-reaction-object).
 *
 * Specifies the emoji displayed by the add-reaction button on a forum or media
 * thread; Discord provides either an emoji ID or an emoji name.
 *
 * @property emojiId The custom emoji ID, when the reaction uses a custom emoji.
 * @property emojiName The Unicode emoji name, when the reaction uses Unicode.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class DefaultReaction internal constructor(
    @SerialName("emoji_id")
    @get:JvmExposeBoxed
    public val emojiId: DiscordId? = null,
    @SerialName("emoji_name")
    public val emojiName: String? = null,
) {
    override fun toString(): String =
        "DefaultReaction(emojiId=$emojiId, emojiName=$emojiName)"
}

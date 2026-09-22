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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Forum Tag Object](https://docs.discord.com/developers/resources/channel#forum-tag-object).
 *
 * Defines a tag that can be applied to threads in forum and media channels.
 *
 * @property id The tag's Discord ID.
 * @property name The tag's name.
 * @property moderated Whether only members with MANAGE_THREADS can add or remove
 * the tag.
 * @property emojiId The custom emoji ID for the tag, when present.
 * @property emojiName The Unicode emoji name for the tag, when present.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class ForumTag internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    public val moderated: Boolean,
    @SerialName("emoji_id")
    @get:JvmExposeBoxed
    public val emojiId: DiscordId? = null,
    @SerialName("emoji_name")
    public val emojiName: String? = null,
) {
    override fun toString(): String =
        "ForumTag(id=$id, name=$name, moderated=$moderated)"
}

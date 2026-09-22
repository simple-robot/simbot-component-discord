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

package love.forte.simbot.component.discord.model.emoji

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Emoji Object](https://docs.discord.com/developers/resources/emoji#emoji-object).
 *
 * Represents a custom or Unicode emoji. Reaction payloads can contain a null
 * name when a custom emoji has been deleted.
 *
 * @property id The custom emoji ID, or null for a Unicode emoji.
 * @property name The emoji name or Unicode character.
 * @property roles IDs of roles allowed to use this emoji.
 * @property user The user that created this emoji, when included.
 * @property requireColons Whether the emoji must be wrapped in colons.
 * @property managed Whether the emoji is managed by an integration.
 * @property animated Whether the emoji is animated.
 * @property available Whether the emoji can currently be used.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Emoji internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId?,
    public val name: String?,
    public val roles: List<DiscordId>? = null,
    public val user: User? = null,
    @SerialName("require_colons")
    public val requireColons: Boolean? = null,
    public val managed: Boolean? = null,
    public val animated: Boolean? = null,
    public val available: Boolean? = null,
) {
    override fun toString(): String = "Emoji(id=$id, name=$name)"
}

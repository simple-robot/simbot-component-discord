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

package love.forte.simbot.component.discord.model.sticker

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Sticker Item Object](https://docs.discord.com/developers/resources/sticker#sticker-item-object).
 *
 * Contains the minimum sticker data required to render a sticker attached to
 * a message.
 *
 * @property id The sticker ID.
 * @property name The sticker name.
 * @property formatType The sticker media format.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class StickerItem internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    @SerialName("format_type")
    @get:JvmExposeBoxed
    public val formatType: StickerFormatType,
) {
    override fun toString(): String =
        "StickerItem(id=$id, name=$name, formatType=$formatType)"
}

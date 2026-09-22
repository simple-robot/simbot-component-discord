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
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Sticker Object](https://docs.discord.com/developers/resources/sticker#sticker-object).
 *
 * Represents a standard or guild-owned sticker that can be sent in messages.
 *
 * @property id The sticker ID.
 * @property packId The standard sticker pack ID, when applicable.
 * @property name The sticker name.
 * @property description The sticker description.
 * @property tags Autocomplete or suggestion tags for the sticker.
 * @property type Whether the sticker is standard or guild-owned.
 * @property formatType The sticker media format.
 * @property available Whether the guild sticker can currently be used.
 * @property guildId The guild that owns this sticker, when applicable.
 * @property user The user that uploaded this guild sticker, when included.
 * @property sortValue The sticker's order within its standard pack.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Sticker internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    @SerialName("pack_id")
    @get:JvmExposeBoxed
    public val packId: DiscordId? = null,
    public val name: String,
    public val description: String?,
    public val tags: String,
    @get:JvmExposeBoxed
    public val type: StickerType,
    @SerialName("format_type")
    @get:JvmExposeBoxed
    public val formatType: StickerFormatType,
    public val available: Boolean? = null,
    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId? = null,
    public val user: User? = null,
    @SerialName("sort_value")
    public val sortValue: Int? = null,
) {
    override fun toString(): String =
        "Sticker(id=$id, name=$name, type=$type, formatType=$formatType)"
}

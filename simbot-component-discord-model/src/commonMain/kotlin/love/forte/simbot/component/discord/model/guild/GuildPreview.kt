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
import love.forte.simbot.component.discord.model.emoji.Emoji
import love.forte.simbot.component.discord.model.sticker.Sticker
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Guild Preview Object](https://docs.discord.com/developers/resources/guild#guild-preview-object).
 *
 * Represents the public preview of a discoverable guild without exposing its
 * complete member or channel state.
 *
 * @property id The guild ID.
 * @property name The guild name.
 * @property icon The guild icon hash.
 * @property splash The guild invite splash hash.
 * @property discoverySplash The guild discovery splash hash.
 * @property emojis The guild's custom emojis.
 * @property features The enabled guild features.
 * @property approximateMemberCount The approximate member count.
 * @property approximatePresenceCount The approximate online member count.
 * @property description The guild description.
 * @property stickers The guild's custom stickers.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class GuildPreview internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    public val icon: String?,
    public val splash: String?,
    @SerialName("discovery_splash")
    public val discoverySplash: String?,
    public val emojis: List<Emoji>,
    public val features: List<GuildFeature>,
    @SerialName("approximate_member_count")
    public val approximateMemberCount: Int,
    @SerialName("approximate_presence_count")
    public val approximatePresenceCount: Int,
    public val description: String?,
    public val stickers: List<Sticker>,
) {
    override fun toString(): String =
        "GuildPreview(id=$id, name=$name, " +
            "approximateMemberCount=$approximateMemberCount)"
}

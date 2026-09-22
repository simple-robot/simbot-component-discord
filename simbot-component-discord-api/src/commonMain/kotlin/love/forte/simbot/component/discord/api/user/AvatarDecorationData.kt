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

package love.forte.simbot.component.discord.api.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Avatar Decoration Data Object](https://docs.discord.com/developers/resources/user#avatar-decoration-data-object).
 *
 * Describes the asset and SKU used to decorate a user's avatar.
 *
 * @property asset The avatar decoration asset hash.
 * @property skuId The SKU ID of the avatar decoration.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class AvatarDecorationData internal constructor(
    public val asset: String,
    @SerialName("sku_id")
    @get:JvmExposeBoxed
    public val skuId: DiscordId,
) {
    override fun toString(): String =
        "AvatarDecorationData(skuId=$skuId, asset=$asset)"
}

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

package love.forte.simbot.component.discord.model.user

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed

/**
 * [Nameplate](https://docs.discord.com/developers/resources/user#nameplate-nameplate-structure).
 *
 * Describes a collectible nameplate equipped by a user.
 *
 * @property skuId The SKU ID of the nameplate.
 * @property asset The nameplate asset hash.
 * @property label The nameplate label.
 * @property palette The nameplate color palette.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Nameplate internal constructor(
    @SerialName("sku_id")
    @get:JvmExposeBoxed
    public val skuId: DiscordId,
    public val asset: String,
    public val label: String,
    public val palette: String,
) {
    override fun toString(): String =
        "Nameplate(skuId=$skuId, label=$label, palette=$palette)"
}

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

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Sticker Types](https://docs.discord.com/developers/resources/sticker#sticker-object-sticker-types).
 *
 * Distinguishes official stickers from stickers uploaded to a guild.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord sticker type value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class StickerType private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for [Standard].
         */
        public const val STANDARD_VALUE: Int = 1

        /**
         * Raw value for [Guild].
         */
        public const val GUILD_VALUE: Int = 2

        /**
         * An official sticker distributed in a sticker pack.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Standard: StickerType = StickerType(STANDARD_VALUE)

        /**
         * A sticker uploaded to a guild.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Guild: StickerType = StickerType(GUILD_VALUE)

        /**
         * Creates a type from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): StickerType = StickerType(value)
    }

}

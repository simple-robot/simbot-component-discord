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
 * [Sticker Format Types](https://docs.discord.com/developers/resources/sticker#sticker-object-sticker-format-types).
 *
 * Represents the media format used to render a sticker.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord sticker format value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class StickerFormatType private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw PNG format value.
         */
        public const val PNG_VALUE: Int = 1

        /**
         * Raw APNG format value.
         */
        public const val APNG_VALUE: Int = 2

        /**
         * Raw Lottie format value.
         */
        public const val LOTTIE_VALUE: Int = 3

        /**
         * Raw GIF format value.
         */
        public const val GIF_VALUE: Int = 4

        /**
         * A PNG sticker.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Png: StickerFormatType = StickerFormatType(PNG_VALUE)

        /**
         * An animated PNG sticker.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Apng: StickerFormatType = StickerFormatType(APNG_VALUE)

        /**
         * A Lottie JSON sticker.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Lottie: StickerFormatType = StickerFormatType(LOTTIE_VALUE)

        /**
         * A GIF sticker.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Gif: StickerFormatType = StickerFormatType(GIF_VALUE)

        /**
         * Creates a format from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): StickerFormatType = StickerFormatType(value)
    }

    override fun toString(): String = "StickerFormatType(value=$value)"
}

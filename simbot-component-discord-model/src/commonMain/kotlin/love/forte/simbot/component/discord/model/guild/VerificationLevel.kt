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

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Verification Level](https://docs.discord.com/developers/resources/guild#guild-object-verification-level).
 *
 * Represents the account or membership requirements a user must satisfy
 * before participating in a guild. Unknown values are preserved.
 *
 * @property value The raw Discord verification level value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class VerificationLevel private constructor(public val value: Int) {
    public companion object {
        /** Raw value for [None]. */
        public const val NONE_VALUE: Int = 0

        /** Raw value for [Low]. */
        public const val LOW_VALUE: Int = 1

        /** Raw value for [Medium]. */
        public const val MEDIUM_VALUE: Int = 2

        /** Raw value for [High]. */
        public const val HIGH_VALUE: Int = 3

        /** Raw value for [VeryHigh]. */
        public const val VERY_HIGH_VALUE: Int = 4

        /** No verification requirement is applied. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val None: VerificationLevel = VerificationLevel(NONE_VALUE)

        /** The account must have a verified email address. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Low: VerificationLevel = VerificationLevel(LOW_VALUE)

        /** The account must be registered for more than five minutes. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Medium: VerificationLevel = VerificationLevel(MEDIUM_VALUE)

        /** The user must be a guild member for more than ten minutes. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val High: VerificationLevel = VerificationLevel(HIGH_VALUE)

        /** The account must have a verified phone number. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val VeryHigh: VerificationLevel = VerificationLevel(VERY_HIGH_VALUE)

        /** Creates a level from a raw Discord value. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): VerificationLevel = VerificationLevel(value)
    }

    override fun toString(): String = "VerificationLevel(value=$value)"
}

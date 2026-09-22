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
 * [MFA Level](https://docs.discord.com/developers/resources/guild#guild-object-mfa-level).
 *
 * Represents whether moderation actions in a guild require two-factor
 * authentication. Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord MFA level value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class MfaLevel private constructor(public val value: Int) {
    public companion object {
        /** Raw value for [None]. */
        public const val NONE_VALUE: Int = 0

        /** Raw value for [Elevated]. */
        public const val ELEVATED_VALUE: Int = 1

        /** Moderation actions do not require two-factor authentication. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val None: MfaLevel = MfaLevel(NONE_VALUE)

        /** Moderation actions require two-factor authentication. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Elevated: MfaLevel = MfaLevel(ELEVATED_VALUE)

        /** Creates a level from a raw Discord value. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): MfaLevel = MfaLevel(value)
    }

    override fun toString(): String = "MfaLevel(value=$value)"
}

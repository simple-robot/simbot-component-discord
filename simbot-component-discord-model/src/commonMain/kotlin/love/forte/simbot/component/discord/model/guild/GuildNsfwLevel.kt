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
 * [Guild Age-Restriction Level](https://docs.discord.com/developers/resources/guild#guild-object-guild-nsfw-level).
 *
 * Represents the age-restriction classification of a guild.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord age-restriction level value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class GuildNsfwLevel private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for [Default].
         */
        public const val DEFAULT_VALUE: Int = 0

        /**
         * Raw value for [Explicit].
         */
        public const val EXPLICIT_VALUE: Int = 1

        /**
         * Raw value for [Safe].
         */
        public const val SAFE_VALUE: Int = 2

        /**
         * Raw value for [AgeRestricted].
         */
        public const val AGE_RESTRICTED_VALUE: Int = 3

        /**
         * The guild uses Discord's default classification.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Default: GuildNsfwLevel = GuildNsfwLevel(DEFAULT_VALUE)

        /**
         * The guild is classified as explicit.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Explicit: GuildNsfwLevel = GuildNsfwLevel(EXPLICIT_VALUE)

        /**
         * The guild is classified as safe.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Safe: GuildNsfwLevel = GuildNsfwLevel(SAFE_VALUE)

        /**
         * The guild is age-restricted.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AgeRestricted: GuildNsfwLevel = GuildNsfwLevel(AGE_RESTRICTED_VALUE)

        /**
         * Creates a level from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): GuildNsfwLevel = GuildNsfwLevel(value)
    }

    override fun toString(): String = "GuildNsfwLevel(value=$value)"
}

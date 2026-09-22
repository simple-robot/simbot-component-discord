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
 * [Premium Tier](https://docs.discord.com/developers/resources/guild#guild-object-premium-tier).
 *
 * Represents the Server Boost level whose perks the guild has unlocked.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord premium tier value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class PremiumTier private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for [None].
         */
        public const val NONE_VALUE: Int = 0

        /**
         * Raw value for [Tier1].
         */
        public const val TIER_1_VALUE: Int = 1

        /**
         * Raw value for [Tier2].
         */
        public const val TIER_2_VALUE: Int = 2

        /**
         * Raw value for [Tier3].
         */
        public const val TIER_3_VALUE: Int = 3

        /**
         * The guild has not unlocked Server Boost perks.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val None: PremiumTier = PremiumTier(NONE_VALUE)

        /**
         * The guild has unlocked Server Boost level 1 perks.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Tier1: PremiumTier = PremiumTier(TIER_1_VALUE)

        /**
         * The guild has unlocked Server Boost level 2 perks.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Tier2: PremiumTier = PremiumTier(TIER_2_VALUE)

        /**
         * The guild has unlocked Server Boost level 3 perks.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Tier3: PremiumTier = PremiumTier(TIER_3_VALUE)

        /**
         * Creates a tier from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): PremiumTier = PremiumTier(value)
    }

}

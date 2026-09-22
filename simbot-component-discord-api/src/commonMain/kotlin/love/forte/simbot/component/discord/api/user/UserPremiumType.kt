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

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Premium Types](https://docs.discord.com/developers/resources/user#user-object-premium-types).
 *
 * Represents the Nitro subscription type from a Discord user object.
 *
 * @property value The raw Discord premium type value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class UserPremiumType private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for users without a Nitro subscription.
         */
        public const val NONE_VALUE: Int = 0

        /**
         * Raw value for the legacy Nitro Classic subscription.
         */
        public const val NITRO_CLASSIC_VALUE: Int = 1

        /**
         * Raw value for the Nitro subscription.
         */
        public const val NITRO_VALUE: Int = 2

        /**
         * Raw value for the Nitro Basic subscription.
         */
        public const val NITRO_BASIC_VALUE: Int = 3

        /**
         * The user has no Nitro subscription.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val None: UserPremiumType = UserPremiumType(NONE_VALUE)

        /**
         * The user has the legacy Nitro Classic subscription.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val NitroClassic: UserPremiumType = UserPremiumType(NITRO_CLASSIC_VALUE)

        /**
         * The user has the Nitro subscription.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Nitro: UserPremiumType = UserPremiumType(NITRO_VALUE)

        /**
         * The user has the Nitro Basic subscription.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val NitroBasic: UserPremiumType = UserPremiumType(NITRO_BASIC_VALUE)

        /**
         * Creates a [UserPremiumType] from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): UserPremiumType = UserPremiumType(value)
    }

    override fun toString(): String =
        "UserPremiumType(value=$value)"
}

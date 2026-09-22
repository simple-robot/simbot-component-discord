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

package love.forte.simbot.component.discord.api.channel

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Sort Order Types](https://docs.discord.com/developers/resources/channel#channel-object-sort-order-types).
 *
 * Represents the default sort order used to order posts in a
 * GUILD_FORUM or GUILD_MEDIA channel.
 *
 * Known values:
 *
 * - 0 = LATEST_ACTIVITY
 * - 1 = CREATION_DATE
 *
 * @property value The raw Discord sort order type value.
 *
 * @see Channel
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class SortOrderType private constructor(public val value: Int) {
    public companion object {
        /**
         * LATEST_ACTIVITY value constant.
         */
        public const val LATEST_ACTIVITY_VALUE: Int = 0

        /**
         * CREATION_DATE value constant.
         */
        public const val CREATION_DATE_VALUE: Int = 1

        /**
         * Sort forum posts by activity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val LatestActivity: SortOrderType = SortOrderType(LATEST_ACTIVITY_VALUE)

        /**
         * Sort forum posts by creation time, from most recent to oldest.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val CreationDate: SortOrderType = SortOrderType(CREATION_DATE_VALUE)

        /**
         * Creates a [SortOrderType] from any integer value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): SortOrderType = SortOrderType(value)
    }

    override fun toString(): String =
        "SortOrderType(value=$value)"
}

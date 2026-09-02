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

package love.forte.simbot.component.discord.common

import kotlin.jvm.JvmInline
import kotlin.time.Instant

/**
 * [Discord Snowflake ID](https://docs.discord.com/developers/reference#snowflakes),
 * Discord utilizes Twitter’s [snowflake](https://github.com/twitter-archive/snowflake/tree/snowflake-2010)
 * format for uniquely identifiable descriptors (IDs).
 */
@JvmInline
public value class DiscordSnowflake(public val value: ULong) {
    /**
     * Milliseconds since Discord Epoch, the first second of 2015 or 1420070400000.
     * Bits from 63 to 22.
     */
    public val timestamp: Long
        get() = (value shr 22).toLong() + DISCORD_EPOCH

    /**
     * Internal worker ID, bits from 21 to 17
     */
    public val internalWorkerId: Int
        get() = (value and 0x3E0000u).toInt() shr 17

    /**
     * Internal process ID, bits from 16 to 12
     */
    public val internalProcessId: Int
        get() = (value and 0x1F000u).toInt() shr 12

    /**
     * For every ID that is generated on that process, this number is incremented.
     * Bits from 11 to 0.
     */
    public val increment: Int
        get() = (value and 0xFFFu).toInt()

    public companion object {
        private const val DISCORD_EPOCH: Long = 1420070400000L
    }
}

/**
 * Converts the current [DiscordSnowflake] value into an [Instant].
 *
 * @return An [Instant] instance representing the timestamp of this [DiscordSnowflake].
 */
public val DiscordSnowflake.instant: Instant
    get() = Instant.fromEpochMilliseconds(timestamp)

/**
 * Converts the current [ULong] value into a [DiscordSnowflake].
 *
 * @return A [DiscordSnowflake] instance representing the Discord Snowflake ID for this [ULong] value.
 */
public fun ULong.toDiscordSnowflake(): DiscordSnowflake = DiscordSnowflake(this)

/**
 * Converts the current [String] ULong value into a [DiscordSnowflake].
 *
 * @return A [DiscordSnowflake] instance representing the Discord Snowflake ID for this [String] value.
 */
public fun String.toDiscordSnowflake(): DiscordSnowflake = toULong().toDiscordSnowflake()

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

package love.forte.simbot.component.discord.model.channel

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * A Discord channel flags bit field.
 *
 * [plus] combines flags, [minus] removes flags, and [contains] checks whether
 * another flag is included in this bit field.
 *
 * Unknown bits are preserved, allowing compatibility with channel flags
 * introduced by newer Discord API versions.
 *
 * @property value The raw channel flags bit field.
 *
 * @see ChannelFlag
 * @see [Channel flags](https://docs.discord.com/developers/resources/channel#channel-object-channel-flags)
 *
 * @author Forte Scarlet
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmExposeBoxed
@JvmInline
@Serializable
public value class ChannelFlags private constructor(public val value: Long) {
    public companion object {
        /**
         * An empty channel flags bit field.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val None: ChannelFlags = ChannelFlags(0L)

        /**
         * Creates a [ChannelFlags] instance from its raw bit field value.
         *
         * Unknown bits are preserved.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Long): ChannelFlags =
            ChannelFlags(value)
    }

    /**
     * Combines this bit field with [other].
     */
    @JvmExposeBoxed
    public operator fun plus(other: ChannelFlags): ChannelFlags =
        ChannelFlags(value or other.value)

    /**
     * Removes all bits present in [other] from this bit field.
     */
    @JvmExposeBoxed
    public operator fun minus(other: ChannelFlags): ChannelFlags =
        ChannelFlags(value and other.value.inv())

    /**
     * Returns `true` when every bit in [other] is present in this bit field.
     */
    @JvmExposeBoxed
    public operator fun contains(other: ChannelFlags): Boolean =
        contains(other, exactly = false)

    /**
     * Checks whether [other] is included in this bit field.
     *
     * When [exactly] is `true`, this bit field must equal [other].
     * Otherwise, every bit in [other] only needs to be present.
     */
    @JvmExposeBoxed
    public fun contains(
        other: ChannelFlags,
        exactly: Boolean
    ): Boolean =
        if (exactly) {
            value == other.value
        } else {
            value and other.value == other.value
        }

    /**
     * Returns `true` when this bit field and [other] share at least one bit.
     */
    @JvmExposeBoxed
    public fun intersects(other: ChannelFlags): Boolean =
        value and other.value != 0L

    /**
     * Whether this bit field contains no bits.
     */
    public val isEmpty: Boolean
        get() = value == 0L

    override fun toString(): String =
        "ChannelFlags(value=$value)"
}

/**
 * Combines this [ChannelFlags] bit field with the bit represented by the given [ChannelFlag].
 *
 * @param other The [ChannelFlag] to be combined with this bit field.
 * @return A new [ChannelFlags] instance with the bit from [other] included.
 */
public operator fun ChannelFlags.plus(other: ChannelFlag): ChannelFlags = this + other.flag

/**
 * Removes the specified [ChannelFlag] from this [ChannelFlags] instance.
 *
 * @param other The channel flag to remove from this bit field.
 * @return A new [ChannelFlags] instance with the specified flag removed.
 */
public operator fun ChannelFlags.minus(other: ChannelFlag): ChannelFlags = this - other.flag

/**
 * Determines whether a specific [ChannelFlag] is present in this [ChannelFlags] bit field.
 *
 * @param other The [ChannelFlag] to check for presence in this bit field.
 * @return `true` if the specified [ChannelFlag] is present, `false` otherwise.
 */
public operator fun ChannelFlags.contains(other: ChannelFlag): Boolean = contains(other.flag)

/**
 * Checks whether the specified [ChannelFlag] is included in this [ChannelFlags] bit field.
 *
 * When [exactly] is `true`, this bit field must equal the bit field of the given [ChannelFlag].
 * Otherwise, every bit in the [ChannelFlag] only needs to be present in this bit field.
 *
 * @param other The [ChannelFlag] to check for inclusion in this bit field.
 * @param exactly When `true`, this bit field must exactly match the bit field of [other].
 *                Otherwise, a partial match is sufficient.
 * @return `true` if [other] is included in this bit field, considering the value of [exactly].
 */
public fun ChannelFlags.contains(other: ChannelFlag, exactly: Boolean): Boolean = contains(other.flag, exactly)

/**
 * Checks whether this bit field and the given channel flag share at least one bit.
 *
 * @param other The channel flag to check for intersections with this bit field.
 * @return `true` if this bit field and the given channel flag share at least one bit; `false` otherwise.
 */
public fun ChannelFlags.intersects(other: ChannelFlag): Boolean = intersects(other.flag)

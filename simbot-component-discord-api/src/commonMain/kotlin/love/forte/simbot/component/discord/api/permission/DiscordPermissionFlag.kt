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

package love.forte.simbot.component.discord.api.permission

import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline

/**
 * A Discord permission bit field.
 *
 * [plus] combines flags, [minus] removes flags, and [contains] checks whether
 * another flag is included in this bit field.
 *
 * @see DiscordPermission
 * @see [Discord permissions](https://docs.discord.com/developers/topics/permissions)
 * @author Forte Scarlet
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmExposeBoxed
@JvmInline
public value class DiscordPermissionFlag(public val value: Long) {

    /**
     * An empty permission bit field.
     */
    public companion object {
        public val NONE: DiscordPermissionFlag = DiscordPermissionFlag(0L)
    }

    /**
     * Combines this bit field with [other].
     *
     * This is a bitwise OR, so adding an already-present permission has no
     * effect.
     */
    public operator fun plus(other: DiscordPermissionFlag): DiscordPermissionFlag =
        DiscordPermissionFlag(value or other.value)

    /**
     * Removes all bits present in [other] from this bit field.
     *
     * This is a bitwise clear operation; it is not arithmetic subtraction.
     */
    public operator fun minus(other: DiscordPermissionFlag): DiscordPermissionFlag =
        DiscordPermissionFlag(value and other.value.inv())

    /**
     * Returns `true` when every bit in [other] is present in this bit field.
     *
     * This makes expressions such as `required in granted` possible.
     */
    public operator fun contains(other: DiscordPermissionFlag): Boolean =
        contains(other, exactly = false)

    /**
     * Checks whether [other] is included in this bit field.
     *
     * When [exactly] is `true`, this bit field must equal [other]. Otherwise,
     * every bit in [other] only needs to be present in this bit field.
     */
    public fun contains(other: DiscordPermissionFlag, exactly: Boolean): Boolean =
        if (exactly) {
            value == other.value
        } else {
            value and other.value == other.value
        }

    /**
     * Returns `true` when this bit field and [other] share at least one bit.
     *
     * Unlike [contains], this does not require all bits in [other] to be
     * present.
     */
    public fun intersects(other: DiscordPermissionFlag): Boolean =
        value and other.value != 0L

    /**
     * Whether this bit field contains no bits.
     */
    public val isEmpty: Boolean
        get() = value == 0L

}


/**
 * Combines this bit field with the flag represented by [other].
 */
public operator fun DiscordPermissionFlag.plus(other: DiscordPermission): DiscordPermissionFlag = this + other.flag


/**
 * Removes the flag represented by [other] from this bit field.
 */
public operator fun DiscordPermissionFlag.minus(other: DiscordPermission): DiscordPermissionFlag = this - other.flag


/**
 * Returns `true` when the flag represented by [other] is present in this
 * bit field.
 */
public operator fun DiscordPermissionFlag.contains(other: DiscordPermission): Boolean = contains(other.flag)


/**
 * Checks whether the flag represented by [other] is included in this bit
 * field, with the same [exactly] semantics as [contains].
 */
public fun DiscordPermissionFlag.contains(other: DiscordPermission, exactly: Boolean): Boolean =
    contains(other.flag, exactly)


/**
 * Returns `true` when this bit field and the flag represented by [other]
 * share at least one bit.
 */
public fun DiscordPermissionFlag.intersects(other: DiscordPermission): Boolean = intersects(other.flag)

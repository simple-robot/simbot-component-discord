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
 * [Role Flags](https://docs.discord.com/developers/topics/permissions#role-object-role-flags).
 *
 * A bit field describing additional role capabilities. Unknown bits are
 * preserved for forward compatibility.
 *
 * @property value The raw role flags bit field.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class RoleFlags private constructor(public val value: Long) {
    public companion object {
        /** An empty role flags bit field. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val None: RoleFlags = RoleFlags(0L)

        /** Creates flags from a raw Discord bit field. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Long): RoleFlags = RoleFlags(value)
    }

    @JvmExposeBoxed
    public operator fun plus(other: RoleFlags): RoleFlags = RoleFlags(value or other.value)

    @JvmExposeBoxed
    public operator fun minus(other: RoleFlags): RoleFlags =
        RoleFlags(value and other.value.inv())

    @JvmExposeBoxed
    public operator fun contains(other: RoleFlags): Boolean =
        value and other.value == other.value

    public val isEmpty: Boolean get() = value == 0L

    override fun toString(): String = "RoleFlags(value=$value)"
}

/** Combines this bit field with [other]. */
public operator fun RoleFlags.plus(other: RoleFlag): RoleFlags = this + other.flag

/** Removes [other] from this bit field. */
public operator fun RoleFlags.minus(other: RoleFlag): RoleFlags = this - other.flag

/** Returns whether [other] is present in this bit field. */
public operator fun RoleFlags.contains(other: RoleFlag): Boolean = other.flag in this

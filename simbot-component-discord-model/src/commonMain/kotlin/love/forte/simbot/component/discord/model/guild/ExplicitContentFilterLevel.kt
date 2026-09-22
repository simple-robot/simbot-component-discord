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
 * [Explicit Content Filter Level](https://docs.discord.com/developers/resources/guild#guild-object-explicit-content-filter-level).
 *
 * Represents which guild members have their media content scanned.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord explicit content filter value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class ExplicitContentFilterLevel private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for [Disabled].
         */
        public const val DISABLED_VALUE: Int = 0

        /**
         * Raw value for [MembersWithoutRoles].
         */
        public const val MEMBERS_WITHOUT_ROLES_VALUE: Int = 1

        /**
         * Raw value for [AllMembers].
         */
        public const val ALL_MEMBERS_VALUE: Int = 2

        /**
         * Media content is not scanned.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Disabled: ExplicitContentFilterLevel =
            ExplicitContentFilterLevel(DISABLED_VALUE)

        /**
         * Media content from members without roles is scanned.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MembersWithoutRoles: ExplicitContentFilterLevel =
            ExplicitContentFilterLevel(MEMBERS_WITHOUT_ROLES_VALUE)

        /**
         * Media content from all members is scanned.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AllMembers: ExplicitContentFilterLevel =
            ExplicitContentFilterLevel(ALL_MEMBERS_VALUE)

        /**
         * Creates a level from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): ExplicitContentFilterLevel =
            ExplicitContentFilterLevel(value)
    }

}

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
 * [Overwrite Object](https://docs.discord.com/developers/resources/channel#overwrite-object).
 *
 * Represents the target type of a channel permission overwrite.
 *
 * @property value The raw Discord overwrite target type value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class PermissionOverwriteType private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for a role overwrite.
         */
        public const val ROLE_VALUE: Int = 0

        /**
         * Raw value for a member overwrite.
         */
        public const val MEMBER_VALUE: Int = 1

        /**
         * The overwrite targets a guild role.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Role: PermissionOverwriteType = PermissionOverwriteType(ROLE_VALUE)

        /**
         * The overwrite targets an individual guild member.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Member: PermissionOverwriteType = PermissionOverwriteType(MEMBER_VALUE)

        /**
         * Creates a [PermissionOverwriteType] from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): PermissionOverwriteType = PermissionOverwriteType(value)
    }

}

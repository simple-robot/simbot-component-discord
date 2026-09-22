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

package love.forte.simbot.component.discord.model.event

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Guild Scheduled Event Entity Types](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-object-guild-scheduled-event-entity-types).
 *
 * Represents where Discord hosts a scheduled event. Unknown values are
 * preserved for forward compatibility.
 *
 * @property value The raw Discord scheduled event entity type value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class GuildScheduledEventEntityType private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw stage instance entity type value.
         */
        public const val STAGE_INSTANCE_VALUE: Int = 1

        /**
         * Raw voice entity type value.
         */
        public const val VOICE_VALUE: Int = 2

        /**
         * Raw external entity type value.
         */
        public const val EXTERNAL_VALUE: Int = 3

        /**
         * An event hosted in a stage channel.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val StageInstance: GuildScheduledEventEntityType =
            GuildScheduledEventEntityType(STAGE_INSTANCE_VALUE)

        /**
         * An event hosted in a voice channel.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Voice: GuildScheduledEventEntityType =
            GuildScheduledEventEntityType(VOICE_VALUE)

        /**
         * An event hosted at an external location.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val External: GuildScheduledEventEntityType =
            GuildScheduledEventEntityType(EXTERNAL_VALUE)

        /**
         * Creates a type from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): GuildScheduledEventEntityType =
            GuildScheduledEventEntityType(value)
    }

    override fun toString(): String =
        "GuildScheduledEventEntityType(value=$value)"
}

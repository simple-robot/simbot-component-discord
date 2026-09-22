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
 * [Guild Scheduled Event Status](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-object-guild-scheduled-event-status).
 *
 * Represents the lifecycle state of a scheduled event. Completed and canceled
 * events cannot transition to another status. Unknown values are preserved.
 *
 * @property value The raw Discord scheduled event status value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class GuildScheduledEventStatus private constructor(public val value: Int) {
    public companion object {
        /** Raw scheduled status value. */
        public const val SCHEDULED_VALUE: Int = 1

        /** Raw active status value. */
        public const val ACTIVE_VALUE: Int = 2

        /** Raw completed status value. */
        public const val COMPLETED_VALUE: Int = 3

        /** Raw canceled status value. */
        public const val CANCELED_VALUE: Int = 4

        /** The event has not started. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Scheduled: GuildScheduledEventStatus =
            GuildScheduledEventStatus(SCHEDULED_VALUE)

        /** The event is currently active. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Active: GuildScheduledEventStatus =
            GuildScheduledEventStatus(ACTIVE_VALUE)

        /** The event has completed. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Completed: GuildScheduledEventStatus =
            GuildScheduledEventStatus(COMPLETED_VALUE)

        /** The event was canceled. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Canceled: GuildScheduledEventStatus =
            GuildScheduledEventStatus(CANCELED_VALUE)

        /** Creates a status from a raw Discord value. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): GuildScheduledEventStatus =
            GuildScheduledEventStatus(value)
    }

    override fun toString(): String = "GuildScheduledEventStatus(value=$value)"
}

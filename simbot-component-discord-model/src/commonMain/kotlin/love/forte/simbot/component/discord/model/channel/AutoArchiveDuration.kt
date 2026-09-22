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
 * Represents an automatic thread archive duration, in minutes.
 *
 * Known values:
 *
 * - 60 = 1 hour
 * - 1440 = 1 day
 * - 4320 = 3 days
 * - 10080 = 7 days
 *
 * This type is used by both the channel's `default_auto_archive_duration`
 * and thread metadata's `auto_archive_duration`.
 *
 * @property value The archive duration in minutes.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class AutoArchiveDuration private constructor(public val value: Int) {
    public companion object {
        /**
         * One hour, in minutes.
         */
        public const val ONE_HOUR_VALUE: Int = 60

        /**
         * One day, in minutes.
         */
        public const val ONE_DAY_VALUE: Int = 1440

        /**
         * Three days, in minutes.
         */
        public const val THREE_DAYS_VALUE: Int = 4320

        /**
         * Seven days, in minutes.
         */
        public const val SEVEN_DAYS_VALUE: Int = 10080

        /**
         * Automatically archive after one hour of inactivity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val OneHour: AutoArchiveDuration = AutoArchiveDuration(ONE_HOUR_VALUE)

        /**
         * Automatically archive after one day of inactivity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val OneDay: AutoArchiveDuration = AutoArchiveDuration(ONE_DAY_VALUE)

        /**
         * Automatically archive after three days of inactivity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val ThreeDays: AutoArchiveDuration = AutoArchiveDuration(THREE_DAYS_VALUE)

        /**
         * Automatically archive after seven days of inactivity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val SevenDays: AutoArchiveDuration = AutoArchiveDuration(SEVEN_DAYS_VALUE)

        /**
         * Creates an [AutoArchiveDuration] from any integer value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): AutoArchiveDuration = AutoArchiveDuration(value)
    }

    override fun toString(): String =
        "AutoArchiveDuration(value=$value)"
}

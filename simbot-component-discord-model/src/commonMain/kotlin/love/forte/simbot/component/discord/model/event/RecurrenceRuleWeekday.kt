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
 * [Recurrence Rule Weekday](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-recurrence-rule-object-guild-scheduled-event-recurrence-rule-weekday).
 *
 * Represents a weekday in a scheduled event recurrence rule.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord weekday value, where Monday is zero.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class RecurrenceRuleWeekday private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw Monday value.
         */
        public const val MONDAY_VALUE: Int = 0

        /**
         * Raw Tuesday value.
         */
        public const val TUESDAY_VALUE: Int = 1

        /**
         * Raw Wednesday value.
         */
        public const val WEDNESDAY_VALUE: Int = 2

        /**
         * Raw Thursday value.
         */
        public const val THURSDAY_VALUE: Int = 3

        /**
         * Raw Friday value.
         */
        public const val FRIDAY_VALUE: Int = 4

        /**
         * Raw Saturday value.
         */
        public const val SATURDAY_VALUE: Int = 5

        /**
         * Raw Sunday value.
         */
        public const val SUNDAY_VALUE: Int = 6


        /**
         * Monday.
         */
        @JvmStatic @get:JvmExposeBoxed public val Monday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(MONDAY_VALUE)
        /**
         * Tuesday.
         */
        @JvmStatic @get:JvmExposeBoxed public val Tuesday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(TUESDAY_VALUE)
        /**
         * Wednesday.
         */
        @JvmStatic @get:JvmExposeBoxed public val Wednesday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(WEDNESDAY_VALUE)
        /**
         * Thursday.
         */
        @JvmStatic @get:JvmExposeBoxed public val Thursday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(THURSDAY_VALUE)
        /**
         * Friday.
         */
        @JvmStatic @get:JvmExposeBoxed public val Friday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(FRIDAY_VALUE)
        /**
         * Saturday.
         */
        @JvmStatic @get:JvmExposeBoxed public val Saturday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(SATURDAY_VALUE)
        /**
         * Sunday.
         */
        @JvmStatic @get:JvmExposeBoxed public val Sunday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(SUNDAY_VALUE)

        /**
         * Creates a weekday from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): RecurrenceRuleWeekday = RecurrenceRuleWeekday(value)
    }

    override fun toString(): String = "RecurrenceRuleWeekday(value=$value)"
}

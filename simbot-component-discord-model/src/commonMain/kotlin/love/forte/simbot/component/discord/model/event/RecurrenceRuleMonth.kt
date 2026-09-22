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
 * [Recurrence Rule Month](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-recurrence-rule-object-guild-scheduled-event-recurrence-rule-month).
 *
 * Represents a month in a scheduled event recurrence rule.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord month value from 1 through 12.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class RecurrenceRuleMonth private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw January value.
         */
        public const val JANUARY_VALUE: Int = 1

        /**
         * Raw February value.
         */
        public const val FEBRUARY_VALUE: Int = 2

        /**
         * Raw March value.
         */
        public const val MARCH_VALUE: Int = 3

        /**
         * Raw April value.
         */
        public const val APRIL_VALUE: Int = 4

        /**
         * Raw May value.
         */
        public const val MAY_VALUE: Int = 5

        /**
         * Raw June value.
         */
        public const val JUNE_VALUE: Int = 6

        /**
         * Raw July value.
         */
        public const val JULY_VALUE: Int = 7

        /**
         * Raw August value.
         */
        public const val AUGUST_VALUE: Int = 8

        /**
         * Raw September value.
         */
        public const val SEPTEMBER_VALUE: Int = 9

        /**
         * Raw October value.
         */
        public const val OCTOBER_VALUE: Int = 10

        /**
         * Raw November value.
         */
        public const val NOVEMBER_VALUE: Int = 11

        /**
         * Raw December value.
         */
        public const val DECEMBER_VALUE: Int = 12


        /**
         * January.
         */
        @JvmStatic @get:JvmExposeBoxed public val January: RecurrenceRuleMonth = RecurrenceRuleMonth(JANUARY_VALUE)
        /**
         * February.
         */
        @JvmStatic @get:JvmExposeBoxed public val February: RecurrenceRuleMonth = RecurrenceRuleMonth(FEBRUARY_VALUE)
        /**
         * March.
         */
        @JvmStatic @get:JvmExposeBoxed public val March: RecurrenceRuleMonth = RecurrenceRuleMonth(MARCH_VALUE)
        /**
         * April.
         */
        @JvmStatic @get:JvmExposeBoxed public val April: RecurrenceRuleMonth = RecurrenceRuleMonth(APRIL_VALUE)
        /**
         * May.
         */
        @JvmStatic @get:JvmExposeBoxed public val May: RecurrenceRuleMonth = RecurrenceRuleMonth(MAY_VALUE)
        /**
         * June.
         */
        @JvmStatic @get:JvmExposeBoxed public val June: RecurrenceRuleMonth = RecurrenceRuleMonth(JUNE_VALUE)
        /**
         * July.
         */
        @JvmStatic @get:JvmExposeBoxed public val July: RecurrenceRuleMonth = RecurrenceRuleMonth(JULY_VALUE)
        /**
         * August.
         */
        @JvmStatic @get:JvmExposeBoxed public val August: RecurrenceRuleMonth = RecurrenceRuleMonth(AUGUST_VALUE)
        /**
         * September.
         */
        @JvmStatic @get:JvmExposeBoxed public val September: RecurrenceRuleMonth = RecurrenceRuleMonth(SEPTEMBER_VALUE)
        /**
         * October.
         */
        @JvmStatic @get:JvmExposeBoxed public val October: RecurrenceRuleMonth = RecurrenceRuleMonth(OCTOBER_VALUE)
        /**
         * November.
         */
        @JvmStatic @get:JvmExposeBoxed public val November: RecurrenceRuleMonth = RecurrenceRuleMonth(NOVEMBER_VALUE)
        /**
         * December.
         */
        @JvmStatic @get:JvmExposeBoxed public val December: RecurrenceRuleMonth = RecurrenceRuleMonth(DECEMBER_VALUE)

        /**
         * Creates a month from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): RecurrenceRuleMonth = RecurrenceRuleMonth(value)
    }

    override fun toString(): String = "RecurrenceRuleMonth(value=$value)"
}

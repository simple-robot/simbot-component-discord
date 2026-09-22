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
 * [Recurrence Rule Frequency](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-recurrence-rule-object-guild-scheduled-event-recurrence-rule-frequency).
 *
 * Represents the base interval unit of a scheduled event recurrence rule.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord recurrence frequency value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class RecurrenceRuleFrequency private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw yearly recurrence value.
         */
        public const val YEARLY_VALUE: Int = 0


        /**
         * Raw monthly recurrence value.
         */
        public const val MONTHLY_VALUE: Int = 1


        /**
         * Raw weekly recurrence value.
         */
        public const val WEEKLY_VALUE: Int = 2


        /**
         * Raw daily recurrence value.
         */
        public const val DAILY_VALUE: Int = 3


        /**
         * A yearly recurrence.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Yearly: RecurrenceRuleFrequency = RecurrenceRuleFrequency(YEARLY_VALUE)

        /**
         * A monthly recurrence.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Monthly: RecurrenceRuleFrequency = RecurrenceRuleFrequency(MONTHLY_VALUE)

        /**
         * A weekly recurrence.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Weekly: RecurrenceRuleFrequency = RecurrenceRuleFrequency(WEEKLY_VALUE)

        /**
         * A daily recurrence.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Daily: RecurrenceRuleFrequency = RecurrenceRuleFrequency(DAILY_VALUE)

        /**
         * Creates a frequency from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): RecurrenceRuleFrequency = RecurrenceRuleFrequency(value)
    }

    override fun toString(): String = "RecurrenceRuleFrequency(value=$value)"
}

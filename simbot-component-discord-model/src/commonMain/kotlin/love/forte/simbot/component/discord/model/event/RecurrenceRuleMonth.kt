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
        /** January. */
        @JvmStatic @get:JvmExposeBoxed public val January: RecurrenceRuleMonth = RecurrenceRuleMonth(1)
        /** February. */
        @JvmStatic @get:JvmExposeBoxed public val February: RecurrenceRuleMonth = RecurrenceRuleMonth(2)
        /** March. */
        @JvmStatic @get:JvmExposeBoxed public val March: RecurrenceRuleMonth = RecurrenceRuleMonth(3)
        /** April. */
        @JvmStatic @get:JvmExposeBoxed public val April: RecurrenceRuleMonth = RecurrenceRuleMonth(4)
        /** May. */
        @JvmStatic @get:JvmExposeBoxed public val May: RecurrenceRuleMonth = RecurrenceRuleMonth(5)
        /** June. */
        @JvmStatic @get:JvmExposeBoxed public val June: RecurrenceRuleMonth = RecurrenceRuleMonth(6)
        /** July. */
        @JvmStatic @get:JvmExposeBoxed public val July: RecurrenceRuleMonth = RecurrenceRuleMonth(7)
        /** August. */
        @JvmStatic @get:JvmExposeBoxed public val August: RecurrenceRuleMonth = RecurrenceRuleMonth(8)
        /** September. */
        @JvmStatic @get:JvmExposeBoxed public val September: RecurrenceRuleMonth = RecurrenceRuleMonth(9)
        /** October. */
        @JvmStatic @get:JvmExposeBoxed public val October: RecurrenceRuleMonth = RecurrenceRuleMonth(10)
        /** November. */
        @JvmStatic @get:JvmExposeBoxed public val November: RecurrenceRuleMonth = RecurrenceRuleMonth(11)
        /** December. */
        @JvmStatic @get:JvmExposeBoxed public val December: RecurrenceRuleMonth = RecurrenceRuleMonth(12)

        /** Creates a month from a raw Discord value. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): RecurrenceRuleMonth = RecurrenceRuleMonth(value)
    }

    override fun toString(): String = "RecurrenceRuleMonth(value=$value)"
}

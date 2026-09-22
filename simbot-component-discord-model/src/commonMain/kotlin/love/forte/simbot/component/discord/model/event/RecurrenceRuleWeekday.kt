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
        /** Monday. */
        @JvmStatic @get:JvmExposeBoxed public val Monday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(0)
        /** Tuesday. */
        @JvmStatic @get:JvmExposeBoxed public val Tuesday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(1)
        /** Wednesday. */
        @JvmStatic @get:JvmExposeBoxed public val Wednesday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(2)
        /** Thursday. */
        @JvmStatic @get:JvmExposeBoxed public val Thursday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(3)
        /** Friday. */
        @JvmStatic @get:JvmExposeBoxed public val Friday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(4)
        /** Saturday. */
        @JvmStatic @get:JvmExposeBoxed public val Saturday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(5)
        /** Sunday. */
        @JvmStatic @get:JvmExposeBoxed public val Sunday: RecurrenceRuleWeekday = RecurrenceRuleWeekday(6)

        /** Creates a weekday from a raw Discord value. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): RecurrenceRuleWeekday = RecurrenceRuleWeekday(value)
    }

    override fun toString(): String = "RecurrenceRuleWeekday(value=$value)"
}

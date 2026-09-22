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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Guild Scheduled Event Recurrence Rule Object](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-recurrence-rule-object).
 *
 * Describes a supported subset of iCalendar recurrence behavior for a guild
 * scheduled event.
 *
 * @property start The beginning of the recurrence interval.
 * @property end The end of the recurrence interval.
 * @property frequency The base recurrence frequency.
 * @property interval The spacing between occurrences in frequency units.
 * @property byWeekday Specific weekdays on which the event recurs.
 * @property byNWeekday Specific weekdays within selected weeks of a month.
 * @property byMonth Specific months in which the event recurs.
 * @property byMonthDay Specific dates within a month.
 * @property byYearDay Specific dates within a year.
 * @property count The maximum number of occurrences.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class GuildScheduledEventRecurrenceRule internal constructor(
    public val start: Instant,
    public val end: Instant?,
    @get:JvmExposeBoxed
    public val frequency: RecurrenceRuleFrequency,
    public val interval: Int,
    @SerialName("by_weekday")
    public val byWeekday: List<RecurrenceRuleWeekday>?,
    @SerialName("by_n_weekday")
    public val byNWeekday: List<RecurrenceRuleNWeekday>?,
    @SerialName("by_month")
    public val byMonth: List<RecurrenceRuleMonth>?,
    @SerialName("by_month_day")
    public val byMonthDay: List<Int>?,
    @SerialName("by_year_day")
    public val byYearDay: List<Int>?,
    public val count: Int?,
) {
    override fun toString(): String =
        "GuildScheduledEventRecurrenceRule(start=$start, frequency=$frequency, " +
            "interval=$interval)"
}

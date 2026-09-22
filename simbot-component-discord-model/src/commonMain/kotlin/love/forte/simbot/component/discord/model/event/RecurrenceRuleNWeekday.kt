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

/**
 * [Recurrence Rule N-Weekday Structure](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-recurrence-rule-object-guild-scheduled-event-recurrence-rule-nweekday-structure).
 *
 * Selects a weekday within a specific week of a month.
 *
 * @property n The one-based week number, from 1 through 5.
 * @property day The weekday within that week.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class RecurrenceRuleNWeekday internal constructor(
    public val n: Int,
    @get:JvmExposeBoxed
    public val day: RecurrenceRuleWeekday,
) {
    override fun toString(): String = "RecurrenceRuleNWeekday(n=$n, day=$day)"
}

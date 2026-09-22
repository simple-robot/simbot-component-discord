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
@file:JvmName("RecurrenceRuleWeekdayJvmKt")

package love.forte.simbot.component.discord.model.event

import java.time.DayOfWeek

/**
 * Converts this [RecurrenceRuleWeekday] instance to its corresponding [DayOfWeek] in the Java Time API.
 *
 * @return The [DayOfWeek] that corresponds to this [RecurrenceRuleWeekday].
 * For example, [RecurrenceRuleWeekday.MONDAY] maps to [DayOfWeek.MONDAY].
 */
public fun RecurrenceRuleWeekday.toJavaDayOfWeek(): DayOfWeek = DayOfWeek.entries[ordinal]

/**
 * Converts this [DayOfWeek] instance to its corresponding [RecurrenceRuleWeekday] in the Discord API.
 *
 * @return The [RecurrenceRuleWeekday] that corresponds to this [DayOfWeek].
 * For example, [DayOfWeek.MONDAY] maps to [RecurrenceRuleWeekday.MONDAY].
 */
public fun DayOfWeek.toRecurrenceRuleWeekday(): RecurrenceRuleWeekday = RecurrenceRuleWeekday.entries[ordinal]

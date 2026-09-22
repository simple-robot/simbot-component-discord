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

@file:JvmName("RecurrenceRuleMonthJvmKt")

package love.forte.simbot.component.discord.model.event

import java.time.Month

/**
 * Converts this [RecurrenceRuleMonth] instance to its corresponding [Month] in the Java Time API.
 *
 * @return The [Month] that corresponds to this [RecurrenceRuleMonth].
 * For example, [RecurrenceRuleMonth.JANUARY] maps to [Month.JANUARY].
 */
public fun RecurrenceRuleMonth.toJavaMonth(): Month = Month.entries[ordinal]

/**
 * Converts this [Month] instance to its corresponding [RecurrenceRuleMonth] in the Discord API.
 *
 * @return The [RecurrenceRuleMonth] that corresponds to this [Month].
 * For example, [Month.JANUARY] maps to [RecurrenceRuleMonth.JANUARY].
 */
public fun Month.toRecurrenceRuleMonth(): RecurrenceRuleMonth = RecurrenceRuleMonth.entries[ordinal]

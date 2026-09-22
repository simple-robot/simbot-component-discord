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

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull

/**
 * Verifies scheduled event payloads based on Discord's
 * [Guild Scheduled Event](https://docs.discord.com/developers/resources/guild-scheduled-event)
 * and published recurrence examples.
 */
class GuildScheduledEventContractTests {
    private val json = Json

    @Test
    fun decodeExternalScheduledEventFromOfficialFieldRequirements() {
        val event = json.decodeFromString<GuildScheduledEvent>(
            """
            {
              "id": "100000000000000001",
              "guild_id": "100000000000000002",
              "channel_id": null,
              "name": "Community meetup",
              "description": "An externally hosted event",
              "scheduled_start_time": "2026-10-01T12:00:00Z",
              "scheduled_end_time": "2026-10-01T14:00:00Z",
              "privacy_level": 2,
              "status": 1,
              "entity_type": 3,
              "entity_id": null,
              "entity_metadata": {"location": "Community Hall"},
              "recurrence_rule": null
            }
            """.trimIndent(),
        )

        assertNull(event.channelId)
        assertEquals(GuildScheduledEventEntityType.External, event.entityType)
        assertEquals("Community Hall", event.entityMetadata?.location)
        assertEquals(GuildScheduledEventStatus.Scheduled, event.status)
    }

    @Test
    fun decodeOfficialMonthlyFourthWednesdayRecurrenceExample() {
        val recurrence = json.decodeFromString<GuildScheduledEventRecurrenceRule>(
            """
            {
              "start": "2026-10-01T12:00:00Z",
              "end": null,
              "frequency": 1,
              "interval": 1,
              "by_weekday": null,
              "by_n_weekday": [{"n": 4, "day": 2}],
              "by_month": null,
              "by_month_day": null,
              "by_year_day": null,
              "count": null
            }
            """.trimIndent(),
        )

        assertEquals(RecurrenceRuleFrequency.Monthly, recurrence.frequency)
        assertEquals(4, recurrence.byNWeekday?.single()?.n)
        assertEquals(RecurrenceRuleWeekday.Wednesday, recurrence.byNWeekday?.single()?.day)
    }
}

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

package love.forte.simbot.component.discord.model.stage

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse

/**
 * Uses Discord's
 * [Example Stage Instance](https://docs.discord.com/developers/resources/stage-instance#stage-instance-object).
 */
class StageInstanceOfficialFixtureTests {
    @Test
    fun decodeOfficialStageInstanceExample() {
        val stage = Json.decodeFromString<StageInstance>(
            """
            {
              "id": "840647391636226060",
              "guild_id": "197038439483310086",
              "channel_id": "733488538393510049",
              "topic": "Testing Testing, 123",
              "privacy_level": 1,
              "discoverable_disabled": false,
              "guild_scheduled_event_id": "947656305244532806"
            }
            """.trimIndent(),
        )

        assertEquals("840647391636226060", stage.id.stringValue)
        assertEquals(StagePrivacyLevel.Public, stage.privacyLevel)
        assertFalse(stage.discoverableDisabled)
        assertEquals("947656305244532806", stage.guildScheduledEventId?.stringValue)
    }
}

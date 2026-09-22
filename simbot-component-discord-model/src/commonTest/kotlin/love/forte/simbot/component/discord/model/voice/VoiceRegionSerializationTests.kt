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

package love.forte.simbot.component.discord.model.voice

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Verifies the field contract from Discord's
 * [Voice Region Object](https://docs.discord.com/developers/resources/voice#voice-region-object).
 * Discord does not currently publish a JSON example for this object.
 */
class VoiceRegionSerializationTests {
    @Test
    fun decodeVoiceRegionFromDocumentedStructure() {
        val region = Json.decodeFromString<VoiceRegion>(
            """
            {
              "id": "us-west",
              "name": "US West",
              "optimal": true,
              "deprecated": false,
              "custom": false
            }
            """.trimIndent(),
        )

        assertEquals("us-west", region.id)
        assertEquals("US West", region.name)
        assertTrue(region.optimal)
        assertFalse(region.deprecated)
        assertFalse(region.custom)
    }
}

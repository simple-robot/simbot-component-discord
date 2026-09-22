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

package love.forte.simbot.component.discord.model

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.time.Duration.Companion.seconds

/**
 * Uses Discord's official
 * [user rate-limit example](https://docs.discord.com/developers/topics/rate-limits#exceeding-a-rate-limit).
 */
class RateLimitResponseOfficialFixtureTests {
    @Test
    fun decodeOfficialExceededUserRateLimitResponse() {
        val response = Json.decodeFromString<RateLimitResponse>(
            """
            {
              "message": "You are being rate limited.",
              "retry_after": 64.57,
              "global": false
            }
            """.trimIndent(),
        )

        assertEquals("You are being rate limited.", response.message)
        assertEquals(64.57, response.retryAfter)
        assertEquals(64.57.seconds, response.retryAfterDuration)
        assertFalse(response.global)
        assertEquals(null, response.code)
    }
}

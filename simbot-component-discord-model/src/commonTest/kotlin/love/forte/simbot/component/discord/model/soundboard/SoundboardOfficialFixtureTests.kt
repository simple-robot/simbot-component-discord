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

package love.forte.simbot.component.discord.model.soundboard

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNull
import kotlin.test.assertTrue

/**
 * Uses Discord's
 * [Example Default Soundboard Sound](https://docs.discord.com/developers/resources/soundboard#soundboard-sound-object).
 */
class SoundboardOfficialFixtureTests {
    @Test
    fun decodeOfficialDefaultSoundboardSoundExample() {
        val sound = Json.decodeFromString<SoundboardSound>(
            """
            {
              "name": "quack",
              "sound_id": "1",
              "volume": 1.0,
              "emoji_id": null,
              "emoji_name": "🦆",
              "available": true
            }
            """.trimIndent(),
        )

        assertEquals("1", sound.soundId.stringValue)
        assertEquals("quack", sound.name)
        assertNull(sound.emojiId)
        assertEquals("🦆", sound.emojiName)
        assertTrue(sound.available)
    }
}

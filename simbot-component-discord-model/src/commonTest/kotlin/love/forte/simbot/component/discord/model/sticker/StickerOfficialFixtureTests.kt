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

package love.forte.simbot.component.discord.model.sticker

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

/**
 * Verifies the top-level sticker contract with Discord's
 * [Example Sticker](https://docs.discord.com/developers/resources/sticker#sticker-object).
 */
class StickerOfficialFixtureTests {
    @Test
    fun decodeOfficialStickerExample() {
        val sticker = Json.decodeFromString<Sticker>(
            """
            {
              "id": "749054660769218631",
              "name": "Wave",
              "tags": "wumpus, hello, wave",
              "type": 1,
              "format_type": 3,
              "description": "Wumpus waves hello",
              "pack_id": "847199849233514549",
              "sort_value": 12
            }
            """.trimIndent(),
        )

        // The official tag list is abbreviated because tags are an opaque string.
        assertEquals("749054660769218631", sticker.id.stringValue)
        assertEquals(StickerType.Standard, sticker.type)
        assertEquals(StickerFormatType.Lottie, sticker.formatType)
        assertEquals(12, sticker.sortValue)
    }
}

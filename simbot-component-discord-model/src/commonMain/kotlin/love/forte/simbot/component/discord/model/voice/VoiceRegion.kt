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

import kotlinx.serialization.Serializable

/**
 * [Voice Region Object](https://docs.discord.com/developers/resources/voice#voice-region-object).
 *
 * Describes a Discord voice region available for voice or stage channels.
 *
 * @property id The unique voice region ID.
 * @property name The human-readable voice region name.
 * @property optimal Whether the region is closest to the current user's client.
 * @property deprecated Whether applications should avoid selecting this region.
 * @property custom Whether this is a custom region for an event or similar use.
 */
@Serializable
public class VoiceRegion internal constructor(
    public val id: String,
    public val name: String,
    public val optimal: Boolean,
    public val deprecated: Boolean,
    public val custom: Boolean,
) {
    override fun toString(): String =
        "VoiceRegion(id=$id, name=$name, optimal=$optimal)"
}

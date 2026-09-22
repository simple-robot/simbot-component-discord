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

package love.forte.simbot.component.discord.model.guild

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

/**
 * [Incidents Data Object](https://docs.discord.com/developers/resources/guild#incidents-data-object).
 *
 * Describes temporary guild incident actions and the most recently detected
 * direct-message spam or raid signals.
 *
 * @property invitesDisabledUntil When guild invites become enabled again.
 * @property dmsDisabledUntil When direct messages to guild members become enabled again.
 * @property dmSpamDetectedAt When direct-message spam was detected, when included.
 * @property raidDetectedAt When a raid was detected, when included.
 */
@Serializable
public class IncidentsData internal constructor(
    @SerialName("invites_disabled_until")
    public val invitesDisabledUntil: Instant?,
    @SerialName("dms_disabled_until")
    public val dmsDisabledUntil: Instant?,
    @SerialName("dm_spam_detected_at")
    public val dmSpamDetectedAt: Instant? = null,
    @SerialName("raid_detected_at")
    public val raidDetectedAt: Instant? = null,
) {
    override fun toString(): String =
        "IncidentsData(invitesDisabledUntil=$invitesDisabledUntil, " +
            "dmsDisabledUntil=$dmsDisabledUntil)"
}

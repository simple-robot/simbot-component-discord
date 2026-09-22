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

package love.forte.simbot.component.discord.model.channel

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlin.time.Instant

/**
 * [Thread Metadata Object](https://docs.discord.com/developers/resources/channel#thread-metadata-object).
 *
 * Contains thread state and archival settings that do not apply to other
 * channel types.
 *
 * @property archived Whether the thread is archived.
 * @property autoArchiveDuration Minutes of inactivity before automatic archival.
 * @property archiveTimestamp When the thread's archive state was last updated.
 * @property locked Whether the thread is locked and requires MANAGE_THREADS to
 * unarchive.
 * @property invitable Whether non-moderators can invite users to a private thread.
 * @property createTimestamp When the thread was created, when provided by Discord.
 */
@Serializable
public class ThreadMetadata internal constructor(
    public val archived: Boolean,
    @SerialName("auto_archive_duration")
    public val autoArchiveDuration: AutoArchiveDuration,
    @SerialName("archive_timestamp")
    public val archiveTimestamp: Instant,
    public val locked: Boolean,
    public val invitable: Boolean? = null,
    @SerialName("create_timestamp")
    public val createTimestamp: Instant? = null,
) {
    override fun toString(): String =
        "ThreadMetadata(archived=$archived, " +
            "autoArchiveDuration=$autoArchiveDuration, locked=$locked)"
}

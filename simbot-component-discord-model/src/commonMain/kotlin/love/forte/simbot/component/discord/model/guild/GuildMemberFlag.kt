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

import kotlin.jvm.JvmExposeBoxed

/**
 * A known [guild member flag](https://docs.discord.com/developers/resources/guild#guild-member-object-guild-member-flags).
 *
 * @property flag The bit represented by this flag.
 */
@OptIn(ExperimentalStdlibApi::class)
public enum class GuildMemberFlag(
    @get:JvmExposeBoxed
    public val flag: GuildMemberFlags,
) {
    /** The member has left and rejoined the guild. */
    DID_REJOIN(GuildMemberFlags.of(1L shl 0)),

    /** The member has completed guild onboarding. */
    COMPLETED_ONBOARDING(GuildMemberFlags.of(1L shl 1)),

    /** The member is exempt from guild verification requirements. */
    BYPASSES_VERIFICATION(GuildMemberFlags.of(1L shl 2)),

    /** The member has started guild onboarding. */
    STARTED_ONBOARDING(GuildMemberFlags.of(1L shl 3)),

    /** The member is a voice-channel guest. */
    IS_GUEST(GuildMemberFlags.of(1L shl 4)),

    /** The member has started Server Guide home actions. */
    STARTED_HOME_ACTIONS(GuildMemberFlags.of(1L shl 5)),

    /** The member has completed Server Guide home actions. */
    COMPLETED_HOME_ACTIONS(GuildMemberFlags.of(1L shl 6)),

    /** AutoMod has quarantined the member's username or display name. */
    AUTOMOD_QUARANTINED_USERNAME(GuildMemberFlags.of(1L shl 7)),

    /** The member has dismissed the direct-message settings upsell. */
    DM_SETTINGS_UPSELL_ACKNOWLEDGED(GuildMemberFlags.of(1L shl 9)),

    /** AutoMod has quarantined the member's guild tag. */
    AUTOMOD_QUARANTINED_GUILD_TAG(GuildMemberFlags.of(1L shl 10));

    /** The raw bit represented by [flag]. */
    public val flagValue: Long get() = flag.value
}

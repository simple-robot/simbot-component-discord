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

package love.forte.simbot.component.discord.api.team

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Team Membership State Enum](https://docs.discord.com/developers/topics/teams#data-models-team-membership-state-enum).
 *
 * Represents the membership state of a developer team member.
 *
 * @property value The raw Discord membership state value.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class TeamMembershipState private constructor(public val value: Int) {
    public companion object {
        /**
         * Raw value for an invited team member.
         */
        public const val INVITED_VALUE: Int = 1

        /**
         * Raw value for an accepted team member.
         */
        public const val ACCEPTED_VALUE: Int = 2

        /**
         * The member has been invited but has not accepted.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Invited: TeamMembershipState = TeamMembershipState(INVITED_VALUE)

        /**
         * The member has accepted the invitation.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Accepted: TeamMembershipState = TeamMembershipState(ACCEPTED_VALUE)

        /**
         * Creates a [TeamMembershipState] from a raw Discord value.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: Int): TeamMembershipState = TeamMembershipState(value)
    }

    override fun toString(): String =
        "TeamMembershipState(value=$value)"
}

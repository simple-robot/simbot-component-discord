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
 * A known [role flag](https://docs.discord.com/developers/topics/permissions#role-object-role-flags).
 *
 * @property flag The bit represented by this flag.
 */
@OptIn(ExperimentalStdlibApi::class)
public enum class RoleFlag(
    @get:JvmExposeBoxed
    public val flag: RoleFlags,
) {
    /** The role can be selected by members in an onboarding prompt. */
    IN_PROMPT(RoleFlags.of(1L shl 0));

    /** The raw bit represented by [flag]. */
    public val flagValue: Long get() = flag.value
}

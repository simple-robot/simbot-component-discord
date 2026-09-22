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

package love.forte.simbot.component.discord.model.permission

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PermissionTests {

    @Test
    fun permissionValuesAreDistinctSingleBits() {
        val permissions = Permission.entries

        assertEquals(52, permissions.size)
        assertEquals(permissions.size, permissions.map { it.flagValue }.toSet().size)
        assertTrue(permissions.all { it.flagValue > 0L && it.flagValue and (it.flagValue - 1L) == 0L })
        assertFalse(permissions.any { it.flagValue == (1L shl 47) })
        assertEquals(1L shl 52, Permission.BYPASS_SLOWMODE.flagValue)
    }

    @Test
    fun permissionFlagCanBeCombinedRemovedAndChecked() {
        val invite = Permission.CREATE_INSTANT_INVITE
        val messages = Permission.SEND_MESSAGES
        val required = invite.flag + messages

        assertEquals(invite.flagValue or messages.flagValue, required.value)
        assertTrue(invite in required)
        assertTrue(required.contains(messages.flag))
        assertTrue(required.contains(required, exactly = true))
        assertFalse(required.contains(invite, exactly = true))
        assertTrue(required.intersects(messages))
        assertFalse(required.intersects(Permissions.None))

        assertEquals(messages.flagValue, (required - invite).value)
        assertEquals(Permissions.None, required - invite - messages)
        assertTrue(Permissions.None.isEmpty)
        assertFalse(required.isEmpty)
    }
}

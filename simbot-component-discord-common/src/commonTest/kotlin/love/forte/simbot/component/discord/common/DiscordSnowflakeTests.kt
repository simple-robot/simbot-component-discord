package love.forte.simbot.component.discord.common

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Instant


/**
 * 
 * @author ForteScarlet 
 */
class DiscordSnowflakeTests {

    @Test
    fun testDiscordSnowflake() {
        val snowflake = 175928847299117063u.toDiscordSnowflake()
        assertEquals(1462015105796L, snowflake.timestamp)
        assertEquals(Instant.parse("2016-04-30T11:18:25.796Z"), snowflake.instant)
        assertEquals(1, snowflake.internalWorkerId)
        assertEquals(0, snowflake.internalProcessId)
        assertEquals(7, snowflake.increment)
    }
}

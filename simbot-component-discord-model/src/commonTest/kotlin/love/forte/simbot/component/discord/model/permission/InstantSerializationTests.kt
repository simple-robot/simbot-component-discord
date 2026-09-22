package love.forte.simbot.component.discord.model.permission

import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.time.Instant


/**
 * 
 * @author ForteScarlet 
 */
class InstantSerializationTests {

    @Serializable
    data class InstantTest(val instant: Instant)

    @Test
    fun deserializeIsoUtc1() {
        val jsonStr = """
            {"instant": "2023-07-01T12:00:00Z"}
        """
        val deserialized = Json.decodeFromString<InstantTest>(jsonStr)
        assertEquals(Instant.parse("2023-07-01T12:00:00Z"), deserialized.instant)
    }

    @Test
    fun deserializeIsoUtc2() {
        val jsonStr = """
            {"instant": "2023-07-01T12:00:00.000Z"}
        """
        val deserialized = Json.decodeFromString<InstantTest>(jsonStr)
        assertEquals(Instant.parse("2023-07-01T12:00:00Z"), deserialized.instant)
    }

    @Test
    fun deserializeIsoEast8() {
        val jsonStr = """
            {"instant": "2023-07-01T12:00:00.000+08:00"}
        """
        val deserialized = Json.decodeFromString<InstantTest>(jsonStr)
        assertEquals(Instant.parse("2023-07-01T12:00:00+08:00"), deserialized.instant)
    }

}

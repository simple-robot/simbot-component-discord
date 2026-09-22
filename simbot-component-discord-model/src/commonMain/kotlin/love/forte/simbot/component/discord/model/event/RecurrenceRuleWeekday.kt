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

package love.forte.simbot.component.discord.model.event

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.SerializationException
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

/**
 * [Recurrence Rule Weekday](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-recurrence-rule-object-guild-scheduled-event-recurrence-rule-weekday).
 *
 * Represents a weekday in a scheduled event recurrence rule.
 *
 * @property value The raw Discord weekday value, where Monday is zero.
 */
@Serializable(RecurrenceRuleWeekdaySerializer::class)
public enum class RecurrenceRuleWeekday(public val value: Int) {
    /**
     * Monday.
     */
    MONDAY(0),

    /**
     * Tuesday.
     */
    TUESDAY(1),

    /**
     * Wednesday.
     */
    WEDNESDAY(2),

    /**
     * Thursday.
     */
    THURSDAY(3),

    /**
     * Friday.
     */
    FRIDAY(4),

    /**
     * Saturday.
     */
    SATURDAY(5),

    /**
     * Sunday.
     */
    SUNDAY(6)
}

/**
 * A serializer for the [RecurrenceRuleWeekday] enum, which represents a weekday in a scheduled event recurrence rule.
 *
 * This serializer handles the mapping between the [RecurrenceRuleWeekday] object and its integer representation as defined by Discord's API.
 * It ensures that only valid weekday values (0 through 6) are serializable and deserializable.
 *
 * - During serialization, the [RecurrenceRuleWeekday] is encoded as an integer corresponding to its `value` property.
 * - During deserialization, the integer value is validated to ensure it represents a valid weekday. If the value is invalid,
 *   a [SerializationException] is thrown.
 *
 * Throws:
 * - [SerializationException] if a deserialized value is outside the valid range of 0 to 6.
 */
internal object RecurrenceRuleWeekdaySerializer : KSerializer<RecurrenceRuleWeekday> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("RecurrenceRuleWeekday", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: RecurrenceRuleWeekday) {
        encoder.encodeInt(value.value)
    }

    override fun deserialize(decoder: Decoder): RecurrenceRuleWeekday {
        val value = decoder.decodeInt()
        if (value !in 0..6) {
            throw SerializationException("Invalid RecurrenceRuleWeekday value: $value")
        }
        return RecurrenceRuleWeekday.entries[value]
    }
}

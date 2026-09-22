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
 * [Recurrence Rule Month](https://docs.discord.com/developers/resources/guild-scheduled-event#guild-scheduled-event-recurrence-rule-object-guild-scheduled-event-recurrence-rule-month).
 *
 * Represents a month in a scheduled event recurrence rule.
 * Unknown values are preserved for forward compatibility.
 *
 * @property value The raw Discord month value from 1 through 12.
 */
@Serializable(RecurrenceRuleMonthSerializer::class)
public enum class RecurrenceRuleMonth(public val value: Int) {
    /**
     * January.
     */
    JANUARY(1),

    /**
     * February.
     */
    FEBRUARY(2),

    /**
     * March.
     */
    MARCH(3),

    /**
     * April.
     */
    APRIL(4),

    /**
     * May.
     */
    MAY(5),

    /**
     * June.
     */
    JUNE(6),

    /**
     * July.
     */
    JULY(7),

    /**
     * August.
     */
    AUGUST(8),

    /**
     * September.
     */
    SEPTEMBER(9),

    /**
     * October.
     */
    OCTOBER(10),

    /**
     * November.
     */
    NOVEMBER(11),

    /**
     * December.
     */
    DECEMBER(12)
}

/**
 * A serializer for the [RecurrenceRuleMonth] enum, which represents a month in a scheduled event recurrence rule.
 *
 * This serializer handles the mapping between the [RecurrenceRuleMonth] object and its integer representation as defined by Discord's API.
 * It ensures that only valid month values (1 through 12) are serializable and deserializable.
 *
 * - During serialization, the [RecurrenceRuleMonth] is encoded as an integer corresponding to its `value` property.
 * - During deserialization, the integer value is validated to ensure it represents a valid month. If the value is invalid,
 *   a [SerializationException] is thrown.
 *
 * Throws:
 * - [SerializationException] if a deserialized value is outside the valid range of 1 to 12.
 */
internal object RecurrenceRuleMonthSerializer : KSerializer<RecurrenceRuleMonth> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("RecurrenceRuleMonth", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: RecurrenceRuleMonth) {
        encoder.encodeInt(value.value)
    }

    override fun deserialize(decoder: Decoder): RecurrenceRuleMonth {
        val value = decoder.decodeInt()
        if (value !in 1..12) {
            throw SerializationException("Invalid RecurrenceRuleMonth value: $value")
        }
        return RecurrenceRuleMonth.entries[value - 1]
    }
}

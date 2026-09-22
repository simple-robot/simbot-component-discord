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
import love.forte.simbot.component.discord.model.user.User
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Channel Object](https://docs.discord.com/developers/resources/channel#channel-object),
 * represents a guild or DM channel within Discord.
 *
 * @property id The ID of this channel
 * @property type The type of this channel
 * @property guildId The ID of the guild. May be missing for some channel objects
 * received over gateway guild dispatches
 * @property position Sorting position of the channel. Channels with the same
 * position are sorted by ID
 * @property permissionOverwrites Explicit permission overwrites for members and roles
 * @property name The name of the channel. 1-100 characters
 * @property topic The channel topic. 0-4096 characters for GUILD_FORUM and
 * GUILD_MEDIA channels, and 0-1024 characters for all other channel types
 * @property nsfw Whether the channel is age-restricted
 * @property lastMessageId The ID of the last message sent in this channel,
 * or thread for GUILD_FORUM or GUILD_MEDIA channels. May not point to an
 * existing or valid message or thread
 * @property bitrate The bitrate, in bits per second, of the voice channel
 * @property userLimit The user limit of the voice channel
 * @property rateLimitPerUser Amount of seconds a user has to wait before sending
 * another message. Valid values are from 0 to 21600. Bots and users with the
 * BYPASS_SLOWMODE permission are unaffected
 * @property recipients The recipients of the DM
 * @property icon Icon hash of the group DM
 * @property ownerId ID of the creator of the group DM or thread
 * @property applicationId Application ID associated with the channel.
 * For group DMs, this is the application that created the group
 * @property managed For group DM channels, whether the channel is managed by an
 * application via the `gdm.join` OAuth2 scope
 * @property parentId For guild channels, the ID of the parent category for the
 * channel. For threads, the ID of the text channel this thread was created in
 * @property lastPinTimestamp When the last pinned message was pinned.
 * May be null in events such as GUILD_CREATE when a message is not pinned
 * @property rtcRegion Voice region ID for the voice channel.
 * Null indicates automatic voice region selection
 * @property videoQualityMode The camera video quality mode of the voice channel.
 * Defaults to AUTO when not present
 * @property messageCount Number of messages in a thread, not including the
 * initial message or deleted messages
 * @property memberCount Approximate count of users in a thread. Stops counting at 50
 * @property threadMetadata Thread-specific fields not needed by other channel types
 * @property member Thread member object for the current user, if they have joined
 * the thread. Only included on certain API endpoints
 * @property defaultAutoArchiveDuration Default automatic archive duration copied
 * onto newly created threads
 * @property permissions Computed permissions for the invoking user in the channel,
 * including overwrites. Only included as part of resolved interaction data.
 * Does not include implicit permissions
 * @property appPermissions Computed permissions for the bot user in the channel,
 * including overwrites. Only included as part of resolved interaction data.
 * Does not include implicit permissions
 * @property flags Channel flags combined as a bitfield
 * @property totalMessageSent Number of messages ever sent in a thread.
 * Unlike messageCount, this value does not decrement when a message is deleted
 * @property availableTags The set of tags that can be used in a GUILD_FORUM
 * or GUILD_MEDIA channel
 * @property appliedTags IDs of the tags that have been applied to a thread in a
 * GUILD_FORUM or GUILD_MEDIA channel
 * @property defaultReactionEmoji The emoji shown in the add reaction button on
 * a thread in a GUILD_FORUM or GUILD_MEDIA channel
 * @property defaultThreadRateLimitPerUser Initial rate_limit_per_user to set on
 * newly created threads. This value is copied to a thread when it is created
 * and does not live update
 * @property defaultSortOrder Default sort order used to order posts in
 * GUILD_FORUM and GUILD_MEDIA channels. Null means no preferred sort order has
 * been configured by a channel administrator
 * @property defaultForumLayout Default forum layout used to display posts in a
 * GUILD_FORUM channel
 *
 * @author ForteScarlet
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Channel internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,

    @get:JvmExposeBoxed
    public val type: ChannelType,

    @SerialName("guild_id")
    @get:JvmExposeBoxed
    public val guildId: DiscordId? = null,

    public val position: Int? = null,

    @SerialName("permission_overwrites")
    public val permissionOverwrites: List<PermissionOverwrite>? = null,

    public val name: String? = null,

    public val topic: String? = null,

    public val nsfw: Boolean? = null,

    @SerialName("last_message_id")
    @get:JvmExposeBoxed
    public val lastMessageId: DiscordId? = null,

    public val bitrate: Int? = null,

    @SerialName("user_limit")
    public val userLimit: Int? = null,

    @SerialName("rate_limit_per_user")
    public val rateLimitPerUser: Int? = null,

    public val recipients: List<User>? = null,

    public val icon: String? = null,

    @SerialName("owner_id")
    @get:JvmExposeBoxed
    public val ownerId: DiscordId? = null,

    @SerialName("application_id")
    @get:JvmExposeBoxed
    public val applicationId: DiscordId? = null,

    public val managed: Boolean? = null,

    @SerialName("parent_id")
    @get:JvmExposeBoxed
    public val parentId: DiscordId? = null,

    @SerialName("last_pin_timestamp")
    public val lastPinTimestamp: Instant? = null,

    @SerialName("rtc_region")
    public val rtcRegion: String? = null,

    @SerialName("video_quality_mode")
    @get:JvmExposeBoxed
    public val videoQualityMode: VideoQualityMode? = null,

    @SerialName("message_count")
    public val messageCount: Int? = null,

    @SerialName("member_count")
    public val memberCount: Int? = null,

    @SerialName("thread_metadata")
    public val threadMetadata: ThreadMetadata? = null,

    public val member: ThreadMember? = null,

    @SerialName("default_auto_archive_duration")
    @get:JvmExposeBoxed
    public val defaultAutoArchiveDuration: AutoArchiveDuration? = null,

    public val permissions: String? = null,

    @SerialName("app_permissions")
    public val appPermissions: String? = null,

    @get:JvmExposeBoxed
    public val flags: ChannelFlags? = null,

    @SerialName("total_message_sent")
    public val totalMessageSent: Int? = null,

    @SerialName("available_tags")
    public val availableTags: List<ForumTag>? = null,

    @SerialName("applied_tags")
    public val appliedTags: List<DiscordId>? = null,

    @SerialName("default_reaction_emoji")
    public val defaultReactionEmoji: DefaultReaction? = null,

    @SerialName("default_thread_rate_limit_per_user")
    public val defaultThreadRateLimitPerUser: Int? = null,

    @SerialName("default_sort_order")
    @get:JvmExposeBoxed
    public val defaultSortOrder: SortOrderType? = null,

    @SerialName("default_forum_layout")
    @get:JvmExposeBoxed
    public val defaultForumLayout: ForumLayoutType? = null,
) {
    override fun toString(): String =
        "Channel(id=$id, type=$type, name=$name)"
}

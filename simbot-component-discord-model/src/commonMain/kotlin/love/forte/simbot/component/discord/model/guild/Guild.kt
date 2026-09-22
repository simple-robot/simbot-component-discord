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

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonObject
import love.forte.simbot.component.discord.model.channel.Channel
import love.forte.simbot.component.discord.model.emoji.Emoji
import love.forte.simbot.component.discord.model.event.GuildScheduledEvent
import love.forte.simbot.component.discord.model.permission.Permissions
import love.forte.simbot.component.discord.model.soundboard.SoundboardSound
import love.forte.simbot.component.discord.model.stage.StageInstance
import love.forte.simbot.component.discord.model.sticker.Sticker
import love.forte.simbot.component.discord.model.voice.VoiceState
import love.forte.simbot.component.discord.common.DiscordId
import kotlin.jvm.JvmExposeBoxed
import kotlin.time.Instant

/**
 * [Guild Object](https://docs.discord.com/developers/resources/guild#guild-object).
 *
 * Represents an isolated collection of Discord users and channels, commonly
 * called a server in the Discord client. Optional fields depend on the endpoint
 * and request options used to obtain the guild. Guild Create Gateway payloads
 * use this object with additional initial-state fields.
 *
 * @property id The guild ID.
 * @property name The guild name.
 * @property icon The guild icon hash.
 * @property iconHash The icon hash included by guild template payloads.
 * @property splash The guild invite splash hash.
 * @property discoverySplash The discovery splash hash.
 * @property owner Whether the requesting user owns the guild.
 * @property ownerId The guild owner ID.
 * @property permissions The requesting user's total guild permissions.
 * @property region The deprecated guild voice region ID.
 * @property afkChannelId The AFK voice channel ID.
 * @property afkTimeout The AFK timeout in seconds.
 * @property widgetEnabled Whether the guild widget is enabled.
 * @property widgetChannelId The channel used by the guild widget invite.
 * @property verificationLevel The guild verification requirement.
 * @property defaultMessageNotifications The default member notification level.
 * @property explicitContentFilter The guild media scanning level.
 * @property roles The roles defined in the guild.
 * @property emojis The guild's custom emojis.
 * @property features The enabled guild features.
 * @property mfaLevel The MFA requirement for moderation actions.
 * @property applicationId The creator application ID for a bot-created guild.
 * @property systemChannelId The guild system notices channel ID.
 * @property systemChannelFlags Notices suppressed in the system channel.
 * @property rulesChannelId The Community guild rules channel ID.
 * @property maxPresences The maximum presence count, when provided.
 * @property maxMembers The maximum member count, when provided.
 * @property vanityUrlCode The guild vanity URL code.
 * @property description The guild description.
 * @property banner The guild banner hash.
 * @property premiumTier The guild's Server Boost level.
 * @property premiumSubscriptionCount The current Server Boost count.
 * @property preferredLocale The preferred locale for Community guild notices.
 * @property publicUpdatesChannelId The Community public updates channel ID.
 * @property maxVideoChannelUsers The maximum users in a video channel.
 * @property maxStageVideoChannelUsers The maximum users in a stage video channel.
 * @property approximateMemberCount The approximate member count when requested.
 * @property approximatePresenceCount The approximate online count when requested.
 * @property welcomeScreen The Community guild welcome screen.
 * @property nsfwLevel The guild age-restriction level.
 * @property stickers The guild's custom stickers, when included.
 * @property premiumProgressBarEnabled Whether the boost progress bar is enabled.
 * @property safetyAlertsChannelId The Community safety alerts channel ID.
 * @property incidentsData The guild's current incident state.
 * @property joinedAt When the current user joined the guild in Guild Create.
 * @property large Whether Discord considers this a large guild.
 * @property unavailable Whether the guild is unavailable because of an outage.
 * @property memberCount The total member count in Guild Create.
 * @property voiceStates Current voice states included by Guild Create.
 * @property members Guild members included by Guild Create and active intents.
 * @property channels Guild channels included by Guild Create.
 * @property threads Visible active threads included by Guild Create.
 * @property presences Presence payloads included by Guild Create.
 * @property stageInstances Live stage instances included by Guild Create.
 * @property guildScheduledEvents Scheduled events included by Guild Create.
 * @property soundboardSounds Guild soundboard sounds included by Guild Create.
 */
@OptIn(ExperimentalStdlibApi::class)
@Serializable
public class Guild internal constructor(
    @get:JvmExposeBoxed
    public val id: DiscordId,
    public val name: String,
    public val icon: String?,
    @SerialName("icon_hash")
    public val iconHash: String? = null,
    public val splash: String?,
    @SerialName("discovery_splash")
    public val discoverySplash: String?,
    public val owner: Boolean? = null,
    @SerialName("owner_id")
    @get:JvmExposeBoxed
    public val ownerId: DiscordId,
    @get:JvmExposeBoxed
    public val permissions: Permissions? = null,
    public val region: String? = null,
    @SerialName("afk_channel_id")
    @get:JvmExposeBoxed
    public val afkChannelId: DiscordId?,
    @SerialName("afk_timeout")
    public val afkTimeout: Int,
    @SerialName("widget_enabled")
    public val widgetEnabled: Boolean? = null,
    @SerialName("widget_channel_id")
    @get:JvmExposeBoxed
    public val widgetChannelId: DiscordId? = null,
    @SerialName("verification_level")
    @get:JvmExposeBoxed
    public val verificationLevel: VerificationLevel,
    @SerialName("default_message_notifications")
    @get:JvmExposeBoxed
    public val defaultMessageNotifications: DefaultMessageNotificationLevel,
    @SerialName("explicit_content_filter")
    @get:JvmExposeBoxed
    public val explicitContentFilter: ExplicitContentFilterLevel,
    public val roles: List<Role>,
    public val emojis: List<Emoji>,
    public val features: List<GuildFeature>,
    @SerialName("mfa_level")
    @get:JvmExposeBoxed
    public val mfaLevel: MfaLevel,
    @SerialName("application_id")
    @get:JvmExposeBoxed
    public val applicationId: DiscordId?,
    @SerialName("system_channel_id")
    @get:JvmExposeBoxed
    public val systemChannelId: DiscordId?,
    @SerialName("system_channel_flags")
    @get:JvmExposeBoxed
    public val systemChannelFlags: SystemChannelFlags,
    @SerialName("rules_channel_id")
    @get:JvmExposeBoxed
    public val rulesChannelId: DiscordId?,
    @SerialName("max_presences")
    public val maxPresences: Int? = null,
    @SerialName("max_members")
    public val maxMembers: Int? = null,
    @SerialName("vanity_url_code")
    public val vanityUrlCode: String?,
    public val description: String?,
    public val banner: String?,
    @SerialName("premium_tier")
    @get:JvmExposeBoxed
    public val premiumTier: PremiumTier,
    @SerialName("premium_subscription_count")
    public val premiumSubscriptionCount: Int? = null,
    @SerialName("preferred_locale")
    public val preferredLocale: String,
    @SerialName("public_updates_channel_id")
    @get:JvmExposeBoxed
    public val publicUpdatesChannelId: DiscordId?,
    @SerialName("max_video_channel_users")
    public val maxVideoChannelUsers: Int? = null,
    @SerialName("max_stage_video_channel_users")
    public val maxStageVideoChannelUsers: Int? = null,
    @SerialName("approximate_member_count")
    public val approximateMemberCount: Int? = null,
    @SerialName("approximate_presence_count")
    public val approximatePresenceCount: Int? = null,
    @SerialName("welcome_screen")
    public val welcomeScreen: WelcomeScreen? = null,
    @SerialName("nsfw_level")
    @get:JvmExposeBoxed
    public val nsfwLevel: GuildNsfwLevel,
    public val stickers: List<Sticker>? = null,
    @SerialName("premium_progress_bar_enabled")
    public val premiumProgressBarEnabled: Boolean,
    @SerialName("safety_alerts_channel_id")
    @get:JvmExposeBoxed
    public val safetyAlertsChannelId: DiscordId?,
    @SerialName("incidents_data")
    public val incidentsData: IncidentsData?,
    @SerialName("joined_at")
    public val joinedAt: Instant? = null,
    public val large: Boolean? = null,
    public val unavailable: Boolean? = null,
    @SerialName("member_count")
    public val memberCount: Int? = null,
    @SerialName("voice_states")
    public val voiceStates: List<VoiceState>? = null,
    public val members: List<GuildMember>? = null,
    public val channels: List<Channel>? = null,
    public val threads: List<Channel>? = null,
    // TODO：Presence Update 的 activities 字段包含多种随类型变化的结构，
    // 需在 Presence 专题中单独建模；此处先保留原始 Gateway 对象以避免丢失数据。
    public val presences: List<JsonObject>? = null,
    @SerialName("stage_instances")
    public val stageInstances: List<StageInstance>? = null,
    @SerialName("guild_scheduled_events")
    public val guildScheduledEvents: List<GuildScheduledEvent>? = null,
    @SerialName("soundboard_sounds")
    public val soundboardSounds: List<SoundboardSound>? = null,
) {
    override fun toString(): String =
        "Guild(id=$id, name=$name, ownerId=$ownerId)"
}

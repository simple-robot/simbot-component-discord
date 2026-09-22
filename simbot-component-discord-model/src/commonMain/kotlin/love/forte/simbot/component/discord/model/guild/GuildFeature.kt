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

import kotlinx.serialization.Serializable
import kotlin.jvm.JvmExposeBoxed
import kotlin.jvm.JvmInline
import kotlin.jvm.JvmStatic

/**
 * [Guild Features](https://docs.discord.com/developers/resources/guild#guild-object-guild-features).
 *
 * Represents a capability enabled for a guild. Discord may add feature names,
 * so this type preserves unknown string values.
 *
 * @property value The raw Discord guild feature name.
 */
@OptIn(ExperimentalStdlibApi::class)
@JvmInline
@JvmExposeBoxed
@Serializable
public value class GuildFeature private constructor(public val value: String) {
    public companion object {
        /**
         * Raw value for [AnimatedBanner].
         */
        public const val ANIMATED_BANNER_VALUE: String = "ANIMATED_BANNER"

        /**
         * Raw value for [AnimatedIcon].
         */
        public const val ANIMATED_ICON_VALUE: String = "ANIMATED_ICON"

        /**
         * Raw value for [ApplicationCommandPermissionsV2].
         */
        public const val APPLICATION_COMMAND_PERMISSIONS_V2_VALUE: String = "APPLICATION_COMMAND_PERMISSIONS_V2"

        /**
         * Raw value for [AutoModeration].
         */
        public const val AUTO_MODERATION_VALUE: String = "AUTO_MODERATION"

        /**
         * Raw value for [Banner].
         */
        public const val BANNER_VALUE: String = "BANNER"

        /**
         * Raw value for [Community].
         */
        public const val COMMUNITY_VALUE: String = "COMMUNITY"

        /**
         * Raw value for [CreatorMonetizableProvisional].
         */
        public const val CREATOR_MONETIZABLE_PROVISIONAL_VALUE: String = "CREATOR_MONETIZABLE_PROVISIONAL"

        /**
         * Raw value for [CreatorStorePage].
         */
        public const val CREATOR_STORE_PAGE_VALUE: String = "CREATOR_STORE_PAGE"

        /**
         * Raw value for [DeveloperSupportServer].
         */
        public const val DEVELOPER_SUPPORT_SERVER_VALUE: String = "DEVELOPER_SUPPORT_SERVER"

        /**
         * Raw value for [Discoverable].
         */
        public const val DISCOVERABLE_VALUE: String = "DISCOVERABLE"

        /**
         * Raw value for [EnhancedRoleColors].
         */
        public const val ENHANCED_ROLE_COLORS_VALUE: String = "ENHANCED_ROLE_COLORS"

        /**
         * Raw value for [Featurable].
         */
        public const val FEATURABLE_VALUE: String = "FEATURABLE"

        /**
         * Raw value for [GuildTags].
         */
        public const val GUILD_TAGS_VALUE: String = "GUILD_TAGS"

        /**
         * Raw value for [GuestsEnabled].
         */
        public const val GUESTS_ENABLED_VALUE: String = "GUESTS_ENABLED"

        /**
         * Raw value for [InvitesDisabled].
         */
        public const val INVITES_DISABLED_VALUE: String = "INVITES_DISABLED"

        /**
         * Raw value for [InviteSplash].
         */
        public const val INVITE_SPLASH_VALUE: String = "INVITE_SPLASH"

        /**
         * Raw value for [MemberVerificationGateEnabled].
         */
        public const val MEMBER_VERIFICATION_GATE_ENABLED_VALUE: String = "MEMBER_VERIFICATION_GATE_ENABLED"

        /**
         * Raw value for [MoreSoundboard].
         */
        public const val MORE_SOUNDBOARD_VALUE: String = "MORE_SOUNDBOARD"

        /**
         * Raw value for [MoreStickers].
         */
        public const val MORE_STICKERS_VALUE: String = "MORE_STICKERS"

        /**
         * Raw value for [News].
         */
        public const val NEWS_VALUE: String = "NEWS"

        /**
         * Raw value for [Partnered].
         */
        public const val PARTNERED_VALUE: String = "PARTNERED"

        /**
         * Raw value for [PreviewEnabled].
         */
        public const val PREVIEW_ENABLED_VALUE: String = "PREVIEW_ENABLED"

        /**
         * Raw value for [PruneRequiresAdmin].
         */
        public const val PRUNE_REQUIRES_ADMIN_VALUE: String = "PRUNE_REQUIRES_ADMIN"

        /**
         * Raw value for [RaidAlertsDisabled].
         */
        public const val RAID_ALERTS_DISABLED_VALUE: String = "RAID_ALERTS_DISABLED"

        /**
         * Raw value for [RoleIcons].
         */
        public const val ROLE_ICONS_VALUE: String = "ROLE_ICONS"

        /**
         * Raw value for [RoleSubscriptionsEnabled].
         */
        public const val ROLE_SUBSCRIPTIONS_ENABLED_VALUE: String = "ROLE_SUBSCRIPTIONS_ENABLED"

        /**
         * Raw value for [RoleSubscriptionsAvailableForPurchase].
         */
        public const val ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE_VALUE: String =
            "ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE"

        /**
         * Raw value for [Soundboard].
         */
        public const val SOUNDBOARD_VALUE: String = "SOUNDBOARD"

        /**
         * Raw value for [TicketedEventsEnabled].
         */
        public const val TICKETED_EVENTS_ENABLED_VALUE: String = "TICKETED_EVENTS_ENABLED"

        /**
         * Raw value for [VanityUrl].
         */
        public const val VANITY_URL_VALUE: String = "VANITY_URL"

        /**
         * Raw value for [Verified].
         */
        public const val VERIFIED_VALUE: String = "VERIFIED"

        /**
         * Raw value for [VipRegions].
         */
        public const val VIP_REGIONS_VALUE: String = "VIP_REGIONS"

        /**
         * Raw value for [WelcomeScreenEnabled].
         */
        public const val WELCOME_SCREEN_ENABLED_VALUE: String = "WELCOME_SCREEN_ENABLED"


        /**
         * The guild can use animated banner images.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AnimatedBanner: GuildFeature = GuildFeature(ANIMATED_BANNER_VALUE)

        /**
         * The guild can use animated icons.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AnimatedIcon: GuildFeature = GuildFeature(ANIMATED_ICON_VALUE)

        /**
         * The guild uses the legacy application command permission behavior.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val ApplicationCommandPermissionsV2: GuildFeature =
            GuildFeature(APPLICATION_COMMAND_PERMISSIONS_V2_VALUE)

        /**
         * The guild has configured Auto Moderation rules.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AutoModeration: GuildFeature = GuildFeature(AUTO_MODERATION_VALUE)

        /**
         * The guild can use a banner image.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Banner: GuildFeature = GuildFeature(BANNER_VALUE)

        /**
         * The guild has Community features enabled.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Community: GuildFeature = GuildFeature(COMMUNITY_VALUE)

        /**
         * The guild has provisionally enabled creator monetization.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val CreatorMonetizableProvisional: GuildFeature =
            GuildFeature(CREATOR_MONETIZABLE_PROVISIONAL_VALUE)

        /**
         * The guild has enabled a role subscription store page.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val CreatorStorePage: GuildFeature = GuildFeature(CREATOR_STORE_PAGE_VALUE)

        /**
         * The guild is configured as an application support server.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val DeveloperSupportServer: GuildFeature =
            GuildFeature(DEVELOPER_SUPPORT_SERVER_VALUE)

        /**
         * The guild can be discovered in the directory.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Discoverable: GuildFeature = GuildFeature(DISCOVERABLE_VALUE)

        /**
         * The guild can configure gradient role colors.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val EnhancedRoleColors: GuildFeature = GuildFeature(ENHANCED_ROLE_COLORS_VALUE)

        /**
         * The guild can be featured in the directory.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Featurable: GuildFeature = GuildFeature(FEATURABLE_VALUE)

        /**
         * The guild has access to guild tags.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildTags: GuildFeature = GuildFeature(GUILD_TAGS_VALUE)

        /**
         * The guild can create guest invites.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuestsEnabled: GuildFeature = GuildFeature(GUESTS_ENABLED_VALUE)

        /**
         * New invites and guild access are paused.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val InvitesDisabled: GuildFeature = GuildFeature(INVITES_DISABLED_VALUE)

        /**
         * The guild can use an invite splash image.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val InviteSplash: GuildFeature = GuildFeature(INVITE_SPLASH_VALUE)

        /**
         * The guild has Membership Screening enabled.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MemberVerificationGateEnabled: GuildFeature =
            GuildFeature(MEMBER_VERIFICATION_GATE_ENABLED_VALUE)

        /**
         * The guild has increased soundboard capacity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MoreSoundboard: GuildFeature = GuildFeature(MORE_SOUNDBOARD_VALUE)

        /**
         * The guild has increased sticker capacity.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MoreStickers: GuildFeature = GuildFeature(MORE_STICKERS_VALUE)

        /**
         * The guild can create announcement channels.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val News: GuildFeature = GuildFeature(NEWS_VALUE)

        /**
         * The guild is partnered.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Partnered: GuildFeature = GuildFeature(PARTNERED_VALUE)

        /**
         * The guild can be previewed before joining.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val PreviewEnabled: GuildFeature = GuildFeature(PREVIEW_ENABLED_VALUE)

        /**
         * Pruning members requires the Administrator permission.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val PruneRequiresAdmin: GuildFeature = GuildFeature(PRUNE_REQUIRES_ADMIN_VALUE)

        /**
         * Join raid alerts are disabled.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RaidAlertsDisabled: GuildFeature = GuildFeature(RAID_ALERTS_DISABLED_VALUE)

        /**
         * The guild can use role icons.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RoleIcons: GuildFeature = GuildFeature(ROLE_ICONS_VALUE)

        /**
         * The guild has role subscriptions enabled.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RoleSubscriptionsEnabled: GuildFeature =
            GuildFeature(ROLE_SUBSCRIPTIONS_ENABLED_VALUE)

        /**
         * The guild has role subscriptions available for purchase.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RoleSubscriptionsAvailableForPurchase: GuildFeature =
            GuildFeature(ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE_VALUE)

        /**
         * The guild has created soundboard sounds.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Soundboard: GuildFeature = GuildFeature(SOUNDBOARD_VALUE)

        /**
         * The guild has ticketed events enabled.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val TicketedEventsEnabled: GuildFeature =
            GuildFeature(TICKETED_EVENTS_ENABLED_VALUE)

        /**
         * The guild can use a vanity URL.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val VanityUrl: GuildFeature = GuildFeature(VANITY_URL_VALUE)

        /**
         * The guild is verified.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Verified: GuildFeature = GuildFeature(VERIFIED_VALUE)

        /**
         * The guild can use the highest-bandwidth voice regions.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val VipRegions: GuildFeature = GuildFeature(VIP_REGIONS_VALUE)

        /**
         * The guild can use the welcome screen.
         */
        @JvmStatic
        @get:JvmExposeBoxed
        public val WelcomeScreenEnabled: GuildFeature =
            GuildFeature(WELCOME_SCREEN_ENABLED_VALUE)

        /**
         * Creates a feature from a raw Discord feature name.
         */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: String): GuildFeature = GuildFeature(value)
    }

    override fun toString(): String = "GuildFeature(value=$value)"
}

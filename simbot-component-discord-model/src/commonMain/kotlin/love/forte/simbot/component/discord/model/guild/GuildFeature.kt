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
        /** The guild can use animated banner images. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AnimatedBanner: GuildFeature = GuildFeature("ANIMATED_BANNER")

        /** The guild can use animated icons. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AnimatedIcon: GuildFeature = GuildFeature("ANIMATED_ICON")

        /** The guild uses the legacy application command permission behavior. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val ApplicationCommandPermissionsV2: GuildFeature =
            GuildFeature("APPLICATION_COMMAND_PERMISSIONS_V2")

        /** The guild has configured Auto Moderation rules. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val AutoModeration: GuildFeature = GuildFeature("AUTO_MODERATION")

        /** The guild can use a banner image. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Banner: GuildFeature = GuildFeature("BANNER")

        /** The guild has Community features enabled. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Community: GuildFeature = GuildFeature("COMMUNITY")

        /** The guild has provisionally enabled creator monetization. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val CreatorMonetizableProvisional: GuildFeature =
            GuildFeature("CREATOR_MONETIZABLE_PROVISIONAL")

        /** The guild has enabled a role subscription store page. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val CreatorStorePage: GuildFeature = GuildFeature("CREATOR_STORE_PAGE")

        /** The guild is configured as an application support server. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val DeveloperSupportServer: GuildFeature =
            GuildFeature("DEVELOPER_SUPPORT_SERVER")

        /** The guild can be discovered in the directory. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Discoverable: GuildFeature = GuildFeature("DISCOVERABLE")

        /** The guild can configure gradient role colors. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val EnhancedRoleColors: GuildFeature = GuildFeature("ENHANCED_ROLE_COLORS")

        /** The guild can be featured in the directory. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Featurable: GuildFeature = GuildFeature("FEATURABLE")

        /** The guild has access to guild tags. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuildTags: GuildFeature = GuildFeature("GUILD_TAGS")

        /** The guild can create guest invites. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val GuestsEnabled: GuildFeature = GuildFeature("GUESTS_ENABLED")

        /** New invites and guild access are paused. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val InvitesDisabled: GuildFeature = GuildFeature("INVITES_DISABLED")

        /** The guild can use an invite splash image. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val InviteSplash: GuildFeature = GuildFeature("INVITE_SPLASH")

        /** The guild has Membership Screening enabled. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MemberVerificationGateEnabled: GuildFeature =
            GuildFeature("MEMBER_VERIFICATION_GATE_ENABLED")

        /** The guild has increased soundboard capacity. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MoreSoundboard: GuildFeature = GuildFeature("MORE_SOUNDBOARD")

        /** The guild has increased sticker capacity. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val MoreStickers: GuildFeature = GuildFeature("MORE_STICKERS")

        /** The guild can create announcement channels. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val News: GuildFeature = GuildFeature("NEWS")

        /** The guild is partnered. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Partnered: GuildFeature = GuildFeature("PARTNERED")

        /** The guild can be previewed before joining. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val PreviewEnabled: GuildFeature = GuildFeature("PREVIEW_ENABLED")

        /** Pruning members requires the Administrator permission. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val PruneRequiresAdmin: GuildFeature = GuildFeature("PRUNE_REQUIRES_ADMIN")

        /** Join raid alerts are disabled. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RaidAlertsDisabled: GuildFeature = GuildFeature("RAID_ALERTS_DISABLED")

        /** The guild can use role icons. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RoleIcons: GuildFeature = GuildFeature("ROLE_ICONS")

        /** The guild has role subscriptions enabled. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RoleSubscriptionsEnabled: GuildFeature =
            GuildFeature("ROLE_SUBSCRIPTIONS_ENABLED")

        /** The guild has role subscriptions available for purchase. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val RoleSubscriptionsAvailableForPurchase: GuildFeature =
            GuildFeature("ROLE_SUBSCRIPTIONS_AVAILABLE_FOR_PURCHASE")

        /** The guild has created soundboard sounds. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Soundboard: GuildFeature = GuildFeature("SOUNDBOARD")

        /** The guild has ticketed events enabled. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val TicketedEventsEnabled: GuildFeature =
            GuildFeature("TICKETED_EVENTS_ENABLED")

        /** The guild can use a vanity URL. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val VanityUrl: GuildFeature = GuildFeature("VANITY_URL")

        /** The guild is verified. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val Verified: GuildFeature = GuildFeature("VERIFIED")

        /** The guild can use the highest-bandwidth voice regions. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val VipRegions: GuildFeature = GuildFeature("VIP_REGIONS")

        /** The guild can use the welcome screen. */
        @JvmStatic
        @get:JvmExposeBoxed
        public val WelcomeScreenEnabled: GuildFeature =
            GuildFeature("WELCOME_SCREEN_ENABLED")

        /** Creates a feature from a raw Discord feature name. */
        @JvmStatic
        @JvmExposeBoxed
        public fun of(value: String): GuildFeature = GuildFeature(value)
    }

    override fun toString(): String = "GuildFeature(value=$value)"
}

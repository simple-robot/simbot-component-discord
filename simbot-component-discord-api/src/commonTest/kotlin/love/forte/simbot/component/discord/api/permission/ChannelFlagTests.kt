package love.forte.simbot.component.discord.api.permission

import love.forte.simbot.component.discord.api.channel.Channel


/**
 * 
 * @author ForteScarlet 
 */
class ChannelFlagTests {

    fun readFlag(channel: Channel) {
        val flags = channel.flags
        val value = flags.value
        println(value)
    }

}

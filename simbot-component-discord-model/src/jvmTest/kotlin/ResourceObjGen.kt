import java.util.*
import kotlin.test.Test

/**
 *
 * @author ForteScarlet
 */
class ResourceObjGen {
    private val name = "Application"
    private val doc = """
        The [Application Object](https://discord.com/developers/docs/resources/application#application-object)
    """.trimIndent()
    private val str = """
        id	snowflake	ID of the app
        name	string	Name of the app
        icon	?string	Icon hash of the app
        description	string	Description of the app
        rpc_origins?	array of strings	List of RPC origin URLs, if RPC is enabled
        bot_public	boolean	When false, only the app owner can add the app to guilds
        bot_require_code_grant	boolean	When true, the app's bot will only join upon completion of the full OAuth2 code grant flow
        bot?	partial user object	Partial user object for the bot user associated with the app
        terms_of_service_url?	string	URL of the app's Terms of Service
        privacy_policy_url?	string	URL of the app's Privacy Policy
        owner?	partial user object	Partial user object for the owner of the app
        verify_key	string	Hex encoded key for verification in interactions and the GameSDK's GetTicket
        team	?team object	If the app belongs to a team, this will be a list of the members of that team
        guild_id?	snowflake	Guild associated with the app. For example, a developer support server.
        guild?	partial guild object	Partial object of the associated guild
        primary_sku_id?	snowflake	If this app is a game sold on Discord, this field will be the id of the "Game SKU" that is created, if exists
        slug?	string	If this app is a game sold on Discord, this field will be the URL slug that links to the store page
        cover_image?	string	App's default rich presence invite cover image hash
        flags?	integer	App's public flags
        approximate_guild_count?	integer	Approximate count of guilds the app has been added to
        redirect_uris?	array of strings	Array of redirect URIs for the app
        interactions_endpoint_url?	string	Interactions endpoint URL for the app
        role_connections_verification_url?	string	Role connection verification URL for the app
        tags?	array of strings	List of tags describing the content and functionality of the app. Max of 5 tags.
        install_params?	install params object	Settings for the app's default in-app authorization link, if enabled
        custom_install_url?	string	Default custom authorization URL for the app, if enabled
    """.trimIndent()

    @Test
    fun run() {
        data class LineData(val name: Name, val type: Type, val desc: String)

        val lines = str.lineSequence()
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .mapNotNull { line ->
                val split = line.split(Regex("\t"), 3)
                if (split.size != 3) {
                    return@mapNotNull null
                }

                val name = name(split[0])
                val type = type(name, split[1])

                LineData(name, type, split[2])
            }
            .toList()

        println("/**")
        doc.lineSequence().forEach {
            println(" * $it")
        }
        println(" * ")
        lines.forEach { (name, _, desc) ->
            println(" * @property ${name.name} $desc")
        }
        println(" * ")
        println(" * @author ForteScarlet")
        println(" */")
        println("@Serializable")
        println("public data class $name(")
        lines.forEach { (name, type, _) ->
            val n = name.name
            val t = type.name
            if (" " in t) {
                if (name.name != name.source) {
                    println("  // @SerialName(\"${name.source}\")")
                }
                println("  // val ${name.name}: ${type.name}${if (type.nullable) "? = null" else ""}, // TODO ${name.name}: ${type.name}")
            } else {
                if (name.name != name.source) {
                    println("    @SerialName(\"${name.source}\")")
                }
                println("    val ${name.name}: ${type.name}${if (type.nullable) "? = null" else ""},")
            }
        }
        println(")")
    }

}

data class Type(val name: String, val nullable: Boolean)
data class Name(val name: String, val source: String, val raw: String)

/**
 * 下划线转驼峰
 */
private fun name(name: String): Name {
    val n = if (name.endsWith("?")) name.substring(0, name.length - 1) else name
    val split = n.split("_")
    val sb = StringBuilder()
    split.forEachIndexed { index, s ->
        if (index == 0) {
            sb.append(s)
        } else {
            sb.append(s.replaceFirstChar { if (it.isLowerCase()) it.titlecase(Locale.getDefault()) else it.toString() })
        }
    }

    return Name(sb.toString(), n, name)
}

private fun type(name: Name, type: String): Type {
    val nullable = name.raw.endsWith("?") || type.startsWith("?")
    val typeName = if (type.startsWith("?")) type.substring(1, type.length) else type
    return when {
        typeName.equals("snowflake", true) -> Type("Long", nullable)
        typeName.equals("string", true) -> Type("String", nullable)
        typeName.equals("integer", true) -> Type("Int", nullable)
        typeName.equals("array of strings", true) -> Type("List<String>", nullable)
        typeName.equals("boolean", true) -> Type("Boolean", nullable)
        else -> Type(typeName, nullable)
    }
}

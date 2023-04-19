import java.security.MessageDigest

fun String.sha256() =
    MessageDigest.getInstance("SHA-256")
        .digest(this.toByteArray())
        .joinToString("") { "%02x".format(it) }
import java.time.Instant

data class Block(
    private val data: String,
    val previousHash: String,
    var nonce: Long,
    private val timestamp: Instant
) {

    val hash: String
        get() = "$previousHash$timestamp$data$nonce".sha256()

}
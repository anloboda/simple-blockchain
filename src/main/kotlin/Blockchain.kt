import java.time.Instant

class Blockchain {

    private val chain = ArrayList<Block>()

    init {
        chain.add(genesis())
    }

    fun addBlock(data: String) {
        chain.add(mine(data))
    }

    fun validate() =
        chain.windowed(size = 2, step = 1, partialWindows = false)
            .all { (previous, current) -> current.previousHash == previous.hash }

    private fun mine(data: String, difficulty: Int = 2): Block {
        var nonce = 0L
        val block = Block(data, chain.last().hash, nonce, Instant.now())
        val prefix = "0".repeat(difficulty)
        while (!block.hash.startsWith(prefix)) {
            nonce++
            block.nonce = nonce
        }
        return block
    }

    private fun genesis() = Block("", "0", 0, Instant.now())
}
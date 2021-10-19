package refill

class Random {
    companion object {
        fun random(percent:Double): Boolean {
            val value: Int = ((Math.random() * 100) + 1).toInt()
            return value <= percent
        }

        fun randomSlot(max: Int): Int {
            return (Math.random() * (max - 1)).toInt()
        }
    }
}
package leetCodeEasyPractice

class Strstr {

    companion object {
        @JvmStatic
        fun main(args: Array<String>) {
            print(strStr("needlekamaakachut", "ka"))
        }

        private fun strStr(hayStack: String?, needle: String?): Int {
            if (needle.orEmpty().isEmpty()) {
                return 0
            }
            var p1 = 0
            var p2 = 0
            while (p1 < hayStack?.length ?: -1 && p2 < needle?.length ?: -1) {
                if (hayStack?.get(p1) == needle?.get(p2)){
                    p1++
                    p2++
                    if (p2 == needle?.length) {
                        return p1 - p2
                    }
                } else {
                    p1 = p1-p2 + 1
                    p2 = 0
                }
            }
            return -1
        }
    }
}
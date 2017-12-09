@file:Suppress("UNUSED_PARAMETER", "unused")

package lesson7.task1

/**
 * Ячейка матрицы: row = ряд, column = колонка
 */
data class Cell(val row: Int, val column: Int)

/**
 * Интерфейс, описывающий возможности матрицы. E = тип элемента матрицы
 */
interface Matrix<E> {
    /** Высота */
    val height: Int

    /** Ширина */
    val width: Int

    /**
     * Доступ к ячейке.
     * Методы могут бросить исключение, если ячейка не существует или пуста
     */
    operator fun get(row: Int, column: Int): E

    operator fun get(cell: Cell): E

    /**
     * Запись в ячейку.
     * Методы могут бросить исключение, если ячейка не существует
     */
    operator fun set(row: Int, column: Int, value: E)

    operator fun set(cell: Cell, value: E)
}

/**
 * Простая
 *
 * Метод для создания матрицы, должен вернуть РЕАЛИЗАЦИЮ Matrix<E>.
 * height = высота, width = ширина, e = чем заполнить элементы.
 * Бросить исключение IllegalArgumentException, если height или width <= 0.
 */
fun <E> createMatrix(height: Int, width: Int, e: E): Matrix<E> {
    if (height <= 0 || width <= 0) throw IllegalArgumentException()
    else return MatrixImpl(height, width, e)
}

/**
 * Средняя сложность
 *
 * Реализация интерфейса "матрица"
 */
class MatrixImpl<E>(override val height: Int, override val width: Int, val e: E) : Matrix<E> {
    val container = MutableList(height) { MutableList(width) { e } }

    override fun get(row: Int, column: Int): E {
        if ((row !in 0..height) || column !in 0..width) throw IllegalArgumentException()
        return container[row][column]
    }

    override fun get(cell: Cell): E = get(cell.row, cell.column)

    override fun set(row: Int, column: Int, value: E) {
        if ((row !in 0..height) || column !in 0..width) throw IllegalArgumentException()
        container[row][column] = value
    }

    override fun set(cell: Cell, value: E) = set(cell.row, cell.column, value)

    override fun equals(other: Any?): Boolean {
        if ((other !is Matrix<*>) || (other.width != width) || (other.height != height)) return false
        for (i in 1 until height) {
            for (j in 1 until width)
                if (container[i][j] != other[i, j]) return false
        }
        return true
    }

    override fun hashCode(): Int {
        var result = 0
        result += height * 31
        result += width * 31
        result += e?.hashCode() ?: 0
        return result
    }

    override fun toString(): String {
        val string = StringBuilder()
        for (i in 0 until height) {
            string.append("|")
            string.append(" ")
            for (j in 0 until width) {
                string.append(container[i][j].toString())
                string.append(" ")
            }
            string.append("|")
            string.append("\n")
        }
        return string.toString()
    }
}


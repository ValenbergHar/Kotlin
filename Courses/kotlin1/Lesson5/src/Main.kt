fun main() {
    val month = Month.AUG
    val season = when (month) {
        Month.DEC, Month.JAN, Month.FEB -> Season.WIN
            Month.MAR, Month.APR, Month.MAY ->Season.SPR
            Month.JUN, Month.JUL, Month.AUG ->Season.SUM
            Month.SEPT , Month.OCT, Month.NOV ->Season.AUT
    }
    print(season)
}
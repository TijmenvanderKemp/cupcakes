package models

import entities.Month
import entities.Week
import observablemapasdatapoints.RefreshableMap
import java.time.LocalDate

interface EarningsModel {
    val refreshableMapDaily: RefreshableMap<LocalDate, Int>
    val refreshableMapWeekly: RefreshableMap<Week, Int>
    val refreshableMapMonthly: RefreshableMap<Month, Int>
    val refreshableMapYearly: RefreshableMap<Int, Int>
    fun refreshAll()
}
package entities

data class DailySale(val totalDollars: Int, val perType: Map<Class<Cupcake>, Int>)
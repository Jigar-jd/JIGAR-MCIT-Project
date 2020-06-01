package RW

import GTFs.{Calender, Routes, Trips}

import scala.io.Source

class Reader {
  val filePathRoutes = "C:\\Users\\Evil\\Downloads\\gtfs_stm\\routes.txt"
  val filePathCalender = "C:\\Users\\Evil\\Downloads\\gtfs_stm\\calendar.txt"
  val filePathTrips = "C:\\Users\\Evil\\Downloads\\gtfs_stm\\trips.txt"

  def getRouteList:List[Routes] = {
    val source = Source.fromFile(filePathRoutes)
    val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Routes(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList
    source.close()
    input
  }

  def getCalenderList: List[Calender] = {
    val source = Source.fromFile(filePathCalender)
    val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Calender(a(0), a(1), a(2), a(3), a(4), a(5), a(6), a(7), a(8), a(9))).toList
    source.close()
    input
  }

  def getTripList: List[Trips] = {
    val source = Source.fromFile(filePathTrips)
    val input = source.getLines().drop(1)
      .map(line => line.split(","))
      .map(a => Trips(a(0).toInt, a(1), a(2), a(3), a(4), a(5), a(6))).toList
    source.close()
    input
  }

}

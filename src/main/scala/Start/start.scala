package Start

import GTFs.{Calender, EnrichedTrip, Routes, TripRoute, Trips}
import Map.{CalendarLookup, RouteLookup}
import RW.{Reader, Writer}

object start extends App {
  val readData : Reader = new Reader

  val tripList: List[Trips] = readData.getTripList


  val routeList: List[Routes] = readData.getRouteList


  val calenderList: List[Calender] = readData.getCalenderList

  val routeLookup = new RouteLookup(routeList)

  val calenderLookUp = new CalendarLookup(calenderList)



  val enrichedTripRoute: List[TripRoute] = tripList.map(trip => TripRoute(trip,
    routeLookup.lookup(trip.route_id)))

  val enrichedTrip: List[EnrichedTrip] = enrichedTripRoute.map(tripRoute => EnrichedTrip(tripRoute,
    calenderLookUp.lookup(tripRoute.trips.service_id)))

  val finalListOfTrips: List[EnrichedTrip] = enrichedTrip.filter(a => a.calender.monday.equals("1") && a.tripRoute.routes.route_type.equals("1"))

  val writer = new Writer(finalListOfTrips)



  writer.writeData()

}

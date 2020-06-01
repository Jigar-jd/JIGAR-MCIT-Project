package Map

import GTFs.Routes

class RouteLookup (routes: List[Routes]) {
  private val lookupTable: Map[Int, Routes] =
    routes.map(route => route.route_id -> route).toMap

  def lookup(routeId: Int): Routes = lookupTable.getOrElse(routeId, null)

}

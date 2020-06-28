package avimarine.traccar.client.route

import android.location.Location

class Waypoint : RouteElement  {
    override val name: String
    override val type = RouteElementType.WAYPOINT
    override val stbdWpt : Location
    override val portWpt: Location
    override val mandatory: Boolean
    override val proofArea: ProofArea
    override var firstTimeInProofArea: Long = -1

    constructor(name: String, location: Location, mandatory: Boolean, bearing1: Double, bearing2:Double){
        this.name = name
        stbdWpt = location
        portWpt = location
        this.mandatory = mandatory
        this.proofArea = ProofAreaFactory.createProofArea(stbdWpt,bearing1,bearing2)
    }
    override fun isInProofArea(loc: Location):Boolean{
        return proofArea.isInProofArea(portWpt,loc)
    }
    override fun toString() : String{
        return name
    }
}
from opensky_api import OpenSkyApi
from math import radians, cos, sin, asin, sqrt

currentLocation = [41.3660057, -81.97764280000001] #latitude, longitude  --- make this user input later on
def distanceGPS(lon1, lat1, lon2, lat2):
    """
    Calculate the great circle distance between two points 
    on the earth (specified in decimal degrees)
    """
    # convert decimal degrees to radians 
    lon1, lat1, lon2, lat2 = map(radians, [lon1, lat1, lon2, lat2])
    # haversine formula 
    dlon = lon2 - lon1 
    dlat = lat2 - lat1 
    a = sin(dlat/2)**2 + cos(lat1) * cos(lat2) * sin(dlon/2)**2
    c = 2 * asin(sqrt(a)) 
    # Radius of earth in kilometers is 6371
    km = 6371* c
    return km
api = OpenSkyApi()
planes = api.get_states().states
closestPlane = {"plane": None, "distance": 40000}

for plane in planes:
    if plane.longitude and plane.latitude:
        distance = distanceGPS(currentLocation[1], currentLocation[0], plane.longitude, plane.latitude)
        if distance < closestPlane["distance"]:
            closestPlane["plane"] = plane
            closestPlane["distance"] = distance
p = closestPlane["plane"]
callsign = ""
lat = str(p.latitude)
lon = str(p.longitude)
geo = ""
country = ""
code = ""
if p.callsign:
    callsign = str(p.callsign)
if p.geo_altitude:
    geo = str(p.geo_altitude)
if p.origin_country:
    country = str(p.origin_country)
if p.icao24:
    code = str(p.icao24)

print("Distance: " + str(closestPlane["distance"])+ "km" + "\ncallsign: " + callsign +"\nLatitude: " + lat + "\nLongitude: " + lon +"\nAltitude: " + geo + "m" + "\ncountry: " + country + "\nicao24: " + code)
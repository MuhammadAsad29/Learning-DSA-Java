import java.util.*;

public class SmartCityTrafficManagement {

    static class Intersection {
        String name;
        List<Road> roads;

        Intersection(String name) {
            this.name = name;
            this.roads = new ArrayList<>();
        }

        void addRoad(Road road) {
            roads.add(road);
        }
    }

    static class Road {
        Intersection from;
        Intersection to;
        int length;
        int trafficLoad;

        Road(Intersection from, Intersection to, int length) {
            this.from = from;
            this.to = to;
            this.length = length;
            this.trafficLoad = 0;
        }
    }

    static class Vehicle {
        String id;
        Intersection start;
        Intersection destination;

        Vehicle(String id, Intersection start, Intersection destination) {
            this.id = id;
            this.start = start;
            this.destination = destination;
        }
    }

    static class TrafficManagementSystem {
        Map<String, Intersection> intersections;

        TrafficManagementSystem() {
            intersections = new HashMap<>();
        }

        void addIntersection(String name) {
            intersections.put(name, new Intersection(name));
        }

        void addRoad(String fromName, String toName, int length) {
            Intersection from = intersections.get(fromName);
            Intersection to = intersections.get(toName);
            if (from != null && to != null) {
                Road road = new Road(from, to, length);
                from.addRoad(road);
                to.addRoad(road); // Assuming bidirectional roads
            }
        }

        List<Intersection> findShortestPath(Intersection start, Intersection destination) {
            Map<Intersection, Integer> distances = new HashMap<>();
            Map<Intersection, Intersection> previousNodes = new HashMap<>();
            PriorityQueue<Intersection> pq = new PriorityQueue<>(Comparator.comparingInt(distances::get));

            for (Intersection intersection : intersections.values()) {
                distances.put(intersection, Integer.MAX_VALUE);
                previousNodes.put(intersection, null);
                pq.add(intersection);
            }
            distances.put(start, 0);

            while (!pq.isEmpty()) {
                Intersection current = pq.poll();
                if (current == destination) break;

                for (Road road : current.roads) {
                    Intersection neighbor = road.to.equals(current) ? road.from : road.to;
                    int newDist = distances.get(current) + road.length + road.trafficLoad;
                    if (newDist < distances.get(neighbor)) {
                        distances.put(neighbor, newDist);
                        previousNodes.put(neighbor, current);
                        pq.remove(neighbor);
                        pq.add(neighbor);
                    }
                }
            }

            List<Intersection> path = new ArrayList<>();
            for (Intersection at = destination; at != null; at = previousNodes.get(at)) {
                path.add(at);
            }
            Collections.reverse(path);
            return path.size() == 1 && !path.get(0).equals(start) ? Collections.emptyList() : path;
        }

        void simulateTraffic(List<Vehicle> vehicles) {
            for (Vehicle vehicle : vehicles) {
                List<Intersection> path = findShortestPath(vehicle.start, vehicle.destination);
                System.out.println("Vehicle " + vehicle.id + " path: " + path.stream().map(i -> i.name).toList());
                for (int i = 0; i < path.size() - 1; i++) {
                    Intersection from = path.get(i);
                    Intersection to = path.get(i + 1);
                    for (Road road : from.roads) {
                        if ((road.from.equals(from) && road.to.equals(to)) || (road.from.equals(to) && road.to.equals(from))) {
                            road.trafficLoad++;
                        }
                    }
                }
            }
        }

        public static void main(String[] args) {
            TrafficManagementSystem tms = new TrafficManagementSystem();

            tms.addIntersection("A");
            tms.addIntersection("B");
            tms.addIntersection("C");

            tms.addRoad("A", "B", 10);
            tms.addRoad("B", "C", 15);

            List<Vehicle> vehicles = List.of(
                    new Vehicle("V1", tms.intersections.get("A"), tms.intersections.get("C")),
                    new Vehicle("V2", tms.intersections.get("A"), tms.intersections.get("B"))
            );

            tms.simulateTraffic(vehicles);

            System.out.println("Traffic simulation completed.");
        }
    }
}
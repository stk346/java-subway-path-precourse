package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DijkstraShortestDistancePath {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph;
    private DijkstraShortestPath dijkstraShortestPath;

    public DijkstraShortestDistancePath() {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }

        for (Section section : SectionRepository.sections()) {
            String departureStation = section.getDepartureStation();
            String arrivalStation = section.getArrivalStation();
            int distance = section.getKilometer();
            graph.setEdgeWeight(graph.addEdge(departureStation, arrivalStation), distance);
        }
    }

    public List<String> getShortestPath(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestDistancePath = new DijkstraShortestPath(graph);
        return dijkstraShortestDistancePath.getPath(departureStation, arrivalStation).getVertexList();
    }
}

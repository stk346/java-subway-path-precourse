package subway.domain;

import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;

import java.util.List;

public class DijkstraShortestTimePath {
    private static WeightedMultigraph<String, DefaultWeightedEdge> graph;
    private static DijkstraShortestPath dijkstraShortestPath;

    public DijkstraShortestTimePath() {
        graph = new WeightedMultigraph(DefaultWeightedEdge.class);

        for (Station station : StationRepository.stations()) {
            graph.addVertex(station.getName());
        }

        for (Section section : SectionRepository.sections()) {
            String departureStation = section.getDepartureStation();
            String arrivalStation = section.getArrivalStation();
            int time = section.getRequiredTime();
            graph.setEdgeWeight(graph.addEdge(departureStation, arrivalStation), time);
        }
    }
    public static List<String> getShortestPath(String departureStation, String arrivalStation) {
        DijkstraShortestPath dijkstraShortestTimePath = new DijkstraShortestPath(graph);
        return dijkstraShortestTimePath.getPath(departureStation, arrivalStation).getVertexList();
    }
}

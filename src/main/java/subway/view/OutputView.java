package subway.view;

import subway.domain.Section;
import subway.domain.SectionRepository;

import java.util.List;

public class OutputView {
    public static void showMainDisplay() {
        System.out.println("## 메인 화면");
        System.out.println("1. 경로 조회");
        System.out.println("Q. 종료");
    }


    public static void showSecondDisplay() {
        System.out.println("## 경로 기준");
        System.out.println("1. 최단 거리");
        System.out.println("2. 최소 시간");
        System.out.println("B. 돌아가기");
    }

    public static void showInfo(List<String> shortestPath) {
        StringBuilder sb = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        extractInfo(shortestPath, sb, sb2);
        System.out.print(sb);
        System.out.println(sb2);
    }

    private static void extractInfo(List<String> shortestPath, StringBuilder sb, StringBuilder sb2) {
        int totalDistance = 0;
        int totalRequiredTime = 0;
        sb.append("## 조회 결과 \n");
        sb.append("[INFO] ---\n");
        for (int idx = 0; idx < shortestPath.size()-1; idx++) {
            Section targetSection = getSection(shortestPath, idx);
            totalDistance += targetSection.getKilometer();
            totalRequiredTime += targetSection.getRequiredTime();
            String stationName = shortestPath.get(idx);
            sb2.append("[INFO] " + stationName + "\n");
        }
        sb2.append("[INFO] " + shortestPath.get(shortestPath.size()-1));
        sb.append("[INFO] 총 거리: " + totalDistance + "km\n");
        sb.append("[INFO] 총 소요 시간: " + totalRequiredTime + "분\n");
        sb.append("[INFO] ---\n");
    }

    private static Section getSection(List<String> shortestPath, int idx) {
        try {
            String departure = shortestPath.get(idx);
            String arrival = shortestPath.get(idx +1);
            return SectionRepository.getSection(departure, arrival);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return getSection(shortestPath, idx);
        }
    }
}

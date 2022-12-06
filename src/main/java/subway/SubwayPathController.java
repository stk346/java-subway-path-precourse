package subway;

import subway.domain.*;
import subway.view.InputView;
import subway.view.OutputView;

import java.util.List;

public class SubwayPathController {

    public void run() {
        boolean continueFlag = true;
        while (continueFlag) {
            OutputView.showMainDisplay();
            String mainDisplayUserInput = InputView.showMainSelectUIAndGetUserInput();

            if (mainDisplayUserInput.equals("1")) {
                OutputView.showSecondDisplay();
                String secondDisplayUserInput = InputView.showSecondDisplayUIAndGetUserInput();

                calculateShortestDistance(secondDisplayUserInput);
                calculateShortestTime(secondDisplayUserInput);
                if (backToMainDisplay(secondDisplayUserInput)) continue;
            }

            continueFlag = quit(continueFlag, mainDisplayUserInput);
        }
    }

    private boolean quit(boolean continueFlag, String mainDisplayUserInput) {
        if (mainDisplayUserInput.equals("Q")) {
            continueFlag = false;
        }
        return continueFlag;
    }

    private boolean backToMainDisplay(String secondDisplayUserInput) {
        if (secondDisplayUserInput.equals("B")) {
            return true;
        }
        return false;
    }

    private void calculateShortestTime(String secondDisplayUserInput) {
        if (secondDisplayUserInput.equals("2")) { // 최소시간
            List<String> shortestPath = getShortestTimeStation();

            OutputView.showInfo(shortestPath);
        }
    }

    private List<String> getShortestTimeStation() {
        try {
            String userInputOfDeparture = InputView.showDepartureEnteringUIAndGetInput();
            String userInputOfArrival = InputView.showArrivalEnteringUIAndGetInput();

            DijkstraShortestTimePath dijkstraShortestTimePath = new DijkstraShortestTimePath();
            return dijkstraShortestTimePath.getShortestPath(userInputOfDeparture, userInputOfArrival);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 역 명을 입력해주세요.");
            return getShortestDistanceStation();
        }
    }

    private void calculateShortestDistance(String secondDisplayUserInput) {
        if (secondDisplayUserInput.equals("1")) { // 최단거리
            List<String> shortestPath = getShortestDistanceStation();

            OutputView.showInfo(shortestPath);
        }
    }

    private List<String> getShortestDistanceStation() {
        try {
            String userInputOfDeparture = InputView.showDepartureEnteringUIAndGetInput();
            String userInputOfArrival = InputView.showArrivalEnteringUIAndGetInput();

            DijkstraShortestDistancePath dijkstraShortestDistancePath = new DijkstraShortestDistancePath();
            return dijkstraShortestDistancePath.getShortestPath(userInputOfDeparture, userInputOfArrival);
        } catch (IllegalArgumentException e) {
            System.out.println("올바른 역 명을 입력해주세요.");
            return getShortestDistanceStation();
        }
    }
}

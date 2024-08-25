package model

import java.time.LocalDateTime

class Task {
    private LocalDateTime start
    private LocalDateTime end
    private List<Action> actionList

    Task(LocalDateTime start, LocalDateTime end, String... actions) {
        this.start = start
        this.end = end
        this.actionList = Arrays.stream(actions)
                .map(text -> new Action(start, text))
                .toList()
    }

    LocalDateTime getStart() {
        return start
    }

    LocalDateTime getEnd() {
        return end
    }

    List<Action> getActionList() {
        return actionList
    }
}

package model

import java.time.LocalDateTime

class Action {
    private LocalDateTime dateTime;
    private String text

    Action(LocalDateTime dateTime, String text) {
        this.dateTime = dateTime
        this.text = text
    }

    String getText() {
        return text
    }
}

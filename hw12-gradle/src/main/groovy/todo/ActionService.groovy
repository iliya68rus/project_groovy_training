package todo

import grails.gorm.services.Service

@Service(Action)
interface ActionService {
    List<Action> list()
    Action save(Action action)
}

class ActionServiceImpl implements ActionService {

    @Override
    List<Action> list() {
        Action.list()
    }

    @Override
    Action save(Action action) {
        Task task = action.task
        List<Action> existingActions = task.actions

        for (Action existingAction : existingActions) {
            if (isOverlapping(existingAction, action)) {
                throw new IllegalArgumentException("Даты пересакаются с уже существующим действием")
            }
        }

        action.save()
    }

    private static boolean isOverlapping(Action existingAction, Action newAction) {
        return !(newAction.endDate.isBefore(existingAction.startDate) || newAction.startDate.isAfter(existingAction.endDate))
    }
}
package ru.forinnyy.tm.command.task;

import lombok.NonNull;
import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.entity.TaskNotFoundException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.model.Task;
import ru.forinnyy.tm.util.TerminalUtil;

public final class TaskShowByIdCommand extends AbstractTaskCommand {

    @NonNull
    private static final String NAME = "task-show-by-id";

    @NonNull
    private static final String DESCRIPTION = "Show task by id.";

    @NonNull
    @Override
    public String getDescription() {
        return DESCRIPTION;
    }

    @NonNull
    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public void execute() throws AbstractEntityException, AbstractFieldException, AbstractUserException {
        System.out.println("[SHOW TASK BY ID]");
        System.out.println("ENTER ID:");
        @NonNull final String id = TerminalUtil.nextLine();
        @NonNull final String userId = getUserId();
        final Task task = getTaskService().findOneById(userId, id);
        if (task == null) throw new TaskNotFoundException();
        showTask(task);
    }

}

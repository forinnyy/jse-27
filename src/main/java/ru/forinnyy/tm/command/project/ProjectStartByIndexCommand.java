package ru.forinnyy.tm.command.project;

import lombok.NonNull;
import ru.forinnyy.tm.enumerated.Status;
import ru.forinnyy.tm.exception.entity.AbstractEntityException;
import ru.forinnyy.tm.exception.field.AbstractFieldException;
import ru.forinnyy.tm.exception.user.AbstractUserException;
import ru.forinnyy.tm.util.TerminalUtil;

public final class ProjectStartByIndexCommand extends AbstractProjectCommand {

    @NonNull
    private static final String NAME = "project-start-by-index";

    @NonNull
    private static final String DESCRIPTION = "Start project by index.";

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
        System.out.println("[START PROJECT BY INDEX]");
        System.out.println("ENTER INDEX:");
        @NonNull final Integer index = TerminalUtil.nextNumber() - 1;
        @NonNull final String userId = getUserId();
        getProjectService().changeProjectStatusByIndex(userId, index, Status.IN_PROGRESS);
    }

}

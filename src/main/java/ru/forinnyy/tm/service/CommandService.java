package ru.forinnyy.tm.service;

import ru.forinnyy.tm.api.repository.ICommandRepository;
import ru.forinnyy.tm.api.service.ICommandService;
import ru.forinnyy.tm.command.AbstractCommand;

import java.util.Collection;

public final class CommandService implements ICommandService {

    private final ICommandRepository commandRepository;

    public CommandService(final ICommandRepository commandRepository) {
        this.commandRepository = commandRepository;
    }

    @Override
    public void add(AbstractCommand command) {
        if (command == null) return;
        commandRepository.add(command);
    }

    @Override
    public AbstractCommand getCommandByArgument(String argument) {
        if (argument == null || argument.isEmpty()) return null;
        return commandRepository.getCommandByArgument(argument);
    }

    @Override
    public AbstractCommand getCommandByName(String name) {
        if (name == null || name.isEmpty()) return null;
        return commandRepository.getCommandByName(name);
    }

    @Override
    public Collection<AbstractCommand> getTerminalCommands() {
        return commandRepository.getTerminalCommands();
    }

    @Override
    public Collection<AbstractCommand> getTerminalArguments() {
        return commandRepository.getTerminalArguments();
    }

}

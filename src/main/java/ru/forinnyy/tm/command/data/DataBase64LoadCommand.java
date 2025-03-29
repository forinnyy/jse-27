package ru.forinnyy.tm.command.data;

import lombok.NonNull;
import lombok.SneakyThrows;
import ru.forinnyy.tm.dto.Domain;
import ru.forinnyy.tm.enumerated.Role;
import java.io.ByteArrayInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class DataBase64LoadCommand extends AbstractDataCommand {

    @NonNull
    public static final String NAME = "data-load-base64";

    @Override
    @SneakyThrows
    public void execute() {
        System.out.println("[DATA BASE64 LOAD]");
        @NonNull final byte[] base64Byte = Files.readAllBytes(Paths.get(FILE_BASE64));
        final String base64Date = new String(base64Byte);
        final byte[] bytes = new BASE64Decoder().decodeBuffer(base64Date);
        @NonNull final ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bytes);
        @NonNull final ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        @NonNull final Domain domain = (Domain) objectInputStream.readObject();
        objectInputStream.close();
        byteArrayInputStream.close();
        setDomain(domain);
    }

    @Override
    public String getArgument() {
        return null;
    }

    @Override
    public @NonNull String getDescription() {
        return "Load data from base64 file.";
    }

    @Override
    public @NonNull String getName() {
        return NAME;
    }

    @Override
    public Role[] getRoles() {
        return new Role[]{Role.ADMIN};
    }
}

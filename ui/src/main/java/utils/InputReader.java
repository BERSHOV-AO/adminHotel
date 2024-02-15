package utils;
import ru.senla.enums.RoomStatus;
import ru.senla.enums.ServiceType;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InputReader {

    public static Integer getIntegerInput(Scanner scanner, String message) {
        Printer.print(message);
        return getIntegerInput(scanner);
    }

    public static Integer getIntegerInput(Scanner scanner) {
        boolean isValid = false;
        Integer input = null;

        while (!isValid) {
            if (scanner.hasNextInt()) {
                input = scanner.nextInt();
                isValid = true;
            } else {
                Printer.print("Wrong input. Please, input a number.");
                scanner.nextLine();
                continue;
            }
        }
        return input;
    }

    public static String getStringInput(Scanner scanner, String message) {
        Printer.print(message);
        return getStringInput(scanner);
    }

    public static String getStringInput(Scanner scanner) {

        String input = scanner.nextLine();

        return input;
    }

    public static Double getDoubleInput(Scanner scanner, String message) {
        Printer.print(message);
        return getDoubleInput(scanner);
    }

    public static Double getDoubleInput(Scanner scanner) {
        boolean isValid = false;
        Double input = null;

        while (!isValid) {
            if (scanner.hasNextDouble()) {
                input = scanner.nextDouble();
                isValid = true;

            } else {
                Printer.print("Wrong input. Please, input a double.");
                scanner.nextLine();
                continue;
            }
        }
        return input;
    }

    public static LocalDate getLocalDateInput(Scanner scanner, String message) {
        Printer.print(message);

        return getLocalDateInput(scanner);
    }

    private static LocalDate getLocalDateInput(Scanner scanner) {
        boolean isValid = false;
        String input;
        LocalDate date = null;
        while (!isValid) {
            if (scanner.hasNext()) {
                input = scanner.next();
                try {
                    date = LocalDate.parse(input);
                    isValid = true;
                } catch (DateTimeParseException e) {
                    Printer.print("Wrong input. Please, input the date in \"YYYY-MM-DD\" format." + e.getMessage());
                    scanner.nextLine();
                    continue;
                }
            }
        }
        return date;
    }

    public static RoomStatus getRoomStatusByInput(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                RoomStatus status = RoomStatus.integerRoomStatus(input);

                if (status != null) {
                    return status;
                }
            } else {
                scanner.next();
            }
            System.out.println("Ввод не соответствует статусу комнаты!");
        }
    }

    public static ServiceType getServiceTypeByInput(Scanner scanner, String message) {
        while (true) {
            System.out.println(message);
            if (scanner.hasNextInt()) {
                int input = scanner.nextInt();
                ServiceType type = ServiceType.integerServiceType(input);

                if (type != null) {
                    return type;
                }
            } else {
                scanner.next();
            }
            System.out.println("Ввод не соответствует сервису!");
        }
    }
}



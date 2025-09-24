package ThreadsConcurrencia.miniCurso.II_ClasePoolThreadsCallbacks;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Session {

    private String username;
    private LocalDateTime createdAt; // guardamos el momento de creación

    public Session(String username) {
        this.username = username;
        this.createdAt = LocalDateTime.now(); // se registra cuando se crea
    }

    @Override
    public String toString() {

        LocalDateTime ahora = LocalDateTime.now();
        // Definir formato: yyyy-MM-dd HH:mm:ss
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        // Tomar la fecha y hora formateada
        String fechaFormateada = ahora.format(formatter);

        // Extraer los segundos de ese instante
        int segundos = ahora.getSecond();

        return "Session{" +
                "sessionId=" + this.hashCode() +
                ", createdAt=" + fechaFormateada + " (" + segundos + " segundos)" +
                ", username='" + username + '\'' +
                '}';
    }
}

package ThreadsConcurrencia.miniCurso.I_ClaseThreadInterfaceRunnable;

public class SessionThread extends Thread {

    private SessionService sessionService;
    private String username;

    public SessionThread(String name, String username) {
        super(name); // Llamada al constructor de la clase Thread
        this.username = username;
        this.sessionService = new SessionService();
    }

    @Override
    public void run() {
        System.out.println("Run in thread: " + Thread.currentThread().getName());
        this.sessionService.startSession(username); // se le pasa el nombre de usuario por parametro que viene del constructor
        // Obtener el nombre del hilo actual
    }
}
